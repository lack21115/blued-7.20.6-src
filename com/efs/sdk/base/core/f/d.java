package com.efs.sdk.base.core.f;

import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.f.f;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/f/d.class */
public final class d extends a {

    /* renamed from: c  reason: collision with root package name */
    private AtomicInteger f8172c = new AtomicInteger(0);
    private AtomicInteger d = new AtomicInteger(0);
    public AtomicInteger b = new AtomicInteger(0);
    private AtomicInteger e = new AtomicInteger(0);
    private AtomicInteger f = new AtomicInteger(0);

    @Override // com.efs.sdk.base.core.f.a
    public final void a() {
        f fVar;
        if ((this.f8172c.get() == 0 && this.d.get() == 0 && this.b.get() == 0 && this.f.get() == 0 && this.e.get() == 0) || this.f8167a == null || !ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
            return;
        }
        ControllerCenter controllerCenter = this.f8167a;
        int i = this.f8172c.get();
        int i2 = this.d.get();
        int i3 = this.b.get();
        int i4 = this.f.get();
        int i5 = this.e.get();
        fVar = f.a.f8175a;
        b bVar = new b("efs_core", "lf_st", fVar.f8173a.f8171c);
        bVar.put("create_cnt", Integer.valueOf(i));
        bVar.put("cache_cnt", Integer.valueOf(i2));
        bVar.put("req_cnt", Integer.valueOf(i3));
        bVar.put("err_cnt", Integer.valueOf(i4));
        bVar.put("expire_cnt", Integer.valueOf(i5));
        this.f8172c.addAndGet(i * (-1));
        this.d.addAndGet(i2 * (-1));
        this.b.addAndGet(i3 * (-1));
        this.f.addAndGet(i4 * (-1));
        this.e.addAndGet(i5 * (-1));
        controllerCenter.send(bVar);
    }

    public final void b() {
        this.f8172c.incrementAndGet();
    }

    public final void c() {
        this.d.incrementAndGet();
    }

    public final void d() {
        this.e.incrementAndGet();
    }

    public final void e() {
        this.f.incrementAndGet();
    }
}
