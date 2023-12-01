package com.youzan.x5web;

import com.tencent.smtt.sdk.WebView;
import com.youzan.jsbridge.method.JsMethodCompat;
import com.youzan.jsbridge.subscriber.MethodSubscriberCompat;

@Deprecated
/* loaded from: source-8829756-dex2jar.jar:com/youzan/x5web/JsSubscriberCompat.class */
public abstract class JsSubscriberCompat implements MethodSubscriberCompat {
    private JsTrigger mJstrigger;
    private WebView mWebView;

    public abstract void onCall(WebView webView, JsMethodCompat jsMethodCompat, JsTrigger jsTrigger);

    @Override // com.youzan.jsbridge.subscriber.Subscriber
    public final void onCall(JsMethodCompat jsMethodCompat) {
        onCall(this.mWebView, jsMethodCompat, this.mJstrigger);
    }

    public void withCall(WebView webView, JsTrigger jsTrigger) {
        this.mWebView = webView;
        this.mJstrigger = jsTrigger;
    }
}
