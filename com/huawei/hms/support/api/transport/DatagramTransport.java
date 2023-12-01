package com.huawei.hms.support.api.transport;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/support/api/transport/DatagramTransport.class */
public interface DatagramTransport {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/support/api/transport/DatagramTransport$a.class */
    public interface a {
        void a(int i, IMessageEntity iMessageEntity);
    }

    void post(ApiClient apiClient, a aVar);

    void send(ApiClient apiClient, a aVar);
}
