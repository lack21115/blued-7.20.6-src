package com.anythink.expressad.exoplayer;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.anythink.expressad.exoplayer.ae;
import com.anythink.expressad.exoplayer.h;
import com.anythink.expressad.exoplayer.h.s;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.w;
import com.anythink.expressad.exoplayer.x;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j.class */
final class j implements h {
    private static final String w = "ExoPlayerImpl";
    private final Handler A;
    private final k B;
    private final Handler C;
    private final CopyOnWriteArraySet<w.c> D;
    private final ae.b E;
    private final ae.a F;
    private final ArrayDeque<a> G;
    private boolean H;
    private int I;
    private boolean J;
    private int K;
    private boolean L;
    private boolean M;
    private v N;
    private g O;
    private u P;
    private int Q;
    private int R;
    private long S;
    private final y[] x;
    private final com.anythink.expressad.exoplayer.i.h y;
    private final com.anythink.expressad.exoplayer.i.i z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final u f4712a;
        private final Set<w.c> b;

        /* renamed from: c  reason: collision with root package name */
        private final com.anythink.expressad.exoplayer.i.h f4713c;
        private final boolean d;
        private final int e;
        private final int f;
        private final boolean g;
        private final boolean h;
        private final boolean i;
        private final boolean j;
        private final boolean k;
        private final boolean l;

        public a(u uVar, u uVar2, Set<w.c> set, com.anythink.expressad.exoplayer.i.h hVar, boolean z, int i, int i2, boolean z2, boolean z3, boolean z4) {
            this.f4712a = uVar;
            this.b = set;
            this.f4713c = hVar;
            this.d = z;
            this.e = i;
            this.f = i2;
            this.g = z2;
            this.h = z3;
            this.i = z4 || uVar2.f != uVar.f;
            this.j = (uVar2.f4899a == uVar.f4899a && uVar2.b == uVar.b) ? false : true;
            this.k = uVar2.g != uVar.g;
            this.l = uVar2.i != uVar.i;
        }

        public final void a() {
            if (this.j || this.f == 0) {
                for (w.c cVar : this.b) {
                    cVar.onTimelineChanged(this.f4712a.f4899a, this.f4712a.b, this.f);
                }
            }
            if (this.d) {
                for (w.c cVar2 : this.b) {
                    cVar2.onPositionDiscontinuity(this.e);
                }
            }
            if (this.l) {
                this.f4713c.a(this.f4712a.i.d);
                for (w.c cVar3 : this.b) {
                    cVar3.onTracksChanged(this.f4712a.h, this.f4712a.i.f4709c);
                }
            }
            if (this.k) {
                for (w.c cVar4 : this.b) {
                    cVar4.onLoadingChanged(this.f4712a.g);
                }
            }
            if (this.i) {
                for (w.c cVar5 : this.b) {
                    cVar5.onPlayerStateChanged(this.h, this.f4712a.f);
                }
            }
            if (this.g) {
                for (w.c cVar6 : this.b) {
                    cVar6.onSeekProcessed();
                }
            }
        }
    }

    public j(y[] yVarArr, com.anythink.expressad.exoplayer.i.h hVar, p pVar, com.anythink.expressad.exoplayer.k.c cVar) {
        Log.i(w, "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.8.4] [" + af.e + "]");
        com.anythink.expressad.exoplayer.k.a.b(yVarArr.length > 0);
        this.x = (y[]) com.anythink.expressad.exoplayer.k.a.a(yVarArr);
        this.y = (com.anythink.expressad.exoplayer.i.h) com.anythink.expressad.exoplayer.k.a.a(hVar);
        this.H = false;
        this.I = 0;
        this.J = false;
        this.D = new CopyOnWriteArraySet<>();
        this.z = new com.anythink.expressad.exoplayer.i.i(new aa[yVarArr.length], new com.anythink.expressad.exoplayer.i.f[yVarArr.length], null);
        this.E = new ae.b();
        this.F = new ae.a();
        this.N = v.f4901a;
        this.A = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()) { // from class: com.anythink.expressad.exoplayer.j.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                j.this.a(message);
            }
        };
        this.P = new u(ae.f4321a, 0L, com.anythink.expressad.exoplayer.h.af.f4580a, this.z);
        this.G = new ArrayDeque<>();
        this.B = new k(yVarArr, hVar, this.z, pVar, this.H, this.I, this.J, this.A, this, cVar);
        this.C = new Handler(this.B.b());
    }

    private boolean H() {
        return this.P.f4899a.a() || this.K > 0;
    }

    private u a(boolean z, boolean z2, int i) {
        if (z) {
            this.Q = 0;
            this.R = 0;
            this.S = 0L;
        } else {
            this.Q = p();
            this.R = o();
            this.S = t();
        }
        return new u(z2 ? ae.f4321a : this.P.f4899a, z2 ? null : this.P.b, this.P.f4900c, this.P.d, this.P.e, i, false, z2 ? com.anythink.expressad.exoplayer.h.af.f4580a : this.P.h, z2 ? this.z : this.P.i);
    }

    private void a(u uVar, int i, boolean z, int i2) {
        int i3 = this.K - i;
        this.K = i3;
        if (i3 == 0) {
            u uVar2 = uVar;
            if (uVar.d == b.b) {
                uVar2 = uVar.a(uVar.f4900c, 0L, uVar.e);
            }
            if ((!this.P.f4899a.a() || this.L) && uVar2.f4899a.a()) {
                this.R = 0;
                this.Q = 0;
                this.S = 0L;
            }
            int i4 = this.L ? 0 : 2;
            boolean z2 = this.M;
            this.L = false;
            this.M = false;
            a(uVar2, z, i2, i4, z2, false);
        }
    }

    private void a(u uVar, boolean z, int i, int i2, boolean z2, boolean z3) {
        boolean isEmpty = this.G.isEmpty();
        this.G.addLast(new a(uVar, this.P, this.D, this.y, z, i, i2, z2, this.H, z3));
        this.P = uVar;
        if (!isEmpty) {
            return;
        }
        while (!this.G.isEmpty()) {
            this.G.peekFirst().a();
            this.G.removeFirst();
        }
    }

    private long b(long j) {
        long a2 = b.a(j);
        long j2 = a2;
        if (!this.P.f4900c.a()) {
            this.P.f4899a.a(this.P.f4900c.f4645a, this.F, false);
            j2 = a2 + this.F.a();
        }
        return j2;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int A() {
        if (y()) {
            return this.P.f4900c.f4646c;
        }
        return -1;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final long B() {
        if (y()) {
            this.P.f4899a.a(this.P.f4900c.f4645a, this.F, false);
            return this.F.a() + b.a(this.P.e);
        }
        return t();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int C() {
        return this.x.length;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final com.anythink.expressad.exoplayer.h.af D() {
        return this.P.h;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final com.anythink.expressad.exoplayer.i.g E() {
        return this.P.i.f4709c;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final ae F() {
        return this.P.f4899a;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final Object G() {
        return this.P.b;
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final Looper a() {
        return this.B.b();
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final x a(x.b bVar) {
        return new x(this.B, bVar, this.P.f4899a, p(), this.C);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(int i) {
        if (this.I != i) {
            this.I = i;
            this.B.a(i);
            Iterator<w.c> it = this.D.iterator();
            while (it.hasNext()) {
                it.next().onRepeatModeChanged(i);
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(int i, long j) {
        ae aeVar = this.P.f4899a;
        if (i < 0 || (!aeVar.a() && i >= aeVar.b())) {
            throw new o(aeVar, i, j);
        }
        this.M = true;
        this.K++;
        if (y()) {
            Log.w(w, "seekTo ignored because an ad is playing");
            this.A.obtainMessage(0, 1, -1, this.P).sendToTarget();
            return;
        }
        this.Q = i;
        if (aeVar.a()) {
            this.S = j == b.b ? 0L : j;
            this.R = 0;
        } else {
            long b = j == b.b ? aeVar.a(i, this.E, false).h : b.b(j);
            Pair<Integer, Long> a2 = aeVar.a(this.E, this.F, i, b);
            this.S = b.a(b);
            this.R = a2.first.intValue();
        }
        this.B.a(aeVar, i, b.b(j));
        Iterator<w.c> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().onPositionDiscontinuity(1);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(long j) {
        a(p(), j);
    }

    final void a(Message message) {
        int i = message.what;
        boolean z = true;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException();
                }
                g gVar = (g) message.obj;
                this.O = gVar;
                Iterator<w.c> it = this.D.iterator();
                while (it.hasNext()) {
                    it.next().onPlayerError(gVar);
                }
                return;
            }
            v vVar = (v) message.obj;
            if (this.N.equals(vVar)) {
                return;
            }
            this.N = vVar;
            Iterator<w.c> it2 = this.D.iterator();
            while (it2.hasNext()) {
                it2.next().onPlaybackParametersChanged(vVar);
            }
            return;
        }
        u uVar = (u) message.obj;
        int i2 = message.arg1;
        if (message.arg2 == -1) {
            z = false;
        }
        int i3 = message.arg2;
        int i4 = this.K - i2;
        this.K = i4;
        if (i4 == 0) {
            u a2 = uVar.d == b.b ? uVar.a(uVar.f4900c, 0L, uVar.e) : uVar;
            if ((!this.P.f4899a.a() || this.L) && a2.f4899a.a()) {
                this.R = 0;
                this.Q = 0;
                this.S = 0L;
            }
            int i5 = this.L ? 0 : 2;
            boolean z2 = this.M;
            this.L = false;
            this.M = false;
            a(a2, z, i3, i5, z2, false);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void a(ac acVar) {
        ac acVar2 = acVar;
        if (acVar == null) {
            acVar2 = ac.e;
        }
        this.B.a(acVar2);
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void a(com.anythink.expressad.exoplayer.h.s sVar) {
        a(sVar, true, true);
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void a(com.anythink.expressad.exoplayer.h.s sVar, boolean z, boolean z2) {
        this.O = null;
        u a2 = a(z, z2, 2);
        this.L = true;
        this.K++;
        this.B.a(sVar, z, z2);
        a(a2, false, 4, 1, false, false);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(v vVar) {
        v vVar2 = vVar;
        if (vVar == null) {
            vVar2 = v.f4901a;
        }
        this.B.b(vVar2);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(w.c cVar) {
        this.D.add(cVar);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(boolean z) {
        if (this.H != z) {
            this.H = z;
            this.B.a(z);
            a(this.P, false, 4, 1, false, true);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void a(h.c... cVarArr) {
        int length = cVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            h.c cVar = cVarArr[i2];
            a(cVar.f4596a).a(cVar.b).a(cVar.f4597c).i();
            i = i2 + 1;
        }
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final w.g b() {
        return null;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void b(int i) {
        a(i, b.b);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void b(w.c cVar) {
        this.D.remove(cVar);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void b(boolean z) {
        if (this.J != z) {
            this.J = z;
            this.B.b(z);
            Iterator<w.c> it = this.D.iterator();
            while (it.hasNext()) {
                it.next().onShuffleModeEnabledChanged(z);
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void b(h.c... cVarArr) {
        ArrayList<x> arrayList = new ArrayList();
        int length = cVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            h.c cVar = cVarArr[i2];
            arrayList.add(a(cVar.f4596a).a(cVar.b).a(cVar.f4597c).i());
            i = i2 + 1;
        }
        boolean z = false;
        for (x xVar : arrayList) {
            boolean z2 = true;
            boolean z3 = z;
            while (true) {
                z = z3;
                if (z2) {
                    try {
                        xVar.k();
                        z2 = false;
                    } catch (InterruptedException e) {
                        z3 = true;
                    } catch (TimeoutException e2) {
                        com.anythink.expressad.foundation.h.o.d(w, e2.getMessage());
                    }
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int c(int i) {
        return this.x[i].a();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final w.e c() {
        return null;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void c(boolean z) {
        if (z) {
            this.O = null;
        }
        u a2 = a(z, z, 1);
        this.K++;
        this.B.c(z);
        a(a2, false, 4, 1, false, false);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int d() {
        return this.P.f;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final g e() {
        return this.O;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean f() {
        return this.H;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int g() {
        return this.I;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean h() {
        return this.J;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean i() {
        return this.P.g;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void j() {
        b(p());
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final v k() {
        return this.N;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final Object l() {
        int p = p();
        if (p > this.P.f4899a.b()) {
            return null;
        }
        return this.P.f4899a.a(p, this.E, true).f4324a;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void m() {
        c(false);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void n() {
        Log.i(w, "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.8.4] [" + af.e + "] [" + l.a() + "]");
        this.B.a();
        this.A.removeCallbacksAndMessages(null);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int o() {
        return H() ? this.R : this.P.f4900c.f4645a;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int p() {
        return H() ? this.Q : this.P.f4899a.a(this.P.f4900c.f4645a, this.F, false).f4323c;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int q() {
        ae aeVar = this.P.f4899a;
        if (aeVar.a()) {
            return -1;
        }
        return aeVar.a(p(), this.I, this.J);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int r() {
        ae aeVar = this.P.f4899a;
        if (aeVar.a()) {
            return -1;
        }
        return aeVar.b(p(), this.I, this.J);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final long s() {
        ae aeVar = this.P.f4899a;
        if (aeVar.a()) {
            return b.b;
        }
        if (y()) {
            s.a aVar = this.P.f4900c;
            aeVar.a(aVar.f4645a, this.F, false);
            return b.a(this.F.c(aVar.b, aVar.f4646c));
        }
        return b.a(aeVar.a(p(), this.E, false).i);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final long t() {
        return H() ? this.S : b(this.P.j);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final long u() {
        return H() ? this.S : b(this.P.k);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int v() {
        long u = u();
        long s = s();
        if (u == b.b || s == b.b) {
            return 0;
        }
        if (s == 0) {
            return 100;
        }
        return af.a((int) ((u * 100) / s), 0, 100);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean w() {
        ae aeVar = this.P.f4899a;
        return !aeVar.a() && aeVar.a(p(), this.E, false).e;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean x() {
        ae aeVar = this.P.f4899a;
        return !aeVar.a() && aeVar.a(p(), this.E, false).d;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean y() {
        return !H() && this.P.f4900c.a();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int z() {
        if (y()) {
            return this.P.f4900c.b;
        }
        return -1;
    }
}
