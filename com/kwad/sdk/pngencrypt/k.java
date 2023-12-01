package com.kwad.sdk.pngencrypt;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/k.class */
public final class k {
    public final int avA;
    public final int avS;
    public final int avT;
    public final boolean avU;
    public final boolean avV;
    public final boolean avW;
    public final boolean avX;
    public final int avY;
    public final int avZ;
    public final int avz;
    public final int awa;
    public final int awb;
    public final int awc;
    private long awd = -1;
    private long awe = -1;

    public k(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        this.avA = i;
        this.avz = i2;
        this.avU = z;
        this.avW = z3;
        this.avV = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        this.avT = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.avS = i3;
        boolean z4 = i3 < 8;
        this.avX = z4;
        int i4 = this.avT;
        int i5 = this.avS * i4;
        this.avY = i5;
        this.avZ = (i5 + 7) / 8;
        int i6 = ((i5 * i) + 7) / 8;
        this.awa = i6;
        int i7 = i4 * this.avA;
        this.awb = i7;
        this.awc = z4 ? i6 : i7;
        int i8 = this.avS;
        if (i8 == 1 || i8 == 2 || i8 == 4) {
            if (!this.avW && !this.avV) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + this.avS);
            }
        } else if (i8 != 8) {
            if (i8 != 16) {
                throw new PngjException("invalid bitdepth=" + this.avS);
            } else if (this.avW) {
                throw new PngjException("indexed can't have bitdepth=" + this.avS);
            }
        }
        if (i <= 0 || i > 16777216) {
            throw new PngjException("invalid cols=" + i + " ???");
        } else if (i2 > 0 && i2 <= 16777216) {
            if (this.awb <= 0) {
                throw new PngjException("invalid image parameters (overflow?)");
            }
        } else {
            throw new PngjException("invalid rows=" + i2 + " ???");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            k kVar = (k) obj;
            return this.avU == kVar.avU && this.avS == kVar.avS && this.avA == kVar.avA && this.avV == kVar.avV && this.avW == kVar.avW && this.avz == kVar.avz;
        }
        return false;
    }

    public final int hashCode() {
        int i = 1231;
        int i2 = this.avU ? 1231 : 1237;
        int i3 = this.avS;
        int i4 = this.avA;
        int i5 = this.avV ? 1231 : 1237;
        if (!this.avW) {
            i = 1237;
        }
        return ((((((((((i2 + 31) * 31) + i3) * 31) + i4) * 31) + i5) * 31) + i) * 31) + this.avz;
    }

    public final String toString() {
        return "ImageInfo [cols=" + this.avA + ", rows=" + this.avz + ", bitDepth=" + this.avS + ", channels=" + this.avT + ", alpha=" + this.avU + ", greyscale=" + this.avV + ", indexed=" + this.avW + "]";
    }
}
