package com.tencent.cloud.huiyansdkface.facelight.provider;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/provider/ProcessCallback.class */
public interface ProcessCallback<T> {
    void onFailed(WbFaceInnerError wbFaceInnerError);

    void onSuccess(T t);

    void onUiNetworkRetryTip();
}
