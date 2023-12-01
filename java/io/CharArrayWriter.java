package java.io;

import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/io/CharArrayWriter.class */
public class CharArrayWriter extends Writer {
    protected char[] buf;
    protected int count;

    public CharArrayWriter() {
        this.buf = new char[32];
        this.lock = this.buf;
    }

    public CharArrayWriter(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("size < 0");
        }
        this.buf = new char[i];
        this.lock = this.buf;
    }

    private void expand(int i) {
        if (this.count + i <= this.buf.length) {
            return;
        }
        char[] cArr = new char[Math.max(this.buf.length * 2, this.count + i)];
        System.arraycopy(this.buf, 0, cArr, 0, this.count);
        this.buf = cArr;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public CharArrayWriter append(char c) {
        write(c);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public CharArrayWriter append(CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        if (charSequence == null) {
            charSequence2 = "null";
        }
        append(charSequence2, 0, charSequence2.length());
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public CharArrayWriter append(CharSequence charSequence, int i, int i2) {
        CharSequence charSequence2 = charSequence;
        if (charSequence == null) {
            charSequence2 = "null";
        }
        String charSequence3 = charSequence2.subSequence(i, i2).toString();
        write(charSequence3, 0, charSequence3.length());
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    public void reset() {
        synchronized (this.lock) {
            this.count = 0;
        }
    }

    public int size() {
        int i;
        synchronized (this.lock) {
            i = this.count;
        }
        return i;
    }

    public char[] toCharArray() {
        char[] cArr;
        synchronized (this.lock) {
            cArr = new char[this.count];
            System.arraycopy(this.buf, 0, cArr, 0, this.count);
        }
        return cArr;
    }

    public String toString() {
        String str;
        synchronized (this.lock) {
            str = new String(this.buf, 0, this.count);
        }
        return str;
    }

    @Override // java.io.Writer
    public void write(int i) {
        synchronized (this.lock) {
            expand(1);
            char[] cArr = this.buf;
            int i2 = this.count;
            this.count = i2 + 1;
            cArr[i2] = (char) i;
        }
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) {
        if (str == null) {
            throw new NullPointerException("str == null");
        }
        if ((i | i2) < 0 || i > str.length() - i2) {
            throw new StringIndexOutOfBoundsException(str, i, i2);
        }
        synchronized (this.lock) {
            expand(i2);
            str.getChars(i, i + i2, this.buf, this.count);
            this.count += i2;
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        Arrays.checkOffsetAndCount(cArr.length, i, i2);
        synchronized (this.lock) {
            expand(i2);
            System.arraycopy(cArr, i, this.buf, this.count, i2);
            this.count += i2;
        }
    }

    public void writeTo(Writer writer) throws IOException {
        synchronized (this.lock) {
            writer.write(this.buf, 0, this.count);
        }
    }
}
