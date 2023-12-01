package com.tencent.cloud.huiyansdkface.facelight.provider;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/provider/WbWillFinishCallback.class */
public interface WbWillFinishCallback {
    void onAnswerErrorRestart();

    void onFinish(String str, String str2, String str3, String str4);

    void onNativeException(WbFaceInnerError wbFaceInnerError);

    void onNoVoiceRestart(WbFaceInnerError wbFaceInnerError);

    void onStartAsr();
}
