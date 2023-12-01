package com.opos.cmn.func.dl.base.g;

import com.opos.cmn.func.dl.base.DownloadRequest;
import com.opos.cmn.func.dl.base.DownloadResponse;
import com.opos.cmn.func.dl.base.exception.DlException;
import com.opos.libs.a.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/g/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11243a = a.class.getSimpleName();
    private com.opos.libs.a.a b;

    /* renamed from: c  reason: collision with root package name */
    private b f11244c;
    private DownloadRequest d;
    private DownloadResponse e = new DownloadResponse();
    private com.opos.cmn.func.dl.base.a.b f;

    public a(com.opos.cmn.func.dl.base.a.b bVar, b bVar2) {
        this.f = bVar;
        this.d = bVar.q;
        this.f11244c = bVar2;
        a.C0498a a2 = new a.C0498a(0).a(0, 1).a(1, 2, 7, 4).a(2, 3, 4, 5).a(3, 4, 5, 6, 7).a(4, 1, 5);
        if (bVar.o) {
            a2.a(7, 1, 5, 4);
        }
        this.b = a2.a();
    }

    private boolean a(int i) {
        boolean z;
        synchronized (this) {
            int a2 = a();
            z = i == this.b.a(i) && i != a2;
            String str = f11243a;
            com.opos.cmn.an.f.a.b(str, "Change state:" + a2 + "to " + i + ",result:" + z);
        }
        return z;
    }

    private void i() {
        this.e.f11185a = a();
        this.e.d = this.f.k;
        this.e.b = this.f.l;
        this.e.f11186c = this.f.s.get();
        this.e.e = a() == 3 ? this.e.e : 0L;
    }

    public final int a() {
        int a2;
        synchronized (this) {
            a2 = this.b.a();
        }
        return a2;
    }

    public final void a(long j) {
        synchronized (this) {
            if (a() == 3) {
                i();
                this.e.e = j;
                this.f11244c.c(this.d, this.e);
            }
        }
    }

    public final void a(DlException dlException) {
        synchronized (this) {
            if (a(7)) {
                if (!this.f.m) {
                    this.f.l = 0L;
                    this.f.a(0L);
                }
                i();
                this.f11244c.a(this.d, this.e, dlException);
            }
        }
    }

    public final boolean b() {
        boolean z;
        synchronized (this) {
            int a2 = a();
            z = (a2 == 5 || a2 == 4) ? false : true;
        }
        return z;
    }

    public final boolean c() {
        boolean a2;
        synchronized (this) {
            a2 = a(1);
        }
        return a2;
    }

    public final boolean d() {
        boolean z;
        synchronized (this) {
            if (a(2)) {
                i();
                this.f11244c.a(this.d, this.e);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final boolean e() {
        boolean z;
        synchronized (this) {
            if (a(3)) {
                i();
                this.f11244c.b(this.d, this.e);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final boolean f() {
        boolean z;
        synchronized (this) {
            if (a(4)) {
                if (!this.f.m) {
                    this.f.l = 0L;
                    this.f.a(0L);
                }
                i();
                this.f11244c.d(this.d, this.e);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final boolean g() {
        boolean z;
        synchronized (this) {
            if (a(5)) {
                i();
                this.f11244c.e(this.d, this.e);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final void h() {
        synchronized (this) {
            if (a(6)) {
                if (this.f.k == -1) {
                    this.f.k = this.f.s.get();
                }
                i();
                this.f11244c.f(this.d, this.e);
            }
        }
    }
}
