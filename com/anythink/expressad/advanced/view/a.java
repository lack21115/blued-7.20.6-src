package com.anythink.expressad.advanced.view;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.anythink.expressad.advanced.d.c;
import com.anythink.expressad.advanced.js.NativeAdvancedJSBridgeImpl;
import com.anythink.expressad.atsignalcommon.base.b;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.foundation.h.o;
import com.bytedance.applog.tracker.Tracker;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URLDecoder;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/advanced/view/a.class */
public final class a extends b {

    /* renamed from: a  reason: collision with root package name */
    String f7054a;
    com.anythink.expressad.advanced.d.a b;

    /* renamed from: c  reason: collision with root package name */
    private final String f7055c = "NativeAdvancedWebViewClient";
    private c d;

    public a(String str, com.anythink.expressad.advanced.d.a aVar, c cVar) {
        this.f7054a = str;
        this.b = aVar;
        this.d = cVar;
    }

    private WebResourceResponse a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            z = false;
            if (parse != null) {
                z = false;
                if ("mb-h5".equals(parse.getScheme())) {
                    z = true;
                }
            }
        }
        if (!z || this.d == null) {
            return null;
        }
        String a2 = this.d.a(URLDecoder.decode(Uri.parse(str).getQueryParameter("uri")));
        try {
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            o.a("webviewclient", "relace url".concat(String.valueOf(a2)));
            if (a2.contains("127.0.0.1") || a2.startsWith("http")) {
                return null;
            }
            return new WebResourceResponse("video/mp4", "utf-8", new FileInputStream(a2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean b(String str) {
        Uri parse;
        return (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || !"mb-h5".equals(parse.getScheme())) ? false : true;
    }

    public final void a() {
        if (this.d != null) {
            this.d = null;
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        try {
            StringBuilder sb = new StringBuilder("javascript:");
            com.anythink.expressad.d.b.a.a();
            sb.append(com.anythink.expressad.d.b.a.b());
            if (Build.VERSION.SDK_INT <= 19) {
                Tracker.loadUrl(webView, sb.toString());
            } else {
                webView.evaluateJavascript(sb.toString(), new ValueCallback<String>() { // from class: com.anythink.expressad.advanced.view.a.1
                    private static void a() {
                    }

                    @Override // android.webkit.ValueCallback
                    public final /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                    }
                });
            }
        } catch (Throwable th) {
            o.b("NativeAdvancedWebViewClient", "onPageStarted", th);
        }
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return a(Build.VERSION.SDK_INT >= 21 ? webResourceRequest.getUrl().toString() : "");
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        o.a("NativeAdvancedWebViewClient", "============shouldInterceptRequest:".concat(String.valueOf(str)));
        return a(str);
    }

    @Override // com.anythink.expressad.atsignalcommon.base.b, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            try {
                WindVaneWebView windVaneWebView = (WindVaneWebView) webView;
                if (System.currentTimeMillis() - windVaneWebView.lastTouchTime > com.anythink.expressad.a.b.a.f6956c) {
                    com.anythink.expressad.foundation.d.c cVar = ((NativeAdvancedJSBridgeImpl) windVaneWebView.getObject()).getmCampaignList().get(0);
                    windVaneWebView.getUrl();
                    int i = com.anythink.expressad.a.b.a.b;
                    if (com.anythink.expressad.a.b.a.a(cVar)) {
                        return false;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            o.d("NativeAdvancedWebViewClient", "Use html to open url.");
            if (this.b != null) {
                this.b.a(str);
                return true;
            }
            return true;
        } catch (Throwable th) {
            o.b("NativeAdvancedWebViewClient", "shouldOverrideUrlLoading", th);
            return false;
        }
    }
}
