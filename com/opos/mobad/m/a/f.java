package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import com.heytap.nearx.a.a.e;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/f.class */
public final class f extends com.heytap.nearx.a.a.b<f, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<f> f26337c = new b();
    public static final Integer d = 0;
    public static final Long e = 0L;
    public static final c f = c.UNKNOWN;
    public static final Integer g = 0;
    public static final Integer h = 0;
    public static final Integer i = 0;
    private static final long serialVersionUID = 0;
    public final String j;
    public final Integer k;
    public final Long l;
    public final c m;
    public final Integer n;
    public final Integer o;
    public final Integer p;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/f$a.class */
    public static final class a extends b.a<f, a> {

        /* renamed from: c  reason: collision with root package name */
        public String f26338c;
        public Integer d;
        public Long e;
        public c f;
        public Integer g;
        public Integer h;
        public Integer i;

        public a a(c cVar) {
            this.f = cVar;
            return this;
        }

        public a a(Integer num) {
            this.d = num;
            return this;
        }

        public a a(Long l) {
            this.e = l;
            return this;
        }

        public a a(String str) {
            this.f26338c = str;
            return this;
        }

        public a b(Integer num) {
            this.g = num;
            return this;
        }

        public f b() {
            Integer num;
            Long l;
            c cVar;
            String str = this.f26338c;
            if (str == null || (num = this.d) == null || (l = this.e) == null || (cVar = this.f) == null) {
                throw com.heytap.nearx.a.a.a.b.a(this.f26338c, "channelPosId", this.d, "percent", this.e, "timeout", this.f, "channel");
            }
            return new f(str, num, l, cVar, this.g, this.h, this.i, super.a());
        }

        public a c(Integer num) {
            this.h = num;
            return this;
        }

        public a d(Integer num) {
            this.i = num;
            return this;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/f$b.class */
    static final class b extends com.heytap.nearx.a.a.e<f> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, f.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(f fVar) {
            int a2 = com.heytap.nearx.a.a.e.p.a(1, (int) fVar.j);
            int a3 = com.heytap.nearx.a.a.e.d.a(2, (int) fVar.k);
            int a4 = com.heytap.nearx.a.a.e.i.a(3, (int) fVar.l);
            int a5 = c.j.a(4, (int) fVar.m);
            int i = 0;
            int a6 = fVar.n != null ? com.heytap.nearx.a.a.e.d.a(5, (int) fVar.n) : 0;
            int a7 = fVar.o != null ? com.heytap.nearx.a.a.e.d.a(6, (int) fVar.o) : 0;
            if (fVar.p != null) {
                i = com.heytap.nearx.a.a.e.d.a(7, (int) fVar.p);
            }
            return a7 + a5 + a2 + a3 + a4 + a6 + i + fVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, f fVar) throws IOException {
            com.heytap.nearx.a.a.e.p.a(gVar, 1, fVar.j);
            com.heytap.nearx.a.a.e.d.a(gVar, 2, fVar.k);
            com.heytap.nearx.a.a.e.i.a(gVar, 3, fVar.l);
            c.j.a(gVar, 4, fVar.m);
            if (fVar.n != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 5, fVar.n);
            }
            if (fVar.o != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 6, fVar.o);
            }
            if (fVar.p != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 7, fVar.p);
            }
            gVar.a(fVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public f a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b = fVar.b();
                if (b == -1) {
                    fVar.a(a2);
                    return aVar.b();
                }
                switch (b) {
                    case 1:
                        aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 2:
                        aVar.a(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 3:
                        aVar.a(com.heytap.nearx.a.a.e.i.a(fVar));
                        break;
                    case 4:
                        try {
                            aVar.a(c.j.a(fVar));
                            break;
                        } catch (e.a e) {
                            aVar.a(b, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e.f22263a));
                            break;
                        }
                    case 5:
                        aVar.b(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 6:
                        aVar.c(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 7:
                        aVar.d(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a c2 = fVar.c();
                        aVar.a(b, c2, c2.a().a(fVar));
                        break;
                }
            }
        }
    }

    public f(String str, Integer num, Long l, c cVar, Integer num2, Integer num3, Integer num4, ByteString byteString) {
        super(f26337c, byteString);
        this.j = str;
        this.k = num;
        this.l = l;
        this.m = cVar;
        this.n = num2;
        this.o = num3;
        this.p = num4;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", channelPosId=");
        sb.append(this.j);
        sb.append(", percent=");
        sb.append(this.k);
        sb.append(", timeout=");
        sb.append(this.l);
        sb.append(", channel=");
        sb.append(this.m);
        if (this.n != null) {
            sb.append(", imgHeight=");
            sb.append(this.n);
        }
        if (this.o != null) {
            sb.append(", imgWidth=");
            sb.append(this.o);
        }
        if (this.p != null) {
            sb.append(", posEcpm=");
            sb.append(this.p);
        }
        StringBuilder replace = sb.replace(0, 2, "ChannelStrategy{");
        replace.append('}');
        return replace.toString();
    }
}
