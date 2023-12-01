package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/chunk/j.class */
public final class j extends t {
    private boolean axa;
    private String axb;
    private String axc;

    public j(com.kwad.sdk.pngencrypt.k kVar) {
        super("iTXt", kVar);
        this.axa = false;
        this.axb = "";
        this.axc = "";
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        int i;
        int[] iArr = new int[3];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            i = i4;
            if (i2 >= dVar.data.length) {
                break;
            }
            int i5 = i2;
            int i6 = i4;
            if (dVar.data[i2] == 0) {
                iArr[i4] = i2;
                i6 = i4 + 1;
                int i7 = i2;
                if (i6 == 1) {
                    i7 = i2 + 2;
                }
                i = i6;
                if (i6 == 3) {
                    break;
                }
                i5 = i7;
            }
            i2 = i5 + 1;
            i3 = i6;
        }
        if (i != 3) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Bad formed PngChunkITXT chunk"));
        }
        this.key = b.d(dVar.data, 0, iArr[0]);
        int i8 = iArr[0] + 1;
        boolean z = dVar.data[i8] != 0;
        this.axa = z;
        int i9 = i8 + 1;
        if (z && dVar.data[i9] != 0) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Bad formed PngChunkITXT chunk - bad compression method "));
        }
        this.axb = b.d(dVar.data, i9, iArr[1] - i9);
        this.axc = b.e(dVar.data, iArr[1] + 1, (iArr[2] - iArr[1]) - 1);
        int i10 = iArr[2] + 1;
        boolean z2 = this.axa;
        byte[] bArr = dVar.data;
        this.axu = z2 ? b.j(b.b(bArr, i10, bArr.length - i10, false)) : b.e(bArr, i10, bArr.length - i10);
    }
}
