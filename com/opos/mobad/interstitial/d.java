package com.opos.mobad.interstitial;

import android.app.Activity;
import com.opos.mobad.model.e.a;
import com.opos.mobad.q.a.g;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/interstitial/d.class */
public class d implements a {

    /* renamed from: a  reason: collision with root package name */
    private com.opos.mobad.q.a.b.b f26252a;
    private com.opos.mobad.q.a.c b;

    /* renamed from: c  reason: collision with root package name */
    private com.opos.mobad.q.a.b.c f26253c;
    private com.opos.mobad.n.a d;
    private a.C0707a e;
    private com.opos.mobad.activity.webview.b f;
    private int g;
    private com.opos.mobad.q.a.e.a h = new com.opos.mobad.q.a.e.a() { // from class: com.opos.mobad.interstitial.d.2
        @Override // com.opos.mobad.cmn.a.a.a.b
        public void a(int i, String str) {
            if (d.this.f26253c != null) {
                d.this.f26253c.a(i, str);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j) {
            if (d.this.f26253c != null) {
                d.this.f26253c.a(j);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            if (d.this.f26253c != null) {
                d.this.f26253c.a(str);
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
            if (d.this.f26253c != null) {
                d.this.f26253c.d();
            }
        }

        @Override // com.opos.mobad.q.a.a.InterfaceC0724a
        public void j_() {
            if (d.this.f26253c != null) {
                d.this.f26253c.j_();
            }
        }
    };

    public d(Activity activity, String str, com.opos.mobad.cmn.a.a aVar, com.opos.mobad.q.a.b.b bVar, com.opos.mobad.q.a.b.d dVar, com.opos.mobad.activity.webview.b bVar2, com.opos.mobad.q.a.b.c cVar, a.C0707a c0707a, int i) {
        this.f26252a = bVar;
        this.f26253c = cVar;
        this.e = c0707a;
        this.g = i;
        this.f = bVar2;
        com.opos.mobad.n.a a2 = dVar.a(activity, c0707a.b, bVar2);
        this.d = a2;
        this.b = new com.opos.mobad.q.a.c(activity, str, aVar, a2, new com.opos.mobad.q.a.d(activity), new com.opos.mobad.o.a.a(activity, null), this.h);
        this.f26252a.a(new com.opos.mobad.q.a.b.a() { // from class: com.opos.mobad.interstitial.d.1
            @Override // com.opos.mobad.q.a.b.a
            public void a() {
                d.this.b.g();
            }
        });
    }

    @Override // com.opos.mobad.interstitial.a
    public void a() {
        com.opos.mobad.activity.webview.b bVar = this.f;
        if (bVar != null) {
            bVar.d();
        }
        this.f26252a.a();
        this.b.c();
    }

    @Override // com.opos.mobad.interstitial.a
    public boolean a(Activity activity) {
        boolean a2 = this.b.a(this.e.b, this.e.f26483c, this.g, (g) null);
        if (a2) {
            this.f26252a.a(activity, this.d.c());
        }
        return a2;
    }
}
