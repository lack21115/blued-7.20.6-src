package com.blued.android.framework.web.cache;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/web/cache/BluedWebViewCacheClient.class */
public class BluedWebViewCacheClient extends WebViewClient {
    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        WebResourceResponse a = BluedWebViewCache.a(webResourceRequest);
        return a == null ? super.shouldInterceptRequest(webView, webResourceRequest) : a;
    }
}
