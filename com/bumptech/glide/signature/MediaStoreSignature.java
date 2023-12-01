package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/signature/MediaStoreSignature.class */
public class MediaStoreSignature implements Key {
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final long f7486c;
    private final int d;

    @Override // com.bumptech.glide.load.Key
    public void a(MessageDigest messageDigest) {
        messageDigest.update(ByteBuffer.allocate(12).putLong(this.f7486c).putInt(this.d).array());
        messageDigest.update(this.b.getBytes(f7100a));
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MediaStoreSignature mediaStoreSignature = (MediaStoreSignature) obj;
        return this.f7486c == mediaStoreSignature.f7486c && this.d == mediaStoreSignature.d && this.b.equals(mediaStoreSignature.b);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        int hashCode = this.b.hashCode();
        long j = this.f7486c;
        return (((hashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.d;
    }
}
