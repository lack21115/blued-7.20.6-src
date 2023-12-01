package com.huawei.secure.android.common.ssl.hostname;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.security.auth.x500.X500Principal;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/ssl/hostname/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f9513a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private int f9514c;
    private int d;
    private int e;
    private int f;
    private char[] g;

    public a(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f9513a = name;
        this.b = name.length();
    }

    private int a(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 >= this.b) {
            throw new IllegalStateException("Malformed DN: " + this.f9513a);
        }
        char c2 = this.g[i];
        if (c2 >= '0' && c2 <= '9') {
            i2 = c2 - '0';
        } else if (c2 >= 'a' && c2 <= 'f') {
            i2 = c2 - 'W';
        } else if (c2 < 'A' || c2 > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.f9513a);
        } else {
            i2 = c2 - '7';
        }
        char c3 = this.g[i4];
        if (c3 >= '0' && c3 <= '9') {
            i3 = c3 - '0';
        } else if (c3 >= 'a' && c3 <= 'f') {
            i3 = c3 - 'W';
        } else if (c3 < 'A' || c3 > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.f9513a);
        } else {
            i3 = c3 - '7';
        }
        return (i2 << 4) + i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0099, code lost:
        r0 = r7.g;
        r0 = r7.d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b2, code lost:
        return new java.lang.String(r0, r0, r7.e - r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a() {
        /*
            Method dump skipped, instructions count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.ssl.hostname.a.a():java.lang.String");
    }

    private char b() {
        int i = this.f9514c + 1;
        this.f9514c = i;
        if (i == this.b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f9513a);
        }
        char[] cArr = this.g;
        char c2 = cArr[i];
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
                            return c();
                    }
            }
        }
        return cArr[i];
    }

    private char c() {
        int i;
        int i2;
        int a2 = a(this.f9514c);
        this.f9514c++;
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
            int i5 = this.f9514c + 1;
            this.f9514c = i5;
            if (i5 == this.b || this.g[i5] != '\\') {
                return '?';
            }
            int i6 = i5 + 1;
            this.f9514c = i6;
            int a3 = a(i6);
            this.f9514c++;
            if ((a3 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (a3 & 63);
            i3 = i4 + 1;
        }
    }

    private String d() {
        int i = this.f9514c;
        if (i + 4 >= this.b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f9513a);
        }
        this.d = i;
        this.f9514c = i + 1;
        while (true) {
            int i2 = this.f9514c;
            if (i2 == this.b) {
                break;
            }
            char[] cArr = this.g;
            if (cArr[i2] == '+' || cArr[i2] == ',' || cArr[i2] == ';') {
                break;
            } else if (cArr[i2] == ' ') {
                this.e = i2;
                this.f9514c = i2 + 1;
                while (true) {
                    int i3 = this.f9514c;
                    if (i3 >= this.b || this.g[i3] != ' ') {
                        break;
                    }
                    this.f9514c = i3 + 1;
                }
            } else {
                if (cArr[i2] >= 'A' && cArr[i2] <= 'F') {
                    cArr[i2] = (char) (cArr[i2] + ' ');
                }
                this.f9514c++;
            }
        }
        this.e = this.f9514c;
        int i4 = this.e;
        int i5 = this.d;
        int i6 = i4 - i5;
        if (i6 < 5 || (i6 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f9513a);
        }
        int i7 = i6 / 2;
        byte[] bArr = new byte[i7];
        int i8 = i5 + 1;
        for (int i9 = 0; i9 < i7; i9++) {
            bArr[i9] = (byte) a(i8);
            i8 += 2;
        }
        return new String(this.g, this.d, i6);
    }

    private String e() {
        while (true) {
            int i = this.f9514c;
            if (i >= this.b || this.g[i] != ' ') {
                break;
            }
            this.f9514c = i + 1;
        }
        int i2 = this.f9514c;
        if (i2 == this.b) {
            return null;
        }
        this.d = i2;
        this.f9514c = i2 + 1;
        while (true) {
            int i3 = this.f9514c;
            if (i3 >= this.b) {
                break;
            }
            char[] cArr = this.g;
            if (cArr[i3] == '=' || cArr[i3] == ' ') {
                break;
            }
            this.f9514c = i3 + 1;
        }
        int i4 = this.f9514c;
        if (i4 >= this.b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f9513a);
        }
        this.e = i4;
        if (this.g[i4] == ' ') {
            while (true) {
                int i5 = this.f9514c;
                if (i5 >= this.b) {
                    break;
                }
                char[] cArr2 = this.g;
                if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                    break;
                }
                this.f9514c = i5 + 1;
            }
            char[] cArr3 = this.g;
            int i6 = this.f9514c;
            if (cArr3[i6] != '=' || i6 == this.b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f9513a);
            }
        }
        this.f9514c++;
        while (true) {
            int i7 = this.f9514c;
            if (i7 >= this.b || this.g[i7] != ' ') {
                break;
            }
            this.f9514c = i7 + 1;
        }
        int i8 = this.e;
        int i9 = this.d;
        if (i8 - i9 > 4) {
            char[] cArr4 = this.g;
            if (cArr4[i9 + 3] == '.' && (cArr4[i9] == 'O' || cArr4[i9] == 'o')) {
                char[] cArr5 = this.g;
                int i10 = this.d + 1;
                if (cArr5[i10] == 'I' || cArr5[i10] == 'i') {
                    char[] cArr6 = this.g;
                    int i11 = this.d + 2;
                    if (cArr6[i11] == 'D' || cArr6[i11] == 'd') {
                        this.d += 4;
                    }
                }
            }
        }
        char[] cArr7 = this.g;
        int i12 = this.d;
        return new String(cArr7, i12, this.e - i12);
    }

    private String f() {
        int i = this.f9514c + 1;
        this.f9514c = i;
        this.d = i;
        this.e = i;
        while (true) {
            int i2 = this.f9514c;
            if (i2 == this.b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f9513a);
            }
            char[] cArr = this.g;
            if (cArr[i2] == '\"') {
                this.f9514c = i2 + 1;
                while (true) {
                    int i3 = this.f9514c;
                    if (i3 >= this.b || this.g[i3] != ' ') {
                        break;
                    }
                    this.f9514c = i3 + 1;
                }
                char[] cArr2 = this.g;
                int i4 = this.d;
                return new String(cArr2, i4, this.e - i4);
            }
            if (cArr[i2] == '\\') {
                cArr[this.e] = b();
            } else {
                cArr[this.e] = cArr[i2];
            }
            this.f9514c++;
            this.e++;
        }
    }

    public String a(String str) {
        this.f9514c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = this.f9513a.toCharArray();
        String e = e();
        String str2 = e;
        if (e == null) {
            return null;
        }
        do {
            int i = this.f9514c;
            if (i == this.b) {
                return null;
            }
            char c2 = this.g[i];
            String a2 = c2 != '\"' ? c2 != '#' ? (c2 == '+' || c2 == ',' || c2 == ';') ? "" : a() : d() : f();
            if (str.equalsIgnoreCase(str2)) {
                return a2;
            }
            int i2 = this.f9514c;
            if (i2 >= this.b) {
                return null;
            }
            char[] cArr = this.g;
            if (cArr[i2] != ',' && cArr[i2] != ';' && cArr[i2] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f9513a);
            }
            this.f9514c++;
            str2 = e();
        } while (str2 != null);
        throw new IllegalStateException("Malformed DN: " + this.f9513a);
    }

    public List<String> b(String str) {
        this.f9514c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = this.f9513a.toCharArray();
        List<String> emptyList = Collections.emptyList();
        String e = e();
        List<String> list = emptyList;
        String str2 = e;
        if (e == null) {
            return emptyList;
        }
        while (true) {
            int i = this.f9514c;
            if (i >= this.b) {
                return list;
            }
            char c2 = this.g[i];
            String a2 = c2 != '\"' ? c2 != '#' ? (c2 == '+' || c2 == ',' || c2 == ';') ? "" : a() : d() : f();
            List<String> list2 = list;
            if (str.equalsIgnoreCase(str2)) {
                ArrayList arrayList = list;
                if (list.isEmpty()) {
                    arrayList = new ArrayList();
                }
                arrayList.add(a2);
                list2 = arrayList;
            }
            int i2 = this.f9514c;
            if (i2 >= this.b) {
                return list2;
            }
            char[] cArr = this.g;
            if (cArr[i2] != ',' && cArr[i2] != ';' && cArr[i2] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f9513a);
            }
            this.f9514c++;
            str2 = e();
            if (str2 == null) {
                throw new IllegalStateException("Malformed DN: " + this.f9513a);
            }
            list = list2;
        }
    }
}
