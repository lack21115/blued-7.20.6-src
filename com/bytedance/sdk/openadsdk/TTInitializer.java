package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdSdk;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTInitializer.class */
public interface TTInitializer {
    TTAdManager getAdManager();

    void init(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback);

    boolean isInitSuccess();
}
