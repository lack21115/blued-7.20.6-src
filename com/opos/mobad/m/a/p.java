package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/p.class */
public final class p extends com.heytap.nearx.a.a.b<p, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<p> f12669c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    public static final Long f = 0L;
    public static final Long g = 0L;
    private static final long serialVersionUID = 0;
    public final String h;
    public final String i;
    public final Integer j;
    public final Integer k;
    public final Long l;
    public final String m;
    public final h n;
    public final m o;
    public final k p;
    public final x q;
    public final l r;
    public final Long s;
    public final t t;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/p$a.class */
    public static final class a extends b.a<p, a> {

        /* renamed from: c  reason: collision with root package name */
        public String f12670c;
        public String d;
        public Integer e;
        public Integer f;
        public Long g;
        public String h;
        public h i;
        public m j;
        public k k;
        public x l;
        public l m;
        public Long n;
        public t o;

        public a a(h hVar) {
            this.i = hVar;
            return this;
        }

        public a a(k kVar) {
            this.k = kVar;
            return this;
        }

        public a a(l lVar) {
            this.m = lVar;
            return this;
        }

        public a a(m mVar) {
            this.j = mVar;
            return this;
        }

        public a a(t tVar) {
            this.o = tVar;
            return this;
        }

        public a a(x xVar) {
            this.l = xVar;
            return this;
        }

        public a a(Integer num) {
            this.e = num;
            return this;
        }

        public a a(Long l) {
            this.g = l;
            return this;
        }

        public a a(String str) {
            this.f12670c = str;
            return this;
        }

        public a b(Integer num) {
            this.f = num;
            return this;
        }

        public a b(Long l) {
            this.n = l;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public p b() {
            String str;
            Integer num;
            Integer num2;
            String str2 = this.f12670c;
            if (str2 == null || (str = this.d) == null || (num = this.e) == null || (num2 = this.f) == null) {
                throw com.heytap.nearx.a.a.a.b.a(this.f12670c, "appId", this.d, "packageName", this.e, "platform", this.f, "sdkVerCode");
            }
            return new p(str2, str, num, num2, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, super.a());
        }

        public a c(String str) {
            this.h = str;
            return this;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/p$b.class */
    static final class b extends com.heytap.nearx.a.a.e<p> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, p.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(p pVar) {
            int a2 = com.heytap.nearx.a.a.e.p.a(1, (int) pVar.h);
            int a3 = com.heytap.nearx.a.a.e.p.a(2, (int) pVar.i);
            int a4 = com.heytap.nearx.a.a.e.d.a(3, (int) pVar.j);
            int a5 = com.heytap.nearx.a.a.e.d.a(4, (int) pVar.k);
            int i = 0;
            int a6 = pVar.l != null ? com.heytap.nearx.a.a.e.i.a(5, (int) pVar.l) : 0;
            int a7 = pVar.m != null ? com.heytap.nearx.a.a.e.p.a(6, (int) pVar.m) : 0;
            int a8 = pVar.n != null ? h.f12653c.a(7, (int) pVar.n) : 0;
            int a9 = pVar.o != null ? m.f12663c.a(8, (int) pVar.o) : 0;
            int a10 = pVar.p != null ? k.f12659c.a(9, (int) pVar.p) : 0;
            int a11 = pVar.q != null ? x.f12685c.a(10, (int) pVar.q) : 0;
            int a12 = pVar.r != null ? l.f12661c.a(11, (int) pVar.r) : 0;
            int a13 = pVar.s != null ? com.heytap.nearx.a.a.e.i.a(12, (int) pVar.s) : 0;
            if (pVar.t != null) {
                i = t.f12677c.a(13, (int) pVar.t);
            }
            return a13 + a5 + a2 + a3 + a4 + a6 + a7 + a8 + a9 + a10 + a11 + a12 + i + pVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, p pVar) throws IOException {
            com.heytap.nearx.a.a.e.p.a(gVar, 1, pVar.h);
            com.heytap.nearx.a.a.e.p.a(gVar, 2, pVar.i);
            com.heytap.nearx.a.a.e.d.a(gVar, 3, pVar.j);
            com.heytap.nearx.a.a.e.d.a(gVar, 4, pVar.k);
            if (pVar.l != null) {
                com.heytap.nearx.a.a.e.i.a(gVar, 5, pVar.l);
            }
            if (pVar.m != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 6, pVar.m);
            }
            if (pVar.n != null) {
                h.f12653c.a(gVar, 7, pVar.n);
            }
            if (pVar.o != null) {
                m.f12663c.a(gVar, 8, pVar.o);
            }
            if (pVar.p != null) {
                k.f12659c.a(gVar, 9, pVar.p);
            }
            if (pVar.q != null) {
                x.f12685c.a(gVar, 10, pVar.q);
            }
            if (pVar.r != null) {
                l.f12661c.a(gVar, 11, pVar.r);
            }
            if (pVar.s != null) {
                com.heytap.nearx.a.a.e.i.a(gVar, 12, pVar.s);
            }
            if (pVar.t != null) {
                t.f12677c.a(gVar, 13, pVar.t);
            }
            gVar.a(pVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public p a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b = fVar.b();
                if (b == -1) {
                    fVar.a(a2);
                    return aVar.b();
                }
                switch (b) {
                    case 1:
                        aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 2:
                        aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 3:
                        aVar.a(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 4:
                        aVar.b(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 5:
                        aVar.a(com.heytap.nearx.a.a.e.i.a(fVar));
                        break;
                    case 6:
                        aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 7:
                        aVar.a(h.f12653c.a(fVar));
                        break;
                    case 8:
                        aVar.a(m.f12663c.a(fVar));
                        break;
                    case 9:
                        aVar.a(k.f12659c.a(fVar));
                        break;
                    case 10:
                        aVar.a(x.f12685c.a(fVar));
                        break;
                    case 11:
                        aVar.a(l.f12661c.a(fVar));
                        break;
                    case 12:
                        aVar.b(com.heytap.nearx.a.a.e.i.a(fVar));
                        break;
                    case 13:
                        aVar.a(t.f12677c.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a c2 = fVar.c();
                        aVar.a(b, c2, c2.a().a(fVar));
                        break;
                }
            }
        }
    }

    public p(String str, String str2, Integer num, Integer num2, Long l, String str3, h hVar, m mVar, k kVar, x xVar, l lVar, Long l2, t tVar, ByteString byteString) {
        super(f12669c, byteString);
        this.h = str;
        this.i = str2;
        this.j = num;
        this.k = num2;
        this.l = l;
        this.m = str3;
        this.n = hVar;
        this.o = mVar;
        this.p = kVar;
        this.q = xVar;
        this.r = lVar;
        this.s = l2;
        this.t = tVar;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", appId=");
        sb.append(this.h);
        sb.append(", packageName=");
        sb.append(this.i);
        sb.append(", platform=");
        sb.append(this.j);
        sb.append(", sdkVerCode=");
        sb.append(this.k);
        if (this.l != null) {
            sb.append(", firstActiveTime=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", platformPkgName=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", devInfo=");
            sb.append(this.n);
        }
        if (this.o != null) {
            sb.append(", marketInfo=");
            sb.append(this.o);
        }
        if (this.p != null) {
            sb.append(", instantInfo=");
            sb.append(this.p);
        }
        if (this.q != null) {
            sb.append(", xgameInfo=");
            sb.append(this.q);
        }
        if (this.r != null) {
            sb.append(", localInfo=");
            sb.append(this.r);
        }
        if (this.s != null) {
            sb.append(", curStrategyVersionCode=");
            sb.append(this.s);
        }
        if (this.t != null) {
            sb.append(", userAccountInfo=");
            sb.append(this.t);
        }
        StringBuilder replace = sb.replace(0, 2, "Request{");
        replace.append('}');
        return replace.toString();
    }
}
