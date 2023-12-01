package java.io;

/* loaded from: source-2895416-dex2jar.jar:java/io/FilterWriter.class */
public abstract class FilterWriter extends Writer {
    protected Writer out;

    protected FilterWriter(Writer writer) {
        super(writer);
        this.out = writer;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.lock) {
            this.out.close();
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        synchronized (this.lock) {
            this.out.flush();
        }
    }

    @Override // java.io.Writer
    public void write(int i) throws IOException {
        synchronized (this.lock) {
            this.out.write(i);
        }
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) throws IOException {
        synchronized (this.lock) {
            this.out.write(str, i, i2);
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        synchronized (this.lock) {
            this.out.write(cArr, i, i2);
        }
    }
}
