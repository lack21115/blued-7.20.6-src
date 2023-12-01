package com.huawei.openalliance.ad.beans.metadata;

import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/beans/metadata/ImpEXs.class */
public class ImpEXs {
    private List<ImpEX> impEXs;

    public ImpEXs() {
    }

    public ImpEXs(List<ImpEX> list) {
        this.impEXs = list;
    }

    public List<ImpEX> Code() {
        return this.impEXs;
    }

    public void Code(List<ImpEX> list) {
        this.impEXs = list;
    }
}
