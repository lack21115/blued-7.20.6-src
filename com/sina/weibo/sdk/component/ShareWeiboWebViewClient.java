package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.utils.Utility;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/component/ShareWeiboWebViewClient.class */
public class ShareWeiboWebViewClient extends WeiboWebViewClient {
    private static final String RESP_PARAM_CODE = "code";
    private static final String RESP_PARAM_MSG = "msg";
    private static final String RESP_SUCC_CODE = "0";
    private Activity mAct;
    private WeiboAuthListener mListener;
    private ShareRequestParam mShareRequestParam;

    public ShareWeiboWebViewClient(Activity activity, ShareRequestParam shareRequestParam) {
        this.mAct = activity;
        this.mShareRequestParam = shareRequestParam;
        this.mListener = shareRequestParam.getAuthListener();
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
        this.mShareRequestParam.sendSdkErrorResponse(this.mAct, str);
        WeiboSdkBrowser.closeBrowser(this.mAct, this.mShareRequestParam.getAuthListenerKey(), null);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.mCallBack != null) {
            this.mCallBack.onReceivedSslErrorCallBack(webView, sslErrorHandler, sslError);
        }
        sslErrorHandler.cancel();
        this.mShareRequestParam.sendSdkErrorResponse(this.mAct, "ReceivedSslError");
        WeiboSdkBrowser.closeBrowser(this.mAct, this.mShareRequestParam.getAuthListenerKey(), null);
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
            String string = parseUri.getString("code");
            String string2 = parseUri.getString("msg");
            if (TextUtils.isEmpty(string)) {
                this.mShareRequestParam.sendSdkCancleResponse(this.mAct);
            } else if ("0".equals(string)) {
                this.mShareRequestParam.sendSdkOkResponse(this.mAct);
            } else {
                this.mShareRequestParam.sendSdkErrorResponse(this.mAct, string2);
            }
            WeiboSdkBrowser.closeBrowser(this.mAct, this.mShareRequestParam.getAuthListenerKey(), null);
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
