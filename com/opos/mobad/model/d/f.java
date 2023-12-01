package com.opos.mobad.model.d;

import android.os.SystemClock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/d/f.class */
public class f extends q {

    /* renamed from: a  reason: collision with root package name */
    private p f12729a = new p();
    private long b = SystemClock.elapsedRealtime();

    public f a() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.b;
        this.b = elapsedRealtime;
        this.f12729a.a("1", String.valueOf(elapsedRealtime - j));
        return this;
    }

    public f b() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.b;
        this.b = elapsedRealtime;
        this.f12729a.a("2", String.valueOf(elapsedRealtime - j));
        return this;
    }

    public f c() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.b;
        this.b = elapsedRealtime;
        this.f12729a.a("3", String.valueOf(elapsedRealtime - j));
        return this;
    }

    public f d() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.b;
        this.b = elapsedRealtime;
        this.f12729a.a("4", String.valueOf(elapsedRealtime - j));
        return this;
    }

    public f e() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.b;
        this.b = elapsedRealtime;
        this.f12729a.a("5", String.valueOf(elapsedRealtime - j));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String f() {
        return com.opos.cmn.i.n.a(this.f12729a.a());
    }
}
