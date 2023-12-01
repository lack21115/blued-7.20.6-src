package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/m.class */
public final class m extends com.heytap.nearx.a.a.b<m, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<m> f25742c = new b();
    public static final Boolean d = false;
    private static final long serialVersionUID = 0;
    public final l e;
    public final n f;
    public final o g;
    public final p h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final Boolean n;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/m$a.class */
    public static final class a extends b.a<m, a> {

        /* renamed from: c  reason: collision with root package name */
        public l f25743c;
        public n d;
        public o e;
        public p f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public Boolean l;

        public a a(l lVar) {
            this.f25743c = lVar;
            return this;
        }

        public a a(n nVar) {
            this.d = nVar;
            return this;
        }

        public a a(o oVar) {
            this.e = oVar;
            return this;
        }

        public a a(p pVar) {
            this.f = pVar;
            return this;
        }

        public a a(Boolean bool) {
            this.l = bool;
            return this;
        }

        public a a(String str) {
            this.g = str;
            return this;
        }

        public a b(String str) {
            this.h = str;
            return this;
        }

        public m b() {
            return new m(this.f25743c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, super.a());
        }

        public a c(String str) {
            this.i = str;
            return this;
        }

        public a d(String str) {
            this.j = str;
            return this;
        }

        public a e(String str) {
            this.k = str;
            return this;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/m$b.class */
    static final class b extends com.heytap.nearx.a.a.e<m> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, m.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(m mVar) {
            int i = 0;
            int a2 = mVar.e != null ? l.f25740c.a(1, (int) mVar.e) : 0;
            int a3 = mVar.f != null ? n.f25744c.a(2, (int) mVar.f) : 0;
            int a4 = mVar.g != null ? o.f25746c.a(3, (int) mVar.g) : 0;
            int a5 = mVar.h != null ? p.f25748c.a(4, (int) mVar.h) : 0;
            int a6 = mVar.i != null ? com.heytap.nearx.a.a.e.p.a(5, (int) mVar.i) : 0;
            int a7 = mVar.j != null ? com.heytap.nearx.a.a.e.p.a(6, (int) mVar.j) : 0;
            int a8 = mVar.k != null ? com.heytap.nearx.a.a.e.p.a(7, (int) mVar.k) : 0;
            int a9 = mVar.l != null ? com.heytap.nearx.a.a.e.p.a(8, (int) mVar.l) : 0;
            int a10 = mVar.m != null ? com.heytap.nearx.a.a.e.p.a(9, (int) mVar.m) : 0;
            if (mVar.n != null) {
                i = com.heytap.nearx.a.a.e.f22261c.a(10, (int) mVar.n);
            }
            return a10 + a3 + a2 + a4 + a5 + a6 + a7 + a8 + a9 + i + mVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, m mVar) throws IOException {
            if (mVar.e != null) {
                l.f25740c.a(gVar, 1, mVar.e);
            }
            if (mVar.f != null) {
                n.f25744c.a(gVar, 2, mVar.f);
            }
            if (mVar.g != null) {
                o.f25746c.a(gVar, 3, mVar.g);
            }
            if (mVar.h != null) {
                p.f25748c.a(gVar, 4, mVar.h);
            }
            if (mVar.i != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 5, mVar.i);
            }
            if (mVar.j != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 6, mVar.j);
            }
            if (mVar.k != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 7, mVar.k);
            }
            if (mVar.l != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 8, mVar.l);
            }
            if (mVar.m != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 9, mVar.m);
            }
            if (mVar.n != null) {
                com.heytap.nearx.a.a.e.f22261c.a(gVar, 10, mVar.n);
            }
            gVar.a(mVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public m a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.a(l.f25740c.a(fVar));
                        break;
                    case 2:
                        aVar.a(n.f25744c.a(fVar));
                        break;
                    case 3:
                        aVar.a(o.f25746c.a(fVar));
                        break;
                    case 4:
                        aVar.a(p.f25748c.a(fVar));
                        break;
                    case 5:
                        aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 6:
                        aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 7:
                        aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 8:
                        aVar.d(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 9:
                        aVar.e(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 10:
                        aVar.a(com.heytap.nearx.a.a.e.f22261c.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a c2 = fVar.c();
                        aVar.a(b, c2, c2.a().a(fVar));
                        break;
                }
            }
        }
    }

    public m(l lVar, n nVar, o oVar, p pVar, String str, String str2, String str3, String str4, String str5, Boolean bool, ByteString byteString) {
        super(f25742c, byteString);
        this.e = lVar;
        this.f = nVar;
        this.g = oVar;
        this.h = pVar;
        this.i = str;
        this.j = str2;
        this.k = str3;
        this.l = str4;
        this.m = str5;
        this.n = bool;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.e != null) {
            sb.append(", devId=");
            sb.append(this.e);
        }
        if (this.f != null) {
            sb.append(", devOs=");
            sb.append(this.f);
        }
        if (this.g != null) {
            sb.append(", devScreen=");
            sb.append(this.g);
        }
        if (this.h != null) {
            sb.append(", devStatus=");
            sb.append(this.h);
        }
        if (this.i != null) {
            sb.append(", model=");
            sb.append(this.i);
        }
        if (this.j != null) {
            sb.append(", ua=");
            sb.append(this.j);
        }
        if (this.k != null) {
            sb.append(", brand=");
            sb.append(this.k);
        }
        if (this.l != null) {
            sb.append(", bootMark=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", updateMark=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", touristMode=");
            sb.append(this.n);
        }
        StringBuilder replace = sb.replace(0, 2, "DevInfo{");
        replace.append('}');
        return replace.toString();
    }
}
