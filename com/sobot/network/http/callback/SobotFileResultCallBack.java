package com.sobot.network.http.callback;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/callback/SobotFileResultCallBack.class */
public interface SobotFileResultCallBack<T> {
    void inProgress(int i);

    void onFailure(Exception exc, String str);

    void onSuccess(T t);
}
