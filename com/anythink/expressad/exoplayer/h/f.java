package com.anythink.expressad.exoplayer.h;

import android.os.Handler;
import com.anythink.expressad.exoplayer.h.s;
import com.anythink.expressad.exoplayer.h.t;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/f.class */
public abstract class f<T> extends c {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<T, b> f4609a = new HashMap<>();
    private com.anythink.expressad.exoplayer.h b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f4610c;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/f$a.class */
    final class a implements t {
        private final T b;

        /* renamed from: c  reason: collision with root package name */
        private t.a f4613c;

        public a(T t) {
            this.f4613c = f.this.a((s.a) null);
            this.b = t;
        }

        private t.c a(t.c cVar) {
            long a2 = f.this.a(cVar.f);
            long a3 = f.this.a(cVar.g);
            return (a2 == cVar.f && a3 == cVar.g) ? cVar : new t.c(cVar.f4667a, cVar.b, cVar.f4668c, cVar.d, cVar.e, a2, a3);
        }

        private boolean d(int i, s.a aVar) {
            s.a aVar2;
            if (aVar != null) {
                s.a a2 = f.this.a((f) this.b, aVar);
                aVar2 = a2;
                if (a2 == null) {
                    return false;
                }
            } else {
                aVar2 = null;
            }
            int a3 = f.this.a((f) this.b, i);
            if (this.f4613c.f4647a == a3 && com.anythink.expressad.exoplayer.k.af.a(this.f4613c.b, aVar2)) {
                return true;
            }
            this.f4613c = f.this.a(a3, aVar2);
            return true;
        }

        @Override // com.anythink.expressad.exoplayer.h.t
        public final void a(int i, s.a aVar) {
            if (d(i, aVar)) {
                this.f4613c.a();
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.t
        public final void a(int i, s.a aVar, t.b bVar, t.c cVar) {
            if (d(i, aVar)) {
                this.f4613c.a(bVar, a(cVar));
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.t
        public final void a(int i, s.a aVar, t.b bVar, t.c cVar, IOException iOException, boolean z) {
            if (d(i, aVar)) {
                this.f4613c.a(bVar, a(cVar), iOException, z);
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.t
        public final void a(int i, s.a aVar, t.c cVar) {
            if (d(i, aVar)) {
                this.f4613c.a(a(cVar));
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.t
        public final void b(int i, s.a aVar) {
            if (d(i, aVar)) {
                this.f4613c.b();
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.t
        public final void b(int i, s.a aVar, t.b bVar, t.c cVar) {
            if (d(i, aVar)) {
                this.f4613c.b(bVar, a(cVar));
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.t
        public final void b(int i, s.a aVar, t.c cVar) {
            if (d(i, aVar)) {
                this.f4613c.b(a(cVar));
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.t
        public final void c(int i, s.a aVar) {
            if (d(i, aVar)) {
                this.f4613c.c();
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.t
        public final void c(int i, s.a aVar, t.b bVar, t.c cVar) {
            if (d(i, aVar)) {
                this.f4613c.c(bVar, a(cVar));
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/f$b.class */
    static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final s f4614a;
        public final s.b b;

        /* renamed from: c  reason: collision with root package name */
        public final t f4615c;

        public b(s sVar, s.b bVar, t tVar) {
            this.f4614a = sVar;
            this.b = bVar;
            this.f4615c = tVar;
        }
    }

    protected int a(T t, int i) {
        return i;
    }

    protected long a(long j) {
        return j;
    }

    protected s.a a(T t, s.a aVar) {
        return aVar;
    }

    @Override // com.anythink.expressad.exoplayer.h.c
    public void a() {
        for (b bVar : this.f4609a.values()) {
            bVar.f4614a.a(bVar.b);
            bVar.f4614a.a(bVar.f4615c);
        }
        this.f4609a.clear();
        this.b = null;
    }

    @Override // com.anythink.expressad.exoplayer.h.c
    public void a(com.anythink.expressad.exoplayer.h hVar, boolean z) {
        this.b = hVar;
        this.f4610c = new Handler();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(T t) {
        b remove = this.f4609a.remove(t);
        remove.f4614a.a(remove.b);
        remove.f4614a.a(remove.f4615c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(final T t, s sVar) {
        com.anythink.expressad.exoplayer.k.a.a(!this.f4609a.containsKey(t));
        s.b bVar = new s.b() { // from class: com.anythink.expressad.exoplayer.h.f.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.anythink.expressad.exoplayer.h.s.b
            public final void a(s sVar2, com.anythink.expressad.exoplayer.ae aeVar, Object obj) {
                f.this.a(t, sVar2, aeVar, obj);
            }
        };
        a aVar = new a(t);
        this.f4609a.put(t, new b(sVar, bVar, aVar));
        sVar.a(this.f4610c, aVar);
        sVar.a(this.b, false, bVar);
    }

    protected abstract void a(T t, s sVar, com.anythink.expressad.exoplayer.ae aeVar, Object obj);

    @Override // com.anythink.expressad.exoplayer.h.s
    public void b() {
        for (b bVar : this.f4609a.values()) {
            bVar.f4614a.b();
        }
    }
}
