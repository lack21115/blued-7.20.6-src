package com.huawei.hms.ads;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/gf.class */
public class gf {
    private static final String Code = "HiAdSDKLog";
    private static final int I = 10;
    private static final String V = "HiAdSDK.";
    private static gj Z = gk.Code();
    private String C;
    private int B = 4;
    private boolean S = false;

    private gl I(int i, String str, String str2) {
        gl glVar = new gl(this.C, i, str);
        glVar.Code((gl) str2);
        return glVar;
    }

    public gj Code() {
        return Z;
    }

    public void Code(int i, String str, String str2) {
        this.B = i;
        this.C = str2;
        Z.Code(str, Code);
        this.S = true;
    }

    public void Code(int i, String str, String str2, Throwable th) {
        if (th == null || !Code(i)) {
        }
    }

    public void Code(int i, String str, Throwable th) {
        if (th == null || !Code(i)) {
        }
    }

    public void Code(String str, String str2) {
        Z.Code(I(4, str, str2), 4, str);
    }

    public boolean Code(int i) {
        return this.S && i >= this.B;
    }

    public void V(int i, String str, String str2) {
        if (Code(i)) {
            String str3 = V + str;
            Z.Code(I(i, str3, str2), i, str3);
        }
    }
}
