package com.blued.android.core.image.transform;

import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.security.MessageDigest;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/transform/CropSquareWithRateTransformation.class */
public class CropSquareWithRateTransformation extends BitmapTransformation {
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private float f9566c;

    public CropSquareWithRateTransformation(float f, float f2) {
        this.b = f;
        this.f9566c = f2;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x016a  */
    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Bitmap a(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r9, android.graphics.Bitmap r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.core.image.transform.CropSquareWithRateTransformation.a(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool, android.graphics.Bitmap, int, int):android.graphics.Bitmap");
    }

    @Override // com.bumptech.glide.load.Key
    public void a(MessageDigest messageDigest) {
        messageDigest.update(("com.blued.android.core.transform.CropSquareWithRateTransformation.1" + this.b + this.f9566c).getBytes(f20706a));
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof CropSquareWithRateTransformation) {
            CropSquareWithRateTransformation cropSquareWithRateTransformation = (CropSquareWithRateTransformation) obj;
            return cropSquareWithRateTransformation.b == this.b && cropSquareWithRateTransformation.f9566c == this.f9566c;
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return (int) ((-515355040) + (this.b * 1000.0f) + (this.f9566c * 10.0f));
    }

    public String toString() {
        return "CropSquareWithRateTransformation(rateX=" + this.b + ", rateY=" + this.f9566c + ")";
    }
}
