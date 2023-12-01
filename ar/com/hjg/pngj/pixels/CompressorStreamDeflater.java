package ar.com.hjg.pngj.pixels;

import ar.com.hjg.pngj.PngjOutputException;
import java.util.zip.Deflater;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/pixels/CompressorStreamDeflater.class */
public class CompressorStreamDeflater extends CompressorStream {
    protected Deflater j;
    protected byte[] k;
    protected boolean l;

    @Override // ar.com.hjg.pngj.pixels.CompressorStream
    public void a() {
        if (this.e) {
            return;
        }
        if (!this.j.finished()) {
            this.j.finish();
            while (!this.j.finished()) {
                b();
            }
        }
        this.e = true;
        if (this.f3673a != null) {
            this.f3673a.g();
        }
    }

    @Override // ar.com.hjg.pngj.pixels.CompressorStream
    public void a(byte[] bArr, int i, int i2) {
        if (this.j.finished() || this.e || this.d) {
            throw new PngjOutputException("write beyond end of stream");
        }
        this.j.setInput(bArr, i, i2);
        this.f += i2;
        while (!this.j.needsInput()) {
            b();
        }
    }

    protected void b() {
        byte[] bArr;
        int i;
        int length;
        if (this.f3673a != null) {
            bArr = this.f3673a.h();
            i = this.f3673a.c();
            length = this.f3673a.d();
        } else {
            if (this.k == null) {
                this.k = new byte[4096];
            }
            bArr = this.k;
            i = 0;
            length = bArr.length;
        }
        int deflate = this.j.deflate(bArr, i, length);
        if (deflate > 0) {
            if (this.f3673a != null) {
                this.f3673a.a(deflate);
            }
            this.g += deflate;
        }
    }

    @Override // ar.com.hjg.pngj.pixels.CompressorStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
        try {
            if (this.l) {
                this.j.end();
            }
        } catch (Exception e) {
        }
        super.close();
    }
}
