package com.huawei.openalliance.ad.inter.data;

import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/data/PermissionEntity.class */
public class PermissionEntity implements Serializable {
    private static final long serialVersionUID = -1825501272693801533L;
    private String name;
    private int type;

    public PermissionEntity() {
    }

    public PermissionEntity(String str, int i) {
        this.name = str;
        this.type = i;
    }

    public String Code() {
        return this.name;
    }

    public int V() {
        return this.type;
    }
}
