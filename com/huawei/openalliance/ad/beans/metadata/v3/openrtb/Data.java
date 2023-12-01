package com.huawei.openalliance.ad.beans.metadata.v3.openrtb;

import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/beans/metadata/v3/openrtb/Data.class */
public class Data implements Serializable {
    private static final long serialVersionUID = 4120218934780835998L;
    private int len;
    private int type;
    private String value;

    public int Code() {
        return this.type;
    }

    public void Code(int i) {
        this.type = i;
    }

    public void Code(String str) {
        this.value = str;
    }

    public int I() {
        return this.len;
    }

    public String V() {
        return this.value;
    }

    public void V(int i) {
        this.len = i;
    }
}
