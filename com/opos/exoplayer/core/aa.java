package com.opos.exoplayer.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.opos.exoplayer.core.e.d;
import com.opos.exoplayer.core.e.e;
import com.opos.exoplayer.core.f;
import com.opos.exoplayer.core.g.h;
import com.opos.exoplayer.core.r;
import com.opos.exoplayer.core.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/aa.class */
public final class aa implements Handler.Callback, d.a, e.a, f.a, h.a, r.a {
    private int A;
    private boolean B;
    private int C;
    private d D;
    private long E;
    private int F;

    /* renamed from: a  reason: collision with root package name */
    private final s[] f11358a;
    private final t[] b;

    /* renamed from: c  reason: collision with root package name */
    private final com.opos.exoplayer.core.g.h f11359c;
    private final com.opos.exoplayer.core.g.i d;
    private final n e;
    private final com.opos.exoplayer.core.i.g f;
    private final HandlerThread g;
    private final Handler h;
    private final i i;
    private final y.b j;
    private final y.a k;
    private final long l;
    private final boolean m;
    private final f n;
    private final ArrayList<b> p;
    private final com.opos.exoplayer.core.i.b q;
    private ae t;
    private com.opos.exoplayer.core.e.e u;
    private s[] v;
    private boolean w;
    private boolean y;
    private boolean z;
    private volatile boolean x = false;
    private final ad r = new ad();
    private w s = w.e;
    private final c o = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/aa$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.opos.exoplayer.core.e.e f11361a;
        public final y b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f11362c;

        public a(com.opos.exoplayer.core.e.e eVar, y yVar, Object obj) {
            this.f11361a = eVar;
            this.b = yVar;
            this.f11362c = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/aa$b.class */
    public static final class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        public final r f11363a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public long f11364c;
        public Object d;

        public b(r rVar) {
            this.f11363a = rVar;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            if ((this.d == null) != (bVar.d == null)) {
                return this.d != null ? -1 : 1;
            } else if (this.d == null) {
                return 0;
            } else {
                int i = this.b - bVar.b;
                int i2 = i;
                if (i == 0) {
                    i2 = com.opos.exoplayer.core.i.u.a(this.f11364c, bVar.f11364c);
                }
                return i2;
            }
        }

        public void a(int i, long j, Object obj) {
            this.b = i;
            this.f11364c = j;
            this.d = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/aa$c.class */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private ae f11365a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f11366c;
        private int d;

        private c() {
        }

        public void a(int i) {
            this.b += i;
        }

        public boolean a(ae aeVar) {
            return aeVar != this.f11365a || this.b > 0 || this.f11366c;
        }

        public void b(int i) {
            boolean z = true;
            if (!this.f11366c || this.d == 4) {
                this.f11366c = true;
                this.d = i;
                return;
            }
            if (i != 4) {
                z = false;
            }
            com.opos.exoplayer.core.i.a.a(z);
        }

        public void b(ae aeVar) {
            this.f11365a = aeVar;
            this.b = 0;
            this.f11366c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/aa$d.class */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final y f11367a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final long f11368c;

        public d(y yVar, int i, long j) {
            this.f11367a = yVar;
            this.b = i;
            this.f11368c = j;
        }
    }

    public aa(s[] sVarArr, com.opos.exoplayer.core.g.h hVar, com.opos.exoplayer.core.g.i iVar, n nVar, boolean z, int i, boolean z2, Handler handler, i iVar2, com.opos.exoplayer.core.i.b bVar) {
        this.f11358a = sVarArr;
        this.f11359c = hVar;
        this.d = iVar;
        this.e = nVar;
        this.y = z;
        this.A = i;
        this.B = z2;
        this.h = handler;
        this.i = iVar2;
        this.q = bVar;
        this.l = nVar.e();
        this.m = nVar.f();
        this.t = new ae(y.f11905a, com.anythink.expressad.exoplayer.b.b, iVar);
        this.b = new t[sVarArr.length];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= sVarArr.length) {
                this.n = new f(this, bVar);
                this.p = new ArrayList<>();
                this.v = new s[0];
                this.j = new y.b();
                this.k = new y.a();
                hVar.a((h.a) this);
                HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
                this.g = handlerThread;
                handlerThread.start();
                this.f = bVar.a(this.g.getLooper(), this);
                return;
            }
            sVarArr[i3].a(i3);
            this.b[i3] = sVarArr[i3].b();
            i2 = i3 + 1;
        }
    }

    private int a(int i, y yVar, y yVar2) {
        int c2 = yVar.c();
        int i2 = i;
        int i3 = -1;
        for (int i4 = 0; i4 < c2 && i3 == -1; i4++) {
            i2 = yVar.a(i2, this.k, this.j, this.A, this.B);
            if (i2 == -1) {
                return i3;
            }
            i3 = yVar2.a(yVar.a(i2, this.k, true).b);
        }
        return i3;
    }

    private long a(e.b bVar, long j) {
        return a(bVar, j, this.r.c() != this.r.d());
    }

    private long a(e.b bVar, long j, boolean z) {
        ab abVar;
        e();
        this.z = false;
        b(2);
        ab c2 = this.r.c();
        ab abVar2 = c2;
        while (true) {
            abVar = abVar2;
            if (abVar == null) {
                break;
            } else if (a(bVar, j, abVar)) {
                this.r.a(abVar);
                break;
            } else {
                abVar2 = this.r.h();
            }
        }
        if (c2 != abVar || z) {
            s[] sVarArr = this.v;
            int length = sVarArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                b(sVarArr[i2]);
                i = i2 + 1;
            }
            this.v = new s[0];
            c2 = null;
        }
        if (abVar != null) {
            a(c2);
            long j2 = j;
            if (abVar.g) {
                j2 = abVar.f11369a.b(j);
                abVar.f11369a.a(j2 - this.l, this.m);
            }
            a(j2);
            q();
            j = j2;
        } else {
            this.r.i();
            a(j);
        }
        this.f.a(2);
        return j;
    }

    private Pair<Integer, Long> a(d dVar, boolean z) {
        y yVar = this.t.f11375a;
        y yVar2 = dVar.f11367a;
        if (yVar.a()) {
            return null;
        }
        y yVar3 = yVar2;
        if (yVar2.a()) {
            yVar3 = yVar;
        }
        try {
            Pair<Integer, Long> a2 = yVar3.a(this.j, this.k, dVar.b, dVar.f11368c);
            if (yVar == yVar3) {
                return a2;
            }
            int a3 = yVar.a(yVar3.a(a2.first.intValue(), this.k, true).b);
            if (a3 != -1) {
                return Pair.create(Integer.valueOf(a3), a2.second);
            }
            Pair<Integer, Long> pair = null;
            if (z) {
                int a4 = a(a2.first.intValue(), yVar3, yVar);
                pair = null;
                if (a4 != -1) {
                    pair = b(yVar, yVar.a(a4, this.k).f11907c, com.anythink.expressad.exoplayer.b.b);
                }
            }
            return pair;
        } catch (IndexOutOfBoundsException e) {
            throw new m(yVar, dVar.b, dVar.f11368c);
        }
    }

    private void a(float f) {
        ab e = this.r.e();
        while (true) {
            ab abVar = e;
            if (abVar == null) {
                return;
            }
            if (abVar.j != null) {
                com.opos.exoplayer.core.g.f[] a2 = abVar.j.f11751c.a();
                int length = a2.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < length) {
                        com.opos.exoplayer.core.g.f fVar = a2[i2];
                        if (fVar != null) {
                            fVar.a(f);
                        }
                        i = i2 + 1;
                    }
                }
            }
            e = abVar.i;
        }
    }

    private void a(int i, boolean z, int i2) {
        ab c2 = this.r.c();
        s sVar = this.f11358a[i];
        this.v[i2] = sVar;
        if (sVar.a_() == 0) {
            u uVar = c2.j.e[i];
            Format[] a2 = a(c2.j.f11751c.a(i));
            boolean z2 = this.y && this.t.f == 3;
            sVar.a(uVar, a2, c2.f11370c[i], this.E, !z && z2, c2.a());
            this.n.a(sVar);
            if (z2) {
                sVar.b_();
            }
        }
    }

    private void a(long j) {
        long a2 = !this.r.f() ? j + 60000000 : this.r.c().a(j);
        this.E = a2;
        this.n.a(a2);
        s[] sVarArr = this.v;
        int length = sVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            sVarArr[i2].a(this.E);
            i = i2 + 1;
        }
    }

    private void a(long j, long j2) {
        this.f.b(2);
        this.f.a(2, j + j2);
    }

    private void a(a aVar) {
        e.b a2;
        ae aeVar;
        ae a3;
        ae aeVar2;
        e.b bVar;
        long j;
        ae aeVar3;
        e.b bVar2;
        long j2;
        e.b bVar3;
        if (aVar.f11361a != this.u) {
            return;
        }
        y yVar = this.t.f11375a;
        y yVar2 = aVar.b;
        Object obj = aVar.f11362c;
        this.r.a(yVar2);
        this.t = this.t.a(yVar2, obj);
        j();
        int i = this.C;
        long j3 = 0;
        if (i > 0) {
            this.o.a(i);
            this.C = 0;
            d dVar = this.D;
            if (dVar != null) {
                Pair<Integer, Long> a4 = a(dVar, true);
                this.D = null;
                if (a4 != null) {
                    int intValue = a4.first.intValue();
                    long longValue = a4.second.longValue();
                    e.b a5 = this.r.a(intValue, longValue);
                    ae aeVar4 = this.t;
                    aeVar2 = aeVar4;
                    bVar = a5;
                    j = longValue;
                    if (a5.a()) {
                        j = longValue;
                        bVar2 = a5;
                        aeVar3 = aeVar4;
                        j2 = 0;
                        bVar3 = bVar2;
                    }
                    j2 = j;
                    bVar3 = bVar;
                    aeVar3 = aeVar2;
                }
                n();
                return;
            } else if (this.t.d == com.anythink.expressad.exoplayer.b.b) {
                if (!yVar2.a()) {
                    Pair<Integer, Long> b2 = b(yVar2, yVar2.b(this.B), com.anythink.expressad.exoplayer.b.b);
                    int intValue2 = b2.first.intValue();
                    long longValue2 = b2.second.longValue();
                    e.b a6 = this.r.a(intValue2, longValue2);
                    ae aeVar5 = this.t;
                    aeVar2 = aeVar5;
                    bVar = a6;
                    j = longValue2;
                    if (a6.a()) {
                        aeVar3 = aeVar5;
                        bVar2 = a6;
                        j = longValue2;
                        j2 = 0;
                        bVar3 = bVar2;
                    }
                    j2 = j;
                    bVar3 = bVar;
                    aeVar3 = aeVar2;
                }
                n();
                return;
            } else {
                return;
            }
            a3 = aeVar3.a(bVar3, j2, j);
            this.t = a3;
        }
        int i2 = this.t.f11376c.f11598a;
        long j4 = this.t.e;
        if (!yVar.a()) {
            ab e = this.r.e();
            int a7 = yVar2.a(e == null ? yVar.a(i2, this.k, true).b : e.b);
            if (a7 != -1) {
                if (a7 != i2) {
                    this.t = this.t.a(a7);
                }
                e.b bVar4 = this.t.f11376c;
                if (bVar4.a()) {
                    a2 = this.r.a(a7, j4);
                    if (!a2.equals(bVar4)) {
                        if (!a2.a()) {
                            j3 = j4;
                        }
                        j3 = a(a2, j3);
                        aeVar = this.t;
                    }
                }
                if (this.r.a(bVar4, this.E)) {
                    return;
                }
                e(false);
                return;
            }
            int a8 = a(i2, yVar, yVar2);
            if (a8 != -1) {
                Pair<Integer, Long> b3 = b(yVar2, yVar2.a(a8, this.k).f11907c, com.anythink.expressad.exoplayer.b.b);
                int intValue3 = b3.first.intValue();
                long longValue3 = b3.second.longValue();
                e.b a9 = this.r.a(intValue3, longValue3);
                yVar2.a(intValue3, this.k, true);
                if (e != null) {
                    Object obj2 = this.k.b;
                    ab abVar = e;
                    loop0: while (true) {
                        ab abVar2 = abVar;
                        ac a10 = abVar.h.a(-1);
                        while (true) {
                            abVar2.h = a10;
                            if (abVar2.i == null) {
                                break loop0;
                            }
                            abVar2 = abVar2.i;
                            abVar = abVar2;
                            if (abVar2.b.equals(obj2)) {
                                a10 = this.r.a(abVar2.h, intValue3);
                            }
                        }
                    }
                }
                if (!a9.a()) {
                    j3 = longValue3;
                }
                a3 = this.t.a(a9, a(a9, j3), longValue3);
                this.t = a3;
            }
            n();
            return;
        } else if (yVar2.a()) {
            return;
        } else {
            a2 = this.r.a(i2, j4);
            aeVar = this.t;
            if (!a2.a()) {
                j3 = j4;
            }
        }
        a3 = aeVar.a(a2, j3, j4);
        this.t = a3;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00b6 A[Catch: all -> 0x016f, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x016f, blocks: (B:14:0x009c, B:16:0x00a3, B:21:0x00b6, B:22:0x00c5, B:24:0x00d4, B:28:0x00e7, B:30:0x00ff, B:32:0x0112, B:37:0x0137, B:41:0x014c), top: B:56:0x009c }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c5 A[Catch: all -> 0x016f, TRY_ENTER, TryCatch #0 {all -> 0x016f, blocks: (B:14:0x009c, B:16:0x00a3, B:21:0x00b6, B:22:0x00c5, B:24:0x00d4, B:28:0x00e7, B:30:0x00ff, B:32:0x0112, B:37:0x0137, B:41:0x014c), top: B:56:0x009c }] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.opos.exoplayer.core.aa.d r9) {
        /*
            Method dump skipped, instructions count: 419
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.aa.a(com.opos.exoplayer.core.aa$d):void");
    }

    private void a(ab abVar) {
        ab c2 = this.r.c();
        if (c2 == null || abVar == c2) {
            return;
        }
        boolean[] zArr = new boolean[this.f11358a.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            s[] sVarArr = this.f11358a;
            if (i >= sVarArr.length) {
                this.t = this.t.a(c2.j);
                a(zArr, i3);
                return;
            }
            s sVar = sVarArr[i];
            zArr[i] = sVar.a_() != 0;
            int i4 = i3;
            if (c2.j.b[i]) {
                i4 = i3 + 1;
            }
            if (zArr[i] && (!c2.j.b[i] || (sVar.i() && sVar.f() == abVar.f11370c[i]))) {
                b(sVar);
            }
            i++;
            i2 = i4;
        }
    }

    private void a(com.opos.exoplayer.core.g.i iVar) {
        this.e.a(this.f11358a, iVar.f11750a, iVar.f11751c);
    }

    private void a(s sVar) {
        if (sVar.a_() == 2) {
            sVar.k();
        }
    }

    private void a(w wVar) {
        this.s = wVar;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private void a(boolean z, boolean z2) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private void a(boolean z, boolean z2, boolean z3) {
        com.opos.exoplayer.core.e.e eVar;
        this.f.b(2);
        this.z = false;
        this.n.b();
        this.E = 60000000L;
        s[] sVarArr = this.v;
        int length = sVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            try {
                b(sVarArr[i2]);
            } catch (h | RuntimeException e) {
                com.opos.cmn.an.f.a.d("ExoPlayerImplInternal", "Stop failed.", e);
            }
            i = i2 + 1;
        }
        this.v = new s[0];
        this.r.i();
        b(false);
        if (z2) {
            this.D = null;
        }
        if (z3) {
            this.r.a(y.f11905a);
            Iterator<b> it = this.p.iterator();
            while (it.hasNext()) {
                it.next().f11363a.a(false);
            }
            this.p.clear();
            this.F = 0;
        }
        y yVar = z3 ? y.f11905a : this.t.f11375a;
        Object obj = z3 ? null : this.t.b;
        e.b bVar = z2 ? new e.b(i()) : this.t.f11376c;
        long j = -9223372036854775807L;
        long j2 = z2 ? -9223372036854775807L : this.t.i;
        if (!z2) {
            j = this.t.e;
        }
        this.t = new ae(yVar, obj, bVar, j2, j, this.t.f, false, z3 ? this.d : this.t.h);
        if (!z || (eVar = this.u) == null) {
            return;
        }
        eVar.b();
        this.u = null;
    }

    private void a(boolean[] zArr, int i) {
        this.v = new s[i];
        ab c2 = this.r.c();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i2 >= this.f11358a.length) {
                return;
            }
            int i5 = i4;
            if (c2.j.b[i2]) {
                a(i2, zArr[i2], i4);
                i5 = i4 + 1;
            }
            i2++;
            i3 = i5;
        }
    }

    private boolean a(b bVar) {
        if (bVar.d == null) {
            Pair<Integer, Long> a2 = a(new d(bVar.f11363a.a(), bVar.f11363a.g(), com.opos.exoplayer.core.b.b(bVar.f11363a.f())), false);
            if (a2 == null) {
                return false;
            }
            bVar.a(a2.first.intValue(), a2.second.longValue(), this.t.f11375a.a(a2.first.intValue(), this.k, true).b);
            return true;
        }
        int a3 = this.t.f11375a.a(bVar.d);
        if (a3 != -1) {
            bVar.b = a3;
            return true;
        }
        return false;
    }

    private boolean a(e.b bVar, long j, ab abVar) {
        if (bVar.equals(abVar.h.f11371a) && abVar.f) {
            this.t.f11375a.a(abVar.h.f11371a.f11598a, this.k);
            int b2 = this.k.b(j);
            return b2 == -1 || this.k.a(b2) == abVar.h.f11372c;
        }
        return false;
    }

    private static Format[] a(com.opos.exoplayer.core.g.f fVar) {
        int e = fVar != null ? fVar.e() : 0;
        Format[] formatArr = new Format[e];
        for (int i = 0; i < e; i++) {
            formatArr[i] = fVar.a(i);
        }
        return formatArr;
    }

    private Pair<Integer, Long> b(y yVar, int i, long j) {
        return yVar.a(this.j, this.k, i, j);
    }

    private void b(int i) {
        if (this.t.f != i) {
            this.t = this.t.b(i);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b7, code lost:
        if (r5.F < r5.p.size()) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ba, code lost:
        r16 = r5.p.get(r5.F);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00cd, code lost:
        r16 = null;
        r6 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d3, code lost:
        r17 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d9, code lost:
        if (r16 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00dc, code lost:
        r17 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00e5, code lost:
        if (r16.d == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ef, code lost:
        if (r16.b < r0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00f2, code lost:
        r17 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00fd, code lost:
        if (r16.b != r0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0100, code lost:
        r17 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x010b, code lost:
        if (r16.f11364c > r6) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x010e, code lost:
        r0 = r5.F + 1;
        r5.F = r0;
        r12 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0128, code lost:
        if (r0 >= r5.p.size()) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0130, code lost:
        if (r17 == null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0138, code lost:
        if (r17.d == null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0142, code lost:
        if (r17.b != r0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x014c, code lost:
        if (r17.f11364c <= r6) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0156, code lost:
        if (r17.f11364c > r8) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0159, code lost:
        c(r17.f11363a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x016a, code lost:
        if (r17.f11363a.h() == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x016d, code lost:
        r5.p.remove(r5.F);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x017c, code lost:
        r5.F++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0191, code lost:
        if (r5.F >= r5.p.size()) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0194, code lost:
        r17 = r5.p.get(r5.F);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01a7, code lost:
        r17 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:?, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0061 -> B:15:0x0067). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00a0 -> B:13:0x0050). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00cd -> B:30:0x00d3). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0128 -> B:28:0x00ba). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(long r6, long r8) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.aa.b(long, long):void");
    }

    private void b(com.opos.exoplayer.core.e.e eVar, boolean z, boolean z2) {
        this.C++;
        a(true, z, z2);
        this.e.a();
        this.u = eVar;
        b(2);
        eVar.a(this.i, true, this);
        this.f.a(2);
    }

    private void b(p pVar) {
        this.n.a(pVar);
    }

    private void b(r rVar) {
        if (rVar.f() == com.anythink.expressad.exoplayer.b.b) {
            c(rVar);
        } else if (this.u == null || this.C > 0) {
            this.p.add(new b(rVar));
        } else {
            b bVar = new b(rVar);
            if (!a(bVar)) {
                rVar.a(false);
                return;
            }
            this.p.add(bVar);
            Collections.sort(this.p);
        }
    }

    private void b(s sVar) {
        this.n.b(sVar);
        a(sVar);
        sVar.l();
    }

    private void b(boolean z) {
        if (this.t.g != z) {
            this.t = this.t.a(z);
        }
    }

    private void c() {
        if (this.o.a(this.t)) {
            this.h.obtainMessage(0, this.o.b, this.o.f11366c ? this.o.d : -1, this.t).sendToTarget();
            this.o.b(this.t);
        }
    }

    private void c(int i) {
        this.A = i;
        if (this.r.a(i)) {
            return;
        }
        e(true);
    }

    private void c(com.opos.exoplayer.core.e.d dVar) {
        if (this.r.a(dVar)) {
            a(this.r.a(this.n.e().b));
            if (!this.r.f()) {
                a(this.r.h().h.b);
                a((ab) null);
            }
            q();
        }
    }

    private void c(r rVar) {
        if (rVar.e().getLooper() != this.f.a()) {
            this.f.a(15, rVar).sendToTarget();
            return;
        }
        e(rVar);
        if (this.t.f == 3 || this.t.f == 2) {
            this.f.a(2);
        }
    }

    private void c(boolean z) {
        this.z = false;
        this.y = z;
        if (!z) {
            e();
            f();
            return;
        }
        if (this.t.f == 3) {
            d();
        } else if (this.t.f != 2) {
            return;
        }
        this.f.a(2);
    }

    private boolean c(s sVar) {
        ab d2 = this.r.d();
        return d2.i != null && d2.i.f && sVar.g();
    }

    private void d() {
        this.z = false;
        this.n.a();
        for (s sVar : this.v) {
            sVar.b_();
        }
    }

    private void d(com.opos.exoplayer.core.e.d dVar) {
        if (this.r.a(dVar)) {
            this.r.a(this.E);
            q();
        }
    }

    private void d(final r rVar) {
        rVar.e().post(new Runnable() { // from class: com.opos.exoplayer.core.aa.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    aa.this.e(rVar);
                } catch (h e) {
                    com.opos.cmn.an.f.a.d("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e);
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void d(boolean z) {
        this.B = z;
        if (this.r.a(z)) {
            return;
        }
        e(true);
    }

    private void e() {
        this.n.b();
        s[] sVarArr = this.v;
        int length = sVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            a(sVarArr[i2]);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(r rVar) {
        try {
            rVar.b().a(rVar.c(), rVar.d());
        } finally {
            rVar.a(true);
        }
    }

    private void e(boolean z) {
        e.b bVar = this.r.c().h.f11371a;
        long a2 = a(bVar, this.t.i, true);
        if (a2 != this.t.i) {
            ae aeVar = this.t;
            this.t = aeVar.a(bVar, a2, aeVar.e);
            if (z) {
                this.o.b(4);
            }
        }
    }

    private void f() {
        if (this.r.f()) {
            ab c2 = this.r.c();
            long c3 = c2.f11369a.c();
            if (c3 != com.anythink.expressad.exoplayer.b.b) {
                a(c3);
                if (c3 != this.t.i) {
                    ae aeVar = this.t;
                    this.t = aeVar.a(aeVar.f11376c, c3, this.t.e);
                    this.o.b(4);
                }
            } else {
                long c4 = this.n.c();
                this.E = c4;
                long b2 = c2.b(c4);
                b(this.t.i, b2);
                this.t.i = b2;
            }
            this.t.j = this.v.length == 0 ? c2.h.e : c2.a(true);
        }
    }

    private boolean f(boolean z) {
        boolean z2;
        if (this.v.length == 0) {
            return l();
        }
        if (z) {
            if (this.t.g) {
                ab b2 = this.r.b();
                long a2 = b2.a(!b2.h.g);
                z2 = true;
                if (a2 != Long.MIN_VALUE) {
                    if (this.e.a(a2 - b2.b(this.E), this.n.e().b, this.z)) {
                        return true;
                    }
                }
                return z2;
            }
            return true;
        }
        z2 = false;
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0190  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void g() {
        /*
            Method dump skipped, instructions count: 519
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.aa.g():void");
    }

    private void h() {
        a(true, true, true);
        this.e.c();
        b(1);
        this.g.quit();
        synchronized (this) {
            this.w = true;
            notifyAll();
        }
    }

    private int i() {
        y yVar = this.t.f11375a;
        if (yVar.a()) {
            return 0;
        }
        return yVar.a(yVar.b(this.B), this.j).f;
    }

    private void j() {
        int size = this.p.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                Collections.sort(this.p);
                return;
            }
            if (!a(this.p.get(i))) {
                this.p.get(i).f11363a.a(false);
                this.p.remove(i);
            }
            size = i;
        }
    }

    private void k() {
        int i;
        if (this.r.f()) {
            float f = this.n.e().b;
            ab d2 = this.r.d();
            boolean z = true;
            for (ab c2 = this.r.c(); c2 != null && c2.f; c2 = c2.i) {
                if (c2.b(f)) {
                    if (z) {
                        ab c3 = this.r.c();
                        boolean a2 = this.r.a(c3);
                        boolean[] zArr = new boolean[this.f11358a.length];
                        long a3 = c3.a(this.t.i, a2, zArr);
                        a(c3.j);
                        if (this.t.f != 4 && a3 != this.t.i) {
                            ae aeVar = this.t;
                            this.t = aeVar.a(aeVar.f11376c, a3, this.t.e);
                            this.o.b(4);
                            a(a3);
                        }
                        boolean[] zArr2 = new boolean[this.f11358a.length];
                        int i2 = 0;
                        int i3 = 0;
                        while (true) {
                            i = i3;
                            s[] sVarArr = this.f11358a;
                            if (i2 >= sVarArr.length) {
                                break;
                            }
                            s sVar = sVarArr[i2];
                            zArr2[i2] = sVar.a_() != 0;
                            com.opos.exoplayer.core.e.i iVar = c3.f11370c[i2];
                            int i4 = i;
                            if (iVar != null) {
                                i4 = i + 1;
                            }
                            if (zArr2[i2]) {
                                if (iVar != sVar.f()) {
                                    b(sVar);
                                } else if (zArr[i2]) {
                                    sVar.a(this.E);
                                }
                            }
                            i2++;
                            i3 = i4;
                        }
                        this.t = this.t.a(c3.j);
                        a(zArr2, i);
                    } else {
                        this.r.a(c2);
                        if (c2.f) {
                            c2.a(Math.max(c2.h.b, c2.b(this.E)), false);
                            a(c2.j);
                        }
                    }
                    if (this.t.f != 4) {
                        q();
                        f();
                        this.f.a(2);
                        return;
                    }
                    return;
                }
                if (c2 == d2) {
                    z = false;
                }
            }
        }
    }

    private boolean l() {
        ab c2 = this.r.c();
        long j = c2.h.e;
        if (j == com.anythink.expressad.exoplayer.b.b || this.t.i < j) {
            return true;
        }
        if (c2.i != null) {
            return c2.i.f || c2.i.h.f11371a.a();
        }
        return false;
    }

    private void m() {
        ab b2 = this.r.b();
        ab d2 = this.r.d();
        if (b2 == null || b2.f) {
            return;
        }
        if (d2 != null && d2.i != b2) {
            return;
        }
        s[] sVarArr = this.v;
        int length = sVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                b2.f11369a.c_();
                return;
            } else if (!sVarArr[i2].g()) {
                return;
            } else {
                i = i2 + 1;
            }
        }
    }

    private void n() {
        b(4);
        a(false, true, false);
    }

    private void o() {
        com.opos.exoplayer.core.e.e eVar = this.u;
        if (eVar == null) {
            return;
        }
        if (this.C > 0) {
            eVar.a();
            return;
        }
        p();
        ab b2 = this.r.b();
        if (b2 == null || b2.b()) {
            b(false);
        } else if (!this.t.g) {
            q();
        }
        if (!this.r.f()) {
            return;
        }
        ab c2 = this.r.c();
        ab d2 = this.r.d();
        boolean z = false;
        while (true) {
            boolean z2 = z;
            if (!this.y || c2 == d2 || this.E < c2.i.e) {
                break;
            }
            if (z2) {
                c();
            }
            int i = c2.h.f ? 0 : 3;
            ab h = this.r.h();
            a(c2);
            this.t = this.t.a(h.h.f11371a, h.h.b, h.h.d);
            this.o.b(i);
            f();
            c2 = h;
            z = true;
        }
        if (d2.h.g) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                s[] sVarArr = this.f11358a;
                if (i3 >= sVarArr.length) {
                    return;
                }
                s sVar = sVarArr[i3];
                com.opos.exoplayer.core.e.i iVar = d2.f11370c[i3];
                if (iVar != null && sVar.f() == iVar && sVar.g()) {
                    sVar.h();
                }
                i2 = i3 + 1;
            }
        } else if (d2.i == null || !d2.i.f) {
        } else {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                s[] sVarArr2 = this.f11358a;
                if (i5 < sVarArr2.length) {
                    s sVar2 = sVarArr2[i5];
                    com.opos.exoplayer.core.e.i iVar2 = d2.f11370c[i5];
                    if (sVar2.f() != iVar2) {
                        return;
                    }
                    if (iVar2 != null && !sVar2.g()) {
                        return;
                    }
                    i4 = i5 + 1;
                } else {
                    com.opos.exoplayer.core.g.i iVar3 = d2.j;
                    ab g = this.r.g();
                    com.opos.exoplayer.core.g.i iVar4 = g.j;
                    boolean z3 = g.f11369a.c() != com.anythink.expressad.exoplayer.b.b;
                    int i6 = 0;
                    while (true) {
                        int i7 = i6;
                        s[] sVarArr3 = this.f11358a;
                        if (i7 >= sVarArr3.length) {
                            return;
                        }
                        s sVar3 = sVarArr3[i7];
                        if (iVar3.b[i7]) {
                            if (!z3) {
                                if (!sVar3.i()) {
                                    com.opos.exoplayer.core.g.f a2 = iVar4.f11751c.a(i7);
                                    boolean z4 = iVar4.b[i7];
                                    boolean z5 = this.b[i7].a() == 5;
                                    u uVar = iVar3.e[i7];
                                    u uVar2 = iVar4.e[i7];
                                    if (z4 && uVar2.equals(uVar) && !z5) {
                                        sVar3.a(a(a2), g.f11370c[i7], g.a());
                                    }
                                }
                            }
                            sVar3.h();
                        }
                        i6 = i7 + 1;
                    }
                }
            }
        }
    }

    private void p() {
        this.r.a(this.E);
        if (this.r.a()) {
            ac a2 = this.r.a(this.E, this.t);
            if (a2 == null) {
                this.u.a();
                return;
            }
            this.r.a(this.b, 60000000L, this.f11359c, this.e.d(), this.u, this.t.f11375a.a(a2.f11371a.f11598a, this.k, true).b, a2).a(this, a2.b);
            b(true);
        }
    }

    private void q() {
        ab b2 = this.r.b();
        long c2 = b2.c();
        if (c2 == Long.MIN_VALUE) {
            b(false);
            return;
        }
        boolean a2 = this.e.a(c2 - b2.b(this.E), this.n.e().b);
        b(a2);
        if (a2) {
            b2.d(this.E);
        }
    }

    public void a() {
        synchronized (this) {
            this.x = true;
            if (!this.w) {
                this.f.a(7);
                boolean z = false;
                while (!this.w) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        z = true;
                    }
                }
                if (z) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void a(int i) {
        this.f.a(12, i, 0).sendToTarget();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.opos.exoplayer.core.e.d.a
    public void a(com.opos.exoplayer.core.e.d dVar) {
        this.f.a(9, dVar).sendToTarget();
    }

    @Override // com.opos.exoplayer.core.e.e.a
    public void a(com.opos.exoplayer.core.e.e eVar, y yVar, Object obj) {
        this.f.a(8, new a(eVar, yVar, obj)).sendToTarget();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void a(com.opos.exoplayer.core.e.e eVar, boolean z, boolean z2) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // com.opos.exoplayer.core.f.a
    public void a(p pVar) {
        this.h.obtainMessage(1, pVar).sendToTarget();
        a(pVar.b);
    }

    @Override // com.opos.exoplayer.core.r.a
    public void a(r rVar) {
        synchronized (this) {
            if (!this.x && !this.w) {
                this.f.a(14, rVar).sendToTarget();
            }
            com.opos.cmn.an.f.a.c("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            rVar.a(false);
        }
    }

    public void a(y yVar, int i, long j) {
        this.f.a(3, new d(yVar, i, j)).sendToTarget();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void a(boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public Looper b() {
        return this.g.getLooper();
    }

    @Override // com.opos.exoplayer.core.e.j.a
    /* renamed from: b */
    public void a(com.opos.exoplayer.core.e.d dVar) {
        this.f.a(10, dVar).sendToTarget();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        h e;
        try {
            switch (message.what) {
                case 0:
                    b((com.opos.exoplayer.core.e.e) message.obj, message.arg1 != 0, message.arg2 != 0);
                    break;
                case 1:
                    c(message.arg1 != 0);
                    break;
                case 2:
                    g();
                    break;
                case 3:
                    a((d) message.obj);
                    break;
                case 4:
                    b((p) message.obj);
                    break;
                case 5:
                    a((w) message.obj);
                    break;
                case 6:
                    a(message.arg1 != 0, true);
                    break;
                case 7:
                    h();
                    return true;
                case 8:
                    a((a) message.obj);
                    break;
                case 9:
                    c((com.opos.exoplayer.core.e.d) message.obj);
                    break;
                case 10:
                    d((com.opos.exoplayer.core.e.d) message.obj);
                    break;
                case 11:
                    k();
                    break;
                case 12:
                    c(message.arg1);
                    break;
                case 13:
                    d(message.arg1 != 0);
                    break;
                case 14:
                    b((r) message.obj);
                    break;
                case 15:
                    d((r) message.obj);
                    break;
                default:
                    return false;
            }
            c();
            return true;
        } catch (h e2) {
            e = e2;
            com.opos.cmn.an.f.a.d("ExoPlayerImplInternal", "Playback error.", e);
            a(false, false);
            handler = this.h;
            handler.obtainMessage(2, e).sendToTarget();
            c();
            return true;
        } catch (IOException e3) {
            com.opos.cmn.an.f.a.d("ExoPlayerImplInternal", "Source error.", e3);
            a(false, false);
            handler = this.h;
            e = h.a(e3);
            handler.obtainMessage(2, e).sendToTarget();
            c();
            return true;
        } catch (RuntimeException e4) {
            com.opos.cmn.an.f.a.d("ExoPlayerImplInternal", "Internal runtime error.", e4);
            a(false, false);
            handler = this.h;
            e = h.a(e4);
            handler.obtainMessage(2, e).sendToTarget();
            c();
            return true;
        }
    }
}
