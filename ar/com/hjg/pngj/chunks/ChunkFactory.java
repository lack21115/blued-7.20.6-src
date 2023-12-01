package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.IChunkFactory;
import ar.com.hjg.pngj.ImageInfo;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/ChunkFactory.class */
public class ChunkFactory implements IChunkFactory {

    /* renamed from: a  reason: collision with root package name */
    boolean f3653a;

    public ChunkFactory() {
        this(true);
    }

    public ChunkFactory(boolean z) {
        this.f3653a = z;
    }

    @Override // ar.com.hjg.pngj.IChunkFactory
    public final PngChunk a(ChunkRaw chunkRaw, ImageInfo imageInfo) {
        PngChunk a2 = a(chunkRaw.f3660c, imageInfo);
        PngChunk pngChunk = a2;
        if (a2 == null) {
            pngChunk = c(chunkRaw.f3660c, imageInfo);
        }
        PngChunk pngChunk2 = pngChunk;
        if (pngChunk == null) {
            pngChunk2 = b(chunkRaw.f3660c, imageInfo);
        }
        pngChunk2.b(chunkRaw);
        if (this.f3653a && chunkRaw.d != null) {
            pngChunk2.a(chunkRaw);
        }
        return pngChunk2;
    }

    protected final PngChunk a(String str, ImageInfo imageInfo) {
        if (str.equals("IDAT")) {
            return new PngChunkIDAT(imageInfo);
        }
        if (str.equals("IHDR")) {
            return new PngChunkIHDR(imageInfo);
        }
        if (str.equals("PLTE")) {
            return new PngChunkPLTE(imageInfo);
        }
        if (str.equals("IEND")) {
            return new PngChunkIEND(imageInfo);
        }
        if (str.equals("tEXt")) {
            return new PngChunkTEXT(imageInfo);
        }
        if (str.equals("iTXt")) {
            return new PngChunkITXT(imageInfo);
        }
        if (str.equals("zTXt")) {
            return new PngChunkZTXT(imageInfo);
        }
        if (str.equals("bKGD")) {
            return new PngChunkBKGD(imageInfo);
        }
        if (str.equals("gAMA")) {
            return new PngChunkGAMA(imageInfo);
        }
        if (str.equals("pHYs")) {
            return new PngChunkPHYS(imageInfo);
        }
        if (str.equals("iCCP")) {
            return new PngChunkICCP(imageInfo);
        }
        if (str.equals("tIME")) {
            return new PngChunkTIME(imageInfo);
        }
        if (str.equals("tRNS")) {
            return new PngChunkTRNS(imageInfo);
        }
        if (str.equals("cHRM")) {
            return new PngChunkCHRM(imageInfo);
        }
        if (str.equals("sBIT")) {
            return new PngChunkSBIT(imageInfo);
        }
        if (str.equals("sRGB")) {
            return new PngChunkSRGB(imageInfo);
        }
        if (str.equals("hIST")) {
            return new PngChunkHIST(imageInfo);
        }
        if (str.equals("sPLT")) {
            return new PngChunkSPLT(imageInfo);
        }
        if (str.equals("fdAT")) {
            return new PngChunkFDAT(imageInfo);
        }
        if (str.equals("acTL")) {
            return new PngChunkACTL(imageInfo);
        }
        if (str.equals("fcTL")) {
            return new PngChunkFCTL(imageInfo);
        }
        return null;
    }

    protected final PngChunk b(String str, ImageInfo imageInfo) {
        return new PngChunkUNKNOWN(str, imageInfo);
    }

    protected PngChunk c(String str, ImageInfo imageInfo) {
        if (str.equals("oFFs")) {
            return new PngChunkOFFS(imageInfo);
        }
        if (str.equals("sTER")) {
            return new PngChunkSTER(imageInfo);
        }
        return null;
    }
}
