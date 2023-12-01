package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/h.class */
public final class h extends com.heytap.nearx.a.a.b<h, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<h> f25732c = new b();
    private static final long serialVersionUID = 0;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/h$a.class */
    public static final class a extends b.a<h, a> {

        /* renamed from: c  reason: collision with root package name */
        public String f25733c;
        public String d;
        public String e;
        public String f;

        public a a(String str) {
            this.f25733c = str;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public h b() {
            String str;
            String str2;
            String str3;
            String str4 = this.f25733c;
            if (str4 == null || (str = this.d) == null || (str2 = this.e) == null || (str3 = this.f) == null) {
                throw com.heytap.nearx.a.a.a.b.a(this.f25733c, "permissionUrl", this.d, "privacyUrl", this.e, "versionName", this.f, "developerName");
            }
            return new h(str4, str, str2, str3, super.a());
        }

        public a c(String str) {
            this.e = str;
            return this;
        }

        public a d(String str) {
            this.f = str;
            return this;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/h$b.class */
    static final class b extends com.heytap.nearx.a.a.e<h> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, h.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(h hVar) {
            return com.heytap.nearx.a.a.e.p.a(1, (int) hVar.d) + com.heytap.nearx.a.a.e.p.a(2, (int) hVar.e) + com.heytap.nearx.a.a.e.p.a(3, (int) hVar.f) + com.heytap.nearx.a.a.e.p.a(4, (int) hVar.g) + hVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, h hVar) throws IOException {
            com.heytap.nearx.a.a.e.p.a(gVar, 1, hVar.d);
            com.heytap.nearx.a.a.e.p.a(gVar, 2, hVar.e);
            com.heytap.nearx.a.a.e.p.a(gVar, 3, hVar.f);
            com.heytap.nearx.a.a.e.p.a(gVar, 4, hVar.g);
            gVar.a(hVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public h a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                } else if (b == 3) {
                    aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b != 4) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b, c2, c2.a().a(fVar));
                } else {
                    aVar.d(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public h(String str, String str2, String str3, String str4, ByteString byteString) {
        super(f25732c, byteString);
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", permissionUrl=");
        sb.append(this.d);
        sb.append(", privacyUrl=");
        sb.append(this.e);
        sb.append(", versionName=");
        sb.append(this.f);
        sb.append(", developerName=");
        sb.append(this.g);
        StringBuilder replace = sb.replace(0, 2, "AppPrivacyInfo{");
        replace.append('}');
        return replace.toString();
    }
}
