package com.sdk.tencent.base.api;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/base/api/CallBack.class */
public interface CallBack<T> {
    void onFailed(int i, int i2, String str, String str2);

    void onSuccess(int i, String str, int i2, T t, String str2);
}
