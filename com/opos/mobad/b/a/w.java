package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/w.class */
public final class w extends com.heytap.nearx.a.a.b<w, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<w> f12080c = new b();
    public static final Integer d = 100;
    private static final long serialVersionUID = 0;
    public final String e;
    public final Integer f;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/w$a.class */
    public static final class a extends b.a<w, a> {

        /* renamed from: c  reason: collision with root package name */
        public String f12081c;
        public Integer d;

        public a a(Integer num) {
            this.d = num;
            return this;
        }

        public a a(String str) {
            this.f12081c = str;
            return this;
        }

        public w b() {
            return new w(this.f12081c, this.d, super.a());
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/w$b.class */
    static final class b extends com.heytap.nearx.a.a.e<w> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, w.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(w wVar) {
            int i = 0;
            int a2 = wVar.e != null ? com.heytap.nearx.a.a.e.p.a(1, (int) wVar.e) : 0;
            if (wVar.f != null) {
                i = com.heytap.nearx.a.a.e.d.a(2, (int) wVar.f);
            }
            return a2 + i + wVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, w wVar) throws IOException {
            if (wVar.e != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, wVar.e);
            }
            if (wVar.f != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 2, wVar.f);
            }
            gVar.a(wVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public w a(com.heytap.nearx.a.a.f fVar) throws IOException {
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

    public w(String str, Integer num, ByteString byteString) {
        super(f12080c, byteString);
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
