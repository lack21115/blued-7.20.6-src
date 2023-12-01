package com.kwad.components.ad.e;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.kwad.components.ad.e.a.g;
import com.kwad.components.ad.e.a.h;
import com.kwad.components.ad.e.a.i;
import com.kwad.components.ad.e.d;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.j.k;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.l;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.j;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/e/f.class */
public final class f extends KSFrameLayout {
    private j cK;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private DetailVideoView mDetailVideoView;
    private KsNativeAd.VideoPlayListener mM;
    private Presenter mPresenter;
    private d.a mR;
    private com.kwad.components.core.widget.kwai.b mViewVisibleHelper;
    private AdBasePvFrameLayout nd;
    private com.kwad.components.ad.e.kwai.b ni;
    private com.kwad.components.ad.e.b.a nj;
    private KsAdVideoPlayConfig nk;

    public f(Context context) {
        this(context, null);
    }

    private f(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        this.cK = new j() { // from class: com.kwad.components.ad.e.f.1
            @Override // com.kwad.sdk.widget.j
            public final void aw() {
                l.cw(f.this.mAdTemplate);
            }
        };
        D(context);
    }

    private void D(Context context) {
        k.inflate(context, R.layout.ksad_native_video_layout, this);
        AdBasePvFrameLayout adBasePvFrameLayout = (AdBasePvFrameLayout) findViewById(R.id.ksad_root_container);
        this.nd = adBasePvFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBasePvFrameLayout.findViewById(R.id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.setAd(true);
    }

    private Presenter an() {
        Presenter presenter = new Presenter();
        presenter.a(new com.kwad.components.ad.e.a.e());
        presenter.a(new com.kwad.components.ad.e.a.c());
        presenter.a(new i());
        presenter.a(new com.kwad.components.ad.e.a.j());
        presenter.a(new com.kwad.components.ad.e.a.d());
        presenter.a(new com.kwad.components.ad.e.a.b());
        presenter.a(new com.kwad.components.ad.e.a.k());
        presenter.a(new com.kwad.components.ad.e.a.a(this.nk));
        presenter.a(new g());
        presenter.a(com.kwad.sdk.core.response.a.a.ax(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate)) ? new com.kwad.components.ad.e.a.f() : new h());
        return presenter;
    }

    private com.kwad.components.ad.e.kwai.b eR() {
        com.kwad.components.ad.e.kwai.b bVar = new com.kwad.components.ad.e.kwai.b();
        bVar.nd = this.nd;
        bVar.mAdTemplate = this.mAdTemplate;
        bVar.mR = this.mR;
        bVar.mM = this.mM;
        bVar.mApkDownloadHelper = (this.mApkDownloadHelper == null && com.kwad.sdk.core.response.a.a.ax(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate))) ? new com.kwad.components.core.d.b.c(this.mAdTemplate) : this.mApkDownloadHelper;
        bVar.nj = this.nj;
        return bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.view.View] */
    public final void a(AdTemplate adTemplate, com.kwad.components.core.d.b.c cVar, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.mAdTemplate = adTemplate;
        this.mApkDownloadHelper = cVar;
        this.nk = ksAdVideoPlayConfig;
        this.nd.setVisibleListener(this.cK);
        this.mViewVisibleHelper = new com.kwad.components.core.widget.kwai.b(getParent() == null ? this : (View) getParent(), 30);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void onViewAttached() {
        super.onViewAttached();
        if (this.nj == null) {
            this.nj = new com.kwad.components.ad.e.b.a(this.mAdTemplate, this.mViewVisibleHelper, this.mDetailVideoView, this.nk);
        }
        this.ni = eR();
        Presenter an = an();
        this.mPresenter = an;
        an.E(this.nd);
        this.mPresenter.f(this.ni);
        this.mViewVisibleHelper.rD();
        this.nj.aR();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void onViewDetached() {
        super.onViewDetached();
        com.kwad.components.core.widget.kwai.b bVar = this.mViewVisibleHelper;
        if (bVar != null) {
            bVar.release();
        }
        com.kwad.components.ad.e.b.a aVar = this.nj;
        if (aVar != null) {
            aVar.aS();
        }
        com.kwad.components.ad.e.kwai.b bVar2 = this.ni;
        if (bVar2 != null) {
            bVar2.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    public final void setInnerAdInteractionListener(d.a aVar) {
        this.mR = aVar;
    }

    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.mM = videoPlayListener;
    }
}
