package com.opos.mobad.service.j;

import android.os.SystemClock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/j/m.class */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private int f27399a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f27400c;
    private double d;
    private a e;
    private long f;
    private int g;
    private int h;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/j/m$a.class */
    public interface a {
        void a(m mVar);
    }

    public m(int i, int i2, int i3, double d, a aVar) {
        this.f27399a = i;
        this.b = i2;
        this.f27400c = i3;
        this.d = d;
        this.e = aVar;
    }

    public m(int i, int i2, a aVar) {
        this(i, 0, i2, 0.0d, aVar);
    }

    private void e() {
        int i;
        int i2;
        if (SystemClock.elapsedRealtime() - this.f >= this.f27399a && (i = this.g) >= this.b && (i2 = this.h) >= this.f27400c && i / i2 >= this.d) {
            this.e.a(this);
            f();
        }
    }

    private void f() {
        this.h = 0;
        this.g = 0;
        this.f = SystemClock.elapsedRealtime();
    }

    public void a() {
        this.g++;
        e();
    }

    public void a(int i, int i2) {
        this.g += i;
        this.h += i2;
        e();
    }

    public void b() {
        this.h++;
        e();
    }

    public int c() {
        return this.g;
    }

    public int d() {
        return this.h;
    }
}
