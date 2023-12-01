package java.io;

import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Locale;

/* loaded from: source-2895416-dex2jar.jar:java/io/PrintStream.class */
public class PrintStream extends FilterOutputStream implements Appendable, Closeable {
    private boolean autoFlush;
    private String encoding;
    private boolean ioError;

    public PrintStream(File file) throws FileNotFoundException {
        super(new FileOutputStream(file));
    }

    public PrintStream(File file, String str) throws FileNotFoundException, UnsupportedEncodingException {
        super(new FileOutputStream(file));
        if (str == null) {
            throw new NullPointerException("charsetName == null");
        }
        if (!Charset.isSupported(str)) {
            throw new UnsupportedEncodingException(str);
        }
        this.encoding = str;
    }

    public PrintStream(OutputStream outputStream) {
        super(outputStream);
        if (outputStream == null) {
            throw new NullPointerException("out == null");
        }
    }

    public PrintStream(OutputStream outputStream, boolean z) {
        super(outputStream);
        if (outputStream == null) {
            throw new NullPointerException("out == null");
        }
        this.autoFlush = z;
    }

    public PrintStream(OutputStream outputStream, boolean z, String str) throws UnsupportedEncodingException {
        super(outputStream);
        if (outputStream == null) {
            throw new NullPointerException("out == null");
        }
        if (str == null) {
            throw new NullPointerException("charsetName == null");
        }
        this.autoFlush = z;
        try {
            if (!Charset.isSupported(str)) {
                throw new UnsupportedEncodingException(str);
            }
            this.encoding = str;
        } catch (IllegalCharsetNameException e) {
            throw new UnsupportedEncodingException(str);
        }
    }

    public PrintStream(String str) throws FileNotFoundException {
        this(new File(str));
    }

    public PrintStream(String str, String str2) throws FileNotFoundException, UnsupportedEncodingException {
        this(new File(str), str2);
    }

    private void newline() {
        print(System.lineSeparator());
    }

    @Override // java.lang.Appendable
    public PrintStream append(char c) {
        print(c);
        return this;
    }

    @Override // java.lang.Appendable
    public PrintStream append(CharSequence charSequence) {
        if (charSequence == null) {
            print("null");
            return this;
        }
        print(charSequence.toString());
        return this;
    }

    @Override // java.lang.Appendable
    public PrintStream append(CharSequence charSequence, int i, int i2) {
        CharSequence charSequence2 = charSequence;
        if (charSequence == null) {
            charSequence2 = "null";
        }
        print(charSequence2.subSequence(i, i2).toString());
        return this;
    }

    public boolean checkError() {
        OutputStream outputStream = this.out;
        if (outputStream == null) {
            return this.ioError;
        }
        flush();
        return this.ioError || outputStream.checkError();
    }

    protected void clearError() {
        this.ioError = false;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            flush();
            if (this.out != null) {
                try {
                    this.out.close();
                    this.out = null;
                } catch (IOException e) {
                    setError();
                }
            }
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() {
        synchronized (this) {
            if (this.out != null) {
                try {
                    this.out.flush();
                } catch (IOException e) {
                }
            }
            setError();
        }
    }

    public PrintStream format(String str, Object... objArr) {
        return format(Locale.getDefault(), str, objArr);
    }

    public PrintStream format(Locale locale, String str, Object... objArr) {
        if (str == null) {
            throw new NullPointerException("format == null");
        }
        new Formatter(this, locale).format(str, objArr);
        return this;
    }

    public void print(char c) {
        print(String.valueOf(c));
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
        synchronized (this) {
            if (this.out == null) {
                setError();
            } else if (str == null) {
                print("null");
            } else {
                try {
                    if (this.encoding == null) {
                        write(str.getBytes());
                    } else {
                        write(str.getBytes(this.encoding));
                    }
                } catch (IOException e) {
                    setError();
                }
            }
        }
    }

    public void print(boolean z) {
        print(String.valueOf(z));
    }

    public void print(char[] cArr) {
        print(new String(cArr, 0, cArr.length));
    }

    public PrintStream printf(String str, Object... objArr) {
        return format(str, objArr);
    }

    public PrintStream printf(Locale locale, String str, Object... objArr) {
        return format(locale, str, objArr);
    }

    public void println() {
        newline();
    }

    public void println(char c) {
        println(String.valueOf(c));
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
        synchronized (this) {
            print(str);
            newline();
        }
    }

    public void println(boolean z) {
        println(String.valueOf(z));
    }

    public void println(char[] cArr) {
        println(new String(cArr, 0, cArr.length));
    }

    protected void setError() {
        this.ioError = true;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) {
        synchronized (this) {
            if (this.out == null) {
                setError();
            } else {
                try {
                    this.out.write(i);
                    int i2 = i & 255;
                    boolean z = i2 == 10 || i2 == 21;
                    if (this.autoFlush && z) {
                        flush();
                    }
                } catch (IOException e) {
                    setError();
                }
            }
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        synchronized (this) {
            if (this.out == null) {
                setError();
                return;
            }
            try {
                this.out.write(bArr, i, i2);
                if (this.autoFlush) {
                    flush();
                }
            } catch (IOException e) {
                setError();
            }
        }
    }
}
