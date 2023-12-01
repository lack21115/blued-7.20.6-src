package com.huawei.openalliance.ad.beans.metadata;

import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/beans/metadata/ImpEX.class */
public class ImpEX implements Serializable {
    private static final long serialVersionUID = 30445301;
    private String key;
    private String value;

    public ImpEX() {
    }

    public ImpEX(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    public String Code() {
        return this.key;
    }

    public void Code(String str) {
        this.key = str;
    }

    public String V() {
        return this.value;
    }

    public void V(String str) {
        this.value = str;
    }
}
