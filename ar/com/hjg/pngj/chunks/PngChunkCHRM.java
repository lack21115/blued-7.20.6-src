package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;
import ar.com.hjg.pngj.PngjException;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngChunkCHRM.class */
public class PngChunkCHRM extends PngChunkSingle {
    private double h;
    private double i;
    private double j;
    private double k;
    private double l;
    private double m;
    private double n;
    private double o;

    public PngChunkCHRM(ImageInfo imageInfo) {
        super("cHRM", imageInfo);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void a(ChunkRaw chunkRaw) {
        if (chunkRaw.f3659a != 32) {
            throw new PngjException("bad chunk " + chunkRaw);
        }
        this.h = PngHelperInternal.a(PngHelperInternal.c(chunkRaw.d, 0));
        this.i = PngHelperInternal.a(PngHelperInternal.c(chunkRaw.d, 4));
        this.j = PngHelperInternal.a(PngHelperInternal.c(chunkRaw.d, 8));
        this.k = PngHelperInternal.a(PngHelperInternal.c(chunkRaw.d, 12));
        this.l = PngHelperInternal.a(PngHelperInternal.c(chunkRaw.d, 16));
        this.m = PngHelperInternal.a(PngHelperInternal.c(chunkRaw.d, 20));
        this.n = PngHelperInternal.a(PngHelperInternal.c(chunkRaw.d, 24));
        this.o = PngHelperInternal.a(PngHelperInternal.c(chunkRaw.d, 28));
    }
}
