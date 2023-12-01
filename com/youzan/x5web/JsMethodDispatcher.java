package com.youzan.x5web;

import android.os.Handler;
import com.tencent.smtt.sdk.WebView;
import com.youzan.jsbridge.dispatcher.MethodDispatcher;
import com.youzan.jsbridge.method.JsMethod;
import com.youzan.jsbridge.method.JsMethodCompat;
import com.youzan.jsbridge.method.Method;
import com.youzan.jsbridge.subscriber.Subscriber;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/x5web/JsMethodDispatcher.class */
public class JsMethodDispatcher<T extends Method> extends MethodDispatcher<T> {
    private JsTrigger mJsTrigger;
    private Handler mMainThreadHandler = new Handler();
    private WebView mWebView;

    public JsMethodDispatcher(WebView webView) {
        this.mWebView = webView;
        this.mJsTrigger = new JsTrigger(webView);
    }

    @Override // com.youzan.jsbridge.dispatcher.MethodDispatcher
    public void doCall(final T t, final Subscriber<T> subscriber) {
        if (subscriber instanceof JsSubscriber) {
            final JsSubscriber jsSubscriber = (JsSubscriber) subscriber;
            jsSubscriber.withCall(this.mWebView, this.mJsTrigger);
            this.mMainThreadHandler.post(new Runnable() { // from class: com.youzan.x5web.JsMethodDispatcher.1
                @Override // java.lang.Runnable
                public void run() {
                    jsSubscriber.onCall((JsMethod) t);
                }
            });
        } else if (!(subscriber instanceof JsSubscriberCompat)) {
            this.mMainThreadHandler.post(new Runnable() { // from class: com.youzan.x5web.JsMethodDispatcher.3
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    subscriber.onCall(t);
                }
            });
        } else {
            final JsSubscriberCompat jsSubscriberCompat = (JsSubscriberCompat) subscriber;
            jsSubscriberCompat.withCall(this.mWebView, this.mJsTrigger);
            this.mMainThreadHandler.post(new Runnable() { // from class: com.youzan.x5web.JsMethodDispatcher.2
                @Override // java.lang.Runnable
                public void run() {
                    jsSubscriberCompat.onCall((JsMethodCompat) t);
                }
            });
        }
    }
}
