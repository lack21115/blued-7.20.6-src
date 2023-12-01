package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/j.class */
public final class j extends com.heytap.nearx.a.a.b<j, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<j> f25736c = new b();
    public static final Integer d = 0;
    public static final Boolean e = false;
    public static final Boolean f = false;
    public static final Boolean g = false;
    public static final Boolean h = false;
    public static final Boolean i = false;
    public static final Boolean j = false;
    public static final Boolean k = false;
    private static final long serialVersionUID = 0;
    public final Integer l;
    public final String m;
    public final Boolean n;
    public final Boolean o;
    public final Boolean p;
    public final Boolean q;
    public final Boolean r;
    public final Boolean s;
    public final Boolean t;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/j$a.class */
    public static final class a extends b.a<j, a> {

        /* renamed from: c  reason: collision with root package name */
        public Integer f25737c;
        public String d;
        public Boolean e;
        public Boolean f;
        public Boolean g;
        public Boolean h;
        public Boolean i;
        public Boolean j;
        public Boolean k;

        public a a(Boolean bool) {
            this.e = bool;
            return this;
        }

        public a a(Integer num) {
            this.f25737c = num;
            return this;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public a b(Boolean bool) {
            this.f = bool;
            return this;
        }

        public j b() {
            Integer num = this.f25737c;
            if (num != null) {
                return new j(num, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, super.a());
            }
            throw com.heytap.nearx.a.a.a.b.a(num, "code");
        }

        public a c(Boolean bool) {
            this.g = bool;
            return this;
        }

        public a d(Boolean bool) {
            this.h = bool;
            return this;
        }

        public a e(Boolean bool) {
            this.i = bool;
            return this;
        }

        public a f(Boolean bool) {
            this.j = bool;
            return this;
        }

        public a g(Boolean bool) {
            this.k = bool;
            return this;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/j$b.class */
    static final class b extends com.heytap.nearx.a.a.e<j> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, j.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(j jVar) {
            int a2 = com.heytap.nearx.a.a.e.d.a(1, (int) jVar.l);
            int i = 0;
            int a3 = jVar.m != null ? com.heytap.nearx.a.a.e.p.a(2, (int) jVar.m) : 0;
            int a4 = jVar.n != null ? com.heytap.nearx.a.a.e.f22261c.a(3, (int) jVar.n) : 0;
            int a5 = jVar.o != null ? com.heytap.nearx.a.a.e.f22261c.a(4, (int) jVar.o) : 0;
            int a6 = jVar.p != null ? com.heytap.nearx.a.a.e.f22261c.a(5, (int) jVar.p) : 0;
            int a7 = jVar.q != null ? com.heytap.nearx.a.a.e.f22261c.a(6, (int) jVar.q) : 0;
            int a8 = jVar.r != null ? com.heytap.nearx.a.a.e.f22261c.a(7, (int) jVar.r) : 0;
            int a9 = jVar.s != null ? com.heytap.nearx.a.a.e.f22261c.a(8, (int) jVar.s) : 0;
            if (jVar.t != null) {
                i = com.heytap.nearx.a.a.e.f22261c.a(9, (int) jVar.t);
            }
            return a9 + a2 + a3 + a4 + a5 + a6 + a7 + a8 + i + jVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, j jVar) throws IOException {
            com.heytap.nearx.a.a.e.d.a(gVar, 1, jVar.l);
            if (jVar.m != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, jVar.m);
            }
            if (jVar.n != null) {
                com.heytap.nearx.a.a.e.f22261c.a(gVar, 3, jVar.n);
            }
            if (jVar.o != null) {
                com.heytap.nearx.a.a.e.f22261c.a(gVar, 4, jVar.o);
            }
            if (jVar.p != null) {
                com.heytap.nearx.a.a.e.f22261c.a(gVar, 5, jVar.p);
            }
            if (jVar.q != null) {
                com.heytap.nearx.a.a.e.f22261c.a(gVar, 6, jVar.q);
            }
            if (jVar.r != null) {
                com.heytap.nearx.a.a.e.f22261c.a(gVar, 7, jVar.r);
            }
            if (jVar.s != null) {
                com.heytap.nearx.a.a.e.f22261c.a(gVar, 8, jVar.s);
            }
            if (jVar.t != null) {
                com.heytap.nearx.a.a.e.f22261c.a(gVar, 9, jVar.t);
            }
            gVar.a(jVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public j a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.a(com.heytap.nearx.a.a.e.f22261c.a(fVar));
                        break;
                    case 4:
                        aVar.b(com.heytap.nearx.a.a.e.f22261c.a(fVar));
                        break;
                    case 5:
                        aVar.c(com.heytap.nearx.a.a.e.f22261c.a(fVar));
                        break;
                    case 6:
                        aVar.d(com.heytap.nearx.a.a.e.f22261c.a(fVar));
                        break;
                    case 7:
                        aVar.e(com.heytap.nearx.a.a.e.f22261c.a(fVar));
                        break;
                    case 8:
                        aVar.f(com.heytap.nearx.a.a.e.f22261c.a(fVar));
                        break;
                    case 9:
                        aVar.g(com.heytap.nearx.a.a.e.f22261c.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a c2 = fVar.c();
                        aVar.a(b, c2, c2.a().a(fVar));
                        break;
                }
            }
        }
    }

    public j(Integer num, String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, ByteString byteString) {
        super(f25736c, byteString);
        this.l = num;
        this.m = str;
        this.n = bool;
        this.o = bool2;
        this.p = bool3;
        this.q = bool4;
        this.r = bool5;
        this.s = bool6;
        this.t = bool7;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", code=");
        sb.append(this.l);
        if (this.m != null) {
            sb.append(", msg=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", ttAdAllowed=");
            sb.append(this.n);
        }
        if (this.o != null) {
            sb.append(", gdtAdAllowed=");
            sb.append(this.o);
        }
        if (this.p != null) {
            sb.append(", cacheAdAllowed=");
            sb.append(this.p);
        }
        if (this.q != null) {
            sb.append(", ggAdAllowed=");
            sb.append(this.q);
        }
        if (this.r != null) {
            sb.append(", fbAdAllowed=");
            sb.append(this.r);
        }
        if (this.s != null) {
            sb.append(", quicEnable=");
            sb.append(this.s);
        }
        if (this.t != null) {
            sb.append(", jdAdAllowed=");
            sb.append(this.t);
        }
        StringBuilder replace = sb.replace(0, 2, "ControlResponse{");
        replace.append('}');
        return replace.toString();
    }
}
