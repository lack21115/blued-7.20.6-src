package java.io;

import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/io/StringReader.class */
public class StringReader extends Reader {
    private int count;
    private int markpos = -1;
    private int pos;
    private String str;

    public StringReader(String str) {
        this.str = str;
        this.count = str.length();
    }

    private void checkNotClosed() throws IOException {
        if (isClosed()) {
            throw new IOException("StringReader is closed");
        }
    }

    private boolean isClosed() {
        return this.str == null;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.str = null;
    }

    @Override // java.io.Reader
    public void mark(int i) throws IOException {
        if (i < 0) {
            throw new IllegalArgumentException("readLimit < 0: " + i);
        }
        synchronized (this.lock) {
            checkNotClosed();
            this.markpos = this.pos;
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
            if (this.pos != this.count) {
                String str = this.str;
                int i = this.pos;
                this.pos = i + 1;
                return str.charAt(i);
            }
            return -1;
        }
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        synchronized (this.lock) {
            checkNotClosed();
            Arrays.checkOffsetAndCount(cArr.length, i, i2);
            if (i2 == 0) {
                return 0;
            }
            if (this.pos == this.count) {
                return -1;
            }
            int i3 = this.pos + i2 > this.count ? this.count : this.pos + i2;
            this.str.getChars(this.pos, i3, cArr, i);
            int i4 = this.pos;
            this.pos = i3;
            return i3 - i4;
        }
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        synchronized (this.lock) {
            checkNotClosed();
        }
        return true;
    }

    @Override // java.io.Reader
    public void reset() throws IOException {
        synchronized (this.lock) {
            checkNotClosed();
            this.pos = this.markpos != -1 ? this.markpos : 0;
        }
    }

    @Override // java.io.Reader
    public long skip(long j) throws IOException {
        long j2;
        synchronized (this.lock) {
            checkNotClosed();
            int i = -this.pos;
            int i2 = this.count - this.pos;
            if (i2 == 0 || j > i2) {
                j2 = i2;
            } else {
                j2 = j;
                if (j < i) {
                    j2 = i;
                }
            }
            this.pos = (int) (this.pos + j2);
        }
        return j2;
    }
}
