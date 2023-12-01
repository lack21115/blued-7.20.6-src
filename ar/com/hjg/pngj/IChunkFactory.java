package ar.com.hjg.pngj;

import ar.com.hjg.pngj.chunks.ChunkRaw;
import ar.com.hjg.pngj.chunks.PngChunk;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/IChunkFactory.class */
public interface IChunkFactory {
    PngChunk a(ChunkRaw chunkRaw, ImageInfo imageInfo);
}
