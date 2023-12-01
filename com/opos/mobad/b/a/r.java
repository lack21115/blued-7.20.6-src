package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/r.class */
public final class r extends com.heytap.nearx.a.a.b<r, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<r> f25758c = new b();
    private static final long serialVersionUID = 0;
    public final x d;
    public final String e;
    public final String f;
    public final List<x> g;
    public final List<x> h;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/r$a.class */
    public static final class a extends b.a<r, a> {

        /* renamed from: c  reason: collision with root package name */
        public x f25759c;
        public String d;
        public String e;
        public List<x> f = com.heytap.nearx.a.a.a.b.a();
        public List<x> g = com.heytap.nearx.a.a.a.b.a();

        public a a(x xVar) {
            this.f25759c = xVar;
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

        public r b() {
            return new r(this.f25759c, this.d, this.e, this.f, this.g, super.a());
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/r$b.class */
    static final class b extends com.heytap.nearx.a.a.e<r> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, r.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(r rVar) {
            int i = 0;
            int a2 = rVar.d != null ? x.f25770c.a(1, (int) rVar.d) : 0;
            int a3 = rVar.e != null ? com.heytap.nearx.a.a.e.p.a(2, (int) rVar.e) : 0;
            if (rVar.f != null) {
                i = com.heytap.nearx.a.a.e.p.a(3, (int) rVar.f);
            }
            return a2 + a3 + i + x.f25770c.a().a(4, (int) rVar.g) + x.f25770c.a().a(5, (int) rVar.h) + rVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, r rVar) throws IOException {
            if (rVar.d != null) {
                x.f25770c.a(gVar, 1, rVar.d);
            }
            if (rVar.e != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, rVar.e);
            }
            if (rVar.f != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, rVar.f);
            }
            x.f25770c.a().a(gVar, 4, rVar.g);
            x.f25770c.a().a(gVar, 5, rVar.h);
            gVar.a(rVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public r a(com.heytap.nearx.a.a.f fVar) throws IOException {
            List<x> list;
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b = fVar.b();
                if (b == -1) {
                    fVar.a(a2);
                    return aVar.b();
                } else if (b == 1) {
                    aVar.a(x.f25770c.a(fVar));
                } else if (b == 2) {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b != 3) {
                    if (b == 4) {
                        list = aVar.f;
                    } else if (b != 5) {
                        com.heytap.nearx.a.a.a c2 = fVar.c();
                        aVar.a(b, c2, c2.a().a(fVar));
                    } else {
                        list = aVar.g;
                    }
                    list.add(x.f25770c.a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public r(x xVar, String str, String str2, List<x> list, List<x> list2, ByteString byteString) {
        super(f25758c, byteString);
        this.d = xVar;
        this.e = str;
        this.f = str2;
        this.g = com.heytap.nearx.a.a.a.b.b("imgFileList", list);
        this.h = com.heytap.nearx.a.a.a.b.b("interactiveFileList", list2);
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.d != null) {
            sb.append(", iconFileList=");
            sb.append(this.d);
        }
        if (this.e != null) {
            sb.append(", title=");
            sb.append(this.e);
        }
        if (this.f != null) {
            sb.append(", desc=");
            sb.append(this.f);
        }
        if (!this.g.isEmpty()) {
            sb.append(", imgFileList=");
            sb.append(this.g);
        }
        if (!this.h.isEmpty()) {
            sb.append(", interactiveFileList=");
            sb.append(this.h);
        }
        StringBuilder replace = sb.replace(0, 2, "FloatLayerInfo{");
        replace.append('}');
        return replace.toString();
    }
}
