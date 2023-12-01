package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/h.class */
public final class h extends com.heytap.nearx.a.a.b<h, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<h> f26341c = new b();
    private static final long serialVersionUID = 0;
    public final g d;
    public final i e;
    public final String f;
    public final String g;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/h$a.class */
    public static final class a extends b.a<h, a> {

        /* renamed from: c  reason: collision with root package name */
        public g f26342c;
        public i d;
        public String e;
        public String f;

        public a a(g gVar) {
            this.f26342c = gVar;
            return this;
        }

        public a a(i iVar) {
            this.d = iVar;
            return this;
        }

        public a a(String str) {
            this.e = str;
            return this;
        }

        public a b(String str) {
            this.f = str;
            return this;
        }

        public h b() {
            i iVar;
            g gVar = this.f26342c;
            if (gVar == null || (iVar = this.d) == null) {
                throw com.heytap.nearx.a.a.a.b.a(this.f26342c, "devId", this.d, "devOs");
            }
            return new h(gVar, iVar, this.e, this.f, super.a());
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/h$b.class */
    static final class b extends com.heytap.nearx.a.a.e<h> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, h.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(h hVar) {
            int a2 = g.f26339c.a(1, (int) hVar.d);
            int a3 = i.f26343c.a(2, (int) hVar.e);
            int i = 0;
            int a4 = hVar.f != null ? com.heytap.nearx.a.a.e.p.a(3, (int) hVar.f) : 0;
            if (hVar.g != null) {
                i = com.heytap.nearx.a.a.e.p.a(4, (int) hVar.g);
            }
            return a4 + a3 + a2 + i + hVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, h hVar) throws IOException {
            g.f26339c.a(gVar, 1, hVar.d);
            i.f26343c.a(gVar, 2, hVar.e);
            if (hVar.f != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, hVar.f);
            }
            if (hVar.g != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 4, hVar.g);
            }
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
                    aVar.a(g.f26339c.a(fVar));
                } else if (b == 2) {
                    aVar.a(i.f26343c.a(fVar));
                } else if (b == 3) {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b != 4) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b, c2, c2.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public h(g gVar, i iVar, String str, String str2, ByteString byteString) {
        super(f26341c, byteString);
        this.d = gVar;
        this.e = iVar;
        this.f = str;
        this.g = str2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", devId=");
        sb.append(this.d);
        sb.append(", devOs=");
        sb.append(this.e);
        if (this.f != null) {
            sb.append(", model=");
            sb.append(this.f);
        }
        if (this.g != null) {
            sb.append(", brand=");
            sb.append(this.g);
        }
        StringBuilder replace = sb.replace(0, 2, "DevInfo{");
        replace.append('}');
        return replace.toString();
    }
}
