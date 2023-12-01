package com.opos.mobad.q.a;

import android.app.Activity;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.q.a.d;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/k.class */
public class k extends c {
    private boolean p;

    public k(Activity activity, String str, com.opos.mobad.cmn.a.a aVar, com.opos.mobad.n.a aVar2, d dVar, com.opos.mobad.o.a.a aVar3, com.opos.mobad.q.a.e.a aVar4, com.opos.mobad.n.a aVar5) {
        super(activity, str, aVar, aVar2, dVar, aVar3, aVar4, aVar5);
        this.p = false;
    }

    private void a(long j) {
        if (this.p) {
            return;
        }
        this.p = true;
        try {
            String d = this.n.d(j);
            if (TextUtils.isEmpty(d)) {
                return;
            }
            Toast.makeText(this.b, d, 1).show();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("RWCommonPresenter", "", (Throwable) e);
        }
    }

    private void h() {
        if (this.d == null || this.e == null) {
            return;
        }
        int T = this.e.T();
        if (T == 0) {
            if (this.h != null) {
                this.h.a();
            }
        } else if (T == 1) {
            i();
        } else if (T != 2) {
            l(null, null);
        }
    }

    private void i() {
        if (this.k == null) {
            return;
        }
        this.k.c().setVisibility(0);
    }

    @Override // com.opos.mobad.q.a.c, com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0708a
    public void a(long j, long j2) {
        super.a(j, j2);
        h();
    }

    @Override // com.opos.mobad.q.a.c
    public void a(Configuration configuration) {
        if (this.f27149c instanceof com.opos.mobad.q.a.f.c) {
            ((com.opos.mobad.q.a.f.c) this.f27149c).t();
        }
    }

    @Override // com.opos.mobad.q.a.m
    public void a(com.opos.mobad.ad.h hVar, Object... objArr) {
        if (this.n.b()) {
            this.f.c(0);
            this.f27149c.a(this.f);
        }
        super.a(hVar, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.mobad.q.a.c, com.opos.mobad.q.a.m
    public boolean a(View view, int[] iArr, com.opos.mobad.cmn.a.b.a aVar) {
        return super.a(view, iArr, aVar, false);
    }

    public void b(final AdItemData adItemData, final MaterialData materialData, final int i, final g gVar) {
        this.h = gVar;
        this.p = false;
        if (adItemData.r() == 2 && !com.opos.cmn.an.h.c.a.e(this.b) && com.opos.mobad.q.a.e.b.a(adItemData)) {
            this.g.b(new d.a() { // from class: com.opos.mobad.q.a.k.1
                @Override // com.opos.mobad.q.a.d.a
                public void a() {
                    com.opos.mobad.q.a.e.b.a(false);
                    k.this.a(adItemData, materialData, i, gVar);
                }

                @Override // com.opos.mobad.q.a.d.a
                public void b() {
                    k.this.f();
                }
            });
        } else {
            a(adItemData, materialData, i, gVar);
        }
    }

    @Override // com.opos.mobad.q.a.c, com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0708a
    public void d(long j, long j2) {
        super.d(j, j2);
        a(j2);
    }
}
