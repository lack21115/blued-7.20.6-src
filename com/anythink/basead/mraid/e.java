package com.anythink.basead.mraid;

import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.anythink.expressad.foundation.h.o;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/mraid/e.class */
public final class e extends com.anythink.expressad.atsignalcommon.base.b {
    final String a = getClass().getSimpleName();
    String b;
    b c;

    public e(String str) {
        this.b = str;
    }

    private void a(b bVar) {
        this.c = bVar;
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        try {
            StringBuilder sb = new StringBuilder(BridgeUtil.JAVASCRIPT_STR);
            com.anythink.expressad.d.b.a.a();
            sb.append(com.anythink.expressad.d.b.a.b());
            if (Build.VERSION.SDK_INT <= 19) {
                Tracker.loadUrl(webView, sb.toString());
            } else {
                webView.evaluateJavascript(sb.toString(), new ValueCallback<String>() { // from class: com.anythink.basead.mraid.e.1
                    private static void a() {
                    }

                    @Override // android.webkit.ValueCallback
                    public final /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                    }
                });
            }
        } catch (Throwable th) {
            o.b(this.a, "onPageStarted", th);
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            if (TextUtils.equals(str, this.b)) {
                return true;
            }
            o.d(this.a, "Use html to open url.");
            if (this.c != null) {
                this.c.open(str);
                return true;
            }
            return true;
        } catch (Throwable th) {
            o.b(this.a, "shouldOverrideUrlLoading", th);
            return false;
        }
    }
}
