package com.opos.cmn.func.dl.base.b;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/b/b.class */
public final class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f11209a;
    public ThreadPoolExecutor b;

    /* renamed from: c  reason: collision with root package name */
    private c f11210c;
    private Executor d;
    private ThreadPoolExecutor e;

    public b(c cVar) {
        this.f11210c = cVar;
        this.d = cVar.a();
    }

    @Override // com.opos.cmn.func.dl.base.b.c
    public final Executor a() {
        return this.d;
    }

    @Override // com.opos.cmn.func.dl.base.b.c
    public final ThreadPoolExecutor b() {
        if (this.f11209a == null) {
            this.f11209a = this.f11210c.b();
        }
        return this.f11209a;
    }

    @Override // com.opos.cmn.func.dl.base.b.c
    public final ThreadPoolExecutor c() {
        if (this.b == null) {
            this.b = this.f11210c.c();
        }
        return this.b;
    }

    @Override // com.opos.cmn.func.dl.base.b.c
    public final ThreadPoolExecutor d() {
        if (this.e == null) {
            this.e = this.f11210c.d();
        }
        return this.e;
    }
}
