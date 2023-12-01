package com.kwad.components.ad.fullscreen.b;

import android.view.View;
import com.kwad.components.ad.reward.d.f;
import com.kwad.components.ad.reward.d.h;
import com.kwad.components.ad.reward.d.l;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.a.d.e;
import com.kwad.components.core.webview.a.j;
import com.kwad.sdk.R;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/fullscreen/b/c.class */
public final class c extends com.kwad.components.ad.reward.presenter.a implements h {
    private View gE;
    private View gF;
    private e gG = new e() { // from class: com.kwad.components.ad.fullscreen.b.c.1
        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-top-bar", c.this.qt.mAdTemplate).equals(str) || j.b("ksad-fullscreen-video-card", c.this.qt.mAdTemplate).equals(str)) {
                c.this.bY();
            }
        }
    };
    private f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.fullscreen.b.c.2
        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            c.this.i(false);
        }
    };

    public c() {
        a(new com.kwad.components.ad.fullscreen.b.kwai.e());
        a(new com.kwad.components.ad.fullscreen.b.a.a());
        a(new com.kwad.components.ad.fullscreen.b.b.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY() {
        this.gE.setVisibility(0);
        this.gF.setVisibility(8);
    }

    private void bZ() {
        if (this.qt.ph || this.qt.pg) {
            return;
        }
        this.gE.setVisibility(0);
        this.gF.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z) {
        if ((this.qt.ph || this.qt.pg) && !z) {
            this.gE.setVisibility(8);
            this.gF.setVisibility(8);
            return;
        }
        this.gE.setVisibility(8);
        this.gF.setVisibility(0);
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void a(PlayableSource playableSource, l lVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        int i;
        View view;
        super.ar();
        this.qt.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.b.ff().a(this);
        if (com.kwad.components.ad.reward.j.c(this.qt) || com.kwad.components.ad.reward.j.a(this.qt)) {
            com.kwad.components.core.webview.a.c.a.rn().a(this.gG);
            i = 8;
            this.gE.setVisibility(8);
            view = this.gF;
        } else {
            view = this.gE;
            i = 0;
        }
        view.setVisibility(i);
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void ca() {
        bZ();
        if (this.qt.pg && this.gF.getVisibility() == 0) {
            this.gF.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void cb() {
        i(true);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.gE = findViewById(R.id.ksad_play_detail_top_toolbar);
        this.gF = findViewById(R.id.ksad_play_end_top_toolbar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.a.c.a.rn().b(this.gG);
        this.qt.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.b.ff().b(this);
    }
}
