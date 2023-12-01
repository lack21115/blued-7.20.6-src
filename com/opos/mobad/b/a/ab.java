package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/ab.class */
public final class ab extends com.heytap.nearx.a.a.b<ab, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<ab> f25692c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    public static final Integer f = 0;
    private static final long serialVersionUID = 0;
    public final Integer g;
    public final String h;
    public final Integer i;
    public final Integer j;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/ab$a.class */
    public static final class a extends b.a<ab, a> {

        /* renamed from: c  reason: collision with root package name */
        public Integer f25693c;
        public String d;
        public Integer e;
        public Integer f;

        public a a(Integer num) {
            this.f25693c = num;
            return this;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public a b(Integer num) {
            this.e = num;
            return this;
        }

        public ab b() {
            return new ab(this.f25693c, this.d, this.e, this.f, super.a());
        }

        public a c(Integer num) {
            this.f = num;
            return this;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/ab$b.class */
    static final class b extends com.heytap.nearx.a.a.e<ab> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, ab.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(ab abVar) {
            int i = 0;
            int a2 = abVar.g != null ? com.heytap.nearx.a.a.e.d.a(1, (int) abVar.g) : 0;
            int a3 = abVar.h != null ? com.heytap.nearx.a.a.e.p.a(2, (int) abVar.h) : 0;
            int a4 = abVar.i != null ? com.heytap.nearx.a.a.e.d.a(3, (int) abVar.i) : 0;
            if (abVar.j != null) {
                i = com.heytap.nearx.a.a.e.d.a(4, (int) abVar.j);
            }
            return a4 + a3 + a2 + i + abVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, ab abVar) throws IOException {
            if (abVar.g != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 1, abVar.g);
            }
            if (abVar.h != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, abVar.h);
            }
            if (abVar.i != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 3, abVar.i);
            }
            if (abVar.j != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 4, abVar.j);
            }
            gVar.a(abVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public ab a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b == 3) {
                    aVar.b(com.heytap.nearx.a.a.e.d.a(fVar));
                } else if (b != 4) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b, c2, c2.a().a(fVar));
                } else {
                    aVar.c(com.heytap.nearx.a.a.e.d.a(fVar));
                }
            }
        }
    }

    public ab(Integer num, String str, Integer num2, Integer num3, ByteString byteString) {
        super(f25692c, byteString);
        this.g = num;
        this.h = str;
        this.i = num2;
        this.j = num3;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.g != null) {
            sb.append(", verCode=");
            sb.append(this.g);
        }
        if (this.h != null) {
            sb.append(", verName=");
            sb.append(this.h);
        }
        if (this.i != null) {
            sb.append(", cVerCode=");
            sb.append(this.i);
        }
        if (this.j != null) {
            sb.append(", statSdkVc=");
            sb.append(this.j);
        }
        StringBuilder replace = sb.replace(0, 2, "SdkInfo{");
        replace.append('}');
        return replace.toString();
    }
}
