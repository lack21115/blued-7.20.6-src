package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import com.heytap.nearx.a.a.e;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/p.class */
public final class p extends com.heytap.nearx.a.a.b<p, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<p> f25748c = new d();
    public static final b d = b.CONNECTION_UNKNOWN;
    public static final c e = c.UNKNOWN_OPERATOR;
    public static final Integer f = 0;
    public static final Integer g = 0;
    private static final long serialVersionUID = 0;
    public final b h;
    public final c i;
    public final Integer j;
    public final k k;
    public final Integer l;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/p$a.class */
    public static final class a extends b.a<p, a> {

        /* renamed from: c  reason: collision with root package name */
        public b f25749c;
        public c d;
        public Integer e;
        public k f;
        public Integer g;

        public a a(k kVar) {
            this.f = kVar;
            return this;
        }

        public a a(b bVar) {
            this.f25749c = bVar;
            return this;
        }

        public a a(c cVar) {
            this.d = cVar;
            return this;
        }

        public a a(Integer num) {
            this.e = num;
            return this;
        }

        public a b(Integer num) {
            this.g = num;
            return this;
        }

        public p b() {
            return new p(this.f25749c, this.d, this.e, this.f, this.g, super.a());
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/p$b.class */
    public enum b implements com.heytap.nearx.a.a.i {
        CONNECTION_UNKNOWN(0),
        CELL_2G(2),
        CELL_3G(3),
        CELL_4G(4),
        WIFI(100),
        NEW_TYPE(999);
        
        public static final com.heytap.nearx.a.a.e<b> g = com.heytap.nearx.a.a.e.a(b.class);
        private final int h;

        b(int i2) {
            this.h = i2;
        }

        public static b fromValue(int i2) {
            if (i2 != 0) {
                if (i2 != 100) {
                    if (i2 != 999) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                if (i2 != 4) {
                                    return null;
                                }
                                return CELL_4G;
                            }
                            return CELL_3G;
                        }
                        return CELL_2G;
                    }
                    return NEW_TYPE;
                }
                return WIFI;
            }
            return CONNECTION_UNKNOWN;
        }

        @Override // com.heytap.nearx.a.a.i
        public int a() {
            return this.h;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/p$c.class */
    public enum c implements com.heytap.nearx.a.a.i {
        UNKNOWN_OPERATOR(0),
        CHINA_MOBILE(1),
        CHINA_TELECOM(2),
        CHINA_UNICOM(3);
        
        public static final com.heytap.nearx.a.a.e<c> e = com.heytap.nearx.a.a.e.a(c.class);
        private final int f;

        c(int i) {
            this.f = i;
        }

        public static c fromValue(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return CHINA_UNICOM;
                    }
                    return CHINA_TELECOM;
                }
                return CHINA_MOBILE;
            }
            return UNKNOWN_OPERATOR;
        }

        @Override // com.heytap.nearx.a.a.i
        public int a() {
            return this.f;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/p$d.class */
    static final class d extends com.heytap.nearx.a.a.e<p> {
        d() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, p.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(p pVar) {
            int i = 0;
            int a2 = pVar.h != null ? b.g.a(1, (int) pVar.h) : 0;
            int a3 = pVar.i != null ? c.e.a(2, (int) pVar.i) : 0;
            int a4 = pVar.j != null ? com.heytap.nearx.a.a.e.d.a(3, (int) pVar.j) : 0;
            int a5 = pVar.k != null ? k.f25738c.a(4, (int) pVar.k) : 0;
            if (pVar.l != null) {
                i = com.heytap.nearx.a.a.e.d.a(5, (int) pVar.l);
            }
            return a5 + a3 + a2 + a4 + i + pVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, p pVar) throws IOException {
            if (pVar.h != null) {
                b.g.a(gVar, 1, pVar.h);
            }
            if (pVar.i != null) {
                c.e.a(gVar, 2, pVar.i);
            }
            if (pVar.j != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 3, pVar.j);
            }
            if (pVar.k != null) {
                k.f25738c.a(gVar, 4, pVar.k);
            }
            if (pVar.l != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 5, pVar.l);
            }
            gVar.a(pVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public p a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b = fVar.b();
                if (b == -1) {
                    fVar.a(a2);
                    return aVar.b();
                } else if (b == 1) {
                    aVar.a(b.g.a(fVar));
                } else if (b == 2) {
                    try {
                        aVar.a(c.e.a(fVar));
                    } catch (e.a e) {
                        aVar.a(b, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e.f22263a));
                    }
                } else if (b == 3) {
                    aVar.a(com.heytap.nearx.a.a.e.d.a(fVar));
                } else if (b == 4) {
                    aVar.a(k.f25738c.a(fVar));
                } else if (b != 5) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b, c2, c2.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.d.a(fVar));
                }
            }
        }
    }

    public p(b bVar, c cVar, Integer num, k kVar, Integer num2, ByteString byteString) {
        super(f25748c, byteString);
        this.h = bVar;
        this.i = cVar;
        this.j = num;
        this.k = kVar;
        this.l = num2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.h != null) {
            sb.append(", netType=");
            sb.append(this.h);
        }
        if (this.i != null) {
            sb.append(", operator=");
            sb.append(this.i);
        }
        if (this.j != null) {
            sb.append(", ori=");
            sb.append(this.j);
        }
        if (this.k != null) {
            sb.append(", devGps=");
            sb.append(this.k);
        }
        if (this.l != null) {
            sb.append(", linkSpeed=");
            sb.append(this.l);
        }
        StringBuilder replace = sb.replace(0, 2, "DevStatus{");
        replace.append('}');
        return replace.toString();
    }
}
