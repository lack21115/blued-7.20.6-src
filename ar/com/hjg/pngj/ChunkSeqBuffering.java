package ar.com.hjg.pngj;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/ChunkSeqBuffering.class */
public class ChunkSeqBuffering extends ChunkSeqReader {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f3568a = true;

    @Override // ar.com.hjg.pngj.ChunkSeqReader
    protected boolean a(int i, String str) {
        return this.f3568a;
    }

    @Override // ar.com.hjg.pngj.ChunkSeqReader
    protected boolean a(String str) {
        return false;
    }
}
