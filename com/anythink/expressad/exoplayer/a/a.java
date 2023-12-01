package com.anythink.expressad.exoplayer.a;

import android.net.NetworkInfo;
import android.view.Surface;
import com.anythink.expressad.exoplayer.a.b;
import com.anythink.expressad.exoplayer.ae;
import com.anythink.expressad.exoplayer.b.g;
import com.anythink.expressad.exoplayer.g.f;
import com.anythink.expressad.exoplayer.h.af;
import com.anythink.expressad.exoplayer.h.s;
import com.anythink.expressad.exoplayer.h.t;
import com.anythink.expressad.exoplayer.j.d;
import com.anythink.expressad.exoplayer.l.h;
import com.anythink.expressad.exoplayer.m;
import com.anythink.expressad.exoplayer.v;
import com.anythink.expressad.exoplayer.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/a/a.class */
public final class a implements g, com.anythink.expressad.exoplayer.d.c, f, t, d.a, h, w.c {
    private final com.anythink.expressad.exoplayer.k.c b;
    private w e;

    /* renamed from: a  reason: collision with root package name */
    private final CopyOnWriteArraySet<com.anythink.expressad.exoplayer.a.b> f4310a = new CopyOnWriteArraySet<>();
    private final b d = new b();

    /* renamed from: c  reason: collision with root package name */
    private final ae.b f4311c = new ae.b();

    /* renamed from: com.anythink.expressad.exoplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/a/a$a.class */
    public static final class C0047a {
        public static a a(w wVar, com.anythink.expressad.exoplayer.k.c cVar) {
            return new a(wVar, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/a/a$b.class */
    public static final class b {

        /* renamed from: c  reason: collision with root package name */
        private c f4313c;
        private c d;
        private boolean f;

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList<c> f4312a = new ArrayList<>();
        private final ae.a b = new ae.a();
        private ae e = ae.f4321a;

        private c a(c cVar, ae aeVar) {
            int a2;
            if (!aeVar.a() && !this.e.a() && (a2 = aeVar.a(this.e.a(cVar.b.f4645a, this.b, true).b)) != -1) {
                return new c(aeVar.a(a2, this.b, false).f4323c, cVar.b.a(a2));
            }
            return cVar;
        }

        private void i() {
            if (this.f4312a.isEmpty()) {
                return;
            }
            this.f4313c = this.f4312a.get(0);
        }

        public final c a() {
            if (this.f4312a.isEmpty() || this.e.a() || this.f) {
                return null;
            }
            return this.f4312a.get(0);
        }

        public final s.a a(int i) {
            ae aeVar = this.e;
            s.a aVar = null;
            if (aeVar != null) {
                int c2 = aeVar.c();
                aVar = null;
                int i2 = 0;
                while (i2 < this.f4312a.size()) {
                    c cVar = this.f4312a.get(i2);
                    int i3 = cVar.b.f4645a;
                    s.a aVar2 = aVar;
                    if (i3 < c2) {
                        aVar2 = aVar;
                        if (this.e.a(i3, this.b, false).f4323c != i) {
                            continue;
                        } else if (aVar != null) {
                            return null;
                        } else {
                            aVar2 = cVar.b;
                        }
                    }
                    i2++;
                    aVar = aVar2;
                }
            }
            return aVar;
        }

        public final void a(int i, s.a aVar) {
            this.f4312a.add(new c(i, aVar));
            if (this.f4312a.size() != 1 || this.e.a()) {
                return;
            }
            i();
        }

        public final void a(ae aeVar) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f4312a.size()) {
                    break;
                }
                ArrayList<c> arrayList = this.f4312a;
                arrayList.set(i2, a(arrayList.get(i2), aeVar));
                i = i2 + 1;
            }
            c cVar = this.d;
            if (cVar != null) {
                this.d = a(cVar, aeVar);
            }
            this.e = aeVar;
            i();
        }

        public final c b() {
            return this.f4313c;
        }

        public final void b(int i, s.a aVar) {
            c cVar = new c(i, aVar);
            this.f4312a.remove(cVar);
            if (cVar.equals(this.d)) {
                this.d = this.f4312a.isEmpty() ? null : this.f4312a.get(0);
            }
        }

        public final c c() {
            return this.d;
        }

        public final void c(int i, s.a aVar) {
            this.d = new c(i, aVar);
        }

        public final c d() {
            if (this.f4312a.isEmpty()) {
                return null;
            }
            ArrayList<c> arrayList = this.f4312a;
            return arrayList.get(arrayList.size() - 1);
        }

        public final boolean e() {
            return this.f;
        }

        public final void f() {
            i();
        }

        public final void g() {
            this.f = true;
        }

        public final void h() {
            this.f = false;
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/a/a$c.class */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f4314a;
        public final s.a b;

        public c(int i, s.a aVar) {
            this.f4314a = i;
            this.b = aVar;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            return this.f4314a == cVar.f4314a && this.b.equals(cVar.b);
        }

        public final int hashCode() {
            return (this.f4314a * 31) + this.b.hashCode();
        }
    }

    protected a(w wVar, com.anythink.expressad.exoplayer.k.c cVar) {
        this.e = wVar;
        this.b = (com.anythink.expressad.exoplayer.k.c) com.anythink.expressad.exoplayer.k.a.a(cVar);
    }

    private b.a a(c cVar) {
        if (cVar == null) {
            int p = ((w) com.anythink.expressad.exoplayer.k.a.a(this.e)).p();
            return d(p, this.d.a(p));
        }
        return d(cVar.f4314a, cVar.b);
    }

    private void a(int i, int i2) {
        b.a i3 = i();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().a(i3, i, i2);
        }
    }

    private void a(NetworkInfo networkInfo) {
        b.a i = i();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().a(i, networkInfo);
        }
    }

    private void a(w wVar) {
        com.anythink.expressad.exoplayer.k.a.b(this.e == null);
        this.e = (w) com.anythink.expressad.exoplayer.k.a.a(wVar);
    }

    private b.a d(int i, s.a aVar) {
        long j;
        com.anythink.expressad.exoplayer.k.a.a(this.e);
        long a2 = this.b.a();
        ae F = this.e.F();
        if (i != this.e.p()) {
            j = 0;
            if (i < F.b()) {
                j = (aVar == null || !aVar.a()) ? com.anythink.expressad.exoplayer.b.a(F.a(i, this.f4311c, false).h) : 0L;
            }
        } else if (aVar == null || !aVar.a()) {
            j = this.e.B();
        } else {
            j = 0;
            if (this.e.z() == aVar.b) {
                j = 0;
                if (this.e.A() == aVar.f4646c) {
                    j = this.e.t();
                }
            }
        }
        return new b.a(a2, F, i, aVar, j, this.e.t(), this.e.u() - this.e.B());
    }

    private Set<com.anythink.expressad.exoplayer.a.b> g() {
        return Collections.unmodifiableSet(this.f4310a);
    }

    private b.a h() {
        return a(this.d.b());
    }

    private b.a i() {
        return a(this.d.a());
    }

    private b.a j() {
        return a(this.d.c());
    }

    private b.a k() {
        return a(this.d.d());
    }

    public final void a() {
        if (this.d.e()) {
            return;
        }
        b.a i = i();
        this.d.g();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().a(i);
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.g
    public final void a(int i) {
        b.a j = j();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().f(j, i);
        }
    }

    @Override // com.anythink.expressad.exoplayer.l.h
    public final void a(int i, int i2, int i3, float f) {
        b.a j = j();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().b(j, i, i2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.l.h
    public final void a(int i, long j) {
        b.a h = h();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().g(h, i);
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.g
    public final void a(int i, long j, long j2) {
        b.a j3 = j();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().a(j3, i, j, j2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.t
    public final void a(int i, s.a aVar) {
        this.d.a(i, aVar);
        b.a d = d(i, aVar);
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().c(d);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.t
    public final void a(int i, s.a aVar, t.b bVar, t.c cVar) {
        d(i, aVar);
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.t
    public final void a(int i, s.a aVar, t.b bVar, t.c cVar, IOException iOException, boolean z) {
        b.a d = d(i, aVar);
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().a(d, iOException);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.t
    public final void a(int i, s.a aVar, t.c cVar) {
        b.a d = d(i, aVar);
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().b(d, cVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.l.h
    public final void a(Surface surface) {
        b.a j = j();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().a(j, surface);
        }
    }

    public final void a(com.anythink.expressad.exoplayer.a.b bVar) {
        this.f4310a.add(bVar);
    }

    @Override // com.anythink.expressad.exoplayer.l.h
    public final void a(com.anythink.expressad.exoplayer.c.d dVar) {
        b.a i = i();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().d(i, 2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.g.f
    public final void a(com.anythink.expressad.exoplayer.g.a aVar) {
        b.a i = i();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().a(i, aVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.l.h
    public final void a(m mVar) {
        b.a j = j();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().a(j, 2, mVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.d.c
    public final void a(Exception exc) {
        b.a j = j();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().a(j, exc);
        }
    }

    @Override // com.anythink.expressad.exoplayer.l.h
    public final void a(String str, long j, long j2) {
        b.a j3 = j();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().a(j3, 2, str);
        }
    }

    public final void b() {
        for (c cVar : new ArrayList(this.d.f4312a)) {
            b(cVar.f4314a, cVar.b);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.t
    public final void b(int i, s.a aVar) {
        this.d.b(i, aVar);
        b.a d = d(i, aVar);
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().d(d);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.t
    public final void b(int i, s.a aVar, t.b bVar, t.c cVar) {
        d(i, aVar);
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.t
    public final void b(int i, s.a aVar, t.c cVar) {
        b.a d = d(i, aVar);
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().a(d, cVar);
        }
    }

    public final void b(com.anythink.expressad.exoplayer.a.b bVar) {
        this.f4310a.remove(bVar);
    }

    @Override // com.anythink.expressad.exoplayer.l.h
    public final void b(com.anythink.expressad.exoplayer.c.d dVar) {
        b.a h = h();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().e(h, 2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.g
    public final void b(m mVar) {
        b.a j = j();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().a(j, 1, mVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.g
    public final void b(String str, long j, long j2) {
        b.a j3 = j();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().a(j3, 1, str);
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.d.a
    public final void c() {
        a(this.d.d());
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.t
    public final void c(int i, s.a aVar) {
        this.d.c(i, aVar);
        b.a d = d(i, aVar);
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().e(d);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.t
    public final void c(int i, s.a aVar, t.b bVar, t.c cVar) {
        d(i, aVar);
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.g
    public final void c(com.anythink.expressad.exoplayer.c.d dVar) {
        b.a i = i();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().d(i, 1);
        }
    }

    @Override // com.anythink.expressad.exoplayer.d.c
    public final void d() {
        b.a j = j();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().f(j);
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.g
    public final void d(com.anythink.expressad.exoplayer.c.d dVar) {
        b.a h = h();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().e(h, 1);
        }
    }

    @Override // com.anythink.expressad.exoplayer.d.c
    public final void e() {
        b.a j = j();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().g(j);
        }
    }

    @Override // com.anythink.expressad.exoplayer.d.c
    public final void f() {
        b.a j = j();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().h(j);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onLoadingChanged(boolean z) {
        b.a i = i();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().b(i, z);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onPlaybackParametersChanged(v vVar) {
        b.a i = i();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().a(i, vVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onPlayerError(com.anythink.expressad.exoplayer.g gVar) {
        b.a i = i();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().a(i, gVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onPlayerStateChanged(boolean z, int i) {
        b.a i2 = i();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().a(i2, z, i);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onPositionDiscontinuity(int i) {
        this.d.f();
        b.a i2 = i();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().b(i2, i);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onRepeatModeChanged(int i) {
        b.a i2 = i();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().c(i2, i);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onSeekProcessed() {
        if (this.d.e()) {
            this.d.h();
            b.a i = i();
            Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
            while (it.hasNext()) {
                it.next().b(i);
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onShuffleModeEnabledChanged(boolean z) {
        b.a i = i();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().a(i, z);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onTimelineChanged(ae aeVar, Object obj, int i) {
        this.d.a(aeVar);
        b.a i2 = i();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().a(i2, i);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onTracksChanged(af afVar, com.anythink.expressad.exoplayer.i.g gVar) {
        b.a i = i();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.f4310a.iterator();
        while (it.hasNext()) {
            it.next().a(i, gVar);
        }
    }
}
