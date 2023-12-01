package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngjException;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngChunkPLTE.class */
public class PngChunkPLTE extends PngChunkSingle {
    private int h;
    private int[] i;

    public PngChunkPLTE(ImageInfo imageInfo) {
        super("PLTE", imageInfo);
        this.h = 0;
    }

    public void a(int i, int i2, int i3, int i4) {
        this.i[i] = (i2 << 16) | (i3 << 8) | i4;
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void a(ChunkRaw chunkRaw) {
        b(chunkRaw.f3611a / 3);
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= this.h) {
                return;
            }
            int i4 = i3 + 1;
            int i5 = i4 + 1;
            a(i, chunkRaw.d[i3] & 255, chunkRaw.d[i4] & 255, chunkRaw.d[i5] & 255);
            i++;
            i2 = i5 + 1;
        }
    }

    public void b(int i) {
        this.h = i;
        if (i < 1 || i > 256) {
            throw new PngjException("invalid pallette - nentries=" + this.h);
        }
        int[] iArr = this.i;
        if (iArr == null || iArr.length != i) {
            this.i = new int[this.h];
        }
    }
}
