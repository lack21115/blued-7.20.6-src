package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;
import ar.com.hjg.pngj.PngjException;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngChunkTIME.class */
public class PngChunkTIME extends PngChunkSingle {
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;

    public PngChunkTIME(ImageInfo imageInfo) {
        super("tIME", imageInfo);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void a(ChunkRaw chunkRaw) {
        if (chunkRaw.f3659a != 7) {
            throw new PngjException("bad chunk " + chunkRaw);
        }
        this.h = PngHelperInternal.b(chunkRaw.d, 0);
        this.i = PngHelperInternal.a(chunkRaw.d, 2);
        this.j = PngHelperInternal.a(chunkRaw.d, 3);
        this.k = PngHelperInternal.a(chunkRaw.d, 4);
        this.l = PngHelperInternal.a(chunkRaw.d, 5);
        this.m = PngHelperInternal.a(chunkRaw.d, 6);
    }
}
