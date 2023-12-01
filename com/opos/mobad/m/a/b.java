package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/b.class */
public final class b extends com.heytap.nearx.a.a.b<b, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<b> f12641c = new C0536b();
    public static final Boolean d = false;
    public static final Integer e = 3;
    public static final Boolean f = true;
    public static final Boolean g = true;
    private static final long serialVersionUID = 0;
    public final com.opos.mobad.m.a.a h;
    public final com.opos.mobad.m.a.a i;
    public final com.opos.mobad.m.a.a j;
    public final com.opos.mobad.m.a.a k;
    public final com.opos.mobad.m.a.a l;
    public final com.opos.mobad.m.a.a m;
    public final com.opos.mobad.m.a.a n;
    public final Boolean o;
    public final Integer p;
    public final Boolean q;
    public final Boolean r;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/b$a.class */
    public static final class a extends b.a<b, a> {

        /* renamed from: c  reason: collision with root package name */
        public com.opos.mobad.m.a.a f12642c;
        public com.opos.mobad.m.a.a d;
        public com.opos.mobad.m.a.a e;
        public com.opos.mobad.m.a.a f;
        public com.opos.mobad.m.a.a g;
        public com.opos.mobad.m.a.a h;
        public com.opos.mobad.m.a.a i;
        public Boolean j;
        public Integer k;
        public Boolean l;
        public Boolean m;

        public a a(com.opos.mobad.m.a.a aVar) {
            this.f12642c = aVar;
            return this;
        }

        public a a(Boolean bool) {
            this.j = bool;
            return this;
        }

        public a a(Integer num) {
            this.k = num;
            return this;
        }

        public a b(com.opos.mobad.m.a.a aVar) {
            this.d = aVar;
            return this;
        }

        public a b(Boolean bool) {
            this.l = bool;
            return this;
        }

        public b b() {
            return new b(this.f12642c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, super.a());
        }

        public a c(com.opos.mobad.m.a.a aVar) {
            this.e = aVar;
            return this;
        }

        public a c(Boolean bool) {
            this.m = bool;
            return this;
        }

        public a d(com.opos.mobad.m.a.a aVar) {
            this.f = aVar;
            return this;
        }

        public a e(com.opos.mobad.m.a.a aVar) {
            this.g = aVar;
            return this;
        }

        public a f(com.opos.mobad.m.a.a aVar) {
            this.h = aVar;
            return this;
        }

        public a g(com.opos.mobad.m.a.a aVar) {
            this.i = aVar;
            return this;
        }
    }

    /* renamed from: com.opos.mobad.m.a.b$b  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/b$b.class */
    static final class C0536b extends com.heytap.nearx.a.a.e<b> {
        C0536b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, b.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(b bVar) {
            int i = 0;
            int a2 = bVar.h != null ? com.opos.mobad.m.a.a.f12639c.a(1, (int) bVar.h) : 0;
            int a3 = bVar.i != null ? com.opos.mobad.m.a.a.f12639c.a(2, (int) bVar.i) : 0;
            int a4 = bVar.j != null ? com.opos.mobad.m.a.a.f12639c.a(3, (int) bVar.j) : 0;
            int a5 = bVar.k != null ? com.opos.mobad.m.a.a.f12639c.a(4, (int) bVar.k) : 0;
            int a6 = bVar.l != null ? com.opos.mobad.m.a.a.f12639c.a(5, (int) bVar.l) : 0;
            int a7 = bVar.m != null ? com.opos.mobad.m.a.a.f12639c.a(6, (int) bVar.m) : 0;
            int a8 = bVar.n != null ? com.opos.mobad.m.a.a.f12639c.a(7, (int) bVar.n) : 0;
            int a9 = bVar.o != null ? com.heytap.nearx.a.a.e.f8653c.a(8, (int) bVar.o) : 0;
            int a10 = bVar.p != null ? com.heytap.nearx.a.a.e.d.a(9, (int) bVar.p) : 0;
            int a11 = bVar.q != null ? com.heytap.nearx.a.a.e.f8653c.a(10, (int) bVar.q) : 0;
            if (bVar.r != null) {
                i = com.heytap.nearx.a.a.e.f8653c.a(11, (int) bVar.r);
            }
            return a11 + a3 + a2 + a4 + a5 + a6 + a7 + a8 + a9 + a10 + i + bVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, b bVar) throws IOException {
            if (bVar.h != null) {
                com.opos.mobad.m.a.a.f12639c.a(gVar, 1, bVar.h);
            }
            if (bVar.i != null) {
                com.opos.mobad.m.a.a.f12639c.a(gVar, 2, bVar.i);
            }
            if (bVar.j != null) {
                com.opos.mobad.m.a.a.f12639c.a(gVar, 3, bVar.j);
            }
            if (bVar.k != null) {
                com.opos.mobad.m.a.a.f12639c.a(gVar, 4, bVar.k);
            }
            if (bVar.l != null) {
                com.opos.mobad.m.a.a.f12639c.a(gVar, 5, bVar.l);
            }
            if (bVar.m != null) {
                com.opos.mobad.m.a.a.f12639c.a(gVar, 6, bVar.m);
            }
            if (bVar.n != null) {
                com.opos.mobad.m.a.a.f12639c.a(gVar, 7, bVar.n);
            }
            if (bVar.o != null) {
                com.heytap.nearx.a.a.e.f8653c.a(gVar, 8, bVar.o);
            }
            if (bVar.p != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 9, bVar.p);
            }
            if (bVar.q != null) {
                com.heytap.nearx.a.a.e.f8653c.a(gVar, 10, bVar.q);
            }
            if (bVar.r != null) {
                com.heytap.nearx.a.a.e.f8653c.a(gVar, 11, bVar.r);
            }
            gVar.a(bVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public b a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.a(com.opos.mobad.m.a.a.f12639c.a(fVar));
                        break;
                    case 2:
                        aVar.b(com.opos.mobad.m.a.a.f12639c.a(fVar));
                        break;
                    case 3:
                        aVar.c(com.opos.mobad.m.a.a.f12639c.a(fVar));
                        break;
                    case 4:
                        aVar.d(com.opos.mobad.m.a.a.f12639c.a(fVar));
                        break;
                    case 5:
                        aVar.e(com.opos.mobad.m.a.a.f12639c.a(fVar));
                        break;
                    case 6:
                        aVar.f(com.opos.mobad.m.a.a.f12639c.a(fVar));
                        break;
                    case 7:
                        aVar.g(com.opos.mobad.m.a.a.f12639c.a(fVar));
                        break;
                    case 8:
                        aVar.a(com.heytap.nearx.a.a.e.f8653c.a(fVar));
                        break;
                    case 9:
                        aVar.a(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 10:
                        aVar.b(com.heytap.nearx.a.a.e.f8653c.a(fVar));
                        break;
                    case 11:
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

    public b(com.opos.mobad.m.a.a aVar, com.opos.mobad.m.a.a aVar2, com.opos.mobad.m.a.a aVar3, com.opos.mobad.m.a.a aVar4, com.opos.mobad.m.a.a aVar5, com.opos.mobad.m.a.a aVar6, com.opos.mobad.m.a.a aVar7, Boolean bool, Integer num, Boolean bool2, Boolean bool3, ByteString byteString) {
        super(f12641c, byteString);
        this.h = aVar;
        this.i = aVar2;
        this.j = aVar3;
        this.k = aVar4;
        this.l = aVar5;
        this.m = aVar6;
        this.n = aVar7;
        this.o = bool;
        this.p = num;
        this.q = bool2;
        this.r = bool3;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.h != null) {
            sb.append(", interstitialAdConfig=");
            sb.append(this.h);
        }
        if (this.i != null) {
            sb.append(", interstitialVideoAdConfig=");
            sb.append(this.i);
        }
        if (this.j != null) {
            sb.append(", rewardVideoAdConfig=");
            sb.append(this.j);
        }
        if (this.k != null) {
            sb.append(", nativeAdConfig=");
            sb.append(this.k);
        }
        if (this.l != null) {
            sb.append(", nativeTemplateAdConfig=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", bannerAdConfig=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", splashAdConfig=");
            sb.append(this.n);
        }
        if (this.o != null) {
            sb.append(", deviceIdRequired=");
            sb.append(this.o);
        }
        if (this.p != null) {
            sb.append(", maxDownloadNums=");
            sb.append(this.p);
        }
        if (this.q != null) {
            sb.append(", isShowDownloadToastBar=");
            sb.append(this.q);
        }
        if (this.r != null) {
            sb.append(", isWifiRemindDownload=");
            sb.append(this.r);
        }
        StringBuilder replace = sb.replace(0, 2, "AppConfig{");
        replace.append('}');
        return replace.toString();
    }
}
