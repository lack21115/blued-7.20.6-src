package ar.com.hjg.pngj;

import ar.com.hjg.pngj.ChunkReader;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/DeflatedChunkReader.class */
public class DeflatedChunkReader extends ChunkReader {
    protected final DeflatedChunksSet d;
    protected boolean e;
    protected boolean f;
    protected byte[] g;
    protected int h;

    public DeflatedChunkReader(int i, String str, boolean z, long j, DeflatedChunksSet deflatedChunksSet) {
        super(i, str, j, ChunkReader.ChunkReaderMode.PROCESS);
        this.e = false;
        this.f = false;
        this.h = -1;
        this.d = deflatedChunksSet;
        if (str.equals("fdAT")) {
            this.f = true;
            this.g = new byte[4];
        }
        deflatedChunksSet.a(this);
    }

    public void a(int i) {
        this.h = i;
    }

    @Override // ar.com.hjg.pngj.ChunkReader
    protected void a(int i, byte[] bArr, int i2, int i3) {
        int i4 = i2;
        int i5 = i3;
        if (this.f) {
            i4 = i2;
            i5 = i3;
            if (i < 4) {
                while (true) {
                    i4 = i2;
                    i5 = i3;
                    if (i >= 4) {
                        break;
                    }
                    i4 = i2;
                    i5 = i3;
                    if (i3 <= 0) {
                        break;
                    }
                    this.g[i] = bArr[i2];
                    i++;
                    i2++;
                    i3--;
                }
            }
        }
        if (i5 > 0) {
            this.d.a(bArr, i4, i5);
            if (this.e) {
                System.arraycopy(bArr, i4, a().d, this.b, i5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ar.com.hjg.pngj.ChunkReader
    public void c() {
        int c2;
        if (!this.f || !a().f3612c.equals("fdAT") || this.h < 0 || (c2 = PngHelperInternal.c(this.g, 0)) == this.h) {
            return;
        }
        throw new PngjInputException("bad chunk sequence for fDAT chunk " + c2 + " expected " + this.h);
    }
}
