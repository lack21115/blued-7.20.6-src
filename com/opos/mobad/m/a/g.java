package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/g.class */
public final class g extends com.heytap.nearx.a.a.b<g, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<g> f12651c = new b();
    public static final Boolean d = true;
    public static final Boolean e = true;
    private static final long serialVersionUID = 0;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final Boolean l;
    public final Boolean m;
    public final String n;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/g$a.class */
    public static final class a extends b.a<g, a> {

        /* renamed from: c  reason: collision with root package name */
        public String f12652c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public Boolean i;
        public Boolean j;
        public String k;

        public a a(Boolean bool) {
            this.i = bool;
            return this;
        }

        public a a(String str) {
            this.f12652c = str;
            return this;
        }

        public a b(Boolean bool) {
            this.j = bool;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public g b() {
            return new g(this.f12652c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, super.a());
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
            this.k = str;
            return this;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/g$b.class */
    static final class b extends com.heytap.nearx.a.a.e<g> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, g.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(g gVar) {
            int i = 0;
            int a2 = gVar.f != null ? com.heytap.nearx.a.a.e.p.a(1, (int) gVar.f) : 0;
            int a3 = gVar.g != null ? com.heytap.nearx.a.a.e.p.a(2, (int) gVar.g) : 0;
            int a4 = gVar.h != null ? com.heytap.nearx.a.a.e.p.a(3, (int) gVar.h) : 0;
            int a5 = gVar.i != null ? com.heytap.nearx.a.a.e.p.a(4, (int) gVar.i) : 0;
            int a6 = gVar.j != null ? com.heytap.nearx.a.a.e.p.a(5, (int) gVar.j) : 0;
            int a7 = gVar.k != null ? com.heytap.nearx.a.a.e.p.a(6, (int) gVar.k) : 0;
            int a8 = gVar.l != null ? com.heytap.nearx.a.a.e.f8653c.a(7, (int) gVar.l) : 0;
            int a9 = gVar.m != null ? com.heytap.nearx.a.a.e.f8653c.a(8, (int) gVar.m) : 0;
            if (gVar.n != null) {
                i = com.heytap.nearx.a.a.e.p.a(9, (int) gVar.n);
            }
            return a9 + a3 + a2 + a4 + a5 + a6 + a7 + a8 + i + gVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, g gVar2) throws IOException {
            if (gVar2.f != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, gVar2.f);
            }
            if (gVar2.g != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, gVar2.g);
            }
            if (gVar2.h != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, gVar2.h);
            }
            if (gVar2.i != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 4, gVar2.i);
            }
            if (gVar2.j != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 5, gVar2.j);
            }
            if (gVar2.k != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 6, gVar2.k);
            }
            if (gVar2.l != null) {
                com.heytap.nearx.a.a.e.f8653c.a(gVar, 7, gVar2.l);
            }
            if (gVar2.m != null) {
                com.heytap.nearx.a.a.e.f8653c.a(gVar, 8, gVar2.m);
            }
            if (gVar2.n != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 9, gVar2.n);
            }
            gVar.a(gVar2.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public g a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.a(com.heytap.nearx.a.a.e.f8653c.a(fVar));
                        break;
                    case 8:
                        aVar.b(com.heytap.nearx.a.a.e.f8653c.a(fVar));
                        break;
                    case 9:
                        aVar.g(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a c2 = fVar.c();
                        aVar.a(b, c2, c2.a().a(fVar));
                        break;
                }
            }
        }
    }

    public g(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, Boolean bool2, String str7, ByteString byteString) {
        super(f12651c, byteString);
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.i = str4;
        this.j = str5;
        this.k = str6;
        this.l = bool;
        this.m = bool2;
        this.n = str7;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f != null) {
            sb.append(", imei=");
            sb.append(this.f);
        }
        if (this.g != null) {
            sb.append(", anId=");
            sb.append(this.g);
        }
        if (this.h != null) {
            sb.append(", mac=");
            sb.append(this.h);
        }
        if (this.i != null) {
            sb.append(", ouId=");
            sb.append(this.i);
        }
        if (this.j != null) {
            sb.append(", duId=");
            sb.append(this.j);
        }
        if (this.k != null) {
            sb.append(", guId=");
            sb.append(this.k);
        }
        if (this.l != null) {
            sb.append(", ouIdOpenStatus=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", appOuidStatus=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", gaId=");
            sb.append(this.n);
        }
        StringBuilder replace = sb.replace(0, 2, "DevId{");
        replace.append('}');
        return replace.toString();
    }
}
