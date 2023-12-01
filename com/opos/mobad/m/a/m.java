package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/m.class */
public final class m extends com.heytap.nearx.a.a.b<m, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<m> f12663c = new b();
    public static final Integer d = 100;
    private static final long serialVersionUID = 0;
    public final String e;
    public final Integer f;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/m$a.class */
    public static final class a extends b.a<m, a> {

        /* renamed from: c  reason: collision with root package name */
        public String f12664c;
        public Integer d;

        public a a(Integer num) {
            this.d = num;
            return this;
        }

        public a a(String str) {
            this.f12664c = str;
            return this;
        }

        public m b() {
            return new m(this.f12664c, this.d, super.a());
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/m$b.class */
    static final class b extends com.heytap.nearx.a.a.e<m> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, m.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(m mVar) {
            int i = 0;
            int a2 = mVar.e != null ? com.heytap.nearx.a.a.e.p.a(1, (int) mVar.e) : 0;
            if (mVar.f != null) {
                i = com.heytap.nearx.a.a.e.d.a(2, (int) mVar.f);
            }
            return a2 + i + mVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, m mVar) throws IOException {
            if (mVar.e != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, mVar.e);
            }
            if (mVar.f != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 2, mVar.f);
            }
            gVar.a(mVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public m a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                    aVar.a(com.heytap.nearx.a.a.e.d.a(fVar));
                }
            }
        }
    }

    public m(String str, Integer num, ByteString byteString) {
        super(f12663c, byteString);
        this.e = str;
        this.f = num;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.e != null) {
            sb.append(", verName=");
            sb.append(this.e);
        }
        if (this.f != null) {
            sb.append(", verCode=");
            sb.append(this.f);
        }
        StringBuilder replace = sb.replace(0, 2, "MarketInfo{");
        replace.append('}');
        return replace.toString();
    }
}
