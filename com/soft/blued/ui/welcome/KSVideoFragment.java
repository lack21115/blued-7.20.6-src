package com.soft.blued.ui.welcome;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.module.common.utils.DialogUtils;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsInnerAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.soft.blued.R;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/KSVideoFragment.class */
public class KSVideoFragment extends BaseADVideoFragment {
    public Context g;
    public View h;

    private void a(KsRewardVideoAd ksRewardVideoAd) {
        ksRewardVideoAd.setInnerAdInteractionListener(new KsInnerAd.KsInnerAdInteractionListener() { // from class: com.soft.blued.ui.welcome.KSVideoFragment.2
            @Override // com.kwad.sdk.api.KsInnerAd.KsInnerAdInteractionListener
            public void onAdClicked(KsInnerAd ksInnerAd) {
                Log.v("drb", "激励视频内部广告点击");
            }

            @Override // com.kwad.sdk.api.KsInnerAd.KsInnerAdInteractionListener
            public void onAdShow(KsInnerAd ksInnerAd) {
                Log.v("drb", "激励视频内部广告曝光");
            }
        });
        ksRewardVideoAd.setRewardAdInteractionListener(new KsRewardVideoAd.RewardAdInteractionListener() { // from class: com.soft.blued.ui.welcome.KSVideoFragment.3
            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onAdClicked() {
                Log.v("drb", "激励视频广告点击");
                KSVideoFragment.this.d();
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onExtraRewardVerify(int i) {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onPageDismiss() {
                Log.v("drb", "激励视频广告关闭");
                KSVideoFragment.this.e();
                KSVideoFragment.this.b();
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onRewardStepVerify(int i, int i2) {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onRewardVerify() {
                Log.v("drb", "激励视频广告获取激励");
                KSVideoFragment.this.f();
                KSVideoFragment.this.a();
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onVideoPlayEnd() {
                Log.v("drb", "激励视频广告播放完成");
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onVideoPlayError(int i, int i2) {
                Log.v("drb", "激励视频广告播放出错");
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onVideoPlayStart() {
                Log.v("drb", "激励视频广告播放开始");
                KSVideoFragment.this.c();
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onVideoSkipToEnd(long j) {
                Log.v("drb", "激励视频广告跳过播放完成");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<KsRewardVideoAd> list) {
        if (!getFragmentActive().isActive() || list == null || list.isEmpty()) {
            return;
        }
        KsRewardVideoAd ksRewardVideoAd = list.get(0);
        a(ksRewardVideoAd);
        ksRewardVideoAd.showRewardVideoAd(getActivity(), new KsVideoPlayConfig.Builder().build());
    }

    private void l() {
        h();
        k();
    }

    public void k() {
        KsScene build = new KsScene.Builder(Long.parseLong(this.b.third_id)).screenOrientation(1).build();
        final long currentTimeMillis = System.currentTimeMillis();
        KsAdSDK.getLoadManager().loadRewardVideoAd(build, new KsLoadManager.RewardVideoAdListener() { // from class: com.soft.blued.ui.welcome.KSVideoFragment.1
            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onError(int i, String str) {
                Log.e("drb", "Callback --> onError: " + i + ", " + str);
                KSVideoFragment.this.g();
                KSVideoFragment.this.b();
            }

            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onRewardVideoAdLoad(List<KsRewardVideoAd> list) {
                Log.e("drb", "Callback --> onRewardVideoAdLoad time: " + (System.currentTimeMillis() - currentTimeMillis));
                KSVideoFragment.this.a(list);
                DialogUtils.b(KSVideoFragment.this.f20822a);
                KSVideoFragment.this.i();
            }

            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onRewardVideoResult(List<KsRewardVideoAd> list) {
                Log.e("drb", "Callback --> onRewardVideoResult time: " + (System.currentTimeMillis() - currentTimeMillis));
            }
        });
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.g = getActivity();
        getActivity().overridePendingTransition(R.anim.activity_switch_none, R.anim.activity_switch_none);
        View view = this.h;
        if (view == null) {
            this.h = layoutInflater.inflate(R.layout.fragment_ad_video, viewGroup, false);
            l();
            DialogUtils.a(this.f20822a);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.h.getParent()).removeView(this.h);
        }
        return this.h;
    }
}
