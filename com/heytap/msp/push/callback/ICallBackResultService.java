package com.heytap.msp.push.callback;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/push/callback/ICallBackResultService.class */
public interface ICallBackResultService {
    void onError(int i, String str);

    void onGetNotificationStatus(int i, int i2);

    void onGetPushStatus(int i, int i2);

    void onRegister(int i, String str);

    void onSetPushTime(int i, String str);

    void onUnRegister(int i);
}
