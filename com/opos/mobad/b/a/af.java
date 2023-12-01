package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/af.class */
public final class af extends com.heytap.nearx.a.a.b<af, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<af> f12012c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    private static final long serialVersionUID = 0;
    public final Integer f;
    public final Integer g;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/af$a.class */
    public static final class a extends b.a<af, a> {

        /* renamed from: c  reason: collision with root package name */
        public Integer f12013c;
        public Integer d;

        public a a(Integer num) {
            this.f12013c = num;
            return this;
        }

        public a b(Integer num) {
            this.d = num;
            return this;
        }

        public af b() {
            Integer num;
            Integer num2 = this.f12013c;
            if (num2 == null || (num = this.d) == null) {
                throw com.heytap.nearx.a.a.a.b.a(this.f12013c, "code", this.d, "validTime");
            }
            return new af(num2, num, super.a());
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/af$b.class */
    static final class b extends com.heytap.nearx.a.a.e<af> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, af.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(af afVar) {
            return com.heytap.nearx.a.a.e.d.a(1, (int) afVar.f) + com.heytap.nearx.a.a.e.d.a(10, (int) afVar.g) + afVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, af afVar) throws IOException {
            com.heytap.nearx.a.a.e.d.a(gVar, 1, afVar.f);
            com.heytap.nearx.a.a.e.d.a(gVar, 10, afVar.g);
            gVar.a(afVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public af a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b = fVar.b();
                if (b == -1) {
                    fVar.a(a2);
                    return aVar.b();
                } else if (b == 1) {
                    aVar.a(com.heytap.nearx.a.a.e.d.a(fVar));
                } else if (b != 10) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b, c2, c2.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.d.a(fVar));
                }
            }
        }
    }

    public af(Integer num, Integer num2, ByteString byteString) {
        super(f12012c, byteString);
        this.f = num;
        this.g = num2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", code=");
        sb.append(this.f);
        sb.append(", validTime=");
        sb.append(this.g);
        StringBuilder replace = sb.replace(0, 2, "StateResponse{");
        replace.append('}');
        return replace.toString();
    }
}
