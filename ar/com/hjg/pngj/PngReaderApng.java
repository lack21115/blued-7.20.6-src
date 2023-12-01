package ar.com.hjg.pngj;

import ar.com.hjg.pngj.chunks.PngChunk;
import ar.com.hjg.pngj.chunks.PngChunkACTL;
import ar.com.hjg.pngj.chunks.PngChunkFCTL;
import java.io.File;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/PngReaderApng.class */
public class PngReaderApng extends PngReaderByte {
    protected PngChunkACTL g;
    protected int h;
    private Boolean i;
    private boolean j;
    private PngChunkFCTL k;

    public PngReaderApng(File file) {
        super(file);
        this.i = null;
        this.j = false;
        this.h = -1;
        a("fcTL");
    }

    @Override // ar.com.hjg.pngj.PngReader
    public void c() {
        super.c();
    }

    @Override // ar.com.hjg.pngj.PngReader
    protected ChunkSeqReaderPng f() {
        return new ChunkSeqReaderPng(false) { // from class: ar.com.hjg.pngj.PngReaderApng.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // ar.com.hjg.pngj.ChunkSeqReaderPng, ar.com.hjg.pngj.ChunkSeqReader
            public void a(int i, String str, long j) {
                super.a(i, str, j);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // ar.com.hjg.pngj.ChunkSeqReaderPng, ar.com.hjg.pngj.ChunkSeqReader
            public void a(ChunkReader chunkReader) {
                super.a(chunkReader);
                if (chunkReader.a().f3612c.equals("fcTL")) {
                    PngReaderApng.this.h++;
                    List<PngChunk> m = PngReaderApng.this.f3600c.m();
                    PngReaderApng.this.k = (PngChunkFCTL) m.get(m.size() - 1);
                    if (chunkReader.a().d() != PngReaderApng.this.k.b().d()) {
                        throw new PngjInputException("something went wrong");
                    }
                    PngReaderApng.this.e().a(PngReaderApng.this.k.e());
                }
            }

            @Override // ar.com.hjg.pngj.ChunkSeqReaderPng, ar.com.hjg.pngj.ChunkSeqReader
            protected boolean a(String str) {
                return str.equals("IDAT") || str.equals("fdAT");
            }

            @Override // ar.com.hjg.pngj.ChunkSeqReaderPng, ar.com.hjg.pngj.ChunkSeqReader
            protected DeflatedChunksSet b(String str) {
                IdatSet idatSet = new IdatSet(str, n(), this.d);
                idatSet.a(this.g);
                return idatSet;
            }

            @Override // ar.com.hjg.pngj.ChunkSeqReaderPng, ar.com.hjg.pngj.ChunkSeqReader
            public boolean b(int i, String str) {
                return super.b(i, str);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // ar.com.hjg.pngj.ChunkSeqReaderPng
            public boolean e(String str) {
                return super.e(str) && !str.equals(Boolean.valueOf(str.equals("fdAT")));
            }
        };
    }

    public boolean g() {
        if (this.i == null) {
            PngChunkACTL pngChunkACTL = (PngChunkACTL) b().a("acTL");
            this.g = pngChunkACTL;
            this.i = Boolean.valueOf(pngChunkACTL != null);
            this.j = this.k != null;
        }
        return this.i.booleanValue();
    }

    public int h() {
        if (g()) {
            return this.g.e();
        }
        return 0;
    }
}
