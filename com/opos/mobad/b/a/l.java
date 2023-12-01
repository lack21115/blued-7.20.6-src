package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/l.class */
public final class l extends com.heytap.nearx.a.a.b<l, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<l> f12052c = new b();
    private static final long serialVersionUID = 0;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/l$a.class */
    public static final class a extends b.a<l, a> {

        /* renamed from: c  reason: collision with root package name */
        public String f12053c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;

        public a a(String str) {
            this.f12053c = str;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public l b() {
            return new l(this.f12053c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, super.a());
        }

        public a c(String str) {
            this.e = str;
            return this;
        }

        public a d(String str) {
            this.f = str;
            return this;
        }

        public a e(String str) {
            this.g = str;
            return this;
        }

        public a f(String str) {
            this.h = str;
            return this;
        }

        public a g(String str) {
            this.i = str;
            return this;
        }

        public a h(String str) {
            this.j = str;
            return this;
        }

        public a i(String str) {
            this.k = str;
            return this;
        }

        public a j(String str) {
            this.l = str;
            return this;
        }

        public a k(String str) {
            this.m = str;
            return this;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/l$b.class */
    static final class b extends com.heytap.nearx.a.a.e<l> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, l.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(l lVar) {
            int i = 0;
            int a2 = lVar.d != null ? com.heytap.nearx.a.a.e.p.a(1, (int) lVar.d) : 0;
            int a3 = lVar.e != null ? com.heytap.nearx.a.a.e.p.a(2, (int) lVar.e) : 0;
            int a4 = lVar.f != null ? com.heytap.nearx.a.a.e.p.a(3, (int) lVar.f) : 0;
            int a5 = lVar.g != null ? com.heytap.nearx.a.a.e.p.a(4, (int) lVar.g) : 0;
            int a6 = lVar.h != null ? com.heytap.nearx.a.a.e.p.a(5, (int) lVar.h) : 0;
            int a7 = lVar.i != null ? com.heytap.nearx.a.a.e.p.a(6, (int) lVar.i) : 0;
            int a8 = lVar.j != null ? com.heytap.nearx.a.a.e.p.a(7, (int) lVar.j) : 0;
            int a9 = lVar.k != null ? com.heytap.nearx.a.a.e.p.a(8, (int) lVar.k) : 0;
            int a10 = lVar.l != null ? com.heytap.nearx.a.a.e.p.a(9, (int) lVar.l) : 0;
            int a11 = lVar.m != null ? com.heytap.nearx.a.a.e.p.a(10, (int) lVar.m) : 0;
            if (lVar.n != null) {
                i = com.heytap.nearx.a.a.e.p.a(11, (int) lVar.n);
            }
            return a11 + a3 + a2 + a4 + a5 + a6 + a7 + a8 + a9 + a10 + i + lVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, l lVar) throws IOException {
            if (lVar.d != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, lVar.d);
            }
            if (lVar.e != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, lVar.e);
            }
            if (lVar.f != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, lVar.f);
            }
            if (lVar.g != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 4, lVar.g);
            }
            if (lVar.h != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 5, lVar.h);
            }
            if (lVar.i != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 6, lVar.i);
            }
            if (lVar.j != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 7, lVar.j);
            }
            if (lVar.k != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 8, lVar.k);
            }
            if (lVar.l != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 9, lVar.l);
            }
            if (lVar.m != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 10, lVar.m);
            }
            if (lVar.n != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 11, lVar.n);
            }
            gVar.a(lVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public l a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 4:
                        aVar.d(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 5:
                        aVar.e(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 6:
                        aVar.f(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 7:
                        aVar.g(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 8:
                        aVar.h(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 9:
                        aVar.i(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 10:
                        aVar.j(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 11:
                        aVar.k(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a c2 = fVar.c();
                        aVar.a(b, c2, c2.a().a(fVar));
                        break;
                }
            }
        }
    }

    public l(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, ByteString byteString) {
        super(f12052c, byteString);
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = str5;
        this.i = str6;
        this.j = str7;
        this.k = str8;
        this.l = str9;
        this.m = str10;
        this.n = str11;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.d != null) {
            sb.append(", imei=");
            sb.append(this.d);
        }
        if (this.e != null) {
            sb.append(", anId=");
            sb.append(this.e);
        }
        if (this.f != null) {
            sb.append(", mac=");
            sb.append(this.f);
        }
        if (this.g != null) {
            sb.append(", oaId=");
            sb.append(this.g);
        }
        if (this.h != null) {
            sb.append(", vaId=");
            sb.append(this.h);
        }
        if (this.i != null) {
            sb.append(", udId=");
            sb.append(this.i);
        }
        if (this.j != null) {
            sb.append(", ouId=");
            sb.append(this.j);
        }
        if (this.k != null) {
            sb.append(", duId=");
            sb.append(this.k);
        }
        if (this.l != null) {
            sb.append(", guId=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", mkDuId=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", serialId=");
            sb.append(this.n);
        }
        StringBuilder replace = sb.replace(0, 2, "DevId{");
        replace.append('}');
        return replace.toString();
    }
}
