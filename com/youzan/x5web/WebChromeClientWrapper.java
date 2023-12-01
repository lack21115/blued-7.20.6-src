package com.youzan.x5web;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import com.igexin.push.core.b;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebStorage;
import com.tencent.smtt.sdk.WebView;
import com.youzan.spiderman.cache.CacheHandler;
import com.youzan.spiderman.cache.CacheStatistic;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/x5web/WebChromeClientWrapper.class */
public class WebChromeClientWrapper extends WebChromeClient {
    private static final String TAG = "WebChromeClientWrapper";
    private CacheHandler mCacheHandler;
    private WebChromeClient mDelegate;
    private JsInjecter mJsInjecter;

    public WebChromeClientWrapper(JsInjecter jsInjecter) {
        this.mJsInjecter = jsInjecter;
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        WebChromeClient webChromeClient = this.mDelegate;
        return webChromeClient != null ? webChromeClient.getDefaultVideoPoster() : super.getDefaultVideoPoster();
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public View getVideoLoadingProgressView() {
        WebChromeClient webChromeClient = this.mDelegate;
        return webChromeClient != null ? webChromeClient.getVideoLoadingProgressView() : super.getVideoLoadingProgressView();
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.getVisitedHistory(valueCallback);
        } else {
            super.getVisitedHistory(valueCallback);
        }
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onCloseWindow(WebView webView) {
        WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onCloseWindow(webView);
        } else {
            super.onCloseWindow(webView);
        }
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        WebChromeClient webChromeClient = this.mDelegate;
        return webChromeClient != null ? webChromeClient.onConsoleMessage(consoleMessage) : super.onConsoleMessage(consoleMessage);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebChromeClient webChromeClient = this.mDelegate;
        return webChromeClient != null ? webChromeClient.onCreateWindow(webView, z, z2, message) : super.onCreateWindow(webView, z, z2, message);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        } else {
            super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        }
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onGeolocationPermissionsHidePrompt();
        } else {
            super.onGeolocationPermissionsHidePrompt();
        }
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
        WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
        } else {
            super.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
        }
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onHideCustomView() {
        WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onHideCustomView();
        } else {
            super.onHideCustomView();
        }
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        WebChromeClient webChromeClient = this.mDelegate;
        return webChromeClient != null ? webChromeClient.onJsAlert(webView, str, str2, jsResult) : super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        WebChromeClient webChromeClient = this.mDelegate;
        return webChromeClient != null ? webChromeClient.onJsBeforeUnload(webView, str, str2, jsResult) : super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        WebChromeClient webChromeClient = this.mDelegate;
        return webChromeClient != null ? webChromeClient.onJsConfirm(webView, str, str2, jsResult) : super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (this.mJsInjecter.jsPrompt(str2, jsPromptResult)) {
            return true;
        }
        if (!CacheStatistic.isStatisticUrl(str2)) {
            WebChromeClient webChromeClient = this.mDelegate;
            return webChromeClient != null ? webChromeClient.onJsPrompt(webView, str, str2, str3, jsPromptResult) : super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        this.mCacheHandler.parseStatisticTiming(str2);
        jsPromptResult.confirm(b.x);
        return true;
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onJsTimeout() {
        WebChromeClient webChromeClient = this.mDelegate;
        return webChromeClient != null ? webChromeClient.onJsTimeout() : super.onJsTimeout();
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        this.mJsInjecter.shouldInjectJs(webView, i);
        WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onProgressChanged(webView, i);
        } else {
            super.onProgressChanged(webView, i);
        }
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
        } else {
            super.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
        }
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onReceivedIcon(webView, bitmap);
        } else {
            super.onReceivedIcon(webView, bitmap);
        }
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onReceivedTitle(webView, str);
        } else {
            super.onReceivedTitle(webView, str);
        }
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onReceivedTouchIconUrl(webView, str, z);
        } else {
            super.onReceivedTouchIconUrl(webView, str, z);
        }
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onRequestFocus(WebView webView) {
        WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onRequestFocus(webView);
        } else {
            super.onRequestFocus(webView);
        }
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onShowCustomView(View view, int i, IX5WebChromeClient.CustomViewCallback customViewCallback) {
        WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onShowCustomView(view, i, customViewCallback);
        } else {
            super.onShowCustomView(view, i, customViewCallback);
        }
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onShowCustomView(View view, IX5WebChromeClient.CustomViewCallback customViewCallback) {
        WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onShowCustomView(view, customViewCallback);
        } else {
            super.onShowCustomView(view, customViewCallback);
        }
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        WebChromeClient webChromeClient = this.mDelegate;
        return webChromeClient != null ? webChromeClient.onShowFileChooser(webView, valueCallback, fileChooserParams) : super.onShowFileChooser(webView, valueCallback, fileChooserParams);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.openFileChooser(valueCallback, str, str2);
        } else {
            super.openFileChooser(valueCallback, str, str2);
        }
    }

    public void setCacheHandler(CacheHandler cacheHandler) {
        this.mCacheHandler = cacheHandler;
    }

    public void setDelegate(WebChromeClient webChromeClient) {
        this.mDelegate = webChromeClient;
    }
}
