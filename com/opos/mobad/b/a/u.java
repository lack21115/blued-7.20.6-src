package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/u.class */
public final class u extends com.heytap.nearx.a.a.b<u, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<u> f25764c = new b();
    public static final Boolean d = false;
    public static final Long e = 0L;
    public static final Long f = 0L;
    private static final long serialVersionUID = 0;
    public final Boolean g;
    public final String h;
    public final String i;
    public final Long j;
    public final Long k;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/u$a.class */
    public static final class a extends b.a<u, a> {

        /* renamed from: c  reason: collision with root package name */
        public Boolean f25765c;
        public String d;
        public String e;
        public Long f;
        public Long g;

        public a a(Boolean bool) {
            this.f25765c = bool;
            return this;
        }

        public a a(Long l) {
            this.f = l;
            return this;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public a b(Long l) {
            this.g = l;
            return this;
        }

        public a b(String str) {
            this.e = str;
            return this;
        }

        public u b() {
            return new u(this.f25765c, this.d, this.e, this.f, this.g, super.a());
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/u$b.class */
    static final class b extends com.heytap.nearx.a.a.e<u> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, u.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(u uVar) {
            int i = 0;
            int a2 = uVar.g != null ? com.heytap.nearx.a.a.e.f22261c.a(1, (int) uVar.g) : 0;
            int a3 = uVar.h != null ? com.heytap.nearx.a.a.e.p.a(2, (int) uVar.h) : 0;
            int a4 = uVar.i != null ? com.heytap.nearx.a.a.e.p.a(3, (int) uVar.i) : 0;
            int a5 = uVar.j != null ? com.heytap.nearx.a.a.e.i.a(4, (int) uVar.j) : 0;
            if (uVar.k != null) {
                i = com.heytap.nearx.a.a.e.i.a(5, (int) uVar.k);
            }
            return a5 + a3 + a2 + a4 + i + uVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, u uVar) throws IOException {
            if (uVar.g != null) {
                com.heytap.nearx.a.a.e.f22261c.a(gVar, 1, uVar.g);
            }
            if (uVar.h != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, uVar.h);
            }
            if (uVar.i != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, uVar.i);
            }
            if (uVar.j != null) {
                com.heytap.nearx.a.a.e.i.a(gVar, 4, uVar.j);
            }
            if (uVar.k != null) {
                com.heytap.nearx.a.a.e.i.a(gVar, 5, uVar.k);
            }
            gVar.a(uVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public u a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                } else if (b == 3) {
                    aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b == 4) {
                    aVar.a(com.heytap.nearx.a.a.e.i.a(fVar));
                } else if (b != 5) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b, c2, c2.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.i.a(fVar));
                }
            }
        }
    }

    public u(Boolean bool, String str, String str2, Long l, Long l2, ByteString byteString) {
        super(f25764c, byteString);
        this.g = bool;
        this.h = str;
        this.i = str2;
        this.j = l;
        this.k = l2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.g != null) {
            sb.append(", installed=");
            sb.append(this.g);
        }
        if (this.h != null) {
            sb.append(", version=");
            sb.append(this.h);
        }
        if (this.i != null) {
            sb.append(", sdkVersion=");
            sb.append(this.i);
        }
        if (this.j != null) {
            sb.append(", firstActiveTime=");
            sb.append(this.j);
        }
        if (this.k != null) {
            sb.append(", dayFirstActiveTime=");
            sb.append(this.k);
        }
        StringBuilder replace = sb.replace(0, 2, "InstantInfo{");
        replace.append('}');
        return replace.toString();
    }
}
