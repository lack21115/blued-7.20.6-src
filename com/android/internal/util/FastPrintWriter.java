package com.android.internal.util;

import android.util.Printer;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/FastPrintWriter.class */
public class FastPrintWriter extends PrintWriter {
    private final boolean mAutoFlush;
    private final int mBufferLen;
    private final ByteBuffer mBytes;
    private CharsetEncoder mCharset;
    private boolean mIoError;
    private final OutputStream mOutputStream;
    private int mPos;
    private final Printer mPrinter;
    private final String mSeparator;
    private final char[] mText;
    private final Writer mWriter;

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/FastPrintWriter$DummyWriter.class */
    private static class DummyWriter extends Writer {
        private DummyWriter() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new UnsupportedOperationException("Shouldn't be here");
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            close();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws IOException {
            close();
        }
    }

    public FastPrintWriter(Printer printer) {
        this(printer, 512);
    }

    public FastPrintWriter(Printer printer, int i) {
        super((Writer) new DummyWriter(), true);
        if (printer == null) {
            throw new NullPointerException("pr is null");
        }
        this.mBufferLen = i;
        this.mText = new char[i];
        this.mBytes = null;
        this.mOutputStream = null;
        this.mWriter = null;
        this.mPrinter = printer;
        this.mAutoFlush = true;
        this.mSeparator = System.lineSeparator();
        initDefaultEncoder();
    }

    public FastPrintWriter(OutputStream outputStream) {
        this(outputStream, false, 8192);
    }

    public FastPrintWriter(OutputStream outputStream, boolean z) {
        this(outputStream, z, 8192);
    }

    public FastPrintWriter(OutputStream outputStream, boolean z, int i) {
        super(new DummyWriter(), z);
        if (outputStream == null) {
            throw new NullPointerException("out is null");
        }
        this.mBufferLen = i;
        this.mText = new char[i];
        this.mBytes = ByteBuffer.allocate(this.mBufferLen);
        this.mOutputStream = outputStream;
        this.mWriter = null;
        this.mPrinter = null;
        this.mAutoFlush = z;
        this.mSeparator = System.lineSeparator();
        initDefaultEncoder();
    }

    public FastPrintWriter(Writer writer) {
        this(writer, false, 8192);
    }

    public FastPrintWriter(Writer writer, boolean z) {
        this(writer, z, 8192);
    }

    public FastPrintWriter(Writer writer, boolean z, int i) {
        super(new DummyWriter(), z);
        if (writer == null) {
            throw new NullPointerException("wr is null");
        }
        this.mBufferLen = i;
        this.mText = new char[i];
        this.mBytes = null;
        this.mOutputStream = null;
        this.mWriter = writer;
        this.mPrinter = null;
        this.mAutoFlush = z;
        this.mSeparator = System.lineSeparator();
        initDefaultEncoder();
    }

    private void appendLocked(char c) throws IOException {
        int i = this.mPos;
        int i2 = i;
        if (i >= this.mBufferLen - 1) {
            flushLocked();
            i2 = this.mPos;
        }
        this.mText[i2] = c;
        this.mPos = i2 + 1;
    }

    private void appendLocked(String str, int i, int i2) throws IOException {
        int i3 = this.mBufferLen;
        if (i2 > i3) {
            int i4 = i + i2;
            while (i < i4) {
                int i5 = i + i3;
                appendLocked(str, i, i5 < i4 ? i3 : i4 - i);
                i = i5;
            }
            return;
        }
        int i6 = this.mPos;
        int i7 = i6;
        if (i6 + i2 > i3) {
            flushLocked();
            i7 = this.mPos;
        }
        str.getChars(i, i + i2, this.mText, i7);
        this.mPos = i7 + i2;
    }

    private void appendLocked(char[] cArr, int i, int i2) throws IOException {
        int i3 = this.mBufferLen;
        if (i2 > i3) {
            int i4 = i + i2;
            while (i < i4) {
                int i5 = i + i3;
                appendLocked(cArr, i, i5 < i4 ? i3 : i4 - i);
                i = i5;
            }
            return;
        }
        int i6 = this.mPos;
        int i7 = i6;
        if (i6 + i2 > i3) {
            flushLocked();
            i7 = this.mPos;
        }
        System.arraycopy(cArr, i, this.mText, i7, i2);
        this.mPos = i7 + i2;
    }

    private void flushBytesLocked() throws IOException {
        int position = this.mBytes.position();
        if (position > 0) {
            this.mBytes.flip();
            this.mOutputStream.write(this.mBytes.array(), 0, position);
            this.mBytes.clear();
        }
    }

    private void flushLocked() throws IOException {
        if (this.mPos > 0) {
            if (this.mOutputStream != null) {
                CharBuffer wrap = CharBuffer.wrap(this.mText, 0, this.mPos);
                CoderResult encode = this.mCharset.encode(wrap, this.mBytes, true);
                while (true) {
                    CoderResult coderResult = encode;
                    if (!coderResult.isError()) {
                        if (!coderResult.isOverflow()) {
                            flushBytesLocked();
                            this.mOutputStream.flush();
                            break;
                        }
                        flushBytesLocked();
                        encode = this.mCharset.encode(wrap, this.mBytes, true);
                    } else {
                        throw new IOException(coderResult.toString());
                    }
                }
            } else if (this.mWriter != null) {
                this.mWriter.write(this.mText, 0, this.mPos);
                this.mWriter.flush();
            } else {
                int i = 0;
                int length = this.mSeparator.length();
                if (length >= this.mPos) {
                    length = this.mPos;
                }
                while (i < length && this.mText[(this.mPos - 1) - i] == this.mSeparator.charAt((this.mSeparator.length() - 1) - i)) {
                    i++;
                }
                if (i >= this.mPos) {
                    this.mPrinter.println("");
                } else {
                    this.mPrinter.println(new String(this.mText, 0, this.mPos - i));
                }
            }
            this.mPos = 0;
        }
    }

    private final void initDefaultEncoder() {
        this.mCharset = Charset.defaultCharset().newEncoder();
        this.mCharset.onMalformedInput(CodingErrorAction.REPLACE);
        this.mCharset.onUnmappableCharacter(CodingErrorAction.REPLACE);
    }

    private final void initEncoder(String str) throws UnsupportedEncodingException {
        try {
            this.mCharset = Charset.forName(str).newEncoder();
            this.mCharset.onMalformedInput(CodingErrorAction.REPLACE);
            this.mCharset.onUnmappableCharacter(CodingErrorAction.REPLACE);
        } catch (Exception e) {
            throw new UnsupportedEncodingException(str);
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer, java.lang.Appendable
    public PrintWriter append(CharSequence charSequence, int i, int i2) {
        CharSequence charSequence2 = charSequence;
        if (charSequence == null) {
            charSequence2 = "null";
        }
        String charSequence3 = charSequence2.subSequence(i, i2).toString();
        write(charSequence3, 0, charSequence3.length());
        return this;
    }

    @Override // java.io.PrintWriter
    public boolean checkError() {
        boolean z;
        flush();
        synchronized (this.lock) {
            z = this.mIoError;
        }
        return z;
    }

    @Override // java.io.PrintWriter
    protected void clearError() {
        synchronized (this.lock) {
            this.mIoError = false;
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            try {
                flushLocked();
                if (this.mOutputStream != null) {
                    this.mOutputStream.close();
                } else if (this.mWriter != null) {
                    this.mWriter.close();
                }
            } catch (IOException e) {
                setError();
            }
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer, java.io.Flushable
    public void flush() {
        synchronized (this.lock) {
            try {
                flushLocked();
                if (this.mOutputStream != null) {
                    this.mOutputStream.flush();
                } else if (this.mWriter != null) {
                    this.mWriter.flush();
                }
            } catch (IOException e) {
                setError();
            }
        }
    }

    @Override // java.io.PrintWriter
    public void print(char c) {
        synchronized (this.lock) {
            try {
                appendLocked(c);
            } catch (IOException e) {
            }
        }
    }

    @Override // java.io.PrintWriter
    public void print(int i) {
        if (i == 0) {
            print("0");
        } else {
            super.print(i);
        }
    }

    @Override // java.io.PrintWriter
    public void print(long j) {
        if (j == 0) {
            print("0");
        } else {
            super.print(j);
        }
    }

    @Override // java.io.PrintWriter
    public void print(String str) {
        String str2 = str;
        if (str == null) {
            str2 = String.valueOf((Object) null);
        }
        synchronized (this.lock) {
            try {
                appendLocked(str2, 0, str2.length());
            } catch (IOException e) {
                setError();
            }
        }
    }

    @Override // java.io.PrintWriter
    public void print(char[] cArr) {
        synchronized (this.lock) {
            try {
                appendLocked(cArr, 0, cArr.length);
            } catch (IOException e) {
            }
        }
    }

    @Override // java.io.PrintWriter
    public void println() {
        synchronized (this.lock) {
            try {
                appendLocked(this.mSeparator, 0, this.mSeparator.length());
                if (this.mAutoFlush) {
                    flushLocked();
                }
            } catch (IOException e) {
                setError();
            }
        }
    }

    @Override // java.io.PrintWriter
    public void println(char c) {
        print(c);
        println();
    }

    @Override // java.io.PrintWriter
    public void println(int i) {
        if (i == 0) {
            println("0");
        } else {
            super.println(i);
        }
    }

    @Override // java.io.PrintWriter
    public void println(long j) {
        if (j == 0) {
            println("0");
        } else {
            super.println(j);
        }
    }

    @Override // java.io.PrintWriter
    public void println(char[] cArr) {
        print(cArr);
        println();
    }

    @Override // java.io.PrintWriter
    protected void setError() {
        synchronized (this.lock) {
            this.mIoError = true;
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(int i) {
        synchronized (this.lock) {
            try {
                appendLocked((char) i);
            } catch (IOException e) {
            }
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(String str) {
        synchronized (this.lock) {
            try {
                appendLocked(str, 0, str.length());
            } catch (IOException e) {
            }
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(String str, int i, int i2) {
        synchronized (this.lock) {
            try {
                appendLocked(str, i, i2);
            } catch (IOException e) {
            }
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        synchronized (this.lock) {
            try {
                appendLocked(cArr, i, i2);
            } catch (IOException e) {
            }
        }
    }
}
