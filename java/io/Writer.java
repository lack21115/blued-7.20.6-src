package java.io;

import com.igexin.push.core.b;

/* loaded from: source-2895416-dex2jar.jar:java/io/Writer.class */
public abstract class Writer implements Appendable, Closeable, Flushable {
    protected Object lock;

    /* JADX INFO: Access modifiers changed from: protected */
    public Writer() {
        this.lock = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Writer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("lock == null");
        }
        this.lock = obj;
    }

    @Override // java.lang.Appendable
    public Writer append(char c2) throws IOException {
        write(c2);
        return this;
    }

    @Override // java.lang.Appendable
    public Writer append(CharSequence charSequence) throws IOException {
        CharSequence charSequence2 = charSequence;
        if (charSequence == null) {
            charSequence2 = b.l;
        }
        write(charSequence2.toString());
        return this;
    }

    @Override // java.lang.Appendable
    public Writer append(CharSequence charSequence, int i, int i2) throws IOException {
        CharSequence charSequence2 = charSequence;
        if (charSequence == null) {
            charSequence2 = b.l;
        }
        write(charSequence2.subSequence(i, i2).toString());
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean checkError() {
        return false;
    }

    public abstract void close() throws IOException;

    public abstract void flush() throws IOException;

    public void write(int i) throws IOException {
        synchronized (this.lock) {
            write(new char[]{(char) i});
        }
    }

    public void write(String str) throws IOException {
        write(str, 0, str.length());
    }

    public void write(String str, int i, int i2) throws IOException {
        if ((i | i2) < 0 || i > str.length() - i2) {
            throw new StringIndexOutOfBoundsException(str, i, i2);
        }
        char[] cArr = new char[i2];
        str.getChars(i, i + i2, cArr, 0);
        synchronized (this.lock) {
            write(cArr, 0, cArr.length);
        }
    }

    public void write(char[] cArr) throws IOException {
        write(cArr, 0, cArr.length);
    }

    public abstract void write(char[] cArr, int i, int i2) throws IOException;
}
