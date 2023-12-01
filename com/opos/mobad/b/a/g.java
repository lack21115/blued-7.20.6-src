package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/g.class */
public final class g extends com.heytap.nearx.a.a.b<g, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<g> f12042c = new b();
    private static final long serialVersionUID = 0;
    public final String d;
    public final String e;
    public final String f;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/g$a.class */
    public static final class a extends b.a<g, a> {

        /* renamed from: c  reason: collision with root package name */
        public String f12043c;
        public String d;
        public String e;

        public a a(String str) {
            this.f12043c = str;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public g b() {
            return new g(this.f12043c, this.d, this.e, super.a());
        }

        public a c(String str) {
            this.e = str;
            return this;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/g$b.class */
    static final class b extends com.heytap.nearx.a.a.e<g> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, g.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(g gVar) {
            int i = 0;
            int a2 = gVar.d != null ? com.heytap.nearx.a.a.e.p.a(1, (int) gVar.d) : 0;
            int a3 = gVar.e != null ? com.heytap.nearx.a.a.e.p.a(2, (int) gVar.e) : 0;
            if (gVar.f != null) {
                i = com.heytap.nearx.a.a.e.p.a(3, (int) gVar.f);
            }
            return a2 + a3 + i + gVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, g gVar2) throws IOException {
            if (gVar2.d != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, gVar2.d);
            }
            if (gVar2.e != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, gVar2.e);
            }
            if (gVar2.f != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, gVar2.f);
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
                } else if (b == 1) {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b == 2) {
                    aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b != 3) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b, c2, c2.a().a(fVar));
                } else {
                    aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public g(String str, String str2, String str3, ByteString byteString) {
        super(f12042c, byteString);
        this.d = str;
        this.e = str2;
        this.f = str3;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.d != null) {
            sb.append(", appId=");
            sb.append(this.d);
        }
        if (this.e != null) {
            sb.append(", pkgName=");
            sb.append(this.e);
        }
        if (this.f != null) {
            sb.append(", verName=");
            sb.append(this.f);
        }
        StringBuilder replace = sb.replace(0, 2, "AppInfo{");
        replace.append('}');
        return replace.toString();
    }
}
