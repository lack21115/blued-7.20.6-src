package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/x.class */
public final class x extends com.heytap.nearx.a.a.b<x, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<x> f26373c = new b();
    public static final Boolean d = false;
    private static final long serialVersionUID = 0;
    public final Boolean e;
    public final String f;
    public final String g;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/x$a.class */
    public static final class a extends b.a<x, a> {

        /* renamed from: c  reason: collision with root package name */
        public Boolean f26374c;
        public String d;
        public String e;

        public a a(Boolean bool) {
            this.f26374c = bool;
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

        public x b() {
            return new x(this.f26374c, this.d, this.e, super.a());
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/x$b.class */
    static final class b extends com.heytap.nearx.a.a.e<x> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, x.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(x xVar) {
            int i = 0;
            int a2 = xVar.e != null ? com.heytap.nearx.a.a.e.f22261c.a(1, (int) xVar.e) : 0;
            int a3 = xVar.f != null ? com.heytap.nearx.a.a.e.p.a(2, (int) xVar.f) : 0;
            if (xVar.g != null) {
                i = com.heytap.nearx.a.a.e.p.a(3, (int) xVar.g);
            }
            return a2 + a3 + i + xVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, x xVar) throws IOException {
            if (xVar.e != null) {
                com.heytap.nearx.a.a.e.f22261c.a(gVar, 1, xVar.e);
            }
            if (xVar.f != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, xVar.f);
            }
            if (xVar.g != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, xVar.g);
            }
            gVar.a(xVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public x a(com.heytap.nearx.a.a.f fVar) throws IOException {
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

    public x(Boolean bool, String str, String str2, ByteString byteString) {
        super(f26373c, byteString);
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
        StringBuilder replace = sb.replace(0, 2, "XgameInfo{");
        replace.append('}');
        return replace.toString();
    }
}
