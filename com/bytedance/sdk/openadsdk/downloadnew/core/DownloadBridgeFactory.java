package com.bytedance.sdk.openadsdk.downloadnew.core;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdBridge;
import com.bytedance.sdk.openadsdk.downloadnew.h;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/downloadnew/core/DownloadBridgeFactory.class */
public class DownloadBridgeFactory {
    public static final TTAdBridge getDownloadBridge(Context context) {
        return h.mb(context);
    }
}
