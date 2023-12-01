package com.kwad.components.ad.reward.presenter.e;

import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.ad.reward.k.r;
import com.kwad.components.ad.reward.k.s;
import com.kwad.components.ad.reward.k.u;
import com.kwad.components.ad.reward.k.v;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/e/a.class */
public final class a extends com.kwad.components.ad.reward.presenter.a implements r.a, com.kwad.sdk.core.webview.c.kwai.a {
    private KsAdWebView cS;
    private KSFrameLayout vD;
    private View vE;
    private u vF;
    private s vc;

    private void initView() {
        this.cS = (KsAdWebView) findViewById(R.id.ksad_right_area_webview);
        this.vD = (KSFrameLayout) findViewById(R.id.ksad_right_area_webview_container);
        this.vE = findViewById(R.id.ksad_playabale_end_card);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        initView();
        getContext();
        boolean z = !ai.DL() && d.co(this.qt.mAdTemplate);
        b.d("PlayableHorizontalPresenter", "onBind enable: " + z);
        if (z) {
            this.vc.e((ViewGroup) getRootView());
            this.vc.b(v.B(this.qt.mAdTemplate));
            this.vD.setWidthBasedRatio(false);
            if (this.vF == null) {
                this.vF = new u(this.cS, this.vE, this.qt.mApkDownloadHelper, this);
            }
            this.vF.a(this.qt.mAdTemplate, (AdBaseFrameLayout) findViewById(R.id.ksad_root_container));
        }
    }

    @Override // com.kwad.components.ad.reward.k.r.a
    public final void hV() {
    }

    @Override // com.kwad.components.ad.reward.k.r.a
    public final void hW() {
        com.kwad.components.ad.reward.b.ff().c(PlayableSource.ACTIONBAR_CLICK, new com.kwad.components.ad.reward.f.a(getContext()));
        com.kwad.sdk.core.report.a.q(this.qt.mAdTemplate, 67);
    }

    @Override // com.kwad.components.ad.reward.k.r.a
    public final void hX() {
        this.qt.a(1, getContext(), 1, 1);
    }

    @Override // com.kwad.components.ad.reward.k.r.a
    public final void hY() {
        this.qt.a(1, getContext(), 1, 2);
    }

    @Override // com.kwad.sdk.core.webview.c.kwai.a
    public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        s sVar = new s(-1);
        this.vc = sVar;
        sVar.a(this);
    }
}
