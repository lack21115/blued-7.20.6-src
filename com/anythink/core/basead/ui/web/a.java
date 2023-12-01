package com.anythink.core.basead.ui.web;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.anythink.core.common.e.am;
import com.anythink.core.common.res.d;
import com.bytedance.applog.tracker.Tracker;
import org.json.JSONArray;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/basead/ui/web/a.class */
final class a extends WebViewClient {
    private WebLandPageActivity a;

    public a(WebLandPageActivity webLandPageActivity) {
        this.a = webLandPageActivity;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.a.a(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        WebProgressBarView a = this.a.a();
        if (a != null) {
            a.setVisibility(0);
            a.setProgress(0);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
    }

    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        this.a.finish();
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (TextUtils.isEmpty(str) || d.a.equals(str)) {
            return false;
        }
        WebLandPageActivity webLandPageActivity = this.a;
        if (webLandPageActivity != null) {
            if (webLandPageActivity.b == null) {
                webLandPageActivity.b = new JSONArray();
            }
            webLandPageActivity.b.put(str);
        }
        am a = com.anythink.core.basead.a.a.a(webView.getContext(), str);
        if (a.m) {
            WebLandPageActivity webLandPageActivity2 = this.a;
            if (webLandPageActivity2 != null) {
                webLandPageActivity2.a(a);
                return true;
            }
            return true;
        }
        WebLandPageActivity webLandPageActivity3 = this.a;
        if (webLandPageActivity3 != null) {
            webLandPageActivity3.a(a);
        }
        am a2 = com.anythink.core.basead.a.a.a(str);
        WebLandPageActivity webLandPageActivity4 = this.a;
        if (webLandPageActivity4 != null) {
            webLandPageActivity4.a(a2);
        }
        if (TextUtils.equals(a2.o, str)) {
            return false;
        }
        Tracker.loadUrl(webView, a2.o);
        return true;
    }
}
