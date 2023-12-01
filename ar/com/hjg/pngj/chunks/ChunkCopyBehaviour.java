package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/ChunkCopyBehaviour.class */
public class ChunkCopyBehaviour {

    /* renamed from: ar.com.hjg.pngj.chunks.ChunkCopyBehaviour$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/ChunkCopyBehaviour$1.class */
    static final class AnonymousClass1 implements ChunkPredicate {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageInfo f3604a;
        final /* synthetic */ int b;

        @Override // ar.com.hjg.pngj.chunks.ChunkPredicate
        public boolean a(PngChunk pngChunk) {
            if (pngChunk.b) {
                if (pngChunk.f3619a.equals("PLTE")) {
                    if (this.f3604a.g && ChunkCopyBehaviour.b(this.b, 1)) {
                        return true;
                    }
                    return !this.f3604a.f && ChunkCopyBehaviour.b(this.b, 8);
                }
                return false;
            }
            boolean z = pngChunk instanceof PngChunkTextVar;
            boolean z2 = pngChunk.d;
            if (ChunkCopyBehaviour.b(this.b, 8)) {
                return true;
            }
            if (z2 && ChunkCopyBehaviour.b(this.b, 4)) {
                return true;
            }
            if (pngChunk.f3619a.equals("tRNS") && ChunkCopyBehaviour.b(this.b, 64)) {
                return true;
            }
            if (pngChunk.f3619a.equals("pHYs") && ChunkCopyBehaviour.b(this.b, 16)) {
                return true;
            }
            if (z && ChunkCopyBehaviour.b(this.b, 32)) {
                return true;
            }
            if (!ChunkCopyBehaviour.b(this.b, 256) || ChunkHelper.a(pngChunk) || z || pngChunk.f3619a.equals("hIST") || pngChunk.f3619a.equals("tIME")) {
                return ChunkCopyBehaviour.b(this.b, 128) && ChunkHelper.a(pngChunk);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(int i, int i2) {
        return (i & i2) != 0;
    }
}
