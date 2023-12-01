package com.kwad.sdk.pngencrypt.chunk;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/chunk/PngChunk.class */
public abstract class PngChunk {
    protected final com.kwad.sdk.pngencrypt.k avO;
    public final String awG;
    public final boolean awP;
    public final boolean awQ;
    public final boolean awR;
    protected d awS;
    private boolean awT = false;
    protected int awU = -1;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/chunk/PngChunk$ChunkOrderingConstraint.class */
    public enum ChunkOrderingConstraint {
        NONE,
        BEFORE_PLTE_AND_IDAT,
        AFTER_PLTE_BEFORE_IDAT,
        AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED,
        BEFORE_IDAT,
        AFTER_IDAT,
        NA;

        public final boolean isOk(int i, boolean z) {
            if (this == NONE) {
                return true;
            }
            return this == BEFORE_IDAT ? i < 4 : this == BEFORE_PLTE_AND_IDAT ? i < 2 : this == AFTER_PLTE_BEFORE_IDAT ? z ? i < 4 : i < 4 && i > 2 : this == AFTER_IDAT && i > 4;
        }

        public final boolean mustGoAfterIDAT() {
            return this == AFTER_IDAT;
        }

        public final boolean mustGoAfterPLTE() {
            return this == AFTER_PLTE_BEFORE_IDAT || this == AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED;
        }

        public final boolean mustGoBeforeIDAT() {
            return this == BEFORE_IDAT || this == BEFORE_PLTE_AND_IDAT || this == AFTER_PLTE_BEFORE_IDAT;
        }

        public final boolean mustGoBeforePLTE() {
            return this == BEFORE_PLTE_AND_IDAT;
        }
    }

    public PngChunk(String str, com.kwad.sdk.pngencrypt.k kVar) {
        this.awG = str;
        this.avO = kVar;
        this.awP = b.em(str);
        this.awQ = b.en(str);
        this.awR = b.eo(str);
    }

    private long BW() {
        d dVar = this.awS;
        if (dVar != null) {
            return dVar.BW();
        }
        return -1L;
    }

    private int BY() {
        d dVar = this.awS;
        if (dVar != null) {
            return dVar.len;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(d dVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(d dVar) {
        this.awS = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void bU(int i) {
        this.awU = i;
    }

    public String toString() {
        return "chunk id= " + this.awG + " (len=" + BY() + " offset=" + BW() + ")";
    }
}
