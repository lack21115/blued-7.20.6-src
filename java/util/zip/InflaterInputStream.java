package java.util.zip;

import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.zip.ZipFile;
import libcore.io.Streams;

/* loaded from: source-2895416-dex2jar.jar:java/util/zip/InflaterInputStream.class */
public class InflaterInputStream extends FilterInputStream {
    static final int BUF_SIZE = 512;
    protected byte[] buf;
    boolean closed;
    boolean eof;
    protected Inflater inf;
    protected int len;
    int nativeEndBufSize;

    public InflaterInputStream(InputStream inputStream) {
        this(inputStream, new Inflater(), 512);
    }

    public InflaterInputStream(InputStream inputStream, Inflater inflater) {
        this(inputStream, inflater, 512);
    }

    public InflaterInputStream(InputStream inputStream, Inflater inflater, int i) {
        super(inputStream);
        this.nativeEndBufSize = 0;
        if (inputStream == null) {
            throw new NullPointerException("is == null");
        }
        if (inflater == null) {
            throw new NullPointerException("inflater == null");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("bufferSize <= 0: " + i);
        }
        this.inf = inflater;
        if (inputStream instanceof ZipFile.RAFStream) {
            this.nativeEndBufSize = i;
        } else {
            this.buf = new byte[i];
        }
    }

    private void checkClosed() throws IOException {
        if (this.closed) {
            throw new IOException("Stream is closed");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        checkClosed();
        return this.eof ? 0 : 1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.inf.end();
        this.closed = true;
        this.eof = true;
        super.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fill() throws IOException {
        checkClosed();
        if (this.nativeEndBufSize > 0) {
            this.len = ((ZipFile.RAFStream) this.f42254in).fill(this.inf, this.nativeEndBufSize);
            return;
        }
        int read = this.f42254in.read(this.buf);
        this.len = read;
        if (read > 0) {
            this.inf.setInput(this.buf, 0, this.len);
        }
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
        checkClosed();
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        if (i2 != 0) {
            if (this.eof) {
                return -1;
            }
            do {
                if (this.inf.needsInput()) {
                    fill();
                }
                try {
                    int inflate = this.inf.inflate(bArr, i, i2);
                    this.eof = this.inf.finished();
                    i3 = inflate;
                    if (inflate <= 0) {
                        if (this.eof) {
                            return -1;
                        }
                        if (this.inf.needsDictionary()) {
                            this.eof = true;
                            return -1;
                        }
                    }
                } catch (DataFormatException e) {
                    this.eof = true;
                    if (this.len == -1) {
                        throw new EOFException();
                    }
                    throw ((IOException) new IOException().initCause(e));
                }
            } while (this.len != -1);
            this.eof = true;
            throw new EOFException();
        }
        i3 = 0;
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new IOException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0");
        }
        return Streams.skipByReading(this, j);
    }
}
