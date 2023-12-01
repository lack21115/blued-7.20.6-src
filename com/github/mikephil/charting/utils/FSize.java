package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/utils/FSize.class */
public final class FSize extends ObjectPool.Poolable {

    /* renamed from: c  reason: collision with root package name */
    private static ObjectPool<FSize> f22199c;

    /* renamed from: a  reason: collision with root package name */
    public float f22200a;
    public float b;

    static {
        ObjectPool<FSize> a2 = ObjectPool.a(256, new FSize(0.0f, 0.0f));
        f22199c = a2;
        a2.a(0.5f);
    }

    public FSize() {
    }

    public FSize(float f, float f2) {
        this.f22200a = f;
        this.b = f2;
    }

    public static FSize a(float f, float f2) {
        FSize a2 = f22199c.a();
        a2.f22200a = f;
        a2.b = f2;
        return a2;
    }

    public static void a(FSize fSize) {
        f22199c.a((ObjectPool<FSize>) fSize);
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
            if (this.f22200a == fSize.f22200a) {
                z = false;
                if (this.b == fSize.b) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f22200a) ^ Float.floatToIntBits(this.b);
    }

    public String toString() {
        return this.f22200a + "x" + this.b;
    }
}
