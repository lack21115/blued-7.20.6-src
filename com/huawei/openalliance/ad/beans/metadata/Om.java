package com.huawei.openalliance.ad.beans.metadata;

import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/beans/metadata/Om.class */
public class Om implements Serializable {
    private static final long serialVersionUID = 6514947323166042687L;
    @com.huawei.openalliance.ad.annotations.a
    private String resourceUrl;
    private String vendorKey;
    @com.huawei.openalliance.ad.annotations.a
    private String verificationParameters;

    public String Code() {
        return this.vendorKey;
    }

    public String I() {
        return this.verificationParameters;
    }

    public String V() {
        return this.resourceUrl;
    }

    public String toString() {
        return "Om{vendorKey='" + this.vendorKey + "', resourceUrl='" + this.resourceUrl + "', verificationParameters='" + this.verificationParameters + "'}";
    }
}
