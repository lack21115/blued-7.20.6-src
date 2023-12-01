package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import com.heytap.nearx.a.a.e;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/b.class */
public final class b extends com.heytap.nearx.a.a.b<b, a> {
    private static final long serialVersionUID = 0;
    public final List<y> A;
    public final Boolean B;
    public final Integer C;
    public final x D;
    public final Integer E;
    public final String F;
    public final Long G;
    public final Boolean H;
    public final Integer I;
    public final Integer J;
    public final Integer K;
    public final Integer L;
    public final c M;
    public final Boolean N;
    public final e O;
    public final String P;
    public final Boolean Q;
    public final String R;
    public final Boolean S;
    public final f T;
    public final com.opos.mobad.b.a.a U;
    public final EnumC0504b V;
    public final String W;
    public final Integer X;
    public final h Y;
    public final Integer Z;
    public final Integer aa;
    public final Integer ab;
    public final String x;
    public final String y;
    public final String z;

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<b> f12020c = new d();
    public static final Boolean d = false;
    public static final Integer e = 0;
    public static final Integer f = 0;
    public static final Long g = Long.valueOf((long) com.anythink.expressad.video.module.a.a.m.ag);
    public static final Boolean h = true;
    public static final Integer i = 45;
    public static final Integer j = 90;
    public static final Integer k = 1;
    public static final Integer l = 0;
    public static final c m = c.PLAY_CACHE;
    public static final Boolean n = true;
    public static final e o = e.PLAY_COMPLETE;
    public static final Boolean p = false;
    public static final Boolean q = false;
    public static final f r = f.TOP_RIGHT_CORNER;
    public static final EnumC0504b s = EnumC0504b.SENSOR;
    public static final Integer t = 0;
    public static final Integer u = 1;
    public static final Integer v = 0;
    public static final Integer w = 0;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/b$a.class */
    public static final class a extends b.a<b, a> {
        public EnumC0504b A;
        public String B;
        public Integer C;
        public h D;
        public Integer E;
        public Integer F;
        public Integer G;

        /* renamed from: c  reason: collision with root package name */
        public String f12021c;
        public String d;
        public String e;
        public List<y> f = com.heytap.nearx.a.a.a.b.a();
        public Boolean g;
        public Integer h;
        public x i;
        public Integer j;
        public String k;
        public Long l;
        public Boolean m;
        public Integer n;
        public Integer o;
        public Integer p;
        public Integer q;
        public c r;
        public Boolean s;
        public e t;
        public String u;
        public Boolean v;
        public String w;
        public Boolean x;
        public f y;
        public com.opos.mobad.b.a.a z;

        public a a(com.opos.mobad.b.a.a aVar) {
            this.z = aVar;
            return this;
        }

        public a a(EnumC0504b enumC0504b) {
            this.A = enumC0504b;
            return this;
        }

        public a a(c cVar) {
            this.r = cVar;
            return this;
        }

        public a a(e eVar) {
            this.t = eVar;
            return this;
        }

        public a a(f fVar) {
            this.y = fVar;
            return this;
        }

        public a a(h hVar) {
            this.D = hVar;
            return this;
        }

        public a a(x xVar) {
            this.i = xVar;
            return this;
        }

        public a a(Boolean bool) {
            this.g = bool;
            return this;
        }

        public a a(Integer num) {
            this.h = num;
            return this;
        }

        public a a(Long l) {
            this.l = l;
            return this;
        }

        public a a(String str) {
            this.f12021c = str;
            return this;
        }

        public a b(Boolean bool) {
            this.m = bool;
            return this;
        }

        public a b(Integer num) {
            this.j = num;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public b b() {
            return new b(this.f12021c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.D, this.E, this.F, this.G, super.a());
        }

        public a c(Boolean bool) {
            this.s = bool;
            return this;
        }

        public a c(Integer num) {
            this.n = num;
            return this;
        }

        public a c(String str) {
            this.e = str;
            return this;
        }

        public a d(Boolean bool) {
            this.v = bool;
            return this;
        }

        public a d(Integer num) {
            this.o = num;
            return this;
        }

        public a d(String str) {
            this.k = str;
            return this;
        }

        public a e(Boolean bool) {
            this.x = bool;
            return this;
        }

        public a e(Integer num) {
            this.p = num;
            return this;
        }

        public a e(String str) {
            this.u = str;
            return this;
        }

        public a f(Integer num) {
            this.q = num;
            return this;
        }

        public a f(String str) {
            this.w = str;
            return this;
        }

        public a g(Integer num) {
            this.C = num;
            return this;
        }

        public a g(String str) {
            this.B = str;
            return this;
        }

        public a h(Integer num) {
            this.E = num;
            return this;
        }

        public a i(Integer num) {
            this.F = num;
            return this;
        }

        public a j(Integer num) {
            this.G = num;
            return this;
        }
    }

    /* renamed from: com.opos.mobad.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/b$b.class */
    public enum EnumC0504b implements com.heytap.nearx.a.a.i {
        SENSOR(0),
        HORIZONTAL(1),
        VERTICAL(2);
        
        public static final com.heytap.nearx.a.a.e<EnumC0504b> d = com.heytap.nearx.a.a.e.a(EnumC0504b.class);
        private final int e;

        EnumC0504b(int i) {
            this.e = i;
        }

        public static EnumC0504b fromValue(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return VERTICAL;
                }
                return HORIZONTAL;
            }
            return SENSOR;
        }

        @Override // com.heytap.nearx.a.a.i
        public int a() {
            return this.e;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/b$c.class */
    public enum c implements com.heytap.nearx.a.a.i {
        NO_MODE(0),
        PLAY_CACHE(1),
        PLAY_STREAM(2);
        
        public static final com.heytap.nearx.a.a.e<c> d = com.heytap.nearx.a.a.e.a(c.class);
        private final int e;

        c(int i) {
            this.e = i;
        }

        public static c fromValue(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return PLAY_STREAM;
                }
                return PLAY_CACHE;
            }
            return NO_MODE;
        }

        @Override // com.heytap.nearx.a.a.i
        public int a() {
            return this.e;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/b$d.class */
    static final class d extends com.heytap.nearx.a.a.e<b> {
        d() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, b.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(b bVar) {
            int a2 = bVar.x != null ? com.heytap.nearx.a.a.e.p.a(1, (int) bVar.x) : 0;
            int a3 = bVar.y != null ? com.heytap.nearx.a.a.e.p.a(2, (int) bVar.y) : 0;
            int a4 = bVar.z != null ? com.heytap.nearx.a.a.e.p.a(3, (int) bVar.z) : 0;
            int a5 = y.f12084c.a().a(4, (int) bVar.A);
            int a6 = bVar.B != null ? com.heytap.nearx.a.a.e.f8653c.a(5, (int) bVar.B) : 0;
            int a7 = bVar.C != null ? com.heytap.nearx.a.a.e.d.a(6, (int) bVar.C) : 0;
            int a8 = bVar.D != null ? x.f12082c.a(7, (int) bVar.D) : 0;
            int a9 = bVar.E != null ? com.heytap.nearx.a.a.e.d.a(8, (int) bVar.E) : 0;
            int a10 = bVar.F != null ? com.heytap.nearx.a.a.e.p.a(9, (int) bVar.F) : 0;
            int a11 = bVar.G != null ? com.heytap.nearx.a.a.e.i.a(10, (int) bVar.G) : 0;
            int a12 = bVar.H != null ? com.heytap.nearx.a.a.e.f8653c.a(11, (int) bVar.H) : 0;
            int a13 = bVar.I != null ? com.heytap.nearx.a.a.e.d.a(12, (int) bVar.I) : 0;
            int a14 = bVar.J != null ? com.heytap.nearx.a.a.e.d.a(13, (int) bVar.J) : 0;
            int a15 = bVar.K != null ? com.heytap.nearx.a.a.e.d.a(14, (int) bVar.K) : 0;
            int a16 = bVar.L != null ? com.heytap.nearx.a.a.e.d.a(15, (int) bVar.L) : 0;
            int a17 = bVar.M != null ? c.d.a(16, (int) bVar.M) : 0;
            int a18 = bVar.N != null ? com.heytap.nearx.a.a.e.f8653c.a(17, (int) bVar.N) : 0;
            int a19 = bVar.O != null ? e.g.a(18, (int) bVar.O) : 0;
            int a20 = bVar.P != null ? com.heytap.nearx.a.a.e.p.a(19, (int) bVar.P) : 0;
            int a21 = bVar.Q != null ? com.heytap.nearx.a.a.e.f8653c.a(20, (int) bVar.Q) : 0;
            int a22 = bVar.R != null ? com.heytap.nearx.a.a.e.p.a(21, (int) bVar.R) : 0;
            int a23 = bVar.S != null ? com.heytap.nearx.a.a.e.f8653c.a(22, (int) bVar.S) : 0;
            int a24 = bVar.T != null ? f.d.a(23, (int) bVar.T) : 0;
            int a25 = bVar.U != null ? com.opos.mobad.b.a.a.f12000c.a(24, (int) bVar.U) : 0;
            int a26 = bVar.V != null ? EnumC0504b.d.a(25, (int) bVar.V) : 0;
            int a27 = bVar.W != null ? com.heytap.nearx.a.a.e.p.a(26, (int) bVar.W) : 0;
            int a28 = bVar.X != null ? com.heytap.nearx.a.a.e.d.a(27, (int) bVar.X) : 0;
            int a29 = bVar.Y != null ? h.f12044c.a(28, (int) bVar.Y) : 0;
            int a30 = bVar.Z != null ? com.heytap.nearx.a.a.e.d.a(29, (int) bVar.Z) : 0;
            return (bVar.aa != null ? com.heytap.nearx.a.a.e.d.a(30, (int) bVar.aa) : 0) + a5 + a4 + a3 + a2 + a6 + a7 + a8 + a9 + a10 + a11 + a12 + a13 + a14 + a15 + a16 + a17 + a18 + a19 + a20 + a21 + a22 + a23 + a24 + a25 + a26 + a27 + a28 + a29 + a30 + (bVar.ab != null ? com.heytap.nearx.a.a.e.d.a(31, (int) bVar.ab) : 0) + bVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, b bVar) throws IOException {
            if (bVar.x != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, bVar.x);
            }
            if (bVar.y != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, bVar.y);
            }
            if (bVar.z != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, bVar.z);
            }
            y.f12084c.a().a(gVar, 4, bVar.A);
            if (bVar.B != null) {
                com.heytap.nearx.a.a.e.f8653c.a(gVar, 5, bVar.B);
            }
            if (bVar.C != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 6, bVar.C);
            }
            if (bVar.D != null) {
                x.f12082c.a(gVar, 7, bVar.D);
            }
            if (bVar.E != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 8, bVar.E);
            }
            if (bVar.F != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 9, bVar.F);
            }
            if (bVar.G != null) {
                com.heytap.nearx.a.a.e.i.a(gVar, 10, bVar.G);
            }
            if (bVar.H != null) {
                com.heytap.nearx.a.a.e.f8653c.a(gVar, 11, bVar.H);
            }
            if (bVar.I != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 12, bVar.I);
            }
            if (bVar.J != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 13, bVar.J);
            }
            if (bVar.K != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 14, bVar.K);
            }
            if (bVar.L != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 15, bVar.L);
            }
            if (bVar.M != null) {
                c.d.a(gVar, 16, bVar.M);
            }
            if (bVar.N != null) {
                com.heytap.nearx.a.a.e.f8653c.a(gVar, 17, bVar.N);
            }
            if (bVar.O != null) {
                e.g.a(gVar, 18, bVar.O);
            }
            if (bVar.P != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 19, bVar.P);
            }
            if (bVar.Q != null) {
                com.heytap.nearx.a.a.e.f8653c.a(gVar, 20, bVar.Q);
            }
            if (bVar.R != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 21, bVar.R);
            }
            if (bVar.S != null) {
                com.heytap.nearx.a.a.e.f8653c.a(gVar, 22, bVar.S);
            }
            if (bVar.T != null) {
                f.d.a(gVar, 23, bVar.T);
            }
            if (bVar.U != null) {
                com.opos.mobad.b.a.a.f12000c.a(gVar, 24, bVar.U);
            }
            if (bVar.V != null) {
                EnumC0504b.d.a(gVar, 25, bVar.V);
            }
            if (bVar.W != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 26, bVar.W);
            }
            if (bVar.X != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 27, bVar.X);
            }
            if (bVar.Y != null) {
                h.f12044c.a(gVar, 28, bVar.Y);
            }
            if (bVar.Z != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 29, bVar.Z);
            }
            if (bVar.aa != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 30, bVar.aa);
            }
            if (bVar.ab != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 31, bVar.ab);
            }
            gVar.a(bVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public b a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 3:
                        aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 4:
                        aVar.f.add(y.f12084c.a(fVar));
                        break;
                    case 5:
                        aVar.a(com.heytap.nearx.a.a.e.f8653c.a(fVar));
                        break;
                    case 6:
                        aVar.a(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 7:
                        aVar.a(x.f12082c.a(fVar));
                        break;
                    case 8:
                        aVar.b(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 9:
                        aVar.d(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 10:
                        aVar.a(com.heytap.nearx.a.a.e.i.a(fVar));
                        break;
                    case 11:
                        aVar.b(com.heytap.nearx.a.a.e.f8653c.a(fVar));
                        break;
                    case 12:
                        aVar.c(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 13:
                        aVar.d(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 14:
                        aVar.e(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 15:
                        aVar.f(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 16:
                        aVar.a(c.d.a(fVar));
                        break;
                    case 17:
                        aVar.c(com.heytap.nearx.a.a.e.f8653c.a(fVar));
                        break;
                    case 18:
                        aVar.a(e.g.a(fVar));
                        break;
                    case 19:
                        aVar.e(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 20:
                        aVar.d(com.heytap.nearx.a.a.e.f8653c.a(fVar));
                        break;
                    case 21:
                        aVar.f(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 22:
                        aVar.e(com.heytap.nearx.a.a.e.f8653c.a(fVar));
                        break;
                    case 23:
                        aVar.a(f.d.a(fVar));
                        break;
                    case 24:
                        aVar.a(com.opos.mobad.b.a.a.f12000c.a(fVar));
                        break;
                    case 25:
                        try {
                            aVar.a(EnumC0504b.d.a(fVar));
                            break;
                        } catch (e.a e) {
                            aVar.a(b, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e.f8655a));
                            break;
                        }
                    case 26:
                        aVar.g(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 27:
                        aVar.g(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 28:
                        aVar.a(h.f12044c.a(fVar));
                        break;
                    case 29:
                        aVar.h(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 30:
                        aVar.i(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 31:
                        aVar.j(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a c2 = fVar.c();
                        aVar.a(b, c2, c2.a().a(fVar));
                        break;
                }
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/b$e.class */
    public enum e implements com.heytap.nearx.a.a.i {
        NO_SCENE(0),
        PLAY_COMPLETE(1),
        INSTALL_COMPLETE(2),
        LAUNCH(3),
        PLAY_INTERACTION(4),
        AD_CLICK(5);
        
        public static final com.heytap.nearx.a.a.e<e> g = com.heytap.nearx.a.a.e.a(e.class);
        private final int h;

        e(int i2) {
            this.h = i2;
        }

        public static e fromValue(int i2) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                if (i2 != 5) {
                                    return null;
                                }
                                return AD_CLICK;
                            }
                            return PLAY_INTERACTION;
                        }
                        return LAUNCH;
                    }
                    return INSTALL_COMPLETE;
                }
                return PLAY_COMPLETE;
            }
            return NO_SCENE;
        }

        @Override // com.heytap.nearx.a.a.i
        public int a() {
            return this.h;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/b$f.class */
    public enum f implements com.heytap.nearx.a.a.i {
        TOP_RIGHT_CORNER(0),
        MIDDLE_RIGHT_CORNER(1),
        BOTTOM_RIGHT_CORNER(2);
        
        public static final com.heytap.nearx.a.a.e<f> d = com.heytap.nearx.a.a.e.a(f.class);
        private final int e;

        f(int i) {
            this.e = i;
        }

        public static f fromValue(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return BOTTOM_RIGHT_CORNER;
                }
                return MIDDLE_RIGHT_CORNER;
            }
            return TOP_RIGHT_CORNER;
        }

        @Override // com.heytap.nearx.a.a.i
        public int a() {
            return this.e;
        }
    }

    public b(String str, String str2, String str3, List<y> list, Boolean bool, Integer num, x xVar, Integer num2, String str4, Long l2, Boolean bool2, Integer num3, Integer num4, Integer num5, Integer num6, c cVar, Boolean bool3, e eVar, String str5, Boolean bool4, String str6, Boolean bool5, f fVar, com.opos.mobad.b.a.a aVar, EnumC0504b enumC0504b, String str7, Integer num7, h hVar, Integer num8, Integer num9, Integer num10, ByteString byteString) {
        super(f12020c, byteString);
        this.x = str;
        this.y = str2;
        this.z = str3;
        this.A = com.heytap.nearx.a.a.a.b.b("materialList", list);
        this.B = bool;
        this.C = num;
        this.D = xVar;
        this.E = num2;
        this.F = str4;
        this.G = l2;
        this.H = bool2;
        this.I = num3;
        this.J = num4;
        this.K = num5;
        this.L = num6;
        this.M = cVar;
        this.N = bool3;
        this.O = eVar;
        this.P = str5;
        this.Q = bool4;
        this.R = str6;
        this.S = bool5;
        this.T = fVar;
        this.U = aVar;
        this.V = enumC0504b;
        this.W = str7;
        this.X = num7;
        this.Y = hVar;
        this.Z = num8;
        this.aa = num9;
        this.ab = num10;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.x != null) {
            sb.append(", adId=");
            sb.append(this.x);
        }
        if (this.y != null) {
            sb.append(", posId=");
            sb.append(this.y);
        }
        if (this.z != null) {
            sb.append(", planId=");
            sb.append(this.z);
        }
        if (!this.A.isEmpty()) {
            sb.append(", materialList=");
            sb.append(this.A);
        }
        if (this.B != null) {
            sb.append(", showAdLogo=");
            sb.append(this.B);
        }
        if (this.C != null) {
            sb.append(", closeBnStyle=");
            sb.append(this.C);
        }
        if (this.D != null) {
            sb.append(", logoFile=");
            sb.append(this.D);
        }
        if (this.E != null) {
            sb.append(", refreshTime=");
            sb.append(this.E);
        }
        if (this.F != null) {
            sb.append(", ext=");
            sb.append(this.F);
        }
        if (this.G != null) {
            sb.append(", countdown=");
            sb.append(this.G);
        }
        if (this.H != null) {
            sb.append(", showSkipBn=");
            sb.append(this.H);
        }
        if (this.I != null) {
            sb.append(", showInterval=");
            sb.append(this.I);
        }
        if (this.J != null) {
            sb.append(", clickInterval=");
            sb.append(this.J);
        }
        if (this.K != null) {
            sb.append(", limitNum=");
            sb.append(this.K);
        }
        if (this.L != null) {
            sb.append(", reqInterval=");
            sb.append(this.L);
        }
        if (this.M != null) {
            sb.append(", playMode=");
            sb.append(this.M);
        }
        if (this.N != null) {
            sb.append(", playRemindAtCellular=");
            sb.append(this.N);
        }
        if (this.O != null) {
            sb.append(", rewardScene=");
            sb.append(this.O);
        }
        if (this.P != null) {
            sb.append(", logoText=");
            sb.append(this.P);
        }
        if (this.Q != null) {
            sb.append(", recordShowEvent=");
            sb.append(this.Q);
        }
        if (this.R != null) {
            sb.append(", adSource=");
            sb.append(this.R);
        }
        if (this.S != null) {
            sb.append(", playVideoInSilence=");
            sb.append(this.S);
        }
        if (this.T != null) {
            sb.append(", splashSkipBtPosition=");
            sb.append(this.T);
        }
        if (this.U != null) {
            sb.append(", activatingInfo=");
            sb.append(this.U);
        }
        if (this.V != null) {
            sb.append(", videoOrientation=");
            sb.append(this.V);
        }
        if (this.W != null) {
            sb.append(", transportData=");
            sb.append(this.W);
        }
        if (this.X != null) {
            sb.append(", rewardDuration=");
            sb.append(this.X);
        }
        if (this.Y != null) {
            sb.append(", appPrivacyInfo=");
            sb.append(this.Y);
        }
        if (this.Z != null) {
            sb.append(", rewardSceneFlag=");
            sb.append(this.Z);
        }
        if (this.aa != null) {
            sb.append(", ecpm=");
            sb.append(this.aa);
        }
        if (this.ab != null) {
            sb.append(", returnPrice=");
            sb.append(this.ab);
        }
        StringBuilder replace = sb.replace(0, 2, "AdInfo{");
        replace.append('}');
        return replace.toString();
    }
}
