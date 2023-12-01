package com.tencent.map.tools.net.http;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/tools/net/http/HttpResponseListener.class */
public interface HttpResponseListener<T> {
    void onFailure(int i, String str, Throwable th);

    void onSuccess(int i, T t);
}
