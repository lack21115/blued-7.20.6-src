package com.kwad.components.ad.reward.presenter.g;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.kwad.components.ad.reward.d.j;
import com.kwad.components.ad.reward.k.c;
import com.kwad.components.ad.reward.k.e;
import com.kwad.components.ad.reward.k.u;
import com.kwad.sdk.R;
import com.kwad.sdk.core.b.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.v;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.f;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/g/b.class */
public final class b extends com.kwad.components.ad.reward.presenter.a implements c.a, com.kwad.sdk.a.a, com.kwad.sdk.core.webview.c.kwai.a, com.kwad.sdk.widget.c {
    private static float wG = 0.4548105f;
    private AdInfo mAdInfo;
    private com.kwad.components.ad.reward.i.a.a pw;
    private u vF;
    private ViewGroup wA;
    private ViewGroup wB;
    private e wC;
    private c wD;
    private c wE;
    private int wH = 15;
    private long wI = -1;
    private boolean wJ = false;
    private final j mRewardVerifyListener = new j() { // from class: com.kwad.components.ad.reward.presenter.g.b.3
        @Override // com.kwad.components.ad.reward.d.j
        public final void onRewardVerify() {
            if (b.this.wD != null && com.kwad.components.ad.reward.j.q(b.this.qt.mAdTemplate)) {
                b.this.wD.jJ();
            }
            if (b.this.wE != null) {
                b.this.wE.jJ();
            }
        }
    };
    private com.kwad.sdk.core.b.c wK = new d() { // from class: com.kwad.components.ad.reward.presenter.g.b.4
        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            b.this.ab(false);
        }

        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            b.this.ab(true);
        }
    };

    private void a(AdBaseFrameLayout adBaseFrameLayout) {
        getContext();
        if (!ai.DL()) {
            com.kwad.sdk.core.d.b.d("LaunchAppTaskPresenter", "initBottomActionBar screen is horizontal");
            return;
        }
        ((ViewStub) findViewById(R.id.ksad_reward_apk_info_stub)).inflate();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_reward_apk_info_card_native_container);
        this.wB = viewGroup;
        viewGroup.setClickable(true);
        new f(this.wB, this);
        final KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(R.id.ksad_reward_apk_info_card_root);
        kSFrameLayout.setRadius(getContext().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_step_icon_radius));
        final float dimension = getContext().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_height);
        kSFrameLayout.post(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.g.b.1
            @Override // java.lang.Runnable
            public final void run() {
                kSFrameLayout.getHeight();
            }
        });
        ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.ksad_reward_apk_info_card_native_container);
        this.wB = viewGroup2;
        c cVar = new c(viewGroup2);
        this.wD = cVar;
        cVar.a(this.qt.mApkDownloadHelper);
        this.wD.a(this);
        this.wD.c(this.qt.mAdTemplate, false);
        e eVar = new e((KsAdWebView) findViewById(R.id.ksad_reward_apk_info_card_h5), this.wB, this.qt.mApkDownloadHelper, this);
        this.wC = eVar;
        eVar.a(new com.kwad.components.ad.reward.k.f() { // from class: com.kwad.components.ad.reward.presenter.g.b.2
            @Override // com.kwad.components.ad.reward.k.f
            public final void i(String str, int i) {
                int i2 = com.kwad.sdk.core.response.a.d.cb(b.this.qt.mAdTemplate).status;
                com.kwad.sdk.core.d.b.d("LaunchAppTaskPresenter", "onUpdateDownloadProgress downloadStatus: " + i2);
                b.this.wD.j(str, i);
            }
        });
        this.wC.a(this.qt.mAdTemplate, adBaseFrameLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(boolean z) {
        com.kwad.components.ad.reward.i.a.a aVar;
        com.kwad.components.ad.reward.i.a.a.a(this.pw, getContext(), this.qt.mAdTemplate);
        if (!this.pw.jA()) {
            if (z) {
                ac(false);
            }
        } else if (!z) {
            this.wI = System.currentTimeMillis();
        } else {
            boolean ja = ja();
            if (ja && (aVar = this.pw) != null) {
                aVar.jz();
                com.kwad.components.ad.reward.c.fj().notifyRewardVerify();
                this.qt.mAdOpenInteractionListener.onRewardVerify();
            }
            ac(ja);
        }
    }

    private void ac(boolean z) {
        com.kwad.sdk.core.d.b.d("LaunchAppTaskPresenter", "showTaskToast hasShowCompletedToast: " + this.wJ + " completed: " + z);
        if (this.wJ) {
            return;
        }
        v.d(getContext(), z ? "恭喜！任务达标啦，成功获取奖励~" : "哎呀，差一点就达标啦，再试一次~", 0);
        if (z) {
            this.wJ = true;
        }
    }

    private void ad(boolean z) {
        this.qt.a(1, getContext(), z ? 1 : 153, 1);
    }

    private boolean ja() {
        com.kwad.sdk.core.d.b.d("LaunchAppTaskPresenter", "checkUseAppTime appBackgroundTimestamp: " + this.wI);
        return this.wI >= 0 && System.currentTimeMillis() - this.wI > ((long) (this.wH * 1000));
    }

    @Override // com.kwad.sdk.a.a
    public final void X(String str) {
        if (TextUtils.equals(com.kwad.sdk.core.response.a.a.aq(this.mAdInfo), str) && this.qt.pw != null && com.kwad.components.ad.reward.j.o(this.qt.mAdTemplate)) {
            this.qt.pw.jx();
            com.kwad.sdk.core.b.b.vS();
            if (com.kwad.sdk.core.b.b.isAppOnForeground()) {
                return;
            }
            this.wI = System.currentTimeMillis();
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        ad(true);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.sdk.core.d.b.d("LaunchAppTaskPresenter", "onBind");
        if (com.kwad.components.ad.reward.j.o(this.qt.mAdTemplate)) {
            this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(this.qt.mAdTemplate);
            this.wH = com.kwad.components.ad.reward.kwai.b.gy();
            com.kwad.sdk.core.b.b.vS();
            com.kwad.sdk.core.b.b.a(this.wK);
            com.kwad.components.ad.reward.c.fj().a(this.mRewardVerifyListener);
            this.pw = com.kwad.components.ad.reward.i.d.js();
            this.qt.pw = this.pw;
            com.kwad.components.ad.reward.i.a.a.a(this.pw, getContext(), this.qt.mAdTemplate);
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_activity_apk_info_area_native);
            this.wA = viewGroup;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
                c cVar = new c(this.wA);
                this.wE = cVar;
                cVar.a(this.qt.mApkDownloadHelper);
                this.wE.a(this);
                this.wE.c(this.qt.mAdTemplate, false);
                ((KSFrameLayout) findViewById(R.id.ksad_right_area_webview_container)).setWidthBasedRatio(false);
                u uVar = new u((KsAdWebView) findViewById(R.id.ksad_right_area_webview), this.wA, this.qt.mApkDownloadHelper, this);
                this.vF = uVar;
                uVar.a(this.qt.mAdTemplate, adBaseFrameLayout);
            }
            com.kwad.sdk.a.b.tA().a(this);
            a(adBaseFrameLayout);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.a.c.bQ(this.qt.mAdTemplate)) {
            ad(false);
        }
    }

    @Override // com.kwad.components.ad.reward.k.c.a
    public final void c(boolean z, int i) {
        this.qt.b(1, getContext(), z ? 1 : 153, 1);
    }

    @Override // com.kwad.sdk.core.webview.c.kwai.a
    public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.b.d("LaunchAppTaskPresenter", "onUnbind");
        com.kwad.sdk.core.b.b.vS();
        com.kwad.sdk.core.b.b.b(this.wK);
        com.kwad.components.ad.reward.c.fj().b(this.mRewardVerifyListener);
        com.kwad.sdk.a.b.tA().b(this);
        e eVar = this.wC;
        if (eVar != null) {
            eVar.jL();
            this.wC = null;
        }
        c cVar = this.wE;
        if (cVar != null) {
            cVar.jI();
        }
        this.qt.pw = null;
    }
}
