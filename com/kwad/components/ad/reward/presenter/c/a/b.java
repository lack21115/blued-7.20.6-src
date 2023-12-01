package com.kwad.components.ad.reward.presenter.c.a;

import android.view.View;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.a.d.e;
import com.kwad.components.core.webview.a.j;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bi;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/c/a/b.class */
public final class b extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, c {
    private View vn;
    private boolean vo;
    private e gG = new e() { // from class: com.kwad.components.ad.reward.presenter.c.a.b.1
        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-top-bar", b.this.qt.mAdTemplate).equals(str)) {
                b.b(b.this);
            }
        }
    };
    private final Runnable vp = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.c.a.b.2
        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.getActivity() == null || b.this.getActivity().isFinishing()) {
                return;
            }
            b.this.iA();
        }
    };

    static /* synthetic */ void b(b bVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iA() {
        com.kwad.sdk.core.d.b.d("RewardPlayEndCloseBtn", "showPageCloseBtn mPlayEndH5ShowSuccess: " + this.qt.pH + ", needHideCloseButton: " + this.vo);
        if (this.qt.pH && this.vo) {
            return;
        }
        this.vn.setVisibility(0);
        this.vn.setAlpha(0.0f);
        this.vn.animate().alpha(1.0f).setDuration(500L).start();
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.vo = com.kwad.sdk.core.response.a.b.dt(com.kwad.sdk.core.response.a.d.cb(this.qt.mAdTemplate));
        if (com.kwad.components.ad.reward.j.b(this.qt)) {
            com.kwad.components.core.webview.a.c.a.rn().a(this.gG);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a.c
    public final void iz() {
        if (this.qt.pq) {
            return;
        }
        long j = this.qt.pA;
        if (j == 0) {
            this.vp.run();
        } else {
            bi.runOnUiThreadDelay(this.vp, j);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Tracker.onClick(view);
        if (view == this.vn) {
            PlayableSource fO = this.qt.fO();
            if (fO == null || !(fO.equals(PlayableSource.PENDANT_CLICK_NOT_AUTO) || fO.equals(PlayableSource.PENDANT_CLICK_AUTO) || fO.equals(PlayableSource.PENDANT_AUTO) || fO.equals(PlayableSource.ACTIONBAR_CLICK))) {
                com.kwad.components.ad.reward.presenter.e.a(this.qt, this.qt.fR());
            } else {
                com.kwad.components.ad.reward.b.ff().fg();
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        View findViewById = findViewById(R.id.ksad_end_close_btn);
        this.vn = findViewById;
        findViewById.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vn.setVisibility(8);
        bi.b(this.vp);
        com.kwad.components.core.webview.a.c.a.rn().b(this.gG);
    }
}
