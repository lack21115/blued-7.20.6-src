package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/u.class */
public final class u extends com.heytap.nearx.a.a.b<u, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<u> f26367c = new b();
    private static final long serialVersionUID = 0;
    public final String d;
    public final t e;
    public final h f;
    public final String g;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/u$a.class */
    public static final class a extends b.a<u, a> {

        /* renamed from: c  reason: collision with root package name */
        public String f26368c;
        public t d;
        public h e;
        public String f;

        public a a(h hVar) {
            this.e = hVar;
            return this;
        }

        public a a(t tVar) {
            this.d = tVar;
            return this;
        }

        public a a(String str) {
            this.f26368c = str;
            return this;
        }

        public a b(String str) {
            this.f = str;
            return this;
        }

        public u b() {
            t tVar;
            h hVar;
            String str;
            String str2 = this.f26368c;
            if (str2 == null || (tVar = this.d) == null || (hVar = this.e) == null || (str = this.f) == null) {
                throw com.heytap.nearx.a.a.a.b.a(this.f26368c, "posId", this.d, "userAccountInfo", this.e, "devInfo", this.f, "platformPkgName");
            }
            return new u(str2, tVar, hVar, str, super.a());
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/u$b.class */
    static final class b extends com.heytap.nearx.a.a.e<u> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, u.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(u uVar) {
            return com.heytap.nearx.a.a.e.p.a(1, (int) uVar.d) + t.f26365c.a(2, (int) uVar.e) + h.f26341c.a(3, (int) uVar.f) + com.heytap.nearx.a.a.e.p.a(4, (int) uVar.g) + uVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, u uVar) throws IOException {
            com.heytap.nearx.a.a.e.p.a(gVar, 1, uVar.d);
            t.f26365c.a(gVar, 2, uVar.e);
            h.f26341c.a(gVar, 3, uVar.f);
            com.heytap.nearx.a.a.e.p.a(gVar, 4, uVar.g);
            gVar.a(uVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public u a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b = fVar.b();
                if (b == -1) {
                    fVar.a(a2);
                    return aVar.b();
                } else if (b == 1) {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b == 2) {
                    aVar.a(t.f26365c.a(fVar));
                } else if (b == 3) {
                    aVar.a(h.f26341c.a(fVar));
                } else if (b != 4) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b, c2, c2.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public u(String str, t tVar, h hVar, String str2, ByteString byteString) {
        super(f26367c, byteString);
        this.d = str;
        this.e = tVar;
        this.f = hVar;
        this.g = str2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", posId=");
        sb.append(this.d);
        sb.append(", userAccountInfo=");
        sb.append(this.e);
        sb.append(", devInfo=");
        sb.append(this.f);
        sb.append(", platformPkgName=");
        sb.append(this.g);
        StringBuilder replace = sb.replace(0, 2, "VipInfoReq{");
        replace.append('}');
        return replace.toString();
    }
}
