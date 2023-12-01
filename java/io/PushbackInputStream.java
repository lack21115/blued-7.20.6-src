package java.io;

import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/io/PushbackInputStream.class */
public class PushbackInputStream extends FilterInputStream {
    protected byte[] buf;
    protected int pos;

    public PushbackInputStream(InputStream inputStream) {
        super(inputStream);
        this.buf = inputStream == null ? null : new byte[1];
        this.pos = 1;
    }

    public PushbackInputStream(InputStream inputStream, int i) {
        super(inputStream);
        if (i <= 0) {
            throw new IllegalArgumentException("size <= 0");
        }
        this.buf = inputStream == null ? null : new byte[i];
        this.pos = i;
    }

    private IOException streamClosed() throws IOException {
        throw new IOException("PushbackInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        if (this.buf == null) {
            throw new IOException();
        }
        return (this.buf.length - this.pos) + this.f42254in.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f42254in != null) {
            this.f42254in.close();
            this.f42254in = null;
            this.buf = null;
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
        if (this.buf == null) {
            throw new IOException();
        }
        if (this.pos < this.buf.length) {
            byte[] bArr = this.buf;
            int i = this.pos;
            this.pos = i + 1;
            return bArr[i] & 255;
        }
        return this.f42254in.read();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.buf == null) {
            throw streamClosed();
        }
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        int i3 = 0;
        int i4 = 0;
        int i5 = i;
        if (this.pos < this.buf.length) {
            int length = this.buf.length - this.pos >= i2 ? i2 : this.buf.length - this.pos;
            System.arraycopy(this.buf, this.pos, bArr, i, length);
            i5 = i + length;
            this.pos += length;
            i3 = length;
            i4 = 0 + length;
        }
        if (i3 == i2) {
            return i2;
        }
        int read = this.f42254in.read(bArr, i5, i2 - i4);
        return read > 0 ? read + i4 : i4 == 0 ? read : i4;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new IOException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        if (this.f42254in == null) {
            throw streamClosed();
        }
        if (j <= 0) {
            return 0L;
        }
        int i = 0;
        if (this.pos < this.buf.length) {
            i = (int) ((j < ((long) (this.buf.length - this.pos)) ? j : this.buf.length - this.pos) + 0);
            this.pos += i;
        }
        int i2 = i;
        if (i < j) {
            i2 = (int) (i + this.f42254in.skip(j - i));
        }
        return i2;
    }

    public void unread(int i) throws IOException {
        if (this.buf == null) {
            throw new IOException();
        }
        if (this.pos == 0) {
            throw new IOException("Pushback buffer full");
        }
        byte[] bArr = this.buf;
        int i2 = this.pos - 1;
        this.pos = i2;
        bArr[i2] = (byte) i;
    }

    public void unread(byte[] bArr) throws IOException {
        unread(bArr, 0, bArr.length);
    }

    public void unread(byte[] bArr, int i, int i2) throws IOException {
        if (i2 > this.pos) {
            throw new IOException("Pushback buffer full");
        }
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        if (this.buf == null) {
            throw streamClosed();
        }
        System.arraycopy(bArr, i, this.buf, this.pos - i2, i2);
        this.pos -= i2;
    }
}
