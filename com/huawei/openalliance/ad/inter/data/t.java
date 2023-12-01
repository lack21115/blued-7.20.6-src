package com.huawei.openalliance.ad.inter.data;

import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/data/t.class */
public class t {
    private final Set<String> Code;
    private String I;
    private final int V;
    private String Z;

    public t(Set<String> set, int i, String str, String str2) {
        this.Code = set;
        this.V = i;
        this.I = str;
        this.Z = str2;
    }

    public final Set<String> Code() {
        return this.Code;
    }

    public String I() {
        return this.I;
    }

    public final int V() {
        return this.V;
    }

    public String Z() {
        return this.Z;
    }
}
