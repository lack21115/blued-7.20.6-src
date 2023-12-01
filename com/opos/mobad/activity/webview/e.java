package com.opos.mobad.activity.webview;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.mobad.activity.webview.b;
import com.opos.mobad.activity.webview.c;
import com.opos.mobad.cmn.a.b.f;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/activity/webview/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private Activity f25660a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private c f25661c;
    private com.opos.mobad.activity.a d;
    private WebDataHepler e;
    private com.opos.mobad.activity.webview.b.d f;
    private MaterialData g;
    private b.a i;
    private int h = 0;
    private b.InterfaceC0687b j = new b.InterfaceC0687b() { // from class: com.opos.mobad.activity.webview.e.2
        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0687b
        public void a(AdItemData adItemData, String str) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "notifyInstallCompletedEvent pkgName =" + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            e.this.a(200, 100, "", str, (String) null);
            com.opos.mobad.cmn.service.a.a.a(e.this.b).c(str);
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0687b
        public void b(AdItemData adItemData, String str) {
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0687b
        public void c(AdItemData adItemData, String str) {
        }
    };
    private com.opos.mobad.cmn.service.a.c k = new com.opos.mobad.cmn.service.a.c() { // from class: com.opos.mobad.activity.webview.e.3
        @Override // com.opos.mobad.cmn.service.a.c
        public void a(int i, int i2, String str, String str2) {
            e.this.a(i, i2, str, str2, (String) null);
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void a(int i, int i2, String str, String str2, String str3) {
            e.this.a(i, i2, str, str2, str3);
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void b(int i, int i2, String str, String str2) {
            e.this.a(i, i2, str, str2, (String) null);
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void c(int i, int i2, String str, String str2) {
            e.this.a(i, i2, str, str2, (String) null);
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void d(int i, int i2, String str, String str2) {
            e.this.a(i, i2, str, str2, (String) null);
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void e(int i, int i2, String str, String str2) {
            e.this.a(i, i2, str, str2, (String) null);
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void f(int i, int i2, String str, String str2) {
            e.this.a(i, i2, str, str2, (String) null);
        }
    };
    private c.a l = new c.a() { // from class: com.opos.mobad.activity.webview.e.4
        @Override // com.opos.mobad.activity.webview.c.a
        public void a() {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onUserClose");
            if (e.this.i != null) {
                e.this.i.a();
            }
            if (e.this.h == 1) {
                e.this.c();
            }
        }

        @Override // com.opos.mobad.activity.webview.c.a
        public void a(boolean z) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onViewVisible = " + z);
            if (e.this.h == 4) {
                return;
            }
            if (!z) {
                if (e.this.h == 1) {
                    e.this.c();
                }
            } else if (e.this.h != 3) {
                e eVar = e.this;
                eVar.a(eVar.e.a(), e.this.e.e());
            }
        }

        @Override // com.opos.mobad.activity.webview.c.a
        public void b() {
            if (e.this.f != null) {
                e.this.f.d();
            }
        }

        @Override // com.opos.mobad.activity.webview.c.a
        public void c() {
            if (e.this.f != null) {
                e.this.f.e();
                if (e.this.e.g() == 2) {
                    ((com.opos.mobad.activity.webview.b.c) e.this.f).f_();
                }
                e.this.f = null;
            }
        }
    };
    private com.opos.mobad.o.b.d m = new com.opos.mobad.o.b.d() { // from class: com.opos.mobad.activity.webview.e.5
        @Override // com.opos.mobad.o.b.d
        public void a() {
        }

        @Override // com.opos.mobad.o.b.d
        public void a(int i, String str) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onVideoPlayError code: " + i + ",errMsg: " + str);
            if (e.this.f == null || !(e.this.f instanceof com.opos.mobad.activity.webview.b.c)) {
                return;
            }
            ((com.opos.mobad.activity.webview.b.c) e.this.f).a(i, str);
        }

        @Override // com.opos.mobad.o.b.d
        public void a(long j) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "videoUserPlayPause ");
            e.this.h = 3;
        }

        @Override // com.opos.mobad.o.b.d
        public void a(View view, AdItemData adItemData) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onVideoPlayStart");
            e.this.h = 1;
            if (e.this.f == null || !(e.this.f instanceof com.opos.mobad.activity.webview.b.c)) {
                return;
            }
            ((com.opos.mobad.activity.webview.b.c) e.this.f).b();
        }

        @Override // com.opos.mobad.o.b.d
        public void a(View view, AdItemData adItemData, long j) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onVideoPlayPause");
            if (e.this.f != null && (e.this.f instanceof com.opos.mobad.activity.webview.b.c)) {
                ((com.opos.mobad.activity.webview.b.c) e.this.f).b(j);
            }
            if (e.this.h != 3) {
                e.this.h = 2;
            } else if (e.this.f == null || !(e.this.f instanceof com.opos.mobad.activity.webview.b.c)) {
            } else {
                ((com.opos.mobad.activity.webview.b.c) e.this.f).c(j);
            }
        }

        @Override // com.opos.mobad.o.b.d
        public void a(View view, int[] iArr, long j, com.opos.mobad.cmn.a.b.a aVar) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onVideoClick");
        }

        @Override // com.opos.mobad.o.b.d
        public void b(View view, AdItemData adItemData) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onVideoPlayComplete");
            if (e.this.f == null || !(e.this.f instanceof com.opos.mobad.activity.webview.b.c)) {
                return;
            }
            ((com.opos.mobad.activity.webview.b.c) e.this.f).c();
        }

        @Override // com.opos.mobad.o.b.d
        public void b(View view, AdItemData adItemData, long j) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onVideoPlayResume");
            e.this.h = 1;
        }

        @Override // com.opos.mobad.o.b.d
        public void c(View view, AdItemData adItemData, long j) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onVideoPlayProgress currentPosition:" + j);
            if (e.this.f == null || !(e.this.f instanceof com.opos.mobad.activity.webview.b.c)) {
                return;
            }
            ((com.opos.mobad.activity.webview.b.c) e.this.f).a(j);
        }
    };

    public e(Activity activity, c cVar) {
        this.f25660a = activity;
        this.b = com.opos.mobad.service.b.a(activity.getApplicationContext());
        this.f25661c = cVar;
        cVar.a(this.l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, String str, String str2, String str3) {
        String str4;
        if (this.h == 4) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("dlUrl", str);
            jSONObject.put("dlPkgName", str2);
            jSONObject.put("dlStatus", i);
            if (str3 != null) {
                jSONObject.put("dlErrorCode", str3);
            }
            jSONObject.put("dlProcess", i2);
            str4 = jSONObject.toString();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("WebViewPresenter", "", (Throwable) e);
            str4 = "";
        }
        a("javascript:onActionDownloader(" + str4 + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdItemData adItemData, String str) {
        com.opos.mobad.activity.a aVar = this.d;
        if (aVar != null) {
            aVar.a(adItemData, str);
        }
    }

    private void a(MaterialData materialData) {
        if (f.a(materialData)) {
            com.opos.mobad.cmn.service.a.a.a(this.b).a(com.opos.mobad.service.f.b().d(), com.opos.mobad.service.f.b().e());
        }
    }

    private void a(boolean z) {
        com.opos.mobad.activity.a aVar = this.d;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, String str3, String str4) {
        com.opos.mobad.cmn.service.pkginstall.b.a(this.b).a(str2, this.j);
        com.opos.mobad.cmn.service.a.a.a(this.b).a(str, str2, str3, str4, this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.opos.mobad.activity.a aVar;
        int i = this.h;
        if ((i == 2 && i == 3) || (aVar = this.d) == null) {
            return;
        }
        aVar.Q();
    }

    public com.opos.mobad.cmn.service.a.b a(String str, String str2) {
        return com.opos.cmn.an.h.d.a.d(this.b, str2) ? new com.opos.mobad.cmn.service.a.b(200, 100) : com.opos.mobad.cmn.service.a.a.a(this.b).a(str, str2);
    }

    public void a() {
        this.f25661c.a();
    }

    public void a(WebDataHepler webDataHepler) {
        this.e = webDataHepler;
        if (webDataHepler.a() != null && this.e.a().i() != null && this.e.a().i().size() > 0) {
            this.g = this.e.a().i().get(0);
        }
        if (this.e.g() == 2) {
            FrameLayout frameLayout = new FrameLayout(this.b);
            this.d = new com.opos.mobad.activity.a(this.b, this.m, frameLayout);
            this.f25661c.a(frameLayout);
        }
        a(this.g);
        a(this.e.d());
    }

    public void a(b.a aVar) {
        this.i = aVar;
    }

    public void a(com.opos.mobad.activity.webview.b.d dVar) {
        this.f = dVar;
    }

    public void a(String str) {
        this.f25661c.a(str);
    }

    public void a(final String str, final String str2, final String str3, final String str4) {
        if (this.f25660a == null || !f.j() || "WIFI".equalsIgnoreCase(com.opos.cmn.an.h.c.a.f(this.b))) {
            b(str, str2, str3, str4);
            return;
        }
        final com.opos.cmn.e.a.b.a aVar = new com.opos.cmn.e.a.b.a(this.f25660a);
        aVar.a("当前为非Wi-Fi环境，\n是否继续下载？", "取消", "下载", new com.opos.cmn.e.a.b.c.a() { // from class: com.opos.mobad.activity.webview.e.1
            @Override // com.opos.cmn.e.a.b.c.a
            public void a(View view, int[] iArr) {
                aVar.a();
            }

            @Override // com.opos.cmn.e.a.b.c.a
            public void b(View view, int[] iArr) {
                e.this.b(str, str2, str3, str4);
                f.a(false);
                aVar.a();
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005a, code lost:
        if (r3.e.g() == 1) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(int r4, android.view.KeyEvent r5) {
        /*
            r3 = this;
            r0 = 0
            r7 = r0
            r0 = r4
            if (r0 == 0) goto L44
            r0 = r4
            r1 = 4
            if (r0 == r1) goto L44
            r0 = r4
            r1 = 24
            if (r0 == r1) goto L2f
            r0 = r4
            r1 = 25
            if (r0 == r1) goto L1a
            r0 = 0
            return r0
        L1a:
            r0 = r7
            r6 = r0
            r0 = r3
            com.opos.mobad.activity.webview.WebDataHepler r0 = r0.e
            int r0 = r0.g()
            r1 = 2
            if (r0 != r1) goto L78
            r0 = r3
            r1 = 1
            r0.a(r1)
            r0 = 0
            return r0
        L2f:
            r0 = r7
            r6 = r0
            r0 = r3
            com.opos.mobad.activity.webview.WebDataHepler r0 = r0.e
            int r0 = r0.g()
            r1 = 2
            if (r0 != r1) goto L78
            r0 = r3
            r1 = 0
            r0.a(r1)
            r0 = 0
            return r0
        L44:
            r0 = r3
            com.opos.mobad.activity.webview.WebDataHepler r0 = r0.e
            int r0 = r0.g()
            r1 = 2
            if (r0 == r1) goto L5d
            r0 = r7
            r6 = r0
            r0 = r3
            com.opos.mobad.activity.webview.WebDataHepler r0 = r0.e
            int r0 = r0.g()
            r1 = 1
            if (r0 != r1) goto L78
        L5d:
            r0 = r7
            r6 = r0
            r0 = r4
            r1 = 4
            if (r0 != r1) goto L78
            r0 = r7
            r6 = r0
            r0 = r5
            int r0 = r0.getAction()
            if (r0 != 0) goto L78
            r0 = r3
            com.opos.mobad.activity.webview.c r0 = r0.f25661c
            r0.b()
            r0 = 1
            r6 = r0
        L78:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.activity.webview.e.a(int, android.view.KeyEvent):boolean");
    }

    public void b() {
        this.h = 4;
        a();
        com.opos.mobad.activity.a aVar = this.d;
        if (aVar != null) {
            aVar.b();
        }
        com.opos.mobad.cmn.service.a.a.a(this.b).a(this.k);
        com.opos.mobad.cmn.service.pkginstall.b.a(this.b).a(this.j);
        this.f25660a = null;
    }

    public void b(String str) {
        com.opos.mobad.cmn.service.a.a.a(this.b).a(str);
    }

    public void c(String str) {
        com.opos.mobad.cmn.service.a.a.a(this.b).b(str);
    }
}
