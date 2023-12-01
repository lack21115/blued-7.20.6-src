package java.io;

import java.util.Arrays;
import libcore.io.IoUtils;

/* loaded from: source-2895416-dex2jar.jar:java/io/PipedReader.class */
public class PipedReader extends Reader {
    private static final int PIPE_SIZE = 1024;
    private char[] buffer;

    /* renamed from: in  reason: collision with root package name */
    private int f42258in;
    boolean isClosed;
    boolean isConnected;
    private Thread lastReader;
    private Thread lastWriter;
    private int out;

    public PipedReader() {
        this.f42258in = -1;
    }

    public PipedReader(int i) {
        this.f42258in = -1;
        if (i <= 0) {
            throw new IllegalArgumentException("pipe size " + i + " too small");
        }
        this.buffer = new char[i];
    }

    public PipedReader(PipedWriter pipedWriter) throws IOException {
        this.f42258in = -1;
        connect(pipedWriter);
    }

    public PipedReader(PipedWriter pipedWriter, int i) throws IOException {
        this(i);
        connect(pipedWriter);
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this) {
            this.buffer = null;
            this.isClosed = true;
            notifyAll();
        }
    }

    public void connect(PipedWriter pipedWriter) throws IOException {
        pipedWriter.connect(this);
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
            if (this.isClosed) {
                throw new IOException("Pipe is closed");
            }
            if (this.buffer == null) {
                this.buffer = new char[1024];
            }
            this.isConnected = true;
        }
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        char[] cArr = new char[1];
        int read = read(cArr, 0, 1);
        char c2 = read;
        if (read != -1) {
            c2 = cArr[0];
        }
        return c2;
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        int i3 = 0;
        synchronized (this) {
            if (!this.isConnected) {
                throw new IOException("Pipe not connected");
            }
            if (this.buffer == null) {
                throw new IOException("Pipe is closed");
            }
            Arrays.checkOffsetAndCount(cArr.length, i, i2);
            if (i2 != 0) {
                this.lastReader = Thread.currentThread();
                boolean z = true;
                while (this.f42258in == -1) {
                    try {
                        if (this.isClosed) {
                            i3 = -1;
                            break;
                        } else if (!z && this.lastWriter != null && !this.lastWriter.isAlive()) {
                            throw new IOException("Pipe broken");
                        } else {
                            z = false;
                            notifyAll();
                            wait(1000L);
                        }
                    } catch (InterruptedException e) {
                        IoUtils.throwInterruptedIoException();
                    }
                }
                int i4 = 0;
                if (this.out >= this.f42258in) {
                    int length = i2 > this.buffer.length - this.out ? this.buffer.length - this.out : i2;
                    System.arraycopy(this.buffer, this.out, cArr, i, length);
                    this.out += length;
                    if (this.out == this.buffer.length) {
                        this.out = 0;
                    }
                    i4 = length;
                    if (this.out == this.f42258in) {
                        this.f42258in = -1;
                        this.out = 0;
                        i4 = length;
                    }
                }
                i3 = i4;
                if (i4 != i2) {
                    i3 = i4;
                    if (this.f42258in != -1) {
                        int i5 = this.f42258in - this.out > i2 - i4 ? i2 - i4 : this.f42258in - this.out;
                        System.arraycopy(this.buffer, this.out, cArr, i + i4, i5);
                        this.out += i5;
                        if (this.out == this.f42258in) {
                            this.f42258in = -1;
                            this.out = 0;
                        }
                        i3 = i5 + i4;
                    }
                }
            }
        }
        return i3;
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        boolean z;
        synchronized (this) {
            if (!this.isConnected) {
                throw new IOException("Pipe not connected");
            }
            if (this.buffer == null) {
                throw new IOException("Pipe is closed");
            }
            z = this.f42258in != -1;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void receive(char c2) throws IOException {
        synchronized (this) {
            if (this.buffer == null) {
                throw new IOException("Pipe is closed");
            }
            if (this.lastReader != null && !this.lastReader.isAlive()) {
                throw new IOException("Pipe broken");
            }
            this.lastWriter = Thread.currentThread();
            while (this.buffer != null && this.out == this.f42258in) {
                try {
                    notifyAll();
                    wait(1000L);
                    if (this.lastReader != null && !this.lastReader.isAlive()) {
                        throw new IOException("Pipe broken");
                    }
                } catch (InterruptedException e) {
                    IoUtils.throwInterruptedIoException();
                }
            }
            if (this.buffer == null) {
                throw new IOException("Pipe is closed");
            }
            if (this.f42258in == -1) {
                this.f42258in = 0;
            }
            char[] cArr = this.buffer;
            int i = this.f42258in;
            this.f42258in = i + 1;
            cArr[i] = c2;
            if (this.f42258in == this.buffer.length) {
                this.f42258in = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void receive(char[] cArr, int i, int i2) throws IOException {
        synchronized (this) {
            Arrays.checkOffsetAndCount(cArr.length, i, i2);
            if (this.buffer == null) {
                throw new IOException("Pipe is closed");
            }
            if (this.lastReader != null && !this.lastReader.isAlive()) {
                throw new IOException("Pipe broken");
            }
            this.lastWriter = Thread.currentThread();
            int i3 = i;
            while (i2 > 0) {
                while (this.buffer != null && this.out == this.f42258in) {
                    try {
                        notifyAll();
                        wait(1000L);
                        if (this.lastReader != null && !this.lastReader.isAlive()) {
                            throw new IOException("Pipe broken");
                            break;
                        }
                    } catch (InterruptedException e) {
                        IoUtils.throwInterruptedIoException();
                    }
                }
                if (this.buffer == null) {
                    throw new IOException("Pipe is closed");
                }
                if (this.f42258in == -1) {
                    this.f42258in = 0;
                }
                int i4 = i3;
                int i5 = i2;
                if (this.f42258in >= this.out) {
                    int length = this.buffer.length - this.f42258in;
                    int i6 = length;
                    if (i2 < length) {
                        i6 = i2;
                    }
                    System.arraycopy(cArr, i3, this.buffer, this.f42258in, i6);
                    int i7 = i3 + i6;
                    int i8 = i2 - i6;
                    this.f42258in += i6;
                    i4 = i7;
                    i5 = i8;
                    if (this.f42258in == this.buffer.length) {
                        this.f42258in = 0;
                        i5 = i8;
                        i4 = i7;
                    }
                }
                i3 = i4;
                i2 = i5;
                if (i5 > 0) {
                    i3 = i4;
                    i2 = i5;
                    if (this.f42258in != this.out) {
                        int i9 = this.out - this.f42258in;
                        int i10 = i9;
                        if (i5 < i9) {
                            i10 = i5;
                        }
                        System.arraycopy(cArr, i4, this.buffer, this.f42258in, i10);
                        i3 = i4 + i10;
                        int i11 = i5 - i10;
                        this.f42258in += i10;
                        i2 = i11;
                    }
                }
            }
        }
    }
}
