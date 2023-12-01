package com.kwai.sodler.lib.ext;

import com.tencent.tinker.loader.shareutil.ShareConstants;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/ext/c.class */
public final class c {
    private final String aKG;
    private final String aKH;
    private final String aKI;
    private final String aKJ;
    private final String aKK;
    private final String aKL;
    private final String aKM;
    private final boolean aKN;
    private final boolean aKO;
    private final boolean aKP;
    private String aKQ;
    private byte[] aKR;
    private boolean aKS;
    private final int aKt;

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/ext/c$a.class */
    public static final class a {
        private String aKM;
        private boolean aKP;
        private String aKQ;
        private byte[] aKR;
        private boolean aKS;
        private int aKt = 3;
        private String aKG = "sodler";
        private String aKH = "code-cache";
        private String aKI = ShareConstants.SO_PATH;
        private String aKJ = "temp";
        private String aKL = "base-1.apk";
        private String aKK = ".tmp";
        private boolean aKO = false;
        private boolean aKN = false;

        public final c JY() {
            return new c(this.aKN, this.aKO, this.aKM, this.aKG, this.aKH, this.aKI, this.aKJ, this.aKK, this.aKL, this.aKt, this.aKQ, this.aKR, this.aKS, this.aKP, (byte) 0);
        }

        public final a bW(boolean z) {
            this.aKS = false;
            return this;
        }

        public final a bX(boolean z) {
            this.aKP = z;
            return this;
        }

        public final a dn(int i) {
            if (i > 0) {
                this.aKt = i;
            }
            return this;
        }

        public final a fY(String str) {
            this.aKG = str;
            return this;
        }
    }

    private c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, byte[] bArr, boolean z3, boolean z4) {
        this.aKt = i;
        this.aKG = str2;
        this.aKH = str3;
        this.aKI = str4;
        this.aKJ = str5;
        this.aKK = str6;
        this.aKL = str7;
        this.aKM = str;
        this.aKN = z;
        this.aKO = z2;
        this.aKQ = str8;
        this.aKR = bArr;
        this.aKS = z3;
        this.aKP = z4;
    }

    /* synthetic */ c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, byte[] bArr, boolean z3, boolean z4, byte b) {
        this(z, z2, str, str2, str3, str4, str5, str6, str7, i, str8, bArr, z3, z4);
    }

    public final String JQ() {
        return this.aKG;
    }

    public final String JR() {
        return this.aKH;
    }

    public final String JS() {
        return this.aKI;
    }

    public final String JT() {
        return this.aKJ;
    }

    public final String JU() {
        return this.aKK;
    }

    public final String JV() {
        return this.aKL;
    }

    public final boolean JW() {
        return this.aKO;
    }

    public final boolean JX() {
        return this.aKP;
    }

    public final int getRetryCount() {
        return this.aKt;
    }
}
