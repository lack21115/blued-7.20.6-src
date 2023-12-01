package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.sina.weibo.sdk.utils.Utility;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/component/WidgetWeiboWebViewClient.class */
public class WidgetWeiboWebViewClient extends WeiboWebViewClient {
    private Activity mAct;
    private WeiboAuthListener mListener;
    private WidgetRequestParam.WidgetRequestCallback mWidgetCallback;
    private WidgetRequestParam mWidgetRequestParam;

    public WidgetWeiboWebViewClient(Activity activity, WidgetRequestParam widgetRequestParam) {
        this.mAct = activity;
        this.mWidgetRequestParam = widgetRequestParam;
        this.mWidgetCallback = widgetRequestParam.getWidgetRequestCallback();
        this.mListener = widgetRequestParam.getAuthListener();
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (this.mCallBack != null) {
            this.mCallBack.onPageFinishedCallBack(webView, str);
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.mCallBack != null) {
            this.mCallBack.onPageStartedCallBack(webView, str, bitmap);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        if (this.mCallBack != null) {
            this.mCallBack.onReceivedErrorCallBack(webView, i, str, str2);
        }
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.mCallBack != null) {
            this.mCallBack.onReceivedSslErrorCallBack(webView, sslErrorHandler, sslError);
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        WeiboAuthListener weiboAuthListener;
        if (this.mCallBack != null) {
            this.mCallBack.shouldOverrideUrlLoadingCallBack(webView, str);
        }
        boolean startsWith = str.startsWith(WeiboSdkBrowser.BROWSER_CLOSE_SCHEME);
        if (str.startsWith(WeiboSdkBrowser.BROWSER_CLOSE_SCHEME) || str.startsWith(WeiboSdkBrowser.BROWSER_WIDGET_SCHEME)) {
            Bundle parseUri = Utility.parseUri(str);
            if (!parseUri.isEmpty() && (weiboAuthListener = this.mListener) != null) {
                weiboAuthListener.onComplete(parseUri);
            }
            WidgetRequestParam.WidgetRequestCallback widgetRequestCallback = this.mWidgetCallback;
            if (widgetRequestCallback != null) {
                widgetRequestCallback.onWebViewResult(str);
            }
            if (startsWith) {
                WeiboSdkBrowser.closeBrowser(this.mAct, this.mWidgetRequestParam.getAuthListenerKey(), this.mWidgetRequestParam.getWidgetRequestCallbackKey());
                return true;
            }
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
