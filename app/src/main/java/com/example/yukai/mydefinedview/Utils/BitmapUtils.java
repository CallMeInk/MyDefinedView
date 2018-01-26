package com.example.yukai.mydefinedview.Utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by yukai on 2018/1/25.
 */

public class BitmapUtils {

    public static Bitmap cutBitMap(Bitmap bitmap){

        if (bitmap == null){
            return null;
        }

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int d = (int) Math.max(width, height);
        int radius = d / 2;
        Bitmap resultBitmap = Bitmap.createBitmap(d, d, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(resultBitmap);
        int color = bitmap.getPixel(1, 1);
        Paint paint = new Paint();
        if (width > height){
            paint.setColor(color);
            Rect rect1 = new Rect(0, 0, width, radius - height / 2);
            canvas.drawRect(rect1, paint);
            Rect srcRect = new Rect(0, 0, width, height);
            Rect dstRect = new Rect(0, radius - height / 2, width, radius + height / 2);
            canvas.drawBitmap(bitmap, srcRect, dstRect, null);
            Rect rect2 = new Rect(0, radius + height / 2, d, d);
            canvas.drawRect(rect2, paint);
        }else{
            paint.setColor(color);
            Rect rect1 = new Rect(0, 0, radius - width / 2, d);
            canvas.drawRect(rect1, paint);
            Rect srcRect = new Rect(0, 0, width, height);
            Rect dstRect = new Rect(radius - width / 2, 0, radius + width / 2, d);
            canvas.drawBitmap(bitmap, srcRect, dstRect, null);
            Rect rect2 = new Rect(radius + width / 2, 0, d, d);
            canvas.drawRect(rect2, paint);
        }



        return resultBitmap;
    }

    public static Bitmap getRoundBitmap(Bitmap bitmap){
        if (bitmap == null){
            return null;
        }
        int d = bitmap.getWidth();
        int radius = d / 2;
        Bitmap resultBitMap = Bitmap.createBitmap(d, d, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(resultBitMap);
        Paint paint = new Paint();
        Rect roundSrc = new Rect(0, 0, d, d);
        Rect roundDst = new Rect(0, 0, d, d);
        RectF rectF = new RectF(roundDst);
        paint.setAntiAlias(true);

        canvas.drawARGB(0, 0, 0, 0);
        int color = 0xff424242;
        paint.setColor(color);

        canvas.drawRoundRect(rectF, radius, radius, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, roundSrc, roundDst, paint);
        return resultBitMap;
    }

}
