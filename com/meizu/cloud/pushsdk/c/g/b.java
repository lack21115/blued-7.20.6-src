package com.meizu.cloud.pushsdk.c.g;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/g/b.class */
public final class b implements c, d, Cloneable {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f24059c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: a  reason: collision with root package name */
    j f24060a;
    long b;

    public int a(byte[] bArr, int i, int i2) {
        o.a(bArr.length, i, i2);
        j jVar = this.f24060a;
        if (jVar == null) {
            return -1;
        }
        int min = Math.min(i2, jVar.f24074c - jVar.b);
        System.arraycopy((Object) jVar.f24073a, jVar.b, (Object) bArr, i, min);
        jVar.b += min;
        this.b -= min;
        if (jVar.b == jVar.f24074c) {
            this.f24060a = jVar.a();
            k.a(jVar);
        }
        return min;
    }

    public long a() {
        return this.b;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public long a(m mVar) throws IOException {
        if (mVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long j2 = j;
            long b = mVar.b(this, 2048L);
            if (b == -1) {
                return j2;
            }
            j = j2 + b;
        }
    }

    public b a(int i) {
        int i2;
        int i3;
        if (i >= 128) {
            if (i < 2048) {
                i3 = (i >> 6) | 192;
            } else {
                if (i < 65536) {
                    if (i >= 55296 && i <= 57343) {
                        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
                    }
                    i2 = (i >> 12) | 224;
                } else if (i > 1114111) {
                    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
                } else {
                    b((i >> 18) | 240);
                    i2 = ((i >> 12) & 63) | 128;
                }
                b(i2);
                i3 = ((i >> 6) & 63) | 128;
            }
            b(i3);
            i = (i & 63) | 128;
        }
        b(i);
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    /* renamed from: a */
    public b b(e eVar) {
        if (eVar != null) {
            eVar.a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    /* renamed from: a */
    public b b(String str) {
        return a(str, 0, str.length());
    }

    public b a(String str, int i, int i2) {
        char charAt;
        int i3;
        int i4;
        if (str != null) {
            if (i < 0) {
                throw new IllegalAccessError("beginIndex < 0: " + i);
            } else if (i2 < i) {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
            } else if (i2 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            } else {
                while (i < i2) {
                    char charAt2 = str.charAt(i);
                    if (charAt2 < 128) {
                        j c2 = c(1);
                        byte[] bArr = c2.f24073a;
                        int i5 = c2.f24074c - i;
                        int min = Math.min(i2, 2048 - i5);
                        bArr[i + i5] = (byte) charAt2;
                        int i6 = i + 1;
                        while (true) {
                            i = i6;
                            if (i >= min || (charAt = str.charAt(i)) >= 128) {
                                break;
                            }
                            bArr[i + i5] = (byte) charAt;
                            i6 = i + 1;
                        }
                        int i7 = (i5 + i) - c2.f24074c;
                        c2.f24074c += i7;
                        this.b += i7;
                    } else {
                        if (charAt2 < 2048) {
                            i3 = charAt2 >> 6;
                            i4 = 192;
                        } else if (charAt2 < 55296 || charAt2 > 57343) {
                            b((charAt2 >> '\f') | 224);
                            i3 = (charAt2 >> 6) & 63;
                            i4 = 128;
                        } else {
                            int i8 = i + 1;
                            char charAt3 = i8 < i2 ? str.charAt(i8) : (char) 0;
                            if (charAt2 > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                                b(63);
                                i = i8;
                            } else {
                                int i9 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + 65536;
                                b((i9 >> 18) | 240);
                                b(((i9 >> 12) & 63) | 128);
                                b(((i9 >> 6) & 63) | 128);
                                b((i9 & 63) | 128);
                                i += 2;
                            }
                        }
                        b(i3 | i4);
                        b((charAt2 & '?') | 128);
                        i++;
                    }
                }
                return this;
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    public String a(long j, Charset charset) throws EOFException {
        o.a(this.b, 0L, j);
        if (charset != null) {
            if (j > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
            } else if (j == 0) {
                return "";
            } else {
                j jVar = this.f24060a;
                if (jVar.b + j > jVar.f24074c) {
                    return new String(a(j), charset);
                }
                String str = new String(jVar.f24073a, jVar.b, (int) j, charset);
                jVar.b = (int) (jVar.b + j);
                this.b -= j;
                if (jVar.b == jVar.f24074c) {
                    this.f24060a = jVar.a();
                    k.a(jVar);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l
    public void a(b bVar, long j) {
        if (bVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (bVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        o.a(bVar.b, 0L, j);
        while (j > 0) {
            if (j < bVar.f24060a.f24074c - bVar.f24060a.b) {
                j jVar = this.f24060a;
                j jVar2 = jVar != null ? jVar.g : null;
                if (jVar2 != null && jVar2.e) {
                    if ((jVar2.f24074c + j) - (jVar2.d ? 0 : jVar2.b) <= 2048) {
                        bVar.f24060a.a(jVar2, (int) j);
                        bVar.b -= j;
                        this.b += j;
                        return;
                    }
                }
                bVar.f24060a = bVar.f24060a.a((int) j);
            }
            j jVar3 = bVar.f24060a;
            long j2 = jVar3.f24074c - jVar3.b;
            bVar.f24060a = jVar3.a();
            j jVar4 = this.f24060a;
            if (jVar4 == null) {
                this.f24060a = jVar3;
                jVar3.g = jVar3;
                jVar3.f = jVar3;
            } else {
                jVar4.g.a(jVar3).b();
            }
            bVar.b -= j2;
            this.b += j2;
            j -= j2;
        }
    }

    public void a(byte[] bArr) throws EOFException {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return;
            }
            int a2 = a(bArr, i2, bArr.length - i2);
            if (a2 == -1) {
                throw new EOFException();
            }
            i = i2 + a2;
        }
    }

    public byte[] a(long j) throws EOFException {
        o.a(this.b, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            a(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    @Override // com.meizu.cloud.pushsdk.c.g.m
    public long b(b bVar, long j) {
        if (bVar != null) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            long j2 = this.b;
            if (j2 == 0) {
                return -1L;
            }
            long j3 = j;
            if (j > j2) {
                j3 = j2;
            }
            bVar.a(this, j3);
            return j3;
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public b b() {
        return this;
    }

    public b b(int i) {
        j c2 = c(1);
        byte[] bArr = c2.f24073a;
        int i2 = c2.f24074c;
        c2.f24074c = i2 + 1;
        bArr[i2] = (byte) i;
        this.b++;
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    /* renamed from: b */
    public b c(byte[] bArr) {
        if (bArr != null) {
            return c(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    /* renamed from: b */
    public b c(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = i2;
            o.a(bArr.length, i, j);
            int i3 = i2 + i;
            while (i < i3) {
                j c2 = c(1);
                int min = Math.min(i3 - i, 2048 - c2.f24074c);
                System.arraycopy((Object) bArr, i, (Object) c2.f24073a, c2.f24074c, min);
                i += min;
                c2.f24074c += min;
            }
            this.b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public void b(long j) throws EOFException {
        j jVar;
        while (j > 0) {
            if (this.f24060a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, jVar.f24074c - this.f24060a.b);
            long j2 = min;
            this.b -= j2;
            long j3 = j - j2;
            this.f24060a.b += min;
            j = j3;
            if (this.f24060a.b == this.f24060a.f24074c) {
                j jVar2 = this.f24060a;
                this.f24060a = jVar2.a();
                k.a(jVar2);
                j = j3;
            }
        }
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    /* renamed from: c */
    public b e(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i == 0) {
            return b(48);
        }
        boolean z = false;
        int i2 = 1;
        long j2 = j;
        if (i < 0) {
            j2 = -j;
            if (j2 < 0) {
                return b("-9223372036854775808");
            }
            z = true;
        }
        if (j2 >= 100000000) {
            i2 = j2 < 1000000000000L ? j2 < 10000000000L ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        } else if (j2 >= 10000) {
            i2 = j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8;
        } else if (j2 >= 100) {
            i2 = j2 < 1000 ? 3 : 4;
        } else if (j2 >= 10) {
            i2 = 2;
        }
        int i3 = i2;
        if (z) {
            i3 = i2 + 1;
        }
        j c2 = c(i3);
        byte[] bArr = c2.f24073a;
        int i4 = c2.f24074c + i3;
        while (j2 != 0) {
            i4--;
            bArr[i4] = f24059c[(int) (j2 % 10)];
            j2 /= 10;
        }
        if (z) {
            bArr[i4 - 1] = 45;
        }
        c2.f24074c += i3;
        this.b += i3;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
        if (r0.e == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.meizu.cloud.pushsdk.c.g.j c(int r4) {
        /*
            r3 = this;
            r0 = r4
            r1 = 1
            if (r0 < r1) goto L4e
            r0 = r4
            r1 = 2048(0x800, float:2.87E-42)
            if (r0 > r1) goto L4e
            r0 = r3
            com.meizu.cloud.pushsdk.c.g.j r0 = r0.f24060a
            r5 = r0
            r0 = r5
            if (r0 != 0) goto L2a
            com.meizu.cloud.pushsdk.c.g.j r0 = com.meizu.cloud.pushsdk.c.g.k.a()
            r5 = r0
            r0 = r3
            r1 = r5
            r0.f24060a = r1
            r0 = r5
            r1 = r5
            r0.g = r1
            r0 = r5
            r1 = r5
            r0.f = r1
            r0 = r5
            return r0
        L2a:
            r0 = r5
            com.meizu.cloud.pushsdk.c.g.j r0 = r0.g
            r6 = r0
            r0 = r6
            int r0 = r0.f24074c
            r1 = r4
            int r0 = r0 + r1
            r1 = 2048(0x800, float:2.87E-42)
            if (r0 > r1) goto L44
            r0 = r6
            r5 = r0
            r0 = r6
            boolean r0 = r0.e
            if (r0 != 0) goto L4c
        L44:
            r0 = r6
            com.meizu.cloud.pushsdk.c.g.j r1 = com.meizu.cloud.pushsdk.c.g.k.a()
            com.meizu.cloud.pushsdk.c.g.j r0 = r0.a(r1)
            r5 = r0
        L4c:
            r0 = r5
            return r0
        L4e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r1.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.c.g.b.c(int):com.meizu.cloud.pushsdk.c.g.j");
    }

    public boolean c() {
        return this.b == 0;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public b d(long j) {
        if (j == 0) {
            return b(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        j c2 = c(numberOfTrailingZeros);
        byte[] bArr = c2.f24073a;
        int i = c2.f24074c;
        for (int i2 = (c2.f24074c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f24059c[(int) (15 & j)];
            j >>>= 4;
        }
        c2.f24074c += numberOfTrailingZeros;
        this.b += numberOfTrailingZeros;
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.d
    public InputStream d() {
        return new InputStream() { // from class: com.meizu.cloud.pushsdk.c.g.b.1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(b.this.b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (b.this.b > 0) {
                    return b.this.f() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return b.this.a(bArr, i, i2);
            }

            public String toString() {
                return b.this + ".inputStream()";
            }
        };
    }

    public long e() {
        long j = this.b;
        if (j == 0) {
            return 0L;
        }
        j jVar = this.f24060a.g;
        long j2 = j;
        if (jVar.f24074c < 2048) {
            j2 = j;
            if (jVar.e) {
                j2 = j - (jVar.f24074c - jVar.b);
            }
        }
        return j2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            long j = this.b;
            if (j != bVar.b) {
                return false;
            }
            long j2 = 0;
            if (j == 0) {
                return true;
            }
            j jVar = this.f24060a;
            j jVar2 = bVar.f24060a;
            int i = jVar.b;
            int i2 = jVar2.b;
            while (j2 < this.b) {
                long min = Math.min(jVar.f24074c - i, jVar2.f24074c - i2);
                int i3 = 0;
                while (i3 < min) {
                    if (jVar.f24073a[i] != jVar2.f24073a[i2]) {
                        return false;
                    }
                    i3++;
                    i++;
                    i2++;
                }
                j jVar3 = jVar;
                int i4 = i;
                if (i == jVar.f24074c) {
                    jVar3 = jVar.f;
                    i4 = jVar3.b;
                }
                int i5 = i2;
                j jVar4 = jVar2;
                if (i2 == jVar2.f24074c) {
                    jVar4 = jVar2.f;
                    i5 = jVar4.b;
                }
                j2 += min;
                jVar = jVar3;
                i = i4;
                i2 = i5;
                jVar2 = jVar4;
            }
            return true;
        }
        return false;
    }

    public byte f() {
        if (this.b != 0) {
            j jVar = this.f24060a;
            int i = jVar.b;
            int i2 = jVar.f24074c;
            byte[] bArr = jVar.f24073a;
            int i3 = i + 1;
            byte b = bArr[i];
            this.b--;
            if (i3 != i2) {
                jVar.b = i3;
                return b;
            }
            this.f24060a = jVar.a();
            k.a(jVar);
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Flushable
    public void flush() {
    }

    public e g() {
        return new e(i());
    }

    @Override // com.meizu.cloud.pushsdk.c.g.d
    public String h() {
        try {
            return a(this.b, o.f24078a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public int hashCode() {
        int i;
        j jVar;
        j jVar2 = this.f24060a;
        if (jVar2 == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = jVar2.f24074c;
            i = i2;
            for (int i4 = jVar2.b; i4 < i3; i4++) {
                i = (i * 31) + jVar2.f24073a[i4];
            }
            jVar = jVar2.f;
            jVar2 = jVar;
            i2 = i;
        } while (jVar != this.f24060a);
        return i;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.d
    public byte[] i() {
        try {
            return a(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public void j() {
        try {
            b(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: k */
    public b clone() {
        b bVar = new b();
        if (this.b == 0) {
            return bVar;
        }
        j jVar = new j(this.f24060a);
        bVar.f24060a = jVar;
        jVar.g = jVar;
        jVar.f = jVar;
        j jVar2 = this.f24060a;
        while (true) {
            jVar2 = jVar2.f;
            if (jVar2 == this.f24060a) {
                bVar.b = this.b;
                return bVar;
            }
            bVar.f24060a.g.a(new j(jVar2));
        }
    }

    public String toString() {
        long j = this.b;
        if (j == 0) {
            return "Buffer[size=0]";
        }
        if (j <= 16) {
            return String.format("Buffer[size=%s data=%s]", Long.valueOf(this.b), clone().g().c());
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(this.f24060a.f24073a, this.f24060a.b, this.f24060a.f24074c - this.f24060a.b);
            j jVar = this.f24060a;
            while (true) {
                jVar = jVar.f;
                if (jVar == this.f24060a) {
                    return String.format("Buffer[size=%s md5=%s]", Long.valueOf(this.b), e.a(messageDigest.digest()).c());
                }
                messageDigest.update(jVar.f24073a, jVar.b, jVar.f24074c - jVar.b);
            }
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }
}
