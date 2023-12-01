package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;
import ar.com.hjg.pngj.PngjException;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngChunkSRGB.class */
public class PngChunkSRGB extends PngChunkSingle {
    private int h;

    public PngChunkSRGB(ImageInfo imageInfo) {
        super("sRGB", imageInfo);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void a(ChunkRaw chunkRaw) {
        if (chunkRaw.f3611a == 1) {
            this.h = PngHelperInternal.a(chunkRaw.d, 0);
            return;
        }
        throw new PngjException("bad chunk length " + chunkRaw);
    }
}
