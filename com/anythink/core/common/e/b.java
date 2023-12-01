package com.anythink.core.common.e;

import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.BaseAd;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/b.class */
public class b implements Comparable<b> {

    /* renamed from: a  reason: collision with root package name */
    private int f6649a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private ATBaseAdAdapter f6650c;
    private BaseAd d;
    private int e;
    private boolean f;
    private long g;
    private String h;
    private int i;
    private long j;
    private boolean k;

    private int b(b bVar) {
        return com.anythink.core.common.k.g.a(this.f6650c.getUnitGroupInfo()) > com.anythink.core.common.k.g.a(bVar.f6650c.getUnitGroupInfo()) ? -1 : 1;
    }

    private long l() {
        return this.g;
    }

    private int m() {
        return this.f6649a;
    }

    private long n() {
        return this.b;
    }

    public final void a(int i) {
        this.e = i;
        if (i > 0) {
            this.i = 0;
        }
    }

    public final void a(long j) {
        this.j = j;
    }

    public final void a(ATBaseAdAdapter aTBaseAdAdapter) {
        this.f6650c = aTBaseAdAdapter;
    }

    public final void a(BaseAd baseAd) {
        this.d = baseAd;
    }

    public final void a(String str) {
        this.h = str;
    }

    public final void a(boolean z) {
        this.f = z;
    }

    public final boolean a() {
        return this.i == 1 && System.currentTimeMillis() - this.b < this.j;
    }

    public final String b() {
        return this.h;
    }

    public final void b(int i) {
        this.f6649a = i;
    }

    public final void b(long j) {
        this.g = j;
    }

    public final void c(long j) {
        this.i = 1;
        this.b = j;
    }

    public final boolean c() {
        return this.f;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(b bVar) {
        return com.anythink.core.common.k.g.a(this.f6650c.getUnitGroupInfo()) > com.anythink.core.common.k.g.a(bVar.f6650c.getUnitGroupInfo()) ? -1 : 1;
    }

    public final int d() {
        return this.e;
    }

    public final ATBaseAdAdapter e() {
        return this.f6650c;
    }

    public final BaseAd f() {
        return this.d;
    }

    public final boolean g() {
        try {
            if (this.f6650c == null || this.d == null) {
                if (this.f6650c != null) {
                    return this.f6650c.isAdReady();
                }
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public final e h() {
        BaseAd baseAd = this.d;
        return baseAd != null ? baseAd.getDetail() : this.f6650c.getTrackingInfo();
    }

    public final boolean i() {
        return this.b + this.g > System.currentTimeMillis();
    }

    public final boolean j() {
        return i() && g();
    }

    public final void k() {
        synchronized (this) {
            if (this.k) {
                return;
            }
            this.k = true;
            com.anythink.core.common.b.n.a().a(new Runnable() { // from class: com.anythink.core.common.e.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (b.this.f6650c != null) {
                            b.this.f6650c.destory();
                        }
                    } catch (Throwable th) {
                    }
                }
            });
        }
    }
}
