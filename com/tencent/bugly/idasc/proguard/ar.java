package com.tencent.bugly.idasc.proguard;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/ar.class */
public final class ar implements Comparable<ar> {

    /* renamed from: a  reason: collision with root package name */
    public long f35254a = -1;
    public long b = -1;

    /* renamed from: c  reason: collision with root package name */
    public String f35255c = null;
    public boolean d = false;
    public boolean e = false;
    public int f = 0;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(ar arVar) {
        int i;
        ar arVar2 = arVar;
        if (arVar2 == null || this.b - arVar2.b > 0) {
            return 1;
        }
        return i < 0 ? -1 : 0;
    }
}
