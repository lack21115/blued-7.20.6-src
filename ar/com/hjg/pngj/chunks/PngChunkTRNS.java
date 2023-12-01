package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngChunkTRNS.class */
public class PngChunkTRNS extends PngChunkSingle {
    private int h;
    private int i;
    private int j;
    private int k;
    private int[] l;

    public PngChunkTRNS(ImageInfo imageInfo) {
        super("tRNS", imageInfo);
        this.l = new int[0];
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void a(ChunkRaw chunkRaw) {
        if (this.e.f) {
            this.h = PngHelperInternal.b(chunkRaw.d, 0);
        } else if (!this.e.g) {
            this.i = PngHelperInternal.b(chunkRaw.d, 0);
            this.j = PngHelperInternal.b(chunkRaw.d, 2);
            this.k = PngHelperInternal.b(chunkRaw.d, 4);
        } else {
            int length = chunkRaw.d.length;
            this.l = new int[length];
            for (int i = 0; i < length; i++) {
                this.l[i] = chunkRaw.d[i] & 255;
            }
        }
    }
}
