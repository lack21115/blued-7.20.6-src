package java.io;

import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/io/PushbackReader.class */
public class PushbackReader extends FilterReader {
    char[] buf;
    int pos;

    public PushbackReader(Reader reader) {
        super(reader);
        this.buf = new char[1];
        this.pos = 1;
    }

    public PushbackReader(Reader reader, int i) {
        super(reader);
        if (i <= 0) {
            throw new IllegalArgumentException("size <= 0");
        }
        this.buf = new char[i];
        this.pos = i;
    }

    private void checkNotClosed() throws IOException {
        if (this.buf == null) {
            throw new IOException("PushbackReader is closed");
        }
    }

    @Override // java.io.FilterReader, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.lock) {
            this.buf = null;
            this.f42255in.close();
        }
    }

    @Override // java.io.FilterReader, java.io.Reader
    public void mark(int i) throws IOException {
        throw new IOException("mark/reset not supported");
    }

    @Override // java.io.FilterReader, java.io.Reader
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read() throws IOException {
        synchronized (this.lock) {
            checkNotClosed();
            if (this.pos >= this.buf.length) {
                return this.f42255in.read();
            }
            char[] cArr = this.buf;
            int i = this.pos;
            this.pos = i + 1;
            return cArr[i];
        }
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        synchronized (this.lock) {
            checkNotClosed();
            Arrays.checkOffsetAndCount(cArr.length, i, i2);
            int i3 = 0;
            int i4 = 0;
            int i5 = i;
            if (this.pos < this.buf.length) {
                int length = this.buf.length - this.pos >= i2 ? i2 : this.buf.length - this.pos;
                System.arraycopy(this.buf, this.pos, cArr, i, length);
                i5 = i + length;
                int i6 = 0 + length;
                this.pos += length;
                i3 = length;
                i4 = i6;
            }
            if (i3 == i2) {
                return i2;
            }
            int read = this.f42255in.read(cArr, i5, i2 - i4);
            return read > 0 ? read + i4 : i4 == 0 ? read : i4;
        }
    }

    @Override // java.io.FilterReader, java.io.Reader
    public boolean ready() throws IOException {
        boolean z;
        synchronized (this.lock) {
            if (this.buf == null) {
                throw new IOException("Reader is closed");
            }
            if (this.buf.length - this.pos <= 0 && !this.f42255in.ready()) {
                z = false;
            }
            z = true;
        }
        return z;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public void reset() throws IOException {
        throw new IOException("mark/reset not supported");
    }

    @Override // java.io.FilterReader, java.io.Reader
    public long skip(long j) throws IOException {
        long skip;
        if (j < 0) {
            throw new IllegalArgumentException("charCount < 0: " + j);
        }
        synchronized (this.lock) {
            checkNotClosed();
            if (j == 0) {
                return 0L;
            }
            int length = this.buf.length - this.pos;
            if (length > 0) {
                long j2 = j - length;
                if (j2 <= 0) {
                    this.pos = (int) (this.pos + j);
                    return j;
                }
                this.pos += length;
                skip = this.f42255in.skip(j2);
            } else {
                skip = this.f42255in.skip(j);
            }
            return skip + length;
        }
    }

    public void unread(int i) throws IOException {
        synchronized (this.lock) {
            checkNotClosed();
            if (this.pos == 0) {
                throw new IOException("Pushback buffer full");
            }
            char[] cArr = this.buf;
            int i2 = this.pos - 1;
            this.pos = i2;
            cArr[i2] = (char) i;
        }
    }

    public void unread(char[] cArr) throws IOException {
        unread(cArr, 0, cArr.length);
    }

    public void unread(char[] cArr, int i, int i2) throws IOException {
        synchronized (this.lock) {
            checkNotClosed();
            if (i2 > this.pos) {
                throw new IOException("Pushback buffer full");
            }
            Arrays.checkOffsetAndCount(cArr.length, i, i2);
            int i3 = i + i2;
            while (true) {
                int i4 = i3 - 1;
                if (i4 >= i) {
                    unread(cArr[i4]);
                    i3 = i4;
                }
            }
        }
    }
}
