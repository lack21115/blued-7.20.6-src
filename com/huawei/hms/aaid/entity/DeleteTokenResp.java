package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/aaid/entity/DeleteTokenResp.class */
public class DeleteTokenResp implements IMessageEntity {
    @Packed
    private int retCode = 0;

    public int getRetCode() {
        return this.retCode;
    }

    public void setRetCode(int i) {
        this.retCode = i;
    }
}
