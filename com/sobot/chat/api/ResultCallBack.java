package com.sobot.chat.api;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/ResultCallBack.class */
public interface ResultCallBack<T> {
    void onFailure(Exception exc, String str);

    void onLoading(long j, long j2, boolean z);

    void onSuccess(T t);
}
