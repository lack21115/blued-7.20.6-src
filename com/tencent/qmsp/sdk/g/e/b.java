package com.tencent.qmsp.sdk.g.e;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/e/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f38632a;
    public long b;

    /* renamed from: c  reason: collision with root package name */
    public String f38633c;
    public String d;

    public b(String str) {
        this.f38633c = str;
    }

    public void a(int i) {
        this.f38632a = i;
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
