package com.example.yukai.mydefinedview.ArtLearningNote.chapter5_1;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.SystemClock;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.example.yukai.mydefinedview.R;

/**
 * Created by yukai on 2018/1/28.
 */

public class MyAppWidgetProvider extends AppWidgetProvider{

    public static final String TAG = "MyAppWidgetProvider";
    public static final String CLICK_ACTION = "com.example.yukai.mydefinedview.click";

    public MyAppWidgetProvider(){
        super();
    }


    //接受到任意广播触发，在onDeleted,onEnabled,onDisabled之前被调用
    @Override
    public void onReceive(final Context context, Intent intent) {
        super.onReceive(context, intent);
        Log.e(TAG, "onReceive::action = " + intent.getAction());
        if (intent.getAction() != null && intent.getAction().equals(CLICK_ACTION)){
            Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.hilton);
                    AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
                    for(int i = 0 ; i < 37 ; i++){
                        float degree = (i * 10) % 360;
                        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget);
                        remoteViews.setImageViewBitmap(R.id.image_view_1, rotateBitmap(context, bitmap, degree));
                        Intent intentClick = new Intent();
                        intentClick.setAction(CLICK_ACTION);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intentClick, 0);
                        remoteViews.setOnClickPendingIntent(R.id.image_view_1, pendingIntent);
                        appWidgetManager.updateAppWidget(new ComponentName(context, MyAppWidgetProvider.class), remoteViews);
                        SystemClock.sleep(30);
                    }
                }
            }).start();
        }
    }

    //每次桌面小部件更新时调用该方法
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        Log.e(TAG, "onUpdate");
        final int counter = appWidgetIds.length;
        for (int i = 0 ; i < counter ; i++){
            int appWidgetId = appWidgetIds[i];
            onWidgetUpdate(context, appWidgetManager, appWidgetId);
        }
    }

    private void onWidgetUpdate(Context context, AppWidgetManager appWidgetManager, int appWidgetId){
        Log.e(TAG, "appWidgetId = " + appWidgetId);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget);
        Intent intentClick = new Intent();
        intentClick.setAction(CLICK_ACTION);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intentClick, 0);
        remoteViews.setOnClickPendingIntent(R.id.image_view_1, pendingIntent);
        appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
    }

    private Bitmap rotateBitmap(Context context, Bitmap srcbBitmap, float degree){
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(degree);
        Bitmap tmpBitmap = Bitmap.createBitmap(srcbBitmap, 0, 0, srcbBitmap.getWidth(), srcbBitmap.getHeight(), matrix, true);
        return tmpBitmap;
    }

}
