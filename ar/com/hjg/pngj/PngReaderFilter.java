package ar.com.hjg.pngj;

import java.io.FilterInputStream;
import java.io.IOException;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/PngReaderFilter.class */
public class PngReaderFilter extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private ChunkSeqReaderPng f3649a;

    /* renamed from: ar.com.hjg.pngj.PngReaderFilter$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/PngReaderFilter$1.class */
    class AnonymousClass1 extends ChunkSeqReaderPng {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ar.com.hjg.pngj.ChunkSeqReaderPng, ar.com.hjg.pngj.ChunkSeqReader
        public void a(ChunkReader chunkReader) {
            super.a(chunkReader);
        }

        @Override // ar.com.hjg.pngj.ChunkSeqReaderPng, ar.com.hjg.pngj.ChunkSeqReader
        protected boolean a(int i, String str) {
            return false;
        }

        @Override // ar.com.hjg.pngj.ChunkSeqReaderPng, ar.com.hjg.pngj.ChunkSeqReader
        public boolean b(int i, String str) {
            return super.b(i, str) || str.equals("IDAT");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.f3649a.d();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = super.read();
        if (read > 0) {
            this.f3649a.b(new byte[]{(byte) read}, 0, 1);
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int read = super.read(bArr);
        if (read > 0) {
            this.f3649a.b(bArr, 0, read);
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read > 0) {
            this.f3649a.b(bArr, i, read);
        }
        return read;
    }
}
