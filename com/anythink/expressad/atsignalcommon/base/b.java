package com.anythink.expressad.atsignalcommon.base;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/base/b.class */
public class b extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    private a f7070a;
    private com.anythink.expressad.atsignalcommon.windvane.e b;

    public final void a(a aVar) {
        this.f7070a = aVar;
    }

    public final void a(com.anythink.expressad.atsignalcommon.windvane.e eVar) {
        this.b = eVar;
    }

    public final a b() {
        return this.f7070a;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        com.anythink.expressad.atsignalcommon.windvane.e eVar = this.b;
        if (eVar != null) {
            eVar.onPageFinished(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        com.anythink.expressad.atsignalcommon.windvane.e eVar = this.b;
        if (eVar != null) {
            eVar.onReceivedError(webView, i, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        com.anythink.expressad.atsignalcommon.windvane.e eVar = this.b;
        if (eVar != null) {
            eVar.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        a aVar = this.f7070a;
        if (aVar == null || !aVar.a(str)) {
            com.anythink.expressad.atsignalcommon.windvane.e eVar = this.b;
            if (eVar != null) {
                eVar.shouldOverrideUrlLoading(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return true;
    }
}
