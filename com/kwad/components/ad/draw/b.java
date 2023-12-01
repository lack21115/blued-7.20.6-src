package com.kwad.components.ad.draw;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.j.k;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/draw/b.class */
public final class b extends KSFrameLayout {
    private KsDrawAd.AdInteractionListener bV;
    private com.kwad.components.ad.draw.kwai.b bW;
    private com.kwad.components.ad.draw.b.a bX;
    private boolean bY;
    private ImageView bZ;
    private com.kwad.sdk.core.g.b ca;
    private View.OnClickListener cb;
    private i cc;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private Presenter mPresenter;
    private AdBaseFrameLayout mRootContainer;
    private com.kwad.components.core.widget.kwai.b mViewVisibleHelper;

    public b(Context context) {
        super(context);
        this.cb = new View.OnClickListener() { // from class: com.kwad.components.ad.draw.b.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                com.kwad.components.core.d.b.a.a(new a.C0519a(b.this.bW.mRootContainer.getContext()).I(b.this.bW.mAdTemplate).b(b.this.bW.mApkDownloadHelper).ao(false).ap(3).a(new a.b() { // from class: com.kwad.components.ad.draw.b.1.1
                    @Override // com.kwad.components.core.d.b.a.b
                    public final void onAdClicked() {
                    }
                }));
                if (3 == com.kwad.sdk.core.response.a.a.bm(com.kwad.sdk.core.response.a.d.cb(b.this.bW.mAdTemplate))) {
                    b.this.al();
                }
            }
        };
        this.cc = new j() { // from class: com.kwad.components.ad.draw.b.2
            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayPaused() {
                super.onVideoPlayPaused();
                b.this.bZ.setVisibility(0);
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayStart() {
                super.onVideoPlayStart();
                b.this.bZ.setVisibility(8);
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlaying() {
                super.onVideoPlaying();
                b.this.bZ.setVisibility(8);
            }
        };
        this.mContext = context;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al() {
        this.bX.f(!this.bY);
        if (this.bY) {
            this.bX.resume();
        } else {
            this.bX.pause();
        }
        this.bY = !this.bY;
    }

    private com.kwad.components.ad.draw.kwai.b am() {
        com.kwad.components.ad.draw.kwai.b bVar = new com.kwad.components.ad.draw.kwai.b();
        bVar.bV = this.bV;
        bVar.mRootContainer = this.mRootContainer;
        bVar.mAdTemplate = this.mAdTemplate;
        if (com.kwad.sdk.core.response.a.a.ax(this.mAdInfo)) {
            bVar.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate);
        }
        bVar.bX = this.bX;
        bVar.co = new com.kwad.components.ad.draw.a.a.a(this.mAdTemplate);
        if (com.kwad.sdk.core.response.a.b.be(this.mAdTemplate)) {
            bVar.cp = new com.kwad.components.ad.i.b();
        }
        return bVar;
    }

    private Presenter an() {
        Presenter presenter = new Presenter();
        presenter.a(new com.kwad.components.ad.draw.a.kwai.a());
        presenter.a(new com.kwad.components.ad.draw.a.b());
        presenter.a(new com.kwad.components.ad.draw.a.d());
        presenter.a(new com.kwad.components.ad.draw.a.c());
        presenter.a(new com.kwad.components.ad.draw.a.a.b());
        if (com.kwad.sdk.core.response.a.b.aR(this.mAdTemplate)) {
            presenter.a(new com.kwad.components.ad.draw.a.a.c());
        }
        presenter.a(new com.kwad.components.ad.draw.a.b.a());
        if (com.kwad.sdk.core.response.a.b.be(this.mAdTemplate)) {
            presenter.a(new com.kwad.components.ad.draw.a.b.b());
        }
        if (com.kwad.sdk.core.response.a.a.aH(this.mAdInfo)) {
            presenter.a(new com.kwad.components.ad.draw.a.a());
        }
        return presenter;
    }

    private void initView() {
        k.inflate(this.mContext, R.layout.ksad_draw_layout, this);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.mRootContainer = adBaseFrameLayout;
        this.bZ = (ImageView) adBaseFrameLayout.findViewById(R.id.ksad_video_control_button);
        DetailVideoView detailVideoView = (DetailVideoView) this.mRootContainer.findViewById(R.id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.f(true, com.kwad.sdk.core.config.d.uV());
        this.mDetailVideoView.setOnClickListener(this.cb);
        this.bZ.setOnClickListener(this.cb);
    }

    public final void a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        com.kwad.components.core.widget.kwai.b bVar = new com.kwad.components.core.widget.kwai.b(this, 70);
        this.mViewVisibleHelper = bVar;
        this.bX = new com.kwad.components.ad.draw.b.a(this.mAdTemplate, bVar, this.mDetailVideoView);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void onViewAttached() {
        super.onViewAttached();
        this.bW = am();
        Presenter an = an();
        this.mPresenter = an;
        an.E(this.mRootContainer);
        this.mPresenter.f(this.bW);
        this.mViewVisibleHelper.a(this.ca);
        this.mViewVisibleHelper.rD();
        this.bX.aR();
        this.bX.a(this.cc);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void onViewDetached() {
        super.onViewDetached();
        com.kwad.components.core.widget.kwai.b bVar = this.mViewVisibleHelper;
        if (bVar != null) {
            bVar.release();
        }
        com.kwad.components.ad.draw.b.a aVar = this.bX;
        if (aVar != null) {
            aVar.aS();
            this.bX.b(this.cc);
        }
        com.kwad.components.ad.draw.kwai.b bVar2 = this.bW;
        if (bVar2 != null) {
            bVar2.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    public final void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.bV = adInteractionListener;
    }

    public final void setPageExitListener(com.kwad.sdk.core.g.b bVar) {
        this.ca = bVar;
    }
}
