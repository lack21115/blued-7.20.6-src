package com.opos.exoplayer.core.c.e;

import com.opos.exoplayer.core.i.m;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/e/e.class */
final class e {

    /* renamed from: a  reason: collision with root package name */
    private final f f11480a = new f();
    private final m b = new m(new byte[65025], 0);

    /* renamed from: c  reason: collision with root package name */
    private int f11481c = -1;
    private int d;
    private boolean e;

    private int a(int i) {
        int i2;
        int i3;
        int i4 = 0;
        this.d = 0;
        do {
            i2 = i4;
            if (this.d + i >= this.f11480a.g) {
                break;
            }
            int[] iArr = this.f11480a.j;
            int i5 = this.d;
            this.d = i5 + 1;
            i3 = iArr[i5 + i];
            i2 = i4 + i3;
            i4 = i2;
        } while (i3 == 255);
        return i2;
    }

    public void a() {
        this.f11480a.a();
        this.b.a();
        this.f11481c = -1;
        this.e = false;
    }

    public boolean a(com.opos.exoplayer.core.c.f fVar) {
        int i;
        com.opos.exoplayer.core.i.a.b(fVar != null);
        if (this.e) {
            this.e = false;
            this.b.a();
        }
        while (!this.e) {
            if (this.f11481c < 0) {
                if (!this.f11480a.a(fVar, true)) {
                    return false;
                }
                int i2 = this.f11480a.h;
                if ((this.f11480a.b & 1) == 1 && this.b.c() == 0) {
                    i2 += a(0);
                    i = this.d + 0;
                } else {
                    i = 0;
                }
                fVar.b(i2);
                this.f11481c = i;
            }
            int a2 = a(this.f11481c);
            int i3 = this.f11481c + this.d;
            if (a2 > 0) {
                if (this.b.e() < this.b.c() + a2) {
                    m mVar = this.b;
                    mVar.f11808a = Arrays.copyOf(mVar.f11808a, this.b.c() + a2);
                }
                fVar.b(this.b.f11808a, this.b.c(), a2);
                m mVar2 = this.b;
                mVar2.b(a2 + mVar2.c());
                this.e = this.f11480a.j[i3 - 1] != 255;
            }
            int i4 = i3;
            if (i3 == this.f11480a.g) {
                i4 = -1;
            }
            this.f11481c = i4;
        }
        return true;
    }

    public f b() {
        return this.f11480a;
    }

    public m c() {
        return this.b;
    }

    public void d() {
        if (this.b.f11808a.length == 65025) {
            return;
        }
        m mVar = this.b;
        mVar.f11808a = Arrays.copyOf(mVar.f11808a, Math.max(65025, this.b.c()));
    }
}
