package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngChunkSingle.class */
public abstract class PngChunkSingle extends PngChunk {
    /* JADX INFO: Access modifiers changed from: protected */
    public PngChunkSingle(String str, ImageInfo imageInfo) {
        super(str, imageInfo);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public final boolean a() {
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PngChunkSingle pngChunkSingle = (PngChunkSingle) obj;
            return this.f3619a == null ? pngChunkSingle.f3619a == null : this.f3619a.equals(pngChunkSingle.f3619a);
        }
        return false;
    }

    public int hashCode() {
        return 31 + (this.f3619a == null ? 0 : this.f3619a.hashCode());
    }
}
