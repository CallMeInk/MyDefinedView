package com.example.yukai.mydefinedview.review.Camera;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.yukai.mydefinedview.R;

import java.io.IOException;
import java.util.List;

public class CameraActivity extends AppCompatActivity implements SurfaceHolder.Callback{

    private SurfaceView surfaceView;
    private SurfaceHolder holder;
    private Camera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        surfaceView = (SurfaceView) findViewById(R.id.camera_surface_view);
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) surfaceView.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = width * 16 / 9;
        surfaceView.setLayoutParams(layoutParams);
        holder = surfaceView.getHolder();
        holder.addCallback(this);
        doCameraThings();
    }

    private void doCameraThings(){
        if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)){
            Log.e("yk", "has camera");
        }else{
            Log.e("yk", "no camera");
        }

        int cameraCount = Camera.getNumberOfCameras();
        int frontCameraId = -1;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i = 0; i < cameraCount; i++){
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT){
                frontCameraId = i;
                break;
            }
        }

        camera = Camera.open(frontCameraId);
        Camera.Parameters cp = camera.getParameters();

        //相机角度设置
        Camera.CameraInfo info = new Camera.CameraInfo();
        Camera.getCameraInfo(frontCameraId, info);
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        int degrees = 0;
        switch (rotation) {
            case Surface.ROTATION_0:
                degrees = 0;
                break;
            case Surface.ROTATION_90:
                degrees = 90;
                break;
            case Surface.ROTATION_180:
                degrees = 180;
                break;
            case Surface.ROTATION_270:
                degrees = 270;
                break;
        }

        int result;
        if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
            result = (info.orientation + degrees) % 360;
            result = (360 - result) % 360;
        } else {
            result = (info.orientation - degrees + 360) % 360;
        }

        camera.setDisplayOrientation(result);

        //摄像头预览的size 这边用720*1280
        List<Camera.Size> sizes = cp.getSupportedPreviewSizes();
        for (int i = 0; i < sizes.size();i++){
            if (sizes.get(i).height * sizes.get(i).width ==
                    720 * 1280){
                cp.setPreviewSize(sizes.get(i).width, sizes.get(i).height);
            }
        }

        camera.setParameters(cp);

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        this.holder = holder;
        try {
            camera.setPreviewDisplay(holder);
            camera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        this.holder = holder;
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
