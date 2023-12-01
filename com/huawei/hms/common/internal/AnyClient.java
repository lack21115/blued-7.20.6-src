package com.huawei.hms.common.internal;

import com.huawei.hms.core.aidl.IMessageEntity;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/internal/AnyClient.class */
public interface AnyClient {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/internal/AnyClient$CallBack.class */
    public interface CallBack {
        void onCallback(IMessageEntity iMessageEntity, String str);
    }

    void connect(int i);

    void connect(int i, boolean z);

    void disconnect();

    int getRequestHmsVersionCode();

    String getSessionId();

    boolean isConnected();

    boolean isConnecting();

    void post(IMessageEntity iMessageEntity, String str, CallBack callBack);
}
