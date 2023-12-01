package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngjException;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngChunkSTER.class */
public class PngChunkSTER extends PngChunkSingle {
    private byte h;

    public PngChunkSTER(ImageInfo imageInfo) {
        super("sTER", imageInfo);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void a(ChunkRaw chunkRaw) {
        if (chunkRaw.f3659a == 1) {
            this.h = chunkRaw.d[0];
            return;
        }
        throw new PngjException("bad chunk length " + chunkRaw);
    }
}
