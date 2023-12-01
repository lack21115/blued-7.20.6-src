package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/chunk/n.class */
public final class n extends k {
    private String axi;
    private int axj;
    private int[] axk;

    public n(com.kwad.sdk.pngencrypt.k kVar) {
        super("sPLT", kVar);
    }

    public final String Cg() {
        return this.axi;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        int i;
        int f;
        int f2;
        int f3;
        int f4;
        int i2;
        int i3 = 0;
        while (true) {
            i = i3;
            if (i >= dVar.data.length) {
                i = -1;
                break;
            } else if (dVar.data[i] == 0) {
                break;
            } else {
                i3 = i + 1;
            }
        }
        if (i <= 0 || i > dVar.data.length - 2) {
            throw new PngjException("bad sPLT chunk: no separator found");
        }
        this.axi = b.d(dVar.data, 0, i);
        this.axj = com.kwad.sdk.pngencrypt.n.e(dVar.data, i + 1);
        int i4 = i + 2;
        int length = (dVar.data.length - i4) / (this.axj == 8 ? 6 : 10);
        this.axk = new int[length * 5];
        int i5 = 0;
        int i6 = 0;
        while (i6 < length) {
            if (this.axj == 8) {
                int i7 = i4 + 1;
                f = com.kwad.sdk.pngencrypt.n.e(dVar.data, i4);
                int i8 = i7 + 1;
                f2 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i7);
                int i9 = i8 + 1;
                f3 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i8);
                i2 = i9 + 1;
                f4 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i9);
            } else {
                f = com.kwad.sdk.pngencrypt.n.f(dVar.data, i4);
                int i10 = i4 + 2;
                f2 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i10);
                int i11 = i10 + 2;
                f3 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i11);
                int i12 = i11 + 2;
                f4 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i12);
                i2 = i12 + 2;
            }
            int f5 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i2);
            int[] iArr = this.axk;
            int i13 = i5 + 1;
            iArr[i5] = f;
            int i14 = i13 + 1;
            iArr[i13] = f2;
            int i15 = i14 + 1;
            iArr[i14] = f3;
            int i16 = i15 + 1;
            iArr[i15] = f4;
            iArr[i16] = f5;
            i6++;
            i5 = i16 + 1;
            i4 = i2 + 2;
        }
    }
}
