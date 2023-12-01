package com.huawei.secure.android.common.util;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/util/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f23158a;
    private Character b;

    /* renamed from: c  reason: collision with root package name */
    private Character f23159c;
    private int d = 0;
    private int e = 0;

    public a(String str) {
        this.f23158a = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
        if (r0 <= 'F') goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(java.lang.Character r3) {
        /*
            r0 = 0
            r6 = r0
            r0 = r3
            if (r0 != 0) goto L8
            r0 = 0
            return r0
        L8:
            r0 = r3
            char r0 = r0.charValue()
            r4 = r0
            r0 = r4
            r1 = 48
            if (r0 < r1) goto L19
            r0 = r4
            r1 = 57
            if (r0 <= r1) goto L35
        L19:
            r0 = r4
            r1 = 97
            if (r0 < r1) goto L25
            r0 = r4
            r1 = 102(0x66, float:1.43E-43)
            if (r0 <= r1) goto L35
        L25:
            r0 = r6
            r5 = r0
            r0 = r4
            r1 = 65
            if (r0 < r1) goto L37
            r0 = r6
            r5 = r0
            r0 = r4
            r1 = 70
            if (r0 > r1) goto L37
        L35:
            r0 = 1
            r5 = r0
        L37:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.a.b(java.lang.Character):boolean");
    }

    public static boolean c(Character ch) {
        if (ch == null) {
            return false;
        }
        char charValue = ch.charValue();
        boolean z = false;
        if (charValue >= '0') {
            z = false;
            if (charValue <= '7') {
                z = true;
            }
        }
        return z;
    }

    public void a(Character ch) {
        this.b = ch;
    }

    public boolean a() {
        if (this.b != null) {
            return true;
        }
        String str = this.f23158a;
        return (str == null || str.length() == 0 || this.d >= this.f23158a.length()) ? false : true;
    }

    public boolean a(char c2) {
        Character ch = this.b;
        if (ch == null || ch.charValue() != c2) {
            String str = this.f23158a;
            return str != null && str.length() != 0 && this.d < this.f23158a.length() && this.f23158a.charAt(this.d) == c2;
        }
        return true;
    }

    public int b() {
        return this.d;
    }

    public void c() {
        this.f23159c = this.b;
        this.e = this.d;
    }

    public Character d() {
        Character ch = this.b;
        if (ch != null) {
            this.b = null;
            return ch;
        }
        String str = this.f23158a;
        if (str == null || str.length() == 0 || this.d >= this.f23158a.length()) {
            return null;
        }
        String str2 = this.f23158a;
        int i = this.d;
        this.d = i + 1;
        return Character.valueOf(str2.charAt(i));
    }

    public Character e() {
        Character d = d();
        if (d != null && b(d)) {
            return d;
        }
        return null;
    }

    public Character f() {
        Character d = d();
        if (d != null && c(d)) {
            return d;
        }
        return null;
    }

    public Character g() {
        Character ch = this.b;
        if (ch != null) {
            return ch;
        }
        String str = this.f23158a;
        if (str == null || str.length() == 0 || this.d >= this.f23158a.length()) {
            return null;
        }
        return Character.valueOf(this.f23158a.charAt(this.d));
    }

    protected String h() {
        String substring = this.f23158a.substring(this.d);
        String str = substring;
        if (this.b != null) {
            str = this.b + substring;
        }
        return str;
    }

    public void i() {
        this.b = this.f23159c;
        this.d = this.e;
    }
}
