package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/e.class */
public final class e extends com.heytap.nearx.a.a.b<e, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<e> f12038c = new b();
    private static final long serialVersionUID = 0;
    public final String d;
    public final String e;
    public final String f;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/e$a.class */
    public static final class a extends b.a<e, a> {

        /* renamed from: c  reason: collision with root package name */
        public String f12039c;
        public String d;
        public String e;

        public a a(String str) {
            this.f12039c = str;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public e b() {
            return new e(this.f12039c, this.d, this.e, super.a());
        }

        public a c(String str) {
            this.e = str;
            return this;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/e$b.class */
    static final class b extends com.heytap.nearx.a.a.e<e> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, e.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(e eVar) {
            int i = 0;
            int a2 = eVar.d != null ? com.heytap.nearx.a.a.e.p.a(1, (int) eVar.d) : 0;
            int a3 = eVar.e != null ? com.heytap.nearx.a.a.e.p.a(2, (int) eVar.e) : 0;
            if (eVar.f != null) {
                i = com.heytap.nearx.a.a.e.p.a(3, (int) eVar.f);
            }
            return a2 + a3 + i + eVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, e eVar) throws IOException {
            if (eVar.d != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, eVar.d);
            }
            if (eVar.e != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, eVar.e);
            }
            if (eVar.f != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, eVar.f);
            }
            gVar.a(eVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public e a(com.heytap.nearx.a.a.f fVar) throws IOException {
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

    public e(String str, String str2, String str3) {
        this(str, str2, str3, ByteString.EMPTY);
    }

    public e(String str, String str2, String str3, ByteString byteString) {
        super(f12038c, byteString);
        this.d = str;
        this.e = str2;
        this.f = str3;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.d != null) {
            sb.append(", md5=");
            sb.append(this.d);
        }
        if (this.e != null) {
            sb.append(", sha1=");
            sb.append(this.e);
        }
        if (this.f != null) {
            sb.append(", sha256=");
            sb.append(this.f);
        }
        StringBuilder replace = sb.replace(0, 2, "ApkSigner{");
        replace.append('}');
        return replace.toString();
    }
}
