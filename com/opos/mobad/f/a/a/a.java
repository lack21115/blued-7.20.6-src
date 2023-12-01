package com.opos.mobad.f.a.a;

import android.os.SystemClock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/a/a.class */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private com.opos.mobad.service.i.c f26018a = new com.opos.mobad.service.i.c();
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f26019c;
    private volatile long d;
    private long e;

    public a(String str, long j) {
        this.b = str;
        this.e = j;
        this.e = j;
    }

    public void a() {
        a("t", 0);
    }

    public void a(int i) {
        a(this.b, this.e, this.f26019c, i, SystemClock.elapsedRealtime() - this.d, this.f26018a.b());
        this.f26019c = null;
        this.f26018a = new com.opos.mobad.service.i.c();
    }

    public void a(int i, int i2) {
        a(String.valueOf(i), i2);
    }

    public void a(String str) {
        this.f26019c = str;
        this.d = SystemClock.elapsedRealtime();
    }

    protected final void a(String str, int i) {
        if (this.f26018a.a() >= 1024) {
            com.opos.cmn.an.f.a.b("", "illegal append report");
        } else {
            this.f26018a.a(str, String.valueOf(i));
        }
    }

    protected abstract void a(String str, long j, String str2, int i, long j2, String str3);

    public void b() {
        a("t", 1);
    }

    public void b(int i) {
        b(this.b, this.e, this.f26019c, i, SystemClock.elapsedRealtime() - this.d, this.f26018a.b());
        this.f26019c = null;
        this.f26018a = new com.opos.mobad.service.i.c();
    }

    protected abstract void b(String str, long j, String str2, int i, long j2, String str3);

    public void c() {
        a("t", 2);
    }

    public void c(int i) {
        if (i != 1035) {
            b(i);
            return;
        }
        com.opos.mobad.service.d.b.a().a(this.b);
        this.f26018a = new com.opos.mobad.service.i.c();
    }
}
