package com.web.library.groups.webviewsdk.b;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* loaded from: source-8829756-dex2jar.jar:com/web/library/groups/webviewsdk/b/a.class */
public abstract class a extends WebViewClient {
    public abstract void a(WebView webView, String str);

    public abstract void a(WebView webView, String str, Bitmap bitmap);

    public abstract boolean b(WebView webView, String str);

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        a(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        a(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (b(webView, str)) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
