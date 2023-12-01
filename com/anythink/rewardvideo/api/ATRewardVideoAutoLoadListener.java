package com.anythink.rewardvideo.api;

import com.anythink.core.api.AdError;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/rewardvideo/api/ATRewardVideoAutoLoadListener.class */
public interface ATRewardVideoAutoLoadListener {
    void onRewardVideoAutoLoadFail(String str, AdError adError);

    void onRewardVideoAutoLoaded(String str);
}
