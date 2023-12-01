package com.xiaomi.push;

import java.io.InputStream;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private int f41271a;

    /* renamed from: a  reason: collision with other field name */
    private final InputStream f212a;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f213a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f41272c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;

    private b(InputStream inputStream) {
        this.f = Integer.MAX_VALUE;
        this.h = 64;
        this.i = 67108864;
        this.f213a = new byte[4096];
        this.f41271a = 0;
        this.f41272c = 0;
        this.f212a = inputStream;
    }

    private b(byte[] bArr, int i, int i2) {
        this.f = Integer.MAX_VALUE;
        this.h = 64;
        this.i = 67108864;
        this.f213a = bArr;
        this.f41271a = i2 + i;
        this.f41272c = i;
        this.f212a = null;
    }

    public static b a(InputStream inputStream) {
        return new b(inputStream);
    }

    public static b a(byte[] bArr, int i, int i2) {
        return new b(bArr, i, i2);
    }

    private boolean a(boolean z) {
        int i = this.f41272c;
        int i2 = this.f41271a;
        if (i >= i2) {
            int i3 = this.e;
            if (i3 + i2 == this.f) {
                if (z) {
                    throw d.a();
                }
                return false;
            }
            this.e = i3 + i2;
            this.f41272c = 0;
            InputStream inputStream = this.f212a;
            int read = inputStream == null ? -1 : inputStream.read(this.f213a);
            this.f41271a = read;
            if (read == 0 || read < -1) {
                throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.f41271a + "\nThe InputStream implementation is buggy.");
            } else if (read == -1) {
                this.f41271a = 0;
                if (z) {
                    throw d.a();
                }
                return false;
            } else {
                b();
                int i4 = this.e + this.f41271a + this.b;
                if (i4 > this.i || i4 < 0) {
                    throw d.h();
                }
                return true;
            }
        }
        throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }

    private void b() {
        int i = this.f41271a + this.b;
        this.f41271a = i;
        int i2 = this.e + i;
        int i3 = this.f;
        if (i2 <= i3) {
            this.b = 0;
            return;
        }
        int i4 = i2 - i3;
        this.b = i4;
        this.f41271a = i - i4;
    }

    public final byte a() {
        if (this.f41272c == this.f41271a) {
            a(true);
        }
        byte[] bArr = this.f213a;
        int i = this.f41272c;
        this.f41272c = i + 1;
        return bArr[i];
    }

    /* renamed from: a  reason: collision with other method in class */
    public final int m11518a() {
        if (m11529b()) {
            this.d = 0;
            return 0;
        }
        int d = d();
        this.d = d;
        if (d != 0) {
            return d;
        }
        throw d.d();
    }

    public final int a(int i) {
        if (i >= 0) {
            int i2 = i + this.e + this.f41272c;
            int i3 = this.f;
            if (i2 <= i3) {
                this.f = i2;
                b();
                return i3;
            }
            throw d.a();
        }
        throw d.b();
    }

    /* renamed from: a  reason: collision with other method in class */
    public final long m11519a() {
        return m11530c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public final a m11520a() {
        int d = d();
        int i = this.f41271a;
        int i2 = this.f41272c;
        if (d > i - i2 || d <= 0) {
            return a.a(m11526a(d));
        }
        a a2 = a.a(this.f213a, i2, d);
        this.f41272c += d;
        return a2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final String m11521a() {
        int d = d();
        if (d > this.f41271a - this.f41272c || d <= 0) {
            return new String(m11526a(d), "UTF-8");
        }
        String str = new String(this.f213a, this.f41272c, d, "UTF-8");
        this.f41272c += d;
        return str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final void m11522a() {
        int m11518a;
        do {
            m11518a = m11518a();
            if (m11518a == 0) {
                return;
            }
        } while (m11525a(m11518a));
    }

    /* renamed from: a  reason: collision with other method in class */
    public final void m11523a(int i) {
        if (this.d != i) {
            throw d.e();
        }
    }

    public final void a(e eVar) {
        int d = d();
        if (this.g >= this.h) {
            throw d.g();
        }
        int a2 = a(d);
        this.g++;
        eVar.a(this);
        m11523a(0);
        this.g--;
        b(a2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public final boolean m11524a() {
        return d() != 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final boolean m11525a(int i) {
        int a2 = f.a(i);
        if (a2 == 0) {
            m11527b();
            return true;
        } else if (a2 == 1) {
            m11531d();
            return true;
        } else if (a2 == 2) {
            c(d());
            return true;
        } else if (a2 == 3) {
            m11522a();
            m11523a(f.a(f.b(i), 4));
            return true;
        } else if (a2 != 4) {
            if (a2 == 5) {
                e();
                return true;
            }
            throw d.f();
        } else {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0134, code lost:
        r8 = r8 - r0;
        r0.addElement(r0);
     */
    /* renamed from: a  reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] m11526a(int r7) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.b.m11526a(int):byte[]");
    }

    /* renamed from: b  reason: collision with other method in class */
    public final int m11527b() {
        return d();
    }

    /* renamed from: b  reason: collision with other method in class */
    public final long m11528b() {
        return m11530c();
    }

    public final void b(int i) {
        this.f = i;
        b();
    }

    /* renamed from: b  reason: collision with other method in class */
    public final boolean m11529b() {
        return this.f41272c == this.f41271a && !a(false);
    }

    public final int c() {
        return d();
    }

    /* renamed from: c  reason: collision with other method in class */
    public final long m11530c() {
        byte a2;
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (a2 & Byte.MAX_VALUE) << i;
            if ((a() & 128) == 0) {
                return j;
            }
        }
        throw d.c();
    }

    public final void c(int i) {
        if (i < 0) {
            throw d.b();
        }
        int i2 = this.e;
        int i3 = this.f41272c;
        int i4 = this.f;
        if (i2 + i3 + i > i4) {
            c((i4 - i2) - i3);
            throw d.a();
        }
        int i5 = this.f41271a;
        if (i <= i5 - i3) {
            this.f41272c = i3 + i;
            return;
        }
        int i6 = i5 - i3;
        this.e = i2 + i5;
        this.f41272c = 0;
        this.f41271a = 0;
        while (i6 < i) {
            InputStream inputStream = this.f212a;
            int skip = inputStream == null ? -1 : (int) inputStream.skip(i - i6);
            if (skip <= 0) {
                throw d.a();
            }
            i6 += skip;
            this.e += skip;
        }
    }

    public final int d() {
        int i;
        byte a2 = a();
        if (a2 >= 0) {
            return a2;
        }
        int i2 = a2 & Byte.MAX_VALUE;
        byte a3 = a();
        if (a3 >= 0) {
            i = a3 << 7;
        } else {
            i2 |= (a3 & Byte.MAX_VALUE) << 7;
            byte a4 = a();
            if (a4 >= 0) {
                i = a4 << 14;
            } else {
                i2 |= (a4 & Byte.MAX_VALUE) << 14;
                byte a5 = a();
                if (a5 >= 0) {
                    i = a5 << 21;
                } else {
                    byte a6 = a();
                    int i3 = i2 | ((a5 & Byte.MAX_VALUE) << 21) | (a6 << 28);
                    if (a6 >= 0) {
                        return i3;
                    }
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= 5) {
                            throw d.c();
                        }
                        if (a() >= 0) {
                            return i3;
                        }
                        i4 = i5 + 1;
                    }
                }
            }
        }
        return i2 | i;
    }

    /* renamed from: d  reason: collision with other method in class */
    public final long m11531d() {
        byte a2 = a();
        return ((a() & 255) << 8) | (a2 & 255) | ((a() & 255) << 16) | ((a() & 255) << 24) | ((a() & 255) << 32) | ((a() & 255) << 40) | ((a() & 255) << 48) | ((a() & 255) << 56);
    }

    public final int e() {
        return (a() & 255) | ((a() & 255) << 8) | ((a() & 255) << 16) | ((a() & 255) << 24);
    }
}
