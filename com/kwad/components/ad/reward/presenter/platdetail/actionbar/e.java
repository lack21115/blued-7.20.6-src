package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.k.m;
import com.kwad.components.ad.reward.k.v;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.r.g;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/platdetail/actionbar/e.class */
public final class e extends com.kwad.components.ad.reward.presenter.a implements RewardActionBarControl.c {
    private ViewGroup gv;
    private KsLogoView sh;
    private m ur;
    private int us;
    private FrameLayout.LayoutParams ut;
    private m.a uu;

    public e(ViewGroup viewGroup, m.a aVar) {
        this.gv = viewGroup;
        this.uu = aVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.qt.oQ.a(this);
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.qt.mAdTemplate);
        this.us = this.sh.getVisibility();
        this.ut = d.a(getContext(), cb, this.sh, R.dimen.ksad_reward_order_logo_margin_bottom, !this.qt.oN.jF());
        m mVar = new m(this.gv, new com.kwad.components.ad.reward.k.a(getContext(), this.qt) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.e.1
            @Override // com.kwad.components.ad.reward.k.a, com.kwad.components.ad.reward.k.b
            public final void ic() {
                e.this.qt.a(1, e.this.getContext(), 10, 2);
            }

            @Override // com.kwad.components.ad.reward.k.a, com.kwad.components.ad.reward.k.b
            public final void id() {
                e.this.qt.a(1, e.this.getContext(), 10, 2);
            }
        });
        this.ur = mVar;
        mVar.a(this.uu);
        this.ur.b(v.B(this.qt.mAdTemplate));
        g.a(new com.kwad.components.core.widget.e(), this.ur.gK());
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.c
    public final void e(a aVar) {
        this.gv.setVisibility(0);
        RewardActionBarControl.a(aVar, this.gv, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_ORDER);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sh = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.sh.setVisibility(this.us);
        FrameLayout.LayoutParams layoutParams = this.ut;
        if (layoutParams != null) {
            this.sh.setLayoutParams(layoutParams);
        }
    }
}
