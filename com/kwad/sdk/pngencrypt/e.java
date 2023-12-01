package com.kwad.sdk.pngencrypt;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/e.class */
public final class e {
    private int avA;
    int avB;
    int avC;
    int avD;
    int avE;
    int avF;
    int avG;
    private boolean avL;
    final k avx;
    private int avz;
    private int avy = 0;
    private int avH = -1;
    private int avI = -1;
    private int avJ = 0;
    int avK = 0;

    public e(k kVar) {
        this.avL = false;
        this.avx = kVar;
        this.avL = false;
        bM(1);
        bL(0);
    }

    private int BH() {
        return BG();
    }

    private void bL(int i) {
        this.avH = i;
        int i2 = (i * this.avB) + this.avD;
        this.avI = i2;
        if (i2 < 0 || i2 >= this.avx.avz) {
            throw new PngjException("bad row - this should not happen");
        }
    }

    private void bM(int i) {
        int i2;
        int i3;
        if (this.avy == i) {
            return;
        }
        this.avy = i;
        byte[] bN = bN(i);
        this.avC = bN[0];
        this.avB = bN[1];
        this.avE = bN[2];
        this.avD = bN[3];
        if (this.avx.avz > this.avD) {
            int i4 = this.avx.avz;
            int i5 = this.avB;
            i2 = (((i4 + i5) - 1) - this.avD) / i5;
        } else {
            i2 = 0;
        }
        this.avz = i2;
        if (this.avx.avA > this.avE) {
            int i6 = this.avx.avA;
            int i7 = this.avC;
            i3 = (((i6 + i7) - 1) - this.avE) / i7;
        } else {
            i3 = 0;
        }
        this.avA = i3;
        if (i3 == 0) {
            this.avz = 0;
        }
        this.avG = this.avC * this.avx.avT;
        this.avF = this.avE * this.avx.avT;
    }

    private static byte[] bN(int i) {
        switch (i) {
            case 1:
                return new byte[]{8, 8, 0, 0};
            case 2:
                return new byte[]{8, 8, 4, 0};
            case 3:
                return new byte[]{4, 8, 0, 4};
            case 4:
                return new byte[]{4, 4, 2, 0};
            case 5:
                return new byte[]{2, 4, 0, 2};
            case 6:
                return new byte[]{2, 2, 1, 0};
            case 7:
                return new byte[]{1, 2, 0, 1};
            default:
                throw new PngjException("bad interlace pass" + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean BB() {
        int i;
        while (true) {
            this.avJ++;
            int i2 = this.avz;
            if (i2 != 0 && (i = this.avH) < i2 - 1) {
                bL(i + 1);
                return true;
            }
            int i3 = this.avy;
            if (i3 == 7) {
                this.avL = true;
                return false;
            }
            bM(i3 + 1);
            if (this.avz != 0) {
                bL(0);
                return true;
            }
            this.avJ--;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int BC() {
        return this.avH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int BD() {
        return this.avI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int BE() {
        return this.avy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int BF() {
        return this.avz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int BG() {
        return this.avA;
    }

    public final int BI() {
        return ((this.avx.avY * BH()) + 7) / 8;
    }
}
