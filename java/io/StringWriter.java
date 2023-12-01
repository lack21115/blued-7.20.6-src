package java.io;

import com.igexin.push.core.b;
import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/io/StringWriter.class */
public class StringWriter extends Writer {
    private StringBuffer buf;

    public StringWriter() {
        this.buf = new StringBuffer(16);
        this.lock = this.buf;
    }

    public StringWriter(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("initialSize < 0: " + i);
        }
        this.buf = new StringBuffer(i);
        this.lock = this.buf;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public StringWriter append(char c2) {
        write(c2);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public StringWriter append(CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        if (charSequence == null) {
            charSequence2 = b.l;
        }
        write(charSequence2.toString());
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public StringWriter append(CharSequence charSequence, int i, int i2) {
        CharSequence charSequence2 = charSequence;
        if (charSequence == null) {
            charSequence2 = b.l;
        }
        String charSequence3 = charSequence2.subSequence(i, i2).toString();
        write(charSequence3, 0, charSequence3.length());
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    public StringBuffer getBuffer() {
        return this.buf;
    }

    public String toString() {
        return this.buf.toString();
    }

    @Override // java.io.Writer
    public void write(int i) {
        this.buf.append((char) i);
    }

    @Override // java.io.Writer
    public void write(String str) {
        this.buf.append(str);
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) {
        this.buf.append(str.substring(i, i + i2));
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        Arrays.checkOffsetAndCount(cArr.length, i, i2);
        if (i2 == 0) {
            return;
        }
        this.buf.append(cArr, i, i2);
    }
}
