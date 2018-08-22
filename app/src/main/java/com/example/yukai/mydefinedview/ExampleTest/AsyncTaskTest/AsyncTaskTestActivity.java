package com.example.yukai.mydefinedview.ExampleTest.AsyncTaskTest;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.yukai.mydefinedview.ConstantKt;
import com.example.yukai.mydefinedview.R;

public class AsyncTaskTestActivity extends Activity{

    private ImageView mImageView;
    private TaskParamsModel mTaskParamsModel = new TaskParamsModel();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asynctask_test_activity_layout);
        mImageView = (ImageView) findViewById(R.id.asynctask_iv);
        Button button = (Button) findViewById(R.id.asynctask_start_button);
        mTaskParamsModel.imageView = mImageView;
        mTaskParamsModel.url = ConstantKt.getImageUrl();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAsyncTask task = new MyAsyncTask();
                task.setListener(new MyAsyncTask.IOnDownloadListener() {
                    @Override
                    public void onSuccess(Bitmap bitmap) {
                        mImageView.setImageBitmap(bitmap);
                    }
                });
                task.execute(mTaskParamsModel);
            }
        });
    }
}
