package com.alipay.sdk.widget;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alipay.sdk.widget.p;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/widget/t.class */
public class t extends WebViewClient {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.a = pVar;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        p.b bVar;
        bVar = this.a.h;
        if (bVar.c(this.a, str)) {
            return;
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        p.b bVar;
        bVar = this.a.h;
        if (bVar.a(this.a, i, str, str2)) {
            return;
        }
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        p.b bVar;
        bVar = this.a.h;
        if (bVar.a(this.a, sslErrorHandler, sslError)) {
            return;
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        p.b bVar;
        bVar = this.a.h;
        if (bVar.b(this.a, str)) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
