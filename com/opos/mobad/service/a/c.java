package com.opos.mobad.service.a;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.func.b.b.d;
import com.opos.cmn.i.a;
import com.opos.mobad.b.a.i;
import com.opos.mobad.b.a.j;
import com.opos.mobad.b.a.l;
import com.opos.mobad.b.a.m;
import com.opos.mobad.b.a.n;
import com.opos.mobad.provider.record.ControlEntity;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/a/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f13595a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private String f13596c;
    private int d;
    private int e;
    private com.opos.mobad.provider.record.a f;
    private AtomicReference<ControlEntity> g = new AtomicReference<>(null);
    private com.opos.cmn.i.a h = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.a.c.1
        @Override // com.opos.cmn.i.a.b
        public void a(a.InterfaceC0475a interfaceC0475a) {
            if (c.this.f == null) {
                interfaceC0475a.b();
            } else {
                c.this.a(interfaceC0475a);
            }
        }
    }, 10000, 0);

    private c() {
    }

    public static final c a() {
        c cVar;
        c cVar2 = f13595a;
        if (cVar2 != null) {
            return cVar2;
        }
        synchronized (c.class) {
            try {
                if (f13595a == null) {
                    f13595a = new c();
                }
                cVar = f13595a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a.InterfaceC0475a interfaceC0475a) {
        if (this.g.get() == null) {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (c.this.g.get() == null) {
                            ControlEntity d = c.this.f.d();
                            c.this.g.compareAndSet(null, d);
                            com.opos.cmn.an.f.a.b("", "control local:" + d);
                        }
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.b("", "loal fail", e);
                    }
                }
            });
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(interfaceC0475a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a.InterfaceC0475a interfaceC0475a) {
        try {
            m b = new m.a().a(new l.a().b(com.opos.mobad.service.e.a.a().e()).a(com.opos.mobad.service.e.a.a().k()).c(com.opos.cmn.f.a.a(this.b)).g(com.opos.mobad.service.e.a.a().f()).h(com.opos.mobad.service.e.a.a().g()).i(com.opos.mobad.service.e.a.a().h()).b()).a(new n.a().c(com.opos.cmn.an.b.c.c()).a(com.opos.cmn.an.b.d.b()).b(com.opos.cmn.an.b.d.a()).b()).c(com.opos.cmn.an.b.a.a(this.b)).a(com.opos.cmn.an.b.c.a()).b();
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/x-protobuf");
            hashMap.put("Route-Data", com.opos.cmn.biz.a.e.a(this.b));
            d.a b2 = new d.a().a(i.f12046c.b((com.heytap.nearx.a.a.e<i>) new i.a().a(this.f13596c).a(b).b(this.b.getPackageName()).b(Integer.valueOf(this.d)).a(Integer.valueOf(this.e)).a(Boolean.valueOf(com.opos.mobad.service.e.a.a().j())).b(Boolean.valueOf(com.opos.mobad.service.e.a.a().d())).b())).a(hashMap).b(h());
            b2.a("POST");
            com.opos.cmn.func.b.b.e a2 = com.opos.cmn.func.b.b.b.a().a(this.b, b2.a());
            if (a2 == null || 200 != a2.f11174a) {
                interfaceC0475a.b();
                return;
            }
            j a3 = j.f12048c.a(a2.f11175c);
            com.opos.cmn.an.f.a.b("", "control succ:", a3);
            ControlEntity controlEntity = new ControlEntity((a3.n != null ? a3.n : j.e).booleanValue(), (a3.o != null ? a3.o : j.f).booleanValue(), (a3.p != null ? a3.p : j.g).booleanValue(), (a3.q != null ? a3.q : j.h).booleanValue(), (a3.r != null ? a3.r : j.i).booleanValue(), (a3.s != null ? a3.s : j.j).booleanValue(), System.currentTimeMillis(), (a3.t != null ? a3.t : j.k).booleanValue());
            this.g.set(controlEntity);
            try {
                this.f.a(controlEntity);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("", "set local fail", e);
            }
            interfaceC0475a.a();
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.b("", "refresh fail", th);
            interfaceC0475a.b();
        }
    }

    private String h() {
        return "https://uapi.ads.heytapmobi.com/union/strategy/ability/select";
    }

    public void a(Context context, String str, int i, int i2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.b = context;
        this.f13596c = str;
        this.f = new com.opos.mobad.provider.record.a(context);
        this.d = i;
        this.e = i2;
        this.h.a();
    }

    public boolean b() {
        ControlEntity controlEntity = this.g.get();
        if (controlEntity != null) {
            return controlEntity.f13436a;
        }
        this.h.a();
        return j.e.booleanValue();
    }

    public boolean c() {
        ControlEntity controlEntity = this.g.get();
        if (controlEntity != null) {
            return controlEntity.b;
        }
        this.h.a();
        return j.f.booleanValue();
    }

    public boolean d() {
        ControlEntity controlEntity = this.g.get();
        if (controlEntity != null) {
            return controlEntity.f13437c;
        }
        this.h.a();
        return j.g.booleanValue();
    }

    public boolean e() {
        ControlEntity controlEntity = this.g.get();
        if (controlEntity != null) {
            return controlEntity.e;
        }
        this.h.a();
        return j.h.booleanValue();
    }

    public boolean f() {
        ControlEntity controlEntity = this.g.get();
        if (controlEntity != null) {
            return controlEntity.f;
        }
        this.h.a();
        return j.i.booleanValue();
    }

    public boolean g() {
        ControlEntity controlEntity = this.g.get();
        if (controlEntity != null) {
            return controlEntity.h;
        }
        this.h.a();
        return j.k.booleanValue();
    }
}
