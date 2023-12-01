package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/a.class */
public final class a extends com.heytap.nearx.a.a.b<a, C0535a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<a> f12639c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    public static final Integer f = 0;
    public static final Integer g = 0;
    private static final long serialVersionUID = 0;
    public final Integer h;
    public final Integer i;
    public final Integer j;
    public final Integer k;

    /* renamed from: com.opos.mobad.m.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/a$a.class */
    public static final class C0535a extends b.a<a, C0535a> {

        /* renamed from: c  reason: collision with root package name */
        public Integer f12640c;
        public Integer d;
        public Integer e;
        public Integer f;

        public C0535a a(Integer num) {
            this.f12640c = num;
            return this;
        }

        public C0535a b(Integer num) {
            this.d = num;
            return this;
        }

        public a b() {
            Integer num = this.f12640c;
            if (num != null) {
                return new a(num, this.d, this.e, this.f, super.a());
            }
            throw com.heytap.nearx.a.a.a.b.a(num, "concurrentTimeout");
        }

        public C0535a c(Integer num) {
            this.e = num;
            return this;
        }

        public C0535a d(Integer num) {
            this.f = num;
            return this;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/a$b.class */
    static final class b extends com.heytap.nearx.a.a.e<a> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, a.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(a aVar) {
            int a2 = com.heytap.nearx.a.a.e.d.a(1, (int) aVar.h);
            int i = 0;
            int a3 = aVar.i != null ? com.heytap.nearx.a.a.e.d.a(2, (int) aVar.i) : 0;
            int a4 = aVar.j != null ? com.heytap.nearx.a.a.e.d.a(3, (int) aVar.j) : 0;
            if (aVar.k != null) {
                i = com.heytap.nearx.a.a.e.d.a(4, (int) aVar.k);
            }
            return a4 + a2 + a3 + i + aVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, a aVar) throws IOException {
            com.heytap.nearx.a.a.e.d.a(gVar, 1, aVar.h);
            if (aVar.i != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 2, aVar.i);
            }
            if (aVar.j != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 3, aVar.j);
            }
            if (aVar.k != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 4, aVar.k);
            }
            gVar.a(aVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public a a(com.heytap.nearx.a.a.f fVar) throws IOException {
            C0535a c0535a = new C0535a();
            long a2 = fVar.a();
            while (true) {
                int b = fVar.b();
                if (b == -1) {
                    fVar.a(a2);
                    return c0535a.b();
                } else if (b == 1) {
                    c0535a.a(com.heytap.nearx.a.a.e.d.a(fVar));
                } else if (b == 2) {
                    c0535a.b(com.heytap.nearx.a.a.e.d.a(fVar));
                } else if (b == 3) {
                    c0535a.c(com.heytap.nearx.a.a.e.d.a(fVar));
                } else if (b != 4) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    c0535a.a(b, c2, c2.a().a(fVar));
                } else {
                    c0535a.d(com.heytap.nearx.a.a.e.d.a(fVar));
                }
            }
        }
    }

    public a(Integer num, Integer num2, Integer num3, Integer num4, ByteString byteString) {
        super(f12639c, byteString);
        this.h = num;
        this.i = num2;
        this.j = num3;
        this.k = num4;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", concurrentTimeout=");
        sb.append(this.h);
        if (this.i != null) {
            sb.append(", syncPriorityTimeout=");
            sb.append(this.i);
        }
        if (this.j != null) {
            sb.append(", shakeSensorTime=");
            sb.append(this.j);
        }
        if (this.k != null) {
            sb.append(", shakeSensorDiff=");
            sb.append(this.k);
        }
        StringBuilder replace = sb.replace(0, 2, "AdConfig{");
        replace.append('}');
        return replace.toString();
    }
}
