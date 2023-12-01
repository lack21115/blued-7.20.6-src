package com.huawei.openalliance.ad.beans.metadata.v3.openrtb;

import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/beans/metadata/v3/openrtb/Title.class */
public class Title implements Serializable {
    private static final long serialVersionUID = 3724114949683086810L;
    private int len;
    private String text;

    public String Code() {
        return this.text;
    }

    public void Code(int i) {
        this.len = i;
    }

    public void Code(String str) {
        this.text = str;
    }

    public int V() {
        return this.len;
    }
}
