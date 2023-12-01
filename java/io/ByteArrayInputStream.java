package java.io;

import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/io/ByteArrayInputStream.class */
public class ByteArrayInputStream extends InputStream {
    protected byte[] buf;
    protected int count;
    protected int mark;
    protected int pos;

    public ByteArrayInputStream(byte[] bArr) {
        this.mark = 0;
        this.buf = bArr;
        this.count = bArr.length;
    }

    public ByteArrayInputStream(byte[] bArr, int i, int i2) {
        this.buf = bArr;
        this.pos = i;
        this.mark = i;
        this.count = i + i2 > bArr.length ? bArr.length : i + i2;
    }

    @Override // java.io.InputStream
    public int available() {
        int i;
        int i2;
        synchronized (this) {
            i = this.count;
            i2 = this.pos;
        }
        return i - i2;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        synchronized (this) {
            this.mark = this.pos;
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        int i;
        synchronized (this) {
            if (this.pos < this.count) {
                byte[] bArr = this.buf;
                int i2 = this.pos;
                this.pos = i2 + 1;
                i = bArr[i2] & 255;
            } else {
                i = -1;
            }
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        synchronized (this) {
            Arrays.checkOffsetAndCount(bArr.length, i, i2);
            if (this.pos >= this.count) {
                i2 = -1;
            } else if (i2 == 0) {
                i2 = 0;
            } else {
                if (this.count - this.pos < i2) {
                    i2 = this.count - this.pos;
                }
                System.arraycopy(this.buf, this.pos, bArr, i, i2);
                this.pos += i2;
            }
        }
        return i2;
    }

    @Override // java.io.InputStream
    public void reset() {
        synchronized (this) {
            this.pos = this.mark;
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        long j2;
        synchronized (this) {
            if (j <= 0) {
                j2 = 0;
            } else {
                int i = this.pos;
                this.pos = ((long) (this.count - this.pos)) < j ? this.count : (int) (this.pos + j);
                j2 = this.pos - i;
            }
        }
        return j2;
    }
}
