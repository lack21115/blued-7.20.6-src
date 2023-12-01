package com.kwad.components.ad.fullscreen.b.b;

import android.widget.FrameLayout;
import com.kwad.components.ad.reward.d.f;
import com.kwad.components.ad.reward.d.h;
import com.kwad.components.ad.reward.d.l;
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.presenter.f.c;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/fullscreen/b/b/a.class */
public final class a extends c implements h {
    private FrameLayout hw;
    private final f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.fullscreen.b.b.a.1
        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            if (com.kwad.sdk.core.response.a.a.al(d.cb(a.this.qt.mAdTemplate))) {
                a.this.hw.setVisibility(8);
            }
        }
    };

    @Override // com.kwad.components.ad.reward.d.h
    public final void a(PlayableSource playableSource, l lVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (ck()) {
            this.hw.setVisibility(0);
            this.qt.b(this.mPlayEndPageListener);
            com.kwad.components.ad.reward.b.ff().a(this);
        }
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void ca() {
        if (this.qt.ph) {
            this.hw.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void cb() {
        AdInfo cb = d.cb(this.qt.mAdTemplate);
        if (!this.qt.ph || com.kwad.sdk.core.response.a.a.al(cb)) {
            return;
        }
        this.hw.setVisibility(0);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c
    public final boolean ck() {
        return j.c(this.qt) && !this.qt.oN.jF();
    }

    @Override // com.kwad.components.core.webview.a.i
    public final FrameLayout getTKContainer() {
        return this.hw;
    }

    @Override // com.kwad.components.core.webview.a.i
    public final String getTkTemplateId() {
        return com.kwad.components.core.webview.a.j.b("ksad-video-top-bar", this.qt.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.hw = (FrameLayout) findViewById(R.id.ksad_js_top);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onGetContainerLimited(u.a aVar) {
        aVar.width = (int) ((com.kwad.sdk.c.kwai.a.getScreenWidth(getContext()) / com.kwad.sdk.c.kwai.a.ax(getContext())) + 0.5f);
        aVar.height = 44;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void onTkLoadFailed() {
        super.onTkLoadFailed();
        this.qt.ph = false;
        this.hw.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (ck()) {
            this.qt.c(this.mPlayEndPageListener);
            com.kwad.components.ad.reward.b.ff().b(this);
        }
    }
}
