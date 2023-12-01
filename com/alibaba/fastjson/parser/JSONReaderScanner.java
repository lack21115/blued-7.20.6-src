package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.ref.SoftReference;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/parser/JSONReaderScanner.class */
public final class JSONReaderScanner extends JSONLexerBase {
    public static int BUF_INIT_LEN = 8192;
    private static final ThreadLocal<SoftReference<char[]>> BUF_REF_LOCAL = new ThreadLocal<>();
    private char[] buf;
    private int bufLength;
    private Reader reader;

    public JSONReaderScanner(Reader reader) {
        this(reader, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONReaderScanner(Reader reader, int i) {
        super(i);
        this.reader = reader;
        SoftReference<char[]> softReference = BUF_REF_LOCAL.get();
        if (softReference != null) {
            this.buf = softReference.get();
            BUF_REF_LOCAL.set(null);
        }
        if (this.buf == null) {
            this.buf = new char[BUF_INIT_LEN];
        }
        try {
            this.bufLength = reader.read(this.buf);
            this.bp = -1;
            next();
            if (this.ch == 65279) {
                next();
            }
        } catch (IOException e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public JSONReaderScanner(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONReaderScanner(String str, int i) {
        this(new StringReader(str), i);
    }

    public JSONReaderScanner(char[] cArr, int i) {
        this(cArr, i, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONReaderScanner(char[] cArr, int i, int i2) {
        this(new CharArrayReader(cArr, 0, i), i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String addSymbol(int i, int i2, int i3, SymbolTable symbolTable) {
        return symbolTable.addSymbol(this.buf, i, i2, i3);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    protected final void arrayCopy(int i, char[] cArr, int i2, int i3) {
        System.arraycopy((Object) this.buf, i, (Object) cArr, i2, i3);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public byte[] bytesValue() {
        return IOUtils.decodeFast(this.buf, this.np + 1, this.sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final boolean charArrayCompare(char[] cArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= cArr.length) {
                return true;
            }
            if (charAt(this.bp + i2) != cArr[i2]) {
                return false;
            }
            i = i2 + 1;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char charAt(int i) {
        int i2 = this.bufLength;
        int i3 = i;
        if (i >= i2) {
            if (i2 == -1) {
                if (i < this.sp) {
                    return this.buf[i];
                }
                return (char) 26;
            } else if (this.bp == 0) {
                char[] cArr = this.buf;
                int length = (cArr.length * 3) / 2;
                char[] cArr2 = new char[length];
                System.arraycopy((Object) cArr, this.bp, (Object) cArr2, 0, this.bufLength);
                int i4 = this.bufLength;
                try {
                    this.bufLength += this.reader.read(cArr2, i4, length - i4);
                    this.buf = cArr2;
                    i3 = i;
                } catch (IOException e) {
                    throw new JSONException(e.getMessage(), e);
                }
            } else {
                int i5 = this.bufLength - this.bp;
                if (i5 > 0) {
                    System.arraycopy((Object) this.buf, this.bp, (Object) this.buf, 0, i5);
                }
                try {
                    int read = this.reader.read(this.buf, i5, this.buf.length - i5);
                    this.bufLength = read;
                    if (read == 0) {
                        throw new JSONException("illegal state, textLength is zero");
                    }
                    if (read == -1) {
                        return (char) 26;
                    }
                    this.bufLength = read + i5;
                    i3 = i - this.bp;
                    this.np -= this.bp;
                    this.bp = 0;
                } catch (IOException e2) {
                    throw new JSONException(e2.getMessage(), e2);
                }
            }
        }
        return this.buf[i3];
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        BUF_REF_LOCAL.set(new SoftReference<>(this.buf));
        this.buf = null;
        IOUtils.close(this.reader);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    protected final void copyTo(int i, int i2, char[] cArr) {
        System.arraycopy((Object) this.buf, i, (Object) cArr, 0, i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final int indexOf(char c, int i) {
        int i2 = i - this.bp;
        while (true) {
            int i3 = i2;
            if (c == charAt(this.bp + i3)) {
                return i3 + this.bp;
            }
            if (c == 26) {
                return -1;
            }
            i2 = i3 + 1;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean isEOF() {
        boolean z = true;
        if (this.bufLength != -1) {
            z = true;
            if (this.bp != this.buf.length) {
                if (this.ch == 26 && this.bp + 1 == this.buf.length) {
                    return true;
                }
                z = false;
            }
        }
        return z;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final char next() {
        int i = this.bp + 1;
        this.bp = i;
        int i2 = this.bufLength;
        int i3 = i;
        if (i >= i2) {
            if (i2 == -1) {
                return (char) 26;
            }
            if (this.sp > 0) {
                int i4 = this.bufLength - this.sp;
                int i5 = i4;
                if (this.ch == '\"') {
                    i5 = i4 - 1;
                }
                char[] cArr = this.buf;
                System.arraycopy((Object) cArr, i5, (Object) cArr, 0, this.sp);
            }
            this.np = -1;
            int i6 = this.sp;
            this.bp = i6;
            try {
                int i7 = this.bp;
                int length = this.buf.length - i7;
                int i8 = length;
                if (length == 0) {
                    char[] cArr2 = new char[this.buf.length * 2];
                    System.arraycopy((Object) this.buf, 0, (Object) cArr2, 0, this.buf.length);
                    this.buf = cArr2;
                    i8 = cArr2.length - i7;
                }
                int read = this.reader.read(this.buf, this.bp, i8);
                this.bufLength = read;
                if (read == 0) {
                    throw new JSONException("illegal stat, textLength is zero");
                }
                if (read == -1) {
                    this.ch = (char) 26;
                    return (char) 26;
                }
                this.bufLength = read + this.bp;
                i3 = i6;
            } catch (IOException e) {
                throw new JSONException(e.getMessage(), e);
            }
        }
        char c = this.buf[i3];
        this.ch = c;
        return c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0043, code lost:
        if (r0 == 'D') goto L17;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String numberString() {
        /*
            r6 = this;
            r0 = r6
            int r0 = r0.np
            r8 = r0
            r0 = r8
            r7 = r0
            r0 = r8
            r1 = -1
            if (r0 != r1) goto Le
            r0 = 0
            r7 = r0
        Le:
            r0 = r6
            r1 = r6
            int r1 = r1.sp
            r2 = r7
            int r1 = r1 + r2
            r2 = 1
            int r1 = r1 - r2
            char r0 = r0.charAt(r1)
            r10 = r0
            r0 = r6
            int r0 = r0.sp
            r9 = r0
            r0 = r10
            r1 = 76
            if (r0 == r1) goto L46
            r0 = r10
            r1 = 83
            if (r0 == r1) goto L46
            r0 = r10
            r1 = 66
            if (r0 == r1) goto L46
            r0 = r10
            r1 = 70
            if (r0 == r1) goto L46
            r0 = r9
            r8 = r0
            r0 = r10
            r1 = 68
            if (r0 != r1) goto L4a
        L46:
            r0 = r9
            r1 = 1
            int r0 = r0 - r1
            r8 = r0
        L4a:
            java.lang.String r0 = new java.lang.String
            r1 = r0
            r2 = r6
            char[] r2 = r2.buf
            r3 = r7
            r4 = r8
            r1.<init>(r2, r3, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONReaderScanner.numberString():java.lang.String");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String stringVal() {
        if (this.hasSpecial) {
            return new String(this.sbuf, 0, this.sp);
        }
        int i = this.np + 1;
        if (i >= 0) {
            if (i <= this.buf.length - this.sp) {
                return new String(this.buf, i, this.sp);
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String subString(int i, int i2) {
        if (i2 >= 0) {
            return new String(this.buf, i, i2);
        }
        throw new StringIndexOutOfBoundsException(i2);
    }
}
