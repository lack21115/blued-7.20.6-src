package com.bytedance.bdtracker;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/i2.class */
public final class i2 extends WebChromeClient {
    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        Tracker.onProgressChanged(this, webView, i);
        Tracker.onProgressChanged(this, webView, i);
        super.onProgressChanged(webView, i);
    }
}
