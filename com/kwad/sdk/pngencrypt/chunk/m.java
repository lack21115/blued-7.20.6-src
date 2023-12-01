package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/chunk/m.class */
public final class m extends p {
    private int axg;
    private int[] axh;

    public m(com.kwad.sdk.pngencrypt.k kVar) {
        super("PLTE", kVar);
        this.axg = 0;
    }

    private void a(int i, int i2, int i3, int i4) {
        this.axh[i] = (i2 << 16) | (i3 << 8) | i4;
    }

    private void cc(int i) {
        this.axg = i;
        if (i <= 0 || i > 256) {
            throw new PngjException("invalid pallette - nentries=" + this.axg);
        }
        int[] iArr = this.axh;
        if (iArr == null || iArr.length != i) {
            this.axh = new int[this.axg];
        }
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        cc(dVar.len / 3);
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= this.axg) {
                return;
            }
            int i4 = i3 + 1;
            int i5 = i4 + 1;
            a(i, dVar.data[i3] & 255, dVar.data[i4] & 255, dVar.data[i5] & 255);
            i++;
            i2 = i5 + 1;
        }
    }
}
