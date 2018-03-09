package com.example.yukai.mydefinedview.ArtLearningNote.chapter13_1;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yukai on 2018/3/9.
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler{

    private static final String TAG = "CrashHandler";

    private static final boolean DEBUG = true;

    private static final String PATH = Environment.getExternalStorageDirectory().getPath() + "/CrashTest/log";

    private static final String FILE_NAME = "ykCrash";

    private static final String FILE_NAME_SUFFIX = ".txt";

    private static CrashHandler sInstance = new CrashHandler();

    private Thread.UncaughtExceptionHandler mDefaultCrashHandler;

    private Context mContext;

    private CrashHandler(){

    }

    public static CrashHandler getsInstance(){
        Log.e(TAG, "crash log path::" + PATH);
        return sInstance;
    }

    public void init(Context context){
        mDefaultCrashHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        mContext = context.getApplicationContext();
    }


    /***
     * 程序有未被捕获的异常，系统调用该方法
     * @param t 未捕获异常线程
     * @param e 异常
     */
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Log.e(TAG, "CrashHandler::uncaughtException");
        try{
            dumpExceptionToSdcard(e);
        }catch (Exception e1){

        }
    }

    private void dumpExceptionToSdcard(Throwable e) throws IOException{
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            if (DEBUG){
                Log.e(TAG, "sdCardUnMounted, skip dump exception");
                return;
            }
        }

        File dir = new File(PATH);
        if (!dir.exists()){
            boolean reslut = dir.mkdirs();
            Log.e(TAG, "make dirs result::" + reslut);
        }

        long current = System.currentTimeMillis();
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(current));
        File file = new File(PATH + FILE_NAME + time + FILE_NAME_SUFFIX);

        try {
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            printWriter.println(time);
            dumpPhoneInfo(printWriter);
            printWriter.println();
            e.printStackTrace(printWriter);
            printWriter.close();
        }catch (Exception e1){
            Log.e(TAG, "dump crash info failed!!");
        }
    }

    private void dumpPhoneInfo(PrintWriter printWriter) throws PackageManager.NameNotFoundException{
        PackageManager pm = mContext.getPackageManager();
        PackageInfo pi = pm.getPackageInfo(mContext.getPackageName(), PackageManager.GET_ACTIVITIES);
        printWriter.print("App Version: ");
        printWriter.print(pi.versionName);
        printWriter.print("_");
        printWriter.println(pi.versionCode);

        //Android version
        printWriter.print("Device OS Version : ");
        printWriter.print(Build.VERSION.RELEASE);
        printWriter.print("_");
        printWriter.println(Build.VERSION.SDK_INT);

        //制造商
        printWriter.print("Vendor: ");
        printWriter.println(Build.MANUFACTURER);

        //手机型号
        printWriter.print("Model: ");
        printWriter.println(Build.MODEL);

        //CPU 架构
        printWriter.print("CPU ABI: ");
        printWriter.println(Build.CPU_ABI);

    }

}
