package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/d.class */
public abstract class d extends ChunkReader {
    protected final DeflatedChunksSet avg;
    protected boolean avh;
    protected boolean avi;
    protected byte[] avj;
    protected int avk;

    public d(int i, String str, long j, DeflatedChunksSet deflatedChunksSet) {
        super(i, str, j, ChunkReader.ChunkReaderMode.PROCESS);
        this.avh = false;
        this.avi = false;
        this.avk = -1;
        this.avg = deflatedChunksSet;
        deflatedChunksSet.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void Bk() {
        int g;
        if (!this.avi || this.avk < 0 || (g = n.g(this.avj, 0)) == this.avk) {
            return;
        }
        com.kwad.sdk.core.d.b.printStackTrace(new PngjException("bad chunk sequence for fDAT chunk " + g + " expected " + this.avk));
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    protected final void a(int i, byte[] bArr, int i2, int i3) {
        int i4 = i2;
        int i5 = i3;
        if (this.avi) {
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
                    this.avj[i] = bArr[i2];
                    i++;
                    i2++;
                    i3--;
                }
            }
        }
        if (i5 > 0) {
            this.avg.c(bArr, i4, i5);
            if (this.avh) {
                System.arraycopy((Object) bArr, i4, (Object) Bj().data, this.auz, i5);
            }
        }
    }

    public final void bJ(int i) {
        this.avk = i;
    }
}
