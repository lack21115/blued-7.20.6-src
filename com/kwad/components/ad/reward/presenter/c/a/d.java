package com.kwad.components.ad.reward.presenter.c.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.webview.a.d.e;
import com.kwad.components.core.webview.a.j;
import com.kwad.sdk.R;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/c/a/d.class */
public final class d extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, c {
    private static final String[] vv = {"未获得奖励", "已获得奖励1/2", "已获得全部奖励"};
    private e gG = new e() { // from class: com.kwad.components.ad.reward.presenter.c.a.d.1
        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-top-bar", d.this.qt.mAdTemplate).equals(str)) {
                d.this.cc();
            }
        }
    };
    private final com.kwad.components.ad.reward.d.j mRewardVerifyListener = new com.kwad.components.ad.reward.d.j() { // from class: com.kwad.components.ad.reward.presenter.c.a.d.2
        @Override // com.kwad.components.ad.reward.d.j
        public final void onRewardVerify() {
            if (com.kwad.components.ad.reward.j.q(d.this.qt.mAdTemplate)) {
                d.this.iC();
            }
        }
    };
    private ViewGroup vr;
    private ImageView vs;
    private ViewGroup vt;
    private TextView vu;

    /* JADX INFO: Access modifiers changed from: private */
    public void cc() {
        com.kwad.components.ad.reward.c.fj().a(this.mRewardVerifyListener);
        int i = 0;
        this.vr.setVisibility(0);
        ViewGroup viewGroup = this.vt;
        if (!com.kwad.components.ad.reward.j.q(this.qt.mAdTemplate)) {
            i = 8;
        }
        viewGroup.setVisibility(i);
    }

    private void iB() {
        ImageView imageView = this.vs;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.vs.setOnClickListener(this);
        }
        ViewGroup viewGroup = this.vr;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this);
            this.vr.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iC() {
        this.vu.setText(vv[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.sdk.core.report.a.a(this.qt.mAdTemplate, 41, this.qt.mRootContainer.getTouchCoords(), this.qt.mReportExtData);
        this.qt.mAdOpenInteractionListener.bN();
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

    @Override // com.kwad.components.ad.reward.presenter.c.a.c
    public final void iz() {
        if (this.qt.pq) {
            if (com.kwad.sdk.core.response.a.a.aj(com.kwad.sdk.core.response.a.d.cb(this.qt.mAdTemplate))) {
                this.vt.setVisibility(8);
            }
        } else if (com.kwad.components.ad.reward.j.o(this.qt.mAdTemplate) || com.kwad.components.ad.reward.j.p(this.qt.mAdTemplate)) {
            if (this.qt.fX()) {
                return;
            }
            this.vu.setText(this.qt.pl ? vv[1] : vv[0]);
        } else if (this.qt.fX()) {
            iB();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Tracker.onClick(view);
        if (view == this.vs || view == this.vr) {
            com.kwad.components.core.d.b.a.a(new a.C0349a(view.getContext()).I(this.qt.mAdTemplate).b(this.qt.mApkDownloadHelper).ao(false).ap(2).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.c.a.d.3
                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    d.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vr = (ViewGroup) findViewById(R.id.ksad_end_reward_icon_layout);
        this.vs = (ImageView) findViewById(R.id.ksad_end_reward_icon);
        this.vt = (ViewGroup) findViewById(R.id.ksad_detail_reward_deep_task_view_playend);
        this.vu = (TextView) findViewById(R.id.ksad_reward_deep_task_count_down_playend);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.c.fj().b(this.mRewardVerifyListener);
        com.kwad.components.core.webview.a.c.a.rn().b(this.gG);
        this.vr.setVisibility(8);
        this.vs.setVisibility(8);
        this.vt.setVisibility(8);
    }
}
