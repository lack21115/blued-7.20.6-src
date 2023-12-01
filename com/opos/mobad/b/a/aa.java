package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/aa.class */
public final class aa extends com.heytap.nearx.a.a.b<aa, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<aa> f25690c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    private static final long serialVersionUID = 0;
    public final Integer f;
    public final Integer g;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/aa$a.class */
    public static final class a extends b.a<aa, a> {

        /* renamed from: c  reason: collision with root package name */
        public Integer f25691c;
        public Integer d;

        public a a(Integer num) {
            this.f25691c = num;
            return this;
        }

        public a b(Integer num) {
            this.d = num;
            return this;
        }

        public aa b() {
            return new aa(this.f25691c, this.d, super.a());
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/aa$b.class */
    static final class b extends com.heytap.nearx.a.a.e<aa> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, aa.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(aa aaVar) {
            int i = 0;
            int a2 = aaVar.f != null ? com.heytap.nearx.a.a.e.d.a(1, (int) aaVar.f) : 0;
            if (aaVar.g != null) {
                i = com.heytap.nearx.a.a.e.d.a(2, (int) aaVar.g);
            }
            return a2 + i + aaVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, aa aaVar) throws IOException {
            if (aaVar.f != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 1, aaVar.f);
            }
            if (aaVar.g != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 2, aaVar.g);
            }
            gVar.a(aaVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public aa a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b = fVar.b();
                if (b == -1) {
                    fVar.a(a2);
                    return aVar.b();
                } else if (b == 1) {
                    aVar.a(com.heytap.nearx.a.a.e.d.a(fVar));
                } else if (b != 2) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b, c2, c2.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.d.a(fVar));
                }
            }
        }
    }

    public aa(Integer num, Integer num2, ByteString byteString) {
        super(f25690c, byteString);
        this.f = num;
        this.g = num2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f != null) {
            sb.append(", height=");
            sb.append(this.f);
        }
        if (this.g != null) {
            sb.append(", width=");
            sb.append(this.g);
        }
        StringBuilder replace = sb.replace(0, 2, "PosSize{");
        replace.append('}');
        return replace.toString();
    }
}
