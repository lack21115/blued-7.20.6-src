package com.anythink.expressad.atsignalcommon.a;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.anythink.expressad.foundation.h.o;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/a/a.class */
public class a implements com.anythink.expressad.atsignalcommon.windvane.c {

    /* renamed from: a  reason: collision with root package name */
    protected static final String f7057a = "RVWindVaneWebView";

    @Override // com.anythink.expressad.atsignalcommon.windvane.c
    public String a(String str) {
        o.a(f7057a, "getFileInfo");
        return "{}";
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.c
    public void a(Object obj) {
        o.a(f7057a, "getEndScreenInfo");
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.c
    public void a(Object obj, String str) {
        o.a(f7057a, "operateComponent");
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.c
    public void a(String str, int i, int i2) {
        o.a(f7057a, "loadAds");
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.e
    public void loadingResourceStatus(WebView webView, int i) {
        o.a(f7057a, "loadingResourceStatus");
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.e
    public void onPageFinished(WebView webView, String str) {
        o.a(f7057a, "onPageFinished");
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.e
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        o.a(f7057a, "onPageStarted");
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.e
    public void onProgressChanged(WebView webView, int i) {
        o.a(f7057a, "onProgressChanged");
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.e
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        o.a(f7057a, "onReceivedError");
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.e
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        o.a(f7057a, "onReceivedSslError");
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.e
    public void readyState(WebView webView, int i) {
        o.a(f7057a, "readyState");
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.e
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        o.a(f7057a, "shouldOverrideUrlLoading");
        return true;
    }
}
