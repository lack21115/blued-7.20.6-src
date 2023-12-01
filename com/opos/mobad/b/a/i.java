package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/i.class */
public final class i extends com.heytap.nearx.a.a.b<i, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<i> f12046c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    public static final Boolean f = true;
    public static final Boolean g = true;
    private static final long serialVersionUID = 0;
    public final String h;
    public final String i;
    public final Integer j;
    public final Integer k;
    public final m l;
    public final Boolean m;
    public final Boolean n;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/i$a.class */
    public static final class a extends b.a<i, a> {

        /* renamed from: c  reason: collision with root package name */
        public String f12047c;
        public String d;
        public Integer e;
        public Integer f;
        public m g;
        public Boolean h;
        public Boolean i;

        public a a(m mVar) {
            this.g = mVar;
            return this;
        }

        public a a(Boolean bool) {
            this.h = bool;
            return this;
        }

        public a a(Integer num) {
            this.e = num;
            return this;
        }

        public a a(String str) {
            this.f12047c = str;
            return this;
        }

        public a b(Boolean bool) {
            this.i = bool;
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

        public i b() {
            String str;
            Integer num;
            Integer num2;
            String str2 = this.f12047c;
            if (str2 == null || (str = this.d) == null || (num = this.e) == null || (num2 = this.f) == null) {
                throw com.heytap.nearx.a.a.a.b.a(this.f12047c, "appId", this.d, "packageName", this.e, "platform", this.f, "sdkVerCode");
            }
            return new i(str2, str, num, num2, this.g, this.h, this.i, super.a());
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/i$b.class */
    static final class b extends com.heytap.nearx.a.a.e<i> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, i.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(i iVar) {
            int a2 = com.heytap.nearx.a.a.e.p.a(1, (int) iVar.h);
            int a3 = com.heytap.nearx.a.a.e.p.a(2, (int) iVar.i);
            int a4 = com.heytap.nearx.a.a.e.d.a(3, (int) iVar.j);
            int a5 = com.heytap.nearx.a.a.e.d.a(4, (int) iVar.k);
            int i = 0;
            int a6 = iVar.l != null ? m.f12054c.a(5, (int) iVar.l) : 0;
            int a7 = iVar.m != null ? com.heytap.nearx.a.a.e.f8653c.a(6, (int) iVar.m) : 0;
            if (iVar.n != null) {
                i = com.heytap.nearx.a.a.e.f8653c.a(7, (int) iVar.n);
            }
            return a7 + a5 + a2 + a3 + a4 + a6 + i + iVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, i iVar) throws IOException {
            com.heytap.nearx.a.a.e.p.a(gVar, 1, iVar.h);
            com.heytap.nearx.a.a.e.p.a(gVar, 2, iVar.i);
            com.heytap.nearx.a.a.e.d.a(gVar, 3, iVar.j);
            com.heytap.nearx.a.a.e.d.a(gVar, 4, iVar.k);
            if (iVar.l != null) {
                m.f12054c.a(gVar, 5, iVar.l);
            }
            if (iVar.m != null) {
                com.heytap.nearx.a.a.e.f8653c.a(gVar, 6, iVar.m);
            }
            if (iVar.n != null) {
                com.heytap.nearx.a.a.e.f8653c.a(gVar, 7, iVar.n);
            }
            gVar.a(iVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public i a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.a(m.f12054c.a(fVar));
                        break;
                    case 6:
                        aVar.a(com.heytap.nearx.a.a.e.f8653c.a(fVar));
                        break;
                    case 7:
                        aVar.b(com.heytap.nearx.a.a.e.f8653c.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a c2 = fVar.c();
                        aVar.a(b, c2, c2.a().a(fVar));
                        break;
                }
            }
        }
    }

    public i(String str, String str2, Integer num, Integer num2, m mVar, Boolean bool, Boolean bool2, ByteString byteString) {
        super(f12046c, byteString);
        this.h = str;
        this.i = str2;
        this.j = num;
        this.k = num2;
        this.l = mVar;
        this.m = bool;
        this.n = bool2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", appId=");
        sb.append(this.h);
        sb.append(", packageName=");
        sb.append(this.i);
        sb.append(", platform=");
        sb.append(this.j);
        sb.append(", sdkVerCode=");
        sb.append(this.k);
        if (this.l != null) {
            sb.append(", devInfo=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", ouIdOpenStatus=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", appOuidStatus=");
            sb.append(this.n);
        }
        StringBuilder replace = sb.replace(0, 2, "ControlRequest{");
        replace.append('}');
        return replace.toString();
    }
}
