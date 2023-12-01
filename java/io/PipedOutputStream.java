package java.io;

/* loaded from: source-2895416-dex2jar.jar:java/io/PipedOutputStream.class */
public class PipedOutputStream extends OutputStream {
    private PipedInputStream target;

    public PipedOutputStream() {
    }

    public PipedOutputStream(PipedInputStream pipedInputStream) throws IOException {
        connect(pipedInputStream);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        PipedInputStream pipedInputStream = this.target;
        if (pipedInputStream != null) {
            pipedInputStream.done();
            this.target = null;
        }
    }

    public void connect(PipedInputStream pipedInputStream) throws IOException {
        if (pipedInputStream == null) {
            throw new NullPointerException("stream == null");
        }
        synchronized (pipedInputStream) {
            if (this.target != null) {
                throw new IOException("Already connected");
            }
            if (pipedInputStream.isConnected) {
                throw new IOException("Pipe already connected");
            }
            pipedInputStream.establishConnection();
            this.target = pipedInputStream;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        PipedInputStream pipedInputStream = this.target;
        if (pipedInputStream == null) {
            return;
        }
        synchronized (pipedInputStream) {
            pipedInputStream.notifyAll();
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        PipedInputStream pipedInputStream = this.target;
        if (pipedInputStream == null) {
            throw new IOException("Pipe not connected");
        }
        pipedInputStream.receive(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        super.write(bArr, i, i2);
    }
}
