package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;
import ar.com.hjg.pngj.PngjException;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngChunkOFFS.class */
public class PngChunkOFFS extends PngChunkSingle {
    private long h;
    private long i;
    private int j;

    public PngChunkOFFS(ImageInfo imageInfo) {
        super("oFFs", imageInfo);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void a(ChunkRaw chunkRaw) {
        if (chunkRaw.f3659a != 9) {
            throw new PngjException("bad chunk length " + chunkRaw);
        }
        long c2 = PngHelperInternal.c(chunkRaw.d, 0);
        this.h = c2;
        if (c2 < 0) {
            this.h = c2 + 4294967296L;
        }
        long c3 = PngHelperInternal.c(chunkRaw.d, 4);
        this.i = c3;
        if (c3 < 0) {
            this.i = c3 + 4294967296L;
        }
        this.j = PngHelperInternal.a(chunkRaw.d, 8);
    }
}
