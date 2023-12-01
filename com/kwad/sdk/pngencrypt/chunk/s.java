package com.kwad.sdk.pngencrypt.chunk;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/chunk/s.class */
public final class s extends p {
    private int axp;
    private int axq;
    private int axr;
    private int axs;
    private int[] axt;

    public s(com.kwad.sdk.pngencrypt.k kVar) {
        super("tRNS", kVar);
        this.axt = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (this.avO.avV) {
            this.axp = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
        } else if (!this.avO.avW) {
            this.axq = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
            this.axr = com.kwad.sdk.pngencrypt.n.f(dVar.data, 2);
            this.axs = com.kwad.sdk.pngencrypt.n.f(dVar.data, 4);
        } else {
            int length = dVar.data.length;
            this.axt = new int[length];
            for (int i = 0; i < length; i++) {
                this.axt[i] = dVar.data[i] & 255;
            }
        }
    }
}
