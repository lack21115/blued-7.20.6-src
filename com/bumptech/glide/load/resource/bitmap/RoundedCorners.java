package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/RoundedCorners.class */
public final class RoundedCorners extends BitmapTransformation {
    private static final byte[] b = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(f20706a);

    /* renamed from: c  reason: collision with root package name */
    private final int f20969c;

    public RoundedCorners(int i) {
        Preconditions.a(i > 0, "roundingRadius must be greater than 0.");
        this.f20969c = i;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap a(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        return TransformationUtils.b(bitmapPool, bitmap, this.f20969c);
    }

    @Override // com.bumptech.glide.load.Key
    public void a(MessageDigest messageDigest) {
        messageDigest.update(b);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f20969c).array());
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof RoundedCorners) {
            z = false;
            if (this.f20969c == ((RoundedCorners) obj).f20969c) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.b(-569625254, Util.b(this.f20969c));
    }
}
