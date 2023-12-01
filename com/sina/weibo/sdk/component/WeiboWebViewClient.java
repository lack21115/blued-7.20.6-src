package com.sina.weibo.sdk.component;

import android.webkit.WebViewClient;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/component/WeiboWebViewClient.class */
abstract class WeiboWebViewClient extends WebViewClient {
    protected BrowserRequestCallBack mCallBack;

    public void setBrowserRequestCallBack(BrowserRequestCallBack browserRequestCallBack) {
        this.mCallBack = browserRequestCallBack;
    }
}
