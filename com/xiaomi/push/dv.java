package com.xiaomi.push;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dv.class */
public final class dv {

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dv$a.class */
    public static final class a extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f272a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f274b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f276c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f278d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f280e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f281f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;

        /* renamed from: a  reason: collision with root package name */
        private int f27656a = 0;

        /* renamed from: a  reason: collision with other field name */
        private long f270a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f271a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f273b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f275c = "";

        /* renamed from: d  reason: collision with other field name */
        private String f277d = "";

        /* renamed from: e  reason: collision with other field name */
        private String f279e = "";
        private int b = 1;

        /* renamed from: c  reason: collision with root package name */
        private int f27657c = 0;
        private int d = 0;
        private String f = "";
        private int e = -1;

        @Override // com.xiaomi.push.e
        public final int a() {
            if (this.e < 0) {
                b();
            }
            return this.e;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final long m8586a() {
            return this.f270a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final a m8587a() {
            this.f281f = false;
            this.f277d = "";
            return this;
        }

        public final a a(int i) {
            this.f272a = true;
            this.f27656a = i;
            return this;
        }

        public final a a(long j) {
            this.f274b = true;
            this.f270a = j;
            return this;
        }

        @Override // com.xiaomi.push.e
        public final a a(com.xiaomi.push.b bVar) {
            while (true) {
                int m8468a = bVar.m8468a();
                switch (m8468a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.m8477b());
                        break;
                    case 16:
                        a(bVar.m8478b());
                        break;
                    case 26:
                        a(bVar.m8471a());
                        break;
                    case 34:
                        b(bVar.m8471a());
                        break;
                    case 42:
                        c(bVar.m8471a());
                        break;
                    case 50:
                        d(bVar.m8471a());
                        break;
                    case 58:
                        e(bVar.m8471a());
                        break;
                    case 64:
                        b(bVar.m8477b());
                        break;
                    case 72:
                        c(bVar.m8477b());
                        break;
                    case 80:
                        d(bVar.m8477b());
                        break;
                    case 90:
                        f(bVar.m8471a());
                        break;
                    default:
                        if (a(bVar, m8468a)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public final a a(String str) {
            this.f276c = true;
            this.f271a = str;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final String m8588a() {
            return this.f271a;
        }

        @Override // com.xiaomi.push.e
        public final void a(com.xiaomi.push.c cVar) {
            if (m8589a()) {
                cVar.m8512a(1, c());
            }
            if (m8591b()) {
                cVar.m8526b(2, m8586a());
            }
            if (m8593c()) {
                cVar.m8516a(3, m8588a());
            }
            if (m8595d()) {
                cVar.m8516a(4, m8590b());
            }
            if (m8597e()) {
                cVar.m8516a(5, m8592c());
            }
            if (m8599f()) {
                cVar.m8516a(6, m8594d());
            }
            if (g()) {
                cVar.m8516a(7, m8596e());
            }
            if (h()) {
                cVar.m8512a(8, d());
            }
            if (i()) {
                cVar.m8512a(9, e());
            }
            if (j()) {
                cVar.m8512a(10, f());
            }
            if (k()) {
                cVar.m8516a(11, m8598f());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public final boolean m8589a() {
            return this.f272a;
        }

        @Override // com.xiaomi.push.e
        public final int b() {
            int i = 0;
            if (m8589a()) {
                i = 0 + com.xiaomi.push.c.a(1, c());
            }
            int i2 = i;
            if (m8591b()) {
                i2 = i + com.xiaomi.push.c.b(2, m8586a());
            }
            int i3 = i2;
            if (m8593c()) {
                i3 = i2 + com.xiaomi.push.c.a(3, m8588a());
            }
            int i4 = i3;
            if (m8595d()) {
                i4 = i3 + com.xiaomi.push.c.a(4, m8590b());
            }
            int i5 = i4;
            if (m8597e()) {
                i5 = i4 + com.xiaomi.push.c.a(5, m8592c());
            }
            int i6 = i5;
            if (m8599f()) {
                i6 = i5 + com.xiaomi.push.c.a(6, m8594d());
            }
            int i7 = i6;
            if (g()) {
                i7 = i6 + com.xiaomi.push.c.a(7, m8596e());
            }
            int i8 = i7;
            if (h()) {
                i8 = i7 + com.xiaomi.push.c.a(8, d());
            }
            int i9 = i8;
            if (i()) {
                i9 = i8 + com.xiaomi.push.c.a(9, e());
            }
            int i10 = i9;
            if (j()) {
                i10 = i9 + com.xiaomi.push.c.a(10, f());
            }
            int i11 = i10;
            if (k()) {
                i11 = i10 + com.xiaomi.push.c.a(11, m8598f());
            }
            this.e = i11;
            return i11;
        }

        public final a b(int i) {
            this.h = true;
            this.b = i;
            return this;
        }

        public final a b(String str) {
            this.f278d = true;
            this.f273b = str;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final String m8590b() {
            return this.f273b;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final boolean m8591b() {
            return this.f274b;
        }

        public final int c() {
            return this.f27656a;
        }

        public final a c(int i) {
            this.i = true;
            this.f27657c = i;
            return this;
        }

        public final a c(String str) {
            this.f280e = true;
            this.f275c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public final String m8592c() {
            return this.f275c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public final boolean m8593c() {
            return this.f276c;
        }

        public final int d() {
            return this.b;
        }

        public final a d(int i) {
            this.j = true;
            this.d = i;
            return this;
        }

        public final a d(String str) {
            this.f281f = true;
            this.f277d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public final String m8594d() {
            return this.f277d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public final boolean m8595d() {
            return this.f278d;
        }

        public final int e() {
            return this.f27657c;
        }

        public final a e(String str) {
            this.g = true;
            this.f279e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public final String m8596e() {
            return this.f279e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public final boolean m8597e() {
            return this.f280e;
        }

        public final int f() {
            return this.d;
        }

        public final a f(String str) {
            this.k = true;
            this.f = str;
            return this;
        }

        /* renamed from: f  reason: collision with other method in class */
        public final String m8598f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public final boolean m8599f() {
            return this.f281f;
        }

        public final boolean g() {
            return this.g;
        }

        public final boolean h() {
            return this.h;
        }

        public final boolean i() {
            return this.i;
        }

        public final boolean j() {
            return this.j;
        }

        public final boolean k() {
            return this.k;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dv$b.class */
    public static final class b extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f282a;

        /* renamed from: c  reason: collision with other field name */
        private boolean f284c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f285d;
        private boolean e;

        /* renamed from: b  reason: collision with other field name */
        private boolean f283b = false;

        /* renamed from: a  reason: collision with root package name */
        private int f27658a = 0;
        private int b = 0;

        /* renamed from: c  reason: collision with root package name */
        private int f27659c = 0;
        private int d = -1;

        public static b a(byte[] bArr) {
            return (b) new b().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public final int a() {
            if (this.d < 0) {
                b();
            }
            return this.d;
        }

        public final b a(int i) {
            this.f284c = true;
            this.f27658a = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public final b a(com.xiaomi.push.b bVar) {
            while (true) {
                int m8468a = bVar.m8468a();
                if (m8468a == 0) {
                    return this;
                }
                if (m8468a == 8) {
                    a(bVar.m8474a());
                } else if (m8468a == 24) {
                    a(bVar.m8477b());
                } else if (m8468a == 32) {
                    b(bVar.m8477b());
                } else if (m8468a == 40) {
                    c(bVar.m8477b());
                } else if (!a(bVar, m8468a)) {
                    return this;
                }
            }
        }

        public final b a(boolean z) {
            this.f282a = true;
            this.f283b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public final void a(com.xiaomi.push.c cVar) {
            if (m8601b()) {
                cVar.m8517a(1, m8600a());
            }
            if (m8602c()) {
                cVar.m8512a(3, c());
            }
            if (m8603d()) {
                cVar.m8512a(4, d());
            }
            if (m8604e()) {
                cVar.m8512a(5, e());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public final boolean m8600a() {
            return this.f283b;
        }

        @Override // com.xiaomi.push.e
        public final int b() {
            int i = 0;
            if (m8601b()) {
                i = 0 + com.xiaomi.push.c.a(1, m8600a());
            }
            int i2 = i;
            if (m8602c()) {
                i2 = i + com.xiaomi.push.c.a(3, c());
            }
            int i3 = i2;
            if (m8603d()) {
                i3 = i2 + com.xiaomi.push.c.a(4, d());
            }
            int i4 = i3;
            if (m8604e()) {
                i4 = i3 + com.xiaomi.push.c.a(5, e());
            }
            this.d = i4;
            return i4;
        }

        public final b b(int i) {
            this.f285d = true;
            this.b = i;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final boolean m8601b() {
            return this.f282a;
        }

        public final int c() {
            return this.f27658a;
        }

        public final b c(int i) {
            this.e = true;
            this.f27659c = i;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public final boolean m8602c() {
            return this.f284c;
        }

        public final int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public final boolean m8603d() {
            return this.f285d;
        }

        public final int e() {
            return this.f27659c;
        }

        /* renamed from: e  reason: collision with other method in class */
        public final boolean m8604e() {
            return this.e;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dv$c.class */
    public static final class c extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f287a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f288b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f289c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f290d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f291e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f292f;

        /* renamed from: a  reason: collision with other field name */
        private String f286a = "";
        private String b = "";

        /* renamed from: c  reason: collision with root package name */
        private String f27661c = "";
        private String d = "";
        private String e = "";
        private String f = "";

        /* renamed from: a  reason: collision with root package name */
        private int f27660a = -1;

        @Override // com.xiaomi.push.e
        public final int a() {
            if (this.f27660a < 0) {
                b();
            }
            return this.f27660a;
        }

        @Override // com.xiaomi.push.e
        public final c a(com.xiaomi.push.b bVar) {
            while (true) {
                int m8468a = bVar.m8468a();
                if (m8468a == 0) {
                    return this;
                }
                if (m8468a == 10) {
                    a(bVar.m8471a());
                } else if (m8468a == 18) {
                    b(bVar.m8471a());
                } else if (m8468a == 26) {
                    c(bVar.m8471a());
                } else if (m8468a == 34) {
                    d(bVar.m8471a());
                } else if (m8468a == 42) {
                    e(bVar.m8471a());
                } else if (m8468a == 50) {
                    f(bVar.m8471a());
                } else if (!a(bVar, m8468a)) {
                    return this;
                }
            }
        }

        public final c a(String str) {
            this.f287a = true;
            this.f286a = str;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final String m8605a() {
            return this.f286a;
        }

        @Override // com.xiaomi.push.e
        public final void a(com.xiaomi.push.c cVar) {
            if (m8606a()) {
                cVar.m8516a(1, m8605a());
            }
            if (m8608b()) {
                cVar.m8516a(2, m8607b());
            }
            if (m8609c()) {
                cVar.m8516a(3, c());
            }
            if (m8610d()) {
                cVar.m8516a(4, d());
            }
            if (m8611e()) {
                cVar.m8516a(5, e());
            }
            if (m8612f()) {
                cVar.m8516a(6, f());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public final boolean m8606a() {
            return this.f287a;
        }

        @Override // com.xiaomi.push.e
        public final int b() {
            int i = 0;
            if (m8606a()) {
                i = 0 + com.xiaomi.push.c.a(1, m8605a());
            }
            int i2 = i;
            if (m8608b()) {
                i2 = i + com.xiaomi.push.c.a(2, m8607b());
            }
            int i3 = i2;
            if (m8609c()) {
                i3 = i2 + com.xiaomi.push.c.a(3, c());
            }
            int i4 = i3;
            if (m8610d()) {
                i4 = i3 + com.xiaomi.push.c.a(4, d());
            }
            int i5 = i4;
            if (m8611e()) {
                i5 = i4 + com.xiaomi.push.c.a(5, e());
            }
            int i6 = i5;
            if (m8612f()) {
                i6 = i5 + com.xiaomi.push.c.a(6, f());
            }
            this.f27660a = i6;
            return i6;
        }

        public final c b(String str) {
            this.f288b = true;
            this.b = str;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final String m8607b() {
            return this.b;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final boolean m8608b() {
            return this.f288b;
        }

        public final c c(String str) {
            this.f289c = true;
            this.f27661c = str;
            return this;
        }

        public final String c() {
            return this.f27661c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public final boolean m8609c() {
            return this.f289c;
        }

        public final c d(String str) {
            this.f290d = true;
            this.d = str;
            return this;
        }

        public final String d() {
            return this.d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public final boolean m8610d() {
            return this.f290d;
        }

        public final c e(String str) {
            this.f291e = true;
            this.e = str;
            return this;
        }

        public final String e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public final boolean m8611e() {
            return this.f291e;
        }

        public final c f(String str) {
            this.f292f = true;
            this.f = str;
            return this;
        }

        public final String f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public final boolean m8612f() {
            return this.f292f;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dv$d.class */
    public static final class d extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f294a;

        /* renamed from: c  reason: collision with other field name */
        private boolean f296c;
        private boolean d;
        private boolean e;

        /* renamed from: b  reason: collision with other field name */
        private boolean f295b = false;

        /* renamed from: a  reason: collision with other field name */
        private String f293a = "";
        private String b = "";

        /* renamed from: c  reason: collision with root package name */
        private String f27663c = "";

        /* renamed from: a  reason: collision with root package name */
        private int f27662a = -1;

        public static d a(byte[] bArr) {
            return (d) new d().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public final int a() {
            if (this.f27662a < 0) {
                b();
            }
            return this.f27662a;
        }

        @Override // com.xiaomi.push.e
        public final d a(com.xiaomi.push.b bVar) {
            while (true) {
                int m8468a = bVar.m8468a();
                if (m8468a == 0) {
                    return this;
                }
                if (m8468a == 8) {
                    a(bVar.m8474a());
                } else if (m8468a == 18) {
                    a(bVar.m8471a());
                } else if (m8468a == 26) {
                    b(bVar.m8471a());
                } else if (m8468a == 34) {
                    c(bVar.m8471a());
                } else if (!a(bVar, m8468a)) {
                    return this;
                }
            }
        }

        public final d a(String str) {
            this.f296c = true;
            this.f293a = str;
            return this;
        }

        public final d a(boolean z) {
            this.f294a = true;
            this.f295b = z;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final String m8613a() {
            return this.f293a;
        }

        @Override // com.xiaomi.push.e
        public final void a(com.xiaomi.push.c cVar) {
            if (m8616b()) {
                cVar.m8517a(1, m8614a());
            }
            if (m8617c()) {
                cVar.m8516a(2, m8613a());
            }
            if (d()) {
                cVar.m8516a(3, m8615b());
            }
            if (e()) {
                cVar.m8516a(4, c());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public final boolean m8614a() {
            return this.f295b;
        }

        @Override // com.xiaomi.push.e
        public final int b() {
            int i = 0;
            if (m8616b()) {
                i = 0 + com.xiaomi.push.c.a(1, m8614a());
            }
            int i2 = i;
            if (m8617c()) {
                i2 = i + com.xiaomi.push.c.a(2, m8613a());
            }
            int i3 = i2;
            if (d()) {
                i3 = i2 + com.xiaomi.push.c.a(3, m8615b());
            }
            int i4 = i3;
            if (e()) {
                i4 = i3 + com.xiaomi.push.c.a(4, c());
            }
            this.f27662a = i4;
            return i4;
        }

        public final d b(String str) {
            this.d = true;
            this.b = str;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final String m8615b() {
            return this.b;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final boolean m8616b() {
            return this.f294a;
        }

        public final d c(String str) {
            this.e = true;
            this.f27663c = str;
            return this;
        }

        public final String c() {
            return this.f27663c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public final boolean m8617c() {
            return this.f296c;
        }

        public final boolean d() {
            return this.d;
        }

        public final boolean e() {
            return this.e;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dv$e.class */
    public static final class e extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f299a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f301b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f303c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f305d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f306e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f307f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;

        /* renamed from: a  reason: collision with root package name */
        private int f27664a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f298a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f300b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f302c = "";
        private int b = 0;

        /* renamed from: d  reason: collision with other field name */
        private String f304d = "";
        private String e = "";
        private String f = "";

        /* renamed from: a  reason: collision with other field name */
        private b f297a = null;

        /* renamed from: c  reason: collision with root package name */
        private int f27665c = 0;
        private int d = -1;

        @Override // com.xiaomi.push.e
        public final int a() {
            if (this.d < 0) {
                b();
            }
            return this.d;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final b m8618a() {
            return this.f297a;
        }

        public final e a(int i) {
            this.f299a = true;
            this.f27664a = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public final e a(com.xiaomi.push.b bVar) {
            while (true) {
                int m8468a = bVar.m8468a();
                switch (m8468a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.c());
                        break;
                    case 18:
                        a(bVar.m8471a());
                        break;
                    case 26:
                        b(bVar.m8471a());
                        break;
                    case 34:
                        c(bVar.m8471a());
                        break;
                    case 40:
                        b(bVar.m8477b());
                        break;
                    case 50:
                        d(bVar.m8471a());
                        break;
                    case 58:
                        e(bVar.m8471a());
                        break;
                    case 66:
                        f(bVar.m8471a());
                        break;
                    case 74:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    case 80:
                        c(bVar.m8477b());
                        break;
                    default:
                        if (a(bVar, m8468a)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public final e a(b bVar) {
            if (bVar != null) {
                this.i = true;
                this.f297a = bVar;
                return this;
            }
            throw null;
        }

        public final e a(String str) {
            this.f301b = true;
            this.f298a = str;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final String m8619a() {
            return this.f298a;
        }

        @Override // com.xiaomi.push.e
        public final void a(com.xiaomi.push.c cVar) {
            if (m8620a()) {
                cVar.m8525b(1, c());
            }
            if (m8622b()) {
                cVar.m8516a(2, m8619a());
            }
            if (m8624c()) {
                cVar.m8516a(3, m8621b());
            }
            if (m8626d()) {
                cVar.m8516a(4, m8623c());
            }
            if (m8628e()) {
                cVar.m8512a(5, d());
            }
            if (m8629f()) {
                cVar.m8516a(6, m8625d());
            }
            if (g()) {
                cVar.m8516a(7, m8627e());
            }
            if (h()) {
                cVar.m8516a(8, f());
            }
            if (i()) {
                cVar.m8515a(9, (com.xiaomi.push.e) m8618a());
            }
            if (j()) {
                cVar.m8512a(10, e());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public final boolean m8620a() {
            return this.f299a;
        }

        @Override // com.xiaomi.push.e
        public final int b() {
            int i = 0;
            if (m8620a()) {
                i = 0 + com.xiaomi.push.c.b(1, c());
            }
            int i2 = i;
            if (m8622b()) {
                i2 = i + com.xiaomi.push.c.a(2, m8619a());
            }
            int i3 = i2;
            if (m8624c()) {
                i3 = i2 + com.xiaomi.push.c.a(3, m8621b());
            }
            int i4 = i3;
            if (m8626d()) {
                i4 = i3 + com.xiaomi.push.c.a(4, m8623c());
            }
            int i5 = i4;
            if (m8628e()) {
                i5 = i4 + com.xiaomi.push.c.a(5, d());
            }
            int i6 = i5;
            if (m8629f()) {
                i6 = i5 + com.xiaomi.push.c.a(6, m8625d());
            }
            int i7 = i6;
            if (g()) {
                i7 = i6 + com.xiaomi.push.c.a(7, m8627e());
            }
            int i8 = i7;
            if (h()) {
                i8 = i7 + com.xiaomi.push.c.a(8, f());
            }
            int i9 = i8;
            if (i()) {
                i9 = i8 + com.xiaomi.push.c.a(9, (com.xiaomi.push.e) m8618a());
            }
            int i10 = i9;
            if (j()) {
                i10 = i9 + com.xiaomi.push.c.a(10, e());
            }
            this.d = i10;
            return i10;
        }

        public final e b(int i) {
            this.f306e = true;
            this.b = i;
            return this;
        }

        public final e b(String str) {
            this.f303c = true;
            this.f300b = str;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final String m8621b() {
            return this.f300b;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final boolean m8622b() {
            return this.f301b;
        }

        public final int c() {
            return this.f27664a;
        }

        public final e c(int i) {
            this.j = true;
            this.f27665c = i;
            return this;
        }

        public final e c(String str) {
            this.f305d = true;
            this.f302c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public final String m8623c() {
            return this.f302c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public final boolean m8624c() {
            return this.f303c;
        }

        public final int d() {
            return this.b;
        }

        public final e d(String str) {
            this.f307f = true;
            this.f304d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public final String m8625d() {
            return this.f304d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public final boolean m8626d() {
            return this.f305d;
        }

        public final int e() {
            return this.f27665c;
        }

        public final e e(String str) {
            this.g = true;
            this.e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public final String m8627e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public final boolean m8628e() {
            return this.f306e;
        }

        public final e f(String str) {
            this.h = true;
            this.f = str;
            return this;
        }

        public final String f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public final boolean m8629f() {
            return this.f307f;
        }

        public final boolean g() {
            return this.g;
        }

        public final boolean h() {
            return this.h;
        }

        public final boolean i() {
            return this.i;
        }

        public final boolean j() {
            return this.j;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dv$f.class */
    public static final class f extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f310a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f311b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f27667c;

        /* renamed from: a  reason: collision with other field name */
        private String f309a = "";
        private String b = "";

        /* renamed from: a  reason: collision with other field name */
        private b f308a = null;

        /* renamed from: a  reason: collision with root package name */
        private int f27666a = -1;

        public static f a(byte[] bArr) {
            return (f) new f().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public final int a() {
            if (this.f27666a < 0) {
                b();
            }
            return this.f27666a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final b m8630a() {
            return this.f308a;
        }

        @Override // com.xiaomi.push.e
        public final f a(com.xiaomi.push.b bVar) {
            while (true) {
                int m8468a = bVar.m8468a();
                if (m8468a == 0) {
                    return this;
                }
                if (m8468a == 10) {
                    a(bVar.m8471a());
                } else if (m8468a == 18) {
                    b(bVar.m8471a());
                } else if (m8468a == 26) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, m8468a)) {
                    return this;
                }
            }
        }

        public final f a(b bVar) {
            if (bVar != null) {
                this.f27667c = true;
                this.f308a = bVar;
                return this;
            }
            throw null;
        }

        public final f a(String str) {
            this.f310a = true;
            this.f309a = str;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final String m8631a() {
            return this.f309a;
        }

        @Override // com.xiaomi.push.e
        public final void a(com.xiaomi.push.c cVar) {
            if (m8632a()) {
                cVar.m8516a(1, m8631a());
            }
            if (m8634b()) {
                cVar.m8516a(2, m8633b());
            }
            if (c()) {
                cVar.m8515a(3, (com.xiaomi.push.e) m8630a());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public final boolean m8632a() {
            return this.f310a;
        }

        @Override // com.xiaomi.push.e
        public final int b() {
            int i = 0;
            if (m8632a()) {
                i = 0 + com.xiaomi.push.c.a(1, m8631a());
            }
            int i2 = i;
            if (m8634b()) {
                i2 = i + com.xiaomi.push.c.a(2, m8633b());
            }
            int i3 = i2;
            if (c()) {
                i3 = i2 + com.xiaomi.push.c.a(3, (com.xiaomi.push.e) m8630a());
            }
            this.f27666a = i3;
            return i3;
        }

        public final f b(String str) {
            this.f311b = true;
            this.b = str;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final String m8633b() {
            return this.b;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final boolean m8634b() {
            return this.f311b;
        }

        public final boolean c() {
            return this.f27667c;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dv$g.class */
    public static final class g extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f313a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f314b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f315c;

        /* renamed from: a  reason: collision with other field name */
        private String f312a = "";
        private String b = "";

        /* renamed from: c  reason: collision with root package name */
        private String f27669c = "";

        /* renamed from: a  reason: collision with root package name */
        private int f27668a = -1;

        public static g a(byte[] bArr) {
            return (g) new g().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public final int a() {
            if (this.f27668a < 0) {
                b();
            }
            return this.f27668a;
        }

        @Override // com.xiaomi.push.e
        public final g a(com.xiaomi.push.b bVar) {
            while (true) {
                int m8468a = bVar.m8468a();
                if (m8468a == 0) {
                    return this;
                }
                if (m8468a == 10) {
                    a(bVar.m8471a());
                } else if (m8468a == 18) {
                    b(bVar.m8471a());
                } else if (m8468a == 26) {
                    c(bVar.m8471a());
                } else if (!a(bVar, m8468a)) {
                    return this;
                }
            }
        }

        public final g a(String str) {
            this.f313a = true;
            this.f312a = str;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final String m8635a() {
            return this.f312a;
        }

        @Override // com.xiaomi.push.e
        public final void a(com.xiaomi.push.c cVar) {
            if (m8636a()) {
                cVar.m8516a(1, m8635a());
            }
            if (m8638b()) {
                cVar.m8516a(2, m8637b());
            }
            if (m8639c()) {
                cVar.m8516a(3, c());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public final boolean m8636a() {
            return this.f313a;
        }

        @Override // com.xiaomi.push.e
        public final int b() {
            int i = 0;
            if (m8636a()) {
                i = 0 + com.xiaomi.push.c.a(1, m8635a());
            }
            int i2 = i;
            if (m8638b()) {
                i2 = i + com.xiaomi.push.c.a(2, m8637b());
            }
            int i3 = i2;
            if (m8639c()) {
                i3 = i2 + com.xiaomi.push.c.a(3, c());
            }
            this.f27668a = i3;
            return i3;
        }

        public final g b(String str) {
            this.f314b = true;
            this.b = str;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final String m8637b() {
            return this.b;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final boolean m8638b() {
            return this.f314b;
        }

        public final g c(String str) {
            this.f315c = true;
            this.f27669c = str;
            return this;
        }

        public final String c() {
            return this.f27669c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public final boolean m8639c() {
            return this.f315c;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dv$h.class */
    public static final class h extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f317a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f318b;

        /* renamed from: a  reason: collision with root package name */
        private int f27670a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f316a = "";
        private int b = -1;

        public static h a(byte[] bArr) {
            return (h) new h().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public final int a() {
            if (this.b < 0) {
                b();
            }
            return this.b;
        }

        public final h a(int i) {
            this.f317a = true;
            this.f27670a = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public final h a(com.xiaomi.push.b bVar) {
            while (true) {
                int m8468a = bVar.m8468a();
                if (m8468a == 0) {
                    return this;
                }
                if (m8468a == 8) {
                    a(bVar.m8477b());
                } else if (m8468a == 18) {
                    a(bVar.m8471a());
                } else if (!a(bVar, m8468a)) {
                    return this;
                }
            }
        }

        public final h a(String str) {
            this.f318b = true;
            this.f316a = str;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final String m8640a() {
            return this.f316a;
        }

        @Override // com.xiaomi.push.e
        public final void a(com.xiaomi.push.c cVar) {
            if (m8641a()) {
                cVar.m8512a(1, c());
            }
            if (m8642b()) {
                cVar.m8516a(2, m8640a());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public final boolean m8641a() {
            return this.f317a;
        }

        @Override // com.xiaomi.push.e
        public final int b() {
            int i = 0;
            if (m8641a()) {
                i = 0 + com.xiaomi.push.c.a(1, c());
            }
            int i2 = i;
            if (m8642b()) {
                i2 = i + com.xiaomi.push.c.a(2, m8640a());
            }
            this.b = i2;
            return i2;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final boolean m8642b() {
            return this.f318b;
        }

        public final int c() {
            return this.f27670a;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dv$i.class */
    public static final class i extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f320a;

        /* renamed from: a  reason: collision with other field name */
        private com.xiaomi.push.a f319a = com.xiaomi.push.a.f27550a;

        /* renamed from: a  reason: collision with root package name */
        private int f27671a = -1;

        public static i a(byte[] bArr) {
            return (i) new i().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public final int a() {
            if (this.f27671a < 0) {
                b();
            }
            return this.f27671a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final com.xiaomi.push.a m8643a() {
            return this.f319a;
        }

        public final i a(com.xiaomi.push.a aVar) {
            this.f320a = true;
            this.f319a = aVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public final i a(com.xiaomi.push.b bVar) {
            while (true) {
                int m8468a = bVar.m8468a();
                if (m8468a == 0) {
                    return this;
                }
                if (m8468a == 10) {
                    a(bVar.m8470a());
                } else if (!a(bVar, m8468a)) {
                    return this;
                }
            }
        }

        @Override // com.xiaomi.push.e
        public final void a(com.xiaomi.push.c cVar) {
            if (m8644a()) {
                cVar.m8514a(1, m8643a());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public final boolean m8644a() {
            return this.f320a;
        }

        @Override // com.xiaomi.push.e
        public final int b() {
            int i = 0;
            if (m8644a()) {
                i = 0 + com.xiaomi.push.c.a(1, m8643a());
            }
            this.f27671a = i;
            return i;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dv$j.class */
    public static final class j extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f323a;
        private boolean b;

        /* renamed from: a  reason: collision with other field name */
        private com.xiaomi.push.a f321a = com.xiaomi.push.a.f27550a;

        /* renamed from: a  reason: collision with other field name */
        private b f322a = null;

        /* renamed from: a  reason: collision with root package name */
        private int f27672a = -1;

        public static j a(byte[] bArr) {
            return (j) new j().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public final int a() {
            if (this.f27672a < 0) {
                b();
            }
            return this.f27672a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final com.xiaomi.push.a m8645a() {
            return this.f321a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final b m8646a() {
            return this.f322a;
        }

        public final j a(com.xiaomi.push.a aVar) {
            this.f323a = true;
            this.f321a = aVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public final j a(com.xiaomi.push.b bVar) {
            while (true) {
                int m8468a = bVar.m8468a();
                if (m8468a == 0) {
                    return this;
                }
                if (m8468a == 10) {
                    a(bVar.m8470a());
                } else if (m8468a == 18) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, m8468a)) {
                    return this;
                }
            }
        }

        public final j a(b bVar) {
            if (bVar != null) {
                this.b = true;
                this.f322a = bVar;
                return this;
            }
            throw null;
        }

        @Override // com.xiaomi.push.e
        public final void a(com.xiaomi.push.c cVar) {
            if (m8647a()) {
                cVar.m8514a(1, m8645a());
            }
            if (m8648b()) {
                cVar.m8515a(2, (com.xiaomi.push.e) m8646a());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public final boolean m8647a() {
            return this.f323a;
        }

        @Override // com.xiaomi.push.e
        public final int b() {
            int i = 0;
            if (m8647a()) {
                i = 0 + com.xiaomi.push.c.a(1, m8645a());
            }
            int i2 = i;
            if (m8648b()) {
                i2 = i + com.xiaomi.push.c.a(2, (com.xiaomi.push.e) m8646a());
            }
            this.f27672a = i2;
            return i2;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final boolean m8648b() {
            return this.b;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dv$k.class */
    public static final class k extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f326a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f329b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f27674c;
        private boolean d;
        private boolean e;
        private boolean g;

        /* renamed from: a  reason: collision with other field name */
        private String f325a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f328b = "";

        /* renamed from: a  reason: collision with other field name */
        private long f324a = 0;

        /* renamed from: b  reason: collision with other field name */
        private long f327b = 0;
        private boolean f = false;

        /* renamed from: a  reason: collision with root package name */
        private int f27673a = 0;
        private int b = -1;

        public static k a(byte[] bArr) {
            return (k) new k().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public final int a() {
            if (this.b < 0) {
                b();
            }
            return this.b;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final long m8649a() {
            return this.f324a;
        }

        public final k a(int i) {
            this.g = true;
            this.f27673a = i;
            return this;
        }

        public final k a(long j) {
            this.f27674c = true;
            this.f324a = j;
            return this;
        }

        @Override // com.xiaomi.push.e
        public final k a(com.xiaomi.push.b bVar) {
            while (true) {
                int m8468a = bVar.m8468a();
                if (m8468a == 0) {
                    return this;
                }
                if (m8468a == 10) {
                    a(bVar.m8471a());
                } else if (m8468a == 18) {
                    b(bVar.m8471a());
                } else if (m8468a == 24) {
                    a(bVar.m8469a());
                } else if (m8468a == 32) {
                    b(bVar.m8469a());
                } else if (m8468a == 40) {
                    a(bVar.m8474a());
                } else if (m8468a == 48) {
                    a(bVar.m8477b());
                } else if (!a(bVar, m8468a)) {
                    return this;
                }
            }
        }

        public final k a(String str) {
            this.f326a = true;
            this.f325a = str;
            return this;
        }

        public final k a(boolean z) {
            this.e = true;
            this.f = z;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final String m8650a() {
            return this.f325a;
        }

        @Override // com.xiaomi.push.e
        public final void a(com.xiaomi.push.c cVar) {
            if (m8651a()) {
                cVar.m8516a(1, m8650a());
            }
            if (m8654b()) {
                cVar.m8516a(2, m8653b());
            }
            if (m8655c()) {
                cVar.m8513a(3, m8649a());
            }
            if (d()) {
                cVar.m8513a(4, m8652b());
            }
            if (f()) {
                cVar.m8517a(5, e());
            }
            if (g()) {
                cVar.m8512a(6, c());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public final boolean m8651a() {
            return this.f326a;
        }

        @Override // com.xiaomi.push.e
        public final int b() {
            int i = 0;
            if (m8651a()) {
                i = 0 + com.xiaomi.push.c.a(1, m8650a());
            }
            int i2 = i;
            if (m8654b()) {
                i2 = i + com.xiaomi.push.c.a(2, m8653b());
            }
            int i3 = i2;
            if (m8655c()) {
                i3 = i2 + com.xiaomi.push.c.a(3, m8649a());
            }
            int i4 = i3;
            if (d()) {
                i4 = i3 + com.xiaomi.push.c.a(4, m8652b());
            }
            int i5 = i4;
            if (f()) {
                i5 = i4 + com.xiaomi.push.c.a(5, e());
            }
            int i6 = i5;
            if (g()) {
                i6 = i5 + com.xiaomi.push.c.a(6, c());
            }
            this.b = i6;
            return i6;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final long m8652b() {
            return this.f327b;
        }

        public final k b(long j) {
            this.d = true;
            this.f327b = j;
            return this;
        }

        public final k b(String str) {
            this.f329b = true;
            this.f328b = str;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final String m8653b() {
            return this.f328b;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final boolean m8654b() {
            return this.f329b;
        }

        public final int c() {
            return this.f27673a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public final boolean m8655c() {
            return this.f27674c;
        }

        public final boolean d() {
            return this.d;
        }

        public final boolean e() {
            return this.f;
        }

        public final boolean f() {
            return this.e;
        }

        public final boolean g() {
            return this.g;
        }
    }
}
