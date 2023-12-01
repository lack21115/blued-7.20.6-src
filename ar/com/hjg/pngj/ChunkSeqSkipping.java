package ar.com.hjg.pngj;

import ar.com.hjg.pngj.ChunkReader;
import ar.com.hjg.pngj.chunks.ChunkRaw;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/ChunkSeqSkipping.class */
public class ChunkSeqSkipping extends ChunkSeqReader {

    /* renamed from: a  reason: collision with root package name */
    private List<ChunkRaw> f3576a;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3577c;

    public ChunkSeqSkipping() {
        this(true);
    }

    public ChunkSeqSkipping(boolean z) {
        super(true);
        this.f3576a = new ArrayList();
        this.f3577c = true;
        this.f3577c = z;
    }

    @Override // ar.com.hjg.pngj.ChunkSeqReader
    protected ChunkReader a(String str, int i, long j, boolean z) {
        return new ChunkReader(i, str, j, z ? ChunkReader.ChunkReaderMode.SKIP : ChunkReader.ChunkReaderMode.PROCESS) { // from class: ar.com.hjg.pngj.ChunkSeqSkipping.1
            @Override // ar.com.hjg.pngj.ChunkReader
            protected void a(int i2, byte[] bArr, int i3, int i4) {
                ChunkSeqSkipping.this.a(a(), i2, bArr, i3, i4);
            }

            @Override // ar.com.hjg.pngj.ChunkReader
            protected void c() {
                ChunkSeqSkipping.this.a(this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ar.com.hjg.pngj.ChunkSeqReader
    public void a(ChunkReader chunkReader) {
        super.a(chunkReader);
        this.f3576a.add(chunkReader.a());
    }

    protected void a(ChunkRaw chunkRaw, int i, byte[] bArr, int i2, int i3) {
    }

    @Override // ar.com.hjg.pngj.ChunkSeqReader
    protected boolean a(String str) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ar.com.hjg.pngj.ChunkSeqReader
    public boolean b(int i, String str) {
        return this.f3577c;
    }
}
