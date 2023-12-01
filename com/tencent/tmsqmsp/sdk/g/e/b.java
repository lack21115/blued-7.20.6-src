package com.tencent.tmsqmsp.sdk.g.e;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/e/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f39782a;
    public long b;

    /* renamed from: c  reason: collision with root package name */
    public String f39783c;
    public String d;

    public b(String str) {
        this.f39783c = str;
    }

    public void a(int i) {
        this.f39782a = i;
    }

    public void a(long j) {
        this.b = j;
    }

    public void a(String str) {
        this.d = str;
    }

    public boolean a() {
        return this.b > System.currentTimeMillis();
    }

    public void b() {
        this.b = 0L;
    }
}
