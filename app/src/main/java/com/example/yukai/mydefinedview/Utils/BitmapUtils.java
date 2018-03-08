package com.example.yukai.mydefinedview.Utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.Log;

import java.io.FileDescriptor;

/**
 * Created by yukai on 2018/1/25.
 */

public class BitmapUtils {

    private static final int sPixelToDp = 3;
    private static final int sBorderWidth = 6;

    public static Bitmap cutBitMap(Bitmap bitmap){
        if (bitmap == null){
            return null;
        }

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int d = (int) Math.sqrt(width * width + height * height) + 2 * 2 * sPixelToDp;
        int radius = d / 2;
        Bitmap resultBitmap = Bitmap.createBitmap(d, d, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(resultBitmap);
        int color = bitmap.getPixel(0, 0);
        Paint paint = new Paint();
        paint.setAntiAlias(true);

        paint.setColor(color);
        Rect rect1 = new Rect(0, 0, d, d);
        canvas.drawRect(rect1, paint);
        paint.setColor(color);
        canvas.drawCircle(radius, radius, radius - 1 * sPixelToDp, paint);

        Rect srcRect = new Rect(0, 0, width, height);
        Rect dstRect = new Rect(radius - width / 2, radius - height / 2, radius + width / 2, radius + height / 2);
        canvas.drawBitmap(bitmap, srcRect, dstRect, null);

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

    public static Bitmap addBitmapShadow(Bitmap bitmap){
        if (bitmap == null){
            return null;
        }


        int d = bitmap.getWidth();
        Bitmap resultBitMap = Bitmap.createBitmap(d + 15, d + 15, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(resultBitMap);

        Paint paint = new Paint();
        paint.setAntiAlias(true);

        Paint paintBorder = new Paint();
        paintBorder.setColor(Color.parseColor("#ffffff"));
        paintBorder.setAntiAlias(true);
        paintBorder.setShadowLayer(sBorderWidth, 2, 4, Color.parseColor("#44666666"));

        BitmapShader shader = new BitmapShader(Bitmap.createScaledBitmap(bitmap, canvas.getWidth(), canvas.getHeight(), false), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(shader);
        int circleCenter = d / 2;
        canvas.drawCircle(circleCenter + 4, circleCenter + 4, circleCenter, paintBorder);
        canvas.drawCircle(circleCenter + 4, circleCenter + 4, circleCenter - 4, paint);

        return resultBitMap;
    }

    public static Bitmap decodeSampleBitmapFromResource(Resources resources, int resId, int requiredWidth, int requiredHeight){
        //first decode with inJustDecodeBounds=true to check dimensions
        //inJustDecodeBounds=true 解析图片时只会解析道原始宽高信息，并不会真正加载图片
        final BitmapFactory.Options options = new BitmapFactory.Options();
        // it's important
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, resId, options);

        //calculate inSampleSize
        options.inSampleSize =calculateInSampleSize(options, requiredWidth, requiredHeight);
        Log.e("yk", "inSampleSize::" + options.inSampleSize);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, resId, options);
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int requredWidth, int requiredHeight){
        final int height = options.outHeight;
        final int width = options.outWidth;

        int inSampleSize = 1;
        if (height > requiredHeight || width > requredWidth){
            final int halfHeight = height >> 1;
            final int halfWidth = width >> 1;
            while(((halfHeight / inSampleSize) >= requiredHeight || (halfWidth / inSampleSize) >= requredWidth) &&
                    requiredHeight * requredWidth != 0){
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromFileDescriptor(FileDescriptor fd, int requiredWidth, int requiredHeight){
        //first decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fd, null, options);
        options.inSampleSize = calculateInSampleSize(options, requiredWidth, requiredHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFileDescriptor(fd, null, options);
    }


}
