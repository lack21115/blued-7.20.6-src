package com.alipay.sdk.app;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.SystemClock;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alipay.sdk.util.n;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/b.class */
public class b extends WebViewClient {
    private Activity a;
    private boolean b;
    private final com.alipay.sdk.sys.a c;

    public b(Activity activity, com.alipay.sdk.sys.a aVar) {
        this.a = activity;
        this.c = aVar;
    }

    public void a() {
        this.a = null;
    }

    public boolean b() {
        return this.b;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        com.alipay.sdk.sys.a aVar = this.c;
        com.alipay.sdk.app.statistic.a.b(aVar, com.alipay.sdk.app.statistic.c.b, "h5ldd", SystemClock.elapsedRealtime() + "|" + n.e(str));
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        com.alipay.sdk.sys.a aVar = this.c;
        com.alipay.sdk.app.statistic.a.b(aVar, com.alipay.sdk.app.statistic.c.b, "h5ld", SystemClock.elapsedRealtime() + "|" + n.e(str));
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.b = true;
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Activity activity = this.a;
        if (activity == null) {
            return;
        }
        com.alipay.sdk.sys.a aVar = this.c;
        com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.c.a, com.alipay.sdk.app.statistic.c.r, "1" + sslError);
        activity.runOnUiThread(new c(this, activity, sslErrorHandler));
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return n.a(this.c, webView, str, this.a);
    }
}
