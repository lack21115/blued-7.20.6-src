package com.xiaomi.push;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dv.class */
public final class dv {

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dv$a.class */
    public static final class a extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f319a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f321b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f323c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f325d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f327e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f328f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;

        /* renamed from: a  reason: collision with root package name */
        private int f41347a = 0;

        /* renamed from: a  reason: collision with other field name */
        private long f317a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f318a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f320b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f322c = "";

        /* renamed from: d  reason: collision with other field name */
        private String f324d = "";

        /* renamed from: e  reason: collision with other field name */
        private String f326e = "";
        private int b = 1;

        /* renamed from: c  reason: collision with root package name */
        private int f41348c = 0;
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
        public final long m11636a() {
            return this.f317a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final a m11637a() {
            this.f328f = false;
            this.f324d = "";
            return this;
        }

        public final a a(int i) {
            this.f319a = true;
            this.f41347a = i;
            return this;
        }

        public final a a(long j) {
            this.f321b = true;
            this.f317a = j;
            return this;
        }

        @Override // com.xiaomi.push.e
        public final a a(com.xiaomi.push.b bVar) {
            while (true) {
                int m11518a = bVar.m11518a();
                switch (m11518a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.m11527b());
                        break;
                    case 16:
                        a(bVar.m11528b());
                        break;
                    case 26:
                        a(bVar.m11521a());
                        break;
                    case 34:
                        b(bVar.m11521a());
                        break;
                    case 42:
                        c(bVar.m11521a());
                        break;
                    case 50:
                        d(bVar.m11521a());
                        break;
                    case 58:
                        e(bVar.m11521a());
                        break;
                    case 64:
                        b(bVar.m11527b());
                        break;
                    case 72:
                        c(bVar.m11527b());
                        break;
                    case 80:
                        d(bVar.m11527b());
                        break;
                    case 90:
                        f(bVar.m11521a());
                        break;
                    default:
                        if (a(bVar, m11518a)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public final a a(String str) {
            this.f323c = true;
            this.f318a = str;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final String m11638a() {
            return this.f318a;
        }

        @Override // com.xiaomi.push.e
        public final void a(com.xiaomi.push.c cVar) {
            if (m11639a()) {
                cVar.m11562a(1, c());
            }
            if (m11641b()) {
                cVar.m11576b(2, m11636a());
            }
            if (m11643c()) {
                cVar.m11566a(3, m11638a());
            }
            if (m11645d()) {
                cVar.m11566a(4, m11640b());
            }
            if (m11647e()) {
                cVar.m11566a(5, m11642c());
            }
            if (m11649f()) {
                cVar.m11566a(6, m11644d());
            }
            if (g()) {
                cVar.m11566a(7, m11646e());
            }
            if (h()) {
                cVar.m11562a(8, d());
            }
            if (i()) {
                cVar.m11562a(9, e());
            }
            if (j()) {
                cVar.m11562a(10, f());
            }
            if (k()) {
                cVar.m11566a(11, m11648f());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public final boolean m11639a() {
            return this.f319a;
        }

        @Override // com.xiaomi.push.e
        public final int b() {
            int i = 0;
            if (m11639a()) {
                i = 0 + com.xiaomi.push.c.a(1, c());
            }
            int i2 = i;
            if (m11641b()) {
                i2 = i + com.xiaomi.push.c.b(2, m11636a());
            }
            int i3 = i2;
            if (m11643c()) {
                i3 = i2 + com.xiaomi.push.c.a(3, m11638a());
            }
            int i4 = i3;
            if (m11645d()) {
                i4 = i3 + com.xiaomi.push.c.a(4, m11640b());
            }
            int i5 = i4;
            if (m11647e()) {
                i5 = i4 + com.xiaomi.push.c.a(5, m11642c());
            }
            int i6 = i5;
            if (m11649f()) {
                i6 = i5 + com.xiaomi.push.c.a(6, m11644d());
            }
            int i7 = i6;
            if (g()) {
                i7 = i6 + com.xiaomi.push.c.a(7, m11646e());
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
                i11 = i10 + com.xiaomi.push.c.a(11, m11648f());
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
            this.f325d = true;
            this.f320b = str;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final String m11640b() {
            return this.f320b;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final boolean m11641b() {
            return this.f321b;
        }

        public final int c() {
            return this.f41347a;
        }

        public final a c(int i) {
            this.i = true;
            this.f41348c = i;
            return this;
        }

        public final a c(String str) {
            this.f327e = true;
            this.f322c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public final String m11642c() {
            return this.f322c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public final boolean m11643c() {
            return this.f323c;
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
            this.f328f = true;
            this.f324d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public final String m11644d() {
            return this.f324d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public final boolean m11645d() {
            return this.f325d;
        }

        public final int e() {
            return this.f41348c;
        }

        public final a e(String str) {
            this.g = true;
            this.f326e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public final String m11646e() {
            return this.f326e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public final boolean m11647e() {
            return this.f327e;
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
        public final String m11648f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public final boolean m11649f() {
            return this.f328f;
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
        private boolean f329a;

        /* renamed from: c  reason: collision with other field name */
        private boolean f331c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f332d;
        private boolean e;

        /* renamed from: b  reason: collision with other field name */
        private boolean f330b = false;

        /* renamed from: a  reason: collision with root package name */
        private int f41349a = 0;
        private int b = 0;

        /* renamed from: c  reason: collision with root package name */
        private int f41350c = 0;
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
            this.f331c = true;
            this.f41349a = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public final b a(com.xiaomi.push.b bVar) {
            while (true) {
                int m11518a = bVar.m11518a();
                if (m11518a == 0) {
                    return this;
                }
                if (m11518a == 8) {
                    a(bVar.m11524a());
                } else if (m11518a == 24) {
                    a(bVar.m11527b());
                } else if (m11518a == 32) {
                    b(bVar.m11527b());
                } else if (m11518a == 40) {
                    c(bVar.m11527b());
                } else if (!a(bVar, m11518a)) {
                    return this;
                }
            }
        }

        public final b a(boolean z) {
            this.f329a = true;
            this.f330b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public final void a(com.xiaomi.push.c cVar) {
            if (m11651b()) {
                cVar.m11567a(1, m11650a());
            }
            if (m11652c()) {
                cVar.m11562a(3, c());
            }
            if (m11653d()) {
                cVar.m11562a(4, d());
            }
            if (m11654e()) {
                cVar.m11562a(5, e());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public final boolean m11650a() {
            return this.f330b;
        }

        @Override // com.xiaomi.push.e
        public final int b() {
            int i = 0;
            if (m11651b()) {
                i = 0 + com.xiaomi.push.c.a(1, m11650a());
            }
            int i2 = i;
            if (m11652c()) {
                i2 = i + com.xiaomi.push.c.a(3, c());
            }
            int i3 = i2;
            if (m11653d()) {
                i3 = i2 + com.xiaomi.push.c.a(4, d());
            }
            int i4 = i3;
            if (m11654e()) {
                i4 = i3 + com.xiaomi.push.c.a(5, e());
            }
            this.d = i4;
            return i4;
        }

        public final b b(int i) {
            this.f332d = true;
            this.b = i;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final boolean m11651b() {
            return this.f329a;
        }

        public final int c() {
            return this.f41349a;
        }

        public final b c(int i) {
            this.e = true;
            this.f41350c = i;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public final boolean m11652c() {
            return this.f331c;
        }

        public final int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public final boolean m11653d() {
            return this.f332d;
        }

        public final int e() {
            return this.f41350c;
        }

        /* renamed from: e  reason: collision with other method in class */
        public final boolean m11654e() {
            return this.e;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dv$c.class */
    public static final class c extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f334a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f335b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f336c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f337d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f338e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f339f;

        /* renamed from: a  reason: collision with other field name */
        private String f333a = "";
        private String b = "";

        /* renamed from: c  reason: collision with root package name */
        private String f41352c = "";
        private String d = "";
        private String e = "";
        private String f = "";

        /* renamed from: a  reason: collision with root package name */
        private int f41351a = -1;

        @Override // com.xiaomi.push.e
        public final int a() {
            if (this.f41351a < 0) {
                b();
            }
            return this.f41351a;
        }

        @Override // com.xiaomi.push.e
        public final c a(com.xiaomi.push.b bVar) {
            while (true) {
                int m11518a = bVar.m11518a();
                if (m11518a == 0) {
                    return this;
                }
                if (m11518a == 10) {
                    a(bVar.m11521a());
                } else if (m11518a == 18) {
                    b(bVar.m11521a());
                } else if (m11518a == 26) {
                    c(bVar.m11521a());
                } else if (m11518a == 34) {
                    d(bVar.m11521a());
                } else if (m11518a == 42) {
                    e(bVar.m11521a());
                } else if (m11518a == 50) {
                    f(bVar.m11521a());
                } else if (!a(bVar, m11518a)) {
                    return this;
                }
            }
        }

        public final c a(String str) {
            this.f334a = true;
            this.f333a = str;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final String m11655a() {
            return this.f333a;
        }

        @Override // com.xiaomi.push.e
        public final void a(com.xiaomi.push.c cVar) {
            if (m11656a()) {
                cVar.m11566a(1, m11655a());
            }
            if (m11658b()) {
                cVar.m11566a(2, m11657b());
            }
            if (m11659c()) {
                cVar.m11566a(3, c());
            }
            if (m11660d()) {
                cVar.m11566a(4, d());
            }
            if (m11661e()) {
                cVar.m11566a(5, e());
            }
            if (m11662f()) {
                cVar.m11566a(6, f());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public final boolean m11656a() {
            return this.f334a;
        }

        @Override // com.xiaomi.push.e
        public final int b() {
            int i = 0;
            if (m11656a()) {
                i = 0 + com.xiaomi.push.c.a(1, m11655a());
            }
            int i2 = i;
            if (m11658b()) {
                i2 = i + com.xiaomi.push.c.a(2, m11657b());
            }
            int i3 = i2;
            if (m11659c()) {
                i3 = i2 + com.xiaomi.push.c.a(3, c());
            }
            int i4 = i3;
            if (m11660d()) {
                i4 = i3 + com.xiaomi.push.c.a(4, d());
            }
            int i5 = i4;
            if (m11661e()) {
                i5 = i4 + com.xiaomi.push.c.a(5, e());
            }
            int i6 = i5;
            if (m11662f()) {
                i6 = i5 + com.xiaomi.push.c.a(6, f());
            }
            this.f41351a = i6;
            return i6;
        }

        public final c b(String str) {
            this.f335b = true;
            this.b = str;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final String m11657b() {
            return this.b;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final boolean m11658b() {
            return this.f335b;
        }

        public final c c(String str) {
            this.f336c = true;
            this.f41352c = str;
            return this;
        }

        public final String c() {
            return this.f41352c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public final boolean m11659c() {
            return this.f336c;
        }

        public final c d(String str) {
            this.f337d = true;
            this.d = str;
            return this;
        }

        public final String d() {
            return this.d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public final boolean m11660d() {
            return this.f337d;
        }

        public final c e(String str) {
            this.f338e = true;
            this.e = str;
            return this;
        }

        public final String e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public final boolean m11661e() {
            return this.f338e;
        }

        public final c f(String str) {
            this.f339f = true;
            this.f = str;
            return this;
        }

        public final String f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public final boolean m11662f() {
            return this.f339f;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dv$d.class */
    public static final class d extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f341a;

        /* renamed from: c  reason: collision with other field name */
        private boolean f343c;
        private boolean d;
        private boolean e;

        /* renamed from: b  reason: collision with other field name */
        private boolean f342b = false;

        /* renamed from: a  reason: collision with other field name */
        private String f340a = "";
        private String b = "";

        /* renamed from: c  reason: collision with root package name */
        private String f41354c = "";

        /* renamed from: a  reason: collision with root package name */
        private int f41353a = -1;

        public static d a(byte[] bArr) {
            return (d) new d().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public final int a() {
            if (this.f41353a < 0) {
                b();
            }
            return this.f41353a;
        }

        @Override // com.xiaomi.push.e
        public final d a(com.xiaomi.push.b bVar) {
            while (true) {
                int m11518a = bVar.m11518a();
                if (m11518a == 0) {
                    return this;
                }
                if (m11518a == 8) {
                    a(bVar.m11524a());
                } else if (m11518a == 18) {
                    a(bVar.m11521a());
                } else if (m11518a == 26) {
                    b(bVar.m11521a());
                } else if (m11518a == 34) {
                    c(bVar.m11521a());
                } else if (!a(bVar, m11518a)) {
                    return this;
                }
            }
        }

        public final d a(String str) {
            this.f343c = true;
            this.f340a = str;
            return this;
        }

        public final d a(boolean z) {
            this.f341a = true;
            this.f342b = z;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final String m11663a() {
            return this.f340a;
        }

        @Override // com.xiaomi.push.e
        public final void a(com.xiaomi.push.c cVar) {
            if (m11666b()) {
                cVar.m11567a(1, m11664a());
            }
            if (m11667c()) {
                cVar.m11566a(2, m11663a());
            }
            if (d()) {
                cVar.m11566a(3, m11665b());
            }
            if (e()) {
                cVar.m11566a(4, c());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public final boolean m11664a() {
            return this.f342b;
        }

        @Override // com.xiaomi.push.e
        public final int b() {
            int i = 0;
            if (m11666b()) {
                i = 0 + com.xiaomi.push.c.a(1, m11664a());
            }
            int i2 = i;
            if (m11667c()) {
                i2 = i + com.xiaomi.push.c.a(2, m11663a());
            }
            int i3 = i2;
            if (d()) {
                i3 = i2 + com.xiaomi.push.c.a(3, m11665b());
            }
            int i4 = i3;
            if (e()) {
                i4 = i3 + com.xiaomi.push.c.a(4, c());
            }
            this.f41353a = i4;
            return i4;
        }

        public final d b(String str) {
            this.d = true;
            this.b = str;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final String m11665b() {
            return this.b;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final boolean m11666b() {
            return this.f341a;
        }

        public final d c(String str) {
            this.e = true;
            this.f41354c = str;
            return this;
        }

        public final String c() {
            return this.f41354c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public final boolean m11667c() {
            return this.f343c;
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
        private boolean f346a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f348b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f350c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f352d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f353e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f354f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;

        /* renamed from: a  reason: collision with root package name */
        private int f41355a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f345a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f347b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f349c = "";
        private int b = 0;

        /* renamed from: d  reason: collision with other field name */
        private String f351d = "";
        private String e = "";
        private String f = "";

        /* renamed from: a  reason: collision with other field name */
        private b f344a = null;

        /* renamed from: c  reason: collision with root package name */
        private int f41356c = 0;
        private int d = -1;

        @Override // com.xiaomi.push.e
        public final int a() {
            if (this.d < 0) {
                b();
            }
            return this.d;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final b m11668a() {
            return this.f344a;
        }

        public final e a(int i) {
            this.f346a = true;
            this.f41355a = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public final e a(com.xiaomi.push.b bVar) {
            while (true) {
                int m11518a = bVar.m11518a();
                switch (m11518a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.c());
                        break;
                    case 18:
                        a(bVar.m11521a());
                        break;
                    case 26:
                        b(bVar.m11521a());
                        break;
                    case 34:
                        c(bVar.m11521a());
                        break;
                    case 40:
                        b(bVar.m11527b());
                        break;
                    case 50:
                        d(bVar.m11521a());
                        break;
                    case 58:
                        e(bVar.m11521a());
                        break;
                    case 66:
                        f(bVar.m11521a());
                        break;
                    case 74:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    case 80:
                        c(bVar.m11527b());
                        break;
                    default:
                        if (a(bVar, m11518a)) {
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
                this.f344a = bVar;
                return this;
            }
            throw null;
        }

        public final e a(String str) {
            this.f348b = true;
            this.f345a = str;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final String m11669a() {
            return this.f345a;
        }

        @Override // com.xiaomi.push.e
        public final void a(com.xiaomi.push.c cVar) {
            if (m11670a()) {
                cVar.m11575b(1, c());
            }
            if (m11672b()) {
                cVar.m11566a(2, m11669a());
            }
            if (m11674c()) {
                cVar.m11566a(3, m11671b());
            }
            if (m11676d()) {
                cVar.m11566a(4, m11673c());
            }
            if (m11678e()) {
                cVar.m11562a(5, d());
            }
            if (m11679f()) {
                cVar.m11566a(6, m11675d());
            }
            if (g()) {
                cVar.m11566a(7, m11677e());
            }
            if (h()) {
                cVar.m11566a(8, f());
            }
            if (i()) {
                cVar.m11565a(9, (com.xiaomi.push.e) m11668a());
            }
            if (j()) {
                cVar.m11562a(10, e());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public final boolean m11670a() {
            return this.f346a;
        }

        @Override // com.xiaomi.push.e
        public final int b() {
            int i = 0;
            if (m11670a()) {
                i = 0 + com.xiaomi.push.c.b(1, c());
            }
            int i2 = i;
            if (m11672b()) {
                i2 = i + com.xiaomi.push.c.a(2, m11669a());
            }
            int i3 = i2;
            if (m11674c()) {
                i3 = i2 + com.xiaomi.push.c.a(3, m11671b());
            }
            int i4 = i3;
            if (m11676d()) {
                i4 = i3 + com.xiaomi.push.c.a(4, m11673c());
            }
            int i5 = i4;
            if (m11678e()) {
                i5 = i4 + com.xiaomi.push.c.a(5, d());
            }
            int i6 = i5;
            if (m11679f()) {
                i6 = i5 + com.xiaomi.push.c.a(6, m11675d());
            }
            int i7 = i6;
            if (g()) {
                i7 = i6 + com.xiaomi.push.c.a(7, m11677e());
            }
            int i8 = i7;
            if (h()) {
                i8 = i7 + com.xiaomi.push.c.a(8, f());
            }
            int i9 = i8;
            if (i()) {
                i9 = i8 + com.xiaomi.push.c.a(9, (com.xiaomi.push.e) m11668a());
            }
            int i10 = i9;
            if (j()) {
                i10 = i9 + com.xiaomi.push.c.a(10, e());
            }
            this.d = i10;
            return i10;
        }

        public final e b(int i) {
            this.f353e = true;
            this.b = i;
            return this;
        }

        public final e b(String str) {
            this.f350c = true;
            this.f347b = str;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final String m11671b() {
            return this.f347b;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final boolean m11672b() {
            return this.f348b;
        }

        public final int c() {
            return this.f41355a;
        }

        public final e c(int i) {
            this.j = true;
            this.f41356c = i;
            return this;
        }

        public final e c(String str) {
            this.f352d = true;
            this.f349c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public final String m11673c() {
            return this.f349c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public final boolean m11674c() {
            return this.f350c;
        }

        public final int d() {
            return this.b;
        }

        public final e d(String str) {
            this.f354f = true;
            this.f351d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public final String m11675d() {
            return this.f351d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public final boolean m11676d() {
            return this.f352d;
        }

        public final int e() {
            return this.f41356c;
        }

        public final e e(String str) {
            this.g = true;
            this.e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public final String m11677e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public final boolean m11678e() {
            return this.f353e;
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
        public final boolean m11679f() {
            return this.f354f;
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
        private boolean f357a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f358b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f41358c;

        /* renamed from: a  reason: collision with other field name */
        private String f356a = "";
        private String b = "";

        /* renamed from: a  reason: collision with other field name */
        private b f355a = null;

        /* renamed from: a  reason: collision with root package name */
        private int f41357a = -1;

        public static f a(byte[] bArr) {
            return (f) new f().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public final int a() {
            if (this.f41357a < 0) {
                b();
            }
            return this.f41357a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final b m11680a() {
            return this.f355a;
        }

        @Override // com.xiaomi.push.e
        public final f a(com.xiaomi.push.b bVar) {
            while (true) {
                int m11518a = bVar.m11518a();
                if (m11518a == 0) {
                    return this;
                }
                if (m11518a == 10) {
                    a(bVar.m11521a());
                } else if (m11518a == 18) {
                    b(bVar.m11521a());
                } else if (m11518a == 26) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, m11518a)) {
                    return this;
                }
            }
        }

        public final f a(b bVar) {
            if (bVar != null) {
                this.f41358c = true;
                this.f355a = bVar;
                return this;
            }
            throw null;
        }

        public final f a(String str) {
            this.f357a = true;
            this.f356a = str;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final String m11681a() {
            return this.f356a;
        }

        @Override // com.xiaomi.push.e
        public final void a(com.xiaomi.push.c cVar) {
            if (m11682a()) {
                cVar.m11566a(1, m11681a());
            }
            if (m11684b()) {
                cVar.m11566a(2, m11683b());
            }
            if (c()) {
                cVar.m11565a(3, (com.xiaomi.push.e) m11680a());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public final boolean m11682a() {
            return this.f357a;
        }

        @Override // com.xiaomi.push.e
        public final int b() {
            int i = 0;
            if (m11682a()) {
                i = 0 + com.xiaomi.push.c.a(1, m11681a());
            }
            int i2 = i;
            if (m11684b()) {
                i2 = i + com.xiaomi.push.c.a(2, m11683b());
            }
            int i3 = i2;
            if (c()) {
                i3 = i2 + com.xiaomi.push.c.a(3, (com.xiaomi.push.e) m11680a());
            }
            this.f41357a = i3;
            return i3;
        }

        public final f b(String str) {
            this.f358b = true;
            this.b = str;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final String m11683b() {
            return this.b;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final boolean m11684b() {
            return this.f358b;
        }

        public final boolean c() {
            return this.f41358c;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dv$g.class */
    public static final class g extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f360a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f361b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f362c;

        /* renamed from: a  reason: collision with other field name */
        private String f359a = "";
        private String b = "";

        /* renamed from: c  reason: collision with root package name */
        private String f41360c = "";

        /* renamed from: a  reason: collision with root package name */
        private int f41359a = -1;

        public static g a(byte[] bArr) {
            return (g) new g().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public final int a() {
            if (this.f41359a < 0) {
                b();
            }
            return this.f41359a;
        }

        @Override // com.xiaomi.push.e
        public final g a(com.xiaomi.push.b bVar) {
            while (true) {
                int m11518a = bVar.m11518a();
                if (m11518a == 0) {
                    return this;
                }
                if (m11518a == 10) {
                    a(bVar.m11521a());
                } else if (m11518a == 18) {
                    b(bVar.m11521a());
                } else if (m11518a == 26) {
                    c(bVar.m11521a());
                } else if (!a(bVar, m11518a)) {
                    return this;
                }
            }
        }

        public final g a(String str) {
            this.f360a = true;
            this.f359a = str;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final String m11685a() {
            return this.f359a;
        }

        @Override // com.xiaomi.push.e
        public final void a(com.xiaomi.push.c cVar) {
            if (m11686a()) {
                cVar.m11566a(1, m11685a());
            }
            if (m11688b()) {
                cVar.m11566a(2, m11687b());
            }
            if (m11689c()) {
                cVar.m11566a(3, c());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public final boolean m11686a() {
            return this.f360a;
        }

        @Override // com.xiaomi.push.e
        public final int b() {
            int i = 0;
            if (m11686a()) {
                i = 0 + com.xiaomi.push.c.a(1, m11685a());
            }
            int i2 = i;
            if (m11688b()) {
                i2 = i + com.xiaomi.push.c.a(2, m11687b());
            }
            int i3 = i2;
            if (m11689c()) {
                i3 = i2 + com.xiaomi.push.c.a(3, c());
            }
            this.f41359a = i3;
            return i3;
        }

        public final g b(String str) {
            this.f361b = true;
            this.b = str;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final String m11687b() {
            return this.b;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final boolean m11688b() {
            return this.f361b;
        }

        public final g c(String str) {
            this.f362c = true;
            this.f41360c = str;
            return this;
        }

        public final String c() {
            return this.f41360c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public final boolean m11689c() {
            return this.f362c;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dv$h.class */
    public static final class h extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f364a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f365b;

        /* renamed from: a  reason: collision with root package name */
        private int f41361a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f363a = "";
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
            this.f364a = true;
            this.f41361a = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public final h a(com.xiaomi.push.b bVar) {
            while (true) {
                int m11518a = bVar.m11518a();
                if (m11518a == 0) {
                    return this;
                }
                if (m11518a == 8) {
                    a(bVar.m11527b());
                } else if (m11518a == 18) {
                    a(bVar.m11521a());
                } else if (!a(bVar, m11518a)) {
                    return this;
                }
            }
        }

        public final h a(String str) {
            this.f365b = true;
            this.f363a = str;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final String m11690a() {
            return this.f363a;
        }

        @Override // com.xiaomi.push.e
        public final void a(com.xiaomi.push.c cVar) {
            if (m11691a()) {
                cVar.m11562a(1, c());
            }
            if (m11692b()) {
                cVar.m11566a(2, m11690a());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public final boolean m11691a() {
            return this.f364a;
        }

        @Override // com.xiaomi.push.e
        public final int b() {
            int i = 0;
            if (m11691a()) {
                i = 0 + com.xiaomi.push.c.a(1, c());
            }
            int i2 = i;
            if (m11692b()) {
                i2 = i + com.xiaomi.push.c.a(2, m11690a());
            }
            this.b = i2;
            return i2;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final boolean m11692b() {
            return this.f365b;
        }

        public final int c() {
            return this.f41361a;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dv$i.class */
    public static final class i extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f367a;

        /* renamed from: a  reason: collision with other field name */
        private com.xiaomi.push.a f366a = com.xiaomi.push.a.f41241a;

        /* renamed from: a  reason: collision with root package name */
        private int f41362a = -1;

        public static i a(byte[] bArr) {
            return (i) new i().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public final int a() {
            if (this.f41362a < 0) {
                b();
            }
            return this.f41362a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final com.xiaomi.push.a m11693a() {
            return this.f366a;
        }

        public final i a(com.xiaomi.push.a aVar) {
            this.f367a = true;
            this.f366a = aVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public final i a(com.xiaomi.push.b bVar) {
            while (true) {
                int m11518a = bVar.m11518a();
                if (m11518a == 0) {
                    return this;
                }
                if (m11518a == 10) {
                    a(bVar.m11520a());
                } else if (!a(bVar, m11518a)) {
                    return this;
                }
            }
        }

        @Override // com.xiaomi.push.e
        public final void a(com.xiaomi.push.c cVar) {
            if (m11694a()) {
                cVar.m11564a(1, m11693a());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public final boolean m11694a() {
            return this.f367a;
        }

        @Override // com.xiaomi.push.e
        public final int b() {
            int i = 0;
            if (m11694a()) {
                i = 0 + com.xiaomi.push.c.a(1, m11693a());
            }
            this.f41362a = i;
            return i;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dv$j.class */
    public static final class j extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f370a;
        private boolean b;

        /* renamed from: a  reason: collision with other field name */
        private com.xiaomi.push.a f368a = com.xiaomi.push.a.f41241a;

        /* renamed from: a  reason: collision with other field name */
        private b f369a = null;

        /* renamed from: a  reason: collision with root package name */
        private int f41363a = -1;

        public static j a(byte[] bArr) {
            return (j) new j().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public final int a() {
            if (this.f41363a < 0) {
                b();
            }
            return this.f41363a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final com.xiaomi.push.a m11695a() {
            return this.f368a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final b m11696a() {
            return this.f369a;
        }

        public final j a(com.xiaomi.push.a aVar) {
            this.f370a = true;
            this.f368a = aVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public final j a(com.xiaomi.push.b bVar) {
            while (true) {
                int m11518a = bVar.m11518a();
                if (m11518a == 0) {
                    return this;
                }
                if (m11518a == 10) {
                    a(bVar.m11520a());
                } else if (m11518a == 18) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, m11518a)) {
                    return this;
                }
            }
        }

        public final j a(b bVar) {
            if (bVar != null) {
                this.b = true;
                this.f369a = bVar;
                return this;
            }
            throw null;
        }

        @Override // com.xiaomi.push.e
        public final void a(com.xiaomi.push.c cVar) {
            if (m11697a()) {
                cVar.m11564a(1, m11695a());
            }
            if (m11698b()) {
                cVar.m11565a(2, (com.xiaomi.push.e) m11696a());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public final boolean m11697a() {
            return this.f370a;
        }

        @Override // com.xiaomi.push.e
        public final int b() {
            int i = 0;
            if (m11697a()) {
                i = 0 + com.xiaomi.push.c.a(1, m11695a());
            }
            int i2 = i;
            if (m11698b()) {
                i2 = i + com.xiaomi.push.c.a(2, (com.xiaomi.push.e) m11696a());
            }
            this.f41363a = i2;
            return i2;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final boolean m11698b() {
            return this.b;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dv$k.class */
    public static final class k extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f373a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f376b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f41365c;
        private boolean d;
        private boolean e;
        private boolean g;

        /* renamed from: a  reason: collision with other field name */
        private String f372a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f375b = "";

        /* renamed from: a  reason: collision with other field name */
        private long f371a = 0;

        /* renamed from: b  reason: collision with other field name */
        private long f374b = 0;
        private boolean f = false;

        /* renamed from: a  reason: collision with root package name */
        private int f41364a = 0;
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
        public final long m11699a() {
            return this.f371a;
        }

        public final k a(int i) {
            this.g = true;
            this.f41364a = i;
            return this;
        }

        public final k a(long j) {
            this.f41365c = true;
            this.f371a = j;
            return this;
        }

        @Override // com.xiaomi.push.e
        public final k a(com.xiaomi.push.b bVar) {
            while (true) {
                int m11518a = bVar.m11518a();
                if (m11518a == 0) {
                    return this;
                }
                if (m11518a == 10) {
                    a(bVar.m11521a());
                } else if (m11518a == 18) {
                    b(bVar.m11521a());
                } else if (m11518a == 24) {
                    a(bVar.m11519a());
                } else if (m11518a == 32) {
                    b(bVar.m11519a());
                } else if (m11518a == 40) {
                    a(bVar.m11524a());
                } else if (m11518a == 48) {
                    a(bVar.m11527b());
                } else if (!a(bVar, m11518a)) {
                    return this;
                }
            }
        }

        public final k a(String str) {
            this.f373a = true;
            this.f372a = str;
            return this;
        }

        public final k a(boolean z) {
            this.e = true;
            this.f = z;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final String m11700a() {
            return this.f372a;
        }

        @Override // com.xiaomi.push.e
        public final void a(com.xiaomi.push.c cVar) {
            if (m11701a()) {
                cVar.m11566a(1, m11700a());
            }
            if (m11704b()) {
                cVar.m11566a(2, m11703b());
            }
            if (m11705c()) {
                cVar.m11563a(3, m11699a());
            }
            if (d()) {
                cVar.m11563a(4, m11702b());
            }
            if (f()) {
                cVar.m11567a(5, e());
            }
            if (g()) {
                cVar.m11562a(6, c());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public final boolean m11701a() {
            return this.f373a;
        }

        @Override // com.xiaomi.push.e
        public final int b() {
            int i = 0;
            if (m11701a()) {
                i = 0 + com.xiaomi.push.c.a(1, m11700a());
            }
            int i2 = i;
            if (m11704b()) {
                i2 = i + com.xiaomi.push.c.a(2, m11703b());
            }
            int i3 = i2;
            if (m11705c()) {
                i3 = i2 + com.xiaomi.push.c.a(3, m11699a());
            }
            int i4 = i3;
            if (d()) {
                i4 = i3 + com.xiaomi.push.c.a(4, m11702b());
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
        public final long m11702b() {
            return this.f374b;
        }

        public final k b(long j) {
            this.d = true;
            this.f374b = j;
            return this;
        }

        public final k b(String str) {
            this.f376b = true;
            this.f375b = str;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final String m11703b() {
            return this.f375b;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final boolean m11704b() {
            return this.f376b;
        }

        public final int c() {
            return this.f41364a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public final boolean m11705c() {
            return this.f41365c;
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
