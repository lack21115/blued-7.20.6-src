package com.amap.api.col.p0003sl;

/* renamed from: com.amap.api.col.3sl.mo  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/mo.class */
public class mo {

    /* renamed from: a  reason: collision with root package name */
    public String f5385a;
    public long b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f5386c = 0;
    public double d = 0.0d;
    public double e = 0.0d;
    public double f = 0.0d;
    public float g = 0.0f;
    public float h = 0.0f;
    public float i = 0.0f;
    public boolean j = false;

    public mo(String str) {
        this.f5385a = str;
    }

    public final double a(mo moVar) {
        if (moVar != null) {
            return mz.a(this.e, this.d, moVar.e, moVar.d);
        }
        return 0.0d;
    }
}
