package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/ae.class */
public final class ae extends com.heytap.nearx.a.a.b<ae, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<ae> f12010c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    private static final long serialVersionUID = 0;
    public final String f;
    public final String g;
    public final Integer h;
    public final Integer i;
    public final String j;
    public final String k;
    public final m l;
    public final w m;
    public final u n;
    public final ah o;
    public final v p;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/ae$a.class */
    public static final class a extends b.a<ae, a> {

        /* renamed from: c  reason: collision with root package name */
        public String f12011c;
        public String d;
        public Integer e;
        public Integer f;
        public String g;
        public String h;
        public m i;
        public w j;
        public u k;
        public ah l;
        public v m;

        public a a(ah ahVar) {
            this.l = ahVar;
            return this;
        }

        public a a(m mVar) {
            this.i = mVar;
            return this;
        }

        public a a(u uVar) {
            this.k = uVar;
            return this;
        }

        public a a(v vVar) {
            this.m = vVar;
            return this;
        }

        public a a(w wVar) {
            this.j = wVar;
            return this;
        }

        public a a(Integer num) {
            this.e = num;
            return this;
        }

        public a a(String str) {
            this.f12011c = str;
            return this;
        }

        public a b(Integer num) {
            this.f = num;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public ae b() {
            String str;
            Integer num;
            Integer num2;
            String str2;
            String str3 = this.f12011c;
            if (str3 == null || (str = this.d) == null || (num = this.e) == null || (num2 = this.f) == null || (str2 = this.g) == null) {
                throw com.heytap.nearx.a.a.a.b.a(this.f12011c, "appId", this.d, "packageName", this.e, "platform", this.f, "sdkVerCode", this.g, "posId");
            }
            return new ae(str3, str, num, num2, str2, this.h, this.i, this.j, this.k, this.l, this.m, super.a());
        }

        public a c(String str) {
            this.g = str;
            return this;
        }

        public a d(String str) {
            this.h = str;
            return this;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/ae$b.class */
    static final class b extends com.heytap.nearx.a.a.e<ae> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, ae.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(ae aeVar) {
            int a2 = com.heytap.nearx.a.a.e.p.a(1, (int) aeVar.f);
            int a3 = com.heytap.nearx.a.a.e.p.a(2, (int) aeVar.g);
            int a4 = com.heytap.nearx.a.a.e.d.a(3, (int) aeVar.h);
            int a5 = com.heytap.nearx.a.a.e.d.a(4, (int) aeVar.i);
            int a6 = com.heytap.nearx.a.a.e.p.a(5, (int) aeVar.j);
            int i = 0;
            int a7 = aeVar.k != null ? com.heytap.nearx.a.a.e.p.a(6, (int) aeVar.k) : 0;
            int a8 = aeVar.l != null ? m.f12054c.a(7, (int) aeVar.l) : 0;
            int a9 = aeVar.m != null ? w.f12080c.a(8, (int) aeVar.m) : 0;
            int a10 = aeVar.n != null ? u.f12076c.a(9, (int) aeVar.n) : 0;
            int a11 = aeVar.o != null ? ah.f12018c.a(10, (int) aeVar.o) : 0;
            if (aeVar.p != null) {
                i = v.f12078c.a(11, (int) aeVar.p);
            }
            return a11 + a6 + a2 + a3 + a4 + a5 + a7 + a8 + a9 + a10 + i + aeVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, ae aeVar) throws IOException {
            com.heytap.nearx.a.a.e.p.a(gVar, 1, aeVar.f);
            com.heytap.nearx.a.a.e.p.a(gVar, 2, aeVar.g);
            com.heytap.nearx.a.a.e.d.a(gVar, 3, aeVar.h);
            com.heytap.nearx.a.a.e.d.a(gVar, 4, aeVar.i);
            com.heytap.nearx.a.a.e.p.a(gVar, 5, aeVar.j);
            if (aeVar.k != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 6, aeVar.k);
            }
            if (aeVar.l != null) {
                m.f12054c.a(gVar, 7, aeVar.l);
            }
            if (aeVar.m != null) {
                w.f12080c.a(gVar, 8, aeVar.m);
            }
            if (aeVar.n != null) {
                u.f12076c.a(gVar, 9, aeVar.n);
            }
            if (aeVar.o != null) {
                ah.f12018c.a(gVar, 10, aeVar.o);
            }
            if (aeVar.p != null) {
                v.f12078c.a(gVar, 11, aeVar.p);
            }
            gVar.a(aeVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public ae a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.a(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 4:
                        aVar.b(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 5:
                        aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 6:
                        aVar.d(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 7:
                        aVar.a(m.f12054c.a(fVar));
                        break;
                    case 8:
                        aVar.a(w.f12080c.a(fVar));
                        break;
                    case 9:
                        aVar.a(u.f12076c.a(fVar));
                        break;
                    case 10:
                        aVar.a(ah.f12018c.a(fVar));
                        break;
                    case 11:
                        aVar.a(v.f12078c.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a c2 = fVar.c();
                        aVar.a(b, c2, c2.a().a(fVar));
                        break;
                }
            }
        }
    }

    public ae(String str, String str2, Integer num, Integer num2, String str3, String str4, m mVar, w wVar, u uVar, ah ahVar, v vVar, ByteString byteString) {
        super(f12010c, byteString);
        this.f = str;
        this.g = str2;
        this.h = num;
        this.i = num2;
        this.j = str3;
        this.k = str4;
        this.l = mVar;
        this.m = wVar;
        this.n = uVar;
        this.o = ahVar;
        this.p = vVar;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", appId=");
        sb.append(this.f);
        sb.append(", packageName=");
        sb.append(this.g);
        sb.append(", platform=");
        sb.append(this.h);
        sb.append(", sdkVerCode=");
        sb.append(this.i);
        sb.append(", posId=");
        sb.append(this.j);
        if (this.k != null) {
            sb.append(", platformPkgName=");
            sb.append(this.k);
        }
        if (this.l != null) {
            sb.append(", devInfo=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", marketInfo=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", instantInfo=");
            sb.append(this.n);
        }
        if (this.o != null) {
            sb.append(", xgameInfo=");
            sb.append(this.o);
        }
        if (this.p != null) {
            sb.append(", localInfo=");
            sb.append(this.p);
        }
        StringBuilder replace = sb.replace(0, 2, "StateRequest{");
        replace.append('}');
        return replace.toString();
    }
}
