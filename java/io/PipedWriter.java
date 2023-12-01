package java.io;

/* loaded from: source-2895416-dex2jar.jar:java/io/PipedWriter.class */
public class PipedWriter extends Writer {
    private PipedReader destination;
    private boolean isClosed;

    public PipedWriter() {
    }

    public PipedWriter(PipedReader pipedReader) throws IOException {
        super(pipedReader);
        connect(pipedReader);
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        PipedReader pipedReader = this.destination;
        if (pipedReader != null) {
            pipedReader.done();
            this.isClosed = true;
            this.destination = null;
        }
    }

    public void connect(PipedReader pipedReader) throws IOException {
        if (pipedReader == null) {
            throw new NullPointerException("reader == null");
        }
        synchronized (pipedReader) {
            if (this.destination != null) {
                throw new IOException("Pipe already connected");
            }
            pipedReader.establishConnection();
            this.lock = pipedReader;
            this.destination = pipedReader;
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        PipedReader pipedReader = this.destination;
        if (this.isClosed) {
            throw new IOException("Pipe is closed");
        }
        if (pipedReader == null) {
            return;
        }
        synchronized (pipedReader) {
            if (pipedReader.isClosed) {
                throw new IOException("Pipe is broken");
            }
            pipedReader.notifyAll();
        }
    }

    @Override // java.io.Writer
    public void write(int i) throws IOException {
        PipedReader pipedReader = this.destination;
        if (pipedReader == null) {
            throw new IOException("Pipe not connected");
        }
        pipedReader.receive((char) i);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        PipedReader pipedReader = this.destination;
        if (pipedReader == null) {
            throw new IOException("Pipe not connected");
        }
        pipedReader.receive(cArr, i, i2);
    }
}
