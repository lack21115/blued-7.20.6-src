package com.alipay.sdk.widget;

import android.app.Activity;
import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.applog.tracker.Tracker;
import java.lang.reflect.Method;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/widget/h.class */
public class h extends g {
    private com.alipay.sdk.app.b b;

    /* renamed from: c  reason: collision with root package name */
    private WebView f4686c;

    public h(Activity activity, com.alipay.sdk.sys.a aVar) {
        super(activity);
        this.f4686c = new WebView(activity);
        a(activity);
        addView(this.f4686c);
        com.alipay.sdk.app.b bVar = new com.alipay.sdk.app.b(activity, aVar);
        this.b = bVar;
        this.f4686c.setWebViewClient(bVar);
    }

    private void a(Context context) {
        WebSettings settings = this.f4686c.getSettings();
        settings.setUserAgentString(settings.getUserAgentString() + com.alipay.sdk.util.n.c(context));
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setMinimumFontSize(settings.getMinimumFontSize() + 8);
        settings.setAllowFileAccess(false);
        settings.setTextSize(WebSettings.TextSize.NORMAL);
        settings.setDomStorageEnabled(true);
        settings.setCacheMode(1);
        this.f4686c.resumeTimers();
        this.f4686c.setVerticalScrollbarOverlay(true);
        this.f4686c.setDownloadListener(new i(this));
        try {
            this.f4686c.removeJavascriptInterface("searchBoxJavaBridge_");
            this.f4686c.removeJavascriptInterface(Context.ACCESSIBILITY_SERVICE);
            this.f4686c.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            try {
                Method method = this.f4686c.getClass().getMethod("removeJavascriptInterface", new Class[0]);
                if (method != null) {
                    method.invoke(this.f4686c, "searchBoxJavaBridge_");
                    method.invoke(this.f4686c, Context.ACCESSIBILITY_SERVICE);
                    method.invoke(this.f4686c, "accessibilityTraversal");
                }
            } catch (Throwable th2) {
            }
        }
    }

    @Override // com.alipay.sdk.widget.g
    public void a() {
        this.b.a();
        removeAllViews();
    }

    @Override // com.alipay.sdk.widget.g
    public void a(String str) {
        Tracker.loadUrl(this.f4686c, str);
    }

    @Override // com.alipay.sdk.widget.g
    public boolean b() {
        if (!this.f4686c.canGoBack()) {
            com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.c());
            this.f4685a.finish();
            return true;
        } else if (this.b.b()) {
            com.alipay.sdk.app.k b = com.alipay.sdk.app.k.b(com.alipay.sdk.app.k.NETWORK_ERROR.a());
            com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.a(b.a(), b.b(), ""));
            this.f4685a.finish();
            return true;
        } else {
            return true;
        }
    }
}
