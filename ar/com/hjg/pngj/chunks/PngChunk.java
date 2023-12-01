package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngChunk.class */
public abstract class PngChunk {

    /* renamed from: a  reason: collision with root package name */
    public final String f3667a;
    public final boolean b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f3668c;
    public final boolean d;
    protected final ImageInfo e;
    protected ChunkRaw f;
    private boolean h = false;
    protected int g = -1;

    /* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngChunk$ChunkOrderingConstraint.class */
    public enum ChunkOrderingConstraint {
        NONE,
        BEFORE_PLTE_AND_IDAT,
        AFTER_PLTE_BEFORE_IDAT,
        AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED,
        BEFORE_IDAT,
        AFTER_IDAT,
        NA
    }

    public PngChunk(String str, ImageInfo imageInfo) {
        this.f3667a = str;
        this.e = imageInfo;
        this.b = ChunkHelper.b(str);
        this.f3668c = ChunkHelper.c(str);
        this.d = ChunkHelper.d(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i) {
        this.g = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(ChunkRaw chunkRaw);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean a();

    public ChunkRaw b() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ChunkRaw chunkRaw) {
        this.f = chunkRaw;
    }

    public int c() {
        ChunkRaw chunkRaw = this.f;
        if (chunkRaw != null) {
            return chunkRaw.f3659a;
        }
        return -1;
    }

    public long d() {
        ChunkRaw chunkRaw = this.f;
        if (chunkRaw != null) {
            return chunkRaw.d();
        }
        return -1L;
    }

    public String toString() {
        return "chunk id= " + this.f3667a + " (len=" + c() + " offset=" + d() + ")";
    }
}
