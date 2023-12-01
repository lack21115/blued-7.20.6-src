package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;
import ar.com.hjg.pngj.PngjException;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngChunkSPLT.class */
public class PngChunkSPLT extends PngChunkMultiple {
    private String h;
    private int i;
    private int[] j;

    public PngChunkSPLT(ImageInfo imageInfo) {
        super("sPLT", imageInfo);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void a(ChunkRaw chunkRaw) {
        int i;
        int b;
        int b2;
        int b3;
        int b4;
        int i2;
        int i3 = 0;
        while (true) {
            i = i3;
            if (i >= chunkRaw.d.length) {
                i = -1;
                break;
            } else if (chunkRaw.d[i] == 0) {
                break;
            } else {
                i3 = i + 1;
            }
        }
        if (i <= 0 || i > chunkRaw.d.length - 2) {
            throw new PngjException("bad sPLT chunk: no separator found");
        }
        this.h = ChunkHelper.a(chunkRaw.d, 0, i);
        this.i = PngHelperInternal.a(chunkRaw.d, i + 1);
        int i4 = i + 2;
        int length = (chunkRaw.d.length - i4) / (this.i == 8 ? 6 : 10);
        this.j = new int[length * 5];
        int i5 = 0;
        int i6 = 0;
        while (i6 < length) {
            if (this.i == 8) {
                int i7 = i4 + 1;
                b = PngHelperInternal.a(chunkRaw.d, i4);
                int i8 = i7 + 1;
                b2 = PngHelperInternal.a(chunkRaw.d, i7);
                int i9 = i8 + 1;
                b3 = PngHelperInternal.a(chunkRaw.d, i8);
                i2 = i9 + 1;
                b4 = PngHelperInternal.a(chunkRaw.d, i9);
            } else {
                b = PngHelperInternal.b(chunkRaw.d, i4);
                int i10 = i4 + 2;
                b2 = PngHelperInternal.b(chunkRaw.d, i10);
                int i11 = i10 + 2;
                b3 = PngHelperInternal.b(chunkRaw.d, i11);
                int i12 = i11 + 2;
                b4 = PngHelperInternal.b(chunkRaw.d, i12);
                i2 = i12 + 2;
            }
            int b5 = PngHelperInternal.b(chunkRaw.d, i2);
            int[] iArr = this.j;
            int i13 = i5 + 1;
            iArr[i5] = b;
            int i14 = i13 + 1;
            iArr[i13] = b2;
            int i15 = i14 + 1;
            iArr[i14] = b3;
            int i16 = i15 + 1;
            iArr[i15] = b4;
            iArr[i16] = b5;
            i6++;
            i5 = i16 + 1;
            i4 = i2 + 2;
        }
    }

    public String e() {
        return this.h;
    }
}
