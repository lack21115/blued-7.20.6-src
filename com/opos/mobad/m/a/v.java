package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import com.heytap.nearx.a.a.e;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/v.class */
public final class v extends com.heytap.nearx.a.a.b<v, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<v> f26369c = new b();
    public static final Integer d = 0;
    public static final w e = w.UNKNOWN_STATUS;
    public static final Boolean f = false;
    private static final long serialVersionUID = 0;
    public final Integer g;
    public final w h;
    public final Boolean i;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/v$a.class */
    public static final class a extends b.a<v, a> {

        /* renamed from: c  reason: collision with root package name */
        public Integer f26370c;
        public w d;
        public Boolean e;

        public a a(w wVar) {
            this.d = wVar;
            return this;
        }

        public a a(Boolean bool) {
            this.e = bool;
            return this;
        }

        public a a(Integer num) {
            this.f26370c = num;
            return this;
        }

        public v b() {
            w wVar;
            Boolean bool;
            Integer num = this.f26370c;
            if (num == null || (wVar = this.d) == null || (bool = this.e) == null) {
                throw com.heytap.nearx.a.a.a.b.a(this.f26370c, "code", this.d, "vipStatus", this.e, "rightValid");
            }
            return new v(num, wVar, bool, super.a());
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/v$b.class */
    static final class b extends com.heytap.nearx.a.a.e<v> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, v.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(v vVar) {
            return com.heytap.nearx.a.a.e.d.a(1, (int) vVar.g) + w.d.a(2, (int) vVar.h) + com.heytap.nearx.a.a.e.f22261c.a(3, (int) vVar.i) + vVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, v vVar) throws IOException {
            com.heytap.nearx.a.a.e.d.a(gVar, 1, vVar.g);
            w.d.a(gVar, 2, vVar.h);
            com.heytap.nearx.a.a.e.f22261c.a(gVar, 3, vVar.i);
            gVar.a(vVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public v a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b = fVar.b();
                if (b == -1) {
                    fVar.a(a2);
                    return aVar.b();
                } else if (b == 1) {
                    aVar.a(com.heytap.nearx.a.a.e.d.a(fVar));
                } else if (b == 2) {
                    try {
                        aVar.a(w.d.a(fVar));
                    } catch (e.a e) {
                        aVar.a(b, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e.f22263a));
                    }
                } else if (b != 3) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b, c2, c2.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.a.a.e.f22261c.a(fVar));
                }
            }
        }
    }

    public v(Integer num, w wVar, Boolean bool, ByteString byteString) {
        super(f26369c, byteString);
        this.g = num;
        this.h = wVar;
        this.i = bool;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", code=");
        sb.append(this.g);
        sb.append(", vipStatus=");
        sb.append(this.h);
        sb.append(", rightValid=");
        sb.append(this.i);
        StringBuilder replace = sb.replace(0, 2, "VipInfoResponse{");
        replace.append('}');
        return replace.toString();
    }
}
