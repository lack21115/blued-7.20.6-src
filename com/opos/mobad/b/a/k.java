package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/k.class */
public final class k extends com.heytap.nearx.a.a.b<k, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<k> f25738c = new b();
    public static final Double d;
    public static final Double e;
    public static final Long f;
    private static final long serialVersionUID = 0;
    public final Double g;
    public final Double h;
    public final Long i;
    public final String j;
    public final String k;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/k$a.class */
    public static final class a extends b.a<k, a> {

        /* renamed from: c  reason: collision with root package name */
        public Double f25739c;
        public Double d;
        public Long e;
        public String f;
        public String g;

        public a a(Double d) {
            this.f25739c = d;
            return this;
        }

        public a a(Long l) {
            this.e = l;
            return this;
        }

        public a a(String str) {
            this.f = str;
            return this;
        }

        public a b(Double d) {
            this.d = d;
            return this;
        }

        public a b(String str) {
            this.g = str;
            return this;
        }

        public k b() {
            return new k(this.f25739c, this.d, this.e, this.f, this.g, super.a());
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/k$b.class */
    static final class b extends com.heytap.nearx.a.a.e<k> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, k.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(k kVar) {
            int i = 0;
            int a2 = kVar.g != null ? com.heytap.nearx.a.a.e.o.a(1, (int) kVar.g) : 0;
            int a3 = kVar.h != null ? com.heytap.nearx.a.a.e.o.a(2, (int) kVar.h) : 0;
            int a4 = kVar.i != null ? com.heytap.nearx.a.a.e.i.a(3, (int) kVar.i) : 0;
            int a5 = kVar.j != null ? com.heytap.nearx.a.a.e.p.a(4, (int) kVar.j) : 0;
            if (kVar.k != null) {
                i = com.heytap.nearx.a.a.e.p.a(5, (int) kVar.k);
            }
            return a5 + a3 + a2 + a4 + i + kVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, k kVar) throws IOException {
            if (kVar.g != null) {
                com.heytap.nearx.a.a.e.o.a(gVar, 1, kVar.g);
            }
            if (kVar.h != null) {
                com.heytap.nearx.a.a.e.o.a(gVar, 2, kVar.h);
            }
            if (kVar.i != null) {
                com.heytap.nearx.a.a.e.i.a(gVar, 3, kVar.i);
            }
            if (kVar.j != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 4, kVar.j);
            }
            if (kVar.k != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 5, kVar.k);
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
                    aVar.a(com.heytap.nearx.a.a.e.o.a(fVar));
                } else if (b == 2) {
                    aVar.b(com.heytap.nearx.a.a.e.o.a(fVar));
                } else if (b == 3) {
                    aVar.a(com.heytap.nearx.a.a.e.i.a(fVar));
                } else if (b == 4) {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b != 5) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b, c2, c2.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    static {
        Double valueOf = Double.valueOf(0.0d);
        d = valueOf;
        e = valueOf;
        f = 0L;
    }

    public k(Double d2, Double d3, Long l, String str, String str2, ByteString byteString) {
        super(f25738c, byteString);
        this.g = d2;
        this.h = d3;
        this.i = l;
        this.j = str;
        this.k = str2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.g != null) {
            sb.append(", longitude=");
            sb.append(this.g);
        }
        if (this.h != null) {
            sb.append(", latitude=");
            sb.append(this.h);
        }
        if (this.i != null) {
            sb.append(", timestamp=");
            sb.append(this.i);
        }
        if (this.j != null) {
            sb.append(", cryptLon=");
            sb.append(this.j);
        }
        if (this.k != null) {
            sb.append(", cryptLat=");
            sb.append(this.k);
        }
        StringBuilder replace = sb.replace(0, 2, "DevGps{");
        replace.append('}');
        return replace.toString();
    }
}
