package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngChunkTEXT.class */
public class PngChunkTEXT extends PngChunkTextVar {
    public PngChunkTEXT(ImageInfo imageInfo) {
        super("tEXt", imageInfo);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void a(ChunkRaw chunkRaw) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= chunkRaw.d.length || chunkRaw.d[i] == 0) {
                break;
            }
            i2 = i + 1;
        }
        this.h = ChunkHelper.a(chunkRaw.d, 0, i);
        int i3 = i + 1;
        this.i = i3 < chunkRaw.d.length ? ChunkHelper.a(chunkRaw.d, i3, chunkRaw.d.length - i3) : "";
    }
}
