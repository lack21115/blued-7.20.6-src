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
    public WebView f38453a = null;

    /* renamed from: c  reason: collision with root package name */
    public final a f38454c = new a("x5");

    public k(Context context) {
        this.b = context;
    }

    public final void a() {
        WebView webView = this.f38453a;
        if (webView != null) {
            webView.destroy();
            this.f38453a = null;
        }
    }

    public final void b() {
        WebView webView = new WebView(this.b);
        this.f38453a = webView;
        if (webView.getX5WebViewExtension() == null) {
            this.f38454c.a("x5_sys");
        }
        this.f38453a.removeJavascriptInterface("searchBoxJavaBridge_");
        this.f38453a.removeJavascriptInterface(Context.ACCESSIBILITY_SERVICE);
        this.f38453a.removeJavascriptInterface("accessibilityTraversal");
        WebSettings settings = this.f38453a.getSettings();
        settings.setSavePassword(false);
        settings.setAllowFileAccess(true);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(-1);
        this.f38453a.addJavascriptInterface(this.f38454c, "JSInterface");
        this.f38453a.setWebViewClient(new h(this));
        Tracker.loadUrl(this.f38453a, com.tencent.qimei.a.a.a(this.b));
    }
}
