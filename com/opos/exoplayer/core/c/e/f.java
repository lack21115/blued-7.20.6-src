package com.opos.exoplayer.core.c.e;

import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.o;
import java.io.EOFException;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/e/f.class */
final class f {
    private static final int k = u.f("OggS");

    /* renamed from: a  reason: collision with root package name */
    public int f11482a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public long f11483c;
    public long d;
    public long e;
    public long f;
    public int g;
    public int h;
    public int i;
    public final int[] j = new int[255];
    private final m l = new m(255);

    public void a() {
        this.f11482a = 0;
        this.b = 0;
        this.f11483c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        this.g = 0;
        this.h = 0;
        this.i = 0;
    }

    public boolean a(com.opos.exoplayer.core.c.f fVar, boolean z) {
        boolean z2;
        this.l.a();
        a();
        if ((fVar.d() == -1 || fVar.d() - fVar.b() >= 27) && fVar.b(this.l.f11808a, 0, 27, true)) {
            if (this.l.m() == k) {
                int g = this.l.g();
                this.f11482a = g;
                if (g == 0) {
                    this.b = this.l.g();
                    this.f11483c = this.l.r();
                    this.d = this.l.n();
                    this.e = this.l.n();
                    this.f = this.l.n();
                    int g2 = this.l.g();
                    this.g = g2;
                    this.h = g2 + 27;
                    this.l.a();
                    fVar.c(this.l.f11808a, 0, this.g);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        z2 = true;
                        if (i2 >= this.g) {
                            break;
                        }
                        this.j[i2] = this.l.g();
                        this.i += this.j[i2];
                        i = i2 + 1;
                    }
                    return z2;
                } else if (!z) {
                    throw new o("unsupported bit stream revision");
                }
            } else if (!z) {
                throw new o("expected OggS capture pattern at begin of page");
            }
        } else if (!z) {
            throw new EOFException();
        }
        z2 = false;
        return z2;
    }
}
