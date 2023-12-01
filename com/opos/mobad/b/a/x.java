package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/x.class */
public final class x extends com.heytap.nearx.a.a.b<x, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<x> f25770c = new b();
    private static final long serialVersionUID = 0;
    public final String d;
    public final String e;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/x$a.class */
    public static final class a extends b.a<x, a> {

        /* renamed from: c  reason: collision with root package name */
        public String f25771c;
        public String d;

        public a a(String str) {
            this.f25771c = str;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public x b() {
            return new x(this.f25771c, this.d, super.a());
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/x$b.class */
    static final class b extends com.heytap.nearx.a.a.e<x> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, x.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(x xVar) {
            int i = 0;
            int a2 = xVar.d != null ? com.heytap.nearx.a.a.e.p.a(1, (int) xVar.d) : 0;
            if (xVar.e != null) {
                i = com.heytap.nearx.a.a.e.p.a(2, (int) xVar.e);
            }
            return a2 + i + xVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, x xVar) throws IOException {
            if (xVar.d != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, xVar.d);
            }
            if (xVar.e != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, xVar.e);
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

    public x(String str, String str2, ByteString byteString) {
        super(f25770c, byteString);
        this.d = str;
        this.e = str2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.d != null) {
            sb.append(", url=");
            sb.append(this.d);
        }
        if (this.e != null) {
            sb.append(", md5=");
            sb.append(this.e);
        }
        StringBuilder replace = sb.replace(0, 2, "MaterialFile{");
        replace.append('}');
        return replace.toString();
    }
}
