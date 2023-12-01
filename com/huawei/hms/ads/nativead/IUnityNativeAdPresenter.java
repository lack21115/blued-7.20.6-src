package com.huawei.hms.ads.nativead;

import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/nativead/IUnityNativeAdPresenter.class */
public interface IUnityNativeAdPresenter {
    int getMinEffectiveShowRatio();

    long getMinEffectiveShowTime();

    boolean onUnityAdClick();

    void onUnityAdClose(List<String> list);

    void onUnityAdPhyShow(long j, int i);

    void onUnityAdShow(Long l, Integer num, Integer num2);

    void onUnityAdShowStart();

    void onUnityGoWhyShowThis();

    void updateContent();
}
