package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/chunk/l.class */
public final class l extends p {
    private long axd;
    private long axe;
    private int axf;

    public l(com.kwad.sdk.pngencrypt.k kVar) {
        super("oFFs", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len != 9) {
            throw new PngjException("bad chunk length " + dVar);
        }
        long g = com.kwad.sdk.pngencrypt.n.g(dVar.data, 0);
        this.axd = g;
        if (g < 0) {
            this.axd = g + 4294967296L;
        }
        long g2 = com.kwad.sdk.pngencrypt.n.g(dVar.data, 4);
        this.axe = g2;
        if (g2 < 0) {
            this.axe = g2 + 4294967296L;
        }
        this.axf = com.kwad.sdk.pngencrypt.n.e(dVar.data, 8);
    }
}
