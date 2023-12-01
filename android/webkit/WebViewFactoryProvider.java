package android.webkit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;

/* loaded from: source-4181928-dex2jar.jar:android/webkit/WebViewFactoryProvider.class */
public interface WebViewFactoryProvider {

    /* loaded from: source-4181928-dex2jar.jar:android/webkit/WebViewFactoryProvider$Statics.class */
    public interface Statics {
        void clearClientCertPreferences(Runnable runnable);

        void enableSlowWholeDocumentDraw();

        String findAddress(String str);

        void freeMemoryForTests();

        String getDefaultUserAgent(Context context);

        Uri[] parseFileChooserResult(int i, Intent intent);

        void setWebContentsDebuggingEnabled(boolean z);
    }

    WebViewProvider createWebView(WebView webView, WebView.PrivateAccess privateAccess);

    CookieManager getCookieManager();

    GeolocationPermissions getGeolocationPermissions();

    Statics getStatics();

    WebIconDatabase getWebIconDatabase();

    WebStorage getWebStorage();

    WebViewDatabase getWebViewDatabase(Context context);
}
