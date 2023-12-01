package com.opos.cmn.an.g;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/g/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final b f24545a;
    public final c b;

    /* renamed from: c  reason: collision with root package name */
    public final com.opos.cmn.an.g.a f24546c;
    public final d d;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/g/e$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private b f24547a;
        private c b;

        /* renamed from: c  reason: collision with root package name */
        private com.opos.cmn.an.g.a f24548c;
        private d d;

        private void b() {
            if (this.f24547a == null) {
                this.f24547a = new com.opos.cmn.an.g.a.b.a();
            }
            if (this.b == null) {
                this.b = new com.opos.cmn.an.g.a.d.a();
            }
            if (this.f24548c == null) {
                this.f24548c = new com.opos.cmn.an.g.a.c.a();
            }
            if (this.d == null) {
                this.d = new com.opos.cmn.an.g.a.e.a();
            }
        }

        public a a(com.opos.cmn.an.g.a aVar) {
            this.f24548c = aVar;
            return this;
        }

        public a a(b bVar) {
            this.f24547a = bVar;
            return this;
        }

        public a a(c cVar) {
            this.b = cVar;
            return this;
        }

        public a a(d dVar) {
            this.d = dVar;
            return this;
        }

        public e a() {
            b();
            return new e(this);
        }
    }

    public e(a aVar) {
        this.f24545a = aVar.f24547a;
        this.b = aVar.b;
        this.f24546c = aVar.f24548c;
        this.d = aVar.d;
    }

    public String toString() {
        return "NetInitParams{iHttpExecutor=" + this.f24545a + ", iHttpsExecutor=" + this.b + ", iHttp2Executor=" + this.f24546c + ", iSpdyExecutor=" + this.d + '}';
    }
}
