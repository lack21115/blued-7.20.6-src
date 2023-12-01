package com.huawei.hms.core.aidl;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.client.Status;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/core/aidl/AbstractMessageEntity.class */
public class AbstractMessageEntity implements IMessageEntity {
    @Packed
    private Status commonStatus;

    public Status getCommonStatus() {
        return this.commonStatus;
    }

    public void setCommonStatus(Status status) {
        this.commonStatus = status;
    }
}
