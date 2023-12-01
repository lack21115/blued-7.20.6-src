package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngChunkMultiple.class */
public abstract class PngChunkMultiple extends PngChunk {
    /* JADX INFO: Access modifiers changed from: protected */
    public PngChunkMultiple(String str, ImageInfo imageInfo) {
        super(str, imageInfo);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public final boolean a() {
        return true;
    }
}
