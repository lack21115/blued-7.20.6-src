package java.io;

import java.nio.CharBuffer;

/* loaded from: source-2895416-dex2jar.jar:java/io/Reader.class */
public abstract class Reader implements Readable, Closeable {
    protected Object lock;

    /* JADX INFO: Access modifiers changed from: protected */
    public Reader() {
        this.lock = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Reader(Object obj) {
        if (obj == null) {
            throw new NullPointerException("lock == null");
        }
        this.lock = obj;
    }

    public abstract void close() throws IOException;

    public void mark(int i) throws IOException {
        throw new IOException();
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        synchronized (this.lock) {
            char[] cArr = new char[1];
            if (read(cArr, 0, 1) != -1) {
                return cArr[0];
            }
            return -1;
        }
    }

    @Override // java.lang.Readable
    public int read(CharBuffer charBuffer) throws IOException {
        int length = charBuffer.length();
        char[] cArr = new char[length];
        int min = Math.min(length, read(cArr));
        if (min > 0) {
            charBuffer.put(cArr, 0, min);
        }
        return min;
    }

    public int read(char[] cArr) throws IOException {
        return read(cArr, 0, cArr.length);
    }

    public abstract int read(char[] cArr, int i, int i2) throws IOException;

    public boolean ready() throws IOException {
        return false;
    }

    public void reset() throws IOException {
        throw new IOException();
    }

    public long skip(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("charCount < 0: " + j);
        }
        synchronized (this.lock) {
            long j2 = 0;
            int i = j < 512 ? (int) j : 512;
            char[] cArr = new char[i];
            while (j2 < j) {
                int read = read(cArr, 0, i);
                if (read == -1) {
                    return j2;
                }
                long j3 = j2 + read;
                if (read < i) {
                    return j3;
                }
                j2 = j3;
                if (j - j3 < i) {
                    i = (int) (j - j3);
                    j2 = j3;
                }
            }
            return j2;
        }
    }
}
