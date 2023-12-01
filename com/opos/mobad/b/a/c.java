package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import com.heytap.nearx.a.a.e;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/c.class */
public final class c extends com.heytap.nearx.a.a.b<c, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<c> f12030c = new b();
    public static final Integer d = 1;
    public static final Boolean e = true;
    public static final EnumC0505c f = EnumC0505c.SDK;
    public static final ac g = ac.MODE_ONE;
    public static final Boolean h = true;
    public static final Long i = 0L;
    private static final long serialVersionUID = 0;
    public final String A;
    public final Integer j;
    public final g k;
    public final ab l;
    public final z m;
    public final m n;
    public final String o;
    public final w p;
    public final u q;
    public final Boolean r;
    public final ah s;
    public final EnumC0505c t;
    public final String u;
    public final ac v;
    public final List<e> w;
    public final Boolean x;
    public final String y;
    public final Long z;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/c$a.class */
    public static final class a extends b.a<c, a> {

        /* renamed from: c  reason: collision with root package name */
        public Integer f12031c;
        public g d;
        public ab e;
        public z f;
        public m g;
        public String h;
        public w i;
        public u j;
        public Boolean k;
        public ah l;
        public EnumC0505c m;
        public String n;
        public ac o;
        public List<e> p = com.heytap.nearx.a.a.a.b.a();
        public Boolean q;
        public String r;
        public Long s;
        public String t;

        public a a(ab abVar) {
            this.e = abVar;
            return this;
        }

        public a a(ac acVar) {
            this.o = acVar;
            return this;
        }

        public a a(ah ahVar) {
            this.l = ahVar;
            return this;
        }

        public a a(EnumC0505c enumC0505c) {
            this.m = enumC0505c;
            return this;
        }

        public a a(g gVar) {
            this.d = gVar;
            return this;
        }

        public a a(m mVar) {
            this.g = mVar;
            return this;
        }

        public a a(u uVar) {
            this.j = uVar;
            return this;
        }

        public a a(w wVar) {
            this.i = wVar;
            return this;
        }

        public a a(z zVar) {
            this.f = zVar;
            return this;
        }

        public a a(Boolean bool) {
            this.k = bool;
            return this;
        }

        public a a(Integer num) {
            this.f12031c = num;
            return this;
        }

        public a a(Long l) {
            this.s = l;
            return this;
        }

        public a a(String str) {
            this.h = str;
            return this;
        }

        public a a(List<e> list) {
            com.heytap.nearx.a.a.a.b.a(list);
            this.p = list;
            return this;
        }

        public a b(Boolean bool) {
            this.q = bool;
            return this;
        }

        public a b(String str) {
            this.n = str;
            return this;
        }

        public c b() {
            return new c(this.f12031c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, super.a());
        }

        public a c(String str) {
            this.r = str;
            return this;
        }

        public a d(String str) {
            this.t = str;
            return this;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/c$b.class */
    static final class b extends com.heytap.nearx.a.a.e<c> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, c.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(c cVar) {
            int a2 = cVar.j != null ? com.heytap.nearx.a.a.e.d.a(1, (int) cVar.j) : 0;
            int a3 = cVar.k != null ? g.f12042c.a(2, (int) cVar.k) : 0;
            int a4 = cVar.l != null ? ab.f12004c.a(3, (int) cVar.l) : 0;
            int a5 = cVar.m != null ? z.f12112c.a(4, (int) cVar.m) : 0;
            int a6 = cVar.n != null ? m.f12054c.a(5, (int) cVar.n) : 0;
            int a7 = cVar.o != null ? com.heytap.nearx.a.a.e.p.a(6, (int) cVar.o) : 0;
            int a8 = cVar.p != null ? w.f12080c.a(7, (int) cVar.p) : 0;
            int a9 = cVar.q != null ? u.f12076c.a(8, (int) cVar.q) : 0;
            int a10 = cVar.r != null ? com.heytap.nearx.a.a.e.f8653c.a(9, (int) cVar.r) : 0;
            int a11 = cVar.s != null ? ah.f12018c.a(10, (int) cVar.s) : 0;
            int a12 = cVar.t != null ? EnumC0505c.f12033c.a(11, (int) cVar.t) : 0;
            int a13 = cVar.u != null ? com.heytap.nearx.a.a.e.p.a(12, (int) cVar.u) : 0;
            int a14 = cVar.v != null ? ac.f12007c.a(13, (int) cVar.v) : 0;
            int a15 = e.f12038c.a().a(14, (int) cVar.w);
            int a16 = cVar.x != null ? com.heytap.nearx.a.a.e.f8653c.a(15, (int) cVar.x) : 0;
            int a17 = cVar.y != null ? com.heytap.nearx.a.a.e.p.a(16, (int) cVar.y) : 0;
            return (cVar.z != null ? com.heytap.nearx.a.a.e.i.a(17, (int) cVar.z) : 0) + a15 + a14 + a3 + a2 + a4 + a5 + a6 + a7 + a8 + a9 + a10 + a11 + a12 + a13 + a16 + a17 + (cVar.A != null ? com.heytap.nearx.a.a.e.p.a(18, (int) cVar.A) : 0) + cVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, c cVar) throws IOException {
            if (cVar.j != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 1, cVar.j);
            }
            if (cVar.k != null) {
                g.f12042c.a(gVar, 2, cVar.k);
            }
            if (cVar.l != null) {
                ab.f12004c.a(gVar, 3, cVar.l);
            }
            if (cVar.m != null) {
                z.f12112c.a(gVar, 4, cVar.m);
            }
            if (cVar.n != null) {
                m.f12054c.a(gVar, 5, cVar.n);
            }
            if (cVar.o != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 6, cVar.o);
            }
            if (cVar.p != null) {
                w.f12080c.a(gVar, 7, cVar.p);
            }
            if (cVar.q != null) {
                u.f12076c.a(gVar, 8, cVar.q);
            }
            if (cVar.r != null) {
                com.heytap.nearx.a.a.e.f8653c.a(gVar, 9, cVar.r);
            }
            if (cVar.s != null) {
                ah.f12018c.a(gVar, 10, cVar.s);
            }
            if (cVar.t != null) {
                EnumC0505c.f12033c.a(gVar, 11, cVar.t);
            }
            if (cVar.u != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 12, cVar.u);
            }
            if (cVar.v != null) {
                ac.f12007c.a(gVar, 13, cVar.v);
            }
            e.f12038c.a().a(gVar, 14, cVar.w);
            if (cVar.x != null) {
                com.heytap.nearx.a.a.e.f8653c.a(gVar, 15, cVar.x);
            }
            if (cVar.y != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 16, cVar.y);
            }
            if (cVar.z != null) {
                com.heytap.nearx.a.a.e.i.a(gVar, 17, cVar.z);
            }
            if (cVar.A != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 18, cVar.A);
            }
            gVar.a(cVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public c a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.a(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 2:
                        aVar.a(g.f12042c.a(fVar));
                        break;
                    case 3:
                        aVar.a(ab.f12004c.a(fVar));
                        break;
                    case 4:
                        aVar.a(z.f12112c.a(fVar));
                        break;
                    case 5:
                        aVar.a(m.f12054c.a(fVar));
                        break;
                    case 6:
                        aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 7:
                        aVar.a(w.f12080c.a(fVar));
                        break;
                    case 8:
                        aVar.a(u.f12076c.a(fVar));
                        break;
                    case 9:
                        aVar.a(com.heytap.nearx.a.a.e.f8653c.a(fVar));
                        break;
                    case 10:
                        aVar.a(ah.f12018c.a(fVar));
                        break;
                    case 11:
                        aVar.a(EnumC0505c.f12033c.a(fVar));
                        break;
                    case 12:
                        aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 13:
                        try {
                            aVar.a(ac.f12007c.a(fVar));
                            break;
                        } catch (e.a e) {
                            aVar.a(b, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e.f8655a));
                            break;
                        }
                    case 14:
                        aVar.p.add(e.f12038c.a(fVar));
                        break;
                    case 15:
                        aVar.b(com.heytap.nearx.a.a.e.f8653c.a(fVar));
                        break;
                    case 16:
                        aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 17:
                        aVar.a(com.heytap.nearx.a.a.e.i.a(fVar));
                        break;
                    case 18:
                        aVar.d(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a c2 = fVar.c();
                        aVar.a(b, c2, c2.a().a(fVar));
                        break;
                }
            }
        }
    }

    /* renamed from: com.opos.mobad.b.a.c$c  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/c$c.class */
    public enum EnumC0505c implements com.heytap.nearx.a.a.i {
        SDK(0),
        QG(1);
        

        /* renamed from: c  reason: collision with root package name */
        public static final com.heytap.nearx.a.a.e<EnumC0505c> f12033c = com.heytap.nearx.a.a.e.a(EnumC0505c.class);
        private final int d;

        EnumC0505c(int i) {
            this.d = i;
        }

        public static EnumC0505c fromValue(int i) {
            if (i != 0) {
                if (i != 1) {
                    return null;
                }
                return QG;
            }
            return SDK;
        }

        @Override // com.heytap.nearx.a.a.i
        public int a() {
            return this.d;
        }
    }

    public c(Integer num, g gVar, ab abVar, z zVar, m mVar, String str, w wVar, u uVar, Boolean bool, ah ahVar, EnumC0505c enumC0505c, String str2, ac acVar, List<e> list, Boolean bool2, String str3, Long l, String str4, ByteString byteString) {
        super(f12030c, byteString);
        this.j = num;
        this.k = gVar;
        this.l = abVar;
        this.m = zVar;
        this.n = mVar;
        this.o = str;
        this.p = wVar;
        this.q = uVar;
        this.r = bool;
        this.s = ahVar;
        this.t = enumC0505c;
        this.u = str2;
        this.v = acVar;
        this.w = com.heytap.nearx.a.a.a.b.b("apkSigner", list);
        this.x = bool2;
        this.y = str3;
        this.z = l;
        this.A = str4;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.j != null) {
            sb.append(", apiVer=");
            sb.append(this.j);
        }
        if (this.k != null) {
            sb.append(", appInfo=");
            sb.append(this.k);
        }
        if (this.l != null) {
            sb.append(", sdkInfo=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", posInfo=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", devInfo=");
            sb.append(this.n);
        }
        if (this.o != null) {
            sb.append(", ext=");
            sb.append(this.o);
        }
        if (this.p != null) {
            sb.append(", marketInfo=");
            sb.append(this.p);
        }
        if (this.q != null) {
            sb.append(", instantInfo=");
            sb.append(this.q);
        }
        if (this.r != null) {
            sb.append(", ouIdOpenStatus=");
            sb.append(this.r);
        }
        if (this.s != null) {
            sb.append(", xgameInfo=");
            sb.append(this.s);
        }
        if (this.t != null) {
            sb.append(", scenes=");
            sb.append(this.t);
        }
        if (this.u != null) {
            sb.append(", clReqId=");
            sb.append(this.u);
        }
        if (this.v != null) {
            sb.append(", selfType=");
            sb.append(this.v);
        }
        if (!this.w.isEmpty()) {
            sb.append(", apkSigner=");
            sb.append(this.w);
        }
        if (this.x != null) {
            sb.append(", appOuidStatus=");
            sb.append(this.x);
        }
        if (this.y != null) {
            sb.append(", platformPkgName=");
            sb.append(this.y);
        }
        if (this.z != null) {
            sb.append(", strategyVersionCode=");
            sb.append(this.z);
        }
        if (this.A != null) {
            sb.append(", classifyByAge=");
            sb.append(this.A);
        }
        StringBuilder replace = sb.replace(0, 2, "AdRequest{");
        replace.append('}');
        return replace.toString();
    }
}
