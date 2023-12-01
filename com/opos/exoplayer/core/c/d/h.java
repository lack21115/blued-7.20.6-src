package com.opos.exoplayer.core.c.d;

import android.util.Pair;
import com.anythink.expressad.exoplayer.k.o;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.d.a;
import com.opos.exoplayer.core.c.d.g;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.video.ColorInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/d/h.class */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final int f25131a = u.f("vide");
    private static final int b = u.f("soun");

    /* renamed from: c  reason: collision with root package name */
    private static final int f25132c = u.f("text");
    private static final int d = u.f("sbtl");
    private static final int e = u.f("subt");
    private static final int f = u.f("clcp");
    private static final int g = u.f(TTDownloadField.TT_META);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/d/h$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f25133a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public int f25134c;
        public long d;
        private final boolean e;
        private final com.opos.exoplayer.core.i.m f;
        private final com.opos.exoplayer.core.i.m g;
        private int h;
        private int i;

        public a(com.opos.exoplayer.core.i.m mVar, com.opos.exoplayer.core.i.m mVar2, boolean z) {
            this.g = mVar;
            this.f = mVar2;
            this.e = z;
            mVar2.c(12);
            this.f25133a = mVar2.u();
            mVar.c(12);
            this.i = mVar.u();
            com.opos.exoplayer.core.i.a.b(mVar.o() != 1 ? false : true, "first_chunk must be 1");
            this.b = -1;
        }

        public boolean a() {
            int i = this.b + 1;
            this.b = i;
            if (i == this.f25133a) {
                return false;
            }
            this.d = this.e ? this.f.w() : this.f.m();
            if (this.b == this.h) {
                this.f25134c = this.g.u();
                this.g.d(4);
                int i2 = this.i - 1;
                this.i = i2;
                this.h = i2 > 0 ? this.g.u() - 1 : -1;
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/d/h$b.class */
    public interface b {
        int a();

        int b();

        boolean c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/d/h$c.class */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final com.opos.exoplayer.core.c.d.f[] f25135a;
        public Format b;

        /* renamed from: c  reason: collision with root package name */
        public int f25136c;
        public int d = 0;

        public c(int i) {
            this.f25135a = new com.opos.exoplayer.core.c.d.f[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/d/h$d.class */
    public static final class d implements b {

        /* renamed from: a  reason: collision with root package name */
        private final int f25137a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final com.opos.exoplayer.core.i.m f25138c;

        public d(g.b bVar) {
            com.opos.exoplayer.core.i.m mVar = bVar.aQ;
            this.f25138c = mVar;
            mVar.c(12);
            this.f25137a = this.f25138c.u();
            this.b = this.f25138c.u();
        }

        @Override // com.opos.exoplayer.core.c.d.h.b
        public int a() {
            return this.b;
        }

        @Override // com.opos.exoplayer.core.c.d.h.b
        public int b() {
            int i = this.f25137a;
            int i2 = i;
            if (i == 0) {
                i2 = this.f25138c.u();
            }
            return i2;
        }

        @Override // com.opos.exoplayer.core.c.d.h.b
        public boolean c() {
            return this.f25137a != 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/d/h$e.class */
    public static final class e implements b {

        /* renamed from: a  reason: collision with root package name */
        private final com.opos.exoplayer.core.i.m f25139a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final int f25140c;
        private int d;
        private int e;

        public e(g.b bVar) {
            com.opos.exoplayer.core.i.m mVar = bVar.aQ;
            this.f25139a = mVar;
            mVar.c(12);
            this.f25140c = this.f25139a.u() & 255;
            this.b = this.f25139a.u();
        }

        @Override // com.opos.exoplayer.core.c.d.h.b
        public int a() {
            return this.b;
        }

        @Override // com.opos.exoplayer.core.c.d.h.b
        public int b() {
            int i = this.f25140c;
            if (i == 8) {
                return this.f25139a.g();
            }
            if (i == 16) {
                return this.f25139a.h();
            }
            int i2 = this.d;
            this.d = i2 + 1;
            if (i2 % 2 == 0) {
                int g = this.f25139a.g();
                this.e = g;
                return (g & 240) >> 4;
            }
            return this.e & 15;
        }

        @Override // com.opos.exoplayer.core.c.d.h.b
        public boolean c() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/d/h$f.class */
    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        private final int f25141a;
        private final long b;

        /* renamed from: c  reason: collision with root package name */
        private final int f25142c;

        public f(int i, long j, int i2) {
            this.f25141a = i;
            this.b = j;
            this.f25142c = i2;
        }
    }

    private static long a(com.opos.exoplayer.core.i.m mVar) {
        int i = 8;
        mVar.c(8);
        if (g.a(mVar.o()) != 0) {
            i = 16;
        }
        mVar.d(i);
        return mVar.m();
    }

    private static Pair<long[], long[]> a(g.a aVar) {
        g.b d2;
        if (aVar == null || (d2 = aVar.d(g.Q)) == null) {
            return Pair.create(null, null);
        }
        com.opos.exoplayer.core.i.m mVar = d2.aQ;
        mVar.c(8);
        int a2 = g.a(mVar.o());
        int u = mVar.u();
        long[] jArr = new long[u];
        long[] jArr2 = new long[u];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= u) {
                return Pair.create(jArr, jArr2);
            }
            jArr[i2] = a2 == 1 ? mVar.w() : mVar.m();
            jArr2[i2] = a2 == 1 ? mVar.q() : mVar.o();
            if (mVar.j() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            mVar.d(2);
            i = i2 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00bb, code lost:
        if (com.anythink.expressad.exoplayer.b.bg.equals(r16) != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static android.util.Pair<java.lang.Integer, com.opos.exoplayer.core.c.d.f> a(com.opos.exoplayer.core.i.m r5, int r6, int r7) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.d.h.a(com.opos.exoplayer.core.i.m, int, int):android.util.Pair");
    }

    public static com.opos.exoplayer.core.c.d.e a(g.a aVar, g.b bVar, long j, DrmInitData drmInitData, boolean z, boolean z2) {
        long[] jArr;
        long[] jArr2;
        g.a e2 = aVar.e(g.E);
        int c2 = c(e2.d(g.S).aQ);
        if (c2 == -1) {
            return null;
        }
        f b2 = b(aVar.d(g.O).aQ);
        if (j == com.anythink.expressad.exoplayer.b.b) {
            j = b2.b;
        }
        long a2 = a(bVar.aQ);
        long d2 = j == com.anythink.expressad.exoplayer.b.b ? -9223372036854775807L : u.d(j, 1000000L, a2);
        g.a e3 = e2.e(g.F).e(g.G);
        Pair<Long, String> d3 = d(e2.d(g.R).aQ);
        c a3 = a(e3.d(g.T).aQ, b2.f25141a, b2.f25142c, d3.second, drmInitData, z2);
        if (z) {
            jArr = null;
            jArr2 = null;
        } else {
            Pair<long[], long[]> a4 = a(aVar.e(g.P));
            jArr = a4.first;
            jArr2 = a4.second;
        }
        if (a3.b == null) {
            return null;
        }
        return new com.opos.exoplayer.core.c.d.e(b2.f25141a, c2, d3.first.longValue(), a2, d2, a3.b, a3.d, a3.f25135a, a3.f25136c, jArr, jArr2);
    }

    private static com.opos.exoplayer.core.c.d.f a(com.opos.exoplayer.core.i.m mVar, int i, int i2, String str) {
        int i3;
        int i4;
        int i5 = i;
        int i6 = 8;
        while (true) {
            int i7 = i5 + i6;
            if (i7 - i >= i2) {
                return null;
            }
            mVar.c(i7);
            int o = mVar.o();
            if (mVar.o() == g.Y) {
                int a2 = g.a(mVar.o());
                mVar.d(1);
                if (a2 == 0) {
                    mVar.d(1);
                    i4 = 0;
                    i3 = 0;
                } else {
                    int g2 = mVar.g();
                    i3 = g2 & 15;
                    i4 = (g2 & 240) >> 4;
                }
                boolean z = mVar.g() == 1;
                int g3 = mVar.g();
                byte[] bArr = new byte[16];
                mVar.a(bArr, 0, 16);
                byte[] bArr2 = null;
                if (z) {
                    bArr2 = null;
                    if (g3 == 0) {
                        int g4 = mVar.g();
                        bArr2 = new byte[g4];
                        mVar.a(bArr2, 0, g4);
                    }
                }
                return new com.opos.exoplayer.core.c.d.f(z, str, g3, bArr, i4, i3, bArr2);
            }
            i5 = i7;
            i6 = o;
        }
    }

    private static c a(com.opos.exoplayer.core.i.m mVar, int i, int i2, String str, DrmInitData drmInitData, boolean z) {
        mVar.c(12);
        int o = mVar.o();
        c cVar = new c(o);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= o) {
                return cVar;
            }
            int d2 = mVar.d();
            int o2 = mVar.o();
            com.opos.exoplayer.core.i.a.a(o2 > 0, "childAtomSize should be positive");
            int o3 = mVar.o();
            if (o3 == g.b || o3 == g.f25130c || o3 == g.Z || o3 == g.al || o3 == g.d || o3 == g.e || o3 == g.f || o3 == g.aK || o3 == g.aL) {
                a(mVar, o3, d2, o2, i, i2, drmInitData, cVar, i4);
            } else if (o3 == g.i || o3 == g.aa || o3 == g.n || o3 == g.p || o3 == g.r || o3 == g.u || o3 == g.s || o3 == g.t || o3 == g.ay || o3 == g.az || o3 == g.l || o3 == g.m || o3 == g.j || o3 == g.aO) {
                a(mVar, o3, d2, o2, i, str, z, drmInitData, cVar, i4);
            } else if (o3 == g.aj || o3 == g.au || o3 == g.av || o3 == g.aw || o3 == g.ax) {
                a(mVar, o3, d2, o2, i, str, cVar);
            } else if (o3 == g.aN) {
                cVar.b = Format.a(Integer.toString(i), o.ah, (String) null, -1, (DrmInitData) null);
            }
            mVar.c(d2 + o2);
            i3 = i4 + 1;
        }
    }

    public static m a(com.opos.exoplayer.core.c.d.e eVar, g.a aVar, com.opos.exoplayer.core.c.i iVar) {
        b eVar2;
        boolean z;
        int i;
        com.opos.exoplayer.core.i.m mVar;
        int i2;
        int i3;
        long[] jArr;
        int[] iArr;
        int i4;
        long[] jArr2;
        int[] iArr2;
        long j;
        boolean z2;
        int i5;
        m mVar2;
        g.b d2 = aVar.d(g.aq);
        if (d2 != null) {
            eVar2 = new d(d2);
        } else {
            g.b d3 = aVar.d(g.f25129ar);
            if (d3 == null) {
                throw new com.opos.exoplayer.core.o("Track has no sample table size information");
            }
            eVar2 = new e(d3);
        }
        int a2 = eVar2.a();
        if (a2 == 0) {
            return new m(new long[0], new int[0], 0, new long[0], new int[0], com.anythink.expressad.exoplayer.b.b);
        }
        g.b d4 = aVar.d(g.as);
        if (d4 == null) {
            d4 = aVar.d(g.at);
            z = true;
        } else {
            z = false;
        }
        com.opos.exoplayer.core.i.m mVar3 = d4.aQ;
        com.opos.exoplayer.core.i.m mVar4 = aVar.d(g.ap).aQ;
        com.opos.exoplayer.core.i.m mVar5 = aVar.d(g.am).aQ;
        g.b d5 = aVar.d(g.an);
        com.opos.exoplayer.core.i.m mVar6 = d5 != null ? d5.aQ : null;
        g.b d6 = aVar.d(g.ao);
        com.opos.exoplayer.core.i.m mVar7 = d6 != null ? d6.aQ : null;
        a aVar2 = new a(mVar4, mVar3, z);
        mVar5.c(12);
        int u = mVar5.u() - 1;
        int u2 = mVar5.u();
        int u3 = mVar5.u();
        if (mVar7 != null) {
            mVar7.c(12);
            i = mVar7.u();
        } else {
            i = 0;
        }
        int i6 = -1;
        if (mVar6 != null) {
            mVar6.c(12);
            int u4 = mVar6.u();
            i2 = u4;
            mVar = null;
            if (u4 > 0) {
                i6 = mVar6.u() - 1;
                mVar = mVar6;
                i2 = u4;
            }
        } else {
            mVar = mVar6;
            i2 = 0;
        }
        if (eVar2.c() && "audio/raw".equals(eVar.f.f) && u == 0 && i == 0 && i2 == 0) {
            i3 = a2;
            long[] jArr3 = new long[aVar2.f25133a];
            int[] iArr3 = new int[aVar2.f25133a];
            while (aVar2.a()) {
                jArr3[aVar2.b] = aVar2.d;
                iArr3[aVar2.b] = aVar2.f25134c;
            }
            a.C0651a a3 = com.opos.exoplayer.core.c.d.a.a(eVar2.b(), jArr3, iArr3, u3);
            jArr = a3.f25111a;
            iArr = a3.b;
            i4 = a3.f25112c;
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
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = i2;
            int i11 = 0;
            int i12 = i6;
            int i13 = u3;
            int i14 = 0;
            while (i14 < a2) {
                int i15 = u2;
                while (i9 == 0) {
                    com.opos.exoplayer.core.i.a.b(aVar2.a());
                    j2 = aVar2.d;
                    i9 = aVar2.f25134c;
                }
                int i16 = u;
                int i17 = i;
                int i18 = i8;
                int i19 = i11;
                if (mVar7 != null) {
                    while (i8 == 0 && i > 0) {
                        i8 = mVar7.u();
                        i11 = mVar7.o();
                        i--;
                    }
                    i18 = i8 - 1;
                    i19 = i11;
                    i17 = i;
                }
                jArr[i14] = j2;
                iArr4[i14] = eVar2.b();
                int i20 = i7;
                if (iArr4[i14] > i7) {
                    i20 = iArr4[i14];
                }
                jArr4[i14] = i19 + j3;
                iArr5[i14] = mVar == null ? 1 : 0;
                int i21 = i10;
                int i22 = i12;
                if (i14 == i12) {
                    iArr5[i14] = 1;
                    int i23 = i10 - 1;
                    i21 = i23;
                    i22 = i12;
                    if (i23 > 0) {
                        i22 = mVar.u() - 1;
                        i21 = i23;
                    }
                }
                j3 += i13;
                int i24 = i15 - 1;
                int i25 = i13;
                int i26 = i24;
                int i27 = i16;
                if (i24 == 0) {
                    i25 = i13;
                    i26 = i24;
                    i27 = i16;
                    if (i16 > 0) {
                        i26 = mVar5.u();
                        i25 = mVar5.o();
                        i27 = i16 - 1;
                    }
                }
                j2 += iArr4[i14];
                i9--;
                i14++;
                i13 = i25;
                u2 = i26;
                i11 = i19;
                i10 = i21;
                i7 = i20;
                i12 = i22;
                u = i27;
                i = i17;
                i8 = i18;
            }
            long j4 = i11;
            com.opos.exoplayer.core.i.a.a(i8 == 0);
            while (i > 0) {
                com.opos.exoplayer.core.i.a.a(mVar7.u() == 0);
                mVar7.o();
                i--;
            }
            if (i10 != 0 || u2 != 0 || i9 != 0 || u != 0) {
                com.opos.cmn.an.f.a.c("AtomParsers", "Inconsistent stbl box for track " + eVar.f25124a + ": remainingSynchronizationSamples " + i10 + ", remainingSamplesAtTimestampDelta " + u2 + ", remainingSamplesInChunk " + i9 + ", remainingTimestampDeltaChanges " + u);
            }
            j = j3 + j4;
            jArr2 = jArr4;
            iArr = iArr4;
            iArr2 = iArr5;
            i4 = i7;
            i3 = a2;
        }
        int[] iArr6 = iArr2;
        long d7 = u.d(j, 1000000L, eVar.f25125c);
        if (eVar.h == null || iVar.a()) {
            u.a(jArr2, 1000000L, eVar.f25125c);
            return new m(jArr, iArr, i4, jArr2, iArr6, d7);
        }
        if (eVar.h.length == 1 && eVar.b == 1 && jArr2.length >= 2) {
            long j5 = eVar.i[0];
            long d8 = u.d(eVar.h[0], eVar.f25125c, eVar.d) + j5;
            if (jArr2[0] <= j5 && j5 < jArr2[1] && jArr2[jArr2.length - 1] < d8 && d8 <= j) {
                long d9 = u.d(j5 - jArr2[0], eVar.f.s, eVar.f25125c);
                long d10 = u.d(j - d8, eVar.f.s, eVar.f25125c);
                if ((d9 != 0 || d10 != 0) && d9 <= 2147483647L && d10 <= 2147483647L) {
                    iVar.b = (int) d9;
                    iVar.f25246c = (int) d10;
                    u.a(jArr2, 1000000L, eVar.f25125c);
                    mVar2 = new m(jArr, iArr, i4, jArr2, iArr6, d7);
                    return mVar2;
                }
            }
        }
        if (eVar.h.length == 1 && eVar.h[0] == 0) {
            long j6 = eVar.i[0];
            int i28 = 0;
            while (true) {
                int i29 = i28;
                if (i29 >= jArr2.length) {
                    break;
                }
                jArr2[i29] = u.d(jArr2[i29] - j6, 1000000L, eVar.f25125c);
                i28 = i29 + 1;
            }
            mVar2 = new m(jArr, iArr, i4, jArr2, iArr6, u.d(j - j6, 1000000L, eVar.f25125c));
            return mVar2;
        }
        boolean z3 = eVar.b == 1;
        int i30 = 0;
        int i31 = 0;
        int i32 = 0;
        boolean z4 = false;
        while (i30 < eVar.h.length) {
            long j7 = eVar.i[i30];
            if (j7 != -1) {
                long d11 = u.d(eVar.h[i30], eVar.f25125c, eVar.d);
                int b2 = u.b(jArr2, j7, true, true);
                int b3 = u.b(jArr2, d11 + j7, z3, false);
                int i33 = i31 + (b3 - b2);
                boolean z5 = i32 != b2;
                i5 = i33;
                i32 = b3;
                z2 = z5 | z4;
            } else {
                z2 = z4;
                i5 = i31;
            }
            i30++;
            i31 = i5;
            z4 = z2;
        }
        boolean z6 = (i31 != i3) | z4;
        long[] jArr5 = z6 ? new long[i31] : jArr;
        int[] iArr7 = z6 ? new int[i31] : iArr;
        int i34 = z6 ? 0 : i4;
        int[] iArr8 = z6 ? new int[i31] : iArr6;
        long[] jArr6 = new long[i31];
        int i35 = 0;
        int i36 = 0;
        long j8 = 0;
        while (i35 < eVar.h.length) {
            long j9 = eVar.i[i35];
            long j10 = eVar.h[i35];
            if (j9 != -1) {
                long d12 = u.d(j10, eVar.f25125c, eVar.d);
                int b4 = u.b(jArr2, j9, true, true);
                int b5 = u.b(jArr2, d12 + j9, z3, false);
                if (z6) {
                    int i37 = b5 - b4;
                    System.arraycopy((Object) jArr, b4, (Object) jArr5, i36, i37);
                    System.arraycopy((Object) iArr, b4, (Object) iArr7, i36, i37);
                    System.arraycopy((Object) iArr6, b4, (Object) iArr8, i36, i37);
                }
                while (b4 < b5) {
                    jArr6[i36] = u.d(jArr2[b4] - j9, 1000000L, eVar.f25125c) + u.d(j8, 1000000L, eVar.d);
                    int i38 = i34;
                    if (z6) {
                        i38 = i34;
                        if (iArr7[i36] > i34) {
                            i38 = iArr[b4];
                        }
                    }
                    i36++;
                    b4++;
                    i34 = i38;
                }
            }
            j8 += j10;
            i35++;
            iArr = iArr;
        }
        long d13 = u.d(j8, 1000000L, eVar.f25125c);
        boolean z7 = false;
        int i39 = 0;
        while (true) {
            int i40 = i39;
            if (i40 >= iArr8.length || z7) {
                break;
            }
            z7 |= (iArr8[i40] & 1) != 0;
            i39 = i40 + 1;
        }
        if (z7) {
            return new m(jArr5, iArr7, i34, jArr6, iArr8, d13);
        }
        com.opos.cmn.an.f.a.c("AtomParsers", "Ignoring edit list: Edited sample sequence does not contain a sync sample.");
        u.a(jArr2, 1000000L, eVar.f25125c);
        return new m(jArr, iArr, i4, jArr2, iArr6, d7);
    }

    public static Metadata a(g.b bVar, boolean z) {
        if (z) {
            return null;
        }
        com.opos.exoplayer.core.i.m mVar = bVar.aQ;
        mVar.c(8);
        while (mVar.b() >= 8) {
            int d2 = mVar.d();
            int o = mVar.o();
            if (mVar.o() == g.aB) {
                mVar.c(d2);
                return a(mVar, d2 + o);
            }
            mVar.d(o - 8);
        }
        return null;
    }

    private static Metadata a(com.opos.exoplayer.core.i.m mVar, int i) {
        mVar.d(12);
        while (mVar.d() < i) {
            int d2 = mVar.d();
            int o = mVar.o();
            if (mVar.o() == g.aC) {
                mVar.c(d2);
                return b(mVar, d2 + o);
            }
            mVar.d(o - 8);
        }
        return null;
    }

    private static void a(com.opos.exoplayer.core.i.m mVar, int i, int i2, int i3, int i4, int i5, DrmInitData drmInitData, c cVar, int i6) {
        boolean z;
        String str;
        List<byte[]> list;
        float f2;
        byte[] bArr;
        int i7;
        mVar.c(i2 + 8 + 8);
        mVar.d(16);
        int h = mVar.h();
        int h2 = mVar.h();
        mVar.d(50);
        int d2 = mVar.d();
        String str2 = null;
        DrmInitData drmInitData2 = drmInitData;
        int i8 = i;
        if (i == g.Z) {
            Pair<Integer, com.opos.exoplayer.core.c.d.f> c2 = c(mVar, i2, i3);
            DrmInitData drmInitData3 = drmInitData;
            if (c2 != null) {
                i = c2.first.intValue();
                drmInitData3 = drmInitData == null ? null : drmInitData.a(c2.second.b);
                cVar.f25135a[i6] = c2.second;
            }
            mVar.c(d2);
            i8 = i;
            drmInitData2 = drmInitData3;
        }
        List<byte[]> list2 = null;
        byte[] bArr2 = null;
        float f3 = 1.0f;
        int i9 = -1;
        int i10 = d2;
        boolean z2 = false;
        while (i10 - i2 < i3) {
            mVar.c(i10);
            int d3 = mVar.d();
            int o = mVar.o();
            if (o == 0 && mVar.d() - i2 == i3) {
                break;
            }
            com.opos.exoplayer.core.i.a.a(o > 0, "childAtomSize should be positive");
            int o2 = mVar.o();
            if (o2 == g.H) {
                com.opos.exoplayer.core.i.a.b(str2 == null);
                mVar.c(d3 + 8);
                com.opos.exoplayer.core.video.a a2 = com.opos.exoplayer.core.video.a.a(mVar);
                list = a2.f25565a;
                cVar.f25136c = a2.b;
                if (!z2) {
                    f3 = a2.e;
                }
                str = "video/avc";
                z = z2;
                f2 = f3;
                bArr = bArr2;
                i7 = i9;
            } else if (o2 == g.I) {
                com.opos.exoplayer.core.i.a.b(str2 == null);
                mVar.c(d3 + 8);
                com.opos.exoplayer.core.video.b a3 = com.opos.exoplayer.core.video.b.a(mVar);
                list = a3.f25567a;
                cVar.f25136c = a3.b;
                str = "video/hevc";
                z = z2;
                f2 = f3;
                bArr = bArr2;
                i7 = i9;
            } else if (o2 == g.aM) {
                com.opos.exoplayer.core.i.a.b(str2 == null);
                if (i8 == g.aK) {
                    str = "video/x-vnd.on2.vp8";
                    z = z2;
                    list = list2;
                    f2 = f3;
                    bArr = bArr2;
                    i7 = i9;
                } else {
                    str = "video/x-vnd.on2.vp9";
                    z = z2;
                    list = list2;
                    f2 = f3;
                    bArr = bArr2;
                    i7 = i9;
                }
            } else if (o2 == g.g) {
                com.opos.exoplayer.core.i.a.b(str2 == null);
                str = "video/3gpp";
                z = z2;
                list = list2;
                f2 = f3;
                bArr = bArr2;
                i7 = i9;
            } else if (o2 == g.J) {
                com.opos.exoplayer.core.i.a.b(str2 == null);
                Pair<String, byte[]> d4 = d(mVar, d3);
                str = d4.first;
                list = Collections.singletonList(d4.second);
                z = z2;
                f2 = f3;
                bArr = bArr2;
                i7 = i9;
            } else if (o2 == g.ai) {
                f2 = c(mVar, d3);
                z = true;
                str = str2;
                list = list2;
                bArr = bArr2;
                i7 = i9;
            } else if (o2 == g.aI) {
                bArr = d(mVar, d3, o);
                z = z2;
                str = str2;
                list = list2;
                f2 = f3;
                i7 = i9;
            } else {
                z = z2;
                str = str2;
                list = list2;
                f2 = f3;
                bArr = bArr2;
                i7 = i9;
                if (o2 == g.aH) {
                    int g2 = mVar.g();
                    mVar.d(3);
                    z = z2;
                    str = str2;
                    list = list2;
                    f2 = f3;
                    bArr = bArr2;
                    i7 = i9;
                    if (g2 == 0) {
                        int g3 = mVar.g();
                        if (g3 == 0) {
                            i7 = 0;
                            bArr = bArr2;
                            f2 = f3;
                            list = list2;
                            str = str2;
                            z = z2;
                        } else if (g3 == 1) {
                            i7 = 1;
                            z = z2;
                            str = str2;
                            list = list2;
                            f2 = f3;
                            bArr = bArr2;
                        } else if (g3 == 2) {
                            i7 = 2;
                            z = z2;
                            str = str2;
                            list = list2;
                            f2 = f3;
                            bArr = bArr2;
                        } else if (g3 != 3) {
                            z = z2;
                            str = str2;
                            list = list2;
                            f2 = f3;
                            bArr = bArr2;
                            i7 = i9;
                        } else {
                            i7 = 3;
                            z = z2;
                            str = str2;
                            list = list2;
                            f2 = f3;
                            bArr = bArr2;
                        }
                    }
                }
            }
            i10 += o;
            z2 = z;
            str2 = str;
            list2 = list;
            f3 = f2;
            bArr2 = bArr;
            i9 = i7;
        }
        if (str2 == null) {
            return;
        }
        cVar.b = Format.a(Integer.toString(i4), str2, (String) null, -1, -1, h, h2, -1.0f, list2, i5, f3, bArr2, i9, (ColorInfo) null, drmInitData2);
    }

    private static void a(com.opos.exoplayer.core.i.m mVar, int i, int i2, int i3, int i4, String str, c cVar) {
        String str2;
        mVar.c(i2 + 8 + 8);
        List list = null;
        long j = Long.MAX_VALUE;
        if (i == g.aj) {
            str2 = o.Z;
        } else if (i == g.au) {
            int i5 = (i3 - 8) - 8;
            byte[] bArr = new byte[i5];
            mVar.a(bArr, 0, i5);
            list = Collections.singletonList(bArr);
            str2 = o.aa;
        } else if (i == g.av) {
            str2 = o.ab;
        } else if (i == g.aw) {
            j = 0;
            str2 = o.Z;
        } else if (i != g.ax) {
            throw new IllegalStateException();
        } else {
            cVar.d = 1;
            str2 = o.ac;
        }
        cVar.b = Format.a(Integer.toString(i4), str2, null, -1, 0, str, -1, null, j, list);
    }

    private static void a(com.opos.exoplayer.core.i.m mVar, int i, int i2, int i3, int i4, String str, boolean z, DrmInitData drmInitData, c cVar, int i5) {
        int i6;
        int h;
        int i7;
        Format b2;
        mVar.c(i2 + 8 + 8);
        if (z) {
            i6 = mVar.h();
            mVar.d(6);
        } else {
            mVar.d(8);
            i6 = 0;
        }
        if (i6 == 0 || i6 == 1) {
            h = mVar.h();
            mVar.d(6);
            int s = mVar.s();
            if (i6 == 1) {
                mVar.d(16);
            }
            i7 = s;
        } else if (i6 != 2) {
            return;
        } else {
            mVar.d(16);
            i7 = (int) Math.round(mVar.x());
            h = mVar.u();
            mVar.d(20);
        }
        int d2 = mVar.d();
        DrmInitData drmInitData2 = drmInitData;
        int i8 = i;
        if (i == g.aa) {
            Pair<Integer, com.opos.exoplayer.core.c.d.f> c2 = c(mVar, i2, i3);
            drmInitData2 = drmInitData;
            if (c2 != null) {
                i = c2.first.intValue();
                drmInitData2 = drmInitData == null ? null : drmInitData.a(c2.second.b);
                cVar.f25135a[i5] = c2.second;
            }
            mVar.c(d2);
            i8 = i;
        }
        DrmInitData drmInitData3 = drmInitData2;
        String str2 = i8 == g.n ? "audio/ac3" : i8 == g.p ? "audio/eac3" : i8 == g.r ? o.D : (i8 == g.s || i8 == g.t) ? o.E : i8 == g.u ? o.F : i8 == g.ay ? "audio/3gpp" : i8 == g.az ? "audio/amr-wb" : (i8 == g.l || i8 == g.m) ? "audio/raw" : i8 == g.j ? "audio/mpeg" : i8 == g.aO ? o.L : null;
        int i9 = d2;
        byte[] bArr = null;
        while (i9 - i2 < i3) {
            mVar.c(i9);
            int o = mVar.o();
            com.opos.exoplayer.core.i.a.a(o > 0, "childAtomSize should be positive");
            int o2 = mVar.o();
            if (o2 == g.J || (z && o2 == g.k)) {
                int i10 = i9;
                int b3 = o2 == g.J ? i10 : b(mVar, i10, o);
                i9 = i10;
                if (b3 != -1) {
                    Pair<String, byte[]> d3 = d(mVar, b3);
                    String str3 = d3.first;
                    byte[] bArr2 = d3.second;
                    i9 = i10;
                    str2 = str3;
                    bArr = bArr2;
                    if ("audio/mp4a-latm".equals(str3)) {
                        Pair<Integer, Integer> a2 = com.opos.exoplayer.core.i.c.a(bArr2);
                        i7 = a2.first.intValue();
                        h = a2.second.intValue();
                        bArr = bArr2;
                        str2 = str3;
                        i9 = i10;
                    }
                }
            } else {
                if (o2 == g.o) {
                    mVar.c(i9 + 8);
                    b2 = com.opos.exoplayer.core.a.a.a(mVar, Integer.toString(i4), str, drmInitData3);
                } else if (o2 == g.q) {
                    mVar.c(i9 + 8);
                    b2 = com.opos.exoplayer.core.a.a.b(mVar, Integer.toString(i4), str, drmInitData3);
                } else if (o2 == g.v) {
                    cVar.b = Format.a(Integer.toString(i4), str2, null, -1, -1, h, i7, null, drmInitData3, 0, str);
                } else if (o2 == g.aO) {
                    bArr = new byte[o];
                    mVar.c(i9);
                    mVar.a(bArr, 0, o);
                }
                cVar.b = b2;
            }
            i9 += o;
        }
        if (cVar.b != null || str2 == null) {
            return;
        }
        cVar.b = Format.a(Integer.toString(i4), str2, (String) null, -1, -1, h, i7, "audio/raw".equals(str2) ? 2 : -1, bArr == null ? null : Collections.singletonList(bArr), drmInitData3, 0, str);
    }

    private static int b(com.opos.exoplayer.core.i.m mVar, int i, int i2) {
        int d2 = mVar.d();
        while (true) {
            int i3 = d2;
            if (i3 - i >= i2) {
                return -1;
            }
            mVar.c(i3);
            int o = mVar.o();
            com.opos.exoplayer.core.i.a.a(o > 0, "childAtomSize should be positive");
            if (mVar.o() == g.J) {
                return i3;
            }
            d2 = i3 + o;
        }
    }

    private static f b(com.opos.exoplayer.core.i.m mVar) {
        boolean z;
        long m;
        int i;
        mVar.c(8);
        int a2 = g.a(mVar.o());
        mVar.d(a2 == 0 ? 8 : 16);
        int o = mVar.o();
        mVar.d(4);
        int d2 = mVar.d();
        int i2 = 8;
        if (a2 == 0) {
            i2 = 4;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                z = true;
                break;
            } else if (mVar.f25496a[d2 + i4] != -1) {
                z = false;
                break;
            } else {
                i3 = i4 + 1;
            }
        }
        if (z) {
            mVar.d(i2);
            m = -9223372036854775807L;
        } else {
            m = a2 == 0 ? mVar.m() : mVar.w();
            if (m == 0) {
                m = -9223372036854775807L;
            }
        }
        mVar.d(16);
        int o2 = mVar.o();
        int o3 = mVar.o();
        mVar.d(4);
        int o4 = mVar.o();
        int o5 = mVar.o();
        if (o2 == 0 && o3 == 65536 && o4 == -65536 && o5 == 0) {
            i = 90;
        } else if (o2 == 0 && o3 == -65536 && o4 == 65536 && o5 == 0) {
            i = 270;
        } else {
            i = 0;
            if (o2 == -65536) {
                i = 0;
                if (o3 == 0) {
                    i = 0;
                    if (o4 == 0) {
                        i = 0;
                        if (o5 == -65536) {
                            i = 180;
                        }
                    }
                }
            }
        }
        return new f(o, m, i);
    }

    private static Metadata b(com.opos.exoplayer.core.i.m mVar, int i) {
        mVar.d(8);
        ArrayList arrayList = new ArrayList();
        while (mVar.d() < i) {
            Metadata.Entry a2 = j.a(mVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static float c(com.opos.exoplayer.core.i.m mVar, int i) {
        mVar.c(i + 8);
        return mVar.u() / mVar.u();
    }

    private static int c(com.opos.exoplayer.core.i.m mVar) {
        mVar.c(16);
        int o = mVar.o();
        if (o == b) {
            return 1;
        }
        if (o == f25131a) {
            return 2;
        }
        if (o == f25132c || o == d || o == e || o == f) {
            return 3;
        }
        return o == g ? 4 : -1;
    }

    private static Pair<Integer, com.opos.exoplayer.core.c.d.f> c(com.opos.exoplayer.core.i.m mVar, int i, int i2) {
        Pair<Integer, com.opos.exoplayer.core.c.d.f> a2;
        int d2 = mVar.d();
        while (true) {
            int i3 = d2;
            if (i3 - i >= i2) {
                return null;
            }
            mVar.c(i3);
            int o = mVar.o();
            com.opos.exoplayer.core.i.a.a(o > 0, "childAtomSize should be positive");
            if (mVar.o() == g.V && (a2 = a(mVar, i3, o)) != null) {
                return a2;
            }
            d2 = i3 + o;
        }
    }

    private static Pair<Long, String> d(com.opos.exoplayer.core.i.m mVar) {
        mVar.c(8);
        int a2 = g.a(mVar.o());
        mVar.d(a2 == 0 ? 8 : 16);
        long m = mVar.m();
        int i = 8;
        if (a2 == 0) {
            i = 4;
        }
        mVar.d(i);
        int h = mVar.h();
        return Pair.create(Long.valueOf(m), "" + ((char) (((h >> 10) & 31) + 96)) + ((char) (((h >> 5) & 31) + 96)) + ((char) ((h & 31) + 96)));
    }

    private static Pair<String, byte[]> d(com.opos.exoplayer.core.i.m mVar, int i) {
        mVar.c(i + 8 + 4);
        mVar.d(1);
        e(mVar);
        mVar.d(2);
        int g2 = mVar.g();
        if ((g2 & 128) != 0) {
            mVar.d(2);
        }
        if ((g2 & 64) != 0) {
            mVar.d(mVar.h());
        }
        if ((g2 & 32) != 0) {
            mVar.d(2);
        }
        mVar.d(1);
        e(mVar);
        String a2 = com.opos.exoplayer.core.i.j.a(mVar.g());
        if ("audio/mpeg".equals(a2) || o.D.equals(a2) || o.E.equals(a2)) {
            return Pair.create(a2, null);
        }
        mVar.d(12);
        mVar.d(1);
        int e2 = e(mVar);
        byte[] bArr = new byte[e2];
        mVar.a(bArr, 0, e2);
        return Pair.create(a2, bArr);
    }

    private static byte[] d(com.opos.exoplayer.core.i.m mVar, int i, int i2) {
        int i3 = i;
        int i4 = 8;
        while (true) {
            int i5 = i3 + i4;
            if (i5 - i >= i2) {
                return null;
            }
            mVar.c(i5);
            int o = mVar.o();
            if (mVar.o() == g.aJ) {
                return Arrays.copyOfRange(mVar.f25496a, i5, o + i5);
            }
            i3 = i5;
            i4 = o;
        }
    }

    private static int e(com.opos.exoplayer.core.i.m mVar) {
        int g2 = mVar.g();
        int i = g2 & 127;
        while (true) {
            int i2 = i;
            if ((g2 & 128) != 128) {
                return i2;
            }
            g2 = mVar.g();
            i = (i2 << 7) | (g2 & 127);
        }
    }
}
