package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;
import ar.com.hjg.pngj.PngjException;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngChunkGAMA.class */
public class PngChunkGAMA extends PngChunkSingle {
    private double h;

    public PngChunkGAMA(ImageInfo imageInfo) {
        super("gAMA", imageInfo);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void a(ChunkRaw chunkRaw) {
        if (chunkRaw.f3659a == 4) {
            this.h = PngHelperInternal.c(chunkRaw.d, 0) / 100000.0d;
            return;
        }
        throw new PngjException("bad chunk " + chunkRaw);
    }
}
