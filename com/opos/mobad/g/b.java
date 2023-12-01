package com.opos.mobad.g;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.opos.mobad.activity.webview.b.d;
import com.opos.mobad.activity.webview.b.e;
import com.opos.mobad.cmn.a.a.a;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.e.a;
import com.opos.mobad.q.a.h;
import com.opos.mobad.service.event.EventDescription;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/g/b.class */
public class b implements a.InterfaceC0680a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f26153a = b.class.getSimpleName();
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private String f26154c;
    private a.C0707a d;
    private com.opos.mobad.cmn.a.a e;
    private a f;
    private a.b g;
    private h h;
    private C0696b i = new C0696b();
    private c j = new c();
    private volatile boolean k;
    private com.opos.mobad.service.event.c l;
    private com.opos.mobad.service.event.c m;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/g/b$a.class */
    public interface a {
        void a();

        void b();

        void c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.mobad.g.b$b  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/g/b$b.class */
    public class C0696b extends com.opos.mobad.q.a.e.a {

        /* renamed from: c  reason: collision with root package name */
        private boolean f26156c;

        private C0696b() {
            this.f26156c = false;
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void a(int i, String str) {
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j) {
            if (b.this.k || b.this.f == null) {
                return;
            }
            b.this.f.a();
        }

        @Override // com.opos.mobad.q.a.e.a, com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0687b
        public void a(AdItemData adItemData, String str) {
            super.a(adItemData, str);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
        }

        @Override // com.opos.mobad.ad.h
        public void a(Object... objArr) {
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b() {
            if (b.this.k) {
                return;
            }
            this.f26156c = false;
            b.this.f.b();
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b(long j) {
            if (b.this.k) {
                return;
            }
            if (b.this.d != null && b.this.d.f26483c.T() == 0 && this.f26156c) {
                return;
            }
            b.this.g.d();
        }

        @Override // com.opos.mobad.q.a.e.a, com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0687b
        public void b(AdItemData adItemData, String str) {
            super.b(adItemData, str);
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b(String str) {
        }

        @Override // com.opos.mobad.q.a.j.a
        public void c() {
            if (b.this.k) {
                return;
            }
            this.f26156c = true;
            b.this.c();
            b.this.f.c();
        }

        @Override // com.opos.mobad.q.a.e.a, com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0687b
        public void c(AdItemData adItemData, String str) {
            super.c(adItemData, str);
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void d() {
        }

        @Override // com.opos.mobad.q.a.e.a
        public void e() {
            if (b.this.l != null) {
                com.opos.mobad.service.event.b.a().b(b.this.l);
            }
        }

        @Override // com.opos.mobad.q.a.a.InterfaceC0724a
        public void j_() {
        }

        public void k_() {
            this.f26156c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/g/b$c.class */
    public class c implements d {
        private c() {
        }

        @Override // com.opos.mobad.activity.webview.b.d
        public void d() {
        }

        @Override // com.opos.mobad.activity.webview.b.d
        public void e() {
            if (b.this.k) {
                return;
            }
            if (b.this.m != null) {
                com.opos.mobad.service.event.b.a().b(b.this.m);
            }
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.g.b.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.g != null) {
                        b.this.g.d();
                    }
                }
            });
        }
    }

    public b(Context context, String str, com.opos.mobad.cmn.a.d dVar, h hVar, a aVar) {
        this.b = context;
        this.f26154c = str;
        this.f = aVar;
        this.e = new com.opos.mobad.cmn.a.a(context, str, dVar);
        this.h = hVar;
    }

    private int a(a.C0707a c0707a) {
        int d = c0707a.f26483c.d();
        if (d != 10 && d != 12 && d != 14) {
            com.opos.cmn.an.f.a.b(f26153a, "illegal type");
            return 10409;
        } else if (1 != c0707a.b.r() && 2 != c0707a.b.r()) {
            com.opos.cmn.an.f.a.b(f26153a, "illegal mode");
            return 10407;
        } else if (c0707a.b.r() == 1 && TextUtils.isEmpty(com.opos.cmn.d.d.a(this.b, c0707a.d.a(), c0707a.d.b()))) {
            com.opos.cmn.an.f.a.b(f26153a, "illegal cache url");
            return 10408;
        } else if (!com.opos.cmn.an.h.c.a.d(this.b)) {
            com.opos.cmn.an.f.a.b(f26153a, "no net");
            return 10403;
        } else if (System.currentTimeMillis() > c0707a.b.s()) {
            com.opos.cmn.an.f.a.b(f26153a, "exp time");
            return 10404;
        } else {
            return 10000;
        }
    }

    private void a(int i) {
        Context context;
        String b;
        String str;
        String c2;
        String a2;
        if (this.k) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("rsCode", "" + i);
        a.C0707a c0707a = this.d;
        if (c0707a == null) {
            context = this.b;
            str = this.f26154c;
            b = "";
            c2 = "";
            a2 = "";
        } else {
            hashMap.put("clientTemplateId", String.valueOf(c0707a.f26483c.b()));
            context = this.b;
            b = this.d.b.b();
            str = this.f26154c;
            c2 = this.d.b.c();
            a2 = this.d.b.a();
        }
        com.opos.mobad.cmn.a.b.d.a(context, b, str, "4", c2, a2, hashMap);
        b(i);
    }

    private boolean a(AdItemData adItemData) {
        boolean z = false;
        if (adItemData != null) {
            z = false;
            try {
                if (adItemData.i() != null) {
                    z = false;
                    if (adItemData.i().size() > 0) {
                        z = false;
                        if (adItemData.i().get(0) != null) {
                            z = false;
                            if (!com.opos.cmn.an.c.a.a(adItemData.i().get(0).w())) {
                                z = true;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a(f26153a, "", (Throwable) e);
                z = false;
            }
        }
        com.opos.cmn.an.f.a.b(f26153a, "hasVideoLandingPage =" + z);
        return z;
    }

    private String b() {
        return this.f26154c + BridgeUtil.UNDERLINE_STR + System.currentTimeMillis();
    }

    private void b(int i) {
        a.b bVar = this.g;
        if (bVar != null) {
            bVar.a(i, com.opos.mobad.ad.a.a(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        a.C0707a c0707a = this.d;
        if (c0707a != null && c0707a.f26483c.T() == 0 && a(this.d.b) && this.d.f26483c.T() == 0) {
            EventDescription eventDescription = new EventDescription(b());
            this.m = e.a(eventDescription, this.j);
            this.e.a(this.d.b, true, (b.InterfaceC0687b) this.i, eventDescription);
        }
    }

    @Override // com.opos.mobad.cmn.a.a.a
    public void a() {
        this.k = true;
        com.opos.mobad.service.event.b.a().b(this.l);
        com.opos.mobad.service.event.b.a().b(this.m);
        this.f = null;
    }

    @Override // com.opos.mobad.cmn.a.a.a.InterfaceC0680a
    public boolean a(a.C0707a c0707a, int i, a.b bVar) {
        try {
            this.g = bVar;
            if (c0707a == null) {
                a(10402);
                return false;
            }
            int a2 = a(c0707a);
            if (10000 != a2) {
                a(a2);
                return false;
            }
            this.i.k_();
            this.e.a(c0707a.b);
            this.e.b(c0707a.b);
            this.d = c0707a;
            EventDescription eventDescription = new EventDescription(b());
            this.l = com.opos.mobad.q.a.a.a.a(eventDescription, this.i);
            this.h.a(this.b, this.d.b, this.d.d, this.d.b.r(), false, i, eventDescription);
            return true;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a(f26153a, "", (Throwable) e);
            return false;
        }
    }
}
