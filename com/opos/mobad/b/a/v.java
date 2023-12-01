package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/v.class */
public final class v extends com.heytap.nearx.a.a.b<v, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<v> f12078c = new b();
    private static final long serialVersionUID = 0;
    public final String d;
    public final String e;
    public final String f;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/v$a.class */
    public static final class a extends b.a<v, a> {

        /* renamed from: c  reason: collision with root package name */
        public String f12079c;
        public String d;
        public String e;

        public a a(String str) {
            this.f12079c = str;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public v b() {
            return new v(this.f12079c, this.d, this.e, super.a());
        }

        public a c(String str) {
            this.e = str;
            return this;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/v$b.class */
    static final class b extends com.heytap.nearx.a.a.e<v> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, v.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(v vVar) {
            int i = 0;
            int a2 = vVar.d != null ? com.heytap.nearx.a.a.e.p.a(1, (int) vVar.d) : 0;
            int a3 = vVar.e != null ? com.heytap.nearx.a.a.e.p.a(2, (int) vVar.e) : 0;
            if (vVar.f != null) {
                i = com.heytap.nearx.a.a.e.p.a(3, (int) vVar.f);
            }
            return a2 + a3 + i + vVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, v vVar) throws IOException {
            if (vVar.d != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, vVar.d);
            }
            if (vVar.e != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, vVar.e);
            }
            if (vVar.f != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, vVar.f);
            }
            gVar.a(vVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public v a(com.heytap.nearx.a.a.f fVar) throws IOException {
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

    public v(String str, String str2, String str3, ByteString byteString) {
        super(f12078c, byteString);
        this.d = str;
        this.e = str2;
        this.f = str3;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.d != null) {
            sb.append(", region=");
            sb.append(this.d);
        }
        if (this.e != null) {
            sb.append(", language=");
            sb.append(this.e);
        }
        if (this.f != null) {
            sb.append(", country=");
            sb.append(this.f);
        }
        StringBuilder replace = sb.replace(0, 2, "LocalInfo{");
        replace.append('}');
        return replace.toString();
    }
}
