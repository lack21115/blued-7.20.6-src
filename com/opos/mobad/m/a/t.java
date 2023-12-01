package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import com.heytap.nearx.a.a.e;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/t.class */
public final class t extends com.heytap.nearx.a.a.b<t, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<t> f12677c = new b();
    public static final w d = w.UNKNOWN_STATUS;
    private static final long serialVersionUID = 0;
    public final String e;
    public final w f;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/t$a.class */
    public static final class a extends b.a<t, a> {

        /* renamed from: c  reason: collision with root package name */
        public String f12678c;
        public w d;

        public a a(w wVar) {
            this.d = wVar;
            return this;
        }

        public a a(String str) {
            this.f12678c = str;
            return this;
        }

        public t b() {
            String str = this.f12678c;
            if (str != null) {
                return new t(this.f12678c, this.d, super.a());
            }
            throw com.heytap.nearx.a.a.a.b.a(str, "token");
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/t$b.class */
    static final class b extends com.heytap.nearx.a.a.e<t> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, t.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(t tVar) {
            return (tVar.f != null ? w.d.a(2, (int) tVar.f) : 0) + com.heytap.nearx.a.a.e.p.a(1, (int) tVar.e) + tVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, t tVar) throws IOException {
            com.heytap.nearx.a.a.e.p.a(gVar, 1, tVar.e);
            if (tVar.f != null) {
                w.d.a(gVar, 2, tVar.f);
            }
            gVar.a(tVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public t a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                    try {
                        aVar.a(w.d.a(fVar));
                    } catch (e.a e) {
                        aVar.a(b, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e.f8655a));
                    }
                }
            }
        }
    }

    public t(String str, w wVar, ByteString byteString) {
        super(f12677c, byteString);
        this.e = str;
        this.f = wVar;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", token=");
        sb.append(this.e);
        if (this.f != null) {
            sb.append(", vipStatus=");
            sb.append(this.f);
        }
        StringBuilder replace = sb.replace(0, 2, "UserAccountInfo{");
        replace.append('}');
        return replace.toString();
    }
}
