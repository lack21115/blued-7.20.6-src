package com.tencent.qmsp.oaid2;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/w.class */
public class w {

    /* renamed from: a  reason: collision with root package name */
    public int f38507a;
    public long b;

    /* renamed from: c  reason: collision with root package name */
    public String f38508c;
    public String d;

    public w(String str) {
        this.f38508c = str;
    }

    public void a(int i) {
        this.f38507a = i;
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
