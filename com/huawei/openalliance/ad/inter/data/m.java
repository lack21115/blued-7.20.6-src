package com.huawei.openalliance.ad.inter.data;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/data/m.class */
public class m {
    private Integer Code;
    private String I;
    private Integer V;

    public m() {
    }

    public m(Integer num, Integer num2, String str) {
        this.Code = num;
        this.V = num2;
        this.I = str;
    }

    public Integer Code() {
        return this.Code;
    }

    public String I() {
        return this.I;
    }

    public Integer V() {
        return this.V;
    }

    public String toString() {
        return "MaterialClickInfo{clickX=" + this.Code + ", clickY=" + this.V + ", creativeSize='" + this.I + "'}";
    }
}
