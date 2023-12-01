package com.hihonor.push.sdk;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/HonorPushCallback.class */
public interface HonorPushCallback<T> {
    void onFailure(int i, String str);

    void onSuccess(T t);
}
