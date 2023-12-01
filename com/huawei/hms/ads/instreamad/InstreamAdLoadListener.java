package com.huawei.hms.ads.instreamad;

import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/instreamad/InstreamAdLoadListener.class */
public interface InstreamAdLoadListener {
    void onAdFailed(int i);

    void onAdLoaded(List<InstreamAd> list);
}
