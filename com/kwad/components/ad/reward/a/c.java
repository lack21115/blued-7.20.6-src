package com.kwad.components.ad.reward.a;

import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.ad.reward.a.b;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/a/c.class */
public final class c extends com.kwad.components.ad.reward.presenter.a implements b.a {
    private AdTemplate mAdTemplate;
    private boolean ri = false;

    static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.ri = true;
        return true;
    }

    private static boolean m(AdInfo adInfo) {
        AdProductInfo ct = com.kwad.sdk.core.response.a.a.ct(adInfo);
        return (!com.kwad.components.ad.reward.kwai.b.j(adInfo) || ct == null || ct.isCouponListEmpty()) ? false : true;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.mAdTemplate = this.qt.mAdTemplate;
    }

    @Override // com.kwad.components.ad.reward.a.b.a
    public final void gO() {
        this.qt.a(1, getContext(), 29, 1);
    }

    public final void showDialog() {
        com.kwad.sdk.core.d.b.d("RewardCouponDialogPresenter", "onBind hasShown : " + this.ri);
        if (this.ri) {
            return;
        }
        AdInfo cb = d.cb(this.mAdTemplate);
        ViewGroup viewGroup = (ViewGroup) this.qt.mRootContainer.findViewById(R.id.ksad_reward_order_coupon_list);
        if (viewGroup == null) {
            return;
        }
        View view = viewGroup;
        if (viewGroup.getChildCount() > 0) {
            view = viewGroup.getChildAt(0);
        }
        final int[] C = com.kwad.sdk.c.kwai.a.C(view);
        if (!m(cb) || C == null) {
            return;
        }
        view.post(new Runnable() { // from class: com.kwad.components.ad.reward.a.c.1
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.b.d("RewardCouponDialogPresenter", "targetView x: " + C[0] + ", y: " + C[1]);
                b.a(c.this.getActivity(), c.this.mAdTemplate, c.this, C);
                c.a(c.this, true);
            }
        });
    }
}
