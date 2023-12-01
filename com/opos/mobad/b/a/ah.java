package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/ah.class */
public final class ah extends com.heytap.nearx.a.a.b<ah, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<ah> f12018c = new b();
    public static final Boolean d = false;
    private static final long serialVersionUID = 0;
    public final Boolean e;
    public final String f;
    public final String g;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/ah$a.class */
    public static final class a extends b.a<ah, a> {

        /* renamed from: c  reason: collision with root package name */
        public Boolean f12019c;
        public String d;
        public String e;

        public a a(Boolean bool) {
            this.f12019c = bool;
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

        public ah b() {
            return new ah(this.f12019c, this.d, this.e, super.a());
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/ah$b.class */
    static final class b extends com.heytap.nearx.a.a.e<ah> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, ah.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(ah ahVar) {
            int i = 0;
            int a2 = ahVar.e != null ? com.heytap.nearx.a.a.e.f8653c.a(1, (int) ahVar.e) : 0;
            int a3 = ahVar.f != null ? com.heytap.nearx.a.a.e.p.a(2, (int) ahVar.f) : 0;
            if (ahVar.g != null) {
                i = com.heytap.nearx.a.a.e.p.a(3, (int) ahVar.g);
            }
            return a2 + a3 + i + ahVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, ah ahVar) throws IOException {
            if (ahVar.e != null) {
                com.heytap.nearx.a.a.e.f8653c.a(gVar, 1, ahVar.e);
            }
            if (ahVar.f != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, ahVar.f);
            }
            if (ahVar.g != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, ahVar.g);
            }
            gVar.a(ahVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public ah a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b = fVar.b();
                if (b == -1) {
                    fVar.a(a2);
                    return aVar.b();
                } else if (b == 1) {
                    aVar.a(com.heytap.nearx.a.a.e.f8653c.a(fVar));
                } else if (b == 2) {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b != 3) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b, c2, c2.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public ah(Boolean bool, String str, String str2, ByteString byteString) {
        super(f12018c, byteString);
        this.e = bool;
        this.f = str;
        this.g = str2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.e != null) {
            sb.append(", installed=");
            sb.append(this.e);
        }
        if (this.f != null) {
            sb.append(", version=");
            sb.append(this.f);
        }
        if (this.g != null) {
            sb.append(", sdkVersion=");
            sb.append(this.g);
        }
        StringBuilder replace = sb.replace(0, 2, "XgameInfo{");
        replace.append('}');
        return replace.toString();
    }
}
