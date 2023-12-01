package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/DataCacheKey.class */
final class DataCacheKey implements Key {
    private final Key b;

    /* renamed from: c  reason: collision with root package name */
    private final Key f7136c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataCacheKey(Key key, Key key2) {
        this.b = key;
        this.f7136c = key2;
    }

    @Override // com.bumptech.glide.load.Key
    public void a(MessageDigest messageDigest) {
        this.b.a(messageDigest);
        this.f7136c.a(messageDigest);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof DataCacheKey) {
            DataCacheKey dataCacheKey = (DataCacheKey) obj;
            z = false;
            if (this.b.equals(dataCacheKey.b)) {
                z = false;
                if (this.f7136c.equals(dataCacheKey.f7136c)) {
                    z = true;
                }
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return (this.b.hashCode() * 31) + this.f7136c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.b + ", signature=" + this.f7136c + '}';
    }
}
