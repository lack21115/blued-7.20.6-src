package com.opos.mobad.activity.webview.a;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.activity.webview.WebDataHepler;
import com.opos.mobad.activity.webview.b;
import com.opos.mobad.activity.webview.e;
import com.opos.mobad.cmn.a.b.f;
import com.opos.mobad.cmn.a.d;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/activity/webview/a/a.class */
public class a implements com.opos.mobad.activity.webview.b.b {

    /* renamed from: a  reason: collision with root package name */
    private e f25632a;
    private AdItemData b;

    /* renamed from: c  reason: collision with root package name */
    private MaterialData f25633c;
    private d d;
    private volatile Context e;
    private WebDataHepler f;
    private b.a g;

    public a(Context context) {
        this.e = context;
    }

    private void a(String str, AdItemData adItemData) {
        b.InterfaceC0687b k = f.k();
        if (this.e == null) {
            return;
        }
        if (k == null) {
            com.opos.mobad.cmn.service.pkginstall.b.a(this.e).a(str, adItemData);
        } else {
            com.opos.mobad.cmn.service.pkginstall.b.a(this.e).a(str, k, adItemData);
        }
    }

    private void a(String str, String str2, String str3, String str4, String str5) {
        String str6;
        StringBuilder sb;
        if (com.opos.cmn.an.c.a.a(str) || this.d == null) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("downloadApk pkgName=");
        sb2.append(str);
        sb2.append(",posId=");
        sb2.append(str2);
        sb2.append(",channelPkg=");
        sb2.append(str3 != null ? str3 : com.igexin.push.core.b.l);
        sb2.append(",trackContent=");
        sb2.append(str4 != null ? str4 : com.igexin.push.core.b.l);
        sb2.append(",trackReference=");
        String str7 = com.igexin.push.core.b.l;
        if (str5 != null) {
            str7 = str5;
        }
        sb2.append(str7);
        com.opos.cmn.an.f.a.b("AdJsListener", sb2.toString());
        if (this.e != null) {
            d dVar = this.d;
            Context context = this.e;
            MaterialData materialData = this.f25633c;
            if (dVar.a(context, str, str2, str3, materialData != null ? materialData.q() : "", str4, str5)) {
                a(str, this.b);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("downloadApk pkgName");
                sb3.append(str);
                sb = sb3;
                str6 = " = true";
                sb.append(str6);
                com.opos.cmn.an.f.a.b("AdJsListener", sb.toString());
            }
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("downloadApk pkgName=");
        sb4.append(str);
        str6 = " = false";
        sb = sb4;
        sb.append(str6);
        com.opos.cmn.an.f.a.b("AdJsListener", sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("loadUrl=");
            sb.append(str != null ? str : com.igexin.push.core.b.l);
            com.opos.cmn.an.f.a.b("AdJsListener", sb.toString());
            if (com.opos.cmn.an.c.a.a(str) || this.f25632a == null) {
                return;
            }
            this.f25632a.a(str);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("AdJsListener", "", (Throwable) e);
        }
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public int a() {
        return f.h();
    }

    public void a(b.a aVar) {
        this.g = aVar;
    }

    public void a(e eVar, WebDataHepler webDataHepler, d dVar) {
        this.f25632a = eVar;
        this.f = webDataHepler;
        AdItemData a2 = webDataHepler.a();
        this.b = a2;
        this.f25633c = a2.i().get(0);
        this.d = dVar;
    }

    public void a(String str) {
        if (this.e != null && !com.opos.cmn.an.c.a.a(str)) {
            try {
                com.opos.mobad.d.b.b.a(this.e, com.opos.cmn.d.a.a(this.e, str));
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("AdJsListener", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("AdJsListener", "installDownloaderApk Url=" + str);
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public void a(String str, String str2, String str3, String str4, int i) {
        com.opos.cmn.an.f.a.b("AdJsListener", "actionDownload pkgName :" + str2 + ",actionType:" + i + ",url:" + str);
        if (this.f25632a == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        switch (i) {
            case 1:
            case 3:
                a(str2, this.b);
                this.f25632a.a(str, str2, str3, str4);
                return;
            case 2:
                this.f25632a.b(str);
                return;
            case 4:
                this.f25632a.c(str);
                return;
            case 5:
                a(str);
                return;
            case 6:
                c(str2);
                return;
            default:
                return;
        }
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public void a(String str, boolean z) {
        try {
            a(str, z, null, null);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("AdJsListener", "", e);
        }
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public void a(String str, boolean z, String str2, String str3) {
        try {
            if (this.f != null) {
                a(str, this.f.b(), this.f25633c.t(), str2, str3);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("AdJsListener", "", e);
        }
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public boolean a(String str, String str2) {
        return this.d.a(this.e, this.b.Z(), str, str2);
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public String b() {
        return f.g();
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public void b(String str, final String str2) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("launchInstant instantUrl=");
            sb.append(str != null ? str : com.igexin.push.core.b.l);
            com.opos.cmn.an.f.a.b("AdJsListener", sb.toString());
            if (this.e == null || com.opos.cmn.an.c.a.a(str) || this.d == null || com.opos.cmn.an.c.a.a(this.f.a().d()) || com.opos.cmn.an.c.a.a(this.f.a().e())) {
                com.opos.mobad.c.b.b.b(new Runnable() { // from class: com.opos.mobad.activity.webview.a.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.d(str2);
                        com.opos.cmn.an.f.a.b("AdJsListener", "launchInstant open instant fail.open web");
                    }
                });
            } else {
                this.d.a(this.e, this.f.a().d(), this.f.a().e(), str, new d.a() { // from class: com.opos.mobad.activity.webview.a.a.1
                    @Override // com.opos.mobad.cmn.a.d.a
                    public void a() {
                        com.opos.cmn.an.f.a.b("AdJsListener", "launchInstant open instant success.");
                    }

                    @Override // com.opos.mobad.cmn.a.d.a
                    public void a(int i, String str3) {
                        com.opos.mobad.c.b.b.b(new Runnable() { // from class: com.opos.mobad.activity.webview.a.a.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.d(str2);
                                com.opos.cmn.an.f.a.b("AdJsListener", "launchInstant open instant fail.open web");
                            }
                        });
                    }
                }, this.f25633c.q());
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("AdJsListener", "", (Throwable) e);
        }
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public boolean b(String str) {
        return c(str);
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public String c(String str, String str2) {
        if (this.f25632a == null) {
            return "";
        }
        String str3 = "";
        if (!TextUtils.isEmpty(str)) {
            str3 = "";
            if (!TextUtils.isEmpty(str2)) {
                com.opos.mobad.cmn.service.a.b a2 = this.f25632a.a(str, str2);
                if (a2 != null && a2.f25920a == 102) {
                    this.f25632a.a(str, str2, "", "");
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("dlStatus", a2 != null ? a2.f25920a : 0);
                    int i = 0;
                    if (a2 != null) {
                        i = a2.b;
                    }
                    jSONObject.put("dlProcess", i);
                    str3 = jSONObject.toString();
                } catch (JSONException e) {
                    com.opos.cmn.an.f.a.a("AdJsListener", "", (Throwable) e);
                    str3 = "";
                }
            }
        }
        com.opos.cmn.an.f.a.b("AdJsListener", "getDownloaderStatus :" + str3);
        return str3;
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public void c() {
        try {
            if (this.f25632a != null) {
                this.f25632a.a();
            }
            if (this.g != null) {
                this.g.a();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("AdJsListener", "", e);
        }
    }

    public boolean c(String str) {
        boolean z;
        d dVar;
        if (com.opos.cmn.an.c.a.a(str) || this.e == null || (dVar = this.d) == null) {
            z = false;
        } else {
            boolean a2 = dVar.a(this.e, str);
            z = a2;
            if (a2) {
                z = a2;
                if (this.f.a().x()) {
                    f.k().c(this.f.a(), str);
                    return a2;
                }
            }
        }
        return z;
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public String d() {
        WebDataHepler webDataHepler = this.f;
        return webDataHepler == null ? "" : webDataHepler.b();
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public void d(String str, String str2) {
        if (com.opos.cmn.an.c.a.a(str) || this.d == null || this.e == null || !this.d.d(this.e, str)) {
            return;
        }
        a(str2, this.b);
        com.opos.cmn.an.f.a.b("AdJsListener", "launchMarketDeeplinkDLApk pkgName" + str2 + " = true");
    }

    public void e() {
        this.e = null;
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public void e(String str, String str2) {
        if (com.opos.cmn.an.c.a.a(str) || this.d == null || this.e == null || !this.d.e(this.e, str)) {
            return;
        }
        a(str2, this.b);
        com.opos.cmn.an.f.a.b("AdJsListener", "launchMarketDeeplinkDLApk pkgName" + str2 + " = true");
    }
}
