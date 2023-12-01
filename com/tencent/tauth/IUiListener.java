package com.tencent.tauth;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tauth/IUiListener.class */
public interface IUiListener {
    void onCancel();

    void onComplete(Object obj);

    void onError(UiError uiError);
}
