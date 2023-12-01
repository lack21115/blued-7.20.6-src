package com.youzan.androidsdk.tool;

import com.youzan.androidsdk.WebViewCompat;
import com.youzan.androidsdk.YouzanLog;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/tool/Javascript.class */
public final class Javascript {
    public static void sharePage(WebViewCompat webViewCompat) {
        if (webViewCompat != null) {
            webViewCompat.loadUrl("javascript:window.YouzanJSBridge.trigger('share')");
        } else {
            YouzanLog.e("WebView Is Null On sharePage");
        }
    }
}
