package com.opos.exoplayer.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.opos.exoplayer.core.e.e;
import com.opos.exoplayer.core.q;
import com.opos.exoplayer.core.r;
import com.opos.exoplayer.core.y;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/z.class */
public final class z implements i {

    /* renamed from: a  reason: collision with root package name */
    private final s[] f11910a;
    private final com.opos.exoplayer.core.g.h b;

    /* renamed from: c  reason: collision with root package name */
    private final com.opos.exoplayer.core.g.i f11911c;
    private final Handler d;
    private final aa e;
    private final Handler f;
    private final CopyOnWriteArraySet<q.b> g;
    private final y.b h;
    private final y.a i;
    private boolean j;
    private int k;
    private boolean l;
    private int m;
    private boolean n;
    private boolean o;
    private p p;
    private ae q;
    private int r;
    private int s;
    private long t;

    public z(s[] sVarArr, com.opos.exoplayer.core.g.h hVar, n nVar, com.opos.exoplayer.core.i.b bVar) {
        com.opos.cmn.an.f.a.a("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.7.3] [" + com.opos.exoplayer.core.i.u.e + "]");
        com.opos.exoplayer.core.i.a.b(sVarArr.length > 0);
        this.f11910a = (s[]) com.opos.exoplayer.core.i.a.a(sVarArr);
        this.b = (com.opos.exoplayer.core.g.h) com.opos.exoplayer.core.i.a.a(hVar);
        this.j = false;
        this.k = 0;
        this.l = false;
        this.g = new CopyOnWriteArraySet<>();
        this.f11911c = new com.opos.exoplayer.core.g.i(com.opos.exoplayer.core.e.m.f11623a, new boolean[sVarArr.length], new com.opos.exoplayer.core.g.g(new com.opos.exoplayer.core.g.f[sVarArr.length]), null, new u[sVarArr.length]);
        this.h = new y.b();
        this.i = new y.a();
        this.p = p.f11866a;
        this.d = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()) { // from class: com.opos.exoplayer.core.z.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                z.this.a(message);
            }
        };
        this.q = new ae(y.f11905a, 0L, this.f11911c);
        this.e = new aa(sVarArr, hVar, this.f11911c, nVar, this.j, this.k, this.l, this.d, this, bVar);
        this.f = new Handler(this.e.b());
    }

    private ae a(boolean z, boolean z2, int i) {
        long m;
        if (z) {
            this.r = 0;
            this.s = 0;
            m = 0;
        } else {
            this.r = i();
            this.s = q();
            m = m();
        }
        this.t = m;
        return new ae(z2 ? y.f11905a : this.q.f11375a, z2 ? null : this.q.b, this.q.f11376c, this.q.d, this.q.e, i, false, z2 ? this.f11911c : this.q.h);
    }

    private void a(ae aeVar, int i, boolean z, int i2) {
        int i3 = this.m - i;
        this.m = i3;
        if (i3 == 0) {
            ae aeVar2 = aeVar;
            if (aeVar.d == com.anythink.expressad.exoplayer.b.b) {
                aeVar2 = aeVar.a(aeVar.f11376c, 0L, aeVar.e);
            }
            if ((!this.q.f11375a.a() || this.n) && aeVar2.f11375a.a()) {
                this.s = 0;
                this.r = 0;
                this.t = 0L;
            }
            int i4 = this.n ? 0 : 2;
            boolean z2 = this.o;
            this.n = false;
            this.o = false;
            a(aeVar2, z, i2, i4, z2);
        }
    }

    private void a(ae aeVar, boolean z, int i, int i2, boolean z2) {
        boolean z3 = false;
        boolean z4 = (this.q.f11375a == aeVar.f11375a && this.q.b == aeVar.b) ? false : true;
        boolean z5 = this.q.f != aeVar.f;
        boolean z6 = this.q.g != aeVar.g;
        if (this.q.h != aeVar.h) {
            z3 = true;
        }
        this.q = aeVar;
        if (z4 || i2 == 0) {
            Iterator<q.b> it = this.g.iterator();
            while (it.hasNext()) {
                it.next().a(this.q.f11375a, this.q.b, i2);
            }
        }
        if (z) {
            Iterator<q.b> it2 = this.g.iterator();
            while (it2.hasNext()) {
                it2.next().b(i);
            }
        }
        if (z3) {
            this.b.a(this.q.h.d);
            Iterator<q.b> it3 = this.g.iterator();
            while (it3.hasNext()) {
                it3.next().a(this.q.h.f11750a, this.q.h.f11751c);
            }
        }
        if (z6) {
            Iterator<q.b> it4 = this.g.iterator();
            while (it4.hasNext()) {
                it4.next().a(this.q.g);
            }
        }
        if (z5) {
            Iterator<q.b> it5 = this.g.iterator();
            while (it5.hasNext()) {
                it5.next().a(this.j, this.q.f);
            }
        }
        if (z2) {
            Iterator<q.b> it6 = this.g.iterator();
            while (it6.hasNext()) {
                it6.next().e_();
            }
        }
    }

    private long b(long j) {
        long a2 = b.a(j);
        long j2 = a2;
        if (!this.q.f11376c.a()) {
            this.q.f11375a.a(this.q.f11376c.f11598a, this.i);
            j2 = a2 + this.i.b();
        }
        return j2;
    }

    private boolean r() {
        return this.q.f11375a.a() || this.m > 0;
    }

    @Override // com.opos.exoplayer.core.q
    public q.d a() {
        return null;
    }

    @Override // com.opos.exoplayer.core.i
    public r a(r.b bVar) {
        return new r(this.e, bVar, this.q.f11375a, i(), this.f);
    }

    @Override // com.opos.exoplayer.core.q
    public void a(int i) {
        if (this.k != i) {
            this.k = i;
            this.e.a(i);
            Iterator<q.b> it = this.g.iterator();
            while (it.hasNext()) {
                it.next().a(i);
            }
        }
    }

    @Override // com.opos.exoplayer.core.q
    public void a(int i, long j) {
        y yVar = this.q.f11375a;
        if (i < 0 || (!yVar.a() && i >= yVar.b())) {
            throw new m(yVar, i, j);
        }
        this.o = true;
        this.m++;
        if (o()) {
            com.opos.cmn.an.f.a.c("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            this.d.obtainMessage(0, 1, -1, this.q).sendToTarget();
            return;
        }
        this.r = i;
        if (yVar.a()) {
            this.t = j == com.anythink.expressad.exoplayer.b.b ? 0L : j;
            this.s = 0;
        } else {
            long a2 = j == com.anythink.expressad.exoplayer.b.b ? yVar.a(i, this.h).a() : b.b(j);
            Pair<Integer, Long> a3 = yVar.a(this.h, this.i, i, a2);
            this.t = b.a(a2);
            this.s = a3.first.intValue();
        }
        this.e.a(yVar, i, b.b(j));
        Iterator<q.b> it = this.g.iterator();
        while (it.hasNext()) {
            it.next().b(1);
        }
    }

    @Override // com.opos.exoplayer.core.q
    public void a(long j) {
        a(i(), j);
    }

    void a(Message message) {
        int i = message.what;
        boolean z = true;
        if (i == 0) {
            ae aeVar = (ae) message.obj;
            int i2 = message.arg1;
            if (message.arg2 == -1) {
                z = false;
            }
            a(aeVar, i2, z, message.arg2);
        } else if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException();
            }
            h hVar = (h) message.obj;
            Iterator<q.b> it = this.g.iterator();
            while (it.hasNext()) {
                it.next().a(hVar);
            }
        } else {
            p pVar = (p) message.obj;
            if (this.p.equals(pVar)) {
                return;
            }
            this.p = pVar;
            Iterator<q.b> it2 = this.g.iterator();
            while (it2.hasNext()) {
                it2.next().a(pVar);
            }
        }
    }

    @Override // com.opos.exoplayer.core.i
    public void a(com.opos.exoplayer.core.e.e eVar) {
        a(eVar, true, true);
    }

    public void a(com.opos.exoplayer.core.e.e eVar, boolean z, boolean z2) {
        ae a2 = a(z, z2, 2);
        this.n = true;
        this.m++;
        this.e.a(eVar, z, z2);
        a(a2, false, 4, 1, false);
    }

    @Override // com.opos.exoplayer.core.q
    public void a(q.b bVar) {
        this.g.add(bVar);
    }

    @Override // com.opos.exoplayer.core.q
    public void a(boolean z) {
        if (this.j != z) {
            this.j = z;
            this.e.a(z);
            Iterator<q.b> it = this.g.iterator();
            while (it.hasNext()) {
                it.next().a(z, this.q.f);
            }
        }
    }

    @Override // com.opos.exoplayer.core.q
    public int b(int i) {
        return this.f11910a[i].a();
    }

    @Override // com.opos.exoplayer.core.q
    public q.c b() {
        return null;
    }

    @Override // com.opos.exoplayer.core.q
    public void b(q.b bVar) {
        this.g.remove(bVar);
    }

    @Override // com.opos.exoplayer.core.q
    public int c() {
        return this.q.f;
    }

    @Override // com.opos.exoplayer.core.q
    public boolean d() {
        return this.j;
    }

    @Override // com.opos.exoplayer.core.q
    public p e() {
        return this.p;
    }

    @Override // com.opos.exoplayer.core.q
    public void f() {
        com.opos.cmn.an.f.a.a("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.7.3] [" + com.opos.exoplayer.core.i.u.e + "] [" + k.a() + "]");
        this.e.a();
        this.d.removeCallbacksAndMessages(null);
    }

    @Override // com.opos.exoplayer.core.q
    public com.opos.exoplayer.core.g.g g() {
        return this.q.h.f11751c;
    }

    @Override // com.opos.exoplayer.core.q
    public y h() {
        return this.q.f11375a;
    }

    @Override // com.opos.exoplayer.core.q
    public int i() {
        return r() ? this.r : this.q.f11375a.a(this.q.f11376c.f11598a, this.i).f11907c;
    }

    @Override // com.opos.exoplayer.core.q
    public int j() {
        y yVar = this.q.f11375a;
        if (yVar.a()) {
            return -1;
        }
        return yVar.a(i(), this.k, this.l);
    }

    @Override // com.opos.exoplayer.core.q
    public int k() {
        y yVar = this.q.f11375a;
        if (yVar.a()) {
            return -1;
        }
        return yVar.b(i(), this.k, this.l);
    }

    @Override // com.opos.exoplayer.core.q
    public long l() {
        y yVar = this.q.f11375a;
        if (yVar.a()) {
            return com.anythink.expressad.exoplayer.b.b;
        }
        if (o()) {
            e.b bVar = this.q.f11376c;
            yVar.a(bVar.f11598a, this.i);
            return b.a(this.i.c(bVar.b, bVar.f11599c));
        }
        return yVar.a(i(), this.h).b();
    }

    @Override // com.opos.exoplayer.core.q
    public long m() {
        return r() ? this.t : b(this.q.i);
    }

    @Override // com.opos.exoplayer.core.q
    public long n() {
        return r() ? this.t : b(this.q.j);
    }

    @Override // com.opos.exoplayer.core.q
    public boolean o() {
        return !r() && this.q.f11376c.a();
    }

    @Override // com.opos.exoplayer.core.q
    public long p() {
        if (o()) {
            this.q.f11375a.a(this.q.f11376c.f11598a, this.i);
            return this.i.b() + b.a(this.q.e);
        }
        return m();
    }

    public int q() {
        return r() ? this.s : this.q.f11376c.f11598a;
    }
}
