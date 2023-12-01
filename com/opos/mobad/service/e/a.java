package com.opos.mobad.service.e;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.opos.cmn.ac.AcTools;
import com.opos.cmn.an.b.c;
import com.opos.cmn.an.b.e;
import com.opos.cmn.g.a.b;
import com.opos.cmn.i.a;
import com.opos.mobad.provider.openId.IdModelIdentify;
import com.opos.mobad.provider.openId.OpenIdData;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/e/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f27334a;
    private volatile com.opos.mobad.provider.openId.a b;

    /* renamed from: c  reason: collision with root package name */
    private Context f27335c;
    private com.opos.cmn.i.a i;
    private com.opos.cmn.i.a j;
    private com.opos.cmn.i.a k;
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "";
    private String h = "";
    private boolean l = true;
    private boolean m = true;
    private String n = "";
    private volatile String o = "";
    private volatile boolean p = false;

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.opos.mobad.provider.openId.a a(Context context) {
        com.opos.mobad.provider.openId.a aVar;
        com.opos.mobad.provider.openId.a aVar2 = this.b;
        if (aVar2 == null) {
            synchronized (a.class) {
                try {
                    com.opos.mobad.provider.openId.a aVar3 = this.b;
                    aVar = aVar3;
                    if (aVar3 == null) {
                        aVar = new com.opos.mobad.provider.openId.a(context.getApplicationContext(), new IdModelIdentify(com.opos.cmn.a.a.a(), com.opos.cmn.a.a.b()));
                        this.b = aVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return aVar;
        }
        return aVar2;
    }

    public static a a() {
        a aVar;
        a aVar2 = f27334a;
        if (aVar2 == null) {
            synchronized (a.class) {
                try {
                    a aVar3 = f27334a;
                    aVar = aVar3;
                    if (aVar3 == null) {
                        aVar = new a();
                        f27334a = aVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return aVar;
        }
        return aVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006c, code lost:
        if (r8 != null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String b(android.content.Context r6) {
        /*
            r5 = this;
            r0 = r6
            android.content.ContentResolver r0 = r0.getContentResolver()
            r8 = r0
            java.lang.String r0 = "content://mk_ex"
            android.net.Uri r0 = android.net.Uri.parse(r0)
            r11 = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r7 = r0
            java.lang.String r0 = ""
            r6 = r0
            r0 = r6
            r9 = r0
            r0 = r7
            r1 = 26
            if (r0 <= r1) goto L91
            r0 = 0
            r10 = r0
            r0 = 0
            r9 = r0
            r0 = r8
            r1 = r11
            android.content.ContentProviderClient r0 = r0.acquireUnstableContentProviderClient(r1)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L94
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L68
            r0 = r8
            java.lang.String r1 = "query_vaid"
            r2 = 0
            r3 = 0
            android.os.Bundle r0 = r0.call(r1, r2, r3)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L54
            java.lang.String r1 = "vaid_result"
            java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L54
            r10 = r0
            r0 = r10
            r9 = r0
            r0 = r8
            if (r0 == 0) goto L91
            r0 = r10
            r6 = r0
        L47:
            r0 = r6
            r9 = r0
            r0 = r8
            r0.close()     // Catch: java.lang.Throwable -> L9b
            r0 = r6
            return r0
        L50:
            r6 = move-exception
            goto L62
        L54:
            r9 = move-exception
            java.lang.String r0 = "IdentityIdManager"
            java.lang.String r1 = ""
            r2 = r9
            com.opos.cmn.an.f.a.b(r0, r1, r2)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L9f
            goto L68
        L62:
            goto L76
        L65:
            goto L80
        L68:
            r0 = r6
            r9 = r0
            r0 = r8
            if (r0 == 0) goto L91
            goto L47
        L72:
            r6 = move-exception
            r0 = r9
            r8 = r0
        L76:
            r0 = r8
            if (r0 == 0) goto L7e
            r0 = r8
            r0.close()     // Catch: java.lang.Throwable -> La4
        L7e:
            r0 = r6
            throw r0
        L80:
            r0 = r6
            r9 = r0
            r0 = r8
            if (r0 == 0) goto L91
            r0 = r6
            r9 = r0
            r0 = r8
            r0.close()     // Catch: java.lang.Throwable -> L9b
            r0 = r6
            r9 = r0
        L91:
            r0 = r9
            return r0
        L94:
            r8 = move-exception
            r0 = r10
            r8 = r0
            goto L80
        L9b:
            r6 = move-exception
            r0 = r9
            return r0
        L9f:
            r9 = move-exception
            goto L65
        La4:
            r8 = move-exception
            goto L7e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.service.e.a.b(android.content.Context):java.lang.String");
    }

    private void o() {
        if (this.f27335c == null) {
            return;
        }
        this.k.a();
    }

    private void p() {
        if (TextUtils.isEmpty(this.d) && TextUtils.isEmpty(this.e) && this.f27335c != null) {
            this.i.a();
        }
    }

    private void q() {
        Context context = this.f27335c;
        if (context == null) {
            return;
        }
        if (b.e(context)) {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.e.a.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a.this.l = a.this.a(a.this.f27335c).b();
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.a("IdentityIdManager", "update status error" + e);
                    }
                }
            });
        } else {
            this.l = true;
        }
    }

    private void r() {
        if (TextUtils.isEmpty(this.h) && this.f27335c != null && s() && t()) {
            this.j.a();
        }
    }

    private boolean s() {
        return c.b() < 29;
    }

    private boolean t() {
        return com.opos.cmn.an.h.d.a.a(this.f27335c, "android.permission.READ_PHONE_STATE") || com.opos.cmn.an.h.d.a.a(this.f27335c, "android.permission.READ_EXTERNAL_STORAGE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OpenIdData u() {
        com.opos.cmn.an.f.a.b("IdentityIdManager", "start getOpenId");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            OpenIdData a2 = a(this.f27335c).a();
            if (a2 == null) {
                com.opos.cmn.an.f.a.b("IdentityIdManager", "openIdData == null");
                return null;
            }
            String str = a2.f27120a;
            if (!TextUtils.isEmpty(str)) {
                this.d = str;
            }
            String str2 = a2.f27121c;
            if (!TextUtils.isEmpty(str2)) {
                this.f = str2;
            }
            String str3 = a2.b;
            if (!TextUtils.isEmpty(str3)) {
                this.e = str3;
            }
            com.opos.cmn.an.f.a.b("IdentityIdManager", "getOpenId cost time = " + (SystemClock.elapsedRealtime() - elapsedRealtime));
            return a2;
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String v() {
        com.opos.cmn.an.f.a.b("IdentityIdManager", "start getCryptClientId");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            String c2 = a(this.f27335c).c();
            if (TextUtils.isEmpty(c2)) {
                com.opos.cmn.an.f.a.b("IdentityIdManager", "clientIdData == null");
                return null;
            }
            this.h = c2;
            com.opos.cmn.an.f.a.b("IdentityIdManager", "getCryptClientId cost time = " + (SystemClock.elapsedRealtime() - elapsedRealtime));
            return this.h;
        } catch (Exception e) {
            return null;
        }
    }

    public void a(Context context, boolean z) {
        this.f27335c = context.getApplicationContext();
        this.p = z;
        this.i = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.e.a.1
            @Override // com.opos.cmn.i.a.b
            public void a(final a.InterfaceC0645a interfaceC0645a) {
                com.opos.cmn.an.f.a.b("IdentityIdManager", "init");
                com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.e.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!b.e(a.this.f27335c)) {
                                com.opos.cmn.an.f.a.a("IdentityIdManager", "unsupport id");
                            } else if (a.this.u() == null) {
                                com.opos.cmn.an.f.a.b("IdentityIdManager", "openIdData == null");
                                if (interfaceC0645a != null) {
                                    interfaceC0645a.b();
                                    return;
                                }
                                return;
                            } else {
                                com.opos.cmn.an.f.a.b("IdentityIdManager", "init succ");
                            }
                            String b = a.this.b(a.this.f27335c);
                            if (!TextUtils.isEmpty(b)) {
                                a.this.g = b;
                            }
                            a.this.b();
                            a.this.c();
                            interfaceC0645a.a();
                        } catch (Exception e) {
                            com.opos.cmn.an.f.a.a("IdentityIdManager", "init error" + e);
                            interfaceC0645a.b();
                        }
                    }
                });
            }
        }, Integer.MAX_VALUE, 0);
        this.j = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.e.a.2
            @Override // com.opos.cmn.i.a.b
            public void a(final a.InterfaceC0645a interfaceC0645a) {
                com.opos.cmn.an.f.a.b("IdentityIdManager", "initClientId");
                com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.e.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!TextUtils.isEmpty(a.this.v())) {
                                com.opos.cmn.an.f.a.b("IdentityIdManager", "init clienitid succ");
                                interfaceC0645a.a();
                                return;
                            }
                            com.opos.cmn.an.f.a.b("IdentityIdManager", "clientIdData == null");
                            if (interfaceC0645a != null) {
                                interfaceC0645a.b();
                            }
                        } catch (Exception e) {
                            com.opos.cmn.an.f.a.a("IdentityIdManager", "init error" + e);
                            interfaceC0645a.b();
                        }
                    }
                });
            }
        }, Integer.MAX_VALUE, 0);
        this.k = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.e.a.3
            @Override // com.opos.cmn.i.a.b
            public void a(a.InterfaceC0645a interfaceC0645a) {
            }
        }, Integer.MAX_VALUE, 0);
        p();
        r();
        o();
    }

    public void a(boolean z) {
        this.m = z;
    }

    public String b() {
        return AcTools.isSoEnabled() ? AcTools.getBootMark() : "";
    }

    public String c() {
        return AcTools.isSoEnabled() ? AcTools.getUpdateMark() : "";
    }

    public boolean d() {
        com.opos.cmn.an.f.a.b("IdentityIdManager", "app status:" + this.m);
        return this.m;
    }

    public String e() {
        if (this.p) {
            return "";
        }
        String str = this.o;
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            Context context = this.f27335c;
            if (context == null) {
                return "";
            }
            try {
                str = e.a(context);
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.a("IdentityIdManager", "", th);
            }
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            this.o = str;
            str2 = str;
        }
        return str2;
    }

    public String f() {
        p();
        return this.d;
    }

    public String g() {
        p();
        return this.e;
    }

    public String h() {
        p();
        return this.f;
    }

    public String i() {
        p();
        return this.g;
    }

    public boolean j() {
        q();
        return this.l;
    }

    public String k() {
        r();
        return this.h;
    }

    public String l() {
        this.k.a();
        return this.n;
    }

    public String m() {
        return (TextUtils.isEmpty(this.h) && this.f27335c != null && s() && t()) ? v() : this.h;
    }

    public String n() {
        Context context;
        if (TextUtils.isEmpty(this.d) && TextUtils.isEmpty(this.e) && (context = this.f27335c) != null && b.e(context)) {
            u();
        }
        return this.d;
    }
}
