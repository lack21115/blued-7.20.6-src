package com.soft.blued.ui.welcome;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;
import com.anythink.rewardvideo.api.ATRewardVideoAd;
import com.anythink.rewardvideo.api.ATRewardVideoExListener;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/TopVideoFragment.class */
public class TopVideoFragment extends BaseADVideoFragment {
    public Context g;
    public View h;
    ATRewardVideoAd i;

    private void k() {
        ATRewardVideoAd aTRewardVideoAd = new ATRewardVideoAd(this.g, this.b.third_id);
        this.i = aTRewardVideoAd;
        aTRewardVideoAd.load();
        h();
        this.i.setAdListener(new ATRewardVideoExListener() { // from class: com.soft.blued.ui.welcome.TopVideoFragment.1
            @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
            public void onAgainReward(ATAdInfo aTAdInfo) {
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
            public void onDeeplinkCallback(ATAdInfo aTAdInfo, boolean z) {
                Log.i("drb", "onDeeplinkCallback:" + aTAdInfo.toString() + "--status:" + z);
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
            public void onDownloadConfirm(Context context, ATAdInfo aTAdInfo, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
            public void onReward(ATAdInfo aTAdInfo) {
                Log.e("drb", "onReward:\n" + aTAdInfo.toString());
                TopVideoFragment.this.f = true;
                TopVideoFragment.this.f();
                TopVideoFragment.this.a();
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
            public void onRewardedVideoAdAgainPlayClicked(ATAdInfo aTAdInfo) {
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
            public void onRewardedVideoAdAgainPlayEnd(ATAdInfo aTAdInfo) {
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
            public void onRewardedVideoAdAgainPlayFailed(AdError adError, ATAdInfo aTAdInfo) {
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
            public void onRewardedVideoAdAgainPlayStart(ATAdInfo aTAdInfo) {
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
            public void onRewardedVideoAdClosed(ATAdInfo aTAdInfo) {
                Log.i("drb", "onRewardedVideoAdClosed:\n" + aTAdInfo.toString());
                TopVideoFragment.this.e();
                TopVideoFragment.this.b();
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
            public void onRewardedVideoAdFailed(AdError adError) {
                Log.i("drb", "onRewardedVideoAdFailed error:" + adError.getFullErrorInfo());
                TopVideoFragment.this.g();
                TopVideoFragment.this.b();
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
            public void onRewardedVideoAdLoaded() {
                Log.i("drb", "onRewardedVideoAdLoaded");
                TopVideoFragment.this.i.show(TopVideoFragment.this.getActivity());
                DialogUtils.b(TopVideoFragment.this.f20822a);
                TopVideoFragment.this.i();
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
            public void onRewardedVideoAdPlayClicked(ATAdInfo aTAdInfo) {
                Log.i("drb", "onRewardedVideoAdPlayClicked:\n" + aTAdInfo.toString());
                TopVideoFragment.this.d();
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
            public void onRewardedVideoAdPlayEnd(ATAdInfo aTAdInfo) {
                Log.i("drb", "onRewardedVideoAdPlayEnd:\n" + aTAdInfo.toString());
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
            public void onRewardedVideoAdPlayFailed(AdError adError, ATAdInfo aTAdInfo) {
                Log.i("drb", "onRewardedVideoAdPlayFailed error:" + adError.getFullErrorInfo());
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
            public void onRewardedVideoAdPlayStart(ATAdInfo aTAdInfo) {
                Log.i("drb", "onRewardedVideoAdPlayStart:\n" + aTAdInfo.toString());
                TopVideoFragment.this.c();
            }
        });
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.g = getActivity();
        getActivity().overridePendingTransition(R.anim.activity_switch_none, R.anim.activity_switch_none);
        View view = this.h;
        if (view == null) {
            this.h = layoutInflater.inflate(R.layout.fragment_ad_video, viewGroup, false);
            k();
            DialogUtils.a(this.f20822a);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.h.getParent()).removeView(this.h);
        }
        return this.h;
    }
}
