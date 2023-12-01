package com.tencent.cloud.huiyansdkface.okhttp3.internal.tls;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/tls/DistinguishedNameParser.class */
final class DistinguishedNameParser {

    /* renamed from: a  reason: collision with root package name */
    private final String f36032a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private int f36033c;
    private int d;
    private int e;
    private int f;
    private char[] g;

    private int a(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 >= this.b) {
            throw new IllegalStateException("Malformed DN: " + this.f36032a);
        }
        char c2 = this.g[i];
        if (c2 >= '0' && c2 <= '9') {
            i2 = c2 - '0';
        } else if (c2 >= 'a' && c2 <= 'f') {
            i2 = c2 - 'W';
        } else if (c2 < 'A' || c2 > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.f36032a);
        } else {
            i2 = c2 - '7';
        }
        char c3 = this.g[i4];
        if (c3 >= '0' && c3 <= '9') {
            i3 = c3 - '0';
        } else if (c3 >= 'a' && c3 <= 'f') {
            i3 = c3 - 'W';
        } else if (c3 < 'A' || c3 > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.f36032a);
        } else {
            i3 = c3 - '7';
        }
        return (i2 << 4) + i3;
    }

    private String a() {
        char[] cArr;
        while (true) {
            int i = this.f36033c;
            if (i >= this.b || this.g[i] != ' ') {
                break;
            }
            this.f36033c = i + 1;
        }
        int i2 = this.f36033c;
        if (i2 == this.b) {
            return null;
        }
        this.d = i2;
        do {
            this.f36033c = i2 + 1;
            i2 = this.f36033c;
            if (i2 >= this.b) {
                break;
            }
            cArr = this.g;
            if (cArr[i2] == '=') {
                break;
            }
        } while (cArr[i2] != ' ');
        int i3 = this.f36033c;
        if (i3 >= this.b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f36032a);
        }
        this.e = i3;
        if (this.g[i3] == ' ') {
            while (true) {
                int i4 = this.f36033c;
                if (i4 >= this.b) {
                    break;
                }
                char[] cArr2 = this.g;
                if (cArr2[i4] == '=' || cArr2[i4] != ' ') {
                    break;
                }
                this.f36033c = i4 + 1;
            }
            char[] cArr3 = this.g;
            int i5 = this.f36033c;
            if (cArr3[i5] != '=' || i5 == this.b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f36032a);
            }
        }
        int i6 = this.f36033c;
        do {
            this.f36033c = i6 + 1;
            i6 = this.f36033c;
            if (i6 >= this.b) {
                break;
            }
        } while (this.g[i6] == ' ');
        int i7 = this.e;
        int i8 = this.d;
        if (i7 - i8 > 4) {
            char[] cArr4 = this.g;
            if (cArr4[i8 + 3] == '.' && (cArr4[i8] == 'O' || cArr4[i8] == 'o')) {
                char[] cArr5 = this.g;
                int i9 = this.d;
                if (cArr5[i9 + 1] == 'I' || cArr5[i9 + 1] == 'i') {
                    char[] cArr6 = this.g;
                    int i10 = this.d;
                    if (cArr6[i10 + 2] == 'D' || cArr6[i10 + 2] == 'd') {
                        this.d += 4;
                    }
                }
            }
        }
        char[] cArr7 = this.g;
        int i11 = this.d;
        return new String(cArr7, i11, this.e - i11);
    }

    private String b() {
        int i = this.f36033c + 1;
        this.f36033c = i;
        this.d = i;
        while (true) {
            this.e = i;
            int i2 = this.f36033c;
            if (i2 == this.b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f36032a);
            }
            char[] cArr = this.g;
            if (cArr[i2] == '\"') {
                do {
                    this.f36033c = i2 + 1;
                    i2 = this.f36033c;
                    if (i2 >= this.b) {
                        break;
                    }
                } while (this.g[i2] == ' ');
                char[] cArr2 = this.g;
                int i3 = this.d;
                return new String(cArr2, i3, this.e - i3);
            }
            if (cArr[i2] == '\\') {
                cArr[this.e] = e();
            } else {
                cArr[this.e] = cArr[i2];
            }
            this.f36033c++;
            i = this.e + 1;
        }
    }

    private String c() {
        int i = this.f36033c;
        if (i + 4 >= this.b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f36032a);
        }
        this.d = i;
        while (true) {
            this.f36033c = i + 1;
            int i2 = this.f36033c;
            if (i2 == this.b) {
                break;
            }
            char[] cArr = this.g;
            if (cArr[i2] == '+' || cArr[i2] == ',' || cArr[i2] == ';') {
                break;
            } else if (cArr[i2] == ' ') {
                this.e = i2;
                do {
                    this.f36033c = i2 + 1;
                    i2 = this.f36033c;
                    if (i2 >= this.b) {
                        break;
                    }
                } while (this.g[i2] == ' ');
            } else {
                if (cArr[i2] >= 'A' && cArr[i2] <= 'F') {
                    cArr[i2] = (char) (cArr[i2] + ' ');
                }
                i = this.f36033c;
            }
        }
        this.e = this.f36033c;
        int i3 = this.e;
        int i4 = this.d;
        int i5 = i3 - i4;
        if (i5 < 5 || (i5 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f36032a);
        }
        int i6 = i5 / 2;
        byte[] bArr = new byte[i6];
        int i7 = i4 + 1;
        for (int i8 = 0; i8 < i6; i8++) {
            bArr[i8] = (byte) a(i7);
            i7 += 2;
        }
        return new String(this.g, this.d, i5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0094, code lost:
        r0 = r7.g;
        r0 = r7.d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00ad, code lost:
        return new java.lang.String(r0, r0, r7.e - r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String d() {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.internal.tls.DistinguishedNameParser.d():java.lang.String");
    }

    private char e() {
        int i = this.f36033c + 1;
        this.f36033c = i;
        if (i == this.b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f36032a);
        }
        char c2 = this.g[i];
        if (c2 != ' ' && c2 != '%' && c2 != '\\' && c2 != '_' && c2 != '\"' && c2 != '#') {
            switch (c2) {
                case '*':
                case '+':
                case ',':
                    break;
                default:
                    switch (c2) {
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                            break;
                        default:
                            return f();
                    }
            }
        }
        return this.g[this.f36033c];
    }

    private char f() {
        int i;
        int i2;
        int a2 = a(this.f36033c);
        this.f36033c++;
        if (a2 < 128) {
            return (char) a2;
        }
        if (a2 < 192 || a2 > 247) {
            return '?';
        }
        if (a2 <= 223) {
            i2 = a2 & 31;
            i = 1;
        } else if (a2 <= 239) {
            i = 2;
            i2 = a2 & 15;
        } else {
            i = 3;
            i2 = a2 & 7;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                return (char) i2;
            }
            int i5 = this.f36033c + 1;
            this.f36033c = i5;
            if (i5 == this.b || this.g[i5] != '\\') {
                return '?';
            }
            int i6 = i5 + 1;
            this.f36033c = i6;
            int a3 = a(i6);
            this.f36033c++;
            if ((a3 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (a3 & 63);
            i3 = i4 + 1;
        }
    }

    public String findMostSpecific(String str) {
        this.f36033c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = this.f36032a.toCharArray();
        String a2 = a();
        String str2 = a2;
        if (a2 == null) {
            return null;
        }
        do {
            int i = this.f36033c;
            if (i == this.b) {
                return null;
            }
            char c2 = this.g[i];
            String d = c2 != '\"' ? c2 != '#' ? (c2 == '+' || c2 == ',' || c2 == ';') ? "" : d() : c() : b();
            if (str.equalsIgnoreCase(str2)) {
                return d;
            }
            int i2 = this.f36033c;
            if (i2 >= this.b) {
                return null;
            }
            char[] cArr = this.g;
            if (cArr[i2] != ',' && cArr[i2] != ';' && cArr[i2] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f36032a);
            }
            this.f36033c++;
            str2 = a();
        } while (str2 != null);
        throw new IllegalStateException("Malformed DN: " + this.f36032a);
    }
}
