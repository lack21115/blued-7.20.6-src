package com.bytedance.sdk.openadsdk.live;

import java.io.Serializable;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/live/TTLiveAuthCallback.class */
public interface TTLiveAuthCallback extends Serializable {
    void onAuth(TTLiveToken tTLiveToken);

    void onFailed(Throwable th);
}
