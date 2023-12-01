package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.ads.reward.OnMetadataChangedListener;
import com.huawei.hms.ads.reward.RewardAdListener;
import com.huawei.hms.ads.reward.RewardVerifyConfig;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/InterstitialAd.class */
public class InterstitialAd {
    private final z Code;

    public InterstitialAd(Context context) {
        this.Code = new z(context);
    }

    public final String getAdId() {
        return this.Code.V();
    }

    public final AdListener getAdListener() {
        return this.Code.Code();
    }

    public final Bundle getAdMetadata() {
        return this.Code.C();
    }

    public final boolean isLoaded() {
        return this.Code.I();
    }

    public final boolean isLoading() {
        return this.Code.Z();
    }

    public final void loadAd(AdParam adParam) {
        this.Code.Code(adParam);
    }

    public final void setAdId(String str) {
        this.Code.Code(str);
    }

    public final void setAdListener(AdListener adListener) {
        this.Code.Code(adListener);
    }

    public final void setAdMetadataListener(OnMetadataChangedListener onMetadataChangedListener) {
        this.Code.Code(onMetadataChangedListener);
    }

    public final void setRewardAdListener(RewardAdListener rewardAdListener) {
        this.Code.Code(rewardAdListener);
    }

    public final void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        this.Code.Code(rewardVerifyConfig);
    }

    @Deprecated
    public final void show() {
        this.Code.S();
    }

    public final void show(Activity activity) {
        this.Code.Code(activity);
    }
}
