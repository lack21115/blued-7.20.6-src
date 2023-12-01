package com.bytedance.sdk.openadsdk.api.plugin.mb;

import javax.security.auth.x500.X500Principal;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/api/plugin/mb/ox.class */
final class ox {
    private int b;
    private int h;
    private int hj;
    private char[] ko;
    private final String mb;
    private final int ox;
    private int u;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ox(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.mb = name;
        this.ox = name.length();
    }

    private String b() {
        int i = this.b;
        if (i + 4 >= this.ox) {
            throw new IllegalStateException("Unexpected end of DN: " + this.mb);
        }
        this.hj = i;
        this.b = i + 1;
        while (true) {
            int i2 = this.b;
            if (i2 == this.ox) {
                break;
            }
            char[] cArr = this.ko;
            if (cArr[i2] == '+' || cArr[i2] == ',' || cArr[i2] == ';') {
                break;
            } else if (cArr[i2] == ' ') {
                this.h = i2;
                this.b = i2 + 1;
                while (true) {
                    int i3 = this.b;
                    if (i3 >= this.ox || this.ko[i3] != ' ') {
                        break;
                    }
                    this.b = i3 + 1;
                }
            } else {
                if (cArr[i2] >= 'A' && cArr[i2] <= 'F') {
                    cArr[i2] = (char) (cArr[i2] + ' ');
                }
                this.b++;
            }
        }
        this.h = this.b;
        int i4 = this.h;
        int i5 = this.hj;
        int i6 = i4 - i5;
        if (i6 < 5 || (i6 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.mb);
        }
        int i7 = i6 / 2;
        byte[] bArr = new byte[i7];
        int i8 = i5 + 1;
        for (int i9 = 0; i9 < i7; i9++) {
            bArr[i9] = (byte) mb(i8);
            i8 += 2;
        }
        return new String(this.ko, this.hj, i6);
    }

    private char h() {
        int i = this.b + 1;
        this.b = i;
        if (i == this.ox) {
            throw new IllegalStateException("Unexpected end of DN: " + this.mb);
        }
        char c2 = this.ko[i];
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
                            return u();
                    }
            }
        }
        return this.ko[this.b];
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0099, code lost:
        r0 = r7.ko;
        r0 = r7.hj;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b2, code lost:
        return new java.lang.String(r0, r0, r7.h - r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String hj() {
        /*
            Method dump skipped, instructions count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.api.plugin.mb.ox.hj():java.lang.String");
    }

    private int mb(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 >= this.ox) {
            throw new IllegalStateException("Malformed DN: " + this.mb);
        }
        char c2 = this.ko[i];
        if (c2 >= '0' && c2 <= '9') {
            i2 = c2 - '0';
        } else if (c2 >= 'a' && c2 <= 'f') {
            i2 = c2 - 'W';
        } else if (c2 < 'A' || c2 > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.mb);
        } else {
            i2 = c2 - '7';
        }
        char c3 = this.ko[i4];
        if (c3 >= '0' && c3 <= '9') {
            i3 = c3 - '0';
        } else if (c3 >= 'a' && c3 <= 'f') {
            i3 = c3 - 'W';
        } else if (c3 < 'A' || c3 > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.mb);
        } else {
            i3 = c3 - '7';
        }
        return (i2 << 4) + i3;
    }

    private String mb() {
        while (true) {
            int i = this.b;
            if (i >= this.ox || this.ko[i] != ' ') {
                break;
            }
            this.b = i + 1;
        }
        int i2 = this.b;
        if (i2 == this.ox) {
            return null;
        }
        this.hj = i2;
        this.b = i2 + 1;
        while (true) {
            int i3 = this.b;
            if (i3 >= this.ox) {
                break;
            }
            char[] cArr = this.ko;
            if (cArr[i3] == '=' || cArr[i3] == ' ') {
                break;
            }
            this.b = i3 + 1;
        }
        int i4 = this.b;
        if (i4 >= this.ox) {
            throw new IllegalStateException("Unexpected end of DN: " + this.mb);
        }
        this.h = i4;
        if (this.ko[i4] == ' ') {
            while (true) {
                int i5 = this.b;
                if (i5 >= this.ox) {
                    break;
                }
                char[] cArr2 = this.ko;
                if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                    break;
                }
                this.b = i5 + 1;
            }
            char[] cArr3 = this.ko;
            int i6 = this.b;
            if (cArr3[i6] != '=' || i6 == this.ox) {
                throw new IllegalStateException("Unexpected end of DN: " + this.mb);
            }
        }
        this.b++;
        while (true) {
            int i7 = this.b;
            if (i7 >= this.ox || this.ko[i7] != ' ') {
                break;
            }
            this.b = i7 + 1;
        }
        int i8 = this.h;
        int i9 = this.hj;
        if (i8 - i9 > 4) {
            char[] cArr4 = this.ko;
            if (cArr4[i9 + 3] == '.' && (cArr4[i9] == 'O' || cArr4[i9] == 'o')) {
                char[] cArr5 = this.ko;
                int i10 = this.hj;
                if (cArr5[i10 + 1] == 'I' || cArr5[i10 + 1] == 'i') {
                    char[] cArr6 = this.ko;
                    int i11 = this.hj;
                    if (cArr6[i11 + 2] == 'D' || cArr6[i11 + 2] == 'd') {
                        this.hj += 4;
                    }
                }
            }
        }
        char[] cArr7 = this.ko;
        int i12 = this.hj;
        return new String(cArr7, i12, this.h - i12);
    }

    private String ox() {
        int i = this.b + 1;
        this.b = i;
        this.hj = i;
        this.h = i;
        while (true) {
            int i2 = this.b;
            if (i2 == this.ox) {
                throw new IllegalStateException("Unexpected end of DN: " + this.mb);
            }
            char[] cArr = this.ko;
            if (cArr[i2] == '\"') {
                this.b = i2 + 1;
                while (true) {
                    int i3 = this.b;
                    if (i3 >= this.ox || this.ko[i3] != ' ') {
                        break;
                    }
                    this.b = i3 + 1;
                }
                char[] cArr2 = this.ko;
                int i4 = this.hj;
                return new String(cArr2, i4, this.h - i4);
            }
            if (cArr[i2] == '\\') {
                cArr[this.h] = h();
            } else {
                cArr[this.h] = cArr[i2];
            }
            this.b++;
            this.h++;
        }
    }

    private char u() {
        int i;
        int i2;
        int mb = mb(this.b);
        this.b++;
        if (mb < 128) {
            return (char) mb;
        }
        if (mb < 192 || mb > 247) {
            return '?';
        }
        if (mb <= 223) {
            i2 = mb & 31;
            i = 1;
        } else if (mb <= 239) {
            i = 2;
            i2 = mb & 15;
        } else {
            i = 3;
            i2 = mb & 7;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                return (char) i2;
            }
            int i5 = this.b + 1;
            this.b = i5;
            if (i5 == this.ox || this.ko[i5] != '\\') {
                return '?';
            }
            int i6 = i5 + 1;
            this.b = i6;
            int mb2 = mb(i6);
            this.b++;
            if ((mb2 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (mb2 & 63);
            i3 = i4 + 1;
        }
    }

    public String mb(String str) {
        this.b = 0;
        this.hj = 0;
        this.h = 0;
        this.u = 0;
        this.ko = this.mb.toCharArray();
        String mb = mb();
        String str2 = mb;
        if (mb == null) {
            return null;
        }
        do {
            int i = this.b;
            if (i == this.ox) {
                return null;
            }
            char c2 = this.ko[i];
            String hj = c2 != '\"' ? c2 != '#' ? (c2 == '+' || c2 == ',' || c2 == ';') ? "" : hj() : b() : ox();
            if (str.equalsIgnoreCase(str2)) {
                return hj;
            }
            int i2 = this.b;
            if (i2 >= this.ox) {
                return null;
            }
            char[] cArr = this.ko;
            if (cArr[i2] != ',' && cArr[i2] != ';' && cArr[i2] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.mb);
            }
            this.b++;
            str2 = mb();
        } while (str2 != null);
        throw new IllegalStateException("Malformed DN: " + this.mb);
    }
}
