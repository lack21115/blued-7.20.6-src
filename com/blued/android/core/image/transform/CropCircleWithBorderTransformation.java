package com.blued.android.core.image.transform;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import java.security.MessageDigest;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/transform/CropCircleWithBorderTransformation.class */
public class CropCircleWithBorderTransformation extends BitmapTransformation {
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f9564c;

    public CropCircleWithBorderTransformation() {
        this.b = ((int) Resources.getSystem().getDisplayMetrics().density) * 4;
        this.f9564c = -16777216;
    }

    public CropCircleWithBorderTransformation(int i, int i2) {
        this.b = i;
        this.f9564c = i2;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap a(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        Bitmap d = TransformationUtils.d(bitmapPool, bitmap, i, i2);
        d.setDensity(bitmap.getDensity());
        Paint paint = new Paint();
        paint.setColor(this.f9564c);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.b);
        paint.setAntiAlias(true);
        new Canvas(d).drawCircle(i / 2.0f, i2 / 2.0f, ((Math.max(i, i2) - this.b) + 0.8f) / 2.0f, paint);
        return d;
    }

    @Override // com.bumptech.glide.load.Key
    public void a(MessageDigest messageDigest) {
        messageDigest.update(("com.blued.android.core.transform.CropCircleWithBorderTransformation.1" + this.b + this.f9564c).getBytes(f20706a));
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof CropCircleWithBorderTransformation) {
            CropCircleWithBorderTransformation cropCircleWithBorderTransformation = (CropCircleWithBorderTransformation) obj;
            return cropCircleWithBorderTransformation.b == this.b && cropCircleWithBorderTransformation.f9564c == this.f9564c;
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return (-548187489) + (this.b * 100) + this.f9564c + 10;
    }
}
