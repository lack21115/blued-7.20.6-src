package com.blued.android.sdk.model;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/sdk/model/ModelCallback.class */
public interface ModelCallback<T> {
    void onFailed(int i, String str);

    void onModel(T t);
}
