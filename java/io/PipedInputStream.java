package java.io;

import libcore.io.IoUtils;

/* loaded from: source-2895416-dex2jar.jar:java/io/PipedInputStream.class */
public class PipedInputStream extends InputStream {
    protected static final int PIPE_SIZE = 1024;
    protected byte[] buffer;
    protected int in;
    private boolean isClosed;
    boolean isConnected;
    private Thread lastReader;
    private Thread lastWriter;
    protected int out;

    public PipedInputStream() {
        this.in = -1;
    }

    public PipedInputStream(int i) {
        this.in = -1;
        if (i <= 0) {
            throw new IllegalArgumentException("pipe size " + i + " too small");
        }
        this.buffer = new byte[i];
    }

    public PipedInputStream(PipedOutputStream pipedOutputStream) throws IOException {
        this.in = -1;
        connect(pipedOutputStream);
    }

    public PipedInputStream(PipedOutputStream pipedOutputStream, int i) throws IOException {
        this(i);
        connect(pipedOutputStream);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        int length;
        synchronized (this) {
            length = (this.buffer == null || this.in == -1) ? 0 : this.in <= this.out ? (this.buffer.length - this.out) + this.in : this.in - this.out;
        }
        return length;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this) {
            this.buffer = null;
            notifyAll();
        }
    }

    public void connect(PipedOutputStream pipedOutputStream) throws IOException {
        pipedOutputStream.connect(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void done() {
        synchronized (this) {
            this.isClosed = true;
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void establishConnection() throws IOException {
        synchronized (this) {
            if (this.isConnected) {
                throw new IOException("Pipe already connected");
            }
            if (this.buffer == null) {
                this.buffer = new byte[1024];
            }
            this.isConnected = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x006b, code lost:
        throw new java.io.IOException("Pipe broken");
     */
    @Override // java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int read() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.PipedInputStream.read():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x007e, code lost:
        throw new java.io.IOException("Pipe broken");
     */
    @Override // java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int read(byte[] r7, int r8, int r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.PipedInputStream.read(byte[], int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void receive(int i) throws IOException {
        synchronized (this) {
            if (this.buffer == null || this.isClosed) {
                throw new IOException("Pipe is closed");
            }
            this.lastWriter = Thread.currentThread();
            while (this.buffer != null && this.out == this.in) {
                try {
                    if (this.lastReader != null && !this.lastReader.isAlive()) {
                        throw new IOException("Pipe broken");
                    }
                    notifyAll();
                    wait(1000L);
                } catch (InterruptedException e) {
                    IoUtils.throwInterruptedIoException();
                }
            }
            if (this.buffer == null) {
                throw new IOException("Pipe is closed");
            }
            if (this.in == -1) {
                this.in = 0;
            }
            if (this.lastReader != null && !this.lastReader.isAlive()) {
                throw new IOException("Pipe broken");
            }
            byte[] bArr = this.buffer;
            int i2 = this.in;
            this.in = i2 + 1;
            bArr[i2] = (byte) i;
            if (this.in == this.buffer.length) {
                this.in = 0;
            }
            notifyAll();
        }
    }
}
