package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngChunkFCTL.class */
public class PngChunkFCTL extends PngChunkMultiple {
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private byte o;
    private byte p;

    public PngChunkFCTL(ImageInfo imageInfo) {
        super("fcTL", imageInfo);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void a(ChunkRaw chunkRaw) {
        this.h = PngHelperInternal.c(chunkRaw.d, 0);
        this.i = PngHelperInternal.c(chunkRaw.d, 4);
        this.j = PngHelperInternal.c(chunkRaw.d, 8);
        this.k = PngHelperInternal.c(chunkRaw.d, 12);
        this.l = PngHelperInternal.c(chunkRaw.d, 16);
        this.m = PngHelperInternal.b(chunkRaw.d, 20);
        this.n = PngHelperInternal.b(chunkRaw.d, 22);
        this.o = chunkRaw.d[24];
        this.p = chunkRaw.d[25];
    }

    public ImageInfo e() {
        return new ImageInfo(this.i, this.j, this.e.f3639c, this.e.e, this.e.f, this.e.g);
    }

    public int f() {
        return this.k;
    }

    public int g() {
        return this.l;
    }

    public int h() {
        return this.m;
    }

    public int i() {
        return this.n;
    }

    public byte j() {
        return this.o;
    }

    public byte k() {
        return this.p;
    }
}
