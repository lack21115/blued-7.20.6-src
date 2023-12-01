package com.huawei.openalliance.ad.uriaction;

import com.huawei.openalliance.ad.utils.z;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/uriaction/FaParams.class */
public class FaParams {
    private String hwChannelId;
    private String prdPkgName;

    public FaParams(String str, String str2) {
        this.prdPkgName = str;
        this.hwChannelId = str2;
    }

    public String Code() {
        return this.hwChannelId;
    }

    public String I() {
        return z.V(this);
    }

    public String V() {
        return this.prdPkgName;
    }
}
