package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import com.heytap.nearx.a.a.e;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/z.class */
public final class z extends com.heytap.nearx.a.a.b<z, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<z> f12112c = new c();
    public static final b d = b.UNKNOWN;
    public static final ad e = ad.UNKNOWN;
    public static final Integer f = -1;
    private static final long serialVersionUID = 0;
    public final String g;
    public final b h;
    public final aa i;
    public final ad j;
    public final Integer k;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/z$a.class */
    public static final class a extends b.a<z, a> {

        /* renamed from: c  reason: collision with root package name */
        public String f12113c;
        public b d;
        public aa e;
        public ad f;
        public Integer g;

        public a a(aa aaVar) {
            this.e = aaVar;
            return this;
        }

        public a a(ad adVar) {
            this.f = adVar;
            return this;
        }

        public a a(b bVar) {
            this.d = bVar;
            return this;
        }

        public a a(Integer num) {
            this.g = num;
            return this;
        }

        public a a(String str) {
            this.f12113c = str;
            return this;
        }

        public z b() {
            return new z(this.f12113c, this.d, this.e, this.f, this.g, super.a());
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/z$b.class */
    public enum b implements com.heytap.nearx.a.a.i {
        UNKNOWN(0),
        BANNER(1),
        POP_WINDOW(2),
        SPLASH_SCREEN(4),
        RAW(8),
        REWARD_VIDEO(64);
        
        public static final com.heytap.nearx.a.a.e<b> g = com.heytap.nearx.a.a.e.a(b.class);
        private final int h;

        b(int i2) {
            this.h = i2;
        }

        public static b fromValue(int i2) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 4) {
                            if (i2 != 8) {
                                if (i2 != 64) {
                                    return null;
                                }
                                return REWARD_VIDEO;
                            }
                            return RAW;
                        }
                        return SPLASH_SCREEN;
                    }
                    return POP_WINDOW;
                }
                return BANNER;
            }
            return UNKNOWN;
        }

        @Override // com.heytap.nearx.a.a.i
        public int a() {
            return this.h;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/z$c.class */
    static final class c extends com.heytap.nearx.a.a.e<z> {
        c() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, z.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(z zVar) {
            int i = 0;
            int a2 = zVar.g != null ? com.heytap.nearx.a.a.e.p.a(1, (int) zVar.g) : 0;
            int a3 = zVar.h != null ? b.g.a(2, (int) zVar.h) : 0;
            int a4 = zVar.i != null ? aa.f12002c.a(3, (int) zVar.i) : 0;
            int a5 = zVar.j != null ? ad.d.a(4, (int) zVar.j) : 0;
            if (zVar.k != null) {
                i = com.heytap.nearx.a.a.e.d.a(5, (int) zVar.k);
            }
            return a5 + a3 + a2 + a4 + i + zVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, z zVar) throws IOException {
            if (zVar.g != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, zVar.g);
            }
            if (zVar.h != null) {
                b.g.a(gVar, 2, zVar.h);
            }
            if (zVar.i != null) {
                aa.f12002c.a(gVar, 3, zVar.i);
            }
            if (zVar.j != null) {
                ad.d.a(gVar, 4, zVar.j);
            }
            if (zVar.k != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 5, zVar.k);
            }
            gVar.a(zVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public z a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b = fVar.b();
                if (b == -1) {
                    fVar.a(a2);
                    return aVar.b();
                } else if (b == 1) {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b == 2) {
                    aVar.a(b.g.a(fVar));
                } else if (b == 3) {
                    aVar.a(aa.f12002c.a(fVar));
                } else if (b == 4) {
                    try {
                        aVar.a(ad.d.a(fVar));
                    } catch (e.a e) {
                        aVar.a(b, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e.f8655a));
                    }
                } else if (b != 5) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b, c2, c2.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.a.a.e.d.a(fVar));
                }
            }
        }
    }

    public z(String str, b bVar, aa aaVar, ad adVar, Integer num, ByteString byteString) {
        super(f12112c, byteString);
        this.g = str;
        this.h = bVar;
        this.i = aaVar;
        this.j = adVar;
        this.k = num;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.g != null) {
            sb.append(", posId=");
            sb.append(this.g);
        }
        if (this.h != null) {
            sb.append(", posType=");
            sb.append(this.h);
        }
        if (this.i != null) {
            sb.append(", posSize=");
            sb.append(this.i);
        }
        if (this.j != null) {
            sb.append(", startMode=");
            sb.append(this.j);
        }
        if (this.k != null) {
            sb.append(", renderOri=");
            sb.append(this.k);
        }
        StringBuilder replace = sb.replace(0, 2, "PosInfo{");
        replace.append('}');
        return replace.toString();
    }
}
