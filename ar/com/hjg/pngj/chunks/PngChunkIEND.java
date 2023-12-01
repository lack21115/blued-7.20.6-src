package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngChunkIEND.class */
public class PngChunkIEND extends PngChunkSingle {
    public PngChunkIEND(ImageInfo imageInfo) {
        super("IEND", imageInfo);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void a(ChunkRaw chunkRaw) {
    }

    public ChunkRaw e() {
        return new ChunkRaw(0, ChunkHelper.d, false);
    }
}
