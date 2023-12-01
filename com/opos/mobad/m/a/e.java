package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import com.heytap.nearx.a.a.e;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/e.class */
public final class e extends com.heytap.nearx.a.a.b<e, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<e> f26335c = new b();
    public static final c d = c.UNKNOWN;
    private static final long serialVersionUID = 0;
    public final c e;
    public final String f;
    public final String g;
    public final d h;
    public final d i;
    public final d j;
    public final d k;
    public final d l;
    public final d m;
    public final d n;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/e$a.class */
    public static final class a extends b.a<e, a> {

        /* renamed from: c  reason: collision with root package name */
        public c f26336c;
        public String d;
        public String e;
        public d f;
        public d g;
        public d h;
        public d i;
        public d j;
        public d k;
        public d l;

        public a a(c cVar) {
            this.f26336c = cVar;
            return this;
        }

        public a a(d dVar) {
            this.f = dVar;
            return this;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public a b(d dVar) {
            this.g = dVar;
            return this;
        }

        public a b(String str) {
            this.e = str;
            return this;
        }

        public e b() {
            String str;
            c cVar = this.f26336c;
            if (cVar == null || (str = this.d) == null) {
                throw com.heytap.nearx.a.a.a.b.a(this.f26336c, "channel", this.d, "appId");
            }
            return new e(cVar, str, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, super.a());
        }

        public a c(d dVar) {
            this.h = dVar;
            return this;
        }

        public a d(d dVar) {
            this.i = dVar;
            return this;
        }

        public a e(d dVar) {
            this.j = dVar;
            return this;
        }

        public a f(d dVar) {
            this.k = dVar;
            return this;
        }

        public a g(d dVar) {
            this.l = dVar;
            return this;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/e$b.class */
    static final class b extends com.heytap.nearx.a.a.e<e> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, e.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(e eVar) {
            int a2 = c.j.a(1, (int) eVar.e);
            int a3 = com.heytap.nearx.a.a.e.p.a(2, (int) eVar.f);
            int i = 0;
            int a4 = eVar.g != null ? com.heytap.nearx.a.a.e.p.a(3, (int) eVar.g) : 0;
            int a5 = eVar.h != null ? d.f26333c.a(4, (int) eVar.h) : 0;
            int a6 = eVar.i != null ? d.f26333c.a(5, (int) eVar.i) : 0;
            int a7 = eVar.j != null ? d.f26333c.a(6, (int) eVar.j) : 0;
            int a8 = eVar.k != null ? d.f26333c.a(7, (int) eVar.k) : 0;
            int a9 = eVar.l != null ? d.f26333c.a(8, (int) eVar.l) : 0;
            int a10 = eVar.m != null ? d.f26333c.a(9, (int) eVar.m) : 0;
            if (eVar.n != null) {
                i = d.f26333c.a(10, (int) eVar.n);
            }
            return a10 + a3 + a2 + a4 + a5 + a6 + a7 + a8 + a9 + i + eVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, e eVar) throws IOException {
            c.j.a(gVar, 1, eVar.e);
            com.heytap.nearx.a.a.e.p.a(gVar, 2, eVar.f);
            if (eVar.g != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, eVar.g);
            }
            if (eVar.h != null) {
                d.f26333c.a(gVar, 4, eVar.h);
            }
            if (eVar.i != null) {
                d.f26333c.a(gVar, 5, eVar.i);
            }
            if (eVar.j != null) {
                d.f26333c.a(gVar, 6, eVar.j);
            }
            if (eVar.k != null) {
                d.f26333c.a(gVar, 7, eVar.k);
            }
            if (eVar.l != null) {
                d.f26333c.a(gVar, 8, eVar.l);
            }
            if (eVar.m != null) {
                d.f26333c.a(gVar, 9, eVar.m);
            }
            if (eVar.n != null) {
                d.f26333c.a(gVar, 10, eVar.n);
            }
            gVar.a(eVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public e a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        try {
                            aVar.a(c.j.a(fVar));
                            break;
                        } catch (e.a e) {
                            aVar.a(b, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e.f22263a));
                            break;
                        }
                    case 2:
                        aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 3:
                        aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 4:
                        aVar.a(d.f26333c.a(fVar));
                        break;
                    case 5:
                        aVar.b(d.f26333c.a(fVar));
                        break;
                    case 6:
                        aVar.c(d.f26333c.a(fVar));
                        break;
                    case 7:
                        aVar.d(d.f26333c.a(fVar));
                        break;
                    case 8:
                        aVar.e(d.f26333c.a(fVar));
                        break;
                    case 9:
                        aVar.f(d.f26333c.a(fVar));
                        break;
                    case 10:
                        aVar.g(d.f26333c.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a c2 = fVar.c();
                        aVar.a(b, c2, c2.a().a(fVar));
                        break;
                }
            }
        }
    }

    public e(c cVar, String str, String str2, d dVar, d dVar2, d dVar3, d dVar4, d dVar5, d dVar6, d dVar7, ByteString byteString) {
        super(f26335c, byteString);
        this.e = cVar;
        this.f = str;
        this.g = str2;
        this.h = dVar;
        this.i = dVar2;
        this.j = dVar3;
        this.k = dVar4;
        this.l = dVar5;
        this.m = dVar6;
        this.n = dVar7;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", channel=");
        sb.append(this.e);
        sb.append(", appId=");
        sb.append(this.f);
        if (this.g != null) {
            sb.append(", logoUrl=");
            sb.append(this.g);
        }
        if (this.h != null) {
            sb.append(", bannerAdConfig=");
            sb.append(this.h);
        }
        if (this.i != null) {
            sb.append(", interstitialAdConfig=");
            sb.append(this.i);
        }
        if (this.j != null) {
            sb.append(", interstitialVideoAdConfig=");
            sb.append(this.j);
        }
        if (this.k != null) {
            sb.append(", rewardVideoAdConfig=");
            sb.append(this.k);
        }
        if (this.l != null) {
            sb.append(", nativeAdConfig=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", nativeTemplateAdConfig=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", splashAdConfig=");
            sb.append(this.n);
        }
        StringBuilder replace = sb.replace(0, 2, "ChannelInfo{");
        replace.append('}');
        return replace.toString();
    }
}
