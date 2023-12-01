package com.opos.mobad.interstitial;

import android.app.Activity;
import android.content.Context;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.opos.mobad.cmn.b.a;
import com.opos.mobad.model.e.a;
import com.opos.mobad.q.a.h;
import com.opos.mobad.service.event.EventDescription;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/interstitial/e.class */
public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private String f26256a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private h f26257c;
    private a.C0707a d;
    private com.opos.mobad.q.a.b.c e;
    private a.C0684a f;
    private com.opos.mobad.q.a.b.d g;
    private com.opos.mobad.service.event.c h;
    private com.opos.mobad.q.a.a i;
    private int j;
    private com.opos.mobad.q.a.e.a k = new com.opos.mobad.q.a.e.a() { // from class: com.opos.mobad.interstitial.e.1
        @Override // com.opos.mobad.cmn.a.a.a.b
        public void a(int i, String str) {
            if (e.this.e != null) {
                e.this.e.a(i, str);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j) {
            if (e.this.e != null) {
                e.this.e.a(j);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            if (e.this.e != null) {
                e.this.e.a(str);
            }
        }

        @Override // com.opos.mobad.ad.h
        public void a(Object... objArr) {
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b() {
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b(long j) {
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b(String str) {
        }

        @Override // com.opos.mobad.q.a.j.a
        public void c() {
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void d() {
            if (e.this.e != null) {
                e.this.e.d();
            }
        }

        @Override // com.opos.mobad.q.a.e.a
        public void e() {
            com.opos.mobad.service.event.b.a().b(e.this.h);
        }

        @Override // com.opos.mobad.q.a.a.InterfaceC0724a
        public void j_() {
            if (e.this.e != null) {
                e.this.e.j_();
            }
        }
    };

    public e(Context context, String str, h hVar, com.opos.mobad.cmn.a.a aVar, com.opos.mobad.q.a.b.d dVar, com.opos.mobad.q.a.b.c cVar, a.C0707a c0707a, int i) {
        com.opos.mobad.q.a.a aVar2 = new com.opos.mobad.q.a.a(context, str, aVar, null, cVar);
        this.i = aVar2;
        this.f26257c = hVar;
        this.e = cVar;
        this.b = str;
        this.j = i;
        this.g = dVar;
        this.d = c0707a;
        aVar2.a(c0707a.b, this.d.f26483c, this.d.f26483c.b(), 0);
    }

    private String b() {
        return this.b + BridgeUtil.UNDERLINE_STR + System.currentTimeMillis();
    }

    @Override // com.opos.mobad.interstitial.a
    public void a() {
        a.C0684a c0684a = this.f;
        if (c0684a != null) {
            c0684a.b();
        }
        this.f = null;
        if (this.h != null) {
            com.opos.mobad.service.event.b.a().b(this.h);
        }
    }

    @Override // com.opos.mobad.interstitial.a
    public boolean a(Activity activity) {
        com.opos.mobad.q.a.a aVar;
        int i;
        if (activity == null) {
            com.opos.cmn.an.f.a.b("ActivityStarted", "null activity");
            aVar = this.i;
            i = -1;
        } else {
            a.C0707a c0707a = this.d;
            if (c0707a == null || c0707a.b == null) {
                com.opos.cmn.an.f.a.b("ActivityStarted", "null data");
                aVar = this.i;
                i = 10006;
            } else if (System.currentTimeMillis() <= this.d.b.s()) {
                String b = b();
                this.f26256a = b;
                EventDescription eventDescription = new EventDescription(b);
                this.h = com.opos.mobad.q.a.a.a.a(eventDescription, this.k);
                if (!this.f26257c.a(activity, this.d.b, this.j, this.g, eventDescription)) {
                    com.opos.mobad.service.event.b.a().b(this.h);
                    return false;
                }
                this.f = new a.C0684a(a.C0684a.a(eventDescription));
                com.opos.cmn.an.f.a.b("ActivityStarted", "do show as activity");
                return true;
            } else {
                com.opos.cmn.an.f.a.b("ActivityStarted", "exp time");
                aVar = this.i;
                i = 10003;
            }
        }
        aVar.a(i);
        return false;
    }
}
