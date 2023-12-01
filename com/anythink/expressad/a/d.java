package com.anythink.expressad.a;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/a/d.class */
public class d {
    protected static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    protected static final int f4125c = 2;
    protected static final int d = 4;
    protected static final int e = 8;
    protected static final int f = 16;
    protected static final int g = 32;

    /* renamed from: a  reason: collision with root package name */
    private int f4126a = 1;
    protected e h;

    private int a() {
        return this.f4126a;
    }

    private void a(int i) {
        this.f4126a = i;
    }

    private void a(e eVar) {
        this.h = eVar;
    }

    private boolean c() {
        int i = this.f4126a;
        return i == 8 || i == 16;
    }

    private boolean d() {
        return this.f4126a == 2;
    }

    private boolean e() {
        return this.f4126a == 32;
    }

    private boolean f() {
        return this.f4126a == 4;
    }

    public void b() {
        this.f4126a = 8;
    }
}
