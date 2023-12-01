package java.util.zip;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/util/zip/InflaterOutputStream.class */
public class InflaterOutputStream extends FilterOutputStream {
    private static final int DEFAULT_BUFFER_SIZE = 1024;
    protected final byte[] buf;
    private boolean closed;
    protected final Inflater inf;

    public InflaterOutputStream(OutputStream outputStream) {
        this(outputStream, new Inflater());
    }

    public InflaterOutputStream(OutputStream outputStream, Inflater inflater) {
        this(outputStream, inflater, 1024);
    }

    public InflaterOutputStream(OutputStream outputStream, Inflater inflater, int i) {
        super(outputStream);
        this.closed = false;
        if (outputStream == null) {
            throw new NullPointerException("out == null");
        }
        if (inflater == null) {
            throw new NullPointerException("inf == null");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("bufferSize <= 0: " + i);
        }
        this.inf = inflater;
        this.buf = new byte[i];
    }

    private void checkClosed() throws IOException {
        if (this.closed) {
            throw new IOException();
        }
    }

    private void write() throws IOException, ZipException {
        while (true) {
            try {
                int inflate = this.inf.inflate(this.buf);
                if (inflate <= 0) {
                    return;
                }
                this.out.write(this.buf, 0, inflate);
            } catch (DataFormatException e) {
                throw new ZipException();
            }
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        finish();
        this.inf.end();
        this.out.close();
        this.closed = true;
    }

    public void finish() throws IOException {
        checkClosed();
        write();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        finish();
        this.out.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException, ZipException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException, ZipException {
        checkClosed();
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        this.inf.setInput(bArr, i, i2);
        write();
    }
}
