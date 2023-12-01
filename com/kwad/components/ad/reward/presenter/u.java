package com.kwad.components.ad.reward.presenter;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ai;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/u.class */
public final class u extends a {
    private DetailVideoView oM;
    private ViewGroup tp;
    private FrameLayout tq;
    private ImageView tr;
    private ViewGroup.LayoutParams ts = null;
    private com.kwad.components.core.video.i mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.reward.presenter.u.1
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            super.onVideoPlayStart();
            u.this.oM.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.u.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    u.this.oM.setVisibility(0);
                }
            }, 200L);
        }
    };

    private void Q(int i) {
        this.tq.addView(com.kwad.sdk.j.k.a(getContext(), i, this.tq, false), -1, -1);
    }

    private void hL() {
        DevelopMangerComponents developMangerComponents = (DevelopMangerComponents) com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
    }

    private void hM() {
        int i;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.qt.mAdTemplate);
        getContext();
        boolean DL = ai.DL();
        boolean bv = com.kwad.sdk.core.response.a.a.bv(cb);
        boolean z = com.kwad.sdk.core.response.a.a.ci(cb) && com.kwad.components.ad.reward.kwai.b.gJ();
        boolean z2 = com.kwad.components.ad.reward.j.o(this.qt.mAdTemplate) || com.kwad.components.ad.reward.j.p(this.qt.mAdTemplate) || bv || z;
        if (!(!DL) || !z2) {
            this.tp.setVisibility(8);
            return;
        }
        ViewGroup viewGroup = this.tp;
        int i2 = 0;
        if (z) {
            i2 = 4;
        }
        viewGroup.setVisibility(i2);
        if (bv) {
            this.tr.setVisibility(8);
            i = R.layout.ksad_playable_end_info;
        } else {
            i = R.layout.ksad_activity_apk_info_landscape;
        }
        Q(i);
        if (!com.kwad.sdk.core.response.a.a.aR(cb)) {
            this.oM.updateTextureViewGravity(17);
        } else {
            this.oM.updateTextureViewGravity(21);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        hL();
        ViewGroup.LayoutParams layoutParams = this.oM.getLayoutParams();
        if (layoutParams != null) {
            this.ts = new ViewGroup.LayoutParams(layoutParams);
        }
        this.qt.oN.jH().a(this.mVideoPlayStateListener);
        hM();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.oM = (DetailVideoView) findViewById(R.id.ksad_video_player);
        this.tp = (ViewGroup) findViewById(R.id.ksad_play_right_area);
        this.tr = (ImageView) findViewById(R.id.ksad_play_right_area_bg_img);
        this.tq = (FrameLayout) findViewById(R.id.ksad_play_right_area_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        DetailVideoView detailVideoView;
        super.onUnbind();
        this.qt.oN.jH().b(this.mVideoPlayStateListener);
        if (this.ts == null || (detailVideoView = this.oM) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = detailVideoView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = this.ts.width;
            layoutParams.height = this.ts.height;
            this.oM.setLayoutParams(layoutParams);
        }
        DetailVideoView detailVideoView2 = this.oM;
        if (detailVideoView2 != null) {
            detailVideoView2.setVisibility(4);
        }
        this.ts = null;
    }
}
