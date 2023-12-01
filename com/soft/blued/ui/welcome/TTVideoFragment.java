package com.soft.blued.ui.welcome;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.soft.blued.R;
import com.soft.blued.utils.third.TTAdManagerHolder;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/TTVideoFragment.class */
public class TTVideoFragment extends BaseADVideoFragment {
    public Context g;
    public View h;
    private TTAdNative i;
    private TTRewardVideoAd j;
    private boolean k = false;
    private boolean l = false;

    private void a(String str) {
        AdSlot build = new AdSlot.Builder().setCodeId(str).build();
        h();
        this.i.loadRewardVideoAd(build, new TTAdNative.RewardVideoAdListener() { // from class: com.soft.blued.ui.welcome.TTVideoFragment.1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
            public void onError(int i, String str2) {
                Log.e("drb", "Callback --> onError: " + i + ", " + String.valueOf(str2));
                TTVideoFragment.this.g();
                TTVideoFragment.this.b();
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
                Log.e("drb", "Callback --> onRewardVideoAdLoad");
                TTVideoFragment.this.i();
                TTVideoFragment.this.k = false;
                TTVideoFragment.this.j = tTRewardVideoAd;
                TTVideoFragment.this.j.setRewardAdInteractionListener(new TTRewardVideoAd.RewardAdInteractionListener() { // from class: com.soft.blued.ui.welcome.TTVideoFragment.1.1
                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdClose() {
                        Log.d("drb", "Callback --> rewardVideoAd close");
                        TTVideoFragment.this.e();
                        TTVideoFragment.this.b();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdShow() {
                        Log.d("drb", "Callback --> rewardVideoAd show");
                        TTVideoFragment.this.c();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdVideoBarClick() {
                        Log.d("drb", "Callback --> rewardVideoAd bar click");
                        TTVideoFragment.this.d();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onRewardArrived(boolean z, int i, Bundle bundle) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onRewardVerify(boolean z, int i, String str2, int i2, String str3) {
                        Log.e("drb", "Callback --> " + ("verify:" + z + " amount:" + i + " name:" + str2 + " errorCode:" + i2 + " errorMsg:" + str3));
                        if (z) {
                            TTVideoFragment.this.f = true;
                            TTVideoFragment.this.a();
                            TTVideoFragment.this.f();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onSkippedVideo() {
                        Log.e("drb", "Callback --> rewardVideoAd has onSkippedVideo");
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onVideoComplete() {
                        Log.d("drb", "Callback --> rewardVideoAd complete");
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onVideoError() {
                        Log.e("drb", "Callback --> rewardVideoAd error");
                        TTVideoFragment.this.g();
                        TTVideoFragment.this.b();
                    }
                });
                TTVideoFragment.this.j.setDownloadListener(new TTAppDownloadListener() { // from class: com.soft.blued.ui.welcome.TTVideoFragment.1.2
                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadActive(long j, long j2, String str2, String str3) {
                        Log.e("drb", "onDownloadActive==totalBytes=" + j + ",currBytes=" + j2 + ",fileName=" + str2 + ",appName=" + str3);
                        if (TTVideoFragment.this.l) {
                            return;
                        }
                        TTVideoFragment.this.l = true;
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadFailed(long j, long j2, String str2, String str3) {
                        Log.e("drb", "onDownloadFailed==totalBytes=" + j + ",currBytes=" + j2 + ",fileName=" + str2 + ",appName=" + str3);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadFinished(long j, String str2, String str3) {
                        Log.e("drb", "onDownloadFinished==totalBytes=" + j + ",fileName=" + str2 + ",appName=" + str3);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadPaused(long j, long j2, String str2, String str3) {
                        Log.e("drb", "onDownloadPaused===totalBytes=" + j + ",currBytes=" + j2 + ",fileName=" + str2 + ",appName=" + str3);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onIdle() {
                        TTVideoFragment.this.l = false;
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onInstalled(String str2, String str3) {
                        Log.e("drb", "onInstalled==,fileName=" + str2 + ",appName=" + str3);
                    }
                });
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached() {
                Log.e("drb", "Callback --> onRewardVideoCached");
                TTVideoFragment.this.k = true;
                DialogUtils.b(TTVideoFragment.this.f34513a);
                TTVideoFragment.this.j.showRewardVideoAd(TTVideoFragment.this.getActivity());
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
            }
        });
    }

    private void k() {
        this.i = TTAdManagerHolder.a(this.g).createAdNative(AppInfo.d());
        a(this.b.third_id);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.g = getActivity();
        getActivity().overridePendingTransition(R.anim.activity_switch_none, R.anim.activity_switch_none);
        View view = this.h;
        if (view == null) {
            this.h = layoutInflater.inflate(R.layout.fragment_ad_video, viewGroup, false);
            k();
            DialogUtils.a(this.f34513a);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.h.getParent()).removeView(this.h);
        }
        return this.h;
    }
}
