package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngChunkFDAT.class */
public class PngChunkFDAT extends PngChunkMultiple {
    int h;
    private int i;
    private byte[] j;

    public PngChunkFDAT(ImageInfo imageInfo) {
        super("fdAT", imageInfo);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void a(ChunkRaw chunkRaw) {
        this.i = PngHelperInternal.c(chunkRaw.d, 0);
        this.h = chunkRaw.f3659a - 4;
        this.j = chunkRaw.d;
    }
}
