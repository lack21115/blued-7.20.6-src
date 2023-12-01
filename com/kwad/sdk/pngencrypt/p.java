package com.kwad.sdk.pngencrypt;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/p.class */
final class p {
    public final e auS;
    int avB;
    int avC;
    int avD;
    int avE;
    public final k avO;
    int avy;
    public final boolean awq;
    int awr;
    int aws;
    int awt;
    int awu;
    int awv;
    int aww;
    int awx;
    byte[] buf;

    public p(k kVar, e eVar) {
        this.avO = kVar;
        this.auS = eVar;
        this.awq = eVar != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void h(byte[] bArr, int i) {
        this.buf = bArr;
        this.awx = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void update(int i) {
        int i2;
        this.awr = i;
        if (this.awq) {
            this.avy = this.auS.BE();
            this.avC = this.auS.avC;
            this.avB = this.auS.avB;
            this.avE = this.auS.avE;
            this.avD = this.auS.avD;
            this.aws = this.auS.BD();
            this.awt = this.auS.BC();
            this.awu = this.auS.BF();
            this.awv = this.auS.BG();
            i2 = ((this.avO.avY * this.awv) + 7) / 8;
        } else {
            this.avy = 1;
            this.avB = 1;
            this.avC = 1;
            this.avD = 0;
            this.avE = 0;
            this.awt = i;
            this.aws = i;
            this.awu = this.avO.avz;
            this.awv = this.avO.avA;
            i2 = this.avO.awa;
        }
        this.aww = i2;
    }
}
