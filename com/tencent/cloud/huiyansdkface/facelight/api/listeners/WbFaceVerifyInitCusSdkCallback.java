package com.tencent.cloud.huiyansdkface.facelight.api.listeners;

import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceError;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/api/listeners/WbFaceVerifyInitCusSdkCallback.class */
public interface WbFaceVerifyInitCusSdkCallback {
    void onInitFailed(WbFaceError wbFaceError);

    void onInitSuccess(Map<String, String> map);
}
