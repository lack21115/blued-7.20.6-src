package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/cj.class */
public class cj extends cp {
    private static final cu d = new cu("");
    private static final ck e = new ck("", (byte) 0, 0);
    private static final byte[] f;
    private static final byte h = -126;
    private static final byte i = 1;
    private static final byte j = 31;
    private static final byte k = -32;
    private static final int l = 5;

    /* renamed from: a  reason: collision with root package name */
    byte[] f27003a;
    byte[] b;

    /* renamed from: c  reason: collision with root package name */
    byte[] f27004c;
    private bo m;
    private short n;
    private ck o;
    private Boolean p;
    private final long q;
    private byte[] r;

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/cj$a.class */
    public static class a implements cr {

        /* renamed from: a  reason: collision with root package name */
        private final long f27005a;

        public a() {
            this.f27005a = -1L;
        }

        public a(int i) {
            this.f27005a = i;
        }

        @Override // com.umeng.analytics.pro.cr
        public cp a(dd ddVar) {
            return new cj(ddVar, this.f27005a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/cj$b.class */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final byte f27006a = 1;
        public static final byte b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final byte f27007c = 3;
        public static final byte d = 4;
        public static final byte e = 5;
        public static final byte f = 6;
        public static final byte g = 7;
        public static final byte h = 8;
        public static final byte i = 9;
        public static final byte j = 10;
        public static final byte k = 11;
        public static final byte l = 12;

        private b() {
        }
    }

    static {
        f = r0;
        byte[] bArr = {0, 0, 1, 3, 7, 0, 4, 0, 5, 0, 6, 8, 12, 11, 10, 9};
    }

    public cj(dd ddVar) {
        this(ddVar, -1L);
    }

    public cj(dd ddVar, long j2) {
        super(ddVar);
        this.m = new bo(15);
        this.n = (short) 0;
        this.o = null;
        this.p = null;
        this.f27003a = new byte[5];
        this.b = new byte[10];
        this.r = new byte[1];
        this.f27004c = new byte[1];
        this.q = j2;
    }

    private int E() throws bw {
        int i2 = 0;
        if (this.g.h() >= 5) {
            byte[] f2 = this.g.f();
            int g = this.g.g();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                byte b2 = f2[g + i2];
                i3 |= (b2 & Byte.MAX_VALUE) << i4;
                if ((b2 & 128) != 128) {
                    this.g.a(i2 + 1);
                    return i3;
                }
                i4 += 7;
                i2++;
            }
        } else {
            int i5 = 0;
            int i6 = 0;
            while (true) {
                int i7 = i6;
                byte u = u();
                i5 |= (u & Byte.MAX_VALUE) << i7;
                if ((u & 128) != 128) {
                    return i5;
                }
                i6 = i7 + 7;
            }
        }
    }

    private long F() throws bw {
        byte u;
        byte b2;
        int i2 = 0;
        long j2 = 0;
        if (this.g.h() >= 10) {
            byte[] f2 = this.g.f();
            int g = this.g.g();
            long j3 = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                j3 |= (b2 & Byte.MAX_VALUE) << i3;
                if ((f2[g + i5] & 128) != 128) {
                    this.g.a(i5 + 1);
                    return j3;
                }
                i3 += 7;
                i4 = i5 + 1;
            }
        } else {
            while (true) {
                j2 |= (u & Byte.MAX_VALUE) << i2;
                if ((u() & 128) != 128) {
                    return j2;
                }
                i2 += 7;
            }
        }
    }

    private long a(byte[] bArr) {
        return ((bArr[7] & 255) << 56) | ((bArr[6] & 255) << 48) | ((bArr[5] & 255) << 40) | ((bArr[4] & 255) << 32) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8) | (255 & bArr[0]);
    }

    private void a(long j2, byte[] bArr, int i2) {
        bArr[i2 + 0] = (byte) (j2 & 255);
        bArr[i2 + 1] = (byte) ((j2 >> 8) & 255);
        bArr[i2 + 2] = (byte) ((j2 >> 16) & 255);
        bArr[i2 + 3] = (byte) ((j2 >> 24) & 255);
        bArr[i2 + 4] = (byte) ((j2 >> 32) & 255);
        bArr[i2 + 5] = (byte) ((j2 >> 40) & 255);
        bArr[i2 + 6] = (byte) ((j2 >> 48) & 255);
        bArr[i2 + 7] = (byte) ((j2 >> 56) & 255);
    }

    private void a(ck ckVar, byte b2) throws bw {
        byte b3 = b2;
        if (b2 == -1) {
            b3 = e(ckVar.b);
        }
        if (ckVar.f27009c <= this.n || ckVar.f27009c - this.n > 15) {
            b(b3);
            a(ckVar.f27009c);
        } else {
            d(b3 | ((ckVar.f27009c - this.n) << 4));
        }
        this.n = ckVar.f27009c;
    }

    private void a(byte[] bArr, int i2, int i3) throws bw {
        b(i3);
        this.g.b(bArr, i2, i3);
    }

    private void b(byte b2) throws bw {
        this.r[0] = b2;
        this.g.b(this.r);
    }

    private void b(int i2) throws bw {
        int i3 = i2;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if ((i3 & (-128)) == 0) {
                this.f27003a[i5] = (byte) i3;
                this.g.b(this.f27003a, 0, i5 + 1);
                return;
            }
            this.f27003a[i5] = (byte) ((i3 & 127) | 128);
            i3 >>>= 7;
            i4 = i5 + 1;
        }
    }

    private void b(long j2) throws bw {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (((-128) & j2) == 0) {
                this.b[i3] = (byte) j2;
                this.g.b(this.b, 0, i3 + 1);
                return;
            }
            this.b[i3] = (byte) ((127 & j2) | 128);
            j2 >>>= 7;
            i2 = i3 + 1;
        }
    }

    private int c(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    private long c(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    private boolean c(byte b2) {
        int i2 = b2 & 15;
        boolean z = true;
        if (i2 != 1) {
            if (i2 == 2) {
                return true;
            }
            z = false;
        }
        return z;
    }

    private byte d(byte b2) throws cq {
        byte b3 = (byte) (b2 & 15);
        switch (b3) {
            case 0:
                return (byte) 0;
            case 1:
            case 2:
                return (byte) 2;
            case 3:
                return (byte) 3;
            case 4:
                return (byte) 6;
            case 5:
                return (byte) 8;
            case 6:
                return (byte) 10;
            case 7:
                return (byte) 4;
            case 8:
                return (byte) 11;
            case 9:
                return (byte) 15;
            case 10:
                return (byte) 14;
            case 11:
                return (byte) 13;
            case 12:
                return (byte) 12;
            default:
                throw new cq("don't know what type: " + ((int) b3));
        }
    }

    private long d(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    private void d(int i2) throws bw {
        b((byte) i2);
    }

    private byte e(byte b2) {
        return f[b2];
    }

    private byte[] e(int i2) throws bw {
        if (i2 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i2];
        this.g.d(bArr, 0, i2);
        return bArr;
    }

    private void f(int i2) throws cq {
        if (i2 < 0) {
            throw new cq("Negative length: " + i2);
        }
        long j2 = this.q;
        if (j2 == -1 || i2 <= j2) {
            return;
        }
        throw new cq("Length exceeded max allowed: " + i2);
    }

    private int g(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    @Override // com.umeng.analytics.pro.cp
    public ByteBuffer A() throws bw {
        int E = E();
        f(E);
        if (E == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[E];
        this.g.d(bArr, 0, E);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.cp
    public void B() {
        this.m.c();
        this.n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.cp
    public void a() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(byte b2) throws bw {
        b(b2);
    }

    protected void a(byte b2, int i2) throws bw {
        if (i2 <= 14) {
            d(e(b2) | (i2 << 4));
            return;
        }
        d(e(b2) | 240);
        b(i2);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(double d2) throws bw {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0};
        a(Double.doubleToLongBits(d2), bArr, 0);
        this.g.b(bArr);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(int i2) throws bw {
        b(c(i2));
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(long j2) throws bw {
        b(c(j2));
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(ck ckVar) throws bw {
        if (ckVar.b == 2) {
            this.o = ckVar;
        } else {
            a(ckVar, (byte) -1);
        }
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(cl clVar) throws bw {
        a(clVar.f27010a, clVar.b);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(cm cmVar) throws bw {
        if (cmVar.f27012c == 0) {
            d(0);
            return;
        }
        b(cmVar.f27012c);
        d(e(cmVar.b) | (e(cmVar.f27011a) << 4));
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(cn cnVar) throws bw {
        b((byte) -126);
        d(((cnVar.b << 5) & (-32)) | 1);
        b(cnVar.f27014c);
        a(cnVar.f27013a);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(ct ctVar) throws bw {
        a(ctVar.f27020a, ctVar.b);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(cu cuVar) throws bw {
        this.m.a(this.n);
        this.n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(String str) throws bw {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException e2) {
            throw new bw("UTF-8 not supported!");
        }
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(ByteBuffer byteBuffer) throws bw {
        a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(short s) throws bw {
        b(c((int) s));
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(boolean z) throws bw {
        ck ckVar = this.o;
        byte b2 = 1;
        if (ckVar == null) {
            b(z ? (byte) 1 : (byte) 2);
            return;
        }
        if (!z) {
            b2 = 2;
        }
        a(ckVar, b2);
        this.o = null;
    }

    @Override // com.umeng.analytics.pro.cp
    public void b() throws bw {
        this.n = this.m.a();
    }

    @Override // com.umeng.analytics.pro.cp
    public void c() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public void d() throws bw {
        b((byte) 0);
    }

    @Override // com.umeng.analytics.pro.cp
    public void e() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public void f() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public void g() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public cn h() throws bw {
        byte u = u();
        if (u != -126) {
            throw new cq("Expected protocol id " + Integer.toHexString(-126) + " but got " + Integer.toHexString(u));
        }
        byte u2 = u();
        byte b2 = (byte) (u2 & 31);
        if (b2 == 1) {
            return new cn(z(), (byte) ((u2 >> 5) & 3), E());
        }
        throw new cq("Expected version 1 but got " + ((int) b2));
    }

    @Override // com.umeng.analytics.pro.cp
    public void i() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public cu j() throws bw {
        this.m.a(this.n);
        this.n = (short) 0;
        return d;
    }

    @Override // com.umeng.analytics.pro.cp
    public void k() throws bw {
        this.n = this.m.a();
    }

    @Override // com.umeng.analytics.pro.cp
    public ck l() throws bw {
        byte u = u();
        if (u == 0) {
            return e;
        }
        short s = (short) ((u & 240) >> 4);
        short v = s == 0 ? v() : (short) (this.n + s);
        byte b2 = (byte) (u & 15);
        ck ckVar = new ck("", d(b2), v);
        if (c(u)) {
            this.p = b2 == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.n = ckVar.f27009c;
        return ckVar;
    }

    @Override // com.umeng.analytics.pro.cp
    public void m() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public cm n() throws bw {
        int E = E();
        byte u = E == 0 ? (byte) 0 : u();
        return new cm(d((byte) (u >> 4)), d((byte) (u & 15)), E);
    }

    @Override // com.umeng.analytics.pro.cp
    public void o() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public cl p() throws bw {
        byte u = u();
        int i2 = (u >> 4) & 15;
        int i3 = i2;
        if (i2 == 15) {
            i3 = E();
        }
        return new cl(d(u), i3);
    }

    @Override // com.umeng.analytics.pro.cp
    public void q() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public ct r() throws bw {
        return new ct(p());
    }

    @Override // com.umeng.analytics.pro.cp
    public void s() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public boolean t() throws bw {
        Boolean bool = this.p;
        if (bool == null) {
            return u() == 1;
        }
        boolean booleanValue = bool.booleanValue();
        this.p = null;
        return booleanValue;
    }

    @Override // com.umeng.analytics.pro.cp
    public byte u() throws bw {
        if (this.g.h() <= 0) {
            this.g.d(this.f27004c, 0, 1);
            return this.f27004c[0];
        }
        byte b2 = this.g.f()[this.g.g()];
        this.g.a(1);
        return b2;
    }

    @Override // com.umeng.analytics.pro.cp
    public short v() throws bw {
        return (short) g(E());
    }

    @Override // com.umeng.analytics.pro.cp
    public int w() throws bw {
        return g(E());
    }

    @Override // com.umeng.analytics.pro.cp
    public long x() throws bw {
        return d(F());
    }

    @Override // com.umeng.analytics.pro.cp
    public double y() throws bw {
        byte[] bArr = new byte[8];
        this.g.d(bArr, 0, 8);
        return Double.longBitsToDouble(a(bArr));
    }

    @Override // com.umeng.analytics.pro.cp
    public String z() throws bw {
        int E = E();
        f(E);
        if (E == 0) {
            return "";
        }
        try {
            if (this.g.h() >= E) {
                String str = new String(this.g.f(), this.g.g(), E, "UTF-8");
                this.g.a(E);
                return str;
            }
            return new String(e(E), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new bw("UTF-8 not supported!");
        }
    }
}
