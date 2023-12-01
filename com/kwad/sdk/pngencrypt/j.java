package com.kwad.sdk.pngencrypt;

import java.util.Arrays;
import java.util.zip.Inflater;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/j.class */
public final class j extends DeflatedChunksSet {
    protected final e auS;
    protected byte[] avM;
    protected byte[] avN;
    protected final k avO;
    final p avP;
    protected int[] avQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.pngencrypt.j$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/j$1.class */
    public static final /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] avR;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0041 -> B:27:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:25:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004d -> B:29:0x0035). Please submit an issue!!! */
        static {
            int[] iArr = new int[FilterType.values().length];
            avR = iArr;
            try {
                iArr[FilterType.FILTER_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                avR[FilterType.FILTER_SUB.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                avR[FilterType.FILTER_UP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                avR[FilterType.FILTER_AVERAGE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                avR[FilterType.FILTER_PAETH.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public j(String str, boolean z, k kVar, e eVar) {
        this(str, z, kVar, eVar, null, null);
    }

    private j(String str, boolean z, k kVar, e eVar, Inflater inflater, byte[] bArr) {
        super(str, z, (eVar != null ? eVar.BI() : kVar.awa) + 1, kVar.awa + 1, null, null);
        this.avQ = new int[5];
        this.avO = kVar;
        this.auS = eVar;
        this.avP = new p(kVar, eVar);
        com.kwad.sdk.core.d.b.d("PNG_ENCRYPT", "Creating IDAT set ");
    }

    private void BJ() {
        bO(this.avP.aww);
    }

    private int BK() {
        int BI;
        e eVar = this.auS;
        int i = 0;
        if (eVar == null) {
            if (BA() < this.avO.avz - 1) {
                BI = this.avO.awa;
                i = BI + 1;
            }
        } else if (eVar.BB()) {
            BI = this.auS.BI();
            i = BI + 1;
        }
        if (!this.auV) {
            bK(i);
        }
        return i;
    }

    private void bO(int i) {
        byte[] bArr = this.avM;
        if (bArr == null || bArr.length < this.avl.length) {
            this.avM = new byte[this.avl.length];
            this.avN = new byte[this.avl.length];
        }
        if (this.avP.awt == 0) {
            Arrays.fill(this.avM, (byte) 0);
        }
        byte[] bArr2 = this.avM;
        this.avM = this.avN;
        this.avN = bArr2;
        byte b = this.avl[0];
        if (!FilterType.isValidStandard(b)) {
            throw new PngjException("Filter type " + ((int) b) + " invalid");
        }
        FilterType byVal = FilterType.getByVal(b);
        int[] iArr = this.avQ;
        iArr[b] = iArr[b] + 1;
        this.avM[0] = this.avl[0];
        int i2 = AnonymousClass1.avR[byVal.ordinal()];
        if (i2 == 1) {
            bQ(i);
        } else if (i2 == 2) {
            bS(i);
        } else if (i2 == 3) {
            bT(i);
        } else if (i2 == 4) {
            bP(i);
        } else if (i2 == 5) {
            bR(i);
        } else {
            throw new PngjException("Filter type " + ((int) b) + " not implemented");
        }
    }

    private void bP(int i) {
        int i2 = 1;
        int i3 = 1 - this.avO.avZ;
        while (true) {
            int i4 = i3;
            if (i2 > i) {
                return;
            }
            this.avM[i2] = (byte) (this.avl[i2] + (((i4 > 0 ? this.avM[i4] & 255 : 0) + (this.avN[i2] & 255)) / 2));
            i2++;
            i3 = i4 + 1;
        }
    }

    private void bQ(int i) {
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 > i) {
                return;
            }
            this.avM[i3] = this.avl[i3];
            i2 = i3 + 1;
        }
    }

    private void bR(int i) {
        int i2 = 1;
        int i3 = 1 - this.avO.avZ;
        while (true) {
            int i4 = i3;
            if (i2 > i) {
                return;
            }
            int i5 = 0;
            int i6 = i4 > 0 ? this.avM[i4] & 255 : 0;
            if (i4 > 0) {
                i5 = this.avN[i4] & 255;
            }
            this.avM[i2] = (byte) (this.avl[i2] + n.b(i6, this.avN[i2] & 255, i5));
            i2++;
            i3 = i4 + 1;
        }
    }

    private void bS(int i) {
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 > this.avO.avZ) {
                break;
            }
            this.avM[i3] = this.avl[i3];
            i2 = i3 + 1;
        }
        int i4 = this.avO.avZ + 1;
        int i5 = 1;
        while (true) {
            int i6 = i5;
            if (i4 > i) {
                return;
            }
            this.avM[i4] = (byte) (this.avl[i4] + this.avM[i6]);
            i4++;
            i5 = i6 + 1;
        }
    }

    private void bT(int i) {
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 > i) {
                return;
            }
            this.avM[i3] = (byte) (this.avl[i3] + this.avN[i3]);
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final void Bx() {
        super.Bx();
        this.avP.update(BA());
        BJ();
        p pVar = this.avP;
        pVar.h(this.avM, pVar.aww + 1);
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    protected final int By() {
        return BK();
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final void close() {
        super.close();
        this.avM = null;
        this.avN = null;
    }
}
