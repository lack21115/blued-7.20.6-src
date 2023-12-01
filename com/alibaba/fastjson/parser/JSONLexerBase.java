package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/parser/JSONLexerBase.class */
public abstract class JSONLexerBase implements JSONLexer, Closeable {
    protected static final int INT_MULTMIN_RADIX_TEN = -214748364;
    protected static final long MULTMIN_RADIX_TEN = -922337203685477580L;
    protected int bp;
    protected char ch;
    protected int eofPos;
    protected int features;
    protected boolean hasSpecial;
    protected int np;
    protected int pos;
    protected char[] sbuf;
    private final SoftReference<char[]> sbufRef;
    protected int sp;
    protected String stringDefaultValue;
    protected int token;
    private static final ThreadLocal<SoftReference<char[]>> SBUF_REF_LOCAL = new ThreadLocal<>();
    protected static final char[] typeFieldName = ("\"" + JSON.DEFAULT_TYPE_KEY + "\":\"").toCharArray();
    protected static final int[] digits = new int[103];
    protected Calendar calendar = null;
    protected TimeZone timeZone = JSON.defaultTimeZone;
    protected Locale locale = JSON.defaultLocale;
    public int matchStat = 0;

    static {
        int i = 48;
        while (true) {
            int i2 = i;
            if (i2 > 57) {
                break;
            }
            digits[i2] = i2 - 48;
            i = i2 + 1;
        }
        int i3 = 97;
        while (true) {
            int i4 = i3;
            if (i4 > 102) {
                break;
            }
            digits[i4] = (i4 - 97) + 10;
            i3 = i4 + 1;
        }
        int i5 = 65;
        while (true) {
            int i6 = i5;
            if (i6 > 70) {
                return;
            }
            digits[i6] = (i6 - 65) + 10;
            i5 = i6 + 1;
        }
    }

    public JSONLexerBase(int i) {
        this.stringDefaultValue = null;
        this.features = i;
        if ((i & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
        SoftReference<char[]> softReference = SBUF_REF_LOCAL.get();
        this.sbufRef = softReference;
        if (softReference != null) {
            this.sbuf = softReference.get();
            SBUF_REF_LOCAL.set(null);
        }
        if (this.sbuf == null) {
            this.sbuf = new char[256];
        }
    }

    public static boolean isWhitespace(char c) {
        if (c <= ' ') {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == '\f' || c == '\b';
        }
        return false;
    }

    private void scanStringSingleQuote() {
        this.np = this.bp;
        this.hasSpecial = false;
        while (true) {
            char next = next();
            if (next == '\'') {
                this.token = 4;
                next();
                return;
            } else if (next == 26) {
                if (isEOF()) {
                    throw new JSONException("unclosed single-quote string");
                }
                putChar((char) 26);
            } else if (next == '\\') {
                if (!this.hasSpecial) {
                    this.hasSpecial = true;
                    int i = this.sp;
                    char[] cArr = this.sbuf;
                    if (i > cArr.length) {
                        char[] cArr2 = new char[i * 2];
                        System.arraycopy((Object) cArr, 0, (Object) cArr2, 0, cArr.length);
                        this.sbuf = cArr2;
                    }
                    copyTo(this.np + 1, this.sp, this.sbuf);
                }
                char next2 = next();
                if (next2 == '\"') {
                    putChar('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            putChar('\\');
                        } else if (next2 == 'b') {
                            putChar('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                putChar('\n');
                            } else if (next2 == 'r') {
                                putChar('\r');
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        putChar('/');
                                        continue;
                                    case '0':
                                        putChar((char) 0);
                                        continue;
                                    case '1':
                                        putChar((char) 1);
                                        continue;
                                    case '2':
                                        putChar((char) 2);
                                        continue;
                                    case '3':
                                        putChar((char) 3);
                                        continue;
                                    case '4':
                                        putChar((char) 4);
                                        continue;
                                    case '5':
                                        putChar((char) 5);
                                        continue;
                                    case '6':
                                        putChar((char) 6);
                                        continue;
                                    case '7':
                                        putChar((char) 7);
                                        continue;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                putChar('\t');
                                                continue;
                                            case 'u':
                                                putChar((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                continue;
                                                continue;
                                            case 'v':
                                                putChar((char) 11);
                                                continue;
                                            default:
                                                this.ch = next2;
                                                throw new JSONException("unclosed single-quote string");
                                        }
                                }
                            } else {
                                putChar((char) ((digits[next()] * 16) + digits[next()]));
                            }
                        }
                    }
                    putChar('\f');
                } else {
                    putChar('\'');
                }
            } else if (this.hasSpecial) {
                int i2 = this.sp;
                char[] cArr3 = this.sbuf;
                if (i2 == cArr3.length) {
                    putChar(next);
                } else {
                    this.sp = i2 + 1;
                    cArr3[i2] = next;
                }
            } else {
                this.sp++;
            }
        }
    }

    public abstract String addSymbol(int i, int i2, int i3, SymbolTable symbolTable);

    protected abstract void arrayCopy(int i, char[] cArr, int i2, int i3);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract byte[] bytesValue();

    protected abstract boolean charArrayCompare(char[] cArr);

    public abstract char charAt(int i);

    @Override // com.alibaba.fastjson.parser.JSONLexer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.sbuf.length <= 8192) {
            SoftReference<char[]> softReference = this.sbufRef;
            SBUF_REF_LOCAL.set((softReference == null || softReference.get() != this.sbuf) ? new SoftReference<>(this.sbuf) : this.sbufRef);
        }
        this.sbuf = null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void config(Feature feature, boolean z) {
        int config = Feature.config(this.features, feature, z);
        this.features = config;
        if ((config & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
    }

    protected abstract void copyTo(int i, int i2, char[] cArr);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number decimalValue(boolean z) {
        char charAt = charAt((this.np + this.sp) - 1);
        return charAt == 'F' ? Float.valueOf(Float.parseFloat(numberString())) : charAt == 'D' ? Double.valueOf(Double.parseDouble(numberString())) : z ? decimalValue() : Double.valueOf(doubleValue());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final BigDecimal decimalValue() {
        return new BigDecimal(numberString());
    }

    public double doubleValue() {
        return Double.parseDouble(numberString());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public float floatValue() {
        return Float.parseFloat(numberString());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int getBufferPosition() {
        return this.bp;
    }

    public Calendar getCalendar() {
        return this.calendar;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final char getCurrent() {
        return this.ch;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Locale getLocale() {
        return this.locale;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public abstract int indexOf(char c, int i);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        return "";
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int intValue() {
        int i;
        boolean z;
        int i2;
        int i3 = 0;
        if (this.np == -1) {
            this.np = 0;
        }
        int i4 = this.np;
        int i5 = this.sp + i4;
        if (charAt(i4) == '-') {
            i = Integer.MIN_VALUE;
            i4++;
            z = true;
        } else {
            i = -2147483647;
            z = false;
        }
        int i6 = i4;
        int i7 = i;
        boolean z2 = z;
        if (i4 < i5) {
            int i8 = i4 + 1;
            i7 = i;
            z2 = z;
            i3 = -digits[charAt(i4)];
            i6 = i8;
        }
        while (true) {
            i2 = i6;
            if (i6 >= i5) {
                break;
            }
            int i9 = i6 + 1;
            char charAt = charAt(i6);
            if (charAt == 'L' || charAt == 'S' || charAt == 'B') {
                break;
            }
            int i10 = digits[charAt];
            if (i3 < -214748364) {
                throw new NumberFormatException(numberString());
            }
            int i11 = i3 * 10;
            if (i11 < i7 + i10) {
                throw new NumberFormatException(numberString());
            }
            z2 = z2;
            i3 = i11 - i10;
            i6 = i9;
        }
        if (z2) {
            if (i2 > this.np + 1) {
                return i3;
            }
            throw new NumberFormatException(numberString());
        }
        return -i3;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number integerValue() throws NumberFormatException {
        long j;
        long j2;
        boolean z = false;
        if (this.np == -1) {
            this.np = 0;
        }
        int i = this.np;
        int i2 = this.sp + i;
        boolean z2 = true;
        char charAt = charAt(i2 - 1);
        if (charAt == 'B') {
            i2--;
            z2 = true;
        } else if (charAt == 'L') {
            i2--;
            z2 = true;
        } else if (charAt == 'S') {
            i2--;
            z2 = true;
        }
        if (charAt(this.np) == '-') {
            j = Long.MIN_VALUE;
            i++;
            z = true;
        } else {
            j = -9223372036854775807L;
        }
        if (i < i2) {
            j2 = -digits[charAt(i)];
            i++;
        } else {
            j2 = 0;
        }
        while (i < i2) {
            int i3 = digits[charAt(i)];
            if (j2 < -922337203685477580L) {
                return new BigInteger(numberString());
            }
            long j3 = j2 * 10;
            long j4 = i3;
            if (j3 < j + j4) {
                return new BigInteger(numberString());
            }
            j2 = j3 - j4;
            i++;
        }
        if (!z) {
            long j5 = -j2;
            return (j5 > 2147483647L || z2) ? Long.valueOf(j5) : z2 ? Short.valueOf((short) j5) : z2 ? Byte.valueOf((byte) j5) : Integer.valueOf((int) j5);
        } else if (i > this.np + 1) {
            return (j2 < -2147483648L || z2) ? Long.valueOf(j2) : z2 ? Short.valueOf((short) j2) : z2 ? Byte.valueOf((byte) j2) : Integer.valueOf((int) j2);
        } else {
            throw new NumberFormatException(numberString());
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isBlankInput() {
        int i = 0;
        while (true) {
            int i2 = i;
            char charAt = charAt(i2);
            if (charAt == 26) {
                return true;
            }
            if (!isWhitespace(charAt)) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public abstract boolean isEOF();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isEnabled(Feature feature) {
        return (feature.mask & this.features) != 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isRef() {
        if (this.sp != 4) {
            return false;
        }
        boolean z = false;
        if (charAt(this.np + 1) == '$') {
            z = false;
            if (charAt(this.np + 2) == 'r') {
                z = false;
                if (charAt(this.np + 3) == 'e') {
                    z = false;
                    if (charAt(this.np + 4) == 'f') {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    protected void lexError(String str, Object... objArr) {
        this.token = 1;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final long longValue() throws NumberFormatException {
        long j;
        long j2;
        int i;
        boolean z = false;
        if (this.np == -1) {
            this.np = 0;
        }
        int i2 = this.np;
        int i3 = this.sp + i2;
        if (charAt(i2) == '-') {
            j = Long.MIN_VALUE;
            i2++;
            z = true;
        } else {
            j = -9223372036854775807L;
        }
        if (i2 < i3) {
            j2 = -digits[charAt(i2)];
            i2++;
        } else {
            j2 = 0;
        }
        while (true) {
            i = i2;
            if (i2 >= i3) {
                break;
            }
            i = i2 + 1;
            char charAt = charAt(i2);
            if (charAt == 'L' || charAt == 'S' || charAt == 'B') {
                break;
            }
            int i4 = digits[charAt];
            if (j2 < -922337203685477580L) {
                throw new NumberFormatException(numberString());
            }
            long j3 = j2 * 10;
            long j4 = i4;
            if (j3 < j + j4) {
                throw new NumberFormatException(numberString());
            }
            j2 = j3 - j4;
            i2 = i;
        }
        if (z) {
            if (i > this.np + 1) {
                return j2;
            }
            throw new NumberFormatException(numberString());
        }
        return -j2;
    }

    public final boolean matchField(char[] cArr) {
        if (charArrayCompare(cArr)) {
            int length = this.bp + cArr.length;
            this.bp = length;
            char charAt = charAt(length);
            this.ch = charAt;
            if (charAt == '{') {
                next();
                this.token = 12;
                return true;
            } else if (charAt == '[') {
                next();
                this.token = 14;
                return true;
            } else if (charAt != 'S' || charAt(this.bp + 1) != 'e' || charAt(this.bp + 2) != 't' || charAt(this.bp + 3) != '[') {
                nextToken();
                return true;
            } else {
                int i = this.bp + 3;
                this.bp = i;
                this.ch = charAt(i);
                this.token = 21;
                return true;
            }
        }
        return false;
    }

    public final int matchStat() {
        return this.matchStat;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract char next();

    public final void nextIdent() {
        while (isWhitespace(this.ch)) {
            next();
        }
        char c = this.ch;
        if (c == '_' || Character.isLetter(c)) {
            scanIdent();
        } else {
            nextToken();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken() {
        this.sp = 0;
        while (true) {
            this.pos = this.bp;
            char c = this.ch;
            if (c == '/') {
                skipComment();
            } else if (c == '\"') {
                scanString();
                return;
            } else if (c == ',') {
                next();
                this.token = 16;
                return;
            } else if (c >= '0' && c <= '9') {
                scanNumber();
                return;
            } else {
                char c2 = this.ch;
                if (c2 == '-') {
                    scanNumber();
                    return;
                }
                if (c2 != '\f' && c2 != '\r' && c2 != ' ') {
                    if (c2 == ':') {
                        next();
                        this.token = 17;
                        return;
                    } else if (c2 == 'N') {
                        scanNULL();
                        return;
                    } else if (c2 == '[') {
                        next();
                        this.token = 14;
                        return;
                    } else if (c2 == ']') {
                        next();
                        this.token = 15;
                        return;
                    } else if (c2 == 'f') {
                        scanFalse();
                        return;
                    } else if (c2 == 'n') {
                        scanNullOrNew();
                        return;
                    } else if (c2 == '{') {
                        next();
                        this.token = 12;
                        return;
                    } else if (c2 == '}') {
                        next();
                        this.token = 13;
                        return;
                    } else if (c2 == 'S') {
                        scanSet();
                        return;
                    } else if (c2 == 'T') {
                        scanTreeSet();
                        return;
                    } else if (c2 == 't') {
                        scanTrue();
                        return;
                    } else if (c2 == 'u') {
                        scanUndefined();
                        return;
                    } else {
                        switch (c2) {
                            case '\b':
                            case '\t':
                            case '\n':
                                break;
                            default:
                                switch (c2) {
                                    case '\'':
                                        if (!isEnabled(Feature.AllowSingleQuotes)) {
                                            throw new JSONException("Feature.AllowSingleQuotes is false");
                                        }
                                        scanStringSingleQuote();
                                        return;
                                    case '(':
                                        next();
                                        this.token = 10;
                                        return;
                                    case ')':
                                        next();
                                        this.token = 11;
                                        return;
                                    default:
                                        if (isEOF()) {
                                            if (this.token == 20) {
                                                throw new JSONException("EOF error");
                                            }
                                            this.token = 20;
                                            int i = this.eofPos;
                                            this.bp = i;
                                            this.pos = i;
                                            return;
                                        }
                                        char c3 = this.ch;
                                        if (c3 > 31 && c3 != 127) {
                                            lexError("illegal.char", String.valueOf((int) c3));
                                            next();
                                            return;
                                        }
                                        next();
                                        break;
                                }
                        }
                    }
                }
                next();
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken(int i) {
        this.sp = 0;
        while (true) {
            if (i == 2) {
                char c = this.ch;
                if (c >= '0' && c <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                }
                char c2 = this.ch;
                if (c2 == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                } else if (c2 == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c2 == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            } else if (i == 4) {
                char c3 = this.ch;
                if (c3 == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                } else if (c3 >= '0' && c3 <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                } else {
                    char c4 = this.ch;
                    if (c4 == '[') {
                        this.token = 14;
                        next();
                        return;
                    } else if (c4 == '{') {
                        this.token = 12;
                        next();
                        return;
                    }
                }
            } else if (i == 12) {
                char c5 = this.ch;
                if (c5 == '{') {
                    this.token = 12;
                    next();
                    return;
                } else if (c5 == '[') {
                    this.token = 14;
                    next();
                    return;
                }
            } else if (i == 18) {
                nextIdent();
                return;
            } else {
                if (i != 20) {
                    switch (i) {
                        case 14:
                            char c6 = this.ch;
                            if (c6 == '[') {
                                this.token = 14;
                                next();
                                return;
                            } else if (c6 == '{') {
                                this.token = 12;
                                next();
                                return;
                            }
                            break;
                        case 15:
                            if (this.ch == ']') {
                                this.token = 15;
                                next();
                                return;
                            }
                            break;
                        case 16:
                            char c7 = this.ch;
                            if (c7 == ',') {
                                this.token = 16;
                                next();
                                return;
                            } else if (c7 == '}') {
                                this.token = 13;
                                next();
                                return;
                            } else if (c7 == ']') {
                                this.token = 15;
                                next();
                                return;
                            } else if (c7 == 26) {
                                this.token = 20;
                                return;
                            }
                            break;
                    }
                }
                if (this.ch == 26) {
                    this.token = 20;
                    return;
                }
            }
            char c8 = this.ch;
            if (c8 != ' ' && c8 != '\n' && c8 != '\r' && c8 != '\t' && c8 != '\f' && c8 != '\b') {
                nextToken();
                return;
            }
            next();
        }
    }

    public final void nextTokenWithChar(char c) {
        this.sp = 0;
        while (true) {
            char c2 = this.ch;
            if (c2 == c) {
                next();
                nextToken();
                return;
            } else if (c2 != ' ' && c2 != '\n' && c2 != '\r' && c2 != '\t' && c2 != '\f' && c2 != '\b') {
                throw new JSONException("not match " + c + " - " + this.ch);
            } else {
                next();
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon() {
        nextTokenWithChar(':');
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon(int i) {
        nextTokenWithChar(':');
    }

    public final void nextTokenWithComma(int i) {
        nextTokenWithChar(',');
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String numberString();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int pos() {
        return this.pos;
    }

    protected final void putChar(char c) {
        int i = this.sp;
        char[] cArr = this.sbuf;
        if (i == cArr.length) {
            char[] cArr2 = new char[cArr.length * 2];
            System.arraycopy((Object) cArr, 0, (Object) cArr2, 0, cArr.length);
            this.sbuf = cArr2;
        }
        char[] cArr3 = this.sbuf;
        int i2 = this.sp;
        this.sp = i2 + 1;
        cArr3[i2] = c;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void resetStringPosition() {
        this.sp = 0;
    }

    public boolean scanBoolean(char c) {
        boolean z = false;
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        int i = 5;
        if (charAt == 't') {
            if (charAt(this.bp + 1) != 'r' || charAt(this.bp + 1 + 1) != 'u' || charAt(this.bp + 1 + 2) != 'e') {
                this.matchStat = -1;
                return false;
            }
            charAt = charAt(this.bp + 4);
            z = true;
        } else if (charAt != 'f') {
            i = 1;
        } else if (charAt(this.bp + 1) != 'a' || charAt(this.bp + 1 + 1) != 'l' || charAt(this.bp + 1 + 2) != 's' || charAt(this.bp + 1 + 3) != 'e') {
            this.matchStat = -1;
            return false;
        } else {
            charAt = charAt(this.bp + 5);
            i = 6;
        }
        if (charAt != c) {
            this.matchStat = -1;
            return z;
        }
        this.bp += i - 1;
        next();
        this.matchStat = 3;
        return z;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Enum<?> scanEnum(Class<?> cls, SymbolTable symbolTable, char c) {
        String scanSymbolWithSeperator = scanSymbolWithSeperator(symbolTable, c);
        if (scanSymbolWithSeperator == null) {
            return null;
        }
        return Enum.valueOf(cls, scanSymbolWithSeperator);
    }

    public final void scanFalse() {
        if (this.ch != 'f') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'a') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'l') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 's') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse false");
        }
        next();
        char c = this.ch;
        if (c != ' ' && c != ',' && c != '}' && c != ']' && c != '\n' && c != '\r' && c != '\t' && c != 26 && c != '\f' && c != '\b' && c != ':') {
            throw new JSONException("scan false error");
        }
        this.token = 7;
    }

    public boolean scanFieldBoolean(char[] cArr) {
        int i;
        boolean z;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char charAt = charAt(this.bp + length);
        if (charAt == 't') {
            int i3 = i2 + 1;
            if (charAt(this.bp + i2) != 'r') {
                this.matchStat = -1;
                return false;
            }
            int i4 = i3 + 1;
            if (charAt(this.bp + i3) != 'u') {
                this.matchStat = -1;
                return false;
            }
            i = i4 + 1;
            if (charAt(this.bp + i4) != 'e') {
                this.matchStat = -1;
                return false;
            }
            z = true;
        } else if (charAt != 'f') {
            this.matchStat = -1;
            return false;
        } else {
            int i5 = i2 + 1;
            if (charAt(this.bp + i2) != 'a') {
                this.matchStat = -1;
                return false;
            }
            int i6 = i5 + 1;
            if (charAt(this.bp + i5) != 'l') {
                this.matchStat = -1;
                return false;
            }
            int i7 = i6 + 1;
            if (charAt(this.bp + i6) != 's') {
                this.matchStat = -1;
                return false;
            } else if (charAt(this.bp + i7) != 'e') {
                this.matchStat = -1;
                return false;
            } else {
                i = i7 + 1;
                z = false;
            }
        }
        int i8 = i + 1;
        char charAt2 = charAt(this.bp + i);
        if (charAt2 == ',') {
            this.bp += i8 - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return z;
        } else if (charAt2 != '}') {
            this.matchStat = -1;
            return false;
        } else {
            int i9 = i8 + 1;
            char charAt3 = charAt(this.bp + i8);
            if (charAt3 == ',') {
                this.token = 16;
                this.bp += i9 - 1;
                next();
            } else if (charAt3 == ']') {
                this.token = 15;
                this.bp += i9 - 1;
                next();
            } else if (charAt3 == '}') {
                this.token = 13;
                this.bp += i9 - 1;
                next();
            } else if (charAt3 != 26) {
                this.matchStat = -1;
                return false;
            } else {
                this.token = 20;
                this.bp += i9 - 1;
                this.ch = (char) 26;
            }
            this.matchStat = 4;
            return z;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00d8, code lost:
        if (r10 == 'E') goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final double scanFieldDouble(char r6) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldDouble(char):double");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00f4, code lost:
        if (r10 == 'E') goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0121, code lost:
        if (r0 == '-') goto L69;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x015c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x016b -> B:37:0x0127). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final double scanFieldDouble(char[] r6) {
        /*
            Method dump skipped, instructions count: 652
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldDouble(char[]):double");
    }

    public final float scanFieldFloat(char[] cArr) {
        int i;
        char charAt;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0.0f;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char charAt2 = charAt(this.bp + length);
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0.0f;
        }
        while (true) {
            i = i2 + 1;
            charAt = charAt(this.bp + i2);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i2 = i;
        }
        char c = charAt;
        int i3 = i;
        if (charAt == '.') {
            int i4 = i + 1;
            char charAt3 = charAt(this.bp + i);
            if (charAt3 >= '0' && charAt3 <= '9') {
                while (true) {
                    int i5 = i4 + 1;
                    char charAt4 = charAt(this.bp + i4);
                    c = charAt4;
                    i3 = i5;
                    if (charAt4 < '0') {
                        break;
                    }
                    c = charAt4;
                    i3 = i5;
                    if (charAt4 > '9') {
                        break;
                    }
                    i4 = i5;
                }
            } else {
                this.matchStat = -1;
                return 0.0f;
            }
        }
        int i6 = this.bp;
        int length2 = cArr.length + i6;
        float parseFloat = Float.parseFloat(subString(length2, ((i6 + i3) - length2) - 1));
        if (c == ',') {
            this.bp += i3 - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return parseFloat;
        } else if (c != '}') {
            this.matchStat = -1;
            return 0.0f;
        } else {
            int i7 = i3 + 1;
            char charAt5 = charAt(this.bp + i3);
            if (charAt5 == ',') {
                this.token = 16;
                this.bp += i7 - 1;
                next();
            } else if (charAt5 == ']') {
                this.token = 15;
                this.bp += i7 - 1;
                next();
            } else if (charAt5 == '}') {
                this.token = 13;
                this.bp += i7 - 1;
                next();
            } else if (charAt5 != 26) {
                this.matchStat = -1;
                return 0.0f;
            } else {
                this.bp += i7 - 1;
                this.token = 20;
                this.ch = (char) 26;
            }
            this.matchStat = 4;
            return parseFloat;
        }
    }

    public int scanFieldInt(char[] cArr) {
        int i;
        char charAt;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char charAt2 = charAt(this.bp + length);
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i3 = digits[charAt2];
        while (true) {
            i = i2 + 1;
            charAt = charAt(this.bp + i2);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i3 = (i3 * 10) + digits[charAt];
            i2 = i;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        } else if (i3 < 0) {
            this.matchStat = -1;
            return 0;
        } else if (charAt == ',') {
            this.bp += i - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return i3;
        } else if (charAt != '}') {
            this.matchStat = -1;
            return 0;
        } else {
            int i4 = i + 1;
            char charAt3 = charAt(this.bp + i);
            if (charAt3 == ',') {
                this.token = 16;
                this.bp += i4 - 1;
                next();
            } else if (charAt3 == ']') {
                this.token = 15;
                this.bp += i4 - 1;
                next();
            } else if (charAt3 == '}') {
                this.token = 13;
                this.bp += i4 - 1;
                next();
            } else if (charAt3 != 26) {
                this.matchStat = -1;
                return 0;
            } else {
                this.token = 20;
                this.bp += i4 - 1;
                this.ch = (char) 26;
            }
            this.matchStat = 4;
            return i3;
        }
    }

    public long scanFieldLong(char[] cArr) {
        int i;
        char charAt;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char charAt2 = charAt(this.bp + length);
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0L;
        }
        long j = digits[charAt2];
        while (true) {
            i = i2 + 1;
            charAt = charAt(this.bp + i2);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            j = (j * 10) + digits[charAt];
            i2 = i;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0L;
        } else if (j < 0) {
            this.matchStat = -1;
            return 0L;
        } else if (charAt == ',') {
            this.bp += i - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return j;
        } else if (charAt != '}') {
            this.matchStat = -1;
            return 0L;
        } else {
            int i3 = i + 1;
            char charAt3 = charAt(this.bp + i);
            if (charAt3 == ',') {
                this.token = 16;
                this.bp += i3 - 1;
                next();
            } else if (charAt3 == ']') {
                this.token = 15;
                this.bp += i3 - 1;
                next();
            } else if (charAt3 == '}') {
                this.token = 13;
                this.bp += i3 - 1;
                next();
            } else if (charAt3 != 26) {
                this.matchStat = -1;
                return 0L;
            } else {
                this.token = 20;
                this.bp += i3 - 1;
                this.ch = (char) 26;
            }
            this.matchStat = 4;
            return j;
        }
    }

    public String scanFieldString(char[] cArr) {
        boolean z;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return stringDefaultValue();
        }
        int length = cArr.length;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int indexOf = indexOf('\"', this.bp + cArr.length + 1);
        if (indexOf != -1) {
            int length2 = this.bp + cArr.length + 1;
            String subString = subString(length2, indexOf - length2);
            int length3 = this.bp + cArr.length;
            while (true) {
                int i = length3 + 1;
                z = false;
                if (i >= indexOf) {
                    break;
                } else if (charAt(i) == '\\') {
                    z = true;
                    break;
                } else {
                    length3 = i;
                }
            }
            if (z) {
                this.matchStat = -1;
                return stringDefaultValue();
            }
            int i2 = this.bp;
            int length4 = length + 1 + (indexOf - ((cArr.length + i2) + 1)) + 1;
            int i3 = length4 + 1;
            char charAt = charAt(i2 + length4);
            if (charAt == ',') {
                this.bp += i3 - 1;
                next();
                this.matchStat = 3;
                return subString;
            } else if (charAt != '}') {
                this.matchStat = -1;
                return stringDefaultValue();
            } else {
                int i4 = i3 + 1;
                char charAt2 = charAt(this.bp + i3);
                if (charAt2 == ',') {
                    this.token = 16;
                    this.bp += i4 - 1;
                    next();
                } else if (charAt2 == ']') {
                    this.token = 15;
                    this.bp += i4 - 1;
                    next();
                } else if (charAt2 == '}') {
                    this.token = 13;
                    this.bp += i4 - 1;
                    next();
                } else if (charAt2 != 26) {
                    this.matchStat = -1;
                    return stringDefaultValue();
                } else {
                    this.token = 20;
                    this.bp += i4 - 1;
                    this.ch = (char) 26;
                }
                this.matchStat = 4;
                return subString;
            }
        }
        throw new JSONException("unclosed str");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ae, code lost:
        r0 = r6.bp;
        r0 = r9 + r0;
        r8.add(subString(r0, ((r0 + r0) - r0) - 1));
        r0 = r0 + 1;
        r0 = charAt(r6.bp + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e8, code lost:
        if (r0 != ',') goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00eb, code lost:
        r10 = charAt(r6.bp + r0);
        r9 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0102, code lost:
        if (r0 != ']') goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0105, code lost:
        r0 = r0 + 1;
        r0 = charAt(r6.bp + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x011c, code lost:
        if (r0 != ',') goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x011f, code lost:
        r6.bp += r0 - 1;
        next();
        r6.matchStat = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0137, code lost:
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x013b, code lost:
        if (r0 != '}') goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x013e, code lost:
        r0 = r0 + 1;
        r0 = charAt(r6.bp + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0158, code lost:
        if (r0 != ',') goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x015b, code lost:
        r6.token = 16;
        r6.bp += r0 - 1;
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0179, code lost:
        if (r0 != ']') goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x017c, code lost:
        r6.token = 15;
        r6.bp += r0 - 1;
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x019a, code lost:
        if (r0 != '}') goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x019d, code lost:
        r6.token = 13;
        r6.bp += r0 - 1;
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x01bb, code lost:
        if (r0 != 26) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01be, code lost:
        r6.bp += r0 - 1;
        r6.token = 20;
        r6.ch = 26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01d6, code lost:
        r6.matchStat = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01dc, code lost:
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x01dd, code lost:
        r6.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01e3, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01e4, code lost:
        r6.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01ea, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01eb, code lost:
        r6.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01f1, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Collection<java.lang.String> scanFieldStringArray(char[] r7, java.lang.Class<?> r8) {
        /*
            Method dump skipped, instructions count: 533
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldStringArray(char[], java.lang.Class):java.util.Collection");
    }

    public String scanFieldSymbol(char[] cArr, SymbolTable symbolTable) {
        int i = 0;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i2 = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return null;
        }
        while (true) {
            int i3 = i2 + 1;
            char charAt = charAt(this.bp + i2);
            if (charAt == '\"') {
                int i4 = this.bp;
                int length2 = cArr.length + i4 + 1;
                String addSymbol = addSymbol(length2, ((i4 + i3) - length2) - 1, i, symbolTable);
                int i5 = i3 + 1;
                char charAt2 = charAt(this.bp + i3);
                if (charAt2 == ',') {
                    this.bp += i5 - 1;
                    next();
                    this.matchStat = 3;
                    return addSymbol;
                } else if (charAt2 != '}') {
                    this.matchStat = -1;
                    return null;
                } else {
                    int i6 = i5 + 1;
                    char charAt3 = charAt(this.bp + i5);
                    if (charAt3 == ',') {
                        this.token = 16;
                        this.bp += i6 - 1;
                        next();
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        this.bp += i6 - 1;
                        next();
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        this.bp += i6 - 1;
                        next();
                    } else if (charAt3 != 26) {
                        this.matchStat = -1;
                        return null;
                    } else {
                        this.token = 20;
                        this.bp += i6 - 1;
                        this.ch = (char) 26;
                    }
                    this.matchStat = 4;
                    return addSymbol;
                }
            }
            i = (i * 31) + charAt;
            if (charAt == '\\') {
                this.matchStat = -1;
                return null;
            }
            i2 = i3;
        }
    }

    public final float scanFloat(char c) {
        int i;
        char charAt;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp + 0);
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0.0f;
        }
        int i2 = 1;
        while (true) {
            int i3 = i2;
            i = i3 + 1;
            charAt = charAt(this.bp + i3);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i2 = i;
        }
        char c2 = charAt;
        int i4 = i;
        if (charAt == '.') {
            int i5 = i + 1;
            char charAt3 = charAt(this.bp + i);
            if (charAt3 >= '0' && charAt3 <= '9') {
                while (true) {
                    int i6 = i5 + 1;
                    char charAt4 = charAt(this.bp + i5);
                    c2 = charAt4;
                    i4 = i6;
                    if (charAt4 < '0') {
                        break;
                    }
                    c2 = charAt4;
                    i4 = i6;
                    if (charAt4 > '9') {
                        break;
                    }
                    i5 = i6;
                }
            } else {
                this.matchStat = -1;
                return 0.0f;
            }
        }
        int i7 = this.bp;
        float parseFloat = Float.parseFloat(subString(i7, ((i7 + i4) - i7) - 1));
        if (c2 != c) {
            this.matchStat = -1;
            return parseFloat;
        }
        this.bp += i4 - 1;
        next();
        this.matchStat = 3;
        this.token = 16;
        return parseFloat;
    }

    public final void scanIdent() {
        this.np = this.bp - 1;
        this.hasSpecial = false;
        do {
            this.sp++;
            next();
        } while (Character.isLetterOrDigit(this.ch));
        String stringVal = stringVal();
        if ("null".equals(stringVal)) {
            this.token = 8;
        } else if ("new".equals(stringVal)) {
            this.token = 9;
        } else if ("true".equals(stringVal)) {
            this.token = 6;
        } else if ("false".equals(stringVal)) {
            this.token = 7;
        } else if ("undefined".equals(stringVal)) {
            this.token = 23;
        } else {
            this.token = 18;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public int scanInt(char c) {
        int i;
        char charAt;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp + 0);
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i2 = digits[charAt2];
        int i3 = 1;
        while (true) {
            int i4 = i3;
            i = i4 + 1;
            charAt = charAt(this.bp + i4);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i2 = (i2 * 10) + digits[charAt];
            i3 = i;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        } else if (i2 < 0) {
            this.matchStat = -1;
            return 0;
        } else if (charAt != c) {
            this.matchStat = -1;
            return i2;
        } else {
            this.bp += i - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return i2;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char c) {
        int i;
        char charAt;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp + 0);
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0L;
        }
        long j = digits[charAt2];
        int i2 = 1;
        while (true) {
            int i3 = i2;
            i = i3 + 1;
            charAt = charAt(this.bp + i3);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            j = (j * 10) + digits[charAt];
            i2 = i;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0L;
        } else if (j < 0) {
            this.matchStat = -1;
            return 0L;
        } else if (charAt != c) {
            this.matchStat = -1;
            return j;
        } else {
            this.bp += i - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return j;
        }
    }

    public final void scanNULL() {
        if (this.ch != 'N') {
            throw new JSONException("error parse NULL");
        }
        next();
        if (this.ch != 'U') {
            throw new JSONException("error parse NULL");
        }
        next();
        if (this.ch != 'L') {
            throw new JSONException("error parse NULL");
        }
        next();
        if (this.ch != 'L') {
            throw new JSONException("error parse NULL");
        }
        next();
        char c = this.ch;
        if (c != ' ' && c != ',' && c != '}' && c != ']' && c != '\n' && c != '\r' && c != '\t' && c != 26 && c != '\f' && c != '\b') {
            throw new JSONException("scan NULL error");
        }
        this.token = 8;
    }

    public final void scanNullOrNew() {
        if (this.ch != 'n') {
            throw new JSONException("error parse null or new");
        }
        next();
        char c = this.ch;
        if (c != 'u') {
            if (c != 'e') {
                throw new JSONException("error parse new");
            }
            next();
            if (this.ch != 'w') {
                throw new JSONException("error parse new");
            }
            next();
            char c2 = this.ch;
            if (c2 != ' ' && c2 != ',' && c2 != '}' && c2 != ']' && c2 != '\n' && c2 != '\r' && c2 != '\t' && c2 != 26 && c2 != '\f' && c2 != '\b') {
                throw new JSONException("scan new error");
            }
            this.token = 9;
            return;
        }
        next();
        if (this.ch != 'l') {
            throw new JSONException("error parse null");
        }
        next();
        if (this.ch != 'l') {
            throw new JSONException("error parse null");
        }
        next();
        char c3 = this.ch;
        if (c3 != ' ' && c3 != ',' && c3 != '}' && c3 != ']' && c3 != '\n' && c3 != '\r' && c3 != '\t' && c3 != 26 && c3 != '\f' && c3 != '\b') {
            throw new JSONException("scan null error");
        }
        this.token = 8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x017b, code lost:
        if (r0 == 'F') goto L63;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void scanNumber() {
        /*
            Method dump skipped, instructions count: 415
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanNumber():void");
    }

    public final void scanSet() {
        if (this.ch != 'S') {
            throw new JSONException("error parse set");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse set");
        }
        next();
        if (this.ch != 't') {
            throw new JSONException("error parse set");
        }
        next();
        char c = this.ch;
        if (c != ' ' && c != '\n' && c != '\r' && c != '\t' && c != '\f' && c != '\b' && c != '[' && c != '(') {
            throw new JSONException("scan set error");
        }
        this.token = 21;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanString(char c) {
        boolean z;
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        if (charAt == 'n') {
            if (charAt(this.bp + 1) != 'u' || charAt(this.bp + 1 + 1) != 'l' || charAt(this.bp + 1 + 2) != 'l') {
                this.matchStat = -1;
                return null;
            } else if (charAt(this.bp + 4) != c) {
                this.matchStat = -1;
                return null;
            } else {
                this.bp += 4;
                next();
                this.matchStat = 3;
                return null;
            }
        } else if (charAt != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        } else {
            int i = this.bp + 1;
            int indexOf = indexOf('\"', i);
            if (indexOf != -1) {
                String subString = subString(this.bp + 1, indexOf - i);
                int i2 = this.bp;
                while (true) {
                    int i3 = i2 + 1;
                    z = false;
                    if (i3 >= indexOf) {
                        break;
                    } else if (charAt(i3) == '\\') {
                        z = true;
                        break;
                    } else {
                        i2 = i3;
                    }
                }
                if (z) {
                    this.matchStat = -1;
                    return stringDefaultValue();
                }
                int i4 = this.bp;
                int i5 = (indexOf - (i4 + 1)) + 1 + 1;
                if (charAt(i4 + i5) != c) {
                    this.matchStat = -1;
                    return subString;
                }
                this.bp += (i5 + 1) - 1;
                next();
                this.matchStat = 3;
                return subString;
            }
            throw new JSONException("unclosed str");
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void scanString() {
        this.np = this.bp;
        this.hasSpecial = false;
        while (true) {
            char next = next();
            if (next == '\"') {
                this.token = 4;
                this.ch = next();
                return;
            } else if (next == 26) {
                if (isEOF()) {
                    throw new JSONException("unclosed string : " + next);
                }
                putChar((char) 26);
            } else if (next == '\\') {
                if (!this.hasSpecial) {
                    this.hasSpecial = true;
                    int i = this.sp;
                    char[] cArr = this.sbuf;
                    if (i >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i <= length) {
                            i = length;
                        }
                        char[] cArr2 = new char[i];
                        char[] cArr3 = this.sbuf;
                        System.arraycopy((Object) cArr3, 0, (Object) cArr2, 0, cArr3.length);
                        this.sbuf = cArr2;
                    }
                    copyTo(this.np + 1, this.sp, this.sbuf);
                }
                char next2 = next();
                if (next2 == '\"') {
                    putChar('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            putChar('\\');
                        } else if (next2 == 'b') {
                            putChar('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                putChar('\n');
                            } else if (next2 == 'r') {
                                putChar('\r');
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        putChar('/');
                                        continue;
                                    case '0':
                                        putChar((char) 0);
                                        continue;
                                    case '1':
                                        putChar((char) 1);
                                        continue;
                                    case '2':
                                        putChar((char) 2);
                                        continue;
                                    case '3':
                                        putChar((char) 3);
                                        continue;
                                    case '4':
                                        putChar((char) 4);
                                        continue;
                                    case '5':
                                        putChar((char) 5);
                                        continue;
                                    case '6':
                                        putChar((char) 6);
                                        continue;
                                    case '7':
                                        putChar((char) 7);
                                        continue;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                putChar('\t');
                                                continue;
                                            case 'u':
                                                putChar((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                continue;
                                                continue;
                                            case 'v':
                                                putChar((char) 11);
                                                continue;
                                            default:
                                                this.ch = next2;
                                                throw new JSONException("unclosed string : " + next2);
                                        }
                                }
                            } else {
                                char next3 = next();
                                char next4 = next();
                                int[] iArr = digits;
                                putChar((char) ((iArr[next3] * 16) + iArr[next4]));
                            }
                        }
                    }
                    putChar('\f');
                } else {
                    putChar('\'');
                }
            } else if (this.hasSpecial) {
                int i2 = this.sp;
                char[] cArr4 = this.sbuf;
                if (i2 == cArr4.length) {
                    putChar(next);
                } else {
                    this.sp = i2 + 1;
                    cArr4[i2] = next;
                }
            } else {
                this.sp++;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Collection<String> scanStringArray(Class<?> cls, char c) {
        int i;
        char charAt;
        Collection<String> createCollection = TypeUtils.createCollection(cls);
        this.matchStat = 0;
        char charAt2 = charAt(this.bp + 0);
        if (charAt2 == 'n') {
            if (charAt(this.bp + 1) != 'u' || charAt(this.bp + 1 + 1) != 'l' || charAt(this.bp + 1 + 2) != 'l') {
                this.matchStat = -1;
                return null;
            } else if (charAt(this.bp + 4) != c) {
                this.matchStat = -1;
                return null;
            } else {
                this.bp += 4;
                next();
                this.matchStat = 3;
                return null;
            }
        } else if (charAt2 != '[') {
            this.matchStat = -1;
            return null;
        } else {
            char charAt3 = charAt(this.bp + 1);
            int i2 = 2;
            while (true) {
                int i3 = i2;
                if (charAt3 == 'n' && charAt(this.bp + i3) == 'u' && charAt(this.bp + i3 + 1) == 'l' && charAt(this.bp + i3 + 2) == 'l') {
                    int i4 = i3 + 3;
                    i = i4 + 1;
                    charAt = charAt(this.bp + i4);
                } else if (charAt3 != '\"') {
                    this.matchStat = -1;
                    return null;
                } else {
                    int i5 = i3;
                    while (true) {
                        int i6 = i5;
                        int i7 = i6 + 1;
                        char charAt4 = charAt(this.bp + i6);
                        if (charAt4 == '\"') {
                            int i8 = this.bp;
                            int i9 = i3 + i8;
                            createCollection.add(subString(i9, ((i8 + i7) - i9) - 1));
                            i = i7 + 1;
                            charAt = charAt(this.bp + i7);
                            break;
                        } else if (charAt4 == '\\') {
                            this.matchStat = -1;
                            return null;
                        } else {
                            i5 = i7;
                        }
                    }
                }
                if (charAt != ',') {
                    if (charAt != ']') {
                        this.matchStat = -1;
                        return null;
                    } else if (charAt(this.bp + i) != c) {
                        this.matchStat = -1;
                        return createCollection;
                    } else {
                        this.bp += (i + 1) - 1;
                        next();
                        this.matchStat = 3;
                        return createCollection;
                    }
                }
                charAt3 = charAt(this.bp + i);
                i2 = i + 1;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable symbolTable) {
        skipWhitespace();
        char c = this.ch;
        if (c == '\"') {
            return scanSymbol(symbolTable, '\"');
        }
        if (c == '\'') {
            if (isEnabled(Feature.AllowSingleQuotes)) {
                return scanSymbol(symbolTable, '\'');
            }
            throw new JSONException("syntax error");
        } else if (c == '}') {
            next();
            this.token = 13;
            return null;
        } else if (c == ',') {
            next();
            this.token = 16;
            return null;
        } else if (c == 26) {
            this.token = 20;
            return null;
        } else if (isEnabled(Feature.AllowUnQuotedFieldNames)) {
            return scanSymbolUnQuoted(symbolTable);
        } else {
            throw new JSONException("syntax error");
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable symbolTable, char c) {
        String addSymbol;
        this.np = this.bp;
        this.sp = 0;
        boolean z = false;
        int i = 0;
        while (true) {
            char next = next();
            if (next == c) {
                this.token = 4;
                if (z) {
                    addSymbol = symbolTable.addSymbol(this.sbuf, 0, this.sp, i);
                } else {
                    int i2 = this.np;
                    addSymbol = addSymbol(i2 == -1 ? 0 : i2 + 1, this.sp, i, symbolTable);
                }
                this.sp = 0;
                next();
                return addSymbol;
            } else if (next == 26) {
                throw new JSONException("unclosed.str");
            } else {
                if (next == '\\') {
                    boolean z2 = z;
                    if (!z) {
                        int i3 = this.sp;
                        char[] cArr = this.sbuf;
                        if (i3 >= cArr.length) {
                            int length = cArr.length * 2;
                            if (i3 <= length) {
                                i3 = length;
                            }
                            char[] cArr2 = new char[i3];
                            char[] cArr3 = this.sbuf;
                            System.arraycopy((Object) cArr3, 0, (Object) cArr2, 0, cArr3.length);
                            this.sbuf = cArr2;
                        }
                        arrayCopy(this.np + 1, this.sbuf, 0, this.sp);
                        z2 = true;
                    }
                    char next2 = next();
                    if (next2 == '\"') {
                        i = (i * 31) + 34;
                        putChar('\"');
                        z = z2;
                    } else if (next2 != '\'') {
                        if (next2 != 'F') {
                            if (next2 == '\\') {
                                i = (i * 31) + 92;
                                putChar('\\');
                                z = z2;
                            } else if (next2 == 'b') {
                                i = (i * 31) + 8;
                                putChar('\b');
                                z = z2;
                            } else if (next2 != 'f') {
                                if (next2 == 'n') {
                                    i = (i * 31) + 10;
                                    putChar('\n');
                                    z = z2;
                                } else if (next2 == 'r') {
                                    i = (i * 31) + 13;
                                    putChar('\r');
                                    z = z2;
                                } else if (next2 != 'x') {
                                    switch (next2) {
                                        case '/':
                                            i = (i * 31) + 47;
                                            putChar('/');
                                            z = z2;
                                            continue;
                                        case '0':
                                            i = (i * 31) + next2;
                                            putChar((char) 0);
                                            z = z2;
                                            continue;
                                        case '1':
                                            i = (i * 31) + next2;
                                            putChar((char) 1);
                                            z = z2;
                                            continue;
                                        case '2':
                                            i = (i * 31) + next2;
                                            putChar((char) 2);
                                            z = z2;
                                            continue;
                                        case '3':
                                            i = (i * 31) + next2;
                                            putChar((char) 3);
                                            z = z2;
                                            continue;
                                        case '4':
                                            i = (i * 31) + next2;
                                            putChar((char) 4);
                                            z = z2;
                                            continue;
                                        case '5':
                                            i = (i * 31) + next2;
                                            putChar((char) 5);
                                            z = z2;
                                            continue;
                                        case '6':
                                            i = (i * 31) + next2;
                                            putChar((char) 6);
                                            z = z2;
                                            continue;
                                        case '7':
                                            i = (i * 31) + next2;
                                            putChar((char) 7);
                                            z = z2;
                                            continue;
                                        default:
                                            switch (next2) {
                                                case 't':
                                                    i = (i * 31) + 9;
                                                    putChar('\t');
                                                    z = z2;
                                                    continue;
                                                case 'u':
                                                    int parseInt = Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16);
                                                    i = (i * 31) + parseInt;
                                                    putChar((char) parseInt);
                                                    z = z2;
                                                    continue;
                                                    continue;
                                                case 'v':
                                                    i = (i * 31) + 11;
                                                    putChar((char) 11);
                                                    z = z2;
                                                    continue;
                                                default:
                                                    this.ch = next2;
                                                    throw new JSONException("unclosed.str.lit");
                                            }
                                    }
                                } else {
                                    char next3 = next();
                                    this.ch = next3;
                                    char next4 = next();
                                    this.ch = next4;
                                    int[] iArr = digits;
                                    char c2 = (char) ((iArr[next3] * 16) + iArr[next4]);
                                    i = (i * 31) + c2;
                                    putChar(c2);
                                    z = z2;
                                }
                            }
                        }
                        i = (i * 31) + 12;
                        putChar('\f');
                        z = z2;
                    } else {
                        i = (i * 31) + 39;
                        putChar('\'');
                        z = z2;
                    }
                } else {
                    i = (i * 31) + next;
                    if (z) {
                        int i4 = this.sp;
                        char[] cArr4 = this.sbuf;
                        if (i4 == cArr4.length) {
                            putChar(next);
                        } else {
                            this.sp = i4 + 1;
                            cArr4[i4] = next;
                        }
                    } else {
                        this.sp++;
                    }
                }
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbolUnQuoted(SymbolTable symbolTable) {
        boolean[] zArr = IOUtils.firstIdentifierFlags;
        char c = this.ch;
        if (!(c >= zArr.length || zArr[c])) {
            throw new JSONException("illegal identifier : " + this.ch + info());
        }
        boolean[] zArr2 = IOUtils.identifierFlags;
        this.np = this.bp;
        this.sp = 1;
        char c2 = c;
        while (true) {
            char next = next();
            if (next < zArr2.length && !zArr2[next]) {
                break;
            }
            c2 = (c2 * 31) + next;
            this.sp++;
        }
        this.ch = charAt(this.bp);
        this.token = 18;
        if (this.sp == 4 && c2 == 3392903 && charAt(this.np) == 'n' && charAt(this.np + 1) == 'u' && charAt(this.np + 2) == 'l' && charAt(this.np + 3) == 'l') {
            return null;
        }
        return addSymbol(this.np, this.sp, c2, symbolTable);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanSymbolWithSeperator(SymbolTable symbolTable, char c) {
        int i = 0;
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        if (charAt == 'n') {
            if (charAt(this.bp + 1) != 'u' || charAt(this.bp + 1 + 1) != 'l' || charAt(this.bp + 1 + 2) != 'l') {
                this.matchStat = -1;
                return null;
            } else if (charAt(this.bp + 4) != c) {
                this.matchStat = -1;
                return null;
            } else {
                this.bp += 4;
                next();
                this.matchStat = 3;
                return null;
            }
        } else if (charAt != '\"') {
            this.matchStat = -1;
            return null;
        } else {
            int i2 = 1;
            while (true) {
                int i3 = i2;
                int i4 = i3 + 1;
                char charAt2 = charAt(this.bp + i3);
                if (charAt2 == '\"') {
                    int i5 = this.bp;
                    int i6 = i5 + 0 + 1;
                    String addSymbol = addSymbol(i6, ((i5 + i4) - i6) - 1, i, symbolTable);
                    if (charAt(this.bp + i4) != c) {
                        this.matchStat = -1;
                        return addSymbol;
                    }
                    this.bp += (i4 + 1) - 1;
                    next();
                    this.matchStat = 3;
                    return addSymbol;
                }
                i = (i * 31) + charAt2;
                if (charAt2 == '\\') {
                    this.matchStat = -1;
                    return null;
                }
                i2 = i4;
            }
        }
    }

    public final void scanTreeSet() {
        if (this.ch != 'T') {
            throw new JSONException("error parse treeSet");
        }
        next();
        if (this.ch != 'r') {
            throw new JSONException("error parse treeSet");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse treeSet");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse treeSet");
        }
        next();
        if (this.ch != 'S') {
            throw new JSONException("error parse treeSet");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse treeSet");
        }
        next();
        if (this.ch != 't') {
            throw new JSONException("error parse treeSet");
        }
        next();
        char c = this.ch;
        if (c != ' ' && c != '\n' && c != '\r' && c != '\t' && c != '\f' && c != '\b' && c != '[' && c != '(') {
            throw new JSONException("scan treeSet error");
        }
        this.token = 22;
    }

    public final void scanTrue() {
        if (this.ch != 't') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'r') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'u') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse true");
        }
        next();
        char c = this.ch;
        if (c != ' ' && c != ',' && c != '}' && c != ']' && c != '\n' && c != '\r' && c != '\t' && c != 26 && c != '\f' && c != '\b' && c != ':') {
            throw new JSONException("scan true error");
        }
        this.token = 6;
    }

    public final int scanType(String str) {
        this.matchStat = 0;
        if (charArrayCompare(typeFieldName)) {
            int length = this.bp + typeFieldName.length;
            int length2 = str.length();
            for (int i = 0; i < length2; i++) {
                if (str.charAt(i) != charAt(length + i)) {
                    return -1;
                }
            }
            int i2 = length + length2;
            if (charAt(i2) != '\"') {
                return -1;
            }
            int i3 = i2 + 1;
            char charAt = charAt(i3);
            this.ch = charAt;
            if (charAt == ',') {
                int i4 = i3 + 1;
                this.ch = charAt(i4);
                this.bp = i4;
                this.token = 16;
                return 3;
            }
            int i5 = i3;
            if (charAt == '}') {
                i5 = i3 + 1;
                char charAt2 = charAt(i5);
                this.ch = charAt2;
                if (charAt2 == ',') {
                    this.token = 16;
                    i5++;
                    this.ch = charAt(i5);
                } else if (charAt2 == ']') {
                    this.token = 15;
                    i5++;
                    this.ch = charAt(i5);
                } else if (charAt2 == '}') {
                    this.token = 13;
                    i5++;
                    this.ch = charAt(i5);
                } else if (charAt2 != 26) {
                    return -1;
                } else {
                    this.token = 20;
                }
                this.matchStat = 4;
            }
            this.bp = i5;
            return this.matchStat;
        }
        return -2;
    }

    public final void scanUndefined() {
        if (this.ch != 'u') {
            throw new JSONException("error parse undefined");
        }
        next();
        if (this.ch != 'n') {
            throw new JSONException("error parse undefined");
        }
        next();
        if (this.ch != 'd') {
            throw new JSONException("error parse undefined");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse undefined");
        }
        next();
        if (this.ch != 'f') {
            throw new JSONException("error parse undefined");
        }
        next();
        if (this.ch != 'i') {
            throw new JSONException("error parse undefined");
        }
        next();
        if (this.ch != 'n') {
            throw new JSONException("error parse undefined");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse undefined");
        }
        next();
        if (this.ch != 'd') {
            throw new JSONException("error parse undefined");
        }
        next();
        char c = this.ch;
        if (c != ' ' && c != ',' && c != '}' && c != ']' && c != '\n' && c != '\r' && c != '\t' && c != 26 && c != '\f' && c != '\b') {
            throw new JSONException("scan undefined error");
        }
        this.token = 23;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    protected void skipComment() {
        next();
        char c = this.ch;
        if (c == '/') {
            do {
                next();
            } while (this.ch != '\n');
            next();
        } else if (c != '*') {
            throw new JSONException("invalid comment");
        } else {
            while (true) {
                next();
                if (this.ch == '*') {
                    next();
                    if (this.ch == '/') {
                        next();
                        return;
                    }
                }
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void skipWhitespace() {
        while (true) {
            char c = this.ch;
            if (c > '/') {
                return;
            }
            if (c == ' ' || c == '\r' || c == '\n' || c == '\t' || c == '\f' || c == '\b') {
                next();
            } else if (c != '/') {
                return;
            } else {
                skipComment();
            }
        }
    }

    public final String stringDefaultValue() {
        return this.stringDefaultValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String stringVal();

    public abstract String subString(int i, int i2);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int token() {
        return this.token;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String tokenName() {
        return JSONToken.name(this.token);
    }
}
