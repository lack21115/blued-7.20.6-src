package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/utils/FSize.class */
public final class FSize extends ObjectPool.Poolable {

    /* renamed from: c  reason: collision with root package name */
    private static ObjectPool<FSize> f8592c;

    /* renamed from: a  reason: collision with root package name */
    public float f8593a;
    public float b;

    static {
        ObjectPool<FSize> a2 = ObjectPool.a(256, new FSize(0.0f, 0.0f));
        f8592c = a2;
        a2.a(0.5f);
    }

    public FSize() {
    }

    public FSize(float f, float f2) {
        this.f8593a = f;
        this.b = f2;
    }

    public static FSize a(float f, float f2) {
        FSize a2 = f8592c.a();
        a2.f8593a = f;
        a2.b = f2;
        return a2;
    }

    public static void a(FSize fSize) {
        f8592c.a((ObjectPool<FSize>) fSize);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable b() {
        return new FSize(0.0f, 0.0f);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        boolean z = false;
        if (obj instanceof FSize) {
            FSize fSize = (FSize) obj;
            z = false;
            if (this.f8593a == fSize.f8593a) {
                z = false;
                if (this.b == fSize.b) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f8593a) ^ Float.floatToIntBits(this.b);
    }

    public String toString() {
        return this.f8593a + "x" + this.b;
    }
}
