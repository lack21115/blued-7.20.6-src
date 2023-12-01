package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/CenterInside.class */
public class CenterInside extends BitmapTransformation {
    private static final byte[] b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(f7100a);

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap a(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        return TransformationUtils.c(bitmapPool, bitmap, i, i2);
    }

    @Override // com.bumptech.glide.load.Key
    public void a(MessageDigest messageDigest) {
        messageDigest.update(b);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return obj instanceof CenterInside;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return -670243078;
    }
}
