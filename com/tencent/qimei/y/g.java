package com.tencent.qimei.y;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/y/g.class */
public class g {
    public Context b;

    /* renamed from: a  reason: collision with root package name */
    public WebView f24758a = null;

    /* renamed from: c  reason: collision with root package name */
    public final a f24759c = new a("sys");

    public g(Context context) {
        this.b = context;
    }

    public static /* synthetic */ void a(g gVar) {
        if (gVar.f24758a != null) {
            gVar.a();
        }
        try {
            WebView webView = new WebView(gVar.b);
            gVar.f24758a = webView;
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            gVar.f24758a.removeJavascriptInterface(Context.ACCESSIBILITY_SERVICE);
            gVar.f24758a.removeJavascriptInterface("accessibilityTraversal");
            WebSettings settings = gVar.f24758a.getSettings();
            settings.setSavePassword(false);
            settings.setAllowFileAccess(false);
            if (Build.VERSION.SDK_INT >= 16) {
                settings.setAllowFileAccessFromFileURLs(false);
                settings.setAllowUniversalAccessFromFileURLs(false);
            }
            settings.setJavaScriptEnabled(true);
            settings.setAllowFileAccess(true);
            settings.setCacheMode(-1);
            gVar.f24758a.addJavascriptInterface(gVar.f24759c, "JSInterface");
            gVar.f24758a.setWebViewClient(new d(gVar));
            Tracker.loadUrl(gVar.f24758a, com.tencent.qimei.a.a.a(gVar.b));
        } catch (RuntimeException e) {
            com.tencent.qimei.k.a.a(e);
        }
    }

    public final void a() {
        WebView webView = this.f24758a;
        if (webView != null) {
            webView.destroy();
            this.f24758a = null;
        }
    }

    public final void a(WebView webView) {
        if (Build.VERSION.SDK_INT >= 19) {
            webView.evaluateJavascript("javascript:new Fingerprint().getNative()", new c(this));
        } else {
            Tracker.loadUrl(webView, "javascript:new Fingerprint().getNative()");
        }
    }
}
