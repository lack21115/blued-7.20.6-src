package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;
import ar.com.hjg.pngj.PngjException;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngChunkSBIT.class */
public class PngChunkSBIT extends PngChunkSingle {
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;

    public PngChunkSBIT(ImageInfo imageInfo) {
        super("sBIT", imageInfo);
    }

    private int e() {
        int i = this.e.f ? 1 : 3;
        int i2 = i;
        if (this.e.e) {
            i2 = i + 1;
        }
        return i2;
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void a(ChunkRaw chunkRaw) {
        if (chunkRaw.f3611a != e()) {
            throw new PngjException("bad chunk length " + chunkRaw);
        } else if (this.e.f) {
            this.h = PngHelperInternal.a(chunkRaw.d, 0);
            if (this.e.e) {
                this.i = PngHelperInternal.a(chunkRaw.d, 1);
            }
        } else {
            this.j = PngHelperInternal.a(chunkRaw.d, 0);
            this.k = PngHelperInternal.a(chunkRaw.d, 1);
            this.l = PngHelperInternal.a(chunkRaw.d, 2);
            if (this.e.e) {
                this.i = PngHelperInternal.a(chunkRaw.d, 3);
            }
        }
    }
}
