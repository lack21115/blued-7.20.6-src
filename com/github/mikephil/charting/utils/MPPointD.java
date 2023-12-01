package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/utils/MPPointD.class */
public class MPPointD extends ObjectPool.Poolable {

    /* renamed from: c  reason: collision with root package name */
    private static ObjectPool<MPPointD> f8594c;

    /* renamed from: a  reason: collision with root package name */
    public double f8595a;
    public double b;

    static {
        ObjectPool<MPPointD> a2 = ObjectPool.a(64, new MPPointD(0.0d, 0.0d));
        f8594c = a2;
        a2.a(0.5f);
    }

    private MPPointD(double d, double d2) {
        this.f8595a = d;
        this.b = d2;
    }

    public static MPPointD a(double d, double d2) {
        MPPointD a2 = f8594c.a();
        a2.f8595a = d;
        a2.b = d2;
        return a2;
    }

    public static void a(MPPointD mPPointD) {
        f8594c.a((ObjectPool<MPPointD>) mPPointD);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable b() {
        return new MPPointD(0.0d, 0.0d);
    }

    public String toString() {
        return "MPPointD, x: " + this.f8595a + ", y: " + this.b;
    }
}
