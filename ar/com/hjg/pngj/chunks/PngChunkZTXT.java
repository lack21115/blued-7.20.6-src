package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngjException;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngChunkZTXT.class */
public class PngChunkZTXT extends PngChunkTextVar {
    public PngChunkZTXT(ImageInfo imageInfo) {
        super("zTXt", imageInfo);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void a(ChunkRaw chunkRaw) {
        int i;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= chunkRaw.d.length) {
                i = -1;
                break;
            }
            i = i3;
            if (chunkRaw.d[i3] == 0) {
                break;
            }
            i2 = i3 + 1;
        }
        if (i < 0 || i > chunkRaw.d.length - 2) {
            throw new PngjException("bad zTXt chunk: no separator found");
        }
        this.h = ChunkHelper.a(chunkRaw.d, 0, i);
        if (chunkRaw.d[i + 1] != 0) {
            throw new PngjException("bad zTXt chunk: unknown compression method");
        }
        this.i = ChunkHelper.a(ChunkHelper.a(chunkRaw.d, i + 2, (chunkRaw.d.length - i) - 2, false));
    }
}
