package org.json.alipay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* loaded from: source-3503164-dex2jar.jar:org/json/alipay/c.class */
public final class c {
    private int a;
    private Reader b;
    private char c;
    private boolean d;

    private c(Reader reader) {
        this.b = reader.markSupported() ? reader : new BufferedReader(reader);
        this.d = false;
        this.a = 0;
    }

    public c(String str) {
        this(new StringReader(str));
    }

    private String a(int i) {
        if (i == 0) {
            return "";
        }
        char[] cArr = new char[i];
        int i2 = 0;
        if (this.d) {
            this.d = false;
            cArr[0] = this.c;
            i2 = 1;
        }
        while (i2 < i) {
            try {
                int read = this.b.read(cArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            } catch (IOException e) {
                throw new JSONException(e);
            }
        }
        this.a += i2;
        if (i2 >= i) {
            this.c = cArr[i - 1];
            return new String(cArr);
        }
        throw a("Substring bounds error");
    }

    public final JSONException a(String str) {
        return new JSONException(str + toString());
    }

    public final void a() {
        int i;
        if (this.d || (i = this.a) <= 0) {
            throw new JSONException("Stepping back two steps is not supported");
        }
        this.a = i - 1;
        this.d = true;
    }

    public final char b() {
        if (this.d) {
            this.d = false;
            if (this.c != 0) {
                this.a++;
            }
            return this.c;
        }
        try {
            int read = this.b.read();
            if (read <= 0) {
                this.c = (char) 0;
                return (char) 0;
            }
            this.a++;
            char c = (char) read;
            this.c = c;
            return c;
        } catch (IOException e) {
            throw new JSONException(e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x008a, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final char c() {
        /*
            r3 = this;
        L0:
            r0 = r3
            char r0 = r0.b()
            r4 = r0
            r0 = r4
            r1 = 47
            if (r0 != r1) goto L61
            r0 = r3
            char r0 = r0.b()
            r5 = r0
            r0 = r5
            r1 = 42
            if (r0 == r1) goto L3b
            r0 = r5
            r1 = 47
            if (r0 == r1) goto L23
            r0 = r3
            r0.a()
            r0 = 47
            return r0
        L23:
            r0 = r3
            char r0 = r0.b()
            r5 = r0
            r0 = r5
            r1 = 10
            if (r0 == r1) goto L0
            r0 = r5
            r1 = 13
            if (r0 == r1) goto L0
            r0 = r5
            if (r0 != 0) goto L23
            goto L0
        L3b:
            r0 = r3
            char r0 = r0.b()
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L5a
            r0 = r5
            r1 = 42
            if (r0 != r1) goto L3b
            r0 = r3
            char r0 = r0.b()
            r1 = 47
            if (r0 == r1) goto L0
            r0 = r3
            r0.a()
            goto L3b
        L5a:
            r0 = r3
            java.lang.String r1 = "Unclosed comment"
            org.json.alipay.JSONException r0 = r0.a(r1)
            throw r0
        L61:
            r0 = r4
            r1 = 35
            if (r0 != r1) goto L7f
        L67:
            r0 = r3
            char r0 = r0.b()
            r5 = r0
            r0 = r5
            r1 = 10
            if (r0 == r1) goto L0
            r0 = r5
            r1 = 13
            if (r0 == r1) goto L0
            r0 = r5
            if (r0 != 0) goto L67
            goto L0
        L7f:
            r0 = r4
            if (r0 == 0) goto L89
            r0 = r4
            r1 = 32
            if (r0 <= r1) goto L0
        L89:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.json.alipay.c.c():char");
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x0202, code lost:
        throw a("Unterminated string");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d() {
        /*
            Method dump skipped, instructions count: 535
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.json.alipay.c.d():java.lang.Object");
    }

    public final String toString() {
        return " at character " + this.a;
    }
}
