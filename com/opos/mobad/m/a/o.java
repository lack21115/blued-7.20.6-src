package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import com.huawei.openalliance.ad.constant.at;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/o.class */
public final class o extends com.heytap.nearx.a.a.b<o, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<o> f26355c = new b();
    public static final Integer d = 0;
    private static final long serialVersionUID = 0;
    public final Integer e;
    public final String f;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/o$a.class */
    public static final class a extends b.a<o, a> {

        /* renamed from: c  reason: collision with root package name */
        public Integer f26356c;
        public String d;

        public a a(Integer num) {
            this.f26356c = num;
            return this;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public o b() {
            String str;
            Integer num = this.f26356c;
            if (num == null || (str = this.d) == null) {
                throw com.heytap.nearx.a.a.a.b.a(this.f26356c, at.C, this.d, "dyMaterialUrl");
            }
            return new o(num, str, super.a());
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/o$b.class */
    static final class b extends com.heytap.nearx.a.a.e<o> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, o.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(o oVar) {
            return com.heytap.nearx.a.a.e.d.a(1, (int) oVar.e) + com.heytap.nearx.a.a.e.p.a(2, (int) oVar.f) + oVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, o oVar) throws IOException {
            com.heytap.nearx.a.a.e.d.a(gVar, 1, oVar.e);
            com.heytap.nearx.a.a.e.p.a(gVar, 2, oVar.f);
            gVar.a(oVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public o a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public o(Integer num, String str, ByteString byteString) {
        super(f26355c, byteString);
        this.e = num;
        this.f = str;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", templateId=");
        sb.append(this.e);
        sb.append(", dyMaterialUrl=");
        sb.append(this.f);
        StringBuilder replace = sb.replace(0, 2, "PreLoadResource{");
        replace.append('}');
        return replace.toString();
    }
}
