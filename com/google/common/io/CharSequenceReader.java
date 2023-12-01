package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/io/CharSequenceReader.class */
final class CharSequenceReader extends Reader {
    private int mark;
    private int pos;
    private CharSequence seq;

    public CharSequenceReader(CharSequence charSequence) {
        this.seq = (CharSequence) Preconditions.checkNotNull(charSequence);
    }

    private void checkOpen() throws IOException {
        if (this.seq == null) {
            throw new IOException("reader closed");
        }
    }

    private boolean hasRemaining() {
        return remaining() > 0;
    }

    private int remaining() {
        return this.seq.length() - this.pos;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this) {
            this.seq = null;
        }
    }

    @Override // java.io.Reader
    public void mark(int i) throws IOException {
        synchronized (this) {
            Preconditions.checkArgument(i >= 0, "readAheadLimit (%s) may not be negative", i);
            checkOpen();
            this.mark = this.pos;
        }
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        char c2;
        synchronized (this) {
            checkOpen();
            if (hasRemaining()) {
                CharSequence charSequence = this.seq;
                int i = this.pos;
                this.pos = i + 1;
                c2 = charSequence.charAt(i);
            } else {
                c2 = 65535;
            }
        }
        return c2;
    }

    @Override // java.io.Reader, java.lang.Readable
    public int read(CharBuffer charBuffer) throws IOException {
        synchronized (this) {
            Preconditions.checkNotNull(charBuffer);
            checkOpen();
            if (!hasRemaining()) {
                return -1;
            }
            int min = Math.min(charBuffer.remaining(), remaining());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= min) {
                    return min;
                }
                CharSequence charSequence = this.seq;
                int i3 = this.pos;
                this.pos = i3 + 1;
                charBuffer.put(charSequence.charAt(i3));
                i = i2 + 1;
            }
        }
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        synchronized (this) {
            Preconditions.checkPositionIndexes(i, i + i2, cArr.length);
            checkOpen();
            if (!hasRemaining()) {
                return -1;
            }
            int min = Math.min(i2, remaining());
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= min) {
                    return min;
                }
                CharSequence charSequence = this.seq;
                int i5 = this.pos;
                this.pos = i5 + 1;
                cArr[i + i4] = charSequence.charAt(i5);
                i3 = i4 + 1;
            }
        }
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        synchronized (this) {
            checkOpen();
        }
        return true;
    }

    @Override // java.io.Reader
    public void reset() throws IOException {
        synchronized (this) {
            checkOpen();
            this.pos = this.mark;
        }
    }

    @Override // java.io.Reader
    public long skip(long j) throws IOException {
        long j2;
        synchronized (this) {
            Preconditions.checkArgument(j >= 0, "n (%s) may not be negative", j);
            checkOpen();
            int min = (int) Math.min(remaining(), j);
            this.pos += min;
            j2 = min;
        }
        return j2;
    }
}
