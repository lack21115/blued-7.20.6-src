package com.blued.android.core.image.transform;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.blued.android.core.image.util.FastBlur;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.security.MessageDigest;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/transform/BlurTransformation.class */
public class BlurTransformation extends BitmapTransformation {
    private static int b = 25;
    private static int c = 1;
    private int d;
    private int e;

    public BlurTransformation() {
        this(b, c);
    }

    public BlurTransformation(int i) {
        this(i, c);
    }

    public BlurTransformation(int i, int i2) {
        this.d = i;
        this.e = i2;
    }

    public Bitmap a(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i3 = this.e;
        Bitmap a = bitmapPool.a(width / i3, height / i3, Bitmap.Config.ARGB_8888);
        a.setDensity(bitmap.getDensity());
        Canvas canvas = new Canvas(a);
        int i4 = this.e;
        canvas.scale(1.0f / i4, 1.0f / i4);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return FastBlur.a(a, this.d, true);
    }

    public void a(MessageDigest messageDigest) {
        messageDigest.update(("com.blued.android.core.transform.BlurTransformation.1" + this.d + this.e).getBytes(a));
    }

    public boolean equals(Object obj) {
        if (obj instanceof BlurTransformation) {
            BlurTransformation blurTransformation = (BlurTransformation) obj;
            return blurTransformation.d == this.d && blurTransformation.e == this.e;
        }
        return false;
    }

    public int hashCode() {
        return 1907786452 + (this.d * 1000) + (this.e * 10);
    }

    public String toString() {
        return "BlurTransformation(radius=" + this.d + ", sampling=" + this.e + ")";
    }
}
