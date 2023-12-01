package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import com.heytap.nearx.a.a.e;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/s.class */
public final class s extends com.heytap.nearx.a.a.b<s, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<s> f12675c = new b();
    public static final Boolean d = false;
    public static final n e = n.HORIZONTAL;
    public static final c f = c.UNKNOWN;
    public static final Long g = Long.valueOf((long) com.anythink.expressad.video.module.a.a.m.ag);
    public static final Integer h = 0;
    public static final Boolean i = true;
    public static final j j = j.UNKNOWN_MODE;
    public static final Boolean k = false;
    private static final long serialVersionUID = 0;
    public final String l;
    public final List<f> m;
    public final Boolean n;
    public final n o;
    public final c p;
    public final Long q;
    public final Integer r;
    public final Boolean s;
    public final j t;
    public final Boolean u;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/s$a.class */
    public static final class a extends b.a<s, a> {

        /* renamed from: c  reason: collision with root package name */
        public String f12676c;
        public List<f> d = com.heytap.nearx.a.a.a.b.a();
        public Boolean e;
        public n f;
        public c g;
        public Long h;
        public Integer i;
        public Boolean j;
        public j k;
        public Boolean l;

        public a a(c cVar) {
            this.g = cVar;
            return this;
        }

        public a a(j jVar) {
            this.k = jVar;
            return this;
        }

        public a a(n nVar) {
            this.f = nVar;
            return this;
        }

        public a a(Boolean bool) {
            this.e = bool;
            return this;
        }

        public a a(Integer num) {
            this.i = num;
            return this;
        }

        public a a(Long l) {
            this.h = l;
            return this;
        }

        public a a(String str) {
            this.f12676c = str;
            return this;
        }

        public a b(Boolean bool) {
            this.j = bool;
            return this;
        }

        public s b() {
            Boolean bool;
            j jVar;
            String str = this.f12676c;
            if (str == null || (bool = this.e) == null || (jVar = this.k) == null) {
                throw com.heytap.nearx.a.a.a.b.a(this.f12676c, "posId", this.e, "isConcurrentEnable", this.k, "distributionMode");
            }
            return new s(str, this.d, bool, this.f, this.g, this.h, this.i, this.j, jVar, this.l, super.a());
        }

        public a c(Boolean bool) {
            this.l = bool;
            return this;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/s$b.class */
    static final class b extends com.heytap.nearx.a.a.e<s> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, s.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(s sVar) {
            int a2 = com.heytap.nearx.a.a.e.p.a(1, (int) sVar.l);
            int a3 = f.f12649c.a().a(2, (int) sVar.m);
            int a4 = com.heytap.nearx.a.a.e.f8653c.a(3, (int) sVar.n);
            int i = 0;
            int a5 = sVar.o != null ? n.f12666c.a(4, (int) sVar.o) : 0;
            int a6 = sVar.p != null ? c.j.a(5, (int) sVar.p) : 0;
            int a7 = sVar.q != null ? com.heytap.nearx.a.a.e.i.a(6, (int) sVar.q) : 0;
            int a8 = sVar.r != null ? com.heytap.nearx.a.a.e.g.a(7, (int) sVar.r) : 0;
            int a9 = sVar.s != null ? com.heytap.nearx.a.a.e.f8653c.a(8, (int) sVar.s) : 0;
            int a10 = j.e.a(9, (int) sVar.t);
            if (sVar.u != null) {
                i = com.heytap.nearx.a.a.e.f8653c.a(10, (int) sVar.u);
            }
            return a9 + a4 + a2 + a3 + a5 + a6 + a7 + a8 + a10 + i + sVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, s sVar) throws IOException {
            com.heytap.nearx.a.a.e.p.a(gVar, 1, sVar.l);
            f.f12649c.a().a(gVar, 2, sVar.m);
            com.heytap.nearx.a.a.e.f8653c.a(gVar, 3, sVar.n);
            if (sVar.o != null) {
                n.f12666c.a(gVar, 4, sVar.o);
            }
            if (sVar.p != null) {
                c.j.a(gVar, 5, sVar.p);
            }
            if (sVar.q != null) {
                com.heytap.nearx.a.a.e.i.a(gVar, 6, sVar.q);
            }
            if (sVar.r != null) {
                com.heytap.nearx.a.a.e.g.a(gVar, 7, sVar.r);
            }
            if (sVar.s != null) {
                com.heytap.nearx.a.a.e.f8653c.a(gVar, 8, sVar.s);
            }
            j.e.a(gVar, 9, sVar.t);
            if (sVar.u != null) {
                com.heytap.nearx.a.a.e.f8653c.a(gVar, 10, sVar.u);
            }
            gVar.a(sVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public s a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.d.add(f.f12649c.a(fVar));
                        break;
                    case 3:
                        aVar.a(com.heytap.nearx.a.a.e.f8653c.a(fVar));
                        break;
                    case 4:
                        aVar.a(n.f12666c.a(fVar));
                        break;
                    case 5:
                        aVar.a(c.j.a(fVar));
                        break;
                    case 6:
                        aVar.a(com.heytap.nearx.a.a.e.i.a(fVar));
                        break;
                    case 7:
                        aVar.a(com.heytap.nearx.a.a.e.g.a(fVar));
                        break;
                    case 8:
                        aVar.b(com.heytap.nearx.a.a.e.f8653c.a(fVar));
                        break;
                    case 9:
                        try {
                            aVar.a(j.e.a(fVar));
                            break;
                        } catch (e.a e) {
                            aVar.a(b, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e.f8655a));
                            break;
                        }
                    case 10:
                        aVar.c(com.heytap.nearx.a.a.e.f8653c.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a c2 = fVar.c();
                        aVar.a(b, c2, c2.a().a(fVar));
                        break;
                }
            }
        }
    }

    public s(String str, List<f> list, Boolean bool, n nVar, c cVar, Long l, Integer num, Boolean bool2, j jVar, Boolean bool3, ByteString byteString) {
        super(f12675c, byteString);
        this.l = str;
        this.m = com.heytap.nearx.a.a.a.b.b("channelStrategy", list);
        this.n = bool;
        this.o = nVar;
        this.p = cVar;
        this.q = l;
        this.r = num;
        this.s = bool2;
        this.t = jVar;
        this.u = bool3;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", posId=");
        sb.append(this.l);
        if (!this.m.isEmpty()) {
            sb.append(", channelStrategy=");
            sb.append(this.m);
        }
        sb.append(", isConcurrentEnable=");
        sb.append(this.n);
        if (this.o != null) {
            sb.append(", orientation=");
            sb.append(this.o);
        }
        if (this.p != null) {
            sb.append(", baseChannel=");
            sb.append(this.p);
        }
        if (this.q != null) {
            sb.append(", unionTimeout=");
            sb.append(this.q);
        }
        if (this.r != null) {
            sb.append(", backgroundColor=");
            sb.append(this.r);
        }
        if (this.s != null) {
            sb.append(", isGameDrawerClose=");
            sb.append(this.s);
        }
        sb.append(", distributionMode=");
        sb.append(this.t);
        if (this.u != null) {
            sb.append(", isBiddingOutEnable=");
            sb.append(this.u);
        }
        StringBuilder replace = sb.replace(0, 2, "StrategyInfo{");
        replace.append('}');
        return replace.toString();
    }
}
