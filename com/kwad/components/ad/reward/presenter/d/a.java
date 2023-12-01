package com.kwad.components.ad.reward.presenter.d;

import android.widget.FrameLayout;
import com.kwad.components.ad.reward.d.f;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.f.c;
import com.kwad.components.core.webview.a.j;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.a.b;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/d/a.class */
public final class a extends c implements com.kwad.components.ad.reward.h.a {
    private boolean mTKLoadSuccess = false;
    private f vA = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.reward.presenter.d.a.1
        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            a.this.iE();
        }
    };
    private KSFrameLayout vx;
    private AdMatrixInfo.PreLandingPageTKInfo vy;
    private an vz;

    private void X(final boolean z) {
        this.vx.post(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.d.a.2
            @Override // java.lang.Runnable
            public final void run() {
                a.this.vx.setVisibility(z ? 0 : 4);
                a.this.vx.setClickable(z);
                if (a.this.vz != null) {
                    if (z) {
                        a.this.vz.qZ();
                        a.this.vz.ra();
                        return;
                    }
                    a.this.vz.rb();
                    a.this.vz.rc();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iE() {
        AdMatrixInfo.PreLandingPageTKInfo preLandingPageTKInfo;
        if (this.mTKLoadSuccess && (preLandingPageTKInfo = this.vy) != null && preLandingPageTKInfo.isPlayEndShow()) {
            X(true);
        }
    }

    private void iF() {
        AdMatrixInfo.PreLandingPageTKInfo preLandingPageTKInfo;
        if (this.mTKLoadSuccess && (preLandingPageTKInfo = this.vy) != null && preLandingPageTKInfo.isSkipShow()) {
            X(true);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.vy = b.bM(this.qt.mAdTemplate);
        this.qt.b(this.vA);
        this.qt.a((com.kwad.components.ad.reward.h.a) this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c
    public final boolean ck() {
        return true;
    }

    @Override // com.kwad.components.core.webview.a.i
    public final FrameLayout getTKContainer() {
        return this.vx;
    }

    @Override // com.kwad.components.core.webview.a.i
    public final String getTkTemplateId() {
        return j.b("ksad-pre-landingpage-card", this.qt.mAdTemplate);
    }

    public final BackPressHandleResult gs() {
        KSFrameLayout kSFrameLayout;
        return (this.vM == null || (kSFrameLayout = this.vx) == null) ? BackPressHandleResult.NOT_HANDLED : kSFrameLayout.getVisibility() == 0 ? this.vM.gs() : BackPressHandleResult.NOT_HANDLED;
    }

    @Override // com.kwad.components.ad.reward.h.a
    public final void iG() {
        iE();
    }

    @Override // com.kwad.components.ad.reward.h.a
    public final void iH() {
        iF();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vx = (KSFrameLayout) findViewById(R.id.ksad_pre_form_card);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onGetContainerLimited(u.a aVar) {
        float ax = com.kwad.sdk.c.kwai.a.ax(getContext());
        aVar.width = (int) ((bd.getScreenWidth(getContext()) / ax) + 0.5f);
        aVar.height = (int) ((bd.getScreenHeight(getContext()) / ax) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void onRegisterLifecycleLisener(an anVar) {
        super.onRegisterLifecycleLisener(anVar);
        this.vz = anVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void onTkLoadFailed() {
        super.onTkLoadFailed();
        this.mTKLoadSuccess = false;
        X(false);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void onTkLoadSuccess() {
        super.onTkLoadSuccess();
        this.mTKLoadSuccess = true;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qt.c(this.vA);
        this.qt.b((com.kwad.components.ad.reward.h.a) this);
    }
}
