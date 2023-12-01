package java.util.zip;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import libcore.io.Streams;

/* loaded from: source-2895416-dex2jar.jar:java/util/zip/DeflaterInputStream.class */
public class DeflaterInputStream extends FilterInputStream {
    private static final int DEFAULT_BUFFER_SIZE = 1024;
    private boolean available;
    protected final byte[] buf;
    private boolean closed;
    protected final Deflater def;

    public DeflaterInputStream(InputStream inputStream) {
        this(inputStream, new Deflater(), 1024);
    }

    public DeflaterInputStream(InputStream inputStream, Deflater deflater) {
        this(inputStream, deflater, 1024);
    }

    public DeflaterInputStream(InputStream inputStream, Deflater deflater, int i) {
        super(inputStream);
        this.closed = false;
        this.available = true;
        if (inputStream == null) {
            throw new NullPointerException("in == null");
        }
        if (deflater == null) {
            throw new NullPointerException("deflater == null");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("bufferSize <= 0: " + i);
        }
        this.def = deflater;
        this.buf = new byte[i];
    }

    private void checkClosed() throws IOException {
        if (this.closed) {
            throw new IOException("Stream is closed");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        checkClosed();
        return this.available ? 1 : 0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
        this.def.end();
        this.f42254in.close();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        return Streams.readSingleByte(this);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4;
        checkClosed();
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        if (i2 == 0) {
            i4 = 0;
        } else if (!this.available) {
            return -1;
        } else {
            int i5 = 0;
            while (true) {
                i3 = i5;
                if (i3 >= i2 || this.def.finished()) {
                    break;
                }
                if (this.def.needsInput()) {
                    int read = this.f42254in.read(this.buf);
                    if (read == -1) {
                        this.def.finish();
                    } else {
                        this.def.setInput(this.buf, 0, read);
                    }
                }
                int deflate = this.def.deflate(bArr, i + i3, i2 - i3);
                if (deflate == -1) {
                    break;
                }
                i5 = i3 + deflate;
            }
            int i6 = i3;
            if (i3 == 0) {
                i6 = -1;
                this.available = false;
            }
            i4 = i6;
            if (this.def.finished()) {
                this.available = false;
                return i6;
            }
        }
        return i4;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new IOException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        return Streams.skipByReading(this, Math.min(2147483647L, j));
    }
}
