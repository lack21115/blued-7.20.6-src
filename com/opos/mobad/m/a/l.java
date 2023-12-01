package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/l.class */
public final class l extends com.heytap.nearx.a.a.b<l, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<l> f12661c = new b();
    private static final long serialVersionUID = 0;
    public final String d;
    public final String e;
    public final String f;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/l$a.class */
    public static final class a extends b.a<l, a> {

        /* renamed from: c  reason: collision with root package name */
        public String f12662c;
        public String d;
        public String e;

        public a a(String str) {
            this.f12662c = str;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public l b() {
            return new l(this.f12662c, this.d, this.e, super.a());
        }

        public a c(String str) {
            this.e = str;
            return this;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/l$b.class */
    static final class b extends com.heytap.nearx.a.a.e<l> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, l.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(l lVar) {
            int i = 0;
            int a2 = lVar.d != null ? com.heytap.nearx.a.a.e.p.a(1, (int) lVar.d) : 0;
            int a3 = lVar.e != null ? com.heytap.nearx.a.a.e.p.a(2, (int) lVar.e) : 0;
            if (lVar.f != null) {
                i = com.heytap.nearx.a.a.e.p.a(3, (int) lVar.f);
            }
            return a2 + a3 + i + lVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, l lVar) throws IOException {
            if (lVar.d != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, lVar.d);
            }
            if (lVar.e != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, lVar.e);
            }
            if (lVar.f != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, lVar.f);
            }
            gVar.a(lVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public l a(com.heytap.nearx.a.a.f fVar) throws IOException {
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

    public l(String str, String str2, String str3, ByteString byteString) {
        super(f12661c, byteString);
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
