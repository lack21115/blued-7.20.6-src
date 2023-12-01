package com.blued.android.module.common.web.jsbridge;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/web/jsbridge/DefaultHandler.class */
public class DefaultHandler implements BridgeHandler {
    String TAG = "DefaultHandler";

    @Override // com.blued.android.module.common.web.jsbridge.BridgeHandler
    public void handler(String str, CallBackFunction callBackFunction) {
        if (callBackFunction != null) {
            callBackFunction.onCallBack("DefaultHandler response data");
        }
    }
}
