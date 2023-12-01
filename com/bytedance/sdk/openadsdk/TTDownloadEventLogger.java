package com.bytedance.sdk.openadsdk;

import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTDownloadEventLogger.class */
public interface TTDownloadEventLogger {
    void onDownloadConfigReady();

    void onEvent(JSONObject jSONObject);

    void onV3Event(JSONObject jSONObject);

    boolean shouldFilterOpenSdkLog();
}
