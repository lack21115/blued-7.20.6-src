package java.io;

/* loaded from: source-2895416-dex2jar.jar:java/io/FilterInputStream.class */
public class FilterInputStream extends InputStream {

    /* renamed from: in  reason: collision with root package name */
    protected volatile InputStream f42254in;

    /* JADX INFO: Access modifiers changed from: protected */
    public FilterInputStream(InputStream inputStream) {
        this.f42254in = inputStream;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f42254in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f42254in.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        synchronized (this) {
            this.f42254in.mark(i);
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f42254in.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.f42254in.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.f42254in.read(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        synchronized (this) {
            this.f42254in.reset();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        return this.f42254in.skip(j);
    }
}
