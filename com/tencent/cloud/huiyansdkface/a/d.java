package com.tencent.cloud.huiyansdkface.a;

import android.content.Context;
import com.tencent.cloud.huiyansdkface.a.a.g;
import com.tencent.cloud.huiyansdkface.a.d.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private Context f35472a;
    private com.tencent.cloud.huiyansdkface.a.g.b f;
    private g<com.tencent.cloud.huiyansdkface.a.a.a.b> m;
    private b o;
    private com.tencent.cloud.huiyansdkface.a.a.f q;
    private com.tencent.cloud.huiyansdkface.a.c.b b = com.tencent.cloud.huiyansdkface.a.c.c.a();

    /* renamed from: c  reason: collision with root package name */
    private boolean f35473c = false;
    private com.tencent.cloud.huiyansdkface.a.a.a.c d = com.tencent.cloud.huiyansdkface.a.a.a.c.CROP_CENTER;
    private com.tencent.cloud.huiyansdkface.a.a.a.a e = com.tencent.cloud.huiyansdkface.a.a.a.a.BACK;
    private com.tencent.cloud.huiyansdkface.a.e.d g = null;
    private g<String> h = com.tencent.cloud.huiyansdkface.a.a.b.b.a(com.tencent.cloud.huiyansdkface.a.a.b.b.d(), com.tencent.cloud.huiyansdkface.a.a.b.b.b(), com.tencent.cloud.huiyansdkface.a.a.b.b.c(), com.tencent.cloud.huiyansdkface.a.a.b.b.a());
    private g<String> i = com.tencent.cloud.huiyansdkface.a.a.b.b.a(com.tencent.cloud.huiyansdkface.a.a.b.c.c(), com.tencent.cloud.huiyansdkface.a.a.b.c.b(), com.tencent.cloud.huiyansdkface.a.a.b.c.a());
    private g<com.tencent.cloud.huiyansdkface.a.a.a.d> j = com.tencent.cloud.huiyansdkface.a.a.b.f.a();
    private g<com.tencent.cloud.huiyansdkface.a.a.a.d> k = com.tencent.cloud.huiyansdkface.a.a.b.f.a();
    private g<com.tencent.cloud.huiyansdkface.a.a.a.d> l = com.tencent.cloud.huiyansdkface.a.a.b.f.a();
    private float n = -1.0f;
    private List<com.tencent.cloud.huiyansdkface.a.a.e> p = new ArrayList();

    public d(Context context) {
        this.f35472a = context;
    }

    public c a() {
        com.tencent.cloud.huiyansdkface.a.d.a.a("WeCamera", "wecamera version:release_1.0.41.14", new Object[0]);
        com.tencent.cloud.huiyansdkface.a.a.c a2 = new com.tencent.cloud.huiyansdkface.a.a.c().a(this.j).b(this.k).c(this.l).d(this.h).e(this.i).f(this.m).a(this.p).a(this.q);
        float f = this.n;
        if (f >= 0.0f && f <= 1.0f) {
            a2.a(f);
        }
        return new c(this.f35472a, this.b, this.f, this.e, a2, this.d, this.o, this.g, this.f35473c);
    }

    public d a(com.tencent.cloud.huiyansdkface.a.a.a.a aVar) {
        com.tencent.cloud.huiyansdkface.a.a.a.a aVar2 = aVar;
        if (aVar == null) {
            aVar2 = com.tencent.cloud.huiyansdkface.a.a.a.a.FRONT;
        }
        this.e = aVar2;
        return this;
    }

    public d a(com.tencent.cloud.huiyansdkface.a.a.a.c cVar) {
        if (cVar != null) {
            this.d = cVar;
        }
        return this;
    }

    public d a(com.tencent.cloud.huiyansdkface.a.a.e eVar) {
        if (eVar != null && !this.p.contains(eVar)) {
            this.p.add(eVar);
        }
        return this;
    }

    public d a(g<String> gVar) {
        if (gVar != null) {
            this.i = gVar;
        }
        return this;
    }

    public d a(com.tencent.cloud.huiyansdkface.a.b.a aVar) {
        if (aVar != null) {
            com.tencent.cloud.huiyansdkface.a.b.b.a(aVar);
        }
        return this;
    }

    public d a(com.tencent.cloud.huiyansdkface.a.c.b bVar) {
        if (bVar != null) {
            this.b = bVar;
        }
        return this;
    }

    public d a(a.c cVar) {
        if (cVar != null) {
            com.tencent.cloud.huiyansdkface.a.d.a.a(cVar);
        }
        return this;
    }

    public d a(com.tencent.cloud.huiyansdkface.a.e.d dVar) {
        this.g = dVar;
        return this;
    }

    public d a(com.tencent.cloud.huiyansdkface.a.g.b bVar) {
        if (bVar != null) {
            this.f = bVar;
        }
        return this;
    }

    public d a(boolean z) {
        this.f35473c = z;
        return this;
    }

    public d b(g<com.tencent.cloud.huiyansdkface.a.a.a.d> gVar) {
        if (gVar != null) {
            this.j = gVar;
        }
        return this;
    }

    public d c(g<com.tencent.cloud.huiyansdkface.a.a.a.b> gVar) {
        if (gVar != null) {
            this.m = gVar;
        }
        return this;
    }
}
