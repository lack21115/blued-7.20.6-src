package com.opos.mobad.activity.webview;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import com.opos.cmn.biz.web.c.b.c;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/activity/webview/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private e f25641a;
    private c b;

    /* renamed from: c  reason: collision with root package name */
    private WebDataHepler f25642c;
    private com.opos.mobad.activity.webview.a.b d;
    private Activity e;
    private com.opos.mobad.activity.webview.a.a f;
    private com.opos.mobad.cmn.a.d g;
    private com.opos.mobad.activity.webview.b.d h;
    private a i;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/activity/webview/b$a.class */
    public interface a {
        void a();
    }

    public b(Activity activity, WebDataHepler webDataHepler) {
        this.e = activity;
        this.f25642c = webDataHepler;
        c.a a2 = new c.a().b("ad_mob").a(true).a(webDataHepler.c());
        this.g = com.opos.mobad.cmn.service.a.a().b();
        this.f = new com.opos.mobad.activity.webview.a.a(activity);
        this.d = com.opos.mobad.cmn.service.a.a().c().a(activity, a2.a(), this.f);
    }

    private void a(com.opos.mobad.activity.webview.a.b bVar, com.opos.mobad.activity.webview.a.a aVar, com.opos.mobad.cmn.a.d dVar) {
        if (this.f25641a != null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("mixad", bVar);
        c cVar = new c(this.e, new d(hashMap, this.f25642c.g(), this.f25642c.i(), this.f25642c.j()));
        this.b = cVar;
        e eVar = new e(this.e, cVar);
        this.f25641a = eVar;
        com.opos.mobad.activity.webview.b.d dVar2 = this.h;
        if (dVar2 != null) {
            eVar.a(dVar2);
        }
        a aVar2 = this.i;
        if (aVar2 != null) {
            this.f.a(aVar2);
            this.f25641a.a(this.i);
        }
        aVar.a(this.f25641a, this.f25642c, dVar);
    }

    public void a() {
        com.opos.cmn.an.f.a.b("WebPresenter", "render");
        if (this.f25641a != null) {
            return;
        }
        a(this.d, this.f, this.g);
        this.f25641a.a(this.f25642c);
    }

    public void a(a aVar) {
        this.i = aVar;
        com.opos.mobad.activity.webview.a.a aVar2 = this.f;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
        e eVar = this.f25641a;
        if (eVar != null) {
            eVar.a(aVar);
        }
    }

    public void a(com.opos.mobad.activity.webview.b.d dVar) {
        this.h = dVar;
        e eVar = this.f25641a;
        if (eVar != null) {
            eVar.a(dVar);
        }
    }

    public boolean a(int i, KeyEvent keyEvent) {
        e eVar = this.f25641a;
        return eVar != null && eVar.a(i, keyEvent);
    }

    public void b() {
        c cVar = this.b;
        if (cVar == null) {
            return;
        }
        cVar.e();
    }

    public View c() {
        c cVar = this.b;
        if (cVar == null) {
            return null;
        }
        return cVar.d();
    }

    public void d() {
        com.opos.mobad.activity.webview.a.b bVar = this.d;
        if (bVar != null) {
            bVar.a();
        }
        e eVar = this.f25641a;
        if (eVar != null) {
            eVar.b();
        }
        com.opos.mobad.activity.webview.a.a aVar = this.f;
        if (aVar != null) {
            aVar.e();
        }
    }
}
