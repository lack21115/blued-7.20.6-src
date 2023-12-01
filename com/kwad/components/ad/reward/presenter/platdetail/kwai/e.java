package com.kwad.components.ad.reward.presenter.platdetail.kwai;

import android.view.View;
import android.widget.ImageView;
import com.kwad.components.ad.reward.d.f;
import com.kwad.components.ad.reward.d.h;
import com.kwad.components.ad.reward.d.l;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.a.j;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ai;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/platdetail/kwai/e.class */
public final class e extends com.kwad.components.ad.reward.presenter.a implements h {
    private com.kwad.components.core.webview.a.d.e gG = new com.kwad.components.core.webview.a.d.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.e.1
        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-top-bar", e.this.qt.mAdTemplate).equals(str)) {
                e.this.qt.pG = true;
                e.this.bY();
            }
        }
    };
    private f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.e.2
        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            e.this.ik();
        }
    };
    private View uQ;
    private View uR;
    private ImageView uS;

    public e() {
        a(new com.kwad.components.ad.reward.presenter.platdetail.a());
        a(new com.kwad.components.ad.reward.presenter.c.a());
        a(new com.kwad.components.ad.reward.presenter.f.h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY() {
        this.uQ.setVisibility(0);
        this.uR.setVisibility(8);
    }

    private void ij() {
        if (!this.qt.ph) {
            this.uR.setVisibility(8);
        }
        this.uQ.setVisibility(0);
        getContext();
        if (com.kwad.components.ad.reward.j.p(this.qt.mAdTemplate) && ai.DL()) {
            this.uS.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void a(PlayableSource playableSource, l lVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        View view;
        int i;
        super.ar();
        if (com.kwad.components.ad.reward.j.b(this.qt)) {
            com.kwad.components.core.webview.a.c.a.rn().a(this.gG);
            i = 8;
            this.uQ.setVisibility(8);
            view = this.uR;
        } else {
            view = this.uQ;
            i = 0;
        }
        view.setVisibility(i);
        this.qt.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.b.ff().a(this);
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void ca() {
        ij();
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void cb() {
        ik();
    }

    public final void ik() {
        if (this.qt.ph) {
            this.uQ.setVisibility(8);
        } else {
            this.uQ.setVisibility(8);
            this.uR.setVisibility(0);
        }
        getContext();
        if (com.kwad.components.ad.reward.j.p(this.qt.mAdTemplate) && ai.DL()) {
            this.uS.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.uQ = findViewById(R.id.ksad_play_detail_top_toolbar);
        this.uR = findViewById(R.id.ksad_play_end_top_toolbar);
        this.uS = (ImageView) findViewById(R.id.ksad_blur_end_cover);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.a.c.a.rn().b(this.gG);
        ij();
        this.qt.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.b.ff().b(this);
        this.uR.setVisibility(8);
    }
}
