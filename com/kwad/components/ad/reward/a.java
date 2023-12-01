package com.kwad.components.ad.reward;

import android.content.Context;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/a.class */
public final class a extends com.kwad.sdk.components.d implements com.kwad.components.ad.a.g {
    @Override // com.kwad.sdk.components.a
    public final Class getComponentsType() {
        return com.kwad.components.ad.a.g.class;
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }

    @Override // com.kwad.components.ad.a.g
    public final void loadRewardVideoAd(KsScene ksScene, KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        e.loadRewardVideoAd(ksScene, rewardVideoAdListener);
    }

    @Override // com.kwad.components.ad.a.g
    public final void notifyRewardVerify() {
        c.fj().notifyRewardVerify();
    }
}
