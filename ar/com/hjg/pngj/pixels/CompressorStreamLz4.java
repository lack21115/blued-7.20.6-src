package ar.com.hjg.pngj.pixels;

import ar.com.hjg.pngj.PngjOutputException;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/pixels/CompressorStreamLz4.class */
public class CompressorStreamLz4 extends CompressorStream {
    private final DeflaterEstimatorLz4 j;
    private byte[] k;
    private final int l;
    private int m;

    @Override // ar.com.hjg.pngj.pixels.CompressorStream
    public void a() {
        if (this.e) {
            return;
        }
        b();
        this.e = true;
    }

    @Override // ar.com.hjg.pngj.pixels.CompressorStream
    public void a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return;
        }
        if (this.e || this.d) {
            throw new PngjOutputException("write beyond end of stream");
        }
        this.f += i2;
        while (i2 > 0) {
            if (this.m != 0 || (i2 < 16000 && this.f != this.f3674c)) {
                if (this.k == null) {
                    this.k = new byte[this.l];
                }
                int i3 = this.m;
                int i4 = this.l;
                int i5 = i3 + i2 <= i4 ? i2 : i4 - i3;
                if (i5 > 0) {
                    System.arraycopy((Object) bArr, i, (Object) this.k, this.m, i5);
                }
                int i6 = this.m + i5;
                this.m = i6;
                int i7 = i2 - i5;
                int i8 = i + i5;
                i = i8;
                i2 = i7;
                if (i6 == this.l) {
                    b();
                    i = i8;
                    i2 = i7;
                }
            } else {
                this.g += this.j.a(bArr, i, i2);
                i2 = 0;
            }
        }
    }

    void b() {
        if (this.m > 0) {
            this.g += this.j.a(this.k, 0, this.m);
            this.m = 0;
        }
    }

    @Override // ar.com.hjg.pngj.pixels.CompressorStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
        if (this.d) {
            return;
        }
        super.close();
        this.k = null;
    }
}
