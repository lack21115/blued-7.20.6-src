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

    /* renamed from: a  reason: collision with root package name */
    private WebLandPageActivity f6408a;

    public a(WebLandPageActivity webLandPageActivity) {
        this.f6408a = webLandPageActivity;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f6408a.a(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        WebProgressBarView a2 = this.f6408a.a();
        if (a2 != null) {
            a2.setVisibility(0);
            a2.setProgress(0);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
    }

    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        this.f6408a.finish();
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (TextUtils.isEmpty(str) || d.f6907a.equals(str)) {
            return false;
        }
        WebLandPageActivity webLandPageActivity = this.f6408a;
        if (webLandPageActivity != null) {
            if (webLandPageActivity.b == null) {
                webLandPageActivity.b = new JSONArray();
            }
            webLandPageActivity.b.put(str);
        }
        am a2 = com.anythink.core.basead.a.a.a(webView.getContext(), str);
        if (a2.m) {
            WebLandPageActivity webLandPageActivity2 = this.f6408a;
            if (webLandPageActivity2 != null) {
                webLandPageActivity2.a(a2);
                return true;
            }
            return true;
        }
        WebLandPageActivity webLandPageActivity3 = this.f6408a;
        if (webLandPageActivity3 != null) {
            webLandPageActivity3.a(a2);
        }
        am a3 = com.anythink.core.basead.a.a.a(str);
        WebLandPageActivity webLandPageActivity4 = this.f6408a;
        if (webLandPageActivity4 != null) {
            webLandPageActivity4.a(a3);
        }
        if (TextUtils.equals(a3.o, str)) {
            return false;
        }
        Tracker.loadUrl(webView, a3.o);
        return true;
    }
}
