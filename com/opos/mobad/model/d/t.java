package com.opos.mobad.model.d;

import android.content.Context;
import com.opos.mobad.b.a.y;
import com.opos.mobad.model.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/d/t.class */
public class t extends a {
    private com.opos.mobad.model.a.a b;

    /* renamed from: c  reason: collision with root package name */
    private String f26452c;
    private List<y> d;
    private Context e;

    public t(Context context, String str, String str2, com.opos.mobad.model.b.c cVar, boolean z, m.a aVar, com.opos.mobad.model.a.b bVar) {
        super(context, str, cVar, z, new i(str, str2, false), aVar);
        this.d = new ArrayList();
        this.e = context;
        this.f26452c = str;
        this.b = new com.opos.mobad.model.a.a.a(context, bVar);
    }

    private void a(final String str, final com.opos.mobad.model.b.c cVar) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.d.t.1
            @Override // java.lang.Runnable
            public void run() {
                com.opos.mobad.model.b.d a2 = t.this.b.a(str, cVar, t.this.f26398a);
                com.opos.cmn.an.f.a.b("sLoader", "response:" + a2);
                com.opos.mobad.model.e.d.a(t.this.e, str, a2.d());
                if (a2.p()) {
                    com.opos.mobad.service.i.d.a().b();
                }
                if (a2.q()) {
                    com.opos.mobad.service.f.b().a();
                }
                if (a2 != null && a2.f() == 1035) {
                    com.opos.mobad.service.f.c().a(str, false, a2.l());
                }
                t.this.a(a2);
            }
        });
    }

    private void k() {
        if (this.d.size() <= 0) {
            return;
        }
        Iterator<y> it = this.d.iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return;
            }
            y next = it.next();
            if (i2 >= 1) {
                return;
            }
            com.opos.mobad.model.e.e.a(this.e, next);
            i = i2 + 1;
        }
    }

    @Override // com.opos.mobad.model.d.a
    protected void a(y yVar) {
        if (yVar != null) {
            this.d.add(yVar);
        }
    }

    @Override // com.opos.mobad.model.d.a
    public void a(com.opos.mobad.model.b.c cVar) {
        a(this.f26452c, cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.mobad.model.d.a, com.opos.mobad.model.d.b
    public void b() {
        k();
        super.b();
    }
}
