package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngChunkBKGD.class */
public class PngChunkBKGD extends PngChunkSingle {
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;

    public PngChunkBKGD(ImageInfo imageInfo) {
        super("bKGD", imageInfo);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void a(ChunkRaw chunkRaw) {
        if (this.e.f) {
            this.h = PngHelperInternal.b(chunkRaw.d, 0);
        } else if (this.e.g) {
            this.l = chunkRaw.d[0] & 255;
        } else {
            this.i = PngHelperInternal.b(chunkRaw.d, 0);
            this.j = PngHelperInternal.b(chunkRaw.d, 2);
            this.k = PngHelperInternal.b(chunkRaw.d, 4);
        }
    }
}
