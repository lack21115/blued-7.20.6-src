package com.blued.android.core.image.transform;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/transform/TransformUtils.class */
public class TransformUtils {
    public static Bitmap.Config a(Bitmap bitmap) {
        return (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGBA_F16;
    }

    public static Bitmap a(BitmapPool bitmapPool, Bitmap bitmap) {
        Bitmap.Config a2 = a(bitmap);
        if (a2.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap a3 = bitmapPool.a(bitmap.getWidth(), bitmap.getHeight(), a2);
        new Canvas(a3).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return a3;
    }

    public static void a(Canvas canvas) {
        canvas.setBitmap(null);
    }
}
