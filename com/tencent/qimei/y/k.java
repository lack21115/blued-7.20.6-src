package com.tencent.qimei.y;

import android.content.Context;
import android.os.Build;
import com.bytedance.applog.tracker.Tracker;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/y/k.class */
public class k {
    public Context b;

    /* renamed from: a  reason: collision with root package name */
    public WebView f24762a = null;

    /* renamed from: c  reason: collision with root package name */
    public final a f24763c = new a("x5");

    public k(Context context) {
        this.b = context;
    }

    public final void a() {
        WebView webView = this.f24762a;
        if (webView != null) {
            webView.destroy();
            this.f24762a = null;
        }
    }

    public final void b() {
        WebView webView = new WebView(this.b);
        this.f24762a = webView;
        if (webView.getX5WebViewExtension() == null) {
            this.f24763c.a("x5_sys");
        }
        this.f24762a.removeJavascriptInterface("searchBoxJavaBridge_");
        this.f24762a.removeJavascriptInterface(Context.ACCESSIBILITY_SERVICE);
        this.f24762a.removeJavascriptInterface("accessibilityTraversal");
        WebSettings settings = this.f24762a.getSettings();
        settings.setSavePassword(false);
        settings.setAllowFileAccess(true);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(-1);
        this.f24762a.addJavascriptInterface(this.f24763c, "JSInterface");
        this.f24762a.setWebViewClient(new h(this));
        Tracker.loadUrl(this.f24762a, com.tencent.qimei.a.a.a(this.b));
    }
}
