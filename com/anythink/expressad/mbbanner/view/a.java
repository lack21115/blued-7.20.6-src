package com.anythink.expressad.mbbanner.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.anythink.core.common.b.n;
import com.anythink.expressad.atsignalcommon.base.BaseWebView;
import com.anythink.expressad.atsignalcommon.base.b;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.o;
import com.bytedance.applog.tracker.Tracker;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/mbbanner/view/a.class */
public final class a extends b {

    /* renamed from: a  reason: collision with root package name */
    String f8056a;
    List<c> b;

    /* renamed from: c  reason: collision with root package name */
    com.anythink.expressad.mbbanner.a.c.a f8057c;
    private final String d = "BannerWebViewClient";

    public a(String str, List<c> list, com.anythink.expressad.mbbanner.a.c.a aVar) {
        this.f8056a = str;
        this.b = list;
        this.f8057c = aVar;
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
                webView.evaluateJavascript(sb.toString(), new ValueCallback<String>() { // from class: com.anythink.expressad.mbbanner.view.a.1
                    private static void a() {
                    }

                    @Override // android.webkit.ValueCallback
                    public final /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                    }
                });
            }
        } catch (Throwable th) {
            o.b("BannerWebViewClient", "onPageStarted", th);
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    @Override // com.anythink.expressad.atsignalcommon.base.b, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            o.d("BannerWebViewClient", "Use html to open url.");
            BaseWebView baseWebView = (BaseWebView) webView;
            if (System.currentTimeMillis() - baseWebView.lastTouchTime > com.anythink.expressad.a.b.a.f6956c) {
                c cVar = this.b.get(0);
                baseWebView.getUrl();
                int i = com.anythink.expressad.a.b.a.b;
                if (com.anythink.expressad.a.b.a.a(cVar)) {
                    return false;
                }
            }
            String str2 = str;
            if (this.b.size() > 1) {
                n.a().g().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                str2 = null;
            }
            if (this.f8057c != null) {
                this.f8057c.a(false, str2);
                return true;
            }
            return true;
        } catch (Throwable th) {
            o.b("BannerWebViewClient", "shouldOverrideUrlLoading", th);
            return false;
        }
    }
}
