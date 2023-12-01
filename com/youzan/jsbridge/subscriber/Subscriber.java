package com.youzan.jsbridge.subscriber;

import com.youzan.jsbridge.method.Method;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/jsbridge/subscriber/Subscriber.class */
public interface Subscriber<T extends Method> {
    void onCall(T t);

    String subscribe();
}
