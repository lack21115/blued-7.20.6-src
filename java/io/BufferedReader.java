package java.io;

import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/io/BufferedReader.class */
public class BufferedReader extends Reader {
    private char[] buf;
    private int end;

    /* renamed from: in  reason: collision with root package name */
    private Reader f42252in;
    private boolean lastWasCR;
    private int mark;
    private int markLimit;
    private boolean markedLastWasCR;
    private int pos;

    public BufferedReader(Reader reader) {
        this(reader, 8192);
    }

    public BufferedReader(Reader reader, int i) {
        super(reader);
        this.mark = -1;
        this.markLimit = -1;
        if (i <= 0) {
            throw new IllegalArgumentException("size <= 0");
        }
        this.f42252in = reader;
        this.buf = new char[i];
    }

    private void checkNotClosed() throws IOException {
        if (isClosed()) {
            throw new IOException("BufferedReader is closed");
        }
    }

    private int fillBuf() throws IOException {
        int read;
        if (this.mark == -1 || this.pos - this.mark >= this.markLimit) {
            read = this.f42252in.read(this.buf, 0, this.buf.length);
            if (read > 0) {
                this.mark = -1;
                this.pos = 0;
                this.end = read;
            }
        } else {
            if (this.mark == 0 && this.markLimit > this.buf.length) {
                int length = this.buf.length * 2;
                int i = length;
                if (length > this.markLimit) {
                    i = this.markLimit;
                }
                char[] cArr = new char[i];
                System.arraycopy(this.buf, 0, cArr, 0, this.buf.length);
                this.buf = cArr;
            } else if (this.mark > 0) {
                System.arraycopy(this.buf, this.mark, this.buf, 0, this.buf.length - this.mark);
                this.pos -= this.mark;
                this.end -= this.mark;
                this.mark = 0;
            }
            int read2 = this.f42252in.read(this.buf, this.pos, this.buf.length - this.pos);
            read = read2;
            if (read2 != -1) {
                this.end += read2;
                return read2;
            }
        }
        return read;
    }

    private boolean isClosed() {
        return this.buf == null;
    }

    private void maybeSwallowLF() throws IOException {
        if (this.lastWasCR) {
            chompNewline();
            this.lastWasCR = false;
        }
    }

    private int readChar() throws IOException {
        char c2 = 65535;
        if (this.pos < this.end || fillBuf() != -1) {
            char[] cArr = this.buf;
            int i = this.pos;
            this.pos = i + 1;
            c2 = cArr[i];
        }
        return c2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void chompNewline() throws IOException {
        if (!(this.pos == this.end && fillBuf() == -1) && this.buf[this.pos] == '\n') {
            this.pos++;
        }
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.lock) {
            if (!isClosed()) {
                this.f42252in.close();
                this.buf = null;
            }
        }
    }

    @Override // java.io.Reader
    public void mark(int i) throws IOException {
        if (i < 0) {
            throw new IllegalArgumentException("markLimit < 0:" + i);
        }
        synchronized (this.lock) {
            checkNotClosed();
            this.markLimit = i;
            this.mark = this.pos;
            this.markedLastWasCR = this.lastWasCR;
        }
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        int i;
        synchronized (this.lock) {
            checkNotClosed();
            int readChar = readChar();
            i = readChar;
            if (this.lastWasCR) {
                i = readChar;
                if (readChar == 10) {
                    i = readChar();
                }
            }
            this.lastWasCR = false;
        }
        return i;
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        int i3;
        synchronized (this.lock) {
            checkNotClosed();
            Arrays.checkOffsetAndCount(cArr.length, i, i2);
            if (i2 == 0) {
                return 0;
            }
            maybeSwallowLF();
            int i4 = i;
            int i5 = i2;
            while (true) {
                i3 = i5;
                if (i5 <= 0) {
                    break;
                }
                int i6 = this.end - this.pos;
                int i7 = i5;
                int i8 = i4;
                if (i6 > 0) {
                    int i9 = i6 >= i5 ? i5 : i6;
                    System.arraycopy(this.buf, this.pos, cArr, i4, i9);
                    this.pos += i9;
                    i8 = i4 + i9;
                    i7 = i5 - i9;
                }
                i3 = i7;
                if (i7 != 0) {
                    if (i7 < i2 && !this.f42252in.ready()) {
                        i3 = i7;
                        break;
                    } else if ((this.mark != -1 && this.pos - this.mark < this.markLimit) || i7 < this.buf.length) {
                        i5 = i7;
                        i4 = i8;
                        if (fillBuf() == -1) {
                            i3 = i7;
                            break;
                        }
                    } else {
                        int read = this.f42252in.read(cArr, i8, i7);
                        i3 = i7;
                        if (read > 0) {
                            i3 = i7 - read;
                            this.mark = -1;
                        }
                    }
                } else {
                    break;
                }
            }
            int i10 = i2 - i3;
            if (i10 > 0) {
                return i10;
            }
            return -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e4, code lost:
        r0.append(r7.buf, r7.pos, r8 - r7.pos);
        r7.pos = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0102, code lost:
        if (r0 != '\r') goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0105, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0108, code lost:
        r7.lastWasCR = r10;
        r0 = r0.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0119, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0140, code lost:
        r10 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String readLine() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.BufferedReader.readLine():java.lang.String");
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        boolean z;
        synchronized (this.lock) {
            checkNotClosed();
            if (this.end - this.pos <= 0 && !this.f42252in.ready()) {
                z = false;
            }
            z = true;
        }
        return z;
    }

    @Override // java.io.Reader
    public void reset() throws IOException {
        synchronized (this.lock) {
            checkNotClosed();
            if (this.mark == -1) {
                throw new IOException("Invalid mark");
            }
            this.pos = this.mark;
            this.lastWasCR = this.markedLastWasCR;
        }
    }

    @Override // java.io.Reader
    public long skip(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("charCount < 0: " + j);
        }
        synchronized (this.lock) {
            checkNotClosed();
            if (this.end - this.pos >= j) {
                this.pos = (int) (this.pos + j);
                return j;
            }
            long j2 = this.end - this.pos;
            this.pos = this.end;
            while (j2 < j) {
                if (fillBuf() == -1) {
                    return j2;
                }
                if (this.end - this.pos >= j - j2) {
                    this.pos = (int) (this.pos + (j - j2));
                    return j;
                }
                j2 += this.end - this.pos;
                this.pos = this.end;
            }
            return j;
        }
    }
}
