package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/GranularRoundedCorners.class */
public final class GranularRoundedCorners extends BitmapTransformation {
    private static final byte[] b = "com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners".getBytes(f20706a);

    /* renamed from: c  reason: collision with root package name */
    private final float f20955c;
    private final float d;
    private final float e;
    private final float f;

    public GranularRoundedCorners(float f, float f2, float f3, float f4) {
        this.f20955c = f;
        this.d = f2;
        this.e = f3;
        this.f = f4;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap a(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        return TransformationUtils.a(bitmapPool, bitmap, this.f20955c, this.d, this.e, this.f);
    }

    @Override // com.bumptech.glide.load.Key
    public void a(MessageDigest messageDigest) {
        messageDigest.update(b);
        messageDigest.update(ByteBuffer.allocate(16).putFloat(this.f20955c).putFloat(this.d).putFloat(this.e).putFloat(this.f).array());
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof GranularRoundedCorners) {
            GranularRoundedCorners granularRoundedCorners = (GranularRoundedCorners) obj;
            z = false;
            if (this.f20955c == granularRoundedCorners.f20955c) {
                z = false;
                if (this.d == granularRoundedCorners.d) {
                    z = false;
                    if (this.e == granularRoundedCorners.e) {
                        z = false;
                        if (this.f == granularRoundedCorners.f) {
                            z = true;
                        }
                    }
                }
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.a(this.f, Util.a(this.e, Util.a(this.d, Util.b(-2013597734, Util.a(this.f20955c)))));
    }
}
