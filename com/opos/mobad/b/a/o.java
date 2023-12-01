package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/o.class */
public final class o extends com.heytap.nearx.a.a.b<o, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<o> f25746c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    public static final Float f = Float.valueOf(0.0f);
    private static final long serialVersionUID = 0;
    public final Integer g;
    public final Integer h;
    public final Float i;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/o$a.class */
    public static final class a extends b.a<o, a> {

        /* renamed from: c  reason: collision with root package name */
        public Integer f25747c;
        public Integer d;
        public Float e;

        public a a(Float f) {
            this.e = f;
            return this;
        }

        public a a(Integer num) {
            this.f25747c = num;
            return this;
        }

        public a b(Integer num) {
            this.d = num;
            return this;
        }

        public o b() {
            return new o(this.f25747c, this.d, this.e, super.a());
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/o$b.class */
    static final class b extends com.heytap.nearx.a.a.e<o> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, o.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(o oVar) {
            int i = 0;
            int a2 = oVar.g != null ? com.heytap.nearx.a.a.e.d.a(1, (int) oVar.g) : 0;
            int a3 = oVar.h != null ? com.heytap.nearx.a.a.e.d.a(2, (int) oVar.h) : 0;
            if (oVar.i != null) {
                i = com.heytap.nearx.a.a.e.n.a(3, (int) oVar.i);
            }
            return a2 + a3 + i + oVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, o oVar) throws IOException {
            if (oVar.g != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 1, oVar.g);
            }
            if (oVar.h != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 2, oVar.h);
            }
            if (oVar.i != null) {
                com.heytap.nearx.a.a.e.n.a(gVar, 3, oVar.i);
            }
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
                } else if (b == 2) {
                    aVar.b(com.heytap.nearx.a.a.e.d.a(fVar));
                } else if (b != 3) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b, c2, c2.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.a.a.e.n.a(fVar));
                }
            }
        }
    }

    public o(Integer num, Integer num2, Float f2, ByteString byteString) {
        super(f25746c, byteString);
        this.g = num;
        this.h = num2;
        this.i = f2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.g != null) {
            sb.append(", height=");
            sb.append(this.g);
        }
        if (this.h != null) {
            sb.append(", width=");
            sb.append(this.h);
        }
        if (this.i != null) {
            sb.append(", density=");
            sb.append(this.i);
        }
        StringBuilder replace = sb.replace(0, 2, "DevScreen{");
        replace.append('}');
        return replace.toString();
    }
}
