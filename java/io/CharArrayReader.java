package java.io;

import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/io/CharArrayReader.class */
public class CharArrayReader extends Reader {
    protected char[] buf;
    protected int count;
    protected int markedPos;
    protected int pos;

    public CharArrayReader(char[] cArr) {
        this.markedPos = -1;
        this.buf = cArr;
        this.count = cArr.length;
    }

    public CharArrayReader(char[] cArr, int i, int i2) {
        this.markedPos = -1;
        if (i < 0 || i > cArr.length || i2 < 0 || i + i2 < 0) {
            throw new IllegalArgumentException();
        }
        this.buf = cArr;
        this.pos = i;
        this.markedPos = i;
        int length = cArr.length;
        this.count = i + i2 >= length ? length : i2;
    }

    private void checkNotClosed() throws IOException {
        if (isClosed()) {
            throw new IOException("CharArrayReader is closed");
        }
    }

    private boolean isClosed() {
        return this.buf == null;
    }

    private boolean isOpen() {
        return this.buf != null;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (isOpen()) {
                this.buf = null;
            }
        }
    }

    @Override // java.io.Reader
    public void mark(int i) throws IOException {
        synchronized (this.lock) {
            checkNotClosed();
            this.markedPos = this.pos;
        }
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        synchronized (this.lock) {
            checkNotClosed();
            if (this.pos == this.count) {
                return -1;
            }
            char[] cArr = this.buf;
            int i = this.pos;
            this.pos = i + 1;
            return cArr[i];
        }
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        Arrays.checkOffsetAndCount(cArr.length, i, i2);
        synchronized (this.lock) {
            checkNotClosed();
            if (this.pos < this.count) {
                if (this.pos + i2 > this.count) {
                    i2 = this.count - this.pos;
                }
                System.arraycopy(this.buf, this.pos, cArr, i, i2);
                this.pos += i2;
                return i2;
            }
            return -1;
        }
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        boolean z;
        synchronized (this.lock) {
            checkNotClosed();
            z = this.pos != this.count;
        }
        return z;
    }

    @Override // java.io.Reader
    public void reset() throws IOException {
        synchronized (this.lock) {
            checkNotClosed();
            this.pos = this.markedPos != -1 ? this.markedPos : 0;
        }
    }

    @Override // java.io.Reader
    public long skip(long j) throws IOException {
        synchronized (this.lock) {
            checkNotClosed();
            if (j <= 0) {
                return 0L;
            }
            if (j < this.count - this.pos) {
                this.pos += (int) j;
            } else {
                j = this.count - this.pos;
                this.pos = this.count;
            }
            return j;
        }
    }
}
