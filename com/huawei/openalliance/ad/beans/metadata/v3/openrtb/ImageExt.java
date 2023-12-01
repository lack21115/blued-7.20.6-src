package com.huawei.openalliance.ad.beans.metadata.v3.openrtb;

import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/beans/metadata/v3/openrtb/ImageExt.class */
public class ImageExt implements Serializable {
    private static final long serialVersionUID = 9185694573603472901L;
    private int checkSHA256Flag;
    private String format;
    private String sha256;
    private long size;

    public long Code() {
        return this.size;
    }

    public void Code(int i) {
        this.checkSHA256Flag = i;
    }

    public void Code(long j) {
        this.size = j;
    }

    public void Code(String str) {
        this.sha256 = str;
    }

    public String I() {
        return this.format;
    }

    public String V() {
        return this.sha256;
    }

    public void V(String str) {
        this.format = str;
    }

    public int Z() {
        return this.checkSHA256Flag;
    }
}
