package com.example.yukai.mydefinedview.ExampleTest.AsyncTaskTest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class MyAsyncTask extends AsyncTask<TaskParamsModel, Integer, Bitmap>{

    private IOnDownloadListener mListener;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.e("yk", "onPreExecute");
    }

    @Override
    protected Bitmap doInBackground(TaskParamsModel... taskParamsModels) {
        Log.e("yk", "doInBackground");
        TaskParamsModel model = taskParamsModels[0];
        String url = model.url;
        Bitmap bitmap = null;
        URLConnection connection ;
        InputStream is ;
        try {
            connection = new URL(url).openConnection();
            is = connection.getInputStream();
            //为了更清楚的看到加载图片的等待操作,将线程休眠3秒钟.
            Thread.sleep(3000);
            BufferedInputStream bis = new BufferedInputStream(is);
            //通过decodeStream方法解析输入流
            bitmap = BitmapFactory.decodeStream(bis);
            is.close();
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        Log.e("yk", "onProgressUpdate");
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        Log.e("yk", "onPostExecute");
        super.onPostExecute(bitmap);
        if (mListener != null){
            mListener.onSuccess(bitmap);
        }
    }

    public void setListener(IOnDownloadListener listener){
        mListener = listener;
    }

    public interface IOnDownloadListener{
        void onSuccess(Bitmap bitmap);
    }

}
