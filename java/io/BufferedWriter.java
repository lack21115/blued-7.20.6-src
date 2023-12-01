package java.io;

import java.util.Arrays;
import libcore.util.SneakyThrow;

/* loaded from: source-2895416-dex2jar.jar:java/io/BufferedWriter.class */
public class BufferedWriter extends Writer {
    private char[] buf;
    private Writer out;
    private int pos;

    public BufferedWriter(Writer writer) {
        this(writer, 8192);
    }

    public BufferedWriter(Writer writer, int i) {
        super(writer);
        if (i <= 0) {
            throw new IllegalArgumentException("size <= 0");
        }
        this.out = writer;
        this.buf = new char[i];
    }

    private void checkNotClosed() throws IOException {
        if (isClosed()) {
            throw new IOException("BufferedWriter is closed");
        }
    }

    private void flushInternal() throws IOException {
        if (this.pos > 0) {
            this.out.write(this.buf, 0, this.pos);
        }
        this.pos = 0;
    }

    private boolean isClosed() {
        return this.out == null;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Throwable th;
        synchronized (this.lock) {
            if (isClosed()) {
                return;
            }
            Throwable th2 = null;
            try {
                flushInternal();
            } catch (Throwable th3) {
                th2 = th3;
            }
            this.buf = null;
            try {
                this.out.close();
                th = th2;
            } catch (Throwable th4) {
                th = th2;
                if (th2 == null) {
                    th = th4;
                }
            }
            this.out = null;
            if (th != null) {
                SneakyThrow.sneakyThrow(th);
            }
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        synchronized (this.lock) {
            checkNotClosed();
            flushInternal();
            this.out.flush();
        }
    }

    public void newLine() throws IOException {
        write(System.lineSeparator());
    }

    @Override // java.io.Writer
    public void write(int i) throws IOException {
        synchronized (this.lock) {
            checkNotClosed();
            if (this.pos >= this.buf.length) {
                this.out.write(this.buf, 0, this.buf.length);
                this.pos = 0;
            }
            char[] cArr = this.buf;
            int i2 = this.pos;
            this.pos = i2 + 1;
            cArr[i2] = (char) i;
        }
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) throws IOException {
        synchronized (this.lock) {
            checkNotClosed();
            if (i2 <= 0) {
                return;
            }
            if (i < 0 || i > str.length() - i2) {
                throw new StringIndexOutOfBoundsException(str, i, i2);
            }
            if (this.pos == 0 && i2 >= this.buf.length) {
                char[] cArr = new char[i2];
                str.getChars(i, i + i2, cArr, 0);
                this.out.write(cArr, 0, i2);
                return;
            }
            int length = this.buf.length - this.pos;
            int i3 = length;
            if (i2 < length) {
                i3 = i2;
            }
            if (i3 > 0) {
                str.getChars(i, i + i3, this.buf, this.pos);
                this.pos += i3;
            }
            if (this.pos == this.buf.length) {
                this.out.write(this.buf, 0, this.buf.length);
                this.pos = 0;
                if (i2 > i3) {
                    int i4 = i + i3;
                    int i5 = i2 - i3;
                    if (i5 >= this.buf.length) {
                        char[] cArr2 = new char[i2];
                        str.getChars(i4, i4 + i5, cArr2, 0);
                        this.out.write(cArr2, 0, i5);
                        return;
                    }
                    str.getChars(i4, i4 + i5, this.buf, this.pos);
                    this.pos += i5;
                }
            }
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        synchronized (this.lock) {
            checkNotClosed();
            if (cArr == null) {
                throw new NullPointerException("buffer == null");
            }
            Arrays.checkOffsetAndCount(cArr.length, i, i2);
            if (this.pos == 0 && i2 >= this.buf.length) {
                this.out.write(cArr, i, i2);
                return;
            }
            int length = this.buf.length - this.pos;
            int i3 = length;
            if (i2 < length) {
                i3 = i2;
            }
            if (i3 > 0) {
                System.arraycopy(cArr, i, this.buf, this.pos, i3);
                this.pos += i3;
            }
            if (this.pos == this.buf.length) {
                this.out.write(this.buf, 0, this.buf.length);
                this.pos = 0;
                if (i2 > i3) {
                    int i4 = i + i3;
                    int i5 = i2 - i3;
                    if (i5 >= this.buf.length) {
                        this.out.write(cArr, i4, i5);
                    } else {
                        System.arraycopy(cArr, i4, this.buf, this.pos, i5);
                        this.pos += i5;
                    }
                }
            }
        }
    }
}
