package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/ResourceCacheKey.class */
public final class ResourceCacheKey implements Key {
    private static final LruCache<Class<?>, byte[]> b = new LruCache<>(50);

    /* renamed from: c  reason: collision with root package name */
    private final ArrayPool f7188c;
    private final Key d;
    private final Key e;
    private final int f;
    private final int g;
    private final Class<?> h;
    private final Options i;
    private final Transformation<?> j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResourceCacheKey(ArrayPool arrayPool, Key key, Key key2, int i, int i2, Transformation<?> transformation, Class<?> cls, Options options) {
        this.f7188c = arrayPool;
        this.d = key;
        this.e = key2;
        this.f = i;
        this.g = i2;
        this.j = transformation;
        this.h = cls;
        this.i = options;
    }

    private byte[] a() {
        byte[] b2 = b.b(this.h);
        byte[] bArr = b2;
        if (b2 == null) {
            bArr = this.h.getName().getBytes(f7100a);
            b.b(this.h, bArr);
        }
        return bArr;
    }

    @Override // com.bumptech.glide.load.Key
    public void a(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f7188c.b(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f).putInt(this.g).array();
        this.e.a(messageDigest);
        this.d.a(messageDigest);
        messageDigest.update(bArr);
        Transformation<?> transformation = this.j;
        if (transformation != null) {
            transformation.a(messageDigest);
        }
        this.i.a(messageDigest);
        messageDigest.update(a());
        this.f7188c.a((ArrayPool) bArr);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof ResourceCacheKey) {
            ResourceCacheKey resourceCacheKey = (ResourceCacheKey) obj;
            z = false;
            if (this.g == resourceCacheKey.g) {
                z = false;
                if (this.f == resourceCacheKey.f) {
                    z = false;
                    if (Util.a(this.j, resourceCacheKey.j)) {
                        z = false;
                        if (this.h.equals(resourceCacheKey.h)) {
                            z = false;
                            if (this.d.equals(resourceCacheKey.d)) {
                                z = false;
                                if (this.e.equals(resourceCacheKey.e)) {
                                    z = false;
                                    if (this.i.equals(resourceCacheKey.i)) {
                                        z = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        int hashCode = (((((this.d.hashCode() * 31) + this.e.hashCode()) * 31) + this.f) * 31) + this.g;
        Transformation<?> transformation = this.j;
        int i = hashCode;
        if (transformation != null) {
            i = (hashCode * 31) + transformation.hashCode();
        }
        return (((i * 31) + this.h.hashCode()) * 31) + this.i.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.d + ", signature=" + this.e + ", width=" + this.f + ", height=" + this.g + ", decodedResourceClass=" + this.h + ", transformation='" + this.j + "', options=" + this.i + '}';
    }
}
