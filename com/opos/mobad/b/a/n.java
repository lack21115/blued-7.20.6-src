package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/n.class */
public final class n extends com.heytap.nearx.a.a.b<n, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<n> f12056c = new b();
    private static final long serialVersionUID = 0;
    public final String d;
    public final String e;
    public final String f;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/n$a.class */
    public static final class a extends b.a<n, a> {

        /* renamed from: c  reason: collision with root package name */
        public String f12057c;
        public String d;
        public String e;

        public a a(String str) {
            this.f12057c = str;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public n b() {
            return new n(this.f12057c, this.d, this.e, super.a());
        }

        public a c(String str) {
            this.e = str;
            return this;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/n$b.class */
    static final class b extends com.heytap.nearx.a.a.e<n> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, n.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(n nVar) {
            int i = 0;
            int a2 = nVar.d != null ? com.heytap.nearx.a.a.e.p.a(1, (int) nVar.d) : 0;
            int a3 = nVar.e != null ? com.heytap.nearx.a.a.e.p.a(2, (int) nVar.e) : 0;
            if (nVar.f != null) {
                i = com.heytap.nearx.a.a.e.p.a(3, (int) nVar.f);
            }
            return a2 + a3 + i + nVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, n nVar) throws IOException {
            if (nVar.d != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, nVar.d);
            }
            if (nVar.e != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, nVar.e);
            }
            if (nVar.f != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, nVar.f);
            }
            gVar.a(nVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public n a(com.heytap.nearx.a.a.f fVar) throws IOException {
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

    public n(String str, String str2, String str3, ByteString byteString) {
        super(f12056c, byteString);
        this.d = str;
        this.e = str2;
        this.f = str3;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.d != null) {
            sb.append(", osVer=");
            sb.append(this.d);
        }
        if (this.e != null) {
            sb.append(", romVer=");
            sb.append(this.e);
        }
        if (this.f != null) {
            sb.append(", anVer=");
            sb.append(this.f);
        }
        StringBuilder replace = sb.replace(0, 2, "DevOs{");
        replace.append('}');
        return replace.toString();
    }
}
