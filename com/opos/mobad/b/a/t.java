package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/t.class */
public final class t extends com.heytap.nearx.a.a.b<t, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<t> f12074c = new b();
    private static final long serialVersionUID = 0;
    public final String d;
    public final String e;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/t$a.class */
    public static final class a extends b.a<t, a> {

        /* renamed from: c  reason: collision with root package name */
        public String f12075c;
        public String d;

        public a a(String str) {
            this.f12075c = str;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public t b() {
            return new t(this.f12075c, this.d, super.a());
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/t$b.class */
    static final class b extends com.heytap.nearx.a.a.e<t> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, t.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(t tVar) {
            int i = 0;
            int a2 = tVar.d != null ? com.heytap.nearx.a.a.e.p.a(1, (int) tVar.d) : 0;
            if (tVar.e != null) {
                i = com.heytap.nearx.a.a.e.p.a(2, (int) tVar.e);
            }
            return a2 + i + tVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, t tVar) throws IOException {
            if (tVar.d != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, tVar.d);
            }
            if (tVar.e != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, tVar.e);
            }
            gVar.a(tVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public t a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b = fVar.b();
                if (b == -1) {
                    fVar.a(a2);
                    return aVar.b();
                } else if (b == 1) {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b != 2) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b, c2, c2.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public t(String str, String str2, ByteString byteString) {
        super(f12074c, byteString);
        this.d = str;
        this.e = str2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.d != null) {
            sb.append(", origin=");
            sb.append(this.d);
        }
        if (this.e != null) {
            sb.append(", secret=");
            sb.append(this.e);
        }
        StringBuilder replace = sb.replace(0, 2, "InstantIds{");
        replace.append('}');
        return replace.toString();
    }
}
