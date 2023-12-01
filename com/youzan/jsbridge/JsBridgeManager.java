package com.youzan.jsbridge;

import com.youzan.jsbridge.dispatcher.MethodDispatcher;
import com.youzan.jsbridge.method.JsMethod;
import com.youzan.jsbridge.method.JsMethodCompat;
import com.youzan.jsbridge.subscriber.MethodSubscriber;
import com.youzan.jsbridge.subscriber.MethodSubscriberCompat;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/jsbridge/JsBridgeManager.class */
public final class JsBridgeManager {
    private MethodDispatcher<JsMethod> mDispatcher;
    private MethodDispatcher<JsMethodCompat> mDispatcherCompat;

    public JsBridgeManager(MethodDispatcher<JsMethod> methodDispatcher, MethodDispatcher<JsMethodCompat> methodDispatcher2) {
        this.mDispatcher = methodDispatcher;
        this.mDispatcherCompat = methodDispatcher2;
    }

    public void subscribe(MethodSubscriber methodSubscriber) {
        this.mDispatcher.subscribe(methodSubscriber);
    }

    @Deprecated
    public void subscribe(MethodSubscriberCompat methodSubscriberCompat) {
        this.mDispatcherCompat.subscribe(methodSubscriberCompat);
    }
}
