package com.kwad.components.ad.reward.presenter.g;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.kwad.components.ad.reward.d.j;
import com.kwad.components.ad.reward.i.d;
import com.kwad.components.ad.reward.k.c;
import com.kwad.components.ad.reward.k.e;
import com.kwad.components.ad.reward.k.u;
import com.kwad.sdk.R;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.f;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/g/a.class */
public final class a extends com.kwad.components.ad.reward.presenter.a implements c.a, com.kwad.sdk.core.webview.c.kwai.a, com.kwad.sdk.widget.c {
    private final j mRewardVerifyListener = new j() { // from class: com.kwad.components.ad.reward.presenter.g.a.1
        @Override // com.kwad.components.ad.reward.d.j
        public final void onRewardVerify() {
            if (a.this.wD != null) {
                a.this.wD.jJ();
            }
            if (a.this.wE != null) {
                a.this.wE.jJ();
            }
        }
    };
    private com.kwad.components.ad.reward.i.kwai.a px;
    private u vF;
    private ViewGroup wA;
    private ViewGroup wB;
    private e wC;
    private c wD;
    private c wE;

    private void a(AdBaseFrameLayout adBaseFrameLayout) {
        Context context;
        float f;
        getContext();
        if (!ai.DL()) {
            com.kwad.sdk.core.d.b.d("LandPageOpenTaskPresenter", "initBottomActionBar screen is horizontal");
            return;
        }
        ((ViewStub) findViewById(R.id.ksad_reward_apk_info_stub)).inflate();
        KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(R.id.ksad_reward_apk_info_card_root);
        kSFrameLayout.setRadius(getContext().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_step_icon_radius));
        int size = com.kwad.sdk.core.response.a.c.bS(this.qt.mAdTemplate).size();
        kSFrameLayout.setRatio(0.0f);
        if (size == 0) {
            context = getContext();
            f = 136.0f;
        } else {
            context = getContext();
            f = 155.0f;
        }
        com.kwad.sdk.c.kwai.a.m(kSFrameLayout, com.kwad.sdk.c.kwai.a.a(context, f));
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_reward_apk_info_card_native_container);
        this.wB = viewGroup;
        viewGroup.setClickable(true);
        new f(this.wB, this);
        c cVar = new c(this.wB);
        this.wD = cVar;
        cVar.a(this);
        this.wD.c(this.qt.mAdTemplate, true);
        e eVar = new e((KsAdWebView) findViewById(R.id.ksad_reward_apk_info_card_h5), this.wB, null, this);
        this.wC = eVar;
        eVar.a(this.qt.mAdTemplate, adBaseFrameLayout);
    }

    private void c(View view, boolean z) {
        int id = view.getId();
        if (id == R.id.ksad_reward_apk_info_card_native_container || id == R.id.ksad_activity_apk_info_area_native) {
            d(z, 2);
        }
    }

    private void d(boolean z, int i) {
        this.qt.a(1, getContext(), z ? 1 : 153, i);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        c(view, true);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.sdk.core.d.b.d("LandPageOpenTaskPresenter", "onBind");
        if (com.kwad.components.ad.reward.j.p(this.qt.mAdTemplate)) {
            this.px = d.jt();
            this.qt.px = this.px;
            com.kwad.components.ad.reward.c.fj().a(this.mRewardVerifyListener);
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_activity_apk_info_area_native);
            this.wA = viewGroup;
            if (viewGroup != null) {
                viewGroup.setClickable(true);
                this.wA.setVisibility(8);
                new f(this.wA, this);
                c cVar = new c(this.wA);
                this.wE = cVar;
                cVar.a(this);
                this.wE.c(this.qt.mAdTemplate, false);
                ((KSFrameLayout) findViewById(R.id.ksad_right_area_webview_container)).setWidthBasedRatio(false);
                u uVar = new u((KsAdWebView) findViewById(R.id.ksad_right_area_webview), this.wA, null, this);
                this.vF = uVar;
                uVar.a(this.qt.mAdTemplate, adBaseFrameLayout);
            }
            a(adBaseFrameLayout);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.a.c.bQ(this.qt.mAdTemplate)) {
            c(view, false);
        }
    }

    @Override // com.kwad.components.ad.reward.k.c.a
    public final void c(boolean z, int i) {
        d(z, 1);
    }

    @Override // com.kwad.sdk.core.webview.c.kwai.a
    public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.b.d("LandPageOpenTaskPresenter", "onUnbind");
        e eVar = this.wC;
        if (eVar != null) {
            eVar.jL();
            this.wC = null;
        }
        c cVar = this.wE;
        if (cVar != null) {
            cVar.jI();
        }
        com.kwad.components.ad.reward.c.fj().b(this.mRewardVerifyListener);
        this.qt.px = null;
    }
}
