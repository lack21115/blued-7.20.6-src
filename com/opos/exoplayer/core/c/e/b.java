package com.opos.exoplayer.core.c.e;

import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.o;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/e/b.class */
final class b {

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/e/b$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f25154a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final long[] f25155c;
        public final int d;
        public final boolean e;

        public a(int i, int i2, long[] jArr, int i3, boolean z) {
            this.f25154a = i;
            this.b = i2;
            this.f25155c = jArr;
            this.d = i3;
            this.e = z;
        }
    }

    /* renamed from: com.opos.exoplayer.core.c.e.b$b  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/e/b$b.class */
    public static final class C0653b {

        /* renamed from: a  reason: collision with root package name */
        public final String f25156a;
        public final String[] b;

        /* renamed from: c  reason: collision with root package name */
        public final int f25157c;

        public C0653b(String str, String[] strArr, int i) {
            this.f25156a = str;
            this.b = strArr;
            this.f25157c = i;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/e/b$c.class */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f25158a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final int f25159c;
        public final int d;

        public c(boolean z, int i, int i2, int i3) {
            this.f25158a = z;
            this.b = i;
            this.f25159c = i2;
            this.d = i3;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/e/b$d.class */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final long f25160a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final long f25161c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final boolean i;
        public final byte[] j;

        public d(long j, int i, long j2, int i2, int i3, int i4, int i5, int i6, boolean z, byte[] bArr) {
            this.f25160a = j;
            this.b = i;
            this.f25161c = j2;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = i5;
            this.h = i6;
            this.i = z;
            this.j = bArr;
        }
    }

    public static int a(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    private static long a(long j, long j2) {
        return (long) Math.floor(Math.pow(j, 1.0d / j2));
    }

    public static d a(m mVar) {
        a(1, mVar, false);
        long n = mVar.n();
        int g = mVar.g();
        long n2 = mVar.n();
        int p = mVar.p();
        int p2 = mVar.p();
        int p3 = mVar.p();
        int g2 = mVar.g();
        return new d(n, g, n2, p, p2, p3, (int) Math.pow(2.0d, g2 & 15), (int) Math.pow(2.0d, (g2 & 240) >> 4), (mVar.g() & 1) > 0, Arrays.copyOf(mVar.f25496a, mVar.c()));
    }

    private static void a(int i, j jVar) {
        int a2 = jVar.a(6);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= a2 + 1) {
                return;
            }
            int a3 = jVar.a(16);
            if (a3 != 0) {
                com.opos.cmn.an.f.a.d("VorbisUtil", "mapping type other than 0 not supported: " + a3);
            } else {
                int a4 = jVar.a() ? jVar.a(4) + 1 : 1;
                if (jVar.a()) {
                    int a5 = jVar.a(8);
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= a5 + 1) {
                            break;
                        }
                        int i6 = i - 1;
                        jVar.b(a(i6));
                        jVar.b(a(i6));
                        i4 = i5 + 1;
                    }
                }
                if (jVar.a(2) != 0) {
                    throw new o("to reserved bits must be zero after mapping coupling steps");
                }
                if (a4 > 1) {
                    int i7 = 0;
                    while (true) {
                        int i8 = i7;
                        if (i8 >= i) {
                            break;
                        }
                        jVar.b(4);
                        i7 = i8 + 1;
                    }
                }
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    if (i10 < a4) {
                        jVar.b(8);
                        jVar.b(8);
                        jVar.b(8);
                        i9 = i10 + 1;
                    }
                }
            }
            i2 = i3 + 1;
        }
    }

    public static boolean a(int i, m mVar, boolean z) {
        if (mVar.b() < 7) {
            if (z) {
                return false;
            }
            throw new o("too short header: " + mVar.b());
        } else if (mVar.g() != i) {
            if (z) {
                return false;
            }
            throw new o("expected header type " + Integer.toHexString(i));
        } else if (mVar.g() == 118 && mVar.g() == 111 && mVar.g() == 114 && mVar.g() == 98 && mVar.g() == 105 && mVar.g() == 115) {
            return true;
        } else {
            if (z) {
                return false;
            }
            throw new o("expected characters 'vorbis'");
        }
    }

    private static c[] a(j jVar) {
        int a2 = jVar.a(6) + 1;
        c[] cVarArr = new c[a2];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= a2) {
                return cVarArr;
            }
            cVarArr[i2] = new c(jVar.a(), jVar.a(16), jVar.a(16), jVar.a(8));
            i = i2 + 1;
        }
    }

    public static c[] a(m mVar, int i) {
        a(5, mVar, false);
        int g = mVar.g();
        j jVar = new j(mVar.f25496a);
        jVar.b(mVar.d() * 8);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= g + 1) {
                break;
            }
            d(jVar);
            i2 = i3 + 1;
        }
        int a2 = jVar.a(6);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= a2 + 1) {
                c(jVar);
                b(jVar);
                a(i, jVar);
                c[] a3 = a(jVar);
                if (jVar.a()) {
                    return a3;
                }
                throw new o("framing bit after modes not set as expected");
            } else if (jVar.a(16) != 0) {
                throw new o("placeholder of time domain transforms not zeroed out");
            } else {
                i4 = i5 + 1;
            }
        }
    }

    public static C0653b b(m mVar) {
        a(3, mVar, false);
        String e = mVar.e((int) mVar.n());
        int length = e.length();
        long n = mVar.n();
        String[] strArr = new String[(int) n];
        int i = length + 11 + 4;
        for (int i2 = 0; i2 < n; i2++) {
            strArr[i2] = mVar.e((int) mVar.n());
            i = i + 4 + strArr[i2].length();
        }
        if ((mVar.g() & 1) != 0) {
            return new C0653b(e, strArr, i + 1);
        }
        throw new o("framing bit expected to be set");
    }

    private static void b(j jVar) {
        int a2 = jVar.a(6);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= a2 + 1) {
                return;
            }
            if (jVar.a(16) > 2) {
                throw new o("residueType greater than 2 is not decodable");
            }
            jVar.b(24);
            jVar.b(24);
            jVar.b(24);
            int a3 = jVar.a(6) + 1;
            jVar.b(8);
            int[] iArr = new int[a3];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= a3) {
                    break;
                }
                iArr[i4] = ((jVar.a() ? jVar.a(5) : 0) * 8) + jVar.a(3);
                i3 = i4 + 1;
            }
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 < a3) {
                    int i7 = 0;
                    while (true) {
                        int i8 = i7;
                        if (i8 < 8) {
                            if ((iArr[i6] & (1 << i8)) != 0) {
                                jVar.b(8);
                            }
                            i7 = i8 + 1;
                        }
                    }
                    i5 = i6 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    private static void c(j jVar) {
        int a2 = jVar.a(6);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= a2 + 1) {
                return;
            }
            int a3 = jVar.a(16);
            if (a3 == 0) {
                jVar.b(8);
                jVar.b(16);
                jVar.b(16);
                jVar.b(6);
                jVar.b(8);
                int a4 = jVar.a(4);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < a4 + 1) {
                        jVar.b(8);
                        i3 = i4 + 1;
                    }
                }
            } else if (a3 != 1) {
                throw new o("floor type greater than 1 not decodable: " + a3);
            } else {
                int a5 = jVar.a(5);
                int i5 = -1;
                int[] iArr = new int[a5];
                int i6 = 0;
                while (i6 < a5) {
                    iArr[i6] = jVar.a(4);
                    int i7 = i5;
                    if (iArr[i6] > i5) {
                        i7 = iArr[i6];
                    }
                    i6++;
                    i5 = i7;
                }
                int i8 = i5 + 1;
                int[] iArr2 = new int[i8];
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    if (i10 >= i8) {
                        break;
                    }
                    iArr2[i10] = jVar.a(3) + 1;
                    int a6 = jVar.a(2);
                    if (a6 > 0) {
                        jVar.b(8);
                    }
                    int i11 = 0;
                    while (true) {
                        int i12 = i11;
                        if (i12 < (1 << a6)) {
                            jVar.b(8);
                            i11 = i12 + 1;
                        }
                    }
                    i9 = i10 + 1;
                }
                jVar.b(2);
                int a7 = jVar.a(4);
                int i13 = 0;
                int i14 = 0;
                for (int i15 = 0; i15 < a5; i15++) {
                    i13 += iArr2[iArr[i15]];
                    while (i14 < i13) {
                        jVar.b(a7);
                        i14++;
                    }
                }
            }
            i = i2 + 1;
        }
    }

    private static a d(j jVar) {
        if (jVar.a(24) != 5653314) {
            throw new o("expected code book to start with [0x56, 0x43, 0x42] at " + jVar.b());
        }
        int a2 = jVar.a(16);
        int a3 = jVar.a(24);
        long[] jArr = new long[a3];
        boolean a4 = jVar.a();
        long j = 0;
        if (a4) {
            int a5 = jVar.a(5) + 1;
            int i = 0;
            while (i < a3) {
                int a6 = jVar.a(a(a3 - i));
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < a6 && i < a3) {
                        jArr[i] = a5;
                        i++;
                        i2 = i3 + 1;
                    }
                }
                a5++;
            }
        } else {
            boolean a7 = jVar.a();
            for (int i4 = 0; i4 < a3; i4++) {
                if (!a7) {
                    jArr[i4] = jVar.a(5) + 1;
                } else if (jVar.a()) {
                    jArr[i4] = jVar.a(5) + 1;
                } else {
                    jArr[i4] = 0;
                }
            }
        }
        int a8 = jVar.a(4);
        if (a8 > 2) {
            throw new o("lookup type greater than 2 not decodable: " + a8);
        }
        if (a8 == 1 || a8 == 2) {
            jVar.b(32);
            jVar.b(32);
            int a9 = jVar.a(4);
            jVar.b(1);
            if (a8 != 1) {
                j = a3 * a2;
            } else if (a2 != 0) {
                j = a(a3, a2);
            }
            jVar.b((int) (j * (a9 + 1)));
        }
        return new a(a2, a3, jArr, a8, a4);
    }
}
