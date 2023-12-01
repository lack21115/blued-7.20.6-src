package com.bumptech.glide.load;

import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/Option.class */
public final class Option<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final CacheKeyUpdater<Object> f20707a = new CacheKeyUpdater<Object>() { // from class: com.bumptech.glide.load.Option.1
        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        public void update(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    };
    private final T b;

    /* renamed from: c  reason: collision with root package name */
    private final CacheKeyUpdater<T> f20708c;
    private final String d;
    private volatile byte[] e;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/Option$CacheKeyUpdater.class */
    public interface CacheKeyUpdater<T> {
        void update(byte[] bArr, T t, MessageDigest messageDigest);
    }

    private Option(String str, T t, CacheKeyUpdater<T> cacheKeyUpdater) {
        this.d = Preconditions.a(str);
        this.b = t;
        this.f20708c = (CacheKeyUpdater) Preconditions.a(cacheKeyUpdater);
    }

    public static <T> Option<T> a(String str) {
        return new Option<>(str, null, c());
    }

    public static <T> Option<T> a(String str, T t) {
        return new Option<>(str, t, c());
    }

    public static <T> Option<T> a(String str, T t, CacheKeyUpdater<T> cacheKeyUpdater) {
        return new Option<>(str, t, cacheKeyUpdater);
    }

    private byte[] b() {
        if (this.e == null) {
            this.e = this.d.getBytes(Key.f20706a);
        }
        return this.e;
    }

    private static <T> CacheKeyUpdater<T> c() {
        return (CacheKeyUpdater<T>) f20707a;
    }

    public T a() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Option) {
            return this.d.equals(((Option) obj).d);
        }
        return false;
    }

    public int hashCode() {
        return this.d.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.d + "'}";
    }

    public void update(T t, MessageDigest messageDigest) {
        this.f20708c.update(b(), t, messageDigest);
    }
}
