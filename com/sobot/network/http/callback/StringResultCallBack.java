package com.sobot.network.http.callback;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/callback/StringResultCallBack.class */
public interface StringResultCallBack<T> {
    void onFailure(Exception exc, String str);

    void onSuccess(T t);
}
