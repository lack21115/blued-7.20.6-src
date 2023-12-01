package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngjException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/ChunksList.class */
public class ChunksList {
    final ImageInfo b;

    /* renamed from: a  reason: collision with root package name */
    List<PngChunk> f3613a = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    boolean f3614c = false;

    /* renamed from: ar.com.hjg.pngj.chunks.ChunksList$3  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/ChunksList$3.class */
    class AnonymousClass3 implements ChunkPredicate {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PngChunk f3617a;

        @Override // ar.com.hjg.pngj.chunks.ChunkPredicate
        public boolean a(PngChunk pngChunk) {
            return ChunkHelper.a(pngChunk, this.f3617a);
        }
    }

    public ChunksList(ImageInfo imageInfo) {
        this.b = imageInfo;
    }

    protected static List<PngChunk> a(List<PngChunk> list, final String str, final String str2) {
        return str2 == null ? ChunkHelper.a(list, new ChunkPredicate() { // from class: ar.com.hjg.pngj.chunks.ChunksList.1
            @Override // ar.com.hjg.pngj.chunks.ChunkPredicate
            public boolean a(PngChunk pngChunk) {
                return pngChunk.f3619a.equals(str);
            }
        }) : ChunkHelper.a(list, new ChunkPredicate() { // from class: ar.com.hjg.pngj.chunks.ChunksList.2
            @Override // ar.com.hjg.pngj.chunks.ChunkPredicate
            public boolean a(PngChunk pngChunk) {
                if (pngChunk.f3619a.equals(str)) {
                    if (!(pngChunk instanceof PngChunkTextVar) || ((PngChunkTextVar) pngChunk).e().equals(str2)) {
                        return !(pngChunk instanceof PngChunkSPLT) || ((PngChunkSPLT) pngChunk).e().equals(str2);
                    }
                    return false;
                }
                return false;
            }
        });
    }

    public PngChunk a(String str) {
        return a(str, false);
    }

    public PngChunk a(String str, String str2, boolean z) {
        List<? extends PngChunk> a2 = a(str, str2);
        if (a2.isEmpty()) {
            return null;
        }
        if (a2.size() <= 1 || (!z && a2.get(0).a())) {
            return a2.get(a2.size() - 1);
        }
        throw new PngjException("unexpected multiple chunks id=" + str);
    }

    public PngChunk a(String str, boolean z) {
        return a(str, (String) null, z);
    }

    public List<PngChunk> a() {
        return this.f3613a;
    }

    public List<? extends PngChunk> a(String str, String str2) {
        return a(this.f3613a, str, str2);
    }

    public void a(PngChunk pngChunk, int i) {
        pngChunk.a(i);
        this.f3613a.add(pngChunk);
        if (pngChunk.f3619a.equals("PLTE")) {
            this.f3614c = true;
        }
    }

    public String toString() {
        return "ChunkList: read: " + this.f3613a.size();
    }
}
