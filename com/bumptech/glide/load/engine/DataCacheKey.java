package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/DataCacheKey.class */
public final class DataCacheKey implements Key {
    private final Key b;

    /* renamed from: c  reason: collision with root package name */
    private final Key f20742c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataCacheKey(Key key, Key key2) {
        this.b = key;
        this.f20742c = key2;
    }

    @Override // com.bumptech.glide.load.Key
    public void a(MessageDigest messageDigest) {
        this.b.a(messageDigest);
        this.f20742c.a(messageDigest);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof DataCacheKey) {
            DataCacheKey dataCacheKey = (DataCacheKey) obj;
            z = false;
            if (this.b.equals(dataCacheKey.b)) {
                z = false;
                if (this.f20742c.equals(dataCacheKey.f20742c)) {
                    z = true;
                }
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return (this.b.hashCode() * 31) + this.f20742c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.b + ", signature=" + this.f20742c + '}';
    }
}
