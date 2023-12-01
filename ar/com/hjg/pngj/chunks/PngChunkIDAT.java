package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngChunkIDAT.class */
public class PngChunkIDAT extends PngChunkMultiple {
    public PngChunkIDAT(ImageInfo imageInfo) {
        super("IDAT", imageInfo);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void a(ChunkRaw chunkRaw) {
    }
}
