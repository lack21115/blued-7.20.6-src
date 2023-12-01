package com.tencent.tendinsv.listener;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/listener/LoginAuthCallbacks.class */
public interface LoginAuthCallbacks {
    void getTokenFailed(int i, int i2, String str, String str2, String str3, long j, long j2, long j3);

    void getTokenSuccessed(int i, int i2, String str, String str2, long j, long j2, long j3);
}
