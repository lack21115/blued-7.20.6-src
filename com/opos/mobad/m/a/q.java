package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/q.class */
public final class q extends com.heytap.nearx.a.a.b<q, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<q> f26359c = new b();
    public static final Integer d = 0;
    public static final Long e = 0L;
    private static final long serialVersionUID = 0;
    public final Integer f;
    public final String g;
    public final r h;
    public final Long i;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/q$a.class */
    public static final class a extends b.a<q, a> {

        /* renamed from: c  reason: collision with root package name */
        public Integer f26360c;
        public String d;
        public r e;
        public Long f;

        public a a(r rVar) {
            this.e = rVar;
            return this;
        }

        public a a(Integer num) {
            this.f26360c = num;
            return this;
        }

        public a a(Long l) {
            this.f = l;
            return this;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public q b() {
            if (this.f26360c == null || this.f == null) {
                throw com.heytap.nearx.a.a.a.b.a(this.f26360c, "code", this.f, "deadLineTime");
            }
            return new q(this.f26360c, this.d, this.e, this.f, super.a());
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/q$b.class */
    static final class b extends com.heytap.nearx.a.a.e<q> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, q.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(q qVar) {
            int a2 = com.heytap.nearx.a.a.e.d.a(1, (int) qVar.f);
            int i = 0;
            int a3 = qVar.g != null ? com.heytap.nearx.a.a.e.p.a(2, (int) qVar.g) : 0;
            if (qVar.h != null) {
                i = r.f26361c.a(3, (int) qVar.h);
            }
            return a3 + a2 + i + com.heytap.nearx.a.a.e.i.a(4, (int) qVar.i) + qVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, q qVar) throws IOException {
            com.heytap.nearx.a.a.e.d.a(gVar, 1, qVar.f);
            if (qVar.g != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, qVar.g);
            }
            if (qVar.h != null) {
                r.f26361c.a(gVar, 3, qVar.h);
            }
            com.heytap.nearx.a.a.e.i.a(gVar, 4, qVar.i);
            gVar.a(qVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public q a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                    aVar.a(r.f26361c.a(fVar));
                } else if (b != 4) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b, c2, c2.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.a.a.e.i.a(fVar));
                }
            }
        }
    }

    public q(Integer num, String str, r rVar, Long l, ByteString byteString) {
        super(f26359c, byteString);
        this.f = num;
        this.g = str;
        this.h = rVar;
        this.i = l;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", code=");
        sb.append(this.f);
        if (this.g != null) {
            sb.append(", msg=");
            sb.append(this.g);
        }
        if (this.h != null) {
            sb.append(", responseInfo=");
            sb.append(this.h);
        }
        sb.append(", deadLineTime=");
        sb.append(this.i);
        StringBuilder replace = sb.replace(0, 2, "Response{");
        replace.append('}');
        return replace.toString();
    }
}
