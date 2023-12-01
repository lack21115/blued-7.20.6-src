package com.opos.cmn.func.dl.base.b;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/b/b.class */
public final class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f24897a;
    public ThreadPoolExecutor b;

    /* renamed from: c  reason: collision with root package name */
    private c f24898c;
    private Executor d;
    private ThreadPoolExecutor e;

    public b(c cVar) {
        this.f24898c = cVar;
        this.d = cVar.a();
    }

    @Override // com.opos.cmn.func.dl.base.b.c
    public final Executor a() {
        return this.d;
    }

    @Override // com.opos.cmn.func.dl.base.b.c
    public final ThreadPoolExecutor b() {
        if (this.f24897a == null) {
            this.f24897a = this.f24898c.b();
        }
        return this.f24897a;
    }

    @Override // com.opos.cmn.func.dl.base.b.c
    public final ThreadPoolExecutor c() {
        if (this.b == null) {
            this.b = this.f24898c.c();
        }
        return this.b;
    }

    @Override // com.opos.cmn.func.dl.base.b.c
    public final ThreadPoolExecutor d() {
        if (this.e == null) {
            this.e = this.f24898c.d();
        }
        return this.e;
    }
}
