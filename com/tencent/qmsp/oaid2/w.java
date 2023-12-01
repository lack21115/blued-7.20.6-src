package com.tencent.qmsp.oaid2;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/w.class */
public class w {

    /* renamed from: a  reason: collision with root package name */
    public int f24816a;
    public long b;

    /* renamed from: c  reason: collision with root package name */
    public String f24817c;
    public String d;

    public w(String str) {
        this.f24817c = str;
    }

    public void a(int i) {
        this.f24816a = i;
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
