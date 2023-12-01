package com.kwad.components.ad.reward.presenter.platdetail.kwai;

import android.view.View;
import android.widget.ImageView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.core.webview.a.j;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.h;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/platdetail/kwai/d.class */
public final class d extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener {
    private ImageView gT;
    private com.kwad.components.ad.reward.j.a gU;
    private AdTemplate mAdTemplate;
    private ImageView uN;
    private h.a gV = new h.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.d.1
        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeOccupied() {
            if (d.this.gT == null || com.kwad.components.ad.reward.kwai.b.gz()) {
                return;
            }
            d.this.gT.post(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.d.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.gT.setSelected(false);
                    d.this.qt.oN.setAudioEnabled(false, false);
                }
            });
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeReleased() {
        }
    };
    private com.kwad.components.core.webview.a.d.e gG = new com.kwad.components.core.webview.a.d.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.d.2
        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-top-bar", d.this.qt.mAdTemplate).equals(str)) {
                d.this.cc();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void cc() {
        this.mAdTemplate = this.qt.mAdTemplate;
        this.gU = this.qt.oN.jH();
        this.gT.setVisibility(com.kwad.components.ad.reward.j.q(this.mAdTemplate) ? 8 : 0);
        ImageView imageView = this.uN;
        int i = 8;
        if (com.kwad.components.ad.reward.j.q(this.mAdTemplate)) {
            i = 0;
        }
        imageView.setVisibility(i);
        KsVideoPlayConfig ksVideoPlayConfig = this.qt.mVideoPlayConfig;
        boolean z = true;
        if (!this.gU.jC() && com.kwad.components.core.r.a.aj(getContext()).pI()) {
            this.uN.setSelected(true);
            this.qt.c(false, false);
            z = false;
        } else if (ksVideoPlayConfig != null) {
            z = ksVideoPlayConfig.isVideoSoundEnable();
            this.uN.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.qt.c(ksVideoPlayConfig.isVideoSoundEnable(), ksVideoPlayConfig.isVideoSoundEnable());
        } else {
            this.uN.setSelected(true);
            this.qt.c(true, true);
        }
        this.gT.setSelected(z);
        this.gU.setAudioEnabled(z, false);
        this.qt.c(z, false);
        this.gU.a(this.gV);
    }

    private void ii() {
        this.gT.setOnClickListener(this);
        this.uN.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (com.kwad.components.ad.reward.j.b(this.qt)) {
            com.kwad.components.core.webview.a.c.a.rn().a(this.gG);
        } else {
            cc();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Tracker.onClick(view);
        if (view == this.gT) {
            this.qt.oN.setAudioEnabled(!this.gT.isSelected(), true);
            ImageView imageView = this.gT;
            imageView.setSelected(!imageView.isSelected());
        } else if (view == this.uN) {
            this.qt.oN.setAudioEnabled(!this.uN.isSelected(), true);
            ImageView imageView2 = this.uN;
            imageView2.setSelected(!imageView2.isSelected());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.gT = (ImageView) findViewById(R.id.ksad_video_sound_switch);
        this.uN = (ImageView) findViewById(R.id.ksad_reward_deep_task_sound_switch);
        ii();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.a.c.a.rn().b(this.gG);
        com.kwad.components.ad.reward.j.a aVar = this.gU;
        if (aVar != null) {
            aVar.b(this.gV);
        }
    }
}
