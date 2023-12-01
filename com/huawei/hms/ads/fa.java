package com.huawei.hms.ads;

import android.graphics.Bitmap;
import java.io.Closeable;
import java.io.InputStream;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/fa.class */
public class fa {
    private static final int B = 1;
    private static final int C = 2;
    private static final int D = 33;
    private static final int F = 44;
    private static final int I = 4096;
    private static final int L = 249;
    private static final int S = 3;
    private static final int Z = 0;

    /* renamed from: a  reason: collision with root package name */
    private static final long f22477a = 62914560;
    private static final String b = fa.class.getSimpleName();
    public int Code;
    private int[] E;
    private int G;
    private Bitmap J;
    private int[] K;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int T;
    private int U;
    public int V;
    private int W;

    /* renamed from: c  reason: collision with root package name */
    private final int f22478c;
    private InputStream d;
    private boolean j;
    private boolean k;
    private boolean l;
    private short[] m;
    private byte[] n;
    private byte[] p;
    private byte[] q;
    private int r;
    private int v;
    private int w;
    private int x;
    private int y;
    private final Object e = new Object();
    private final Object f = new Object();
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;
    private byte[] o = new byte[512];
    private int s = 100;
    private int t = 0;
    private int u = 0;
    private int[] z = null;
    private int[] A = null;
    private int H = 0;
    private int M = 0;
    private int X = 0;
    private int[] Y = null;

    public fa(InputStream inputStream, int i) {
        this.d = inputStream;
        this.f22478c = i;
        Z();
    }

    private void B() {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 6) {
                break;
            }
            stringBuffer.append((char) C());
            i = i2 + 1;
        }
        if (!stringBuffer.toString().startsWith("GIF")) {
            this.u = 1;
            return;
        }
        S();
        if (!this.j || D()) {
            return;
        }
        int[] Code = Code(this.v);
        this.z = Code;
        this.y = Code[this.x];
    }

    private int C() {
        try {
            return this.d.read();
        } catch (Exception e) {
            this.u = 1;
            return 0;
        }
    }

    private Bitmap Code(int[] iArr, int i, int i2, Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        if (bitmap == null) {
            Bitmap.Config config = com.huawei.openalliance.ad.utils.v.V() > f22477a ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            if (ge.Code()) {
                ge.Code(b, "create image with config %s", config);
            }
            bitmap2 = Bitmap.createBitmap(i, i2, config);
        }
        bitmap2.setPixels(iArr, 0, i, 0, 0, i, i2);
        return bitmap2;
    }

    private void Code(boolean z) {
        synchronized (this.f) {
            this.h = z;
        }
    }

    private int[] Code(int i) {
        int i2;
        int[] iArr = new int[256];
        int i3 = i * 3;
        byte[] bArr = new byte[i3];
        try {
            i2 = this.d.read(bArr);
        } catch (Exception e) {
            ge.I(b, "read color table fail");
            i2 = 0;
        }
        if (i2 < i3) {
            this.u = 1;
            return iArr;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = i4 + 1;
            byte b2 = bArr[i4];
            int i7 = i6 + 1;
            iArr[i5] = ((b2 & 255) << 16) | (-16777216) | ((bArr[i6] & 255) << 8) | (bArr[i7] & 255);
            i4 = i7 + 1;
        }
        return iArr;
    }

    private boolean D() {
        return this.u != 0;
    }

    private int F() {
        return C() | (C() << 8);
    }

    private fc L() {
        fc fcVar = null;
        fc fcVar2 = null;
        fc fcVar3 = null;
        try {
            try {
                int a2 = a();
                if (D()) {
                    return null;
                }
                b();
                d();
                if (D()) {
                    return null;
                }
                e();
                if (D()) {
                    return null;
                }
                if (this.J != null) {
                    int i = this.M + 1;
                    this.M = i;
                    fcVar = new fc(i, this.J, this.s);
                }
                fc fcVar4 = fcVar;
                if (this.i) {
                    fc fcVar5 = fcVar;
                    this.E[this.G] = a2;
                }
                fcVar2 = fcVar;
                fcVar3 = fcVar;
                g();
                return fcVar;
            } catch (OutOfMemoryError e) {
                this.u = 1;
                ge.I(b, "run out of memory");
                f();
                return fcVar2;
            }
        } catch (Exception | StackOverflowError e2) {
            this.u = 1;
            ge.I(b, "read image error");
            return fcVar3;
        }
    }

    private void S() {
        this.Code = F();
        this.V = F();
        int C2 = C();
        this.j = (C2 & 128) != 0;
        this.v = (int) Math.pow(2.0d, (C2 & 7) + 1);
        this.x = C();
        C();
    }

    private void V(int i) {
        byte[] bArr = this.q;
        if (bArr == null || bArr.length < i) {
            this.q = new byte[i];
        }
        if (this.m == null) {
            this.m = new short[4096];
        }
        if (this.n == null) {
            this.n = new byte[4096];
        }
        if (this.p == null) {
            this.p = new byte[4097];
        }
    }

    private void Z() {
        if (this.d == null) {
            Code(true);
            return;
        }
        B();
        if (D()) {
            Code(true);
            V();
        }
    }

    private int a() {
        this.N = F();
        this.O = F();
        this.P = F();
        this.Q = F();
        int C2 = C();
        this.k = (C2 & 128) != 0;
        this.l = (C2 & 64) != 0;
        int pow = (int) Math.pow(2.0d, (C2 & 7) + 1);
        this.w = pow;
        if (this.k) {
            int[] Code = Code(pow);
            this.A = Code;
            this.E = Code;
        } else {
            this.E = this.z;
            if (this.x == this.G) {
                this.y = 0;
            }
        }
        int i = 0;
        if (this.i) {
            int[] iArr = this.E;
            i = 0;
            if (iArr != null) {
                i = 0;
                if (iArr.length > 0) {
                    int length = iArr.length;
                    int i2 = this.G;
                    i = 0;
                    if (length > i2) {
                        i = iArr[i2];
                        iArr[i2] = 0;
                    }
                }
            }
        }
        if (this.E == null) {
            this.u = 1;
        }
        return i;
    }

    private void b() {
        int i;
        int i2;
        int i3;
        int i4;
        short s;
        int i5 = this.P * this.Q;
        V(i5);
        int C2 = C();
        int i6 = 1 << C2;
        int i7 = i6 + 1;
        int i8 = i6 + 2;
        int i9 = C2 + 1;
        int i10 = (1 << i9) - 1;
        int i11 = 0;
        while (true) {
            int i12 = i11;
            if (i12 >= i6) {
                break;
            }
            this.m[i12] = 0;
            this.n[i12] = (byte) i12;
            i11 = i12 + 1;
        }
        int i13 = i9;
        int i14 = i8;
        int i15 = i10;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = -1;
        int i23 = 0;
        int i24 = 0;
        while (i16 < i5) {
            if (i17 != 0) {
                int i25 = i22;
                i = i6;
                i2 = i23;
                i3 = i17;
                i4 = i25;
            } else if (i18 >= i13) {
                int i26 = i19 & i15;
                i19 >>= i13;
                int i27 = i18 - i13;
                if (i26 > i14 || i26 == i7) {
                    break;
                } else if (i26 == i6) {
                    i13 = i9;
                    i14 = i8;
                    i15 = i10;
                    i22 = -1;
                    i18 = i27;
                } else if (i22 == -1) {
                    this.p[i17] = this.n[i26];
                    i22 = i26;
                    i17++;
                    i23 = i22;
                    i18 = i27;
                } else {
                    if (i26 == i14) {
                        this.p[i17] = (byte) i23;
                        s = i22;
                        i17++;
                    } else {
                        s = i26;
                    }
                    while (s > i6) {
                        this.p[i17] = this.n[s];
                        s = this.m[s];
                        i17++;
                    }
                    int i28 = i6;
                    byte[] bArr = this.n;
                    int i29 = bArr[s] & 255;
                    if (i14 >= 4096) {
                        break;
                    }
                    byte b2 = (byte) i29;
                    this.p[i17] = b2;
                    this.m[i14] = (short) i22;
                    bArr[i14] = b2;
                    i14++;
                    int i30 = i13;
                    int i31 = i15;
                    if ((i14 & i15) == 0 && i14 < 4096) {
                        i30 = i13 + 1;
                        i31 = i15 + i14;
                    }
                    i3 = i17 + 1;
                    i4 = i26;
                    i18 = i27;
                    i13 = i30;
                    i15 = i31;
                    i2 = i29;
                    i = i28;
                }
            } else {
                int i32 = i20;
                if (i20 == 0) {
                    i32 = h();
                    if (i32 <= 0) {
                        break;
                    }
                    i21 = 0;
                }
                i19 += (this.o[i21] & 255) << i18;
                i18 += 8;
                i21++;
                i20 = i32 - 1;
            }
            int i33 = i3 - 1;
            this.q[i24] = this.p[i33];
            i16++;
            int i34 = i4;
            i24++;
            i6 = i;
            i17 = i33;
            i22 = i34;
            i23 = i2;
        }
        while (i24 < i5) {
            this.q[i24] = 0;
            i24++;
        }
    }

    private void c() {
        C();
        int C2 = C();
        int i = (C2 & 28) >> 2;
        this.t = i;
        boolean z = true;
        if (i == 0) {
            this.t = 1;
        }
        if ((C2 & 1) == 0) {
            z = false;
        }
        this.i = z;
        int F2 = F() * 10;
        this.s = F2;
        int i2 = this.f22478c;
        if (i2 > F2) {
            this.s = i2;
        }
        this.G = C();
        C();
    }

    private void d() {
        do {
            h();
            if (this.X <= 0) {
                return;
            }
        } while (!D());
    }

    private void e() {
        int i;
        int i2;
        int i3;
        try {
            i();
            int i4 = 8;
            int i5 = 0;
            int i6 = 0;
            int i7 = 1;
            while (i5 < this.Q) {
                if (this.l) {
                    i3 = i4;
                    int i8 = i6;
                    int i9 = i7;
                    if (i6 >= this.Q) {
                        i9 = i7 + 1;
                        if (i9 == 2) {
                            i8 = 4;
                            i3 = i4;
                        } else if (i9 == 3) {
                            i3 = 4;
                            i8 = 2;
                        } else if (i9 != 4) {
                            i3 = i4;
                            i8 = i6;
                        } else {
                            i3 = 2;
                            i8 = 1;
                        }
                    }
                    i2 = i8;
                    i7 = i9;
                    i = i8 + i3;
                } else {
                    i = i6;
                    i2 = i5;
                    i3 = i4;
                }
                int i10 = i2 + this.O;
                if (i10 < this.V) {
                    int i11 = i10 * this.Code;
                    int i12 = this.N + i11;
                    int i13 = this.P + i12;
                    int i14 = i13;
                    if (this.Code + i11 < i13) {
                        i14 = this.Code + i11;
                    }
                    int i15 = this.P * i5;
                    while (true) {
                        int i16 = i15;
                        if (i12 < i14) {
                            int i17 = this.E[this.q[i16] & 255];
                            if (i17 != 0) {
                                this.Y[i12] = i17;
                            }
                            i12++;
                            i15 = i16 + 1;
                        }
                    }
                }
                i5++;
                i4 = i3;
                i6 = i;
            }
            this.J = Code(this.Y, this.Code, this.V, this.J);
        } catch (Exception | StackOverflowError e) {
            this.u = 1;
            ge.I(b, "set pixel error");
        }
    }

    private void f() {
        this.u = 3;
    }

    private void g() {
        this.H = this.t;
        this.R = this.N;
        this.T = this.O;
        this.U = this.P;
        this.W = this.Q;
        this.r = this.y;
        this.K = this.Y;
        this.i = false;
        this.t = 0;
        this.A = null;
        this.s = this.f22478c;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int h() {
        /*
            r6 = this;
            r0 = r6
            int r0 = r0.C()
            r9 = r0
            r0 = r6
            r1 = r9
            r0.X = r1
            r0 = 0
            r8 = r0
            r0 = 0
            r7 = r0
            r0 = r9
            if (r0 <= 0) goto L6b
        L12:
            r0 = r7
            r1 = r6
            int r1 = r1.X     // Catch: java.io.IOException -> L6d java.lang.Exception -> L72
            if (r0 >= r1) goto L5a
            r0 = r6
            java.io.InputStream r0 = r0.d     // Catch: java.io.IOException -> L6d java.lang.Exception -> L72
            r1 = r6
            byte[] r1 = r1.o     // Catch: java.io.IOException -> L6d java.lang.Exception -> L72
            r2 = r7
            r3 = r6
            int r3 = r3.X     // Catch: java.io.IOException -> L6d java.lang.Exception -> L72
            r4 = r7
            int r3 = r3 - r4
            int r0 = r0.read(r1, r2, r3)     // Catch: java.io.IOException -> L6d java.lang.Exception -> L72
            r8 = r0
            r0 = r8
            r1 = -1
            if (r0 != r1) goto L35
            goto L5a
        L35:
            r0 = r7
            r1 = r8
            int r0 = r0 + r1
            r7 = r0
            goto L12
        L3c:
            java.lang.String r0 = com.huawei.hms.ads.fa.b
            r10 = r0
            java.lang.String r0 = "read block fail"
            r11 = r0
            goto L53
        L49:
            java.lang.String r0 = com.huawei.hms.ads.fa.b
            r10 = r0
            java.lang.String r0 = "read block IOException"
            r11 = r0
        L53:
            r0 = r10
            r1 = r11
            com.huawei.hms.ads.ge.I(r0, r1)
        L5a:
            r0 = r7
            r8 = r0
            r0 = r7
            r1 = r6
            int r1 = r1.X
            if (r0 >= r1) goto L6b
            r0 = r6
            r1 = 1
            r0.u = r1
            r0 = r7
            r8 = r0
        L6b:
            r0 = r8
            return r0
        L6d:
            r10 = move-exception
            goto L49
        L72:
            r10 = move-exception
            goto L3c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.fa.h():int");
    }

    private void i() {
        if (this.Y == null) {
            this.Y = new int[this.Code * this.V];
        }
        int i = this.H;
        if (i > 0) {
            if (3 == i) {
                this.K = null;
            }
            int[] iArr = this.K;
            if (iArr != null) {
                this.Y = iArr;
                if (2 == this.H) {
                    int i2 = !this.i ? this.r : 0;
                    for (int i3 = 0; i3 < this.W; i3++) {
                        int i4 = ((this.T + i3) * this.Code) + this.R;
                        int i5 = this.U;
                        int i6 = i4;
                        while (true) {
                            int i7 = i6;
                            if (i7 < i5 + i4) {
                                this.Y[i7] = i2;
                                i6 = i7 + 1;
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean j() {
        boolean z;
        synchronized (this.f) {
            z = this.h;
        }
        return z;
    }

    public fc Code() {
        if (I()) {
            Code(true);
            return null;
        }
        while (true) {
            if (j()) {
                break;
            } else if (D()) {
                Code(true);
                break;
            } else {
                int C2 = C();
                if (C2 != 0) {
                    if (C2 != 33) {
                        if (C2 == 44) {
                            fc L2 = L();
                            if (L2 != null) {
                                return L2;
                            }
                        } else if (C2 != 59) {
                            this.u = 1;
                        } else {
                            Code(true);
                        }
                    } else if (249 == C()) {
                        c();
                    } else {
                        d();
                    }
                }
            }
        }
        if (j()) {
            V();
            return null;
        }
        return null;
    }

    public boolean I() {
        boolean z;
        synchronized (this.e) {
            z = this.g;
        }
        return z;
    }

    public void V() {
        synchronized (this.e) {
            if (!this.g) {
                this.g = true;
                com.huawei.openalliance.ad.utils.at.Code((Closeable) this.d);
            }
        }
    }
}
