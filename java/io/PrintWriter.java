package java.io;

import com.igexin.push.core.b;
import java.util.Formatter;
import java.util.Locale;

/* loaded from: source-2895416-dex2jar.jar:java/io/PrintWriter.class */
public class PrintWriter extends Writer {
    private boolean autoFlush;
    private boolean ioError;
    protected Writer out;

    public PrintWriter(File file) throws FileNotFoundException {
        this((Writer) new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(file))), false);
    }

    public PrintWriter(File file, String str) throws FileNotFoundException, UnsupportedEncodingException {
        this((Writer) new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(file)), str), false);
    }

    public PrintWriter(OutputStream outputStream) {
        this((Writer) new OutputStreamWriter(outputStream), false);
    }

    public PrintWriter(OutputStream outputStream, boolean z) {
        this(new OutputStreamWriter(outputStream), z);
    }

    public PrintWriter(Writer writer) {
        this(writer, false);
    }

    public PrintWriter(Writer writer, boolean z) {
        super(writer);
        this.autoFlush = z;
        this.out = writer;
    }

    public PrintWriter(String str) throws FileNotFoundException {
        this((Writer) new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(str))), false);
    }

    public PrintWriter(String str, String str2) throws FileNotFoundException, UnsupportedEncodingException {
        this((Writer) new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(str)), str2), false);
    }

    private final void doWrite(char[] cArr, int i, int i2) {
        synchronized (this.lock) {
            if (this.out != null) {
                try {
                    this.out.write(cArr, i, i2);
                } catch (IOException e) {
                    setError();
                }
            } else {
                setError();
            }
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public PrintWriter append(char c2) {
        write(c2);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public PrintWriter append(CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        if (charSequence == null) {
            charSequence2 = b.l;
        }
        append(charSequence2, 0, charSequence2.length());
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public PrintWriter append(CharSequence charSequence, int i, int i2) {
        CharSequence charSequence2 = charSequence;
        if (charSequence == null) {
            charSequence2 = b.l;
        }
        String charSequence3 = charSequence2.subSequence(i, i2).toString();
        write(charSequence3, 0, charSequence3.length());
        return this;
    }

    public boolean checkError() {
        Writer writer = this.out;
        if (writer == null) {
            return this.ioError;
        }
        flush();
        return this.ioError || writer.checkError();
    }

    protected void clearError() {
        synchronized (this.lock) {
            this.ioError = false;
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (this.out != null) {
                try {
                    this.out.close();
                } catch (IOException e) {
                    setError();
                }
                this.out = null;
            }
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        synchronized (this.lock) {
            if (this.out != null) {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    setError();
                }
            } else {
                setError();
            }
        }
    }

    public PrintWriter format(String str, Object... objArr) {
        return format(Locale.getDefault(), str, objArr);
    }

    public PrintWriter format(Locale locale, String str, Object... objArr) {
        if (str == null) {
            throw new NullPointerException("format == null");
        }
        new Formatter(this, locale).format(str, objArr);
        if (this.autoFlush) {
            flush();
        }
        return this;
    }

    public void print(char c2) {
        print(String.valueOf(c2));
    }

    public void print(double d) {
        print(String.valueOf(d));
    }

    public void print(float f) {
        print(String.valueOf(f));
    }

    public void print(int i) {
        print(String.valueOf(i));
    }

    public void print(long j) {
        print(String.valueOf(j));
    }

    public void print(Object obj) {
        print(String.valueOf(obj));
    }

    public void print(String str) {
        if (str == null) {
            str = String.valueOf((Object) null);
        }
        write(str);
    }

    public void print(boolean z) {
        print(String.valueOf(z));
    }

    public void print(char[] cArr) {
        print(new String(cArr, 0, cArr.length));
    }

    public PrintWriter printf(String str, Object... objArr) {
        return format(str, objArr);
    }

    public PrintWriter printf(Locale locale, String str, Object... objArr) {
        return format(locale, str, objArr);
    }

    public void println() {
        synchronized (this.lock) {
            print(System.lineSeparator());
            if (this.autoFlush) {
                flush();
            }
        }
    }

    public void println(char c2) {
        println(String.valueOf(c2));
    }

    public void println(double d) {
        println(String.valueOf(d));
    }

    public void println(float f) {
        println(String.valueOf(f));
    }

    public void println(int i) {
        println(String.valueOf(i));
    }

    public void println(long j) {
        println(String.valueOf(j));
    }

    public void println(Object obj) {
        println(String.valueOf(obj));
    }

    public void println(String str) {
        synchronized (this.lock) {
            print(str);
            println();
        }
    }

    public void println(boolean z) {
        println(String.valueOf(z));
    }

    public void println(char[] cArr) {
        println(new String(cArr, 0, cArr.length));
    }

    protected void setError() {
        synchronized (this.lock) {
            this.ioError = true;
        }
    }

    @Override // java.io.Writer
    public void write(int i) {
        doWrite(new char[]{(char) i}, 0, 1);
    }

    @Override // java.io.Writer
    public void write(String str) {
        write(str.toCharArray());
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) {
        write(str.substring(i, i + i2).toCharArray());
    }

    @Override // java.io.Writer
    public void write(char[] cArr) {
        write(cArr, 0, cArr.length);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        doWrite(cArr, i, i2);
    }
}
