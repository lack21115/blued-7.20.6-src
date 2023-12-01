package ar.com.hjg.pngj.pixels;

import ar.com.hjg.pngj.IDatChunkWriter;
import java.io.OutputStream;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/pixels/CompressorStream.class */
public abstract class CompressorStream extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    protected IDatChunkWriter f3673a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final long f3674c;
    boolean d;
    protected boolean e;
    protected long f;
    protected long g;
    protected int h;
    protected boolean i;
    private byte[] j;

    public abstract void a();

    public abstract void a(byte[] bArr, int i, int i2);

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
        IDatChunkWriter iDatChunkWriter = this.f3673a;
        if (iDatChunkWriter != null) {
            iDatChunkWriter.g();
        }
        this.d = true;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        write(new byte[]{(byte) i});
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        this.h++;
        int i3 = i;
        int i4 = i2;
        if (i2 <= this.b) {
            a(bArr, i, i2);
            if (this.i) {
                int i5 = this.h;
                byte[] bArr2 = this.j;
                if (i5 < bArr2.length) {
                    bArr2[i5] = bArr[i];
                }
            }
        } else {
            while (i4 > 0) {
                a(bArr, i3, this.b);
                int i6 = this.b;
                i3 += i6;
                i4 -= i6;
            }
        }
        if (this.f >= this.f3674c) {
            a();
        }
    }
}
