package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/bn.class */
public final class bn {
    public static WebSettings a(WebView webView) {
        webView.getSettings().setAllowFileAccess(false);
        return b(webView);
    }

    private static WebSettings b(WebView webView) {
        WebSettings settings = webView.getSettings();
        settings.setAllowContentAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setTextZoom(100);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        if (Build.VERSION.SDK_INT < 19) {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface(Context.ACCESSIBILITY_SERVICE);
            webView.removeJavascriptInterface("accessibilityTraversal");
        }
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        }
        webView.setSaveEnabled(false);
        return settings;
    }
}
