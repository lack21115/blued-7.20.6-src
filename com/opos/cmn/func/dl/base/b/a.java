package com.opos.cmn.func.dl.base.b;

import com.opos.cmn.an.j.a;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/b/a.class */
public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private int f24896a;

    public a(int i) {
        this.f24896a = i;
        if (i <= 0) {
            this.f24896a = 5;
        }
    }

    @Override // com.opos.cmn.func.dl.base.b.c
    public final Executor a() {
        return new com.opos.cmn.an.j.b.c();
    }

    @Override // com.opos.cmn.func.dl.base.b.c
    public final ThreadPoolExecutor b() {
        int i = this.f24896a;
        return new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue());
    }

    @Override // com.opos.cmn.func.dl.base.b.c
    public final ThreadPoolExecutor c() {
        return new a.C0622a().b(Integer.MAX_VALUE).a(0).a("tp_thread").c(30000).a(new SynchronousQueue()).a();
    }

    @Override // com.opos.cmn.func.dl.base.b.c
    public final ThreadPoolExecutor d() {
        return com.opos.cmn.an.j.b.b();
    }
}
