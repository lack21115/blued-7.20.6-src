package com.kwad.sdk.pngencrypt.chunk;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/chunk/p.class */
public abstract class p extends PngChunk {
    /* JADX INFO: Access modifiers changed from: protected */
    public p(String str, com.kwad.sdk.pngencrypt.k kVar) {
        super(str, kVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            p pVar = (p) obj;
            return this.awG == null ? pVar.awG == null : this.awG.equals(pVar.awG);
        }
        return false;
    }

    public int hashCode() {
        return (this.awG == null ? 0 : this.awG.hashCode()) + 31;
    }
}
