package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.k.h;
import com.kwad.components.ad.reward.k.v;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/platdetail/actionbar/d.class */
public final class d extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.ad.reward.k.b {
    private ViewGroup gv;
    private KsLogoView sh;
    private h uq;

    public d(ViewGroup viewGroup) {
        this.gv = viewGroup;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0076, code lost:
        if (r10 != false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.widget.FrameLayout.LayoutParams a(android.content.Context r4, com.kwad.sdk.core.response.model.AdInfo r5, com.kwad.components.core.widget.KsLogoView r6, int r7, boolean r8) {
        /*
            r0 = 0
            r12 = r0
            r0 = r6
            if (r0 == 0) goto Lae
            r0 = r4
            if (r0 != 0) goto Ld
            r0 = 0
            return r0
        Ld:
            r0 = r6
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            r12 = r0
            r0 = r12
            boolean r0 = r0 instanceof android.widget.FrameLayout.LayoutParams
            if (r0 != 0) goto L1d
            r0 = 0
            return r0
        L1d:
            r0 = r12
            android.widget.FrameLayout$LayoutParams r0 = (android.widget.FrameLayout.LayoutParams) r0
            r13 = r0
            r0 = r13
            android.widget.FrameLayout$LayoutParams r0 = a(r0)
            r12 = r0
            r0 = 0
            r11 = r0
            r0 = r8
            if (r0 == 0) goto L38
            r0 = r6
            r1 = 0
            r0.setVisibility(r1)
        L38:
            boolean r0 = com.kwad.sdk.utils.ai.DL()
            if (r0 != 0) goto L52
            r0 = r5
            boolean r0 = com.kwad.components.ad.reward.kwai.b.j(r0)
            if (r0 != 0) goto L4c
            r0 = r5
            boolean r0 = com.kwad.sdk.core.response.a.a.ck(r0)
            if (r0 == 0) goto L52
        L4c:
            r0 = 1
            r9 = r0
            goto L55
        L52:
            r0 = 0
            r9 = r0
        L55:
            boolean r0 = com.kwad.sdk.utils.ai.DL()
            if (r0 == 0) goto L68
            r0 = r5
            boolean r0 = com.kwad.sdk.core.response.a.a.cj(r0)
            if (r0 == 0) goto L68
            r0 = 1
            r10 = r0
            goto L6b
        L68:
            r0 = 0
            r10 = r0
        L6b:
            r0 = r9
            if (r0 != 0) goto L79
            r0 = r11
            r9 = r0
            r0 = r10
            if (r0 == 0) goto L7c
        L79:
            r0 = 1
            r9 = r0
        L7c:
            r0 = r13
            r1 = 85
            r0.gravity = r1
            r0 = r9
            if (r0 == 0) goto L8c
            int r0 = com.kwad.sdk.R.dimen.ksad_reward_follow_card_margin
            r7 = r0
        L8c:
            r0 = r13
            r1 = r4
            android.content.res.Resources r1 = r1.getResources()
            r2 = r7
            int r1 = r1.getDimensionPixelOffset(r2)
            r0.bottomMargin = r1
            r0 = r13
            r1 = r4
            android.content.res.Resources r1 = r1.getResources()
            int r2 = com.kwad.sdk.R.dimen.ksad_reward_follow_card_margin
            int r1 = r1.getDimensionPixelOffset(r2)
            r0.rightMargin = r1
            r0 = r6
            r1 = r13
            r0.setLayoutParams(r1)
        Lae:
            r0 = r12
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.presenter.platdetail.actionbar.d.a(android.content.Context, com.kwad.sdk.core.response.model.AdInfo, com.kwad.components.core.widget.KsLogoView, int, boolean):android.widget.FrameLayout$LayoutParams");
    }

    private static FrameLayout.LayoutParams a(FrameLayout.LayoutParams layoutParams) {
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        layoutParams2.gravity = layoutParams.gravity;
        return layoutParams2;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        h hVar = new h(this.qt, this.gv, this.sh);
        this.uq = hVar;
        hVar.b(v.B(this.qt.mAdTemplate));
        a(getContext(), com.kwad.sdk.core.response.a.d.cb(this.qt.mAdTemplate), this.sh, R.dimen.ksad_reward_jinniu_logo_margin_bottom, false);
    }

    @Override // com.kwad.components.ad.reward.k.b
    public final void gO() {
    }

    @Override // com.kwad.components.ad.reward.k.b
    public final void ic() {
    }

    @Override // com.kwad.components.ad.reward.k.b
    public final void id() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sh = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }
}
