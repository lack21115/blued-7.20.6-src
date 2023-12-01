package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/EngineKey.class */
public class EngineKey implements Key {
    private final Object b;

    /* renamed from: c  reason: collision with root package name */
    private final int f20781c;
    private final int d;
    private final Class<?> e;
    private final Class<?> f;
    private final Key g;
    private final Map<Class<?>, Transformation<?>> h;
    private final Options i;
    private int j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EngineKey(Object obj, Key key, int i, int i2, Map<Class<?>, Transformation<?>> map, Class<?> cls, Class<?> cls2, Options options) {
        this.b = Preconditions.a(obj);
        this.g = (Key) Preconditions.a(key, "Signature must not be null");
        this.f20781c = i;
        this.d = i2;
        this.h = (Map) Preconditions.a(map);
        this.e = (Class) Preconditions.a(cls, "Resource class must not be null");
        this.f = (Class) Preconditions.a(cls2, "Transcode class must not be null");
        this.i = (Options) Preconditions.a(options);
    }

    @Override // com.bumptech.glide.load.Key
    public void a(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof EngineKey) {
            EngineKey engineKey = (EngineKey) obj;
            z = false;
            if (this.b.equals(engineKey.b)) {
                z = false;
                if (this.g.equals(engineKey.g)) {
                    z = false;
                    if (this.d == engineKey.d) {
                        z = false;
                        if (this.f20781c == engineKey.f20781c) {
                            z = false;
                            if (this.h.equals(engineKey.h)) {
                                z = false;
                                if (this.e.equals(engineKey.e)) {
                                    z = false;
                                    if (this.f.equals(engineKey.f)) {
                                        z = false;
                                        if (this.i.equals(engineKey.i)) {
                                            z = true;
                                        }
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
        if (this.j == 0) {
            int hashCode = this.b.hashCode();
            this.j = hashCode;
            int hashCode2 = (hashCode * 31) + this.g.hashCode();
            this.j = hashCode2;
            int i = (hashCode2 * 31) + this.f20781c;
            this.j = i;
            int i2 = (i * 31) + this.d;
            this.j = i2;
            int hashCode3 = (i2 * 31) + this.h.hashCode();
            this.j = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.e.hashCode();
            this.j = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f.hashCode();
            this.j = hashCode5;
            this.j = (hashCode5 * 31) + this.i.hashCode();
        }
        return this.j;
    }

    public String toString() {
        return "EngineKey{model=" + this.b + ", width=" + this.f20781c + ", height=" + this.d + ", resourceClass=" + this.e + ", transcodeClass=" + this.f + ", signature=" + this.g + ", hashCode=" + this.j + ", transformations=" + this.h + ", options=" + this.i + '}';
    }
}
