package com.kwad.components.ad.draw.a.b;

import android.widget.FrameLayout;
import com.kwad.components.ad.i.b;
import com.kwad.sdk.R;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/draw/a/b/b.class */
public final class b extends com.kwad.components.ad.draw.kwai.a {
    private com.kwad.components.ad.i.b cp;
    private FrameLayout df;
    private com.kwad.sdk.core.webview.c.kwai.a mWebCardClickListener = new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.draw.a.b.b.1
        @Override // com.kwad.sdk.core.webview.c.kwai.a
        public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            if (b.this.bW.bV != null) {
                b.this.bW.bV.onAdClicked();
            }
        }
    };

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.components.ad.i.b bVar = this.bW.cp;
        this.cp = bVar;
        if (bVar == null) {
            return;
        }
        bVar.a(this.mWebCardClickListener);
        this.cp.a(this.df, this.bW.mRootContainer, this.bW.mAdTemplate, this.bW.mApkDownloadHelper);
        this.cp.a((b.InterfaceC0309b) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.df = (FrameLayout) findViewById(R.id.ksad_play_end_web_card_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.i.b bVar = this.cp;
        if (bVar != null) {
            bVar.jW();
        }
    }
}
