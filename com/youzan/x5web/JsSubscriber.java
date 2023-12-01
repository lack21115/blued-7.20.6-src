package com.youzan.x5web;

import com.tencent.smtt.sdk.WebView;
import com.youzan.jsbridge.method.JsMethod;
import com.youzan.jsbridge.subscriber.MethodSubscriber;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/x5web/JsSubscriber.class */
public abstract class JsSubscriber implements MethodSubscriber {
    private JsTrigger mJstrigger;
    private WebView mWebView;

    public abstract void onCall(WebView webView, JsMethod jsMethod, JsTrigger jsTrigger);

    @Override // com.youzan.jsbridge.subscriber.Subscriber
    public final void onCall(JsMethod jsMethod) {
        onCall(this.mWebView, jsMethod, this.mJstrigger);
    }

    public void withCall(WebView webView, JsTrigger jsTrigger) {
        this.mWebView = webView;
        this.mJstrigger = jsTrigger;
    }
}
