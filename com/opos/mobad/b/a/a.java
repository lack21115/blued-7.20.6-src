package com.opos.mobad.b.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.heytap.nearx.a.a.b;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/a.class */
public final class a extends com.heytap.nearx.a.a.b<a, C0673a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<a> f25688c = new b();
    public static final Integer d = 0;
    private static final long serialVersionUID = 0;
    public final String e;
    public final String f;
    public final List<e> g;
    public final Integer h;

    /* renamed from: com.opos.mobad.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/a$a.class */
    public static final class C0673a extends b.a<a, C0673a> {

        /* renamed from: c  reason: collision with root package name */
        public String f25689c;
        public String d;
        public List<e> e = com.heytap.nearx.a.a.a.b.a();
        public Integer f;

        public C0673a a(Integer num) {
            this.f = num;
            return this;
        }

        public C0673a a(String str) {
            this.f25689c = str;
            return this;
        }

        public C0673a b(String str) {
            this.d = str;
            return this;
        }

        public a b() {
            String str;
            Integer num;
            String str2 = this.f25689c;
            if (str2 == null || (str = this.d) == null || (num = this.f) == null) {
                throw com.heytap.nearx.a.a.a.b.a(this.f25689c, "pkgName", this.d, TypedValues.AttributesType.S_TARGET, this.f, "minVerCode");
            }
            return new a(str2, str, this.e, num, super.a());
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/a$b.class */
    static final class b extends com.heytap.nearx.a.a.e<a> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, a.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(a aVar) {
            return com.heytap.nearx.a.a.e.p.a(1, (int) aVar.e) + com.heytap.nearx.a.a.e.p.a(2, (int) aVar.f) + e.f25726c.a().a(3, (int) aVar.g) + com.heytap.nearx.a.a.e.d.a(4, (int) aVar.h) + aVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, a aVar) throws IOException {
            com.heytap.nearx.a.a.e.p.a(gVar, 1, aVar.e);
            com.heytap.nearx.a.a.e.p.a(gVar, 2, aVar.f);
            e.f25726c.a().a(gVar, 3, aVar.g);
            com.heytap.nearx.a.a.e.d.a(gVar, 4, aVar.h);
            gVar.a(aVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public a a(com.heytap.nearx.a.a.f fVar) throws IOException {
            C0673a c0673a = new C0673a();
            long a2 = fVar.a();
            while (true) {
                int b = fVar.b();
                if (b == -1) {
                    fVar.a(a2);
                    return c0673a.b();
                } else if (b == 1) {
                    c0673a.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b == 2) {
                    c0673a.b(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b == 3) {
                    c0673a.e.add(e.f25726c.a(fVar));
                } else if (b != 4) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    c0673a.a(b, c2, c2.a().a(fVar));
                } else {
                    c0673a.a(com.heytap.nearx.a.a.e.d.a(fVar));
                }
            }
        }
    }

    public a(String str, String str2, List<e> list, Integer num, ByteString byteString) {
        super(f25688c, byteString);
        this.e = str;
        this.f = str2;
        this.g = com.heytap.nearx.a.a.a.b.b("signerList", list);
        this.h = num;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", pkgName=");
        sb.append(this.e);
        sb.append(", target=");
        sb.append(this.f);
        if (!this.g.isEmpty()) {
            sb.append(", signerList=");
            sb.append(this.g);
        }
        sb.append(", minVerCode=");
        sb.append(this.h);
        StringBuilder replace = sb.replace(0, 2, "ActivatingInfo{");
        replace.append('}');
        return replace.toString();
    }
}
