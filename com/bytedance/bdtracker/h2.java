package com.bytedance.bdtracker;

import com.bytedance.applog.tracker.Tracker;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/h2.class */
public final class h2 extends WebChromeClient {
    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        Tracker.onProgressChanged(this, webView, i);
        Tracker.onProgressChanged(this, webView, i);
        super.onProgressChanged(webView, i);
    }
}
