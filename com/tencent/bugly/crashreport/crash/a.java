package com.tencent.bugly.crashreport.crash;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/crashreport/crash/a.class */
public final class a implements Comparable<a> {

    /* renamed from: a  reason: collision with root package name */
    public long f21452a = -1;
    public long b = -1;

    /* renamed from: c  reason: collision with root package name */
    public String f21453c = null;
    public boolean d = false;
    public boolean e = false;
    public int f = 0;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(a aVar) {
        int i;
        a aVar2 = aVar;
        if (aVar2 == null || this.b - aVar2.b > 0) {
            return 1;
        }
        return i < 0 ? -1 : 0;
    }
}
