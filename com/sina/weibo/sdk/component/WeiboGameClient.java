package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.sina.weibo.sdk.utils.Utility;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/component/WeiboGameClient.class */
public class WeiboGameClient extends WeiboWebViewClient {
    private Activity mAct;
    private GameRequestParam mGameRequestParam;
    private WeiboAuthListener mListener;

    public WeiboGameClient(Activity activity, GameRequestParam gameRequestParam) {
        this.mAct = activity;
        this.mGameRequestParam = gameRequestParam;
        this.mListener = gameRequestParam.getAuthListener();
    }

    private void handleRedirectUrl(String str) {
        Bundle parseUrl = Utility.parseUrl(str);
        String string = parseUrl.getString("error") == null ? "" : parseUrl.getString("error");
        String string2 = parseUrl.getString("code");
        String string3 = parseUrl.getString("msg");
        if (string == null && string2 == null) {
            WeiboAuthListener weiboAuthListener = this.mListener;
            if (weiboAuthListener != null) {
                weiboAuthListener.onComplete(parseUrl);
                return;
            }
            return;
        }
        WeiboAuthListener weiboAuthListener2 = this.mListener;
        if (weiboAuthListener2 != null) {
            weiboAuthListener2.onWeiboException(new WeiboAuthException(string2, string, string3));
        }
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
        if (str.startsWith(WeiboSdkBrowser.BROWSER_CLOSE_SCHEME)) {
            Bundle parseUri = Utility.parseUri(str);
            if (!parseUri.isEmpty() && (weiboAuthListener = this.mListener) != null) {
                weiboAuthListener.onComplete(parseUri);
            }
            WeiboSdkBrowser.closeBrowser(this.mAct, this.mGameRequestParam.getAuthListenerKey(), null);
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
