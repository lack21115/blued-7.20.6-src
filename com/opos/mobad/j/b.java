package com.opos.mobad.j;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.activity.webview.b.d;
import com.opos.mobad.activity.webview.b.e;
import com.opos.mobad.cmn.a.a.a;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.e.a;
import com.opos.mobad.q.a.h;
import com.opos.mobad.q.a.l;
import com.opos.mobad.service.event.EventDescription;
import com.opos.mobad.service.event.c;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/j/b.class */
public class b implements a.InterfaceC0510a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12577a = b.class.getSimpleName();
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private String f12578c;
    private a.C0537a d;
    private com.opos.mobad.cmn.a.a f;
    private com.opos.mobad.ad.d.b g;
    private a.b h;
    private h i;
    private l j;
    private C0532b l;
    private c m;
    private c n;
    private boolean e = false;
    private d o = new d() { // from class: com.opos.mobad.j.b.1
        @Override // com.opos.mobad.activity.webview.b.d
        public void d() {
            if (b.this.e) {
                return;
            }
            b.this.g.e();
        }

        @Override // com.opos.mobad.activity.webview.b.d
        public void e() {
            if (b.this.e) {
                return;
            }
            if (b.this.n != null) {
                com.opos.mobad.service.event.b.a().b(b.this.n);
            }
            b.this.g.f();
            if (b.this.h != null) {
                b.this.h.d();
            }
        }
    };
    private a k = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/j/b$a.class */
    public class a implements b.InterfaceC0517b {
        private a() {
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0517b
        public void a(AdItemData adItemData, String str) {
            try {
                String str2 = b.f12577a;
                com.opos.cmn.an.f.a.b(str2, "notifyInstallCompletedEvent pkgName=" + str);
                if (b.this.e) {
                    return;
                }
                b.this.j.b(adItemData, str);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a(b.f12577a, "", (Throwable) e);
            }
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0517b
        public void b(AdItemData adItemData, String str) {
            b.this.j.a(adItemData, str);
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0517b
        public void c(AdItemData adItemData, String str) {
            b.this.j.a(adItemData, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.mobad.j.b$b  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/j/b$b.class */
    public class C0532b extends com.opos.mobad.q.a.e.a {

        /* renamed from: c  reason: collision with root package name */
        private boolean f12582c;

        private C0532b() {
            this.f12582c = false;
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void a(int i, String str) {
            if (b.this.e) {
                return;
            }
            b.this.g.a(i, str);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j) {
            if (b.this.e) {
                return;
            }
            b.this.g.a(j);
        }

        @Override // com.opos.mobad.q.a.e.a, com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0517b
        public void a(AdItemData adItemData, String str) {
            super.a(adItemData, str);
            b.this.j.b(adItemData, str);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            if (b.this.e) {
                return;
            }
            b.this.g.a(str);
        }

        @Override // com.opos.mobad.ad.h
        public void a(Object... objArr) {
            if (b.this.e) {
                return;
            }
            b.this.g.a(objArr);
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b() {
            if (b.this.e) {
                return;
            }
            this.f12582c = false;
            b.this.g.c();
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b(long j) {
            if (b.this.e) {
                return;
            }
            if (b.this.d != null && b.this.d.f12795c.T() == 0 && this.f12582c) {
                return;
            }
            b.this.g.b(j);
            if (b.this.h != null) {
                b.this.h.d();
            }
        }

        @Override // com.opos.mobad.q.a.e.a, com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0517b
        public void b(AdItemData adItemData, String str) {
            super.b(adItemData, str);
            b.this.j.a(adItemData, str);
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b(String str) {
            if (b.this.e) {
                return;
            }
            b.this.g.b(str);
        }

        @Override // com.opos.mobad.q.a.j.a
        public void c() {
            if (b.this.e) {
                return;
            }
            this.f12582c = true;
            b.this.g.d();
            b.this.d();
        }

        @Override // com.opos.mobad.q.a.e.a, com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0517b
        public void c(AdItemData adItemData, String str) {
            super.c(adItemData, str);
            b.this.j.a(adItemData, str);
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void d() {
        }

        @Override // com.opos.mobad.q.a.e.a
        public void e() {
            if (b.this.m != null) {
                com.opos.mobad.service.event.b.a().b(b.this.m);
            }
        }

        @Override // com.opos.mobad.q.a.a.InterfaceC0554a
        public void j_() {
        }

        public void l_() {
            this.f12582c = false;
        }
    }

    public b(Context context, String str, com.opos.mobad.ad.d.b bVar, com.opos.mobad.cmn.a.d dVar, h hVar) {
        this.b = context;
        this.f12578c = str;
        this.g = bVar;
        this.f = new com.opos.mobad.cmn.a.a(context, str, dVar);
        C0532b c0532b = new C0532b();
        this.l = c0532b;
        this.i = hVar;
        this.j = new l(this.b, c0532b);
    }

    private int a(a.C0537a c0537a) {
        int d = c0537a.f12795c.d();
        if (d != 10 && d != 12 && d != 14) {
            com.opos.cmn.an.f.a.b(f12577a, "illegal type");
            return 10409;
        } else if (1 != c0537a.b.r() && 2 != c0537a.b.r()) {
            com.opos.cmn.an.f.a.b(f12577a, "illegal mode");
            return 10407;
        } else if (c0537a.b.r() == 1 && TextUtils.isEmpty(com.opos.cmn.d.d.a(this.b, c0537a.d.a(), c0537a.d.b()))) {
            com.opos.cmn.an.f.a.b(f12577a, "illegal cache url");
            return 10408;
        } else if (!com.opos.cmn.an.h.c.a.d(this.b)) {
            com.opos.cmn.an.f.a.b(f12577a, "no net");
            return 10403;
        } else if (System.currentTimeMillis() > c0537a.b.s()) {
            com.opos.cmn.an.f.a.b(f12577a, "exp time");
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
        if (this.e) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("rsCode", "" + i);
        a.C0537a c0537a = this.d;
        if (c0537a == null) {
            context = this.b;
            str = this.f12578c;
            b = "";
            c2 = "";
            a2 = "";
        } else {
            hashMap.put("clientTemplateId", String.valueOf(c0537a.f12795c.b()));
            context = this.b;
            b = this.d.b.b();
            str = this.f12578c;
            c2 = this.d.b.c();
            a2 = this.d.b.a();
        }
        com.opos.mobad.cmn.a.b.d.a(context, b, str, "4", c2, a2, hashMap);
        a.b bVar = this.h;
        if (bVar != null) {
            bVar.a(i, com.opos.mobad.ad.a.a(i));
        }
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
                com.opos.cmn.an.f.a.a(f12577a, "", (Throwable) e);
                z = false;
            }
        }
        com.opos.cmn.an.f.a.b(f12577a, "hasVideoLandingPage =" + z);
        return z;
    }

    private boolean a(a.C0537a c0537a, int i, a.b bVar, boolean z) {
        try {
            this.h = bVar;
            if (c0537a == null) {
                a(10402);
                return false;
            }
            int a2 = a(c0537a);
            if (10000 != a2) {
                com.opos.cmn.an.f.a.b(f12577a, "illegal play video condition");
                a(a2);
                return false;
            }
            this.l.l_();
            this.d = c0537a;
            this.j.a(c0537a.b, c0537a.f12795c);
            EventDescription eventDescription = new EventDescription(c());
            this.m = com.opos.mobad.q.a.a.a.a(eventDescription, this.l);
            this.i.a(this.b, this.d.b, this.d.d, this.d.b.r(), z, i, eventDescription);
            return true;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a(f12577a, "", (Throwable) e);
            return false;
        }
    }

    private String c() {
        return this.f12578c + "_" + System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        a.C0537a c0537a = this.d;
        if (c0537a != null && c0537a.f12795c.T() == 0 && a(this.d.b) && this.d.f12795c.T() == 0) {
            EventDescription eventDescription = new EventDescription(c());
            this.n = e.a(eventDescription, this.o);
            this.f.a(this.d.b, true, (b.InterfaceC0517b) this.k, eventDescription);
        }
    }

    @Override // com.opos.mobad.cmn.a.a.a
    public void a() {
        this.e = true;
        this.j.e();
        com.opos.mobad.service.event.b.a().b(this.m);
        com.opos.mobad.service.event.b.a().b(this.n);
        com.opos.mobad.cmn.service.pkginstall.b.a(this.b).a(this.k);
    }

    @Override // com.opos.mobad.cmn.a.a.a.InterfaceC0510a
    public boolean a(a.C0537a c0537a, int i, a.b bVar) {
        return a(c0537a, i, bVar, false);
    }
}
