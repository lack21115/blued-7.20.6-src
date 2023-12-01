package com.anythink.expressad.exoplayer.h;

import com.anythink.expressad.exoplayer.h.aa;
import com.anythink.expressad.exoplayer.h.s;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/q.class */
public final class q extends f<Void> {

    /* renamed from: a  reason: collision with root package name */
    private final s f7481a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private int f7482c;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/q$a.class */
    static final class a extends p {
        public a(com.anythink.expressad.exoplayer.ae aeVar) {
            super(aeVar);
        }

        @Override // com.anythink.expressad.exoplayer.h.p, com.anythink.expressad.exoplayer.ae
        public final int a(int i, int i2, boolean z) {
            int a2 = this.b.a(i, i2, z);
            int i3 = a2;
            if (a2 == -1) {
                i3 = b(z);
            }
            return i3;
        }

        @Override // com.anythink.expressad.exoplayer.h.p, com.anythink.expressad.exoplayer.ae
        public final int b(int i, int i2, boolean z) {
            int b = this.b.b(i, i2, z);
            int i3 = b;
            if (b == -1) {
                i3 = a(z);
            }
            return i3;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/q$b.class */
    static final class b extends com.anythink.expressad.exoplayer.h.a {
        private final com.anythink.expressad.exoplayer.ae b;

        /* renamed from: c  reason: collision with root package name */
        private final int f7483c;
        private final int d;
        private final int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.anythink.expressad.exoplayer.ae aeVar, int i) {
            super(false, new aa.b(i));
            boolean z = false;
            this.b = aeVar;
            this.f7483c = aeVar.c();
            this.d = aeVar.b();
            this.e = i;
            int i2 = this.f7483c;
            if (i2 > 0) {
                com.anythink.expressad.exoplayer.k.a.b(i <= Integer.MAX_VALUE / i2 ? true : z, "LoopingMediaSource contains too many periods");
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        protected final int a(int i) {
            return i / this.f7483c;
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final int b() {
            return this.d * this.e;
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        protected final int b(int i) {
            return i / this.d;
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        protected final int b(Object obj) {
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return -1;
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final int c() {
            return this.f7483c * this.e;
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        protected final com.anythink.expressad.exoplayer.ae c(int i) {
            return this.b;
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        protected final int d(int i) {
            return i * this.f7483c;
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        protected final int e(int i) {
            return i * this.d;
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        protected final Object f(int i) {
            return Integer.valueOf(i);
        }
    }

    private q(s sVar) {
        this(sVar, (byte) 0);
    }

    private q(s sVar, byte b2) {
        com.anythink.expressad.exoplayer.k.a.a(true);
        this.f7481a = sVar;
        this.b = Integer.MAX_VALUE;
    }

    private void b(com.anythink.expressad.exoplayer.ae aeVar, Object obj) {
        this.f7482c = aeVar.c();
        a(this.b != Integer.MAX_VALUE ? new b(aeVar, this.b) : new a(aeVar), obj);
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final r a(s.a aVar, com.anythink.expressad.exoplayer.j.b bVar) {
        return this.b != Integer.MAX_VALUE ? this.f7481a.a(aVar.a(aVar.f7484a % this.f7482c), bVar) : this.f7481a.a(aVar, bVar);
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a() {
        super.a();
        this.f7482c = 0;
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(r rVar) {
        this.f7481a.a(rVar);
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a(com.anythink.expressad.exoplayer.h hVar, boolean z) {
        super.a(hVar, z);
        a((q) null, this.f7481a);
    }

    @Override // com.anythink.expressad.exoplayer.h.f
    protected final /* synthetic */ void a(Void r6, s sVar, com.anythink.expressad.exoplayer.ae aeVar, Object obj) {
        this.f7482c = aeVar.c();
        a(this.b != Integer.MAX_VALUE ? new b(aeVar, this.b) : new a(aeVar), obj);
    }
}
