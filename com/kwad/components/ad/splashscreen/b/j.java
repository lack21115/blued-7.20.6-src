package com.kwad.components.ad.splashscreen.b;

import android.os.SystemClock;
import com.kwad.sdk.utils.bi;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/b/j.class */
public final class j extends e {
    private com.kwad.components.core.offline.api.a.b Cx;
    private long mLoadStartTime;
    private volatile boolean Cy = false;
    private com.kwad.components.core.webview.a.d.e gG = new com.kwad.components.core.webview.a.d.e() { // from class: com.kwad.components.ad.splashscreen.b.j.1
        @Override // com.kwad.components.core.webview.a.d.e
        public final void ad(String str) {
            if (com.kwad.components.core.webview.a.j.b("ksad-splash-play-card", j.this.Cg.mAdTemplate).equals(str)) {
                bi.b(j.this.Cz);
            }
        }

        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            j.this.Cg.BM = true;
            if (com.kwad.components.core.webview.a.j.b("ksad-splash-play-card", j.this.Cg.mAdTemplate).equals(str)) {
                j.this.kZ();
            }
        }
    };
    private final Runnable Cz = new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.j.2
        @Override // java.lang.Runnable
        public final void run() {
            if (!j.this.Cy) {
                j.this.kY();
                return;
            }
            j.this.Cg.BM = true;
            j.this.kZ();
        }
    };
    private com.kwad.components.core.offline.api.a.a CA = new com.kwad.components.core.offline.api.a.a() { // from class: com.kwad.components.ad.splashscreen.b.j.3
        @Override // com.kwad.components.core.offline.api.a.a
        public final void onSuccess() {
            com.kwad.components.splash.monitor.a.rY();
            com.kwad.components.splash.monitor.a.f(j.this.Cg.mAdTemplate, SystemClock.elapsedRealtime() - j.this.mLoadStartTime);
            j.this.kY();
        }
    };

    private void kX() {
        com.kwad.components.core.offline.api.a.b bVar = (com.kwad.components.core.offline.api.a.b) com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.a.b.class);
        this.Cx = bVar;
        if (bVar != null) {
            bVar.a(this.CA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kY() {
        if (this.Cy) {
            return;
        }
        this.Cy = true;
        if (com.kwad.sdk.core.response.a.b.cI(com.kwad.sdk.core.response.a.d.cb(this.Cg.mAdTemplate))) {
            bi.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.j.4
                @Override // java.lang.Runnable
                public final void run() {
                    j.this.a(new com.kwad.components.ad.splashscreen.b.a.a(), true);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kZ() {
        if (com.kwad.sdk.core.response.a.b.dd(com.kwad.sdk.core.response.a.d.cb(this.Cg.mAdTemplate))) {
            this.Cg.BL = true;
            bi.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.j.5
                @Override // java.lang.Runnable
                public final void run() {
                    j.this.a(new o(), true);
                }
            });
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (com.kwad.sdk.core.response.a.b.cI(com.kwad.sdk.core.response.a.d.cb(this.Cg.mAdTemplate))) {
            bi.runOnUiThreadDelay(this.Cz, com.kwad.sdk.core.response.a.b.cO(com.kwad.sdk.core.response.a.d.cb(this.Cg.mAdTemplate)));
            com.kwad.components.core.webview.a.c.a.rn().a(this.gG);
        }
        kX();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mLoadStartTime = SystemClock.elapsedRealtime();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.offline.api.a.b bVar = this.Cx;
        if (bVar != null) {
            bVar.b(this.CA);
        }
        if (com.kwad.sdk.core.response.a.b.cI(com.kwad.sdk.core.response.a.d.cb(this.Cg.mAdTemplate))) {
            bi.b(this.Cz);
            com.kwad.components.core.webview.a.c.a.rn().b(this.gG);
        }
    }
}
