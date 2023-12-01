package com.blued.android.core.image.transform;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import java.security.MessageDigest;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/transform/NinePatchTransformation.class */
public class NinePatchTransformation extends BitmapTransformation {
    private static float b = Resources.getSystem().getDisplayMetrics().density;

    public Bitmap a(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        int min = Math.min(i, i2);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = min;
        float max = Math.max(f / width, f / height);
        if (width == i || height == i2) {
            max = 1.0f;
        } else {
            float f2 = b / 2.0f;
            if (f2 <= max) {
                max = f2;
            }
        }
        Point point = new Point((width - 2) >> 1, (height - 2) >> 1);
        int i3 = (int) (point.x * max);
        int i4 = (int) (point.y * max);
        Rect rect = new Rect(i3, i4, i - i3, i2 - i4);
        Bitmap a = TransformUtils.a(bitmapPool, bitmap);
        Bitmap a2 = bitmapPool.a(i, i2, TransformUtils.a(bitmap));
        a2.setHasAlpha(true);
        TransformationUtils.a().lock();
        try {
            Canvas canvas = new Canvas(a2);
            canvas.drawBitmap(a, new Rect(point.x, 0, point.x + 1, point.y), new Rect(rect.left, 0, rect.right, rect.top), (Paint) null);
            canvas.drawBitmap(a, new Rect(0, point.y, point.x, point.y + 1), new Rect(0, rect.top, rect.left, rect.bottom), (Paint) null);
            canvas.drawBitmap(a, new Rect(point.x + 1, point.y, width, point.y + 1), new Rect(rect.right, rect.top, i, rect.bottom), (Paint) null);
            canvas.drawBitmap(a, new Rect(point.x, point.y + 1, point.x + 1, height), new Rect(rect.left, rect.bottom, rect.right, i2), (Paint) null);
            canvas.drawBitmap(a, new Rect(0, 0, point.x, point.y), new Rect(0, 0, rect.left, rect.top), (Paint) null);
            canvas.drawBitmap(a, new Rect(point.x + 1, 0, width, point.y), new Rect(rect.right, 0, i, rect.top), (Paint) null);
            canvas.drawBitmap(a, new Rect(0, point.y + 1, point.x, height), new Rect(0, rect.bottom, rect.left, i2), (Paint) null);
            canvas.drawBitmap(a, new Rect(point.x + 1, point.y + 1, width, height), new Rect(rect.right, rect.bottom, i, i2), (Paint) null);
            canvas.drawBitmap(a, new Rect(point.x, point.y, point.x + 1, point.y + 1), new Rect(rect.left, rect.top, rect.right, rect.bottom), (Paint) null);
            canvas.setBitmap(null);
            TransformationUtils.a().unlock();
            if (!a.equals(bitmap)) {
                bitmapPool.a(a);
            }
            return a2;
        } catch (Throwable th) {
            TransformationUtils.a().unlock();
            throw th;
        }
    }

    public void a(MessageDigest messageDigest) {
        messageDigest.update("com.blued.android.core.transform.NinePatchTransformation.1".getBytes(a));
    }

    public boolean equals(Object obj) {
        return obj instanceof NinePatchTransformation;
    }

    public int hashCode() {
        return 784365633;
    }

    public String toString() {
        return "NinePatchTransformation()";
    }
}
