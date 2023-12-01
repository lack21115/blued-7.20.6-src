package com.igexin.push.core.i;

import android.app.Activity;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/i/a.class */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected Long f23560a = Long.valueOf(System.currentTimeMillis());
    protected Activity b;

    /* renamed from: c  reason: collision with root package name */
    protected String f23561c;

    private void a(Long l) {
        this.f23560a = l;
    }

    private void a(String str) {
        this.f23561c = str;
    }

    private Activity n() {
        return this.b;
    }

    public final Long a() {
        return this.f23560a;
    }

    public final void a(Activity activity) {
        this.b = activity;
    }

    public final String b() {
        return this.f23561c;
    }

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public abstract boolean j();

    public abstract void k();

    public abstract boolean l();

    public abstract void m();
}
