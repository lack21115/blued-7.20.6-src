package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;
import ar.com.hjg.pngj.PngjException;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngChunkHIST.class */
public class PngChunkHIST extends PngChunkSingle {
    private int[] h;

    public PngChunkHIST(ImageInfo imageInfo) {
        super("hIST", imageInfo);
        this.h = new int[0];
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void a(ChunkRaw chunkRaw) {
        if (!this.e.g) {
            throw new PngjException("only indexed images accept a HIST chunk");
        }
        this.h = new int[chunkRaw.d.length / 2];
        int i = 0;
        while (true) {
            int i2 = i;
            int[] iArr = this.h;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = PngHelperInternal.b(chunkRaw.d, i2 * 2);
            i = i2 + 1;
        }
    }
}
