package com.huawei.hms.support.api.entity.opendevice;

import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/support/api/entity/opendevice/OdidResp.class */
public class OdidResp extends AbstractMessageEntity {
    @Packed
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }
}
