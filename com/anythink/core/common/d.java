package com.anythink.core.common;

import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.common.e.ai;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/d.class */
public final class d {
    com.anythink.core.common.e.e a;
    ai b;
    long c;
    ATBaseAdAdapter d;
    int e;
    Runnable f;
    Runnable g;
    boolean h;
    boolean i;
    private Boolean j;

    private d(int i) {
        this.e = i;
    }

    private void a(long j) {
        this.c = j;
    }

    private void a(long j, final Runnable runnable, long j2, final Runnable runnable2) {
        if (j != -1 && runnable != null) {
            this.f = new Runnable() { // from class: com.anythink.core.common.d.1
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (d.this) {
                        d.this.i = true;
                        runnable.run();
                    }
                }
            };
            com.anythink.core.common.b.n.a().a(this.f, j);
        }
        if (j2 == -1 || runnable2 == null) {
            return;
        }
        this.g = new Runnable() { // from class: com.anythink.core.common.d.2
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (d.this) {
                    d.this.h = true;
                    runnable2.run();
                }
            }
        };
        com.anythink.core.common.b.n.a().a(this.g, j2);
    }

    private void a(ATBaseAdAdapter aTBaseAdAdapter) {
        this.d = aTBaseAdAdapter;
    }

    private void a(ai aiVar) {
        this.b = aiVar;
    }

    private void a(com.anythink.core.common.e.e eVar) {
        this.a = eVar;
    }

    private void a(boolean z) {
        this.j = Boolean.valueOf(z);
    }

    private boolean a() {
        if (this.j != null) {
            return !(this.h || this.i);
        }
        return true;
    }

    private boolean b() {
        return this.j != null;
    }

    private com.anythink.core.common.e.e c() {
        return this.a;
    }

    private long d() {
        return this.c;
    }

    private void e() {
        this.d = null;
    }

    private int f() {
        return this.e;
    }

    private void g() {
        if (this.f != null) {
            com.anythink.core.common.b.n.a().c(this.f);
            this.f = null;
        }
        if (this.g != null) {
            com.anythink.core.common.b.n.a().c(this.g);
            this.g = null;
        }
    }

    private void h() {
        if (this.f != null) {
            com.anythink.core.common.b.n.a().c(this.f);
            this.f = null;
        }
    }

    private void i() {
        if (this.g != null) {
            com.anythink.core.common.b.n.a().c(this.g);
            this.g = null;
        }
    }

    private Boolean j() {
        return this.j;
    }

    private boolean k() {
        return this.h || this.i;
    }

    private ai l() {
        return this.b;
    }
}
