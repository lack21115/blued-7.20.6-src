package com.kwad.components.ad.splashscreen.b.kwai;

import com.kwad.components.core.webview.a.j;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/b/kwai/e.class */
public final class e extends com.kwad.components.ad.splashscreen.b.e {
    private com.kwad.components.core.webview.a.d.e gG = new com.kwad.components.core.webview.a.d.e() { // from class: com.kwad.components.ad.splashscreen.b.kwai.e.1
        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-splash-end-card", e.this.Cg.mAdTemplate).equals(str)) {
                e.this.a(new d(), true);
                e.this.a(new a(), true);
                e.this.a(new b(), true);
                e.this.a(new c(), true);
            }
        }
    };

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.components.core.webview.a.c.a.rn().a(this.gG);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.a.c.a.rn().b(this.gG);
    }
}
