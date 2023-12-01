package com.anythink.expressad.exoplayer.e.a;

import android.util.Log;
import android.util.Pair;
import com.anythink.expressad.exoplayer.e.a.a;
import com.anythink.expressad.exoplayer.e.a.d;
import com.anythink.expressad.exoplayer.g.a;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.k.o;
import com.anythink.expressad.exoplayer.k.s;
import com.anythink.expressad.exoplayer.t;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/a/b.class */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4437a = "AtomParsers";
    private static final int b = af.f("vide");

    /* renamed from: c  reason: collision with root package name */
    private static final int f4438c = af.f("soun");
    private static final int d = af.f("text");
    private static final int e = af.f("sbtl");
    private static final int f = af.f("subt");
    private static final int g = af.f("clcp");
    private static final int h = af.f(TTDownloadField.TT_META);
    private static final int i = 3;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/a/b$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f4439a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public int f4440c;
        public long d;
        private final boolean e;
        private final s f;
        private final s g;
        private int h;
        private int i;

        public a(s sVar, s sVar2, boolean z) {
            this.g = sVar;
            this.f = sVar2;
            this.e = z;
            sVar2.c(12);
            this.f4439a = sVar2.m();
            sVar.c(12);
            this.i = sVar.m();
            com.anythink.expressad.exoplayer.k.a.b(sVar.i() != 1 ? false : true, "first_chunk must be 1");
            this.b = -1;
        }

        public final boolean a() {
            int i = this.b + 1;
            this.b = i;
            if (i == this.f4439a) {
                return false;
            }
            this.d = this.e ? this.f.n() : this.f.h();
            if (this.b == this.h) {
                this.f4440c = this.g.m();
                this.g.d(4);
                int i2 = this.i - 1;
                this.i = i2;
                this.h = i2 > 0 ? this.g.m() - 1 : -1;
                return true;
            }
            return true;
        }
    }

    /* renamed from: com.anythink.expressad.exoplayer.e.a.b$b  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/a/b$b.class */
    interface InterfaceC0055b {
        int a();

        int b();

        boolean c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/a/b$c.class */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public static final int f4441a = 8;
        public final k[] b;

        /* renamed from: c  reason: collision with root package name */
        public com.anythink.expressad.exoplayer.m f4442c;
        public int d;
        public int e = 0;

        public c(int i) {
            this.b = new k[i];
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/a/b$d.class */
    static final class d implements InterfaceC0055b {

        /* renamed from: a  reason: collision with root package name */
        private final int f4443a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final s f4444c;

        public d(a.b bVar) {
            s sVar = bVar.aV;
            this.f4444c = sVar;
            sVar.c(12);
            this.f4443a = this.f4444c.m();
            this.b = this.f4444c.m();
        }

        @Override // com.anythink.expressad.exoplayer.e.a.b.InterfaceC0055b
        public final int a() {
            return this.b;
        }

        @Override // com.anythink.expressad.exoplayer.e.a.b.InterfaceC0055b
        public final int b() {
            int i = this.f4443a;
            int i2 = i;
            if (i == 0) {
                i2 = this.f4444c.m();
            }
            return i2;
        }

        @Override // com.anythink.expressad.exoplayer.e.a.b.InterfaceC0055b
        public final boolean c() {
            return this.f4443a != 0;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/a/b$e.class */
    static final class e implements InterfaceC0055b {

        /* renamed from: a  reason: collision with root package name */
        private final s f4445a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final int f4446c;
        private int d;
        private int e;

        public e(a.b bVar) {
            s sVar = bVar.aV;
            this.f4445a = sVar;
            sVar.c(12);
            this.f4446c = this.f4445a.m() & 255;
            this.b = this.f4445a.m();
        }

        @Override // com.anythink.expressad.exoplayer.e.a.b.InterfaceC0055b
        public final int a() {
            return this.b;
        }

        @Override // com.anythink.expressad.exoplayer.e.a.b.InterfaceC0055b
        public final int b() {
            int i = this.f4446c;
            if (i == 8) {
                return this.f4445a.d();
            }
            if (i == 16) {
                return this.f4445a.e();
            }
            int i2 = this.d;
            this.d = i2 + 1;
            if (i2 % 2 == 0) {
                int d = this.f4445a.d();
                this.e = d;
                return (d & 240) >> 4;
            }
            return this.e & 15;
        }

        @Override // com.anythink.expressad.exoplayer.e.a.b.InterfaceC0055b
        public final boolean c() {
            return false;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/a/b$f.class */
    static final class f {

        /* renamed from: a  reason: collision with root package name */
        private final int f4447a;
        private final long b;

        /* renamed from: c  reason: collision with root package name */
        private final int f4448c;

        public f(int i, long j, int i2) {
            this.f4447a = i;
            this.b = j;
            this.f4448c = i2;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/a/b$g.class */
    public static final class g extends t {
    }

    private b() {
    }

    private static int a(s sVar, int i2, int i3) {
        int c2 = sVar.c();
        while (true) {
            int i4 = c2;
            if (i4 - i2 >= i3) {
                return -1;
            }
            sVar.c(i4);
            int i5 = sVar.i();
            com.anythink.expressad.exoplayer.k.a.a(i5 > 0, "childAtomSize should be positive");
            if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.O) {
                return i4;
            }
            c2 = i4 + i5;
        }
    }

    private static long a(s sVar) {
        int i2 = 8;
        sVar.c(8);
        if (com.anythink.expressad.exoplayer.e.a.a.a(sVar.i()) != 0) {
            i2 = 16;
        }
        sVar.d(i2);
        return sVar.h();
    }

    private static Pair<long[], long[]> a(a.C0054a c0054a) {
        a.b d2;
        if (c0054a == null || (d2 = c0054a.d(com.anythink.expressad.exoplayer.e.a.a.V)) == null) {
            return Pair.create(null, null);
        }
        s sVar = d2.aV;
        sVar.c(8);
        int a2 = com.anythink.expressad.exoplayer.e.a.a.a(sVar.i());
        int m = sVar.m();
        long[] jArr = new long[m];
        long[] jArr2 = new long[m];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= m) {
                return Pair.create(jArr, jArr2);
            }
            jArr[i3] = a2 == 1 ? sVar.n() : sVar.h();
            jArr2[i3] = a2 == 1 ? sVar.j() : sVar.i();
            if (sVar.f() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            sVar.d(2);
            i2 = i3 + 1;
        }
    }

    private static c a(s sVar, int i2, int i3, String str, com.anythink.expressad.exoplayer.d.e eVar, boolean z) {
        com.anythink.expressad.exoplayer.d.e eVar2;
        int i4;
        int i5;
        boolean z2;
        String str2;
        List<byte[]> list;
        float f2;
        byte[] bArr;
        int i6;
        byte[] bArr2;
        List<byte[]> list2;
        String str3;
        com.anythink.expressad.exoplayer.d.e eVar3;
        int i7;
        int e2;
        int i8;
        com.anythink.expressad.exoplayer.d.e eVar4;
        int i9;
        String str4;
        List list3;
        long j;
        sVar.c(12);
        int i10 = sVar.i();
        c cVar = new c(i10);
        int i11 = 0;
        while (true) {
            int i12 = i11;
            if (i12 >= i10) {
                return cVar;
            }
            int c2 = sVar.c();
            int i13 = sVar.i();
            com.anythink.expressad.exoplayer.k.a.a(i13 > 0, "childAtomSize should be positive");
            int i14 = sVar.i();
            com.anythink.expressad.exoplayer.d.e eVar5 = null;
            if (i14 == com.anythink.expressad.exoplayer.e.a.a.g || i14 == com.anythink.expressad.exoplayer.e.a.a.h || i14 == com.anythink.expressad.exoplayer.e.a.a.ae || i14 == com.anythink.expressad.exoplayer.e.a.a.aq || i14 == com.anythink.expressad.exoplayer.e.a.a.i || i14 == com.anythink.expressad.exoplayer.e.a.a.j || i14 == com.anythink.expressad.exoplayer.e.a.a.k || i14 == com.anythink.expressad.exoplayer.e.a.a.aP || i14 == com.anythink.expressad.exoplayer.e.a.a.aQ) {
                sVar.c(c2 + 8 + 8);
                sVar.d(16);
                int e3 = sVar.e();
                int e4 = sVar.e();
                sVar.d(50);
                int c3 = sVar.c();
                if (i14 == com.anythink.expressad.exoplayer.e.a.a.ae) {
                    Pair<Integer, k> b2 = b(sVar, c2, i13);
                    if (b2 != null) {
                        i14 = b2.first.intValue();
                        eVar3 = eVar == null ? null : eVar.a(b2.second.b);
                        cVar.b[i12] = b2.second;
                    } else {
                        eVar3 = eVar;
                    }
                    sVar.c(c3);
                    i4 = i14;
                    eVar2 = eVar3;
                } else {
                    eVar2 = eVar;
                    i4 = i14;
                }
                String str5 = null;
                List<byte[]> list4 = null;
                byte[] bArr3 = null;
                boolean z3 = false;
                float f3 = 1.0f;
                int i15 = -1;
                while (true) {
                    i5 = i15;
                    if (c3 - c2 >= i13) {
                        break;
                    }
                    sVar.c(c3);
                    int c4 = sVar.c();
                    int i16 = sVar.i();
                    if (i16 == 0 && sVar.c() - c2 == i13) {
                        break;
                    }
                    com.anythink.expressad.exoplayer.k.a.a(i16 > 0, "childAtomSize should be positive");
                    int i17 = sVar.i();
                    if (i17 == com.anythink.expressad.exoplayer.e.a.a.M) {
                        com.anythink.expressad.exoplayer.k.a.b(str5 == null);
                        sVar.c(c4 + 8);
                        com.anythink.expressad.exoplayer.l.a a2 = com.anythink.expressad.exoplayer.l.a.a(sVar);
                        list2 = a2.f4852a;
                        cVar.d = a2.b;
                        if (!z3) {
                            f3 = a2.e;
                        }
                        str3 = "video/avc";
                    } else if (i17 == com.anythink.expressad.exoplayer.e.a.a.N) {
                        com.anythink.expressad.exoplayer.k.a.b(str5 == null);
                        sVar.c(c4 + 8);
                        com.anythink.expressad.exoplayer.l.d a3 = com.anythink.expressad.exoplayer.l.d.a(sVar);
                        list2 = a3.f4860a;
                        cVar.d = a3.b;
                        str3 = "video/hevc";
                    } else {
                        if (i17 == com.anythink.expressad.exoplayer.e.a.a.aR) {
                            com.anythink.expressad.exoplayer.k.a.b(str5 == null);
                            str2 = i4 == com.anythink.expressad.exoplayer.e.a.a.aP ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                        } else if (i17 == com.anythink.expressad.exoplayer.e.a.a.l) {
                            com.anythink.expressad.exoplayer.k.a.b(str5 == null);
                            str2 = "video/3gpp";
                        } else {
                            if (i17 == com.anythink.expressad.exoplayer.e.a.a.O) {
                                com.anythink.expressad.exoplayer.k.a.b(str5 == null);
                                Pair<String, byte[]> d2 = d(sVar, c4);
                                str2 = d2.first;
                                list = Collections.singletonList(d2.second);
                                z2 = z3;
                                f2 = f3;
                                bArr = bArr3;
                            } else if (i17 == com.anythink.expressad.exoplayer.e.a.a.an) {
                                sVar.c(c4 + 8);
                                f2 = sVar.m() / sVar.m();
                                z2 = true;
                                str2 = str5;
                                list = list4;
                                bArr = bArr3;
                            } else if (i17 == com.anythink.expressad.exoplayer.e.a.a.aN) {
                                int i18 = c4;
                                int i19 = 8;
                                while (true) {
                                    int i20 = i18 + i19;
                                    if (i20 - c4 >= i16) {
                                        bArr2 = null;
                                        break;
                                    }
                                    sVar.c(i20);
                                    int i21 = sVar.i();
                                    if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.aO) {
                                        bArr2 = Arrays.copyOfRange(sVar.f4835a, i20, i21 + i20);
                                        break;
                                    }
                                    i18 = i20;
                                    i19 = i21;
                                }
                                bArr = bArr2;
                                z2 = z3;
                                str2 = str5;
                                list = list4;
                                f2 = f3;
                            } else {
                                z2 = z3;
                                str2 = str5;
                                list = list4;
                                f2 = f3;
                                bArr = bArr3;
                                if (i17 == com.anythink.expressad.exoplayer.e.a.a.aM) {
                                    int d3 = sVar.d();
                                    sVar.d(3);
                                    z2 = z3;
                                    str2 = str5;
                                    list = list4;
                                    f2 = f3;
                                    bArr = bArr3;
                                    if (d3 == 0) {
                                        int d4 = sVar.d();
                                        if (d4 == 0) {
                                            i6 = 0;
                                            list = list4;
                                            str2 = str5;
                                        } else if (d4 == 1) {
                                            i6 = 1;
                                            str2 = str5;
                                            list = list4;
                                        } else if (d4 == 2) {
                                            i6 = 2;
                                            str2 = str5;
                                            list = list4;
                                        } else if (d4 != 3) {
                                            str2 = str5;
                                            list = list4;
                                            i6 = i5;
                                        } else {
                                            i6 = 3;
                                            str2 = str5;
                                            list = list4;
                                        }
                                        c3 += i16;
                                        str5 = str2;
                                        list4 = list;
                                        i15 = i6;
                                    }
                                }
                            }
                            z3 = z2;
                            f3 = f2;
                            bArr3 = bArr;
                            i6 = i5;
                            c3 += i16;
                            str5 = str2;
                            list4 = list;
                            i15 = i6;
                        }
                        z2 = z3;
                        list = list4;
                        f2 = f3;
                        bArr = bArr3;
                        z3 = z2;
                        f3 = f2;
                        bArr3 = bArr;
                        i6 = i5;
                        c3 += i16;
                        str5 = str2;
                        list4 = list;
                        i15 = i6;
                    }
                    String str6 = str3;
                    bArr = bArr3;
                    f2 = f3;
                    list = list2;
                    str2 = str6;
                    z2 = z3;
                    z3 = z2;
                    f3 = f2;
                    bArr3 = bArr;
                    i6 = i5;
                    c3 += i16;
                    str5 = str2;
                    list4 = list;
                    i15 = i6;
                }
                if (str5 != null) {
                    cVar.f4442c = com.anythink.expressad.exoplayer.m.a(Integer.toString(i2), str5, null, -1, -1, e3, e4, -1.0f, list4, i3, f3, bArr3, i5, null, eVar2);
                }
            } else if (i14 == com.anythink.expressad.exoplayer.e.a.a.n || i14 == com.anythink.expressad.exoplayer.e.a.a.af || i14 == com.anythink.expressad.exoplayer.e.a.a.s || i14 == com.anythink.expressad.exoplayer.e.a.a.u || i14 == com.anythink.expressad.exoplayer.e.a.a.w || i14 == com.anythink.expressad.exoplayer.e.a.a.z || i14 == com.anythink.expressad.exoplayer.e.a.a.x || i14 == com.anythink.expressad.exoplayer.e.a.a.y || i14 == com.anythink.expressad.exoplayer.e.a.a.aD || i14 == com.anythink.expressad.exoplayer.e.a.a.aE || i14 == com.anythink.expressad.exoplayer.e.a.a.q || i14 == com.anythink.expressad.exoplayer.e.a.a.r || i14 == com.anythink.expressad.exoplayer.e.a.a.o || i14 == com.anythink.expressad.exoplayer.e.a.a.aT) {
                sVar.c(c2 + 8 + 8);
                if (z) {
                    i7 = sVar.e();
                    sVar.d(6);
                } else {
                    sVar.d(8);
                    i7 = 0;
                }
                if (i7 == 0 || i7 == 1) {
                    e2 = sVar.e();
                    sVar.d(6);
                    int k = sVar.k();
                    if (i7 == 1) {
                        sVar.d(16);
                    }
                    i8 = k;
                } else if (i7 == 2) {
                    sVar.d(16);
                    i8 = (int) Math.round(Double.longBitsToDouble(sVar.j()));
                    e2 = sVar.m();
                    sVar.d(20);
                }
                int c5 = sVar.c();
                if (i14 == com.anythink.expressad.exoplayer.e.a.a.af) {
                    Pair<Integer, k> b3 = b(sVar, c2, i13);
                    if (b3 != null) {
                        i14 = b3.first.intValue();
                        if (eVar != null) {
                            eVar5 = eVar.a(b3.second.b);
                        }
                        cVar.b[i12] = b3.second;
                    } else {
                        eVar5 = eVar;
                    }
                    sVar.c(c5);
                    eVar4 = eVar5;
                } else {
                    eVar4 = eVar;
                }
                String str7 = i14 == com.anythink.expressad.exoplayer.e.a.a.s ? "audio/ac3" : i14 == com.anythink.expressad.exoplayer.e.a.a.u ? "audio/eac3" : i14 == com.anythink.expressad.exoplayer.e.a.a.w ? o.D : (i14 == com.anythink.expressad.exoplayer.e.a.a.x || i14 == com.anythink.expressad.exoplayer.e.a.a.y) ? o.E : i14 == com.anythink.expressad.exoplayer.e.a.a.z ? o.F : i14 == com.anythink.expressad.exoplayer.e.a.a.aD ? "audio/3gpp" : i14 == com.anythink.expressad.exoplayer.e.a.a.aE ? "audio/amr-wb" : (i14 == com.anythink.expressad.exoplayer.e.a.a.q || i14 == com.anythink.expressad.exoplayer.e.a.a.r) ? "audio/raw" : i14 == com.anythink.expressad.exoplayer.e.a.a.o ? "audio/mpeg" : i14 == com.anythink.expressad.exoplayer.e.a.a.aT ? o.L : null;
                int i22 = c5;
                byte[] bArr4 = null;
                com.anythink.expressad.exoplayer.d.e eVar6 = eVar4;
                while (i22 - c2 < i13) {
                    sVar.c(i22);
                    int i23 = sVar.i();
                    com.anythink.expressad.exoplayer.k.a.a(i23 > 0, "childAtomSize should be positive");
                    int i24 = sVar.i();
                    if (i24 == com.anythink.expressad.exoplayer.e.a.a.O || (z && i24 == com.anythink.expressad.exoplayer.e.a.a.p)) {
                        if (i24 != com.anythink.expressad.exoplayer.e.a.a.O) {
                            int c6 = sVar.c();
                            while (true) {
                                i9 = c6;
                                if (i9 - i22 >= i23) {
                                    i9 = -1;
                                    break;
                                }
                                sVar.c(i9);
                                int i25 = sVar.i();
                                com.anythink.expressad.exoplayer.k.a.a(i25 > 0, "childAtomSize should be positive");
                                if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.O) {
                                    break;
                                }
                                c6 = i9 + i25;
                            }
                        } else {
                            i9 = i22;
                        }
                        if (i9 != -1) {
                            Pair<String, byte[]> d5 = d(sVar, i9);
                            String str8 = d5.first;
                            byte[] bArr5 = d5.second;
                            str7 = str8;
                            bArr4 = bArr5;
                            if ("audio/mp4a-latm".equals(str8)) {
                                Pair<Integer, Integer> a4 = com.anythink.expressad.exoplayer.k.d.a(bArr5);
                                i8 = a4.first.intValue();
                                e2 = a4.second.intValue();
                                str7 = str8;
                                bArr4 = bArr5;
                            }
                        }
                    } else if (i24 == com.anythink.expressad.exoplayer.e.a.a.t) {
                        sVar.c(i22 + 8);
                        cVar.f4442c = com.anythink.expressad.exoplayer.b.a.a(sVar, Integer.toString(i2), str, eVar6);
                    } else if (i24 == com.anythink.expressad.exoplayer.e.a.a.v) {
                        sVar.c(i22 + 8);
                        cVar.f4442c = com.anythink.expressad.exoplayer.b.a.b(sVar, Integer.toString(i2), str, eVar6);
                    } else if (i24 == com.anythink.expressad.exoplayer.e.a.a.A) {
                        cVar.f4442c = com.anythink.expressad.exoplayer.m.a(Integer.toString(i2), str7, null, -1, e2, i8, null, eVar6, str);
                    } else if (i24 == com.anythink.expressad.exoplayer.e.a.a.aT) {
                        bArr4 = new byte[i23];
                        sVar.c(i22);
                        sVar.a(bArr4, 0, i23);
                    }
                    i22 += i23;
                }
                if (cVar.f4442c == null && str7 != null) {
                    cVar.f4442c = com.anythink.expressad.exoplayer.m.a(Integer.toString(i2), str7, (String) null, -1, e2, i8, "audio/raw".equals(str7) ? 2 : -1, bArr4 == null ? null : Collections.singletonList(bArr4), eVar6, str);
                }
            } else if (i14 == com.anythink.expressad.exoplayer.e.a.a.ao || i14 == com.anythink.expressad.exoplayer.e.a.a.az || i14 == com.anythink.expressad.exoplayer.e.a.a.aA || i14 == com.anythink.expressad.exoplayer.e.a.a.aB || i14 == com.anythink.expressad.exoplayer.e.a.a.aC) {
                sVar.c(c2 + 8 + 8);
                if (i14 == com.anythink.expressad.exoplayer.e.a.a.ao) {
                    list3 = null;
                    str4 = o.Z;
                } else if (i14 == com.anythink.expressad.exoplayer.e.a.a.az) {
                    int i26 = (i13 - 8) - 8;
                    byte[] bArr6 = new byte[i26];
                    sVar.a(bArr6, 0, i26);
                    list3 = Collections.singletonList(bArr6);
                    str4 = o.aa;
                } else {
                    if (i14 == com.anythink.expressad.exoplayer.e.a.a.aA) {
                        str4 = o.ab;
                    } else if (i14 == com.anythink.expressad.exoplayer.e.a.a.aB) {
                        list3 = null;
                        str4 = o.Z;
                        j = 0;
                        cVar.f4442c = com.anythink.expressad.exoplayer.m.a(Integer.toString(i2), str4, (String) null, -1, 0, str, -1, (com.anythink.expressad.exoplayer.d.e) null, j, list3);
                    } else if (i14 != com.anythink.expressad.exoplayer.e.a.a.aC) {
                        throw new IllegalStateException();
                    } else {
                        cVar.e = 1;
                        str4 = o.ac;
                    }
                    list3 = null;
                }
                j = Long.MAX_VALUE;
                cVar.f4442c = com.anythink.expressad.exoplayer.m.a(Integer.toString(i2), str4, (String) null, -1, 0, str, -1, (com.anythink.expressad.exoplayer.d.e) null, j, list3);
            } else if (i14 == com.anythink.expressad.exoplayer.e.a.a.aS) {
                cVar.f4442c = com.anythink.expressad.exoplayer.m.a(Integer.toString(i2), o.ah, (String) null, (com.anythink.expressad.exoplayer.d.e) null);
            }
            sVar.c(c2 + i13);
            i11 = i12 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0142, code lost:
        if (r33 == 0) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.anythink.expressad.exoplayer.e.a.j a(com.anythink.expressad.exoplayer.e.a.a.C0054a r17, com.anythink.expressad.exoplayer.e.a.a.b r18, long r19, com.anythink.expressad.exoplayer.d.e r21, boolean r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 895
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.e.a.b.a(com.anythink.expressad.exoplayer.e.a.a$a, com.anythink.expressad.exoplayer.e.a.a$b, long, com.anythink.expressad.exoplayer.d.e, boolean, boolean):com.anythink.expressad.exoplayer.e.a.j");
    }

    private static k a(s sVar, int i2, int i3, String str) {
        int i4;
        int i5;
        int i6 = i2;
        int i7 = 8;
        while (true) {
            int i8 = i6 + i7;
            if (i8 - i2 >= i3) {
                return null;
            }
            sVar.c(i8);
            int i9 = sVar.i();
            if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.ad) {
                int a2 = com.anythink.expressad.exoplayer.e.a.a.a(sVar.i());
                sVar.d(1);
                if (a2 == 0) {
                    sVar.d(1);
                    i5 = 0;
                    i4 = 0;
                } else {
                    int d2 = sVar.d();
                    i4 = d2 & 15;
                    i5 = (d2 & 240) >> 4;
                }
                boolean z = sVar.d() == 1;
                int d3 = sVar.d();
                byte[] bArr = new byte[16];
                sVar.a(bArr, 0, 16);
                byte[] bArr2 = null;
                if (z) {
                    bArr2 = null;
                    if (d3 == 0) {
                        int d4 = sVar.d();
                        bArr2 = new byte[d4];
                        sVar.a(bArr2, 0, d4);
                    }
                }
                return new k(z, str, d3, bArr, i5, i4, bArr2);
            }
            i6 = i8;
            i7 = i9;
        }
    }

    public static m a(j jVar, a.C0054a c0054a, com.anythink.expressad.exoplayer.e.i iVar) {
        InterfaceC0055b eVar;
        boolean z;
        int i2;
        s sVar;
        int i3;
        long[] jArr;
        int[] iArr;
        int i4;
        long[] jArr2;
        int[] iArr2;
        long j;
        a.b d2 = c0054a.d(com.anythink.expressad.exoplayer.e.a.a.av);
        if (d2 != null) {
            eVar = new d(d2);
        } else {
            a.b d3 = c0054a.d(com.anythink.expressad.exoplayer.e.a.a.aw);
            if (d3 == null) {
                throw new t("Track has no sample table size information");
            }
            eVar = new e(d3);
        }
        int a2 = eVar.a();
        if (a2 == 0) {
            return new m(jVar, new long[0], new int[0], 0, new long[0], new int[0], com.anythink.expressad.exoplayer.b.b);
        }
        a.b d4 = c0054a.d(com.anythink.expressad.exoplayer.e.a.a.ax);
        if (d4 == null) {
            d4 = c0054a.d(com.anythink.expressad.exoplayer.e.a.a.ay);
            z = true;
        } else {
            z = false;
        }
        s sVar2 = d4.aV;
        s sVar3 = c0054a.d(com.anythink.expressad.exoplayer.e.a.a.au).aV;
        s sVar4 = c0054a.d(com.anythink.expressad.exoplayer.e.a.a.f4435ar).aV;
        a.b d5 = c0054a.d(com.anythink.expressad.exoplayer.e.a.a.as);
        s sVar5 = d5 != null ? d5.aV : null;
        a.b d6 = c0054a.d(com.anythink.expressad.exoplayer.e.a.a.at);
        s sVar6 = d6 != null ? d6.aV : null;
        a aVar = new a(sVar3, sVar2, z);
        sVar4.c(12);
        int m = sVar4.m() - 1;
        int m2 = sVar4.m();
        int m3 = sVar4.m();
        if (sVar6 != null) {
            sVar6.c(12);
            i2 = sVar6.m();
        } else {
            i2 = 0;
        }
        int i5 = -1;
        if (sVar5 != null) {
            sVar5.c(12);
            int m4 = sVar5.m();
            i3 = m4;
            sVar = null;
            if (m4 > 0) {
                i5 = sVar5.m() - 1;
                sVar = sVar5;
                i3 = m4;
            }
        } else {
            sVar = sVar5;
            i3 = 0;
        }
        if (eVar.c() && "audio/raw".equals(jVar.h.h) && m == 0 && i2 == 0 && i3 == 0) {
            long[] jArr3 = new long[aVar.f4439a];
            int[] iArr3 = new int[aVar.f4439a];
            while (aVar.a()) {
                jArr3[aVar.b] = aVar.d;
                iArr3[aVar.b] = aVar.f4440c;
            }
            d.a a3 = com.anythink.expressad.exoplayer.e.a.d.a(af.b(jVar.h.w, jVar.h.u), jArr3, iArr3, m3);
            jArr = a3.f4452a;
            iArr = a3.b;
            i4 = a3.f4453c;
            jArr2 = a3.d;
            iArr2 = a3.e;
            j = a3.f;
        } else {
            jArr = new long[a2];
            int[] iArr4 = new int[a2];
            long[] jArr4 = new long[a2];
            int[] iArr5 = new int[a2];
            long j2 = 0;
            long j3 = 0;
            int i6 = m;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = i3;
            int i11 = 0;
            int i12 = i5;
            int i13 = 0;
            while (i7 < a2) {
                int i14 = m2;
                while (i9 == 0) {
                    com.anythink.expressad.exoplayer.k.a.b(aVar.a());
                    j3 = aVar.d;
                    i9 = aVar.f4440c;
                }
                int i15 = i6;
                int i16 = i2;
                int i17 = i8;
                int i18 = i11;
                if (sVar6 != null) {
                    while (i8 == 0 && i2 > 0) {
                        i8 = sVar6.m();
                        i11 = sVar6.i();
                        i2--;
                    }
                    i17 = i8 - 1;
                    i18 = i11;
                    i16 = i2;
                }
                jArr[i7] = j3;
                iArr4[i7] = eVar.b();
                int i19 = i13;
                if (iArr4[i7] > i13) {
                    i19 = iArr4[i7];
                }
                jArr4[i7] = j2 + i18;
                iArr5[i7] = sVar == null ? 1 : 0;
                int i20 = i10;
                int i21 = i12;
                if (i7 == i12) {
                    iArr5[i7] = 1;
                    int i22 = i10 - 1;
                    i20 = i22;
                    i21 = i12;
                    if (i22 > 0) {
                        i21 = sVar.m() - 1;
                        i20 = i22;
                    }
                }
                j2 += m3;
                int i23 = i14 - 1;
                int i24 = m3;
                int i25 = i23;
                int i26 = i15;
                if (i23 == 0) {
                    i24 = m3;
                    i25 = i23;
                    i26 = i15;
                    if (i15 > 0) {
                        i25 = sVar4.m();
                        i24 = sVar4.i();
                        i26 = i15 - 1;
                    }
                }
                j3 += iArr4[i7];
                i9--;
                i7++;
                m2 = i25;
                i11 = i18;
                m3 = i24;
                i10 = i20;
                i13 = i19;
                i12 = i21;
                i6 = i26;
                i2 = i16;
                i8 = i17;
            }
            j = j2 + i11;
            com.anythink.expressad.exoplayer.k.a.a(i8 == 0);
            while (i2 > 0) {
                com.anythink.expressad.exoplayer.k.a.a(sVar6.m() == 0);
                sVar6.i();
                i2--;
            }
            if (i10 != 0 || m2 != 0 || i9 != 0 || i6 != 0) {
                Log.w(f4437a, "Inconsistent stbl box for track " + jVar.f4466c + ": remainingSynchronizationSamples " + i10 + ", remainingSamplesAtTimestampDelta " + m2 + ", remainingSamplesInChunk " + i9 + ", remainingTimestampDeltaChanges " + i6);
            }
            iArr = iArr4;
            jArr2 = jArr4;
            i4 = i13;
            iArr2 = iArr5;
        }
        long a4 = af.a(j, 1000000L, jVar.e);
        if (jVar.j == null || iVar.a()) {
            af.a(jArr2, jVar.e);
            return new m(jVar, jArr, iArr, i4, jArr2, iArr2, a4);
        }
        if (jVar.j.length == 1 && jVar.d == 1 && jArr2.length >= 2) {
            long j4 = jVar.k[0];
            long a5 = j4 + af.a(jVar.j[0], jVar.e, jVar.f);
            int length = jArr2.length - 1;
            if (jArr2[0] <= j4 && j4 < jArr2[af.a(3, 0, length)] && jArr2[af.a(jArr2.length - 3, 0, length)] < a5 && a5 <= j) {
                long a6 = af.a(j4 - jArr2[0], jVar.h.v, jVar.e);
                long a7 = af.a(j - a5, jVar.h.v, jVar.e);
                if ((a6 != 0 || a7 != 0) && a6 <= 2147483647L && a7 <= 2147483647L) {
                    iVar.b = (int) a6;
                    iVar.f4480c = (int) a7;
                    af.a(jArr2, jVar.e);
                    return new m(jVar, jArr, iArr, i4, jArr2, iArr2, a4);
                }
            }
        }
        if (jVar.j.length != 1 || jVar.j[0] != 0) {
            boolean z2 = jVar.d == 1;
            boolean z3 = false;
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            while (true) {
                int i30 = i29;
                if (i30 >= jVar.j.length) {
                    break;
                }
                long j5 = jVar.k[i30];
                if (j5 != -1) {
                    long a8 = af.a(jVar.j[i30], jVar.e, jVar.f);
                    int a9 = af.a(jArr2, j5, true, true);
                    int a10 = af.a(jArr2, j5 + a8, z2, false);
                    int i31 = i27 + (a10 - a9);
                    z3 |= i28 != a9;
                    i28 = a10;
                    i27 = i31;
                }
                i29 = i30 + 1;
            }
            boolean z4 = z3 | (i27 != a2);
            long[] jArr5 = z4 ? new long[i27] : jArr;
            int[] iArr6 = z4 ? new int[i27] : iArr;
            if (z4) {
                i4 = 0;
            }
            int[] iArr7 = z4 ? new int[i27] : iArr2;
            long[] jArr6 = new long[i27];
            int i32 = 0;
            int[] iArr8 = iArr;
            long j6 = 0;
            for (int i33 = 0; i33 < jVar.j.length; i33++) {
                long j7 = jVar.k[i33];
                long j8 = jVar.j[i33];
                if (j7 != -1) {
                    long a11 = af.a(j8, jVar.e, jVar.f);
                    int a12 = af.a(jArr2, j7, true, true);
                    int a13 = af.a(jArr2, a11 + j7, z2, false);
                    if (z4) {
                        int i34 = a13 - a12;
                        System.arraycopy(jArr, a12, jArr5, i32, i34);
                        System.arraycopy(iArr8, a12, iArr6, i32, i34);
                        System.arraycopy(iArr2, a12, iArr7, i32, i34);
                    }
                    if (a12 < a13 && (iArr7[i32] & 1) == 0) {
                        Log.w(f4437a, "Ignoring edit list: edit does not start with a sync sample.");
                        throw new g();
                    }
                    while (a12 < a13) {
                        jArr6[i32] = af.a(j6, 1000000L, jVar.f) + af.a(jArr2[a12] - j7, 1000000L, jVar.e);
                        int i35 = i4;
                        if (z4) {
                            i35 = i4;
                            if (iArr6[i32] > i4) {
                                i35 = iArr8[a12];
                            }
                        }
                        i32++;
                        a12++;
                        i4 = i35;
                    }
                }
                j6 += j8;
            }
            return new m(jVar, jArr5, iArr6, i4, jArr6, iArr7, af.a(j6, 1000000L, jVar.e));
        }
        long j9 = jVar.k[0];
        int i36 = 0;
        while (true) {
            int i37 = i36;
            if (i37 >= jArr2.length) {
                return new m(jVar, jArr, iArr, i4, jArr2, iArr2, af.a(j - j9, 1000000L, jVar.e));
            }
            jArr2[i37] = af.a(jArr2[i37] - j9, 1000000L, jVar.e);
            i36 = i37 + 1;
        }
    }

    public static com.anythink.expressad.exoplayer.g.a a(a.b bVar, boolean z) {
        if (z) {
            return null;
        }
        s sVar = bVar.aV;
        sVar.c(8);
        while (sVar.a() >= 8) {
            int c2 = sVar.c();
            int i2 = sVar.i();
            if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.aG) {
                sVar.c(c2);
                sVar.d(12);
                while (sVar.c() < c2 + i2) {
                    int c3 = sVar.c();
                    int i3 = sVar.i();
                    if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.aH) {
                        sVar.c(c3);
                        sVar.d(8);
                        ArrayList arrayList = new ArrayList();
                        while (sVar.c() < c3 + i3) {
                            a.InterfaceC0058a a2 = com.anythink.expressad.exoplayer.e.a.f.a(sVar);
                            if (a2 != null) {
                                arrayList.add(a2);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            return null;
                        }
                        return new com.anythink.expressad.exoplayer.g.a(arrayList);
                    }
                    sVar.d(i3 - 8);
                }
                return null;
            }
            sVar.d(i2 - 8);
        }
        return null;
    }

    private static com.anythink.expressad.exoplayer.g.a a(s sVar, int i2) {
        sVar.d(12);
        while (sVar.c() < i2) {
            int c2 = sVar.c();
            int i3 = sVar.i();
            if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.aH) {
                sVar.c(c2);
                sVar.d(8);
                ArrayList arrayList = new ArrayList();
                while (sVar.c() < c2 + i3) {
                    a.InterfaceC0058a a2 = com.anythink.expressad.exoplayer.e.a.f.a(sVar);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                return new com.anythink.expressad.exoplayer.g.a(arrayList);
            }
            sVar.d(i3 - 8);
        }
        return null;
    }

    private static void a(s sVar, int i2, int i3, int i4, int i5, int i6, com.anythink.expressad.exoplayer.d.e eVar, c cVar, int i7) {
        String str;
        boolean z;
        List<byte[]> list;
        float f2;
        byte[] bArr;
        int i8;
        sVar.c(i3 + 8 + 8);
        sVar.d(16);
        int e2 = sVar.e();
        int e3 = sVar.e();
        sVar.d(50);
        int c2 = sVar.c();
        com.anythink.expressad.exoplayer.d.e eVar2 = eVar;
        int i9 = i2;
        if (i2 == com.anythink.expressad.exoplayer.e.a.a.ae) {
            Pair<Integer, k> b2 = b(sVar, i3, i4);
            com.anythink.expressad.exoplayer.d.e eVar3 = eVar;
            if (b2 != null) {
                i2 = b2.first.intValue();
                eVar3 = eVar == null ? null : eVar.a(b2.second.b);
                cVar.b[i7] = b2.second;
            }
            sVar.c(c2);
            i9 = i2;
            eVar2 = eVar3;
        }
        String str2 = null;
        boolean z2 = false;
        List<byte[]> list2 = null;
        float f3 = 1.0f;
        byte[] bArr2 = null;
        int i10 = -1;
        int i11 = c2;
        while (i11 - i3 < i4) {
            sVar.c(i11);
            int c3 = sVar.c();
            int i12 = sVar.i();
            if (i12 == 0 && sVar.c() - i3 == i4) {
                break;
            }
            com.anythink.expressad.exoplayer.k.a.a(i12 > 0, "childAtomSize should be positive");
            int i13 = sVar.i();
            if (i13 == com.anythink.expressad.exoplayer.e.a.a.M) {
                com.anythink.expressad.exoplayer.k.a.b(str2 == null);
                sVar.c(c3 + 8);
                com.anythink.expressad.exoplayer.l.a a2 = com.anythink.expressad.exoplayer.l.a.a(sVar);
                list = a2.f4852a;
                cVar.d = a2.b;
                if (!z2) {
                    f3 = a2.e;
                }
                str = "video/avc";
                z = z2;
                f2 = f3;
                bArr = bArr2;
                i8 = i10;
            } else if (i13 == com.anythink.expressad.exoplayer.e.a.a.N) {
                com.anythink.expressad.exoplayer.k.a.b(str2 == null);
                sVar.c(c3 + 8);
                com.anythink.expressad.exoplayer.l.d a3 = com.anythink.expressad.exoplayer.l.d.a(sVar);
                list = a3.f4860a;
                cVar.d = a3.b;
                str = "video/hevc";
                z = z2;
                f2 = f3;
                bArr = bArr2;
                i8 = i10;
            } else if (i13 == com.anythink.expressad.exoplayer.e.a.a.aR) {
                com.anythink.expressad.exoplayer.k.a.b(str2 == null);
                if (i9 == com.anythink.expressad.exoplayer.e.a.a.aP) {
                    str = "video/x-vnd.on2.vp8";
                    z = z2;
                    list = list2;
                    f2 = f3;
                    bArr = bArr2;
                    i8 = i10;
                } else {
                    str = "video/x-vnd.on2.vp9";
                    z = z2;
                    list = list2;
                    f2 = f3;
                    bArr = bArr2;
                    i8 = i10;
                }
            } else if (i13 == com.anythink.expressad.exoplayer.e.a.a.l) {
                com.anythink.expressad.exoplayer.k.a.b(str2 == null);
                str = "video/3gpp";
                z = z2;
                list = list2;
                f2 = f3;
                bArr = bArr2;
                i8 = i10;
            } else if (i13 == com.anythink.expressad.exoplayer.e.a.a.O) {
                com.anythink.expressad.exoplayer.k.a.b(str2 == null);
                Pair<String, byte[]> d2 = d(sVar, c3);
                str = d2.first;
                list = Collections.singletonList(d2.second);
                z = z2;
                f2 = f3;
                bArr = bArr2;
                i8 = i10;
            } else if (i13 == com.anythink.expressad.exoplayer.e.a.a.an) {
                sVar.c(c3 + 8);
                f2 = sVar.m() / sVar.m();
                z = true;
                str = str2;
                list = list2;
                bArr = bArr2;
                i8 = i10;
            } else if (i13 == com.anythink.expressad.exoplayer.e.a.a.aN) {
                int i14 = c3;
                int i15 = 8;
                while (true) {
                    int i16 = i14 + i15;
                    if (i16 - c3 >= i12) {
                        bArr = null;
                        str = str2;
                        z = z2;
                        list = list2;
                        f2 = f3;
                        i8 = i10;
                        break;
                    }
                    sVar.c(i16);
                    int i17 = sVar.i();
                    if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.aO) {
                        bArr = Arrays.copyOfRange(sVar.f4835a, i16, i17 + i16);
                        str = str2;
                        z = z2;
                        list = list2;
                        f2 = f3;
                        i8 = i10;
                        break;
                    }
                    i14 = i16;
                    i15 = i17;
                }
            } else {
                str = str2;
                z = z2;
                list = list2;
                f2 = f3;
                bArr = bArr2;
                i8 = i10;
                if (i13 == com.anythink.expressad.exoplayer.e.a.a.aM) {
                    int d3 = sVar.d();
                    sVar.d(3);
                    str = str2;
                    z = z2;
                    list = list2;
                    f2 = f3;
                    bArr = bArr2;
                    i8 = i10;
                    if (d3 == 0) {
                        int d4 = sVar.d();
                        if (d4 == 0) {
                            i8 = 0;
                            bArr = bArr2;
                            f2 = f3;
                            list = list2;
                            z = z2;
                            str = str2;
                        } else if (d4 == 1) {
                            i8 = 1;
                            str = str2;
                            z = z2;
                            list = list2;
                            f2 = f3;
                            bArr = bArr2;
                        } else if (d4 == 2) {
                            i8 = 2;
                            str = str2;
                            z = z2;
                            list = list2;
                            f2 = f3;
                            bArr = bArr2;
                        } else if (d4 != 3) {
                            str = str2;
                            z = z2;
                            list = list2;
                            f2 = f3;
                            bArr = bArr2;
                            i8 = i10;
                        } else {
                            i8 = 3;
                            str = str2;
                            z = z2;
                            list = list2;
                            f2 = f3;
                            bArr = bArr2;
                        }
                    }
                }
            }
            i11 += i12;
            str2 = str;
            z2 = z;
            list2 = list;
            f3 = f2;
            bArr2 = bArr;
            i10 = i8;
        }
        if (str2 == null) {
            return;
        }
        cVar.f4442c = com.anythink.expressad.exoplayer.m.a(Integer.toString(i5), str2, null, -1, -1, e2, e3, -1.0f, list2, i6, f3, bArr2, i10, null, eVar2);
    }

    private static void a(s sVar, int i2, int i3, int i4, int i5, String str, c cVar) {
        String str2;
        sVar.c(i3 + 8 + 8);
        List list = null;
        long j = Long.MAX_VALUE;
        if (i2 == com.anythink.expressad.exoplayer.e.a.a.ao) {
            str2 = o.Z;
        } else if (i2 == com.anythink.expressad.exoplayer.e.a.a.az) {
            int i6 = (i4 - 8) - 8;
            byte[] bArr = new byte[i6];
            sVar.a(bArr, 0, i6);
            list = Collections.singletonList(bArr);
            str2 = o.aa;
        } else if (i2 == com.anythink.expressad.exoplayer.e.a.a.aA) {
            str2 = o.ab;
        } else if (i2 == com.anythink.expressad.exoplayer.e.a.a.aB) {
            j = 0;
            str2 = o.Z;
        } else if (i2 != com.anythink.expressad.exoplayer.e.a.a.aC) {
            throw new IllegalStateException();
        } else {
            cVar.e = 1;
            str2 = o.ac;
        }
        cVar.f4442c = com.anythink.expressad.exoplayer.m.a(Integer.toString(i5), str2, (String) null, -1, 0, str, -1, (com.anythink.expressad.exoplayer.d.e) null, j, list);
    }

    private static void a(s sVar, int i2, int i3, int i4, int i5, String str, boolean z, com.anythink.expressad.exoplayer.d.e eVar, c cVar, int i6) {
        int i7;
        int e2;
        int i8;
        int i9;
        sVar.c(i3 + 8 + 8);
        if (z) {
            i7 = sVar.e();
            sVar.d(6);
        } else {
            sVar.d(8);
            i7 = 0;
        }
        if (i7 == 0 || i7 == 1) {
            e2 = sVar.e();
            sVar.d(6);
            int k = sVar.k();
            if (i7 == 1) {
                sVar.d(16);
            }
            i8 = k;
        } else if (i7 != 2) {
            return;
        } else {
            sVar.d(16);
            i8 = (int) Math.round(Double.longBitsToDouble(sVar.j()));
            e2 = sVar.m();
            sVar.d(20);
        }
        int c2 = sVar.c();
        com.anythink.expressad.exoplayer.d.e eVar2 = eVar;
        int i10 = i2;
        if (i2 == com.anythink.expressad.exoplayer.e.a.a.af) {
            Pair<Integer, k> b2 = b(sVar, i3, i4);
            eVar2 = eVar;
            if (b2 != null) {
                i2 = b2.first.intValue();
                eVar2 = eVar == null ? null : eVar.a(b2.second.b);
                cVar.b[i6] = b2.second;
            }
            sVar.c(c2);
            i10 = i2;
        }
        com.anythink.expressad.exoplayer.d.e eVar3 = eVar2;
        String str2 = i10 == com.anythink.expressad.exoplayer.e.a.a.s ? "audio/ac3" : i10 == com.anythink.expressad.exoplayer.e.a.a.u ? "audio/eac3" : i10 == com.anythink.expressad.exoplayer.e.a.a.w ? o.D : (i10 == com.anythink.expressad.exoplayer.e.a.a.x || i10 == com.anythink.expressad.exoplayer.e.a.a.y) ? o.E : i10 == com.anythink.expressad.exoplayer.e.a.a.z ? o.F : i10 == com.anythink.expressad.exoplayer.e.a.a.aD ? "audio/3gpp" : i10 == com.anythink.expressad.exoplayer.e.a.a.aE ? "audio/amr-wb" : (i10 == com.anythink.expressad.exoplayer.e.a.a.q || i10 == com.anythink.expressad.exoplayer.e.a.a.r) ? "audio/raw" : i10 == com.anythink.expressad.exoplayer.e.a.a.o ? "audio/mpeg" : i10 == com.anythink.expressad.exoplayer.e.a.a.aT ? o.L : null;
        int i11 = c2;
        byte[] bArr = null;
        while (i11 - i3 < i4) {
            sVar.c(i11);
            int i12 = sVar.i();
            com.anythink.expressad.exoplayer.k.a.a(i12 > 0, "childAtomSize should be positive");
            int i13 = sVar.i();
            if (i13 == com.anythink.expressad.exoplayer.e.a.a.O || (z && i13 == com.anythink.expressad.exoplayer.e.a.a.p)) {
                int i14 = i11;
                if (i13 != com.anythink.expressad.exoplayer.e.a.a.O) {
                    int c3 = sVar.c();
                    while (true) {
                        i9 = c3;
                        if (i9 - i14 >= i12) {
                            i9 = -1;
                            break;
                        }
                        sVar.c(i9);
                        int i15 = sVar.i();
                        com.anythink.expressad.exoplayer.k.a.a(i15 > 0, "childAtomSize should be positive");
                        if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.O) {
                            break;
                        }
                        c3 = i9 + i15;
                    }
                } else {
                    i9 = i14;
                }
                if (i9 != -1) {
                    Pair<String, byte[]> d2 = d(sVar, i9);
                    str2 = d2.first;
                    bArr = d2.second;
                    if ("audio/mp4a-latm".equals(str2)) {
                        Pair<Integer, Integer> a2 = com.anythink.expressad.exoplayer.k.d.a(bArr);
                        i8 = a2.first.intValue();
                        e2 = a2.second.intValue();
                    }
                }
            } else if (i13 == com.anythink.expressad.exoplayer.e.a.a.t) {
                sVar.c(i11 + 8);
                cVar.f4442c = com.anythink.expressad.exoplayer.b.a.a(sVar, Integer.toString(i5), str, eVar3);
            } else if (i13 == com.anythink.expressad.exoplayer.e.a.a.v) {
                sVar.c(i11 + 8);
                cVar.f4442c = com.anythink.expressad.exoplayer.b.a.b(sVar, Integer.toString(i5), str, eVar3);
            } else if (i13 == com.anythink.expressad.exoplayer.e.a.a.A) {
                cVar.f4442c = com.anythink.expressad.exoplayer.m.a(Integer.toString(i5), str2, null, -1, e2, i8, null, eVar3, str);
            } else if (i13 == com.anythink.expressad.exoplayer.e.a.a.aT) {
                bArr = new byte[i12];
                sVar.c(i11);
                sVar.a(bArr, 0, i12);
            }
            i11 += i12;
        }
        if (cVar.f4442c != null || str2 == null) {
            return;
        }
        cVar.f4442c = com.anythink.expressad.exoplayer.m.a(Integer.toString(i5), str2, (String) null, -1, e2, i8, "audio/raw".equals(str2) ? 2 : -1, bArr == null ? null : Collections.singletonList(bArr), eVar3, str);
    }

    private static boolean a(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        return jArr[0] <= j2 && j2 < jArr[af.a(3, 0, length)] && jArr[af.a(jArr.length - 3, 0, length)] < j3 && j3 <= j;
    }

    private static Pair<Integer, k> b(s sVar, int i2, int i3) {
        Pair<Integer, k> c2;
        int c3 = sVar.c();
        while (true) {
            int i4 = c3;
            if (i4 - i2 >= i3) {
                return null;
            }
            sVar.c(i4);
            int i5 = sVar.i();
            com.anythink.expressad.exoplayer.k.a.a(i5 > 0, "childAtomSize should be positive");
            if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.aa && (c2 = c(sVar, i4, i5)) != null) {
                return c2;
            }
            c3 = i4 + i5;
        }
    }

    private static f b(s sVar) {
        boolean z;
        long h2;
        int i2;
        sVar.c(8);
        int a2 = com.anythink.expressad.exoplayer.e.a.a.a(sVar.i());
        sVar.d(a2 == 0 ? 8 : 16);
        int i3 = sVar.i();
        sVar.d(4);
        int c2 = sVar.c();
        int i4 = 8;
        if (a2 == 0) {
            i4 = 4;
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= i4) {
                z = true;
                break;
            } else if (sVar.f4835a[c2 + i6] != -1) {
                z = false;
                break;
            } else {
                i5 = i6 + 1;
            }
        }
        if (z) {
            sVar.d(i4);
            h2 = -9223372036854775807L;
        } else {
            h2 = a2 == 0 ? sVar.h() : sVar.n();
            if (h2 == 0) {
                h2 = -9223372036854775807L;
            }
        }
        sVar.d(16);
        int i7 = sVar.i();
        int i8 = sVar.i();
        sVar.d(4);
        int i9 = sVar.i();
        int i10 = sVar.i();
        if (i7 == 0 && i8 == 65536 && i9 == -65536 && i10 == 0) {
            i2 = 90;
        } else if (i7 == 0 && i8 == -65536 && i9 == 65536 && i10 == 0) {
            i2 = 270;
        } else {
            i2 = 0;
            if (i7 == -65536) {
                i2 = 0;
                if (i8 == 0) {
                    i2 = 0;
                    if (i9 == 0) {
                        i2 = 0;
                        if (i10 == -65536) {
                            i2 = 180;
                        }
                    }
                }
            }
        }
        return new f(i3, h2, i2);
    }

    private static com.anythink.expressad.exoplayer.g.a b(s sVar, int i2) {
        sVar.d(8);
        ArrayList arrayList = new ArrayList();
        while (sVar.c() < i2) {
            a.InterfaceC0058a a2 = com.anythink.expressad.exoplayer.e.a.f.a(sVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new com.anythink.expressad.exoplayer.g.a(arrayList);
    }

    private static float c(s sVar, int i2) {
        sVar.c(i2 + 8);
        return sVar.m() / sVar.m();
    }

    private static int c(s sVar) {
        sVar.c(16);
        int i2 = sVar.i();
        if (i2 == f4438c) {
            return 1;
        }
        if (i2 == b) {
            return 2;
        }
        if (i2 == d || i2 == e || i2 == f || i2 == g) {
            return 3;
        }
        return i2 == h ? 4 : -1;
    }

    private static Pair<Integer, k> c(s sVar, int i2, int i3) {
        String str;
        Integer num;
        int i4 = i2 + 8;
        String str2 = null;
        Integer num2 = null;
        int i5 = -1;
        int i6 = 0;
        while (i4 - i2 < i3) {
            sVar.c(i4);
            int i7 = sVar.i();
            int i8 = sVar.i();
            if (i8 == com.anythink.expressad.exoplayer.e.a.a.ag) {
                num = Integer.valueOf(sVar.i());
                str = str2;
            } else if (i8 == com.anythink.expressad.exoplayer.e.a.a.ab) {
                sVar.d(4);
                str = sVar.o();
                num = num2;
            } else {
                str = str2;
                num = num2;
                if (i8 == com.anythink.expressad.exoplayer.e.a.a.ac) {
                    i5 = i4;
                    i6 = i7;
                    num = num2;
                    str = str2;
                }
            }
            i4 += i7;
            str2 = str;
            num2 = num;
        }
        if (com.anythink.expressad.exoplayer.b.bd.equals(str2) || com.anythink.expressad.exoplayer.b.be.equals(str2) || com.anythink.expressad.exoplayer.b.bf.equals(str2) || com.anythink.expressad.exoplayer.b.bg.equals(str2)) {
            com.anythink.expressad.exoplayer.k.a.a(num2 != null, "frma atom is mandatory");
            com.anythink.expressad.exoplayer.k.a.a(i5 != -1, "schi atom is mandatory");
            k a2 = a(sVar, i5, i6, str2);
            boolean z = false;
            if (a2 != null) {
                z = true;
            }
            com.anythink.expressad.exoplayer.k.a.a(z, "tenc atom is mandatory");
            return Pair.create(num2, a2);
        }
        return null;
    }

    private static Pair<Long, String> d(s sVar) {
        sVar.c(8);
        int a2 = com.anythink.expressad.exoplayer.e.a.a.a(sVar.i());
        sVar.d(a2 == 0 ? 8 : 16);
        long h2 = sVar.h();
        int i2 = 8;
        if (a2 == 0) {
            i2 = 4;
        }
        sVar.d(i2);
        int e2 = sVar.e();
        StringBuilder sb = new StringBuilder();
        sb.append((char) (((e2 >> 10) & 31) + 96));
        sb.append((char) (((e2 >> 5) & 31) + 96));
        sb.append((char) ((e2 & 31) + 96));
        return Pair.create(Long.valueOf(h2), sb.toString());
    }

    private static Pair<String, byte[]> d(s sVar, int i2) {
        sVar.c(i2 + 8 + 4);
        sVar.d(1);
        e(sVar);
        sVar.d(2);
        int d2 = sVar.d();
        if ((d2 & 128) != 0) {
            sVar.d(2);
        }
        if ((d2 & 64) != 0) {
            sVar.d(sVar.e());
        }
        if ((d2 & 32) != 0) {
            sVar.d(2);
        }
        sVar.d(1);
        e(sVar);
        String a2 = o.a(sVar.d());
        if ("audio/mpeg".equals(a2) || o.D.equals(a2) || o.E.equals(a2)) {
            return Pair.create(a2, null);
        }
        sVar.d(12);
        sVar.d(1);
        int e2 = e(sVar);
        byte[] bArr = new byte[e2];
        sVar.a(bArr, 0, e2);
        return Pair.create(a2, bArr);
    }

    private static byte[] d(s sVar, int i2, int i3) {
        int i4 = i2;
        int i5 = 8;
        while (true) {
            int i6 = i4 + i5;
            if (i6 - i2 >= i3) {
                return null;
            }
            sVar.c(i6);
            int i7 = sVar.i();
            if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.aO) {
                return Arrays.copyOfRange(sVar.f4835a, i6, i7 + i6);
            }
            i4 = i6;
            i5 = i7;
        }
    }

    private static int e(s sVar) {
        int d2 = sVar.d();
        int i2 = d2 & 127;
        while (true) {
            int i3 = i2;
            if ((d2 & 128) != 128) {
                return i3;
            }
            d2 = sVar.d();
            i2 = (i3 << 7) | (d2 & 127);
        }
    }
}
