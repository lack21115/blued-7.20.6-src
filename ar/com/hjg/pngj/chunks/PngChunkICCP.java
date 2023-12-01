package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngjException;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngChunkICCP.class */
public class PngChunkICCP extends PngChunkSingle {
    private String h;
    private byte[] i;

    public PngChunkICCP(ImageInfo imageInfo) {
        super("iCCP", imageInfo);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void a(ChunkRaw chunkRaw) {
        int c2 = ChunkHelper.c(chunkRaw.d);
        this.h = ChunkHelper.a(chunkRaw.d, 0, c2);
        if ((chunkRaw.d[c2 + 1] & 255) != 0) {
            throw new PngjException("bad compression for ChunkTypeICCP");
        }
        int i = c2 + 2;
        int length = chunkRaw.d.length - i;
        this.i = new byte[length];
        System.arraycopy(chunkRaw.d, i, this.i, 0, length);
    }
}
