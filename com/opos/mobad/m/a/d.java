package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/d.class */
public final class d extends com.heytap.nearx.a.a.b<d, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<d> f26333c = new b();
    public static final Integer d = 0;
    private static final long serialVersionUID = 0;
    public final Integer e;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/d$a.class */
    public static final class a extends b.a<d, a> {

        /* renamed from: c  reason: collision with root package name */
        public Integer f26334c;

        public a a(Integer num) {
            this.f26334c = num;
            return this;
        }

        public d b() {
            Integer num = this.f26334c;
            if (num != null) {
                return new d(num, super.a());
            }
            throw com.heytap.nearx.a.a.a.b.a(num, "cacheInternal");
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/d$b.class */
    static final class b extends com.heytap.nearx.a.a.e<d> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, d.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(d dVar) {
            return com.heytap.nearx.a.a.e.d.a(1, (int) dVar.e) + dVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, d dVar) throws IOException {
            com.heytap.nearx.a.a.e.d.a(gVar, 1, dVar.e);
            gVar.a(dVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public d a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b = fVar.b();
                if (b == -1) {
                    fVar.a(a2);
                    return aVar.b();
                } else if (b != 1) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b, c2, c2.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.a.a.e.d.a(fVar));
                }
            }
        }
    }

    public d(Integer num, ByteString byteString) {
        super(f26333c, byteString);
        this.e = num;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", cacheInternal=");
        sb.append(this.e);
        StringBuilder replace = sb.replace(0, 2, "ChannelAdConfig{");
        replace.append('}');
        return replace.toString();
    }
}
