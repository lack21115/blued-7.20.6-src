package ar.com.hjg.pngj.chunks;

import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/ChunksListForWrite.class */
public class ChunksListForWrite extends ChunksList {
    private final List<PngChunk> d;

    /* renamed from: ar.com.hjg.pngj.chunks.ChunksListForWrite$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/ChunksListForWrite$1.class */
    class AnonymousClass1 implements ChunkPredicate {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PngChunk f3666a;

        @Override // ar.com.hjg.pngj.chunks.ChunkPredicate
        public boolean a(PngChunk pngChunk) {
            return ChunkHelper.a(pngChunk, this.f3666a);
        }
    }

    @Override // ar.com.hjg.pngj.chunks.ChunksList
    public String toString() {
        return "ChunkList: written: " + a().size() + " queue: " + this.d.size();
    }
}
