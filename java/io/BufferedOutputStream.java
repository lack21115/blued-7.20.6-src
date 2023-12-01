package java.io;

import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/io/BufferedOutputStream.class */
public class BufferedOutputStream extends FilterOutputStream {
    protected byte[] buf;
    protected int count;

    public BufferedOutputStream(OutputStream outputStream) {
        this(outputStream, 8192);
    }

    public BufferedOutputStream(OutputStream outputStream, int i) {
        super(outputStream);
        if (i <= 0) {
            throw new IllegalArgumentException("size <= 0");
        }
        this.buf = new byte[i];
    }

    private void checkNotClosed() throws IOException {
        if (this.buf == null) {
            throw new IOException("BufferedOutputStream is closed");
        }
    }

    private void flushInternal() throws IOException {
        if (this.count > 0) {
            this.out.write(this.buf, 0, this.count);
            this.count = 0;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this) {
            if (this.buf != null) {
                super.close();
                this.buf = null;
            }
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        synchronized (this) {
            checkNotClosed();
            flushInternal();
            this.out.flush();
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        synchronized (this) {
            checkNotClosed();
            if (this.count == this.buf.length) {
                this.out.write(this.buf, 0, this.count);
                this.count = 0;
            }
            byte[] bArr = this.buf;
            int i2 = this.count;
            this.count = i2 + 1;
            bArr[i2] = (byte) i;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        synchronized (this) {
            checkNotClosed();
            if (bArr == null) {
                throw new NullPointerException("buffer == null");
            }
            byte[] bArr2 = this.buf;
            if (i2 >= bArr2.length) {
                flushInternal();
                this.out.write(bArr, i, i2);
            } else {
                Arrays.checkOffsetAndCount(bArr.length, i, i2);
                if (i2 > bArr2.length - this.count) {
                    flushInternal();
                }
                System.arraycopy(bArr, i, bArr2, this.count, i2);
                this.count += i2;
            }
        }
    }
}
