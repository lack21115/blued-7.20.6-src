package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IOUtils;
import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/parser/JSONScanner.class */
public final class JSONScanner extends JSONLexerBase {
    public final int ISO8601_LEN_0;
    public final int ISO8601_LEN_1;
    public final int ISO8601_LEN_2;
    private final int len;
    private final String text;

    public JSONScanner(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(String str, int i) {
        super(i);
        this.ISO8601_LEN_0 = 10;
        this.ISO8601_LEN_1 = 19;
        this.ISO8601_LEN_2 = 23;
        this.text = str;
        this.len = str.length();
        this.bp = -1;
        next();
        if (this.ch == 65279) {
            next();
        }
    }

    public JSONScanner(char[] cArr, int i) {
        this(cArr, i, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(char[] cArr, int i, int i2) {
        this(new String(cArr, 0, i), i2);
    }

    static boolean charArrayCompare(String str, int i, char[] cArr) {
        int length = cArr.length;
        if (length + i > str.length()) {
            return false;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return true;
            }
            if (cArr[i3] != str.charAt(i + i3)) {
                return false;
            }
            i2 = i3 + 1;
        }
    }

    static boolean checkDate(char c, char c2, char c3, char c4, char c5, char c6, int i, int i2) {
        if ((c == '1' || c == '2') && c2 >= '0' && c2 <= '9' && c3 >= '0' && c3 <= '9' && c4 >= '0' && c4 <= '9') {
            if (c5 == '0') {
                if (c6 < '1' || c6 > '9') {
                    return false;
                }
            } else if (c5 != '1') {
                return false;
            } else {
                if (c6 != '0' && c6 != '1' && c6 != '2') {
                    return false;
                }
            }
            if (i == 48) {
                return i2 >= 49 && i2 <= 57;
            } else if (i == 49 || i == 50) {
                return i2 >= 48 && i2 <= 57;
            } else if (i == 51) {
                return i2 == 48 || i2 == 49;
            } else {
                return false;
            }
        }
        return false;
    }

    private boolean checkTime(char c, char c2, char c3, char c4, char c5, char c6) {
        if (c == '0') {
            if (c2 < '0' || c2 > '9') {
                return false;
            }
        } else if (c == '1') {
            if (c2 < '0' || c2 > '9') {
                return false;
            }
        } else if (c != '2' || c2 < '0' || c2 > '4') {
            return false;
        }
        if (c3 < '0' || c3 > '5') {
            if (c3 != '6' || c4 != '0') {
                return false;
            }
        } else if (c4 < '0' || c4 > '9') {
            return false;
        }
        return (c5 < '0' || c5 > '5') ? c5 == '6' && c6 == '0' : c6 >= '0' && c6 <= '9';
    }

    private void setCalendar(char c, char c2, char c3, char c4, char c5, char c6, char c7, char c8) {
        this.calendar = Calendar.getInstance(this.timeZone, this.locale);
        int i = digits[c];
        int i2 = digits[c2];
        int i3 = digits[c3];
        int i4 = digits[c4];
        int i5 = digits[c5];
        int i6 = digits[c6];
        int i7 = digits[c7];
        int i8 = digits[c8];
        this.calendar.set(1, (i * 1000) + (i2 * 100) + (i3 * 10) + i4);
        this.calendar.set(2, ((i5 * 10) + i6) - 1);
        this.calendar.set(5, (i7 * 10) + i8);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String addSymbol(int i, int i2, int i3, SymbolTable symbolTable) {
        return symbolTable.addSymbol(this.text, i, i2, i3);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    protected final void arrayCopy(int i, char[] cArr, int i2, int i3) {
        this.text.getChars(i, i3 + i, cArr, i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public byte[] bytesValue() {
        return IOUtils.decodeFast(this.text, this.np + 1, this.sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final boolean charArrayCompare(char[] cArr) {
        return charArrayCompare(this.text, this.bp, cArr);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char charAt(int i) {
        if (i >= this.len) {
            return (char) 26;
        }
        return this.text.charAt(i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    protected final void copyTo(int i, int i2, char[] cArr) {
        this.text.getChars(i, i2 + i, cArr, 0);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final int indexOf(char c, int i) {
        return this.text.indexOf(c, i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append("pos ");
        sb.append(this.bp);
        sb.append(", json : ");
        sb.append(this.text.length() < 65536 ? this.text : this.text.substring(0, 65536));
        return sb.toString();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean isEOF() {
        boolean z = true;
        if (this.bp != this.len) {
            if (this.ch == 26 && this.bp + 1 == this.len) {
                return true;
            }
            z = false;
        }
        return z;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final char next() {
        int i = this.bp + 1;
        this.bp = i;
        char charAt = charAt(i);
        this.ch = charAt;
        return charAt;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
        if (r0 == 'D') goto L14;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String numberString() {
        /*
            r4 = this;
            r0 = r4
            r1 = r4
            int r1 = r1.np
            r2 = r4
            int r2 = r2.sp
            int r1 = r1 + r2
            r2 = 1
            int r1 = r1 - r2
            char r0 = r0.charAt(r1)
            r7 = r0
            r0 = r4
            int r0 = r0.sp
            r6 = r0
            r0 = r7
            r1 = 76
            if (r0 == r1) goto L35
            r0 = r7
            r1 = 83
            if (r0 == r1) goto L35
            r0 = r7
            r1 = 66
            if (r0 == r1) goto L35
            r0 = r7
            r1 = 70
            if (r0 == r1) goto L35
            r0 = r6
            r5 = r0
            r0 = r7
            r1 = 68
            if (r0 != r1) goto L39
        L35:
            r0 = r6
            r1 = 1
            int r0 = r0 - r1
            r5 = r0
        L39:
            r0 = r4
            r1 = r4
            int r1 = r1.np
            r2 = r5
            java.lang.String r0 = r0.subString(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.numberString():java.lang.String");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean scanFieldBoolean(char[] cArr) {
        char charAt;
        boolean z;
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = this.bp + cArr.length;
        int i = length + 1;
        char charAt2 = charAt(length);
        if (charAt2 == 't') {
            int i2 = i + 1;
            if (charAt(i) != 'r') {
                this.matchStat = -1;
                return false;
            }
            int i3 = i2 + 1;
            if (charAt(i2) != 'u') {
                this.matchStat = -1;
                return false;
            } else if (charAt(i3) != 'e') {
                this.matchStat = -1;
                return false;
            } else {
                this.bp = i3 + 1;
                charAt = charAt(this.bp);
                z = true;
            }
        } else if (charAt2 != 'f') {
            this.matchStat = -1;
            return false;
        } else {
            int i4 = i + 1;
            if (charAt(i) != 'a') {
                this.matchStat = -1;
                return false;
            }
            int i5 = i4 + 1;
            if (charAt(i4) != 'l') {
                this.matchStat = -1;
                return false;
            }
            int i6 = i5 + 1;
            if (charAt(i5) != 's') {
                this.matchStat = -1;
                return false;
            } else if (charAt(i6) != 'e') {
                this.matchStat = -1;
                return false;
            } else {
                this.bp = i6 + 1;
                charAt = charAt(this.bp);
                z = false;
            }
        }
        if (charAt == ',') {
            int i7 = this.bp + 1;
            this.bp = i7;
            this.ch = charAt(i7);
            this.matchStat = 3;
            this.token = 16;
            return z;
        } else if (charAt != '}') {
            this.matchStat = -1;
            return false;
        } else {
            int i8 = this.bp + 1;
            this.bp = i8;
            char charAt3 = charAt(i8);
            if (charAt3 == ',') {
                this.token = 16;
                int i9 = this.bp + 1;
                this.bp = i9;
                this.ch = charAt(i9);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i10 = this.bp + 1;
                this.bp = i10;
                this.ch = charAt(i10);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i11 = this.bp + 1;
                this.bp = i11;
                this.ch = charAt(i11);
            } else if (charAt3 != 26) {
                this.matchStat = -1;
                return false;
            } else {
                this.token = 20;
            }
            this.matchStat = 4;
            return z;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public int scanFieldInt(char[] cArr) {
        int i;
        char charAt;
        this.matchStat = 0;
        int i2 = this.bp;
        char c = this.ch;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = this.bp + cArr.length;
        int i3 = length + 1;
        char charAt2 = charAt(length);
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i4 = digits[charAt2];
        while (true) {
            i = i3 + 1;
            charAt = charAt(i3);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i4 = (i4 * 10) + digits[charAt];
            i3 = i;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        } else if (i4 < 0) {
            this.matchStat = -1;
            return 0;
        } else {
            if (charAt == ',' || charAt == '}') {
                this.bp = i - 1;
            }
            if (charAt == ',') {
                int i5 = this.bp + 1;
                this.bp = i5;
                this.ch = charAt(i5);
                this.matchStat = 3;
                this.token = 16;
                return i4;
            } else if (charAt == '}') {
                int i6 = this.bp + 1;
                this.bp = i6;
                char charAt3 = charAt(i6);
                if (charAt3 == ',') {
                    this.token = 16;
                    int i7 = this.bp + 1;
                    this.bp = i7;
                    this.ch = charAt(i7);
                } else if (charAt3 == ']') {
                    this.token = 15;
                    int i8 = this.bp + 1;
                    this.bp = i8;
                    this.ch = charAt(i8);
                } else if (charAt3 == '}') {
                    this.token = 13;
                    int i9 = this.bp + 1;
                    this.bp = i9;
                    this.ch = charAt(i9);
                } else if (charAt3 != 26) {
                    this.bp = i2;
                    this.ch = c;
                    this.matchStat = -1;
                    return 0;
                } else {
                    this.token = 20;
                }
                this.matchStat = 4;
                return i4;
            } else {
                return i4;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public long scanFieldLong(char[] cArr) {
        int i;
        char charAt;
        this.matchStat = 0;
        int i2 = this.bp;
        char c = this.ch;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = this.bp + cArr.length;
        int i3 = length + 1;
        char charAt2 = charAt(length);
        if (charAt2 < '0' || charAt2 > '9') {
            this.bp = i2;
            this.ch = c;
            this.matchStat = -1;
            return 0L;
        }
        long j = digits[charAt2];
        while (true) {
            i = i3 + 1;
            charAt = charAt(i3);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            j = (j * 10) + digits[charAt];
            i3 = i;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0L;
        }
        if (charAt == ',' || charAt == '}') {
            this.bp = i - 1;
        }
        if (j < 0) {
            this.bp = i2;
            this.ch = c;
            this.matchStat = -1;
            return 0L;
        } else if (charAt == ',') {
            int i4 = this.bp + 1;
            this.bp = i4;
            this.ch = charAt(i4);
            this.matchStat = 3;
            this.token = 16;
            return j;
        } else if (charAt != '}') {
            this.matchStat = -1;
            return 0L;
        } else {
            int i5 = this.bp + 1;
            this.bp = i5;
            char charAt3 = charAt(i5);
            if (charAt3 == ',') {
                this.token = 16;
                int i6 = this.bp + 1;
                this.bp = i6;
                this.ch = charAt(i6);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i7 = this.bp + 1;
                this.bp = i7;
                this.ch = charAt(i7);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i8 = this.bp + 1;
                this.bp = i8;
                this.ch = charAt(i8);
            } else if (charAt3 != 26) {
                this.bp = i2;
                this.ch = c;
                this.matchStat = -1;
                return 0L;
            } else {
                this.token = 20;
            }
            this.matchStat = 4;
            return j;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public String scanFieldString(char[] cArr) {
        boolean z;
        this.matchStat = 0;
        int i = this.bp;
        char c = this.ch;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return stringDefaultValue();
        }
        int length = this.bp + cArr.length;
        int i2 = length + 1;
        if (charAt(length) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int indexOf = this.text.indexOf(34, i2);
        if (indexOf != -1) {
            String subString = subString(i2, indexOf - i2);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                z = false;
                if (i4 >= subString.length()) {
                    break;
                } else if (subString.charAt(i4) == '\\') {
                    z = true;
                    break;
                } else {
                    i3 = i4 + 1;
                }
            }
            if (z) {
                this.matchStat = -1;
                return stringDefaultValue();
            }
            int i5 = indexOf + 1;
            char charAt = charAt(i5);
            if (charAt != ',' && charAt != '}') {
                this.matchStat = -1;
                return stringDefaultValue();
            }
            this.bp = i5;
            this.ch = charAt;
            if (charAt == ',') {
                int i6 = this.bp + 1;
                this.bp = i6;
                this.ch = charAt(i6);
                this.matchStat = 3;
                return subString;
            } else if (charAt != '}') {
                this.matchStat = -1;
                return stringDefaultValue();
            } else {
                int i7 = this.bp + 1;
                this.bp = i7;
                char charAt2 = charAt(i7);
                if (charAt2 == ',') {
                    this.token = 16;
                    int i8 = this.bp + 1;
                    this.bp = i8;
                    this.ch = charAt(i8);
                } else if (charAt2 == ']') {
                    this.token = 15;
                    int i9 = this.bp + 1;
                    this.bp = i9;
                    this.ch = charAt(i9);
                } else if (charAt2 == '}') {
                    this.token = 13;
                    int i10 = this.bp + 1;
                    this.bp = i10;
                    this.ch = charAt(i10);
                } else if (charAt2 != 26) {
                    this.bp = i;
                    this.ch = c;
                    this.matchStat = -1;
                    return stringDefaultValue();
                } else {
                    this.token = 20;
                }
                this.matchStat = 4;
                return subString;
            }
        }
        throw new JSONException("unclosed str");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a2, code lost:
        r8.add(subString(r10, (r0 - r10) - 1));
        r0 = r0 + 1;
        r0 = charAt(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00c8, code lost:
        if (r0 != ',') goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00cb, code lost:
        r10 = r0 + 1;
        r0 = charAt(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00e0, code lost:
        if (r0 != ']') goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00e3, code lost:
        r10 = r0 + 1;
        r9 = charAt(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00f4, code lost:
        if (isWhitespace(r9) == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00f7, code lost:
        r9 = charAt(r10);
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0107, code lost:
        r6.bp = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0110, code lost:
        if (r9 != ',') goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0113, code lost:
        r6.ch = charAt(r6.bp);
        r6.matchStat = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0125, code lost:
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0129, code lost:
        if (r9 != '}') goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x012c, code lost:
        r9 = charAt(r6.bp);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0139, code lost:
        if (isWhitespace(r9) == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x013c, code lost:
        r0 = r10 + 1;
        r9 = charAt(r10);
        r6.bp = r0;
        r10 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0159, code lost:
        if (r9 != ',') goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x015c, code lost:
        r6.token = 16;
        r0 = r6.bp + 1;
        r6.bp = r0;
        r6.ch = charAt(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0180, code lost:
        if (r9 != ']') goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0183, code lost:
        r6.token = 15;
        r0 = r6.bp + 1;
        r6.bp = r0;
        r6.ch = charAt(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01a7, code lost:
        if (r9 != '}') goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01aa, code lost:
        r6.token = 13;
        r0 = r6.bp + 1;
        r6.bp = r0;
        r6.ch = charAt(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01ce, code lost:
        if (r9 != 26) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01d1, code lost:
        r6.token = 20;
        r6.ch = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01dc, code lost:
        r6.matchStat = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01e2, code lost:
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01e3, code lost:
        r6.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01e9, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01ea, code lost:
        r6.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01f0, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01f1, code lost:
        r6.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01f7, code lost:
        return null;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Collection<java.lang.String> scanFieldStringArray(char[] r7, java.lang.Class<?> r8) {
        /*
            Method dump skipped, instructions count: 539
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldStringArray(char[], java.lang.Class):java.util.Collection");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public String scanFieldSymbol(char[] cArr, SymbolTable symbolTable) {
        int i = 0;
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = this.bp + cArr.length;
        int i2 = length + 1;
        if (charAt(length) != '\"') {
            this.matchStat = -1;
            return null;
        }
        int i3 = i2;
        while (true) {
            int i4 = i3;
            int i5 = i4 + 1;
            char charAt = charAt(i4);
            if (charAt == '\"') {
                this.bp = i5;
                char charAt2 = charAt(this.bp);
                this.ch = charAt2;
                String addSymbol = symbolTable.addSymbol(this.text, i2, (i5 - i2) - 1, i);
                if (charAt2 == ',') {
                    int i6 = this.bp + 1;
                    this.bp = i6;
                    this.ch = charAt(i6);
                    this.matchStat = 3;
                    return addSymbol;
                } else if (charAt2 != '}') {
                    this.matchStat = -1;
                    return null;
                } else {
                    int i7 = this.bp + 1;
                    this.bp = i7;
                    char charAt3 = charAt(i7);
                    if (charAt3 == ',') {
                        this.token = 16;
                        int i8 = this.bp + 1;
                        this.bp = i8;
                        this.ch = charAt(i8);
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        int i9 = this.bp + 1;
                        this.bp = i9;
                        this.ch = charAt(i9);
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        int i10 = this.bp + 1;
                        this.bp = i10;
                        this.ch = charAt(i10);
                    } else if (charAt3 != 26) {
                        this.matchStat = -1;
                        return null;
                    } else {
                        this.token = 20;
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
            i3 = i5;
        }
    }

    public boolean scanISO8601DateIfMatch() {
        return scanISO8601DateIfMatch(true);
    }

    public boolean scanISO8601DateIfMatch(boolean z) {
        int i;
        int i2;
        int i3;
        char charAt;
        int i4;
        char charAt2;
        int i5;
        int i6;
        int i7 = this.len - this.bp;
        if (!z && i7 > 13) {
            char charAt3 = charAt(this.bp);
            char charAt4 = charAt(this.bp + 1);
            char charAt5 = charAt(this.bp + 2);
            char charAt6 = charAt(this.bp + 3);
            char charAt7 = charAt(this.bp + 4);
            char charAt8 = charAt(this.bp + 5);
            char charAt9 = charAt((this.bp + i7) - 1);
            char charAt10 = charAt((this.bp + i7) - 2);
            if (charAt3 == '/' && charAt4 == 'D' && charAt5 == 'a' && charAt6 == 't' && charAt7 == 'e' && charAt8 == '(' && charAt9 == '/' && charAt10 == ')') {
                int i8 = -1;
                int i9 = 6;
                while (i9 < i7) {
                    char charAt11 = charAt(this.bp + i9);
                    if (charAt11 != '+') {
                        if (charAt11 < '0') {
                            break;
                        }
                        i6 = i8;
                        if (charAt11 > '9') {
                            break;
                        }
                    } else {
                        i6 = i9;
                    }
                    i9++;
                    i8 = i6;
                }
                if (i8 == -1) {
                    return false;
                }
                int i10 = this.bp + 6;
                long parseLong = Long.parseLong(subString(i10, i8 - i10));
                this.calendar = Calendar.getInstance(this.timeZone, this.locale);
                this.calendar.setTimeInMillis(parseLong);
                this.token = 5;
                return true;
            }
        }
        if (i7 == 8 || i7 == 14 || i7 == 17) {
            int i11 = 0;
            if (z) {
                return false;
            }
            char charAt12 = charAt(this.bp);
            char charAt13 = charAt(this.bp + 1);
            char charAt14 = charAt(this.bp + 2);
            char charAt15 = charAt(this.bp + 3);
            char charAt16 = charAt(this.bp + 4);
            char charAt17 = charAt(this.bp + 5);
            char charAt18 = charAt(this.bp + 6);
            char charAt19 = charAt(this.bp + 7);
            if (checkDate(charAt12, charAt13, charAt14, charAt15, charAt16, charAt17, charAt18, charAt19)) {
                setCalendar(charAt12, charAt13, charAt14, charAt15, charAt16, charAt17, charAt18, charAt19);
                if (i7 != 8) {
                    char charAt20 = charAt(this.bp + 8);
                    char charAt21 = charAt(this.bp + 9);
                    char charAt22 = charAt(this.bp + 10);
                    char charAt23 = charAt(this.bp + 11);
                    char charAt24 = charAt(this.bp + 12);
                    char charAt25 = charAt(this.bp + 13);
                    if (!checkTime(charAt20, charAt21, charAt22, charAt23, charAt24, charAt25)) {
                        return false;
                    }
                    if (i7 == 17) {
                        char charAt26 = charAt(this.bp + 14);
                        char charAt27 = charAt(this.bp + 15);
                        char charAt28 = charAt(this.bp + 16);
                        if (charAt26 < '0' || charAt26 > '9' || charAt27 < '0' || charAt27 > '9' || charAt28 < '0' || charAt28 > '9') {
                            return false;
                        }
                        i = (digits[charAt26] * 100) + (digits[charAt27] * 10) + digits[charAt28];
                    } else {
                        i = 0;
                    }
                    int i12 = digits[charAt20];
                    int i13 = digits[charAt21];
                    int i14 = digits[charAt22];
                    int i15 = digits[charAt23];
                    i2 = (digits[charAt24] * 10) + digits[charAt25];
                    i11 = (i14 * 10) + i15;
                    i3 = (i12 * 10) + i13;
                } else {
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                }
                this.calendar.set(11, i3);
                this.calendar.set(12, i11);
                this.calendar.set(13, i2);
                this.calendar.set(14, i);
                this.token = 5;
                return true;
            }
            return false;
        } else if (i7 >= this.ISO8601_LEN_0 && charAt(this.bp + 4) == '-' && charAt(this.bp + 7) == '-') {
            char charAt29 = charAt(this.bp);
            char charAt30 = charAt(this.bp + 1);
            char charAt31 = charAt(this.bp + 2);
            char charAt32 = charAt(this.bp + 3);
            char charAt33 = charAt(this.bp + 5);
            char charAt34 = charAt(this.bp + 6);
            char charAt35 = charAt(this.bp + 8);
            char charAt36 = charAt(this.bp + 9);
            if (checkDate(charAt29, charAt30, charAt31, charAt32, charAt33, charAt34, charAt35, charAt36)) {
                setCalendar(charAt29, charAt30, charAt31, charAt32, charAt33, charAt34, charAt35, charAt36);
                char charAt37 = charAt(this.bp + 10);
                if (charAt37 != 'T' && (charAt37 != ' ' || z)) {
                    if (charAt37 == '\"' || charAt37 == 26) {
                        this.calendar.set(11, 0);
                        this.calendar.set(12, 0);
                        this.calendar.set(13, 0);
                        this.calendar.set(14, 0);
                        int i16 = this.bp + 10;
                        this.bp = i16;
                        this.ch = charAt(i16);
                        this.token = 5;
                        return true;
                    } else if ((charAt37 == '+' || charAt37 == '-') && this.len == 16 && charAt(this.bp + 13) == ':' && charAt(this.bp + 14) == '0' && charAt(this.bp + 15) == '0') {
                        setTime('0', '0', '0', '0', '0', '0');
                        this.calendar.set(14, 0);
                        setTimeZone(charAt37, charAt(this.bp + 11), charAt(this.bp + 12));
                        return true;
                    } else {
                        return false;
                    }
                } else if (i7 >= this.ISO8601_LEN_1 && charAt(this.bp + 13) == ':' && charAt(this.bp + 16) == ':') {
                    char charAt38 = charAt(this.bp + 11);
                    char charAt39 = charAt(this.bp + 12);
                    char charAt40 = charAt(this.bp + 14);
                    char charAt41 = charAt(this.bp + 15);
                    char charAt42 = charAt(this.bp + 17);
                    char charAt43 = charAt(this.bp + 18);
                    if (checkTime(charAt38, charAt39, charAt40, charAt41, charAt42, charAt43)) {
                        setTime(charAt38, charAt39, charAt40, charAt41, charAt42, charAt43);
                        char charAt44 = charAt(this.bp + 19);
                        if (charAt44 != '.') {
                            this.calendar.set(14, 0);
                            int i17 = this.bp + 19;
                            this.bp = i17;
                            this.ch = charAt(i17);
                            this.token = 5;
                            if (charAt44 != 'Z' || this.calendar.getTimeZone().getRawOffset() == 0) {
                                return true;
                            }
                            String[] availableIDs = TimeZone.getAvailableIDs(0);
                            if (availableIDs.length > 0) {
                                this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                                return true;
                            }
                            return true;
                        } else if (i7 >= this.ISO8601_LEN_2 && (charAt = charAt(this.bp + 20)) >= '0' && charAt <= '9') {
                            int i18 = digits[charAt];
                            char charAt45 = charAt(this.bp + 21);
                            if (charAt45 < '0' || charAt45 > '9') {
                                i4 = 1;
                            } else {
                                i18 = (i18 * 10) + digits[charAt45];
                                i4 = 2;
                            }
                            int i19 = i18;
                            int i20 = i4;
                            if (i4 == 2) {
                                char charAt46 = charAt(this.bp + 22);
                                i19 = i18;
                                i20 = i4;
                                if (charAt46 >= '0') {
                                    i19 = i18;
                                    i20 = i4;
                                    if (charAt46 <= '9') {
                                        i19 = (i18 * 10) + digits[charAt46];
                                        i20 = 3;
                                    }
                                }
                            }
                            this.calendar.set(14, i19);
                            char charAt47 = charAt(this.bp + 20 + i20);
                            if (charAt47 == '+' || charAt47 == '-') {
                                char charAt48 = charAt(this.bp + 20 + i20 + 1);
                                if (charAt48 < '0' || charAt48 > '1' || (charAt2 = charAt(this.bp + 20 + i20 + 2)) < '0' || charAt2 > '9') {
                                    return false;
                                }
                                char charAt49 = charAt(this.bp + 20 + i20 + 3);
                                if (charAt49 == ':') {
                                    if (charAt(this.bp + 20 + i20 + 4) != '0' || charAt(this.bp + 20 + i20 + 5) != '0') {
                                        return false;
                                    }
                                    i5 = 6;
                                } else if (charAt49 != '0') {
                                    i5 = 3;
                                } else if (charAt(this.bp + 20 + i20 + 4) != '0') {
                                    return false;
                                } else {
                                    i5 = 5;
                                }
                                setTimeZone(charAt47, charAt48, charAt2);
                            } else if (charAt47 == 'Z') {
                                if (this.calendar.getTimeZone().getRawOffset() != 0) {
                                    String[] availableIDs2 = TimeZone.getAvailableIDs(0);
                                    if (availableIDs2.length > 0) {
                                        this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs2[0]));
                                    }
                                }
                                i5 = 1;
                            } else {
                                i5 = 0;
                            }
                            int i21 = i20 + 20 + i5;
                            char charAt50 = charAt(this.bp + i21);
                            if (charAt50 == 26 || charAt50 == '\"') {
                                int i22 = this.bp + i21;
                                this.bp = i22;
                                this.ch = charAt(i22);
                                this.token = 5;
                                return true;
                            }
                            return false;
                        } else {
                            return false;
                        }
                    }
                    return false;
                } else {
                    return false;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    protected void setTime(char c, char c2, char c3, char c4, char c5, char c6) {
        int i = digits[c];
        int i2 = digits[c2];
        int i3 = digits[c3];
        int i4 = digits[c4];
        int i5 = digits[c5];
        int i6 = digits[c6];
        this.calendar.set(11, (i * 10) + i2);
        this.calendar.set(12, (i3 * 10) + i4);
        this.calendar.set(13, (i5 * 10) + i6);
    }

    protected void setTimeZone(char c, char c2, char c3) {
        int i = ((digits[c2] * 10) + digits[c3]) * 3600 * 1000;
        int i2 = i;
        if (c == '-') {
            i2 = -i;
        }
        if (this.calendar.getTimeZone().getRawOffset() != i2) {
            String[] availableIDs = TimeZone.getAvailableIDs(i2);
            if (availableIDs.length > 0) {
                this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String stringVal() {
        return !this.hasSpecial ? subString(this.np + 1, this.sp) : new String(this.sbuf, 0, this.sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String subString(int i, int i2) {
        if (ASMUtils.IS_ANDROID) {
            if (i2 < this.sbuf.length) {
                this.text.getChars(i, i + i2, this.sbuf, 0);
                return new String(this.sbuf, 0, i2);
            }
            char[] cArr = new char[i2];
            this.text.getChars(i, i2 + i, cArr, 0);
            return new String(cArr);
        }
        return this.text.substring(i, i2 + i);
    }
}
