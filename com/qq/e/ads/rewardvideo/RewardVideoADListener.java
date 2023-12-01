package com.qq.e.ads.rewardvideo;

import com.qq.e.comm.util.AdError;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/rewardvideo/RewardVideoADListener.class */
public interface RewardVideoADListener {
    void onADClick();

    void onADClose();

    void onADExpose();

    void onADLoad();

    void onADShow();

    void onError(AdError adError);

    void onReward(Map<String, Object> map);

    void onVideoCached();

    void onVideoComplete();
}
