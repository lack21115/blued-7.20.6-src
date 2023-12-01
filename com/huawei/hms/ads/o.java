package com.huawei.hms.ads;

import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/o.class */
public interface o {
    void Code(AdListener adListener);

    void Code(AdParam adParam);

    void Code(AdParam adParam, int i);

    void Code(NativeAd.NativeAdLoadedListener nativeAdLoadedListener);

    void Code(NativeAdConfiguration nativeAdConfiguration);

    void Code(boolean z);

    boolean Code();
}
