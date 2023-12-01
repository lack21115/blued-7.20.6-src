package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/Rotate.class */
public class Rotate extends BitmapTransformation {
    private static final byte[] b = "com.bumptech.glide.load.resource.bitmap.Rotate".getBytes(f7100a);

    /* renamed from: c  reason: collision with root package name */
    private final int f7362c;

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap a(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        return TransformationUtils.a(bitmap, this.f7362c);
    }

    @Override // com.bumptech.glide.load.Key
    public void a(MessageDigest messageDigest) {
        messageDigest.update(b);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f7362c).array());
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof Rotate) {
            z = false;
            if (this.f7362c == ((Rotate) obj).f7362c) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.b(-950519196, Util.b(this.f7362c));
    }
}
