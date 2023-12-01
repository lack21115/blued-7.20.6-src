package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/f.class */
public final class f extends com.heytap.nearx.a.a.b<f, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<f> f12040c = new b();
    private static final long serialVersionUID = 0;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/f$a.class */
    public static final class a extends b.a<f, a> {

        /* renamed from: c  reason: collision with root package name */
        public String f12041c;
        public String d;
        public String e;
        public String f;

        public a a(String str) {
            this.f12041c = str;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public f b() {
            return new f(this.f12041c, this.d, this.e, this.f, super.a());
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

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/f$b.class */
    static final class b extends com.heytap.nearx.a.a.e<f> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, f.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(f fVar) {
            int i = 0;
            int a2 = fVar.d != null ? com.heytap.nearx.a.a.e.p.a(1, (int) fVar.d) : 0;
            int a3 = fVar.e != null ? com.heytap.nearx.a.a.e.p.a(2, (int) fVar.e) : 0;
            int a4 = fVar.f != null ? com.heytap.nearx.a.a.e.p.a(3, (int) fVar.f) : 0;
            if (fVar.g != null) {
                i = com.heytap.nearx.a.a.e.p.a(4, (int) fVar.g);
            }
            return a4 + a3 + a2 + i + fVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, f fVar) throws IOException {
            if (fVar.d != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, fVar.d);
            }
            if (fVar.e != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, fVar.e);
            }
            if (fVar.f != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, fVar.f);
            }
            if (fVar.g != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 4, fVar.g);
            }
            gVar.a(fVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public f a(com.heytap.nearx.a.a.f fVar) throws IOException {
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

    public f(String str, String str2, String str3, String str4, ByteString byteString) {
        super(f12040c, byteString);
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
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
        if (this.f != null) {
            sb.append(", pkgName=");
            sb.append(this.f);
        }
        if (this.g != null) {
            sb.append(", appName=");
            sb.append(this.g);
        }
        StringBuilder replace = sb.replace(0, 2, "AppDownInfo{");
        replace.append('}');
        return replace.toString();
    }
}
