package java.io;

/* loaded from: source-2895416-dex2jar.jar:java/io/FilterReader.class */
public abstract class FilterReader extends Reader {
    protected Reader in;

    /* JADX INFO: Access modifiers changed from: protected */
    public FilterReader(Reader reader) {
        super(reader);
        this.in = reader;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.lock) {
            this.in.close();
        }
    }

    @Override // java.io.Reader
    public void mark(int i) throws IOException {
        synchronized (this) {
            synchronized (this.lock) {
                this.in.mark(i);
            }
        }
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        boolean markSupported;
        synchronized (this.lock) {
            markSupported = this.in.markSupported();
        }
        return markSupported;
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        int read;
        synchronized (this.lock) {
            read = this.in.read();
        }
        return read;
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        int read;
        synchronized (this.lock) {
            read = this.in.read(cArr, i, i2);
        }
        return read;
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        boolean ready;
        synchronized (this.lock) {
            ready = this.in.ready();
        }
        return ready;
    }

    @Override // java.io.Reader
    public void reset() throws IOException {
        synchronized (this.lock) {
            this.in.reset();
        }
    }

    @Override // java.io.Reader
    public long skip(long j) throws IOException {
        long skip;
        synchronized (this.lock) {
            skip = this.in.skip(j);
        }
        return skip;
    }
}
