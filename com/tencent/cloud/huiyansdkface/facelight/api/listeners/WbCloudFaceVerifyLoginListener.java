package com.tencent.cloud.huiyansdkface.facelight.api.listeners;

import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceError;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/api/listeners/WbCloudFaceVerifyLoginListener.class */
public interface WbCloudFaceVerifyLoginListener {
    void onLoginFailed(WbFaceError wbFaceError);

    void onLoginSuccess();
}
