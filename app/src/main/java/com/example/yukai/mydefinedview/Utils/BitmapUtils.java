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

    private static final int sPixelToDp = 3;

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
        paint.setColor(Color.parseColor("#ff0000"));
        canvas.drawCircle(radius, radius, radius + 1 * sPixelToDp, paint);
        paint.setColor(color);
        canvas.drawCircle(radius, radius, radius - 1 * sPixelToDp, paint);

//        int z = 10;
//        int startShadowColor = 0x00999999;
//        int endShadowColor = 0x66999999;
//        int step = 255 / z;
//
//        for (int i = z; i > 0; i--) {
//            int shadowColor = getInterpolationColor(startShadowColor, endShadowColor, step * (z - i));
//            paint.setColor(shadowColor);
//            canvas.drawCircle(radius + i, radius + i, radius, paint);
//        }



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

    protected static int getInterpolationColor(int c1, int c2, int ratio) {

        ratio = ratio < 0 ? 0 : ratio;
        ratio = ratio > 255 ? 255 : ratio;

        int r1 = Color.red(c1);
        int g1 = Color.green(c1);
        int b1 = Color.blue(c1);
        int a1 = Color.alpha(c1);

        int r2 = Color.red(c2);
        int g2 = Color.green(c2);
        int b2 = Color.blue(c2);
        int a2 = Color.alpha(c2);

        int r = (r1 * (255 - ratio) + r2 * ratio) >> 8;
        int g = (g1 * (255 - ratio) + g2 * ratio) >> 8;
        int b = (b1 * (255 - ratio) + b2 * ratio) >> 8;
        int a = (a1 * (255 - ratio) + a2 * ratio) >> 8;

        return Color.argb(a, r, g, b);
    }

}
