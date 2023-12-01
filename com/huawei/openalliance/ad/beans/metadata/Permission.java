package com.huawei.openalliance.ad.beans.metadata;

import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/beans/metadata/Permission.class */
public class Permission implements Serializable {
    private static final long serialVersionUID = 5884421861234976573L;
    private String groupDesc;
    private String permissionLabel;

    public String Code() {
        return this.permissionLabel;
    }

    public String V() {
        return this.groupDesc;
    }
}
