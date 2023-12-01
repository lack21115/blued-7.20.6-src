package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/r.class */
public final class r extends com.heytap.nearx.a.a.b<r, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<r> f26361c = new b();
    public static final Long d = 0L;
    public static final Long e = 0L;
    private static final long serialVersionUID = 0;
    public final List<e> f;
    public final List<s> g;
    public final Long h;
    public final com.opos.mobad.m.a.b i;
    public final Long j;
    public final String k;
    public final List<o> l;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/r$a.class */
    public static final class a extends b.a<r, a> {
        public Long e;
        public com.opos.mobad.m.a.b f;
        public Long g;
        public String h;

        /* renamed from: c  reason: collision with root package name */
        public List<e> f26362c = com.heytap.nearx.a.a.a.b.a();
        public List<s> d = com.heytap.nearx.a.a.a.b.a();
        public List<o> i = com.heytap.nearx.a.a.a.b.a();

        public a a(com.opos.mobad.m.a.b bVar) {
            this.f = bVar;
            return this;
        }

        public a a(Long l) {
            this.e = l;
            return this;
        }

        public a a(String str) {
            this.h = str;
            return this;
        }

        public a a(List<s> list) {
            com.heytap.nearx.a.a.a.b.a(list);
            this.d = list;
            return this;
        }

        public a b(Long l) {
            this.g = l;
            return this;
        }

        public r b() {
            com.opos.mobad.m.a.b bVar;
            Long l = this.e;
            if (l == null || (bVar = this.f) == null) {
                throw com.heytap.nearx.a.a.a.b.a(this.e, "adEnableTime", this.f, "appConfig");
            }
            return new r(this.f26362c, this.d, l, bVar, this.g, this.h, this.i, super.a());
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/r$b.class */
    static final class b extends com.heytap.nearx.a.a.e<r> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, r.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(r rVar) {
            int a2 = e.f26335c.a().a(1, (int) rVar.f);
            int a3 = s.f26363c.a().a(2, (int) rVar.g);
            int a4 = com.heytap.nearx.a.a.e.i.a(3, (int) rVar.h);
            int a5 = com.opos.mobad.m.a.b.f26329c.a(4, (int) rVar.i);
            int i = 0;
            int a6 = rVar.j != null ? com.heytap.nearx.a.a.e.i.a(5, (int) rVar.j) : 0;
            if (rVar.k != null) {
                i = com.heytap.nearx.a.a.e.p.a(6, (int) rVar.k);
            }
            return a6 + a5 + a2 + a3 + a4 + i + o.f26355c.a().a(7, (int) rVar.l) + rVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, r rVar) throws IOException {
            e.f26335c.a().a(gVar, 1, rVar.f);
            s.f26363c.a().a(gVar, 2, rVar.g);
            com.heytap.nearx.a.a.e.i.a(gVar, 3, rVar.h);
            com.opos.mobad.m.a.b.f26329c.a(gVar, 4, rVar.i);
            if (rVar.j != null) {
                com.heytap.nearx.a.a.e.i.a(gVar, 5, rVar.j);
            }
            if (rVar.k != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 6, rVar.k);
            }
            o.f26355c.a().a(gVar, 7, rVar.l);
            gVar.a(rVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public r a(com.heytap.nearx.a.a.f fVar) throws IOException {
            Collection collection;
            com.heytap.nearx.a.a.e eVar;
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
                        collection = aVar.f26362c;
                        eVar = e.f26335c;
                        break;
                    case 2:
                        collection = aVar.d;
                        eVar = s.f26363c;
                        break;
                    case 3:
                        aVar.a(com.heytap.nearx.a.a.e.i.a(fVar));
                        continue;
                    case 4:
                        aVar.a(com.opos.mobad.m.a.b.f26329c.a(fVar));
                        continue;
                    case 5:
                        aVar.b(com.heytap.nearx.a.a.e.i.a(fVar));
                        continue;
                    case 6:
                        aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                        continue;
                    case 7:
                        collection = aVar.i;
                        eVar = o.f26355c;
                        break;
                    default:
                        com.heytap.nearx.a.a.a c2 = fVar.c();
                        aVar.a(b, c2, c2.a().a(fVar));
                        continue;
                }
                collection.add(eVar.a(fVar));
            }
        }
    }

    public r(List<e> list, List<s> list2, Long l, com.opos.mobad.m.a.b bVar, Long l2, String str, List<o> list3, ByteString byteString) {
        super(f26361c, byteString);
        this.f = com.heytap.nearx.a.a.a.b.b("channelList", list);
        this.g = com.heytap.nearx.a.a.a.b.b("strategyList", list2);
        this.h = l;
        this.i = bVar;
        this.j = l2;
        this.k = str;
        this.l = com.heytap.nearx.a.a.a.b.b("preLoadResource", list3);
    }

    public a c() {
        a aVar = new a();
        aVar.f26362c = com.heytap.nearx.a.a.a.b.a("channelList", this.f);
        aVar.d = com.heytap.nearx.a.a.a.b.a("strategyList", this.g);
        aVar.e = this.h;
        aVar.f = this.i;
        aVar.g = this.j;
        aVar.h = this.k;
        aVar.i = com.heytap.nearx.a.a.a.b.a("preLoadResource", this.l);
        aVar.a(a());
        return aVar;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f.isEmpty()) {
            sb.append(", channelList=");
            sb.append(this.f);
        }
        if (!this.g.isEmpty()) {
            sb.append(", strategyList=");
            sb.append(this.g);
        }
        sb.append(", adEnableTime=");
        sb.append(this.h);
        sb.append(", appConfig=");
        sb.append(this.i);
        if (this.j != null) {
            sb.append(", strategyVersionCode=");
            sb.append(this.j);
        }
        if (this.k != null) {
            sb.append(", transportData=");
            sb.append(this.k);
        }
        if (!this.l.isEmpty()) {
            sb.append(", preLoadResource=");
            sb.append(this.l);
        }
        StringBuilder replace = sb.replace(0, 2, "ResponseInfo{");
        replace.append('}');
        return replace.toString();
    }
}
