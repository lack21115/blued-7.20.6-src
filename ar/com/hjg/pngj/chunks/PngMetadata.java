package ar.com.hjg.pngj.chunks;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngMetadata.class */
public class PngMetadata {

    /* renamed from: a  reason: collision with root package name */
    private final ChunksList f3671a;
    private final boolean b;

    /* renamed from: ar.com.hjg.pngj.chunks.PngMetadata$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngMetadata$1.class */
    class AnonymousClass1 implements ChunkPredicate {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PngChunk f3672a;

        @Override // ar.com.hjg.pngj.chunks.ChunkPredicate
        public boolean a(PngChunk pngChunk) {
            return ChunkHelper.a(this.f3672a, pngChunk);
        }
    }

    public PngMetadata(ChunksList chunksList) {
        this.f3671a = chunksList;
        if (chunksList instanceof ChunksListForWrite) {
            this.b = false;
        } else {
            this.b = true;
        }
    }
}
