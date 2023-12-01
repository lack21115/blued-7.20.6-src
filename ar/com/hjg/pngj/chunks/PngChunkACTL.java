package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngChunkACTL.class */
public class PngChunkACTL extends PngChunkSingle {
    private int h;
    private int i;

    public PngChunkACTL(ImageInfo imageInfo) {
        super("acTL", imageInfo);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void a(ChunkRaw chunkRaw) {
        this.h = PngHelperInternal.c(chunkRaw.d, 0);
        this.i = PngHelperInternal.c(chunkRaw.d, 4);
    }

    public int e() {
        return this.h;
    }

    public int f() {
        return this.i;
    }
}
