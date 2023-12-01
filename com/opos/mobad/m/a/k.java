package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/k.class */
public final class k extends com.heytap.nearx.a.a.b<k, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<k> f26347c = new b();
    public static final Boolean d = false;
    private static final long serialVersionUID = 0;
    public final Boolean e;
    public final String f;
    public final String g;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/k$a.class */
    public static final class a extends b.a<k, a> {

        /* renamed from: c  reason: collision with root package name */
        public Boolean f26348c;
        public String d;
        public String e;

        public a a(Boolean bool) {
            this.f26348c = bool;
            return this;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public a b(String str) {
            this.e = str;
            return this;
        }

        public k b() {
            return new k(this.f26348c, this.d, this.e, super.a());
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/k$b.class */
    static final class b extends com.heytap.nearx.a.a.e<k> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, k.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(k kVar) {
            int i = 0;
            int a2 = kVar.e != null ? com.heytap.nearx.a.a.e.f22261c.a(1, (int) kVar.e) : 0;
            int a3 = kVar.f != null ? com.heytap.nearx.a.a.e.p.a(2, (int) kVar.f) : 0;
            if (kVar.g != null) {
                i = com.heytap.nearx.a.a.e.p.a(3, (int) kVar.g);
            }
            return a2 + a3 + i + kVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, k kVar) throws IOException {
            if (kVar.e != null) {
                com.heytap.nearx.a.a.e.f22261c.a(gVar, 1, kVar.e);
            }
            if (kVar.f != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, kVar.f);
            }
            if (kVar.g != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, kVar.g);
            }
            gVar.a(kVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public k a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b = fVar.b();
                if (b == -1) {
                    fVar.a(a2);
                    return aVar.b();
                } else if (b == 1) {
                    aVar.a(com.heytap.nearx.a.a.e.f22261c.a(fVar));
                } else if (b == 2) {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b != 3) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b, c2, c2.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public k(Boolean bool, String str, String str2, ByteString byteString) {
        super(f26347c, byteString);
        this.e = bool;
        this.f = str;
        this.g = str2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.e != null) {
            sb.append(", installed=");
            sb.append(this.e);
        }
        if (this.f != null) {
            sb.append(", version=");
            sb.append(this.f);
        }
        if (this.g != null) {
            sb.append(", sdkVersion=");
            sb.append(this.g);
        }
        StringBuilder replace = sb.replace(0, 2, "InstantInfo{");
        replace.append('}');
        return replace.toString();
    }
}
