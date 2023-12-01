package com.youzan.jsbridge.dispatcher;

import android.text.TextUtils;
import com.youzan.jsbridge.method.Method;
import com.youzan.jsbridge.subscriber.Subscriber;
import com.youzan.jsbridge.util.Logger;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/jsbridge/dispatcher/MethodDispatcher.class */
public abstract class MethodDispatcher<T extends Method> {
    protected Map<String, Subscriber<T>> mSubscribers = new HashMap();

    public final boolean dispatch(T t) {
        Subscriber<T> subscriber;
        String name = t.getName();
        if (TextUtils.isEmpty(name) || (subscriber = this.mSubscribers.get(name)) == null) {
            return false;
        }
        doCall(t, subscriber);
        return true;
    }

    public abstract void doCall(T t, Subscriber<T> subscriber);

    public final void subscribe(Subscriber<T> subscriber) {
        if (this.mSubscribers.get(subscriber.subscribe()) != null) {
            Logger.w("Subscriber named " + subscriber.subscribe() + " has already existed.");
        }
        this.mSubscribers.put(subscriber.subscribe(), subscriber);
    }
}
