package com.huawei.hms.ads;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/fw.class */
public class fw {
    public static final String Code = "true";
    private static final String I = "LinkedAdConfiguration";
    public static final String V = "false";
    private int Z = 0;
    private String B = null;
    private int C = 0;
    private String S = "n";
    private boolean F = false;
    private boolean D = false;

    public int B() {
        return this.Z;
    }

    public String C() {
        return this.B;
    }

    public int Code() {
        return this.C;
    }

    public void Code(int i) {
        this.C = i;
    }

    public void Code(String str) {
        this.S = str;
    }

    public void Code(boolean z) {
        this.F = z;
    }

    public boolean I() {
        return this.F;
    }

    public String V() {
        return this.S;
    }

    public void V(int i) {
        ge.Code(I, "setLinkedVideoMode %s", Integer.valueOf(i));
        this.Z = i;
    }

    public void V(String str) {
        this.B = str;
    }

    public void V(boolean z) {
        this.D = z;
    }

    public boolean Z() {
        return this.D;
    }
}
