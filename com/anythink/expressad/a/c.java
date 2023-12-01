package com.anythink.expressad.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.anythink.expressad.foundation.g.g.a;
import java.io.Serializable;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/a/c.class */
public final class c extends d {
    private static final boolean i = true;
    private int l;
    private com.anythink.expressad.foundation.g.g.c o;
    private h p;
    private int j = 0;
    private String k = null;

    /* renamed from: a  reason: collision with root package name */
    b f4119a = null;
    private e m = null;
    private boolean n = true;
    private Handler q = new Handler(Looper.getMainLooper());

    /* renamed from: com.anythink.expressad.a.c$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/a/c$1.class */
    final class AnonymousClass1 implements a.b {
        private AnonymousClass1() {
        }

        @Override // com.anythink.expressad.foundation.g.g.a.b
        public final void a(a.EnumC0076a enumC0076a) {
            if (enumC0076a == a.EnumC0076a.FINISH && c.this.n) {
                c.this.q.post(new Runnable() { // from class: com.anythink.expressad.a.c.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (c.this.m != null) {
                            if (c.this.f4119a.g()) {
                                e unused = c.this.m;
                                return;
                            }
                            e unused2 = c.this.m;
                            c.this.f4119a.h();
                        }
                    }
                });
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/a/c$a.class */
    final class a extends com.anythink.expressad.foundation.g.g.a {
        private a() {
        }

        private /* synthetic */ a(c cVar, byte b) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:102:0x02a6 A[Catch: Exception -> 0x0346, TRY_LEAVE, TryCatch #0 {Exception -> 0x0346, blocks: (B:2:0x0000, B:6:0x0019, B:9:0x0024, B:32:0x00f1, B:58:0x0185, B:68:0x01b2, B:70:0x01ba, B:72:0x01c4, B:75:0x01d1, B:78:0x01eb, B:76:0x01df, B:79:0x01f8, B:80:0x0206, B:82:0x020e, B:83:0x021c, B:85:0x0229, B:86:0x0241, B:53:0x0172, B:57:0x017d, B:91:0x0265, B:93:0x026c, B:95:0x026e, B:97:0x027f, B:100:0x0294, B:102:0x02a6, B:113:0x0330, B:103:0x02d0, B:105:0x02dc, B:110:0x02f5, B:108:0x02ea, B:111:0x0308), top: B:123:0x0000 }] */
        /* JADX WARN: Removed duplicated region for block: B:103:0x02d0 A[Catch: Exception -> 0x0346, TRY_ENTER, TryCatch #0 {Exception -> 0x0346, blocks: (B:2:0x0000, B:6:0x0019, B:9:0x0024, B:32:0x00f1, B:58:0x0185, B:68:0x01b2, B:70:0x01ba, B:72:0x01c4, B:75:0x01d1, B:78:0x01eb, B:76:0x01df, B:79:0x01f8, B:80:0x0206, B:82:0x020e, B:83:0x021c, B:85:0x0229, B:86:0x0241, B:53:0x0172, B:57:0x017d, B:91:0x0265, B:93:0x026c, B:95:0x026e, B:97:0x027f, B:100:0x0294, B:102:0x02a6, B:113:0x0330, B:103:0x02d0, B:105:0x02dc, B:110:0x02f5, B:108:0x02ea, B:111:0x0308), top: B:123:0x0000 }] */
        /* JADX WARN: Removed duplicated region for block: B:133:0x020e A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:138:0x014b A[EDGE_INSN: B:138:0x014b->B:48:0x014b ?: BREAK  , SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0178  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x021c A[Catch: Exception -> 0x0346, TRY_ENTER, TryCatch #0 {Exception -> 0x0346, blocks: (B:2:0x0000, B:6:0x0019, B:9:0x0024, B:32:0x00f1, B:58:0x0185, B:68:0x01b2, B:70:0x01ba, B:72:0x01c4, B:75:0x01d1, B:78:0x01eb, B:76:0x01df, B:79:0x01f8, B:80:0x0206, B:82:0x020e, B:83:0x021c, B:85:0x0229, B:86:0x0241, B:53:0x0172, B:57:0x017d, B:91:0x0265, B:93:0x026c, B:95:0x026e, B:97:0x027f, B:100:0x0294, B:102:0x02a6, B:113:0x0330, B:103:0x02d0, B:105:0x02dc, B:110:0x02f5, B:108:0x02ea, B:111:0x0308), top: B:123:0x0000 }] */
        /* JADX WARN: Removed duplicated region for block: B:91:0x0265 A[Catch: Exception -> 0x0346, TRY_ENTER, TryCatch #0 {Exception -> 0x0346, blocks: (B:2:0x0000, B:6:0x0019, B:9:0x0024, B:32:0x00f1, B:58:0x0185, B:68:0x01b2, B:70:0x01ba, B:72:0x01c4, B:75:0x01d1, B:78:0x01eb, B:76:0x01df, B:79:0x01f8, B:80:0x0206, B:82:0x020e, B:83:0x021c, B:85:0x0229, B:86:0x0241, B:53:0x0172, B:57:0x017d, B:91:0x0265, B:93:0x026c, B:95:0x026e, B:97:0x027f, B:100:0x0294, B:102:0x02a6, B:113:0x0330, B:103:0x02d0, B:105:0x02dc, B:110:0x02f5, B:108:0x02ea, B:111:0x0308), top: B:123:0x0000 }] */
        @Override // com.anythink.expressad.foundation.g.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a() {
            /*
                Method dump skipped, instructions count: 914
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.a.c.a.a():void");
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void b() {
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void c() {
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/a/c$b.class */
    public static final class b implements com.anythink.expressad.e.b, Serializable {

        /* renamed from: a  reason: collision with root package name */
        public static final int f4123a = 1;
        public static final int b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f4124c = 3;
        public static final int d = 4;
        private static final long e = 1;
        private boolean f;
        private String g;
        private int h;
        private String i;
        private String j;
        private boolean k;
        private String l;
        private String m;
        private String n;
        private int o;
        private boolean p;
        private int q;

        private void f(String str) {
            this.j = str;
        }

        private boolean l() {
            return this.p;
        }

        private String m() {
            return this.j;
        }

        public final int a() {
            return this.q;
        }

        public final void a(int i) {
            this.q = i;
        }

        public final void a(String str) {
            this.n = str;
        }

        public final void a(boolean z) {
            this.f = z;
        }

        public final void b() {
            this.p = true;
        }

        public final void b(int i) {
            this.o = i;
        }

        public final void b(String str) {
            this.m = str;
        }

        public final void b(boolean z) {
            this.k = z;
        }

        public final int c() {
            return this.o;
        }

        public final void c(int i) {
            this.h = i;
        }

        public final void c(String str) {
            this.l = str;
        }

        public final String d() {
            return this.n;
        }

        public final void d(String str) {
            this.g = str;
        }

        public final String e() {
            return this.m;
        }

        public final void e(String str) {
            this.i = str;
        }

        public final String f() {
            return this.l;
        }

        public final boolean g() {
            return this.f;
        }

        public final String h() {
            return this.g;
        }

        public final int i() {
            return this.h;
        }

        public final String j() {
            return this.i;
        }

        public final boolean k() {
            return this.k;
        }
    }

    public c(Context context) {
        this.o = new com.anythink.expressad.foundation.g.g.c(context, 2);
        this.p = new h(context);
    }

    private void a(String str, String str2, com.anythink.expressad.foundation.d.c cVar, e eVar) {
        this.k = new String(cVar.ad());
        this.m = eVar;
        this.f4119a = null;
        this.p.a(cVar.ad(), eVar, "5".equals(cVar.ab()) || "6".equals(cVar.ab()), str, cVar.aZ(), str2, null, cVar, true, false, com.anythink.expressad.a.a.a.l);
    }

    private void a(String str, String str2, com.anythink.expressad.foundation.d.c cVar, e eVar, com.anythink.expressad.c.b bVar) {
        this.k = new String(cVar.ad());
        this.m = eVar;
        this.f4119a = null;
        this.p.a(cVar.ad(), eVar, "5".equals(cVar.ab()) || "6".equals(cVar.ab()), str, cVar.aZ(), str2, bVar, cVar, true, false, com.anythink.expressad.a.a.a.l);
    }

    static /* synthetic */ int d(c cVar) {
        int i2 = cVar.j;
        cVar.j = i2 + 1;
        return i2;
    }

    public final void a(String str, String str2, com.anythink.expressad.foundation.d.c cVar, e eVar, String str3, boolean z, boolean z2, int i2) {
        String str4;
        this.k = str3;
        this.m = eVar;
        this.f4119a = null;
        this.l = i2;
        boolean z3 = false;
        if (cVar != null) {
            if ("5".equals(cVar.ab()) || "6".equals(cVar.ab())) {
                z3 = true;
            }
            str4 = cVar.aZ();
        } else {
            str4 = "";
            z3 = false;
        }
        this.p.a(str3, eVar, z3, str, str4, str2, null, cVar, z, z2, i2);
    }

    public final boolean a() {
        return this.n;
    }

    @Override // com.anythink.expressad.a.d
    public final void b() {
        this.n = false;
    }
}
