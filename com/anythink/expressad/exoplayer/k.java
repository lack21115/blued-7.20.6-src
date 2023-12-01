package com.anythink.expressad.exoplayer;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import com.anythink.expressad.exoplayer.ae;
import com.anythink.expressad.exoplayer.e;
import com.anythink.expressad.exoplayer.h.r;
import com.anythink.expressad.exoplayer.h.s;
import com.anythink.expressad.exoplayer.i.h;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k.class */
final class k implements Handler.Callback, e.a, r.a, s.b, h.a, x.a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f4783a = 0;
    public static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f4784c = 2;
    private static final String d = "ExoPlayerImplInternal";
    private static final int e = 0;
    private static final int f = 1;
    private static final int g = 2;
    private static final int h = 3;
    private static final int i = 4;
    private static final int j = 5;
    private static final int k = 6;
    private static final int l = 7;
    private static final int m = 8;
    private static final int n = 9;
    private static final int o = 10;
    private static final int p = 11;
    private static final int q = 12;
    private static final int r = 13;
    private static final int s = 14;
    private static final int t = 15;
    private static final int u = 10;
    private static final int v = 10;
    private static final int w = 1000;
    private static final long x = 500;
    private final com.anythink.expressad.exoplayer.i.h A;
    private final com.anythink.expressad.exoplayer.i.i B;
    private final p C;
    private final com.anythink.expressad.exoplayer.k.k D;
    private final HandlerThread E;
    private final Handler F;
    private final h G;
    private final ae.b H;
    private final ae.a I;
    private final e L;
    private final ArrayList<b> N;
    private final com.anythink.expressad.exoplayer.k.c O;
    private u R;
    private com.anythink.expressad.exoplayer.h.s S;
    private y[] T;
    private boolean U;
    private boolean V;
    private boolean W;
    private int X;
    private boolean Y;
    private int Z;
    private d aa;
    private long ab;
    private int ac;
    private final y[] y;
    private final z[] z;
    private final s P = new s();
    private final long J = 0;
    private final boolean K = false;
    private ac Q = ac.e;
    private final c M = new c((byte) 0);

    /* renamed from: com.anythink.expressad.exoplayer.k$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k$1.class */
    final class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f4785a;

        AnonymousClass1(x xVar) {
            this.f4785a = xVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                k.f(this.f4785a);
            } catch (g e) {
                Log.e(k.d, "Unexpected error delivering message on external thread.", e);
                throw new RuntimeException(e);
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.anythink.expressad.exoplayer.h.s f4786a;
        public final ae b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f4787c;

        public a(com.anythink.expressad.exoplayer.h.s sVar, ae aeVar, Object obj) {
            this.f4786a = sVar;
            this.b = aeVar;
            this.f4787c = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k$b.class */
    public static final class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        public final x f4798a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public long f4799c;
        public Object d;

        public b(x xVar) {
            this.f4798a = xVar;
        }

        private int a(b bVar) {
            if ((this.d == null) != (bVar.d == null)) {
                return this.d != null ? -1 : 1;
            } else if (this.d == null) {
                return 0;
            } else {
                int i = this.b - bVar.b;
                return i != 0 ? i : af.b(this.f4799c, bVar.f4799c);
            }
        }

        public final void a(int i, long j, Object obj) {
            this.b = i;
            this.f4799c = j;
            this.d = obj;
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(b bVar) {
            b bVar2 = bVar;
            if ((this.d == null) != (bVar2.d == null)) {
                return this.d != null ? -1 : 1;
            } else if (this.d == null) {
                return 0;
            } else {
                int i = this.b - bVar2.b;
                return i != 0 ? i : af.b(this.f4799c, bVar2.f4799c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k$c.class */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private u f4802a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f4803c;
        private int d;

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        public final void a(int i) {
            this.b += i;
        }

        public final boolean a(u uVar) {
            return uVar != this.f4802a || this.b > 0 || this.f4803c;
        }

        public final void b(int i) {
            boolean z = true;
            if (!this.f4803c || this.d == 4) {
                this.f4803c = true;
                this.d = i;
                return;
            }
            if (i != 4) {
                z = false;
            }
            com.anythink.expressad.exoplayer.k.a.a(z);
        }

        public final void b(u uVar) {
            this.f4802a = uVar;
            this.b = 0;
            this.f4803c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k$d.class */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final ae f4806a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final long f4807c;

        public d(ae aeVar, int i, long j) {
            this.f4806a = aeVar;
            this.b = i;
            this.f4807c = j;
        }
    }

    public k(y[] yVarArr, com.anythink.expressad.exoplayer.i.h hVar, com.anythink.expressad.exoplayer.i.i iVar, p pVar, boolean z, int i2, boolean z2, Handler handler, h hVar2, com.anythink.expressad.exoplayer.k.c cVar) {
        this.y = yVarArr;
        this.A = hVar;
        this.B = iVar;
        this.C = pVar;
        this.V = z;
        this.X = i2;
        this.Y = z2;
        this.F = handler;
        this.G = hVar2;
        this.O = cVar;
        this.R = new u(ae.f4321a, com.anythink.expressad.exoplayer.b.b, com.anythink.expressad.exoplayer.h.af.f4580a, iVar);
        this.z = new z[yVarArr.length];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= yVarArr.length) {
                this.L = new e(this, cVar);
                this.N = new ArrayList<>();
                this.T = new y[0];
                this.H = new ae.b();
                this.I = new ae.a();
                hVar.a((h.a) this);
                HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
                this.E = handlerThread;
                handlerThread.start();
                this.D = cVar.a(this.E.getLooper(), this);
                return;
            }
            yVarArr[i4].a(i4);
            this.z[i4] = yVarArr[i4].b();
            i3 = i4 + 1;
        }
    }

    private int a(int i2, ae aeVar, ae aeVar2) {
        int c2 = aeVar.c();
        int i3 = i2;
        int i4 = -1;
        for (int i5 = 0; i5 < c2 && i4 == -1; i5++) {
            i3 = aeVar.a(i3, this.I, this.H, this.X, this.Y);
            if (i3 == -1) {
                break;
            }
            i4 = aeVar2.a(aeVar.a(i3, this.I, true).b);
        }
        return i4;
    }

    private long a(s.a aVar, long j2) {
        return a(aVar, j2, this.P.c() != this.P.d());
    }

    private long a(s.a aVar, long j2, boolean z) {
        q qVar;
        f();
        this.W = false;
        b(2);
        q c2 = this.P.c();
        q qVar2 = c2;
        while (true) {
            qVar = qVar2;
            if (qVar == null) {
                break;
            } else if (a(aVar, j2, qVar)) {
                this.P.a(qVar);
                break;
            } else {
                qVar2 = this.P.h();
            }
        }
        if (c2 != qVar || z) {
            y[] yVarArr = this.T;
            int length = yVarArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                }
                b(yVarArr[i3]);
                i2 = i3 + 1;
            }
            this.T = new y[0];
            c2 = null;
        }
        if (qVar != null) {
            a(c2);
            long j3 = j2;
            if (qVar.g) {
                j3 = qVar.f4885a.b(j2);
                qVar.f4885a.a(j3 - this.J, this.K);
            }
            a(j3);
            r();
            j2 = j3;
        } else {
            this.P.b(true);
            a(j2);
        }
        this.D.b(2);
        return j2;
    }

    private Pair<Integer, Long> a(ae aeVar, int i2) {
        return aeVar.a(this.H, this.I, i2, com.anythink.expressad.exoplayer.b.b);
    }

    private Pair<Integer, Long> a(d dVar, boolean z) {
        int a2;
        ae aeVar = this.R.f4899a;
        ae aeVar2 = dVar.f4806a;
        if (aeVar.a()) {
            return null;
        }
        ae aeVar3 = aeVar2;
        if (aeVar2.a()) {
            aeVar3 = aeVar;
        }
        try {
            Pair<Integer, Long> a3 = aeVar3.a(this.H, this.I, dVar.b, dVar.f4807c);
            if (aeVar == aeVar3) {
                return a3;
            }
            int a4 = aeVar.a(aeVar3.a(a3.first.intValue(), this.I, true).b);
            if (a4 != -1) {
                return Pair.create(Integer.valueOf(a4), a3.second);
            }
            if (!z || (a2 = a(a3.first.intValue(), aeVar3, aeVar)) == -1) {
                return null;
            }
            return a(aeVar, aeVar.a(a2, this.I, false).f4323c);
        } catch (IndexOutOfBoundsException e2) {
            throw new o(aeVar, dVar.b, dVar.f4807c);
        }
    }

    private void a(float f2) {
        q e2 = this.P.e();
        while (true) {
            q qVar = e2;
            if (qVar == null) {
                return;
            }
            if (qVar.k != null) {
                com.anythink.expressad.exoplayer.i.f[] a2 = qVar.k.f4709c.a();
                int length = a2.length;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < length) {
                        com.anythink.expressad.exoplayer.i.f fVar = a2[i3];
                        if (fVar != null) {
                            fVar.a(f2);
                        }
                        i2 = i3 + 1;
                    }
                }
            }
            e2 = qVar.i;
        }
    }

    private void a(int i2, boolean z, int i3) {
        q c2 = this.P.c();
        y yVar = this.y[i2];
        this.T[i3] = yVar;
        if (yVar.a_() == 0) {
            aa aaVar = c2.k.b[i2];
            m[] a2 = a(c2.k.f4709c.a(i2));
            boolean z2 = this.V && this.R.f == 3;
            yVar.a(aaVar, a2, c2.f4886c[i2], this.ab, !z && z2, c2.e);
            this.L.a(yVar);
            if (z2) {
                yVar.b_();
            }
        }
    }

    private void a(long j2) {
        if (this.P.f()) {
            j2 += this.P.c().e;
        }
        this.ab = j2;
        this.L.a(j2);
        y[] yVarArr = this.T;
        int length = yVarArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            yVarArr[i3].a(this.ab);
            i2 = i3 + 1;
        }
    }

    private void a(long j2, long j3) {
        this.D.b();
        this.D.a(j2 + j3);
    }

    private void a(com.anythink.expressad.exoplayer.i.i iVar) {
        this.C.a(this.y, iVar.f4709c);
    }

    private void a(a aVar) {
        if (aVar.f4786a != this.S) {
            return;
        }
        ae aeVar = this.R.f4899a;
        ae aeVar2 = aVar.b;
        Object obj = aVar.f4787c;
        this.P.a(aeVar2);
        this.R = this.R.a(aeVar2, obj);
        int size = this.N.size();
        while (true) {
            int i2 = size - 1;
            if (i2 < 0) {
                break;
            }
            if (!a(this.N.get(i2))) {
                this.N.get(i2).f4798a.a(false);
                this.N.remove(i2);
            }
            size = i2;
        }
        Collections.sort(this.N);
        int i3 = this.Z;
        long j2 = 0;
        if (i3 > 0) {
            this.M.a(i3);
            this.Z = 0;
            d dVar = this.aa;
            if (dVar != null) {
                Pair<Integer, Long> a2 = a(dVar, true);
                this.aa = null;
                if (a2 == null) {
                    o();
                    return;
                }
                int intValue = a2.first.intValue();
                long longValue = a2.second.longValue();
                s.a a3 = this.P.a(intValue, longValue);
                this.R = this.R.a(a3, a3.a() ? 0L : longValue, longValue);
                return;
            } else if (this.R.d == com.anythink.expressad.exoplayer.b.b) {
                if (aeVar2.a()) {
                    o();
                    return;
                }
                Pair<Integer, Long> a4 = a(aeVar2, aeVar2.b(this.Y));
                int intValue2 = a4.first.intValue();
                long longValue2 = a4.second.longValue();
                s.a a5 = this.P.a(intValue2, longValue2);
                this.R = this.R.a(a5, a5.a() ? 0L : longValue2, longValue2);
                return;
            } else {
                return;
            }
        }
        int i4 = this.R.f4900c.f4645a;
        long j3 = this.R.e;
        if (aeVar.a()) {
            if (aeVar2.a()) {
                return;
            }
            s.a a6 = this.P.a(i4, j3);
            this.R = this.R.a(a6, a6.a() ? 0L : j3, j3);
            return;
        }
        q e2 = this.P.e();
        int a7 = aeVar2.a(e2 == null ? aeVar.a(i4, this.I, true).b : e2.b);
        if (a7 != -1) {
            if (a7 != i4) {
                this.R = this.R.a(a7);
            }
            s.a aVar2 = this.R.f4900c;
            if (aVar2.a()) {
                s.a a8 = this.P.a(a7, j3);
                if (!a8.equals(aVar2)) {
                    if (!a8.a()) {
                        j2 = j3;
                    }
                    this.R = this.R.a(a8, a(a8, j2), j3);
                    return;
                }
            }
            if (this.P.a(aVar2, this.ab)) {
                return;
            }
            g(false);
            return;
        }
        int a9 = a(i4, aeVar, aeVar2);
        if (a9 == -1) {
            o();
            return;
        }
        Pair<Integer, Long> a10 = a(aeVar2, aeVar2.a(a9, this.I, false).f4323c);
        int intValue3 = a10.first.intValue();
        long longValue3 = a10.second.longValue();
        s.a a11 = this.P.a(intValue3, longValue3);
        aeVar2.a(intValue3, this.I, true);
        if (e2 != null) {
            Object obj2 = this.I.b;
            e2.h = e2.h.a();
            q qVar = e2;
            while (qVar.i != null) {
                qVar = qVar.i;
                if (qVar.b.equals(obj2)) {
                    qVar.h = this.P.a(qVar.h, intValue3);
                } else {
                    qVar.h = qVar.h.a();
                }
            }
        }
        this.R = this.R.a(a11, a(a11, a11.a() ? 0L : longValue3), longValue3);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00b6 A[Catch: all -> 0x0175, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0175, blocks: (B:14:0x009c, B:16:0x00a3, B:21:0x00b6, B:22:0x00c5, B:24:0x00d4, B:28:0x00e7, B:30:0x00ff, B:32:0x0112, B:38:0x013d, B:42:0x0152), top: B:57:0x009c }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c5 A[Catch: all -> 0x0175, TRY_ENTER, TryCatch #0 {all -> 0x0175, blocks: (B:14:0x009c, B:16:0x00a3, B:21:0x00b6, B:22:0x00c5, B:24:0x00d4, B:28:0x00e7, B:30:0x00ff, B:32:0x0112, B:38:0x013d, B:42:0x0152), top: B:57:0x009c }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x016c A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.anythink.expressad.exoplayer.k.d r9) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.k.a(com.anythink.expressad.exoplayer.k$d):void");
    }

    private void a(q qVar) {
        q c2 = this.P.c();
        if (c2 == null || qVar == c2) {
            return;
        }
        boolean[] zArr = new boolean[this.y.length];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            y[] yVarArr = this.y;
            if (i2 >= yVarArr.length) {
                this.R = this.R.a(c2.j, c2.k);
                a(zArr, i4);
                return;
            }
            y yVar = yVarArr[i2];
            zArr[i2] = yVar.a_() != 0;
            int i5 = i4;
            if (c2.k.a(i2)) {
                i5 = i4 + 1;
            }
            if (zArr[i2] && (!c2.k.a(i2) || (yVar.i() && yVar.f() == qVar.f4886c[i2]))) {
                b(yVar);
            }
            i2++;
            i3 = i5;
        }
    }

    private static void a(y yVar) {
        if (yVar.a_() == 2) {
            yVar.k();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private void a(boolean z, boolean z2) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private void a(boolean z, boolean z2, boolean z3) {
        com.anythink.expressad.exoplayer.h.s sVar;
        this.D.b();
        this.W = false;
        this.L.b();
        this.ab = 0L;
        y[] yVarArr = this.T;
        int length = yVarArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                break;
            }
            try {
                b(yVarArr[i3]);
            } catch (g | RuntimeException e2) {
                Log.e(d, "Stop failed.", e2);
            }
            i2 = i3 + 1;
        }
        this.T = new y[0];
        this.P.b(!z2);
        d(false);
        if (z2) {
            this.aa = null;
        }
        if (z3) {
            this.P.a(ae.f4321a);
            Iterator<b> it = this.N.iterator();
            while (it.hasNext()) {
                it.next().f4798a.a(false);
            }
            this.N.clear();
            this.ac = 0;
        }
        ae aeVar = z3 ? ae.f4321a : this.R.f4899a;
        Object obj = z3 ? null : this.R.b;
        s.a aVar = z2 ? new s.a(j()) : this.R.f4900c;
        long j2 = -9223372036854775807L;
        long j3 = z2 ? -9223372036854775807L : this.R.j;
        if (!z2) {
            j2 = this.R.e;
        }
        this.R = new u(aeVar, obj, aVar, j3, j2, this.R.f, false, z3 ? com.anythink.expressad.exoplayer.h.af.f4580a : this.R.h, z3 ? this.B : this.R.i);
        if (!z || (sVar = this.S) == null) {
            return;
        }
        sVar.a(this);
        this.S = null;
    }

    private void a(boolean[] zArr, int i2) {
        this.T = new y[i2];
        q c2 = this.P.c();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i3 >= this.y.length) {
                return;
            }
            int i6 = i5;
            if (c2.k.a(i3)) {
                a(i3, zArr[i3], i5);
                i6 = i5 + 1;
            }
            i3++;
            i4 = i6;
        }
    }

    private boolean a(s.a aVar, long j2, q qVar) {
        if (aVar.equals(qVar.h.f4887a) && qVar.f) {
            this.R.f4899a.a(qVar.h.f4887a.f4645a, this.I, false);
            int b2 = this.I.b(j2);
            return b2 == -1 || this.I.a(b2) == qVar.h.f4888c;
        }
        return false;
    }

    private boolean a(b bVar) {
        if (bVar.d == null) {
            Pair<Integer, Long> a2 = a(new d(bVar.f4798a.a(), bVar.f4798a.g(), com.anythink.expressad.exoplayer.b.b(bVar.f4798a.f())), false);
            if (a2 == null) {
                return false;
            }
            bVar.a(a2.first.intValue(), a2.second.longValue(), this.R.f4899a.a(a2.first.intValue(), this.I, true).b);
            return true;
        }
        int a3 = this.R.f4899a.a(bVar.d);
        if (a3 == -1) {
            return false;
        }
        bVar.b = a3;
        return true;
    }

    private static m[] a(com.anythink.expressad.exoplayer.i.f fVar) {
        int g2 = fVar != null ? fVar.g() : 0;
        m[] mVarArr = new m[g2];
        for (int i2 = 0; i2 < g2; i2++) {
            mVarArr[i2] = fVar.a(i2);
        }
        return mVarArr;
    }

    private void b(int i2) {
        if (this.R.f != i2) {
            this.R = this.R.b(i2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0099 A[LOOP:0: B:14:0x005f->B:24:0x0099, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0142 A[EDGE_INSN: B:73:0x0142->B:85:0x0142 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01ca A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b7 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0059 -> B:14:0x005f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00d0 -> B:29:0x00d6). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(long r6, long r8) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.k.b(long, long):void");
    }

    private void b(ac acVar) {
        this.Q = acVar;
    }

    private void b(com.anythink.expressad.exoplayer.h.r rVar) {
        this.D.a(10, rVar).sendToTarget();
    }

    private void b(com.anythink.expressad.exoplayer.h.s sVar, boolean z, boolean z2) {
        this.Z++;
        a(true, z, z2);
        this.C.a();
        this.S = sVar;
        b(2);
        sVar.a(this.G, true, this);
        this.D.b(2);
    }

    private void b(y yVar) {
        this.L.b(yVar);
        a(yVar);
        yVar.l();
    }

    private void c(int i2) {
        this.X = i2;
        if (this.P.a(i2)) {
            return;
        }
        g(true);
    }

    private void c(com.anythink.expressad.exoplayer.h.r rVar) {
        if (this.P.a(rVar)) {
            q b2 = this.P.b();
            float f2 = this.L.e().b;
            b2.f = true;
            b2.j = b2.f4885a.b();
            b2.a(f2);
            long b3 = b2.b(b2.h.b);
            b2.e += b2.h.b - b3;
            r rVar2 = b2.h;
            b2.h = new r(rVar2.f4887a, b3, rVar2.f4888c, rVar2.d, rVar2.e, rVar2.f, rVar2.g);
            a(b2.k);
            if (!this.P.f()) {
                a(this.P.h().h.b);
                a((q) null);
            }
            r();
        }
    }

    private void c(v vVar) {
        this.L.a(vVar);
    }

    private void c(x xVar) {
        if (xVar.f() == com.anythink.expressad.exoplayer.b.b) {
            d(xVar);
        } else if (this.S == null || this.Z > 0) {
            this.N.add(new b(xVar));
        } else {
            b bVar = new b(xVar);
            if (!a(bVar)) {
                xVar.a(false);
                return;
            }
            this.N.add(bVar);
            Collections.sort(this.N);
        }
    }

    private boolean c(y yVar) {
        q d2 = this.P.d();
        return d2.i != null && d2.i.f && yVar.g();
    }

    private void d() {
        if (this.M.a(this.R)) {
            this.F.obtainMessage(0, this.M.b, this.M.f4803c ? this.M.d : -1, this.R).sendToTarget();
            this.M.b(this.R);
        }
    }

    private void d(com.anythink.expressad.exoplayer.h.r rVar) {
        if (this.P.a(rVar)) {
            this.P.a(this.ab);
            r();
        }
    }

    private void d(x xVar) {
        if (xVar.e().getLooper() != this.D.a()) {
            this.D.a(15, xVar).sendToTarget();
            return;
        }
        f(xVar);
        if (this.R.f == 3 || this.R.f == 2) {
            this.D.b(2);
        }
    }

    private void d(boolean z) {
        if (this.R.g != z) {
            this.R = this.R.a(z);
        }
    }

    private void e() {
        this.W = false;
        this.L.a();
        for (y yVar : this.T) {
            yVar.b_();
        }
    }

    private void e(x xVar) {
        xVar.e().post(new AnonymousClass1(xVar));
    }

    private void e(boolean z) {
        this.W = false;
        this.V = z;
        if (!z) {
            f();
            g();
        } else if (this.R.f == 3) {
            e();
            this.D.b(2);
        } else if (this.R.f == 2) {
            this.D.b(2);
        }
    }

    private void f() {
        this.L.b();
        y[] yVarArr = this.T;
        int length = yVarArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            a(yVarArr[i3]);
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(x xVar) {
        if (xVar.j()) {
            return;
        }
        try {
            xVar.b().a(xVar.c(), xVar.d());
        } finally {
            xVar.a(true);
        }
    }

    private void f(boolean z) {
        this.Y = z;
        if (this.P.a(z)) {
            return;
        }
        g(true);
    }

    private void g() {
        if (this.P.f()) {
            q c2 = this.P.c();
            long c3 = c2.f4885a.c();
            if (c3 != com.anythink.expressad.exoplayer.b.b) {
                a(c3);
                if (c3 != this.R.j) {
                    u uVar = this.R;
                    this.R = uVar.a(uVar.f4900c, c3, this.R.e);
                    this.M.b(4);
                }
            } else {
                long c4 = this.L.c();
                this.ab = c4;
                long j2 = c4 - c2.e;
                b(this.R.j, j2);
                this.R.j = j2;
            }
            this.R.k = this.T.length == 0 ? c2.h.e : c2.a(true);
        }
    }

    private void g(boolean z) {
        s.a aVar = this.P.c().h.f4887a;
        long a2 = a(aVar, this.R.j, true);
        if (a2 != this.R.j) {
            u uVar = this.R;
            this.R = uVar.a(aVar, a2, uVar.e);
            if (z) {
                this.M.b(4);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:159:0x04b1, code lost:
        if (r8.C.a(r0 - (r8.ab - r0.e), r8.L.e().b, r8.W) == false) goto L206;
     */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void h() {
        /*
            Method dump skipped, instructions count: 1413
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.k.h():void");
    }

    private boolean h(boolean z) {
        if (this.T.length == 0) {
            return m();
        }
        if (z) {
            if (this.R.g) {
                q b2 = this.P.b();
                long a2 = b2.a(!b2.h.g);
                return a2 == Long.MIN_VALUE || this.C.a(a2 - (this.ab - b2.e), this.L.e().b, this.W);
            }
            return true;
        }
        return false;
    }

    private void i() {
        a(true, true, true);
        this.C.c();
        b(1);
        if (Build.VERSION.SDK_INT >= 18) {
            this.E.quitSafely();
        } else {
            this.E.quit();
        }
        synchronized (this) {
            this.U = true;
            notifyAll();
        }
    }

    private int j() {
        ae aeVar = this.R.f4899a;
        if (aeVar.a()) {
            return 0;
        }
        return aeVar.a(aeVar.b(this.Y), this.H, false).f;
    }

    private void k() {
        int size = this.N.size();
        while (true) {
            int i2 = size - 1;
            if (i2 < 0) {
                Collections.sort(this.N);
                return;
            }
            if (!a(this.N.get(i2))) {
                this.N.get(i2).f4798a.a(false);
                this.N.remove(i2);
            }
            size = i2;
        }
    }

    private void l() {
        int i2;
        if (this.P.f()) {
            float f2 = this.L.e().b;
            q d2 = this.P.d();
            boolean z = true;
            for (q c2 = this.P.c(); c2 != null && c2.f; c2 = c2.i) {
                if (c2.a(f2)) {
                    if (z) {
                        q c3 = this.P.c();
                        boolean a2 = this.P.a(c3);
                        boolean[] zArr = new boolean[this.y.length];
                        long a3 = c3.a(this.R.j, a2, zArr);
                        a(c3.k);
                        if (this.R.f != 4 && a3 != this.R.j) {
                            u uVar = this.R;
                            this.R = uVar.a(uVar.f4900c, a3, this.R.e);
                            this.M.b(4);
                            a(a3);
                        }
                        boolean[] zArr2 = new boolean[this.y.length];
                        int i3 = 0;
                        int i4 = 0;
                        while (true) {
                            i2 = i4;
                            y[] yVarArr = this.y;
                            if (i3 >= yVarArr.length) {
                                break;
                            }
                            y yVar = yVarArr[i3];
                            zArr2[i3] = yVar.a_() != 0;
                            com.anythink.expressad.exoplayer.h.y yVar2 = c3.f4886c[i3];
                            int i5 = i2;
                            if (yVar2 != null) {
                                i5 = i2 + 1;
                            }
                            if (zArr2[i3]) {
                                if (yVar2 != yVar.f()) {
                                    b(yVar);
                                } else if (zArr[i3]) {
                                    yVar.a(this.ab);
                                }
                            }
                            i3++;
                            i4 = i5;
                        }
                        this.R = this.R.a(c3.j, c3.k);
                        a(zArr2, i2);
                    } else {
                        this.P.a(c2);
                        if (c2.f) {
                            c2.b(Math.max(c2.h.b, this.ab - c2.e));
                            a(c2.k);
                        }
                    }
                    if (this.R.f != 4) {
                        r();
                        g();
                        this.D.b(2);
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

    private boolean m() {
        q c2 = this.P.c();
        long j2 = c2.h.e;
        if (j2 == com.anythink.expressad.exoplayer.b.b || this.R.j < j2) {
            return true;
        }
        if (c2.i != null) {
            return c2.i.f || c2.i.h.f4887a.a();
        }
        return false;
    }

    private void n() {
        q b2 = this.P.b();
        q d2 = this.P.d();
        if (b2 == null || b2.f) {
            return;
        }
        if (d2 != null && d2.i != b2) {
            return;
        }
        y[] yVarArr = this.T;
        int length = yVarArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                b2.f4885a.a();
                return;
            } else if (!yVarArr[i3].g()) {
                return;
            } else {
                i2 = i3 + 1;
            }
        }
    }

    private void o() {
        b(4);
        a(false, true, false);
    }

    private void p() {
        com.anythink.expressad.exoplayer.h.s sVar = this.S;
        if (sVar == null) {
            return;
        }
        if (this.Z > 0) {
            sVar.b();
            return;
        }
        this.P.a(this.ab);
        if (this.P.a()) {
            r a2 = this.P.a(this.ab, this.R);
            if (a2 == null) {
                this.S.b();
            } else {
                this.P.a(this.z, this.A, this.C.d(), this.S, this.R.f4899a.a(a2.f4887a.f4645a, this.I, true).b, a2).a(this, a2.b);
                d(true);
            }
        }
        q b2 = this.P.b();
        if (b2 == null || b2.a()) {
            d(false);
        } else if (!this.R.g) {
            r();
        }
        if (!this.P.f()) {
            return;
        }
        q c2 = this.P.c();
        q d2 = this.P.d();
        boolean z = false;
        while (true) {
            boolean z2 = z;
            if (!this.V || c2 == d2 || this.ab < c2.i.e) {
                break;
            }
            if (z2) {
                d();
            }
            int i2 = c2.h.f ? 0 : 3;
            q h2 = this.P.h();
            a(c2);
            this.R = this.R.a(h2.h.f4887a, h2.h.b, h2.h.d);
            this.M.b(i2);
            g();
            c2 = h2;
            z = true;
        }
        if (d2.h.g) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                y[] yVarArr = this.y;
                if (i4 >= yVarArr.length) {
                    return;
                }
                y yVar = yVarArr[i4];
                com.anythink.expressad.exoplayer.h.y yVar2 = d2.f4886c[i4];
                if (yVar2 != null && yVar.f() == yVar2 && yVar.g()) {
                    yVar.h();
                }
                i3 = i4 + 1;
            }
        } else if (d2.i == null || !d2.i.f) {
        } else {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                y[] yVarArr2 = this.y;
                if (i6 < yVarArr2.length) {
                    y yVar3 = yVarArr2[i6];
                    com.anythink.expressad.exoplayer.h.y yVar4 = d2.f4886c[i6];
                    if (yVar3.f() != yVar4) {
                        return;
                    }
                    if (yVar4 != null && !yVar3.g()) {
                        return;
                    }
                    i5 = i6 + 1;
                } else {
                    com.anythink.expressad.exoplayer.i.i iVar = d2.k;
                    q g2 = this.P.g();
                    com.anythink.expressad.exoplayer.i.i iVar2 = g2.k;
                    boolean z3 = g2.f4885a.c() != com.anythink.expressad.exoplayer.b.b;
                    int i7 = 0;
                    while (true) {
                        int i8 = i7;
                        y[] yVarArr3 = this.y;
                        if (i8 >= yVarArr3.length) {
                            return;
                        }
                        y yVar5 = yVarArr3[i8];
                        if (iVar.a(i8)) {
                            if (!z3) {
                                if (!yVar5.i()) {
                                    com.anythink.expressad.exoplayer.i.f a3 = iVar2.f4709c.a(i8);
                                    boolean a4 = iVar2.a(i8);
                                    boolean z4 = this.z[i8].a() == 5;
                                    aa aaVar = iVar.b[i8];
                                    aa aaVar2 = iVar2.b[i8];
                                    if (a4 && aaVar2.equals(aaVar) && !z4) {
                                        yVar5.a(a(a3), g2.f4886c[i8], g2.e);
                                    }
                                }
                            }
                            yVar5.h();
                        }
                        i7 = i8 + 1;
                    }
                }
            }
        }
    }

    private void q() {
        this.P.a(this.ab);
        if (this.P.a()) {
            r a2 = this.P.a(this.ab, this.R);
            if (a2 == null) {
                this.S.b();
                return;
            }
            this.P.a(this.z, this.A, this.C.d(), this.S, this.R.f4899a.a(a2.f4887a.f4645a, this.I, true).b, a2).a(this, a2.b);
            d(true);
        }
    }

    private void r() {
        q b2 = this.P.b();
        long b3 = b2.b();
        if (b3 == Long.MIN_VALUE) {
            d(false);
            return;
        }
        boolean a2 = this.C.a(b3 - (this.ab - b2.e), this.L.e().b);
        d(a2);
        if (a2) {
            b2.a(this.ab);
        }
    }

    public final void a() {
        synchronized (this) {
            if (!this.U && this.E.isAlive()) {
                this.D.b(7);
                long a2 = this.O.a();
                long j2 = 500;
                boolean z = false;
                while (!this.U && j2 > 0) {
                    try {
                        wait(j2);
                    } catch (InterruptedException e2) {
                        z = true;
                    }
                    j2 = (a2 + 500) - this.O.a();
                }
                if (z) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public final void a(int i2) {
        this.D.a(12, i2).sendToTarget();
    }

    public final void a(ac acVar) {
        this.D.a(5, acVar).sendToTarget();
    }

    public final void a(ae aeVar, int i2, long j2) {
        this.D.a(3, new d(aeVar, i2, j2)).sendToTarget();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.anythink.expressad.exoplayer.h.r.a
    public final void a(com.anythink.expressad.exoplayer.h.r rVar) {
        this.D.a(9, rVar).sendToTarget();
    }

    @Override // com.anythink.expressad.exoplayer.h.s.b
    public final void a(com.anythink.expressad.exoplayer.h.s sVar, ae aeVar, Object obj) {
        this.D.a(8, new a(sVar, aeVar, obj)).sendToTarget();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public final void a(com.anythink.expressad.exoplayer.h.s sVar, boolean z, boolean z2) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // com.anythink.expressad.exoplayer.h.z.a
    public final /* synthetic */ void a(com.anythink.expressad.exoplayer.h.r rVar) {
        this.D.a(10, rVar).sendToTarget();
    }

    @Override // com.anythink.expressad.exoplayer.e.a
    public final void a(v vVar) {
        this.F.obtainMessage(1, vVar).sendToTarget();
        float f2 = vVar.b;
        q e2 = this.P.e();
        while (true) {
            q qVar = e2;
            if (qVar == null) {
                return;
            }
            if (qVar.k != null) {
                com.anythink.expressad.exoplayer.i.f[] a2 = qVar.k.f4709c.a();
                int length = a2.length;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < length) {
                        com.anythink.expressad.exoplayer.i.f fVar = a2[i3];
                        if (fVar != null) {
                            fVar.a(f2);
                        }
                        i2 = i3 + 1;
                    }
                }
            }
            e2 = qVar.i;
        }
    }

    @Override // com.anythink.expressad.exoplayer.x.a
    public final void a(x xVar) {
        synchronized (this) {
            if (!this.U) {
                this.D.a(14, xVar).sendToTarget();
                return;
            }
            Log.w(d, "Ignoring messages sent after release.");
            xVar.a(false);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public final void a(boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public final Looper b() {
        return this.E.getLooper();
    }

    public final void b(v vVar) {
        this.D.a(4, vVar).sendToTarget();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public final void b(boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // com.anythink.expressad.exoplayer.i.h.a
    public final void c() {
        this.D.b(11);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public final void c(boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX WARN: Code restructure failed: missing block: B:536:0x1058, code lost:
        if (r19 == false) goto L534;
     */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0800 A[Catch: all -> 0x08c5, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x08c5, blocks: (B:203:0x07e6, B:205:0x07ed, B:210:0x0800, B:211:0x080f, B:213:0x081d, B:217:0x0832, B:219:0x084b, B:221:0x085e, B:229:0x088c, B:233:0x08a3), top: B:541:0x07e6 }] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x080f A[Catch: all -> 0x08c5, TRY_ENTER, TryCatch #0 {all -> 0x08c5, blocks: (B:203:0x07e6, B:205:0x07ed, B:210:0x0800, B:211:0x080f, B:213:0x081d, B:217:0x0832, B:219:0x084b, B:221:0x085e, B:229:0x088c, B:233:0x08a3), top: B:541:0x07e6 }] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x08bd A[Catch: RuntimeException -> 0x0ede, IOException -> 0x0ee2, g -> 0x0ee6, TRY_ENTER, TRY_LEAVE, TryCatch #10 {RuntimeException -> 0x0ede, blocks: (B:7:0x005a, B:467:0x0ed8, B:8:0x0076, B:10:0x0089, B:11:0x0091, B:13:0x0098, B:16:0x00a2, B:18:0x00b5, B:19:0x00c9, B:20:0x00d1, B:21:0x00e4, B:25:0x00f1, B:27:0x0103, B:28:0x010b, B:30:0x0120, B:31:0x0128, B:33:0x0132, B:37:0x0154, B:40:0x015e, B:46:0x016e, B:49:0x017a, B:51:0x01b9, B:53:0x01c6, B:55:0x01f0, B:57:0x01fd, B:59:0x0206, B:64:0x0224, B:70:0x0242, B:72:0x024e, B:75:0x025e, B:76:0x026c, B:81:0x02bb, B:83:0x02c5, B:77:0x028a, B:79:0x029a, B:84:0x02db, B:86:0x02ee, B:87:0x0300, B:89:0x0313, B:91:0x03a1, B:93:0x03b8, B:94:0x03be, B:96:0x03d1, B:97:0x0406, B:99:0x040a, B:101:0x041c, B:102:0x043a, B:104:0x0448, B:108:0x0459, B:110:0x045f, B:112:0x0472, B:113:0x0479, B:117:0x04ae, B:118:0x04bf, B:120:0x04cd, B:122:0x04d5, B:123:0x04dc, B:127:0x0521, B:128:0x0532, B:130:0x054e, B:132:0x0556, B:136:0x0574, B:137:0x0585, B:139:0x0593, B:142:0x05ad, B:145:0x05b9, B:148:0x05c8, B:149:0x05cf, B:151:0x0618, B:153:0x0631, B:155:0x0638, B:157:0x0649, B:158:0x065c, B:159:0x066a, B:162:0x0675, B:165:0x0699, B:167:0x06a7, B:169:0x06b5, B:171:0x06cb, B:174:0x06d6, B:175:0x06f4, B:140:0x05a5, B:178:0x070f, B:180:0x0715, B:184:0x0722, B:185:0x072c, B:186:0x073a, B:187:0x074e, B:189:0x076d, B:235:0x08aa, B:237:0x08bd, B:227:0x0881, B:223:0x0868, B:225:0x087b, B:239:0x08c7, B:241:0x08db, B:243:0x08e5, B:191:0x0785, B:195:0x07ba, B:197:0x07c9, B:245:0x08e7, B:247:0x08f8, B:249:0x08ff, B:250:0x090b, B:252:0x0920, B:254:0x0934, B:255:0x0940, B:257:0x098a, B:259:0x0995, B:262:0x099f, B:264:0x09a9, B:267:0x09b6, B:269:0x09bf, B:271:0x09d2, B:276:0x09df, B:280:0x09f2, B:282:0x09f7, B:286:0x0a05, B:288:0x0a4a, B:292:0x0a57, B:294:0x0a60, B:296:0x0a75, B:298:0x0a80, B:300:0x0a89, B:301:0x0a92, B:303:0x0a9a, B:306:0x0aa8, B:308:0x0ab1, B:312:0x0ad1, B:315:0x0add, B:319:0x0b09, B:321:0x0b13, B:325:0x0b29, B:327:0x0b33, B:331:0x0b5e, B:333:0x0b76, B:337:0x0b85, B:338:0x0ba1, B:339:0x0bab, B:341:0x0bb5, B:342:0x0bc5, B:347:0x0c16, B:349:0x0c2b, B:353:0x0c3a, B:355:0x0c44, B:357:0x0c4e, B:359:0x0c5f, B:361:0x0c6a, B:367:0x0c7f, B:370:0x0c8e, B:372:0x0c93, B:376:0x0ca8, B:379:0x0cb6, B:381:0x0cbf, B:416:0x0d92, B:418:0x0d9c, B:422:0x0dad, B:424:0x0dbc, B:426:0x0dc3, B:432:0x0dda, B:439:0x0e0d, B:439:0x0e0d, B:429:0x0dcf, B:433:0x0de5, B:435:0x0ded, B:437:0x0df8, B:438:0x0e04, B:382:0x0ccb, B:384:0x0cd6, B:386:0x0cde, B:404:0x0d50, B:406:0x0d5c, B:389:0x0cec, B:392:0x0cf9, B:396:0x0d11, B:399:0x0d22, B:407:0x0d63, B:409:0x0d6e, B:411:0x0d76, B:414:0x0d80, B:441:0x0e13, B:445:0x0e20, B:447:0x0e30, B:448:0x0e3b, B:450:0x0e46, B:452:0x0e50, B:453:0x0e5a, B:456:0x0e67, B:457:0x0e75, B:461:0x0e8b, B:465:0x0e98), top: B:542:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x09bf A[Catch: RuntimeException -> 0x0ede, IOException -> 0x0ee2, g -> 0x0ee6, TRY_LEAVE, TryCatch #10 {RuntimeException -> 0x0ede, blocks: (B:7:0x005a, B:467:0x0ed8, B:8:0x0076, B:10:0x0089, B:11:0x0091, B:13:0x0098, B:16:0x00a2, B:18:0x00b5, B:19:0x00c9, B:20:0x00d1, B:21:0x00e4, B:25:0x00f1, B:27:0x0103, B:28:0x010b, B:30:0x0120, B:31:0x0128, B:33:0x0132, B:37:0x0154, B:40:0x015e, B:46:0x016e, B:49:0x017a, B:51:0x01b9, B:53:0x01c6, B:55:0x01f0, B:57:0x01fd, B:59:0x0206, B:64:0x0224, B:70:0x0242, B:72:0x024e, B:75:0x025e, B:76:0x026c, B:81:0x02bb, B:83:0x02c5, B:77:0x028a, B:79:0x029a, B:84:0x02db, B:86:0x02ee, B:87:0x0300, B:89:0x0313, B:91:0x03a1, B:93:0x03b8, B:94:0x03be, B:96:0x03d1, B:97:0x0406, B:99:0x040a, B:101:0x041c, B:102:0x043a, B:104:0x0448, B:108:0x0459, B:110:0x045f, B:112:0x0472, B:113:0x0479, B:117:0x04ae, B:118:0x04bf, B:120:0x04cd, B:122:0x04d5, B:123:0x04dc, B:127:0x0521, B:128:0x0532, B:130:0x054e, B:132:0x0556, B:136:0x0574, B:137:0x0585, B:139:0x0593, B:142:0x05ad, B:145:0x05b9, B:148:0x05c8, B:149:0x05cf, B:151:0x0618, B:153:0x0631, B:155:0x0638, B:157:0x0649, B:158:0x065c, B:159:0x066a, B:162:0x0675, B:165:0x0699, B:167:0x06a7, B:169:0x06b5, B:171:0x06cb, B:174:0x06d6, B:175:0x06f4, B:140:0x05a5, B:178:0x070f, B:180:0x0715, B:184:0x0722, B:185:0x072c, B:186:0x073a, B:187:0x074e, B:189:0x076d, B:235:0x08aa, B:237:0x08bd, B:227:0x0881, B:223:0x0868, B:225:0x087b, B:239:0x08c7, B:241:0x08db, B:243:0x08e5, B:191:0x0785, B:195:0x07ba, B:197:0x07c9, B:245:0x08e7, B:247:0x08f8, B:249:0x08ff, B:250:0x090b, B:252:0x0920, B:254:0x0934, B:255:0x0940, B:257:0x098a, B:259:0x0995, B:262:0x099f, B:264:0x09a9, B:267:0x09b6, B:269:0x09bf, B:271:0x09d2, B:276:0x09df, B:280:0x09f2, B:282:0x09f7, B:286:0x0a05, B:288:0x0a4a, B:292:0x0a57, B:294:0x0a60, B:296:0x0a75, B:298:0x0a80, B:300:0x0a89, B:301:0x0a92, B:303:0x0a9a, B:306:0x0aa8, B:308:0x0ab1, B:312:0x0ad1, B:315:0x0add, B:319:0x0b09, B:321:0x0b13, B:325:0x0b29, B:327:0x0b33, B:331:0x0b5e, B:333:0x0b76, B:337:0x0b85, B:338:0x0ba1, B:339:0x0bab, B:341:0x0bb5, B:342:0x0bc5, B:347:0x0c16, B:349:0x0c2b, B:353:0x0c3a, B:355:0x0c44, B:357:0x0c4e, B:359:0x0c5f, B:361:0x0c6a, B:367:0x0c7f, B:370:0x0c8e, B:372:0x0c93, B:376:0x0ca8, B:379:0x0cb6, B:381:0x0cbf, B:416:0x0d92, B:418:0x0d9c, B:422:0x0dad, B:424:0x0dbc, B:426:0x0dc3, B:432:0x0dda, B:439:0x0e0d, B:439:0x0e0d, B:429:0x0dcf, B:433:0x0de5, B:435:0x0ded, B:437:0x0df8, B:438:0x0e04, B:382:0x0ccb, B:384:0x0cd6, B:386:0x0cde, B:404:0x0d50, B:406:0x0d5c, B:389:0x0cec, B:392:0x0cf9, B:396:0x0d11, B:399:0x0d22, B:407:0x0d63, B:409:0x0d6e, B:411:0x0d76, B:414:0x0d80, B:441:0x0e13, B:445:0x0e20, B:447:0x0e30, B:448:0x0e3b, B:450:0x0e46, B:452:0x0e50, B:453:0x0e5a, B:456:0x0e67, B:457:0x0e75, B:461:0x0e8b, B:465:0x0e98), top: B:542:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0c7f A[Catch: RuntimeException -> 0x0ede, IOException -> 0x0ee2, g -> 0x0ee6, TRY_ENTER, TRY_LEAVE, TryCatch #10 {RuntimeException -> 0x0ede, blocks: (B:7:0x005a, B:467:0x0ed8, B:8:0x0076, B:10:0x0089, B:11:0x0091, B:13:0x0098, B:16:0x00a2, B:18:0x00b5, B:19:0x00c9, B:20:0x00d1, B:21:0x00e4, B:25:0x00f1, B:27:0x0103, B:28:0x010b, B:30:0x0120, B:31:0x0128, B:33:0x0132, B:37:0x0154, B:40:0x015e, B:46:0x016e, B:49:0x017a, B:51:0x01b9, B:53:0x01c6, B:55:0x01f0, B:57:0x01fd, B:59:0x0206, B:64:0x0224, B:70:0x0242, B:72:0x024e, B:75:0x025e, B:76:0x026c, B:81:0x02bb, B:83:0x02c5, B:77:0x028a, B:79:0x029a, B:84:0x02db, B:86:0x02ee, B:87:0x0300, B:89:0x0313, B:91:0x03a1, B:93:0x03b8, B:94:0x03be, B:96:0x03d1, B:97:0x0406, B:99:0x040a, B:101:0x041c, B:102:0x043a, B:104:0x0448, B:108:0x0459, B:110:0x045f, B:112:0x0472, B:113:0x0479, B:117:0x04ae, B:118:0x04bf, B:120:0x04cd, B:122:0x04d5, B:123:0x04dc, B:127:0x0521, B:128:0x0532, B:130:0x054e, B:132:0x0556, B:136:0x0574, B:137:0x0585, B:139:0x0593, B:142:0x05ad, B:145:0x05b9, B:148:0x05c8, B:149:0x05cf, B:151:0x0618, B:153:0x0631, B:155:0x0638, B:157:0x0649, B:158:0x065c, B:159:0x066a, B:162:0x0675, B:165:0x0699, B:167:0x06a7, B:169:0x06b5, B:171:0x06cb, B:174:0x06d6, B:175:0x06f4, B:140:0x05a5, B:178:0x070f, B:180:0x0715, B:184:0x0722, B:185:0x072c, B:186:0x073a, B:187:0x074e, B:189:0x076d, B:235:0x08aa, B:237:0x08bd, B:227:0x0881, B:223:0x0868, B:225:0x087b, B:239:0x08c7, B:241:0x08db, B:243:0x08e5, B:191:0x0785, B:195:0x07ba, B:197:0x07c9, B:245:0x08e7, B:247:0x08f8, B:249:0x08ff, B:250:0x090b, B:252:0x0920, B:254:0x0934, B:255:0x0940, B:257:0x098a, B:259:0x0995, B:262:0x099f, B:264:0x09a9, B:267:0x09b6, B:269:0x09bf, B:271:0x09d2, B:276:0x09df, B:280:0x09f2, B:282:0x09f7, B:286:0x0a05, B:288:0x0a4a, B:292:0x0a57, B:294:0x0a60, B:296:0x0a75, B:298:0x0a80, B:300:0x0a89, B:301:0x0a92, B:303:0x0a9a, B:306:0x0aa8, B:308:0x0ab1, B:312:0x0ad1, B:315:0x0add, B:319:0x0b09, B:321:0x0b13, B:325:0x0b29, B:327:0x0b33, B:331:0x0b5e, B:333:0x0b76, B:337:0x0b85, B:338:0x0ba1, B:339:0x0bab, B:341:0x0bb5, B:342:0x0bc5, B:347:0x0c16, B:349:0x0c2b, B:353:0x0c3a, B:355:0x0c44, B:357:0x0c4e, B:359:0x0c5f, B:361:0x0c6a, B:367:0x0c7f, B:370:0x0c8e, B:372:0x0c93, B:376:0x0ca8, B:379:0x0cb6, B:381:0x0cbf, B:416:0x0d92, B:418:0x0d9c, B:422:0x0dad, B:424:0x0dbc, B:426:0x0dc3, B:432:0x0dda, B:439:0x0e0d, B:439:0x0e0d, B:429:0x0dcf, B:433:0x0de5, B:435:0x0ded, B:437:0x0df8, B:438:0x0e04, B:382:0x0ccb, B:384:0x0cd6, B:386:0x0cde, B:404:0x0d50, B:406:0x0d5c, B:389:0x0cec, B:392:0x0cf9, B:396:0x0d11, B:399:0x0d22, B:407:0x0d63, B:409:0x0d6e, B:411:0x0d76, B:414:0x0d80, B:441:0x0e13, B:445:0x0e20, B:447:0x0e30, B:448:0x0e3b, B:450:0x0e46, B:452:0x0e50, B:453:0x0e5a, B:456:0x0e67, B:457:0x0e75, B:461:0x0e8b, B:465:0x0e98), top: B:542:0x0009 }] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean handleMessage(android.os.Message r16) {
        /*
            Method dump skipped, instructions count: 4208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.k.handleMessage(android.os.Message):boolean");
    }
}
