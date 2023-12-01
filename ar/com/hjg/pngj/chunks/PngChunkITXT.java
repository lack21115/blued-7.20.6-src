package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngjException;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngChunkITXT.class */
public class PngChunkITXT extends PngChunkTextVar {
    private boolean j;
    private String k;
    private String l;

    public PngChunkITXT(ImageInfo imageInfo) {
        super("iTXt", imageInfo);
        this.j = false;
        this.k = "";
        this.l = "";
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void a(ChunkRaw chunkRaw) {
        int i;
        int[] iArr = new int[3];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3;
            if (i2 >= chunkRaw.d.length) {
                break;
            }
            if (chunkRaw.d[i2] == 0) {
                iArr[i3] = i2;
                i = i3 + 1;
                int i4 = i2;
                if (i == 1) {
                    i4 = i2 + 2;
                }
                i2 = i4;
                i3 = i;
                if (i == 3) {
                    break;
                }
            }
            i2++;
        }
        if (i != 3) {
            throw new PngjException("Bad formed PngChunkITXT chunk");
        }
        this.h = ChunkHelper.a(chunkRaw.d, 0, iArr[0]);
        int i5 = iArr[0] + 1;
        boolean z = chunkRaw.d[i5] != 0;
        this.j = z;
        int i6 = i5 + 1;
        if (z && chunkRaw.d[i6] != 0) {
            throw new PngjException("Bad formed PngChunkITXT chunk - bad compression method ");
        }
        this.k = ChunkHelper.a(chunkRaw.d, i6, iArr[1] - i6);
        this.l = ChunkHelper.b(chunkRaw.d, iArr[1] + 1, (iArr[2] - iArr[1]) - 1);
        int i7 = iArr[2] + 1;
        if (this.j) {
            this.i = ChunkHelper.b(ChunkHelper.a(chunkRaw.d, i7, chunkRaw.d.length - i7, false));
        } else {
            this.i = ChunkHelper.b(chunkRaw.d, i7, chunkRaw.d.length - i7);
        }
    }
}
