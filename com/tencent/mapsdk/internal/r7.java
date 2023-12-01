package com.tencent.mapsdk.internal;

import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/r7.class */
public abstract class r7 {
    public static final long f = -1;
    public static final int g = 0;
    public static final int h = 1;
    public static final int i = 2;

    /* renamed from: a  reason: collision with root package name */
    public long f37735a;
    private boolean d;
    private long e;

    /* renamed from: c  reason: collision with root package name */
    private long f37736c = -1;
    public int b = 0;

    public r7(long j) {
        this.f37735a = j;
    }

    public long a() {
        return this.f37735a;
    }

    public void a(long j) {
        this.e = j;
    }

    public void a(GL10 gl10) {
        if (this.b != 1) {
            return;
        }
        if (this.f37736c == -1) {
            this.f37736c = System.currentTimeMillis();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f37736c;
        long j = this.e;
        if (j - currentTimeMillis > 0) {
            return;
        }
        long j2 = currentTimeMillis - j;
        if (j2 >= this.f37735a) {
            if (this.d) {
                d();
            }
            this.b = 2;
        }
        a(gl10, j2);
    }

    public abstract void a(GL10 gl10, long j);

    public void a(boolean z) {
        this.d = z;
    }

    public boolean b() {
        return this.b == 1;
    }

    public boolean c() {
        return this.b == 2;
    }

    public void d() {
        this.b = 1;
        this.f37736c = -1L;
    }

    public void e() {
        this.b = 1;
        this.f37736c = -1L;
    }

    public void f() {
        this.b = 2;
    }
}
