package com.android.internal.os;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Formatter;
import java.util.Locale;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/LoggingPrintStream.class */
abstract class LoggingPrintStream extends PrintStream {
    private final StringBuilder builder;
    private CharBuffer decodedChars;
    private CharsetDecoder decoder;
    private ByteBuffer encodedBytes;
    private final Formatter formatter;

    /* JADX INFO: Access modifiers changed from: protected */
    public LoggingPrintStream() {
        super(new OutputStream() { // from class: com.android.internal.os.LoggingPrintStream.1
            @Override // java.io.OutputStream
            public void write(int i) throws IOException {
                throw new AssertionError();
            }
        });
        this.builder = new StringBuilder();
        this.formatter = new Formatter(this.builder, (Locale) null);
    }

    private void flush(boolean z) {
        int i;
        int indexOf;
        int length = this.builder.length();
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= length || (indexOf = this.builder.indexOf("\n", i)) == -1) {
                break;
            }
            log(this.builder.substring(i, indexOf));
            i2 = indexOf + 1;
        }
        if (!z) {
            this.builder.delete(0, i);
            return;
        }
        if (i < length) {
            log(this.builder.substring(i));
        }
        this.builder.setLength(0);
    }

    @Override // java.io.PrintStream, java.lang.Appendable
    public PrintStream append(char c2) {
        synchronized (this) {
            print(c2);
        }
        return this;
    }

    @Override // java.io.PrintStream, java.lang.Appendable
    public PrintStream append(CharSequence charSequence) {
        synchronized (this) {
            this.builder.append(charSequence);
            flush(false);
        }
        return this;
    }

    @Override // java.io.PrintStream, java.lang.Appendable
    public PrintStream append(CharSequence charSequence, int i, int i2) {
        synchronized (this) {
            this.builder.append(charSequence, i, i2);
            flush(false);
        }
        return this;
    }

    @Override // java.io.PrintStream
    public boolean checkError() {
        return false;
    }

    @Override // java.io.PrintStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.PrintStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() {
        synchronized (this) {
            flush(true);
        }
    }

    @Override // java.io.PrintStream
    public PrintStream format(String str, Object... objArr) {
        return format(Locale.getDefault(), str, objArr);
    }

    @Override // java.io.PrintStream
    public PrintStream format(Locale locale, String str, Object... objArr) {
        synchronized (this) {
            if (str == null) {
                throw new NullPointerException("format");
            }
            this.formatter.format(locale, str, objArr);
            flush(false);
        }
        return this;
    }

    protected abstract void log(String str);

    @Override // java.io.PrintStream
    public void print(char c2) {
        synchronized (this) {
            this.builder.append(c2);
            if (c2 == '\n') {
                flush(false);
            }
        }
    }

    @Override // java.io.PrintStream
    public void print(double d) {
        synchronized (this) {
            this.builder.append(d);
        }
    }

    @Override // java.io.PrintStream
    public void print(float f) {
        synchronized (this) {
            this.builder.append(f);
        }
    }

    @Override // java.io.PrintStream
    public void print(int i) {
        synchronized (this) {
            this.builder.append(i);
        }
    }

    @Override // java.io.PrintStream
    public void print(long j) {
        synchronized (this) {
            this.builder.append(j);
        }
    }

    @Override // java.io.PrintStream
    public void print(Object obj) {
        synchronized (this) {
            this.builder.append(obj);
            flush(false);
        }
    }

    @Override // java.io.PrintStream
    public void print(String str) {
        synchronized (this) {
            this.builder.append(str);
            flush(false);
        }
    }

    @Override // java.io.PrintStream
    public void print(boolean z) {
        synchronized (this) {
            this.builder.append(z);
        }
    }

    @Override // java.io.PrintStream
    public void print(char[] cArr) {
        synchronized (this) {
            this.builder.append(cArr);
            flush(false);
        }
    }

    @Override // java.io.PrintStream
    public PrintStream printf(String str, Object... objArr) {
        return format(str, objArr);
    }

    @Override // java.io.PrintStream
    public PrintStream printf(Locale locale, String str, Object... objArr) {
        return format(locale, str, objArr);
    }

    @Override // java.io.PrintStream
    public void println() {
        synchronized (this) {
            flush(true);
        }
    }

    @Override // java.io.PrintStream
    public void println(char c2) {
        synchronized (this) {
            this.builder.append(c2);
            flush(true);
        }
    }

    @Override // java.io.PrintStream
    public void println(double d) {
        synchronized (this) {
            this.builder.append(d);
            flush(true);
        }
    }

    @Override // java.io.PrintStream
    public void println(float f) {
        synchronized (this) {
            this.builder.append(f);
            flush(true);
        }
    }

    @Override // java.io.PrintStream
    public void println(int i) {
        synchronized (this) {
            this.builder.append(i);
            flush(true);
        }
    }

    @Override // java.io.PrintStream
    public void println(long j) {
        synchronized (this) {
            this.builder.append(j);
            flush(true);
        }
    }

    @Override // java.io.PrintStream
    public void println(Object obj) {
        synchronized (this) {
            this.builder.append(obj);
            flush(true);
        }
    }

    @Override // java.io.PrintStream
    public void println(String str) {
        int i;
        synchronized (this) {
            if (this.builder.length() != 0 || str == null) {
                this.builder.append(str);
                flush(true);
            } else {
                int length = str.length();
                int i2 = 0;
                while (true) {
                    i = i2;
                    if (i >= length) {
                        break;
                    }
                    int indexOf = str.indexOf(10, i);
                    if (indexOf == -1) {
                        break;
                    }
                    log(str.substring(i, indexOf));
                    i2 = indexOf + 1;
                }
                if (i < length) {
                    log(str.substring(i));
                }
            }
        }
    }

    @Override // java.io.PrintStream
    public void println(boolean z) {
        synchronized (this) {
            this.builder.append(z);
            flush(true);
        }
    }

    @Override // java.io.PrintStream
    public void println(char[] cArr) {
        synchronized (this) {
            this.builder.append(cArr);
            flush(true);
        }
    }

    @Override // java.io.PrintStream
    protected void setError() {
    }

    @Override // java.io.PrintStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) {
        write(new byte[]{(byte) i}, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.PrintStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        CoderResult decode;
        synchronized (this) {
            if (this.decoder == null) {
                this.encodedBytes = ByteBuffer.allocate(80);
                this.decodedChars = CharBuffer.allocate(80);
                this.decoder = Charset.defaultCharset().newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
            }
            int i3 = i + i2;
            while (i < i3) {
                int min = Math.min(this.encodedBytes.remaining(), i3 - i);
                this.encodedBytes.put(bArr, i, min);
                i += min;
                this.encodedBytes.flip();
                do {
                    decode = this.decoder.decode(this.encodedBytes, this.decodedChars, false);
                    this.decodedChars.flip();
                    this.builder.append((CharSequence) this.decodedChars);
                    this.decodedChars.clear();
                } while (decode.isOverflow());
                this.encodedBytes.compact();
            }
            flush(false);
        }
    }
}
