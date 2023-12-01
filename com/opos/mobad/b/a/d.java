package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import com.heytap.nearx.a.a.e;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/d.class */
public final class d extends com.heytap.nearx.a.a.b<d, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<d> f12034c = new c();
    public static final Integer d = 0;
    public static final Long e = 0L;
    public static final Integer f = 0;
    public static final Integer g = 0;
    public static final Integer h = 0;
    public static final b i = b.NO_TYPE;
    public static final Integer j = 0;
    public static final Boolean k = false;
    public static final Integer l = 1;
    public static final Boolean m = false;
    public static final Integer n = 0;
    public static final Integer o = 0;
    private static final long serialVersionUID = 0;
    public final Integer A;
    public final Boolean B;
    public final Integer C;
    public final Boolean D;
    public final Integer E;
    public final Integer F;
    public final String G;
    public final String H;
    public final Integer p;
    public final String q;
    public final String r;
    public final List<com.opos.mobad.b.a.b> s;
    public final Long t;
    public final String u;
    public final t v;
    public final Integer w;
    public final Integer x;
    public final Integer y;
    public final b z;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/d$a.class */
    public static final class a extends b.a<d, a> {

        /* renamed from: c  reason: collision with root package name */
        public Integer f12035c;
        public String d;
        public String e;
        public List<com.opos.mobad.b.a.b> f = com.heytap.nearx.a.a.a.b.a();
        public Long g;
        public String h;
        public t i;
        public Integer j;
        public Integer k;
        public Integer l;
        public b m;
        public Integer n;
        public Boolean o;
        public Integer p;
        public Boolean q;
        public Integer r;
        public Integer s;
        public String t;
        public String u;

        public a a(b bVar) {
            this.m = bVar;
            return this;
        }

        public a a(t tVar) {
            this.i = tVar;
            return this;
        }

        public a a(Boolean bool) {
            this.o = bool;
            return this;
        }

        public a a(Integer num) {
            this.f12035c = num;
            return this;
        }

        public a a(Long l) {
            this.g = l;
            return this;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public a b(Boolean bool) {
            this.q = bool;
            return this;
        }

        public a b(Integer num) {
            this.j = num;
            return this;
        }

        public a b(String str) {
            this.e = str;
            return this;
        }

        public d b() {
            return new d(this.f12035c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, super.a());
        }

        public a c(Integer num) {
            this.k = num;
            return this;
        }

        public a c(String str) {
            this.h = str;
            return this;
        }

        public a d(Integer num) {
            this.l = num;
            return this;
        }

        public a d(String str) {
            this.t = str;
            return this;
        }

        public a e(Integer num) {
            this.n = num;
            return this;
        }

        public a e(String str) {
            this.u = str;
            return this;
        }

        public a f(Integer num) {
            this.p = num;
            return this;
        }

        public a g(Integer num) {
            this.r = num;
            return this;
        }

        public a h(Integer num) {
            this.s = num;
            return this;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/d$b.class */
    public enum b implements com.heytap.nearx.a.a.i {
        NO_TYPE(0),
        GAME_BOX_BANNER(1),
        GAME_BOX_INTERSTITIAL(2);
        
        public static final com.heytap.nearx.a.a.e<b> d = com.heytap.nearx.a.a.e.a(b.class);
        private final int e;

        b(int i) {
            this.e = i;
        }

        public static b fromValue(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return GAME_BOX_INTERSTITIAL;
                }
                return GAME_BOX_BANNER;
            }
            return NO_TYPE;
        }

        @Override // com.heytap.nearx.a.a.i
        public int a() {
            return this.e;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/d$c.class */
    static final class c extends com.heytap.nearx.a.a.e<d> {
        c() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, d.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(d dVar) {
            int a2 = dVar.p != null ? com.heytap.nearx.a.a.e.d.a(1, (int) dVar.p) : 0;
            int a3 = dVar.q != null ? com.heytap.nearx.a.a.e.p.a(2, (int) dVar.q) : 0;
            int a4 = dVar.r != null ? com.heytap.nearx.a.a.e.p.a(3, (int) dVar.r) : 0;
            int a5 = com.opos.mobad.b.a.b.f12020c.a().a(4, (int) dVar.s);
            int a6 = dVar.t != null ? com.heytap.nearx.a.a.e.i.a(5, (int) dVar.t) : 0;
            int a7 = dVar.u != null ? com.heytap.nearx.a.a.e.p.a(6, (int) dVar.u) : 0;
            int a8 = dVar.v != null ? t.f12074c.a(7, (int) dVar.v) : 0;
            int a9 = dVar.w != null ? com.heytap.nearx.a.a.e.d.a(8, (int) dVar.w) : 0;
            int a10 = dVar.x != null ? com.heytap.nearx.a.a.e.d.a(9, (int) dVar.x) : 0;
            int a11 = dVar.y != null ? com.heytap.nearx.a.a.e.d.a(10, (int) dVar.y) : 0;
            int a12 = dVar.z != null ? b.d.a(11, (int) dVar.z) : 0;
            int a13 = dVar.A != null ? com.heytap.nearx.a.a.e.d.a(12, (int) dVar.A) : 0;
            int a14 = dVar.B != null ? com.heytap.nearx.a.a.e.f8653c.a(13, (int) dVar.B) : 0;
            int a15 = dVar.C != null ? com.heytap.nearx.a.a.e.d.a(14, (int) dVar.C) : 0;
            int a16 = dVar.D != null ? com.heytap.nearx.a.a.e.f8653c.a(15, (int) dVar.D) : 0;
            int a17 = dVar.E != null ? com.heytap.nearx.a.a.e.d.a(16, (int) dVar.E) : 0;
            int a18 = dVar.F != null ? com.heytap.nearx.a.a.e.d.a(17, (int) dVar.F) : 0;
            return (dVar.G != null ? com.heytap.nearx.a.a.e.p.a(18, (int) dVar.G) : 0) + a5 + a4 + a3 + a2 + a6 + a7 + a8 + a9 + a10 + a11 + a12 + a13 + a14 + a15 + a16 + a17 + a18 + (dVar.H != null ? com.heytap.nearx.a.a.e.p.a(19, (int) dVar.H) : 0) + dVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, d dVar) throws IOException {
            if (dVar.p != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 1, dVar.p);
            }
            if (dVar.q != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, dVar.q);
            }
            if (dVar.r != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, dVar.r);
            }
            com.opos.mobad.b.a.b.f12020c.a().a(gVar, 4, dVar.s);
            if (dVar.t != null) {
                com.heytap.nearx.a.a.e.i.a(gVar, 5, dVar.t);
            }
            if (dVar.u != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 6, dVar.u);
            }
            if (dVar.v != null) {
                t.f12074c.a(gVar, 7, dVar.v);
            }
            if (dVar.w != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 8, dVar.w);
            }
            if (dVar.x != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 9, dVar.x);
            }
            if (dVar.y != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 10, dVar.y);
            }
            if (dVar.z != null) {
                b.d.a(gVar, 11, dVar.z);
            }
            if (dVar.A != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 12, dVar.A);
            }
            if (dVar.B != null) {
                com.heytap.nearx.a.a.e.f8653c.a(gVar, 13, dVar.B);
            }
            if (dVar.C != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 14, dVar.C);
            }
            if (dVar.D != null) {
                com.heytap.nearx.a.a.e.f8653c.a(gVar, 15, dVar.D);
            }
            if (dVar.E != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 16, dVar.E);
            }
            if (dVar.F != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 17, dVar.F);
            }
            if (dVar.G != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 18, dVar.G);
            }
            if (dVar.H != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 19, dVar.H);
            }
            gVar.a(dVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public d a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 3:
                        aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 4:
                        aVar.f.add(com.opos.mobad.b.a.b.f12020c.a(fVar));
                        break;
                    case 5:
                        aVar.a(com.heytap.nearx.a.a.e.i.a(fVar));
                        break;
                    case 6:
                        aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 7:
                        aVar.a(t.f12074c.a(fVar));
                        break;
                    case 8:
                        aVar.b(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 9:
                        aVar.c(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 10:
                        aVar.d(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 11:
                        try {
                            aVar.a(b.d.a(fVar));
                            break;
                        } catch (e.a e) {
                            aVar.a(b, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e.f8655a));
                            break;
                        }
                    case 12:
                        aVar.e(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 13:
                        aVar.a(com.heytap.nearx.a.a.e.f8653c.a(fVar));
                        break;
                    case 14:
                        aVar.f(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 15:
                        aVar.b(com.heytap.nearx.a.a.e.f8653c.a(fVar));
                        break;
                    case 16:
                        aVar.g(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 17:
                        aVar.h(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 18:
                        aVar.d(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 19:
                        aVar.e(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a c2 = fVar.c();
                        aVar.a(b, c2, c2.a().a(fVar));
                        break;
                }
            }
        }
    }

    public d(Integer num, String str, String str2, List<com.opos.mobad.b.a.b> list, Long l2, String str3, t tVar, Integer num2, Integer num3, Integer num4, b bVar, Integer num5, Boolean bool, Integer num6, Boolean bool2, Integer num7, Integer num8, String str4, String str5, ByteString byteString) {
        super(f12034c, byteString);
        this.p = num;
        this.q = str;
        this.r = str2;
        this.s = com.heytap.nearx.a.a.a.b.b("adList", list);
        this.t = l2;
        this.u = str3;
        this.v = tVar;
        this.w = num2;
        this.x = num3;
        this.y = num4;
        this.z = bVar;
        this.A = num5;
        this.B = bool;
        this.C = num6;
        this.D = bool2;
        this.E = num7;
        this.F = num8;
        this.G = str4;
        this.H = str5;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.p != null) {
            sb.append(", code=");
            sb.append(this.p);
        }
        if (this.q != null) {
            sb.append(", msg=");
            sb.append(this.q);
        }
        if (this.r != null) {
            sb.append(", adSource=");
            sb.append(this.r);
        }
        if (!this.s.isEmpty()) {
            sb.append(", adList=");
            sb.append(this.s);
        }
        if (this.t != null) {
            sb.append(", expTime=");
            sb.append(this.t);
        }
        if (this.u != null) {
            sb.append(", respId=");
            sb.append(this.u);
        }
        if (this.v != null) {
            sb.append(", instantIds=");
            sb.append(this.v);
        }
        if (this.w != null) {
            sb.append(", reqInterval=");
            sb.append(this.w);
        }
        if (this.x != null) {
            sb.append(", dispatch=");
            sb.append(this.x);
        }
        if (this.y != null) {
            sb.append(", validTime=");
            sb.append(this.y);
        }
        if (this.z != null) {
            sb.append(", gameBoxType=");
            sb.append(this.z);
        }
        if (this.A != null) {
            sb.append(", cacheAdNum=");
            sb.append(this.A);
        }
        if (this.B != null) {
            sb.append(", customSkip=");
            sb.append(this.B);
        }
        if (this.C != null) {
            sb.append(", limitNum=");
            sb.append(this.C);
        }
        if (this.D != null) {
            sb.append(", recordShowEvent=");
            sb.append(this.D);
        }
        if (this.E != null) {
            sb.append(", cmType=");
            sb.append(this.E);
        }
        if (this.F != null) {
            sb.append(", strategyState=");
            sb.append(this.F);
        }
        if (this.G != null) {
            sb.append(", customInfo=");
            sb.append(this.G);
        }
        if (this.H != null) {
            sb.append(", miniProgramAppId=");
            sb.append(this.H);
        }
        StringBuilder replace = sb.replace(0, 2, "AdResponse{");
        replace.append('}');
        return replace.toString();
    }
}
