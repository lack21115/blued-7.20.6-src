package com.blued.android.core.image.transform;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import java.security.MessageDigest;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/transform/CropCircleWithBorderTransformation.class */
public class CropCircleWithBorderTransformation extends BitmapTransformation {
    private int b;
    private int c;

    public CropCircleWithBorderTransformation() {
        this.b = ((int) Resources.getSystem().getDisplayMetrics().density) * 4;
        this.c = View.MEASURED_STATE_MASK;
    }

    public CropCircleWithBorderTransformation(int i, int i2) {
        this.b = i;
        this.c = i2;
    }

    public Bitmap a(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        Bitmap d = TransformationUtils.d(bitmapPool, bitmap, i, i2);
        d.setDensity(bitmap.getDensity());
        Paint paint = new Paint();
        paint.setColor(this.c);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.b);
        paint.setAntiAlias(true);
        new Canvas(d).drawCircle(i / 2.0f, i2 / 2.0f, ((Math.max(i, i2) - this.b) + 0.8f) / 2.0f, paint);
        return d;
    }

    public void a(MessageDigest messageDigest) {
        messageDigest.update(("com.blued.android.core.transform.CropCircleWithBorderTransformation.1" + this.b + this.c).getBytes(a));
    }

    public boolean equals(Object obj) {
        if (obj instanceof CropCircleWithBorderTransformation) {
            CropCircleWithBorderTransformation cropCircleWithBorderTransformation = (CropCircleWithBorderTransformation) obj;
            return cropCircleWithBorderTransformation.b == this.b && cropCircleWithBorderTransformation.c == this.c;
        }
        return false;
    }

    public int hashCode() {
        return (-548187489) + (this.b * 100) + this.c + 10;
    }
}
