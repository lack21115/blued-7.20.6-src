package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.ix;
import com.huawei.hms.framework.common.ExceptionCode;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.amap.api.col.3sl.il  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/il.class */
public final class il {

    /* renamed from: a  reason: collision with root package name */
    private Context f5159a;
    private ia b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5160c = true;
    private boolean d = false;
    private boolean e = true;
    private boolean f = false;
    private List<String> g = new ArrayList();
    private in h = new in((byte) 0);
    private in i = new in();
    private ix.a j = new ix.a() { // from class: com.amap.api.col.3sl.il.1
        @Override // com.amap.api.col.p0003sl.ix.a
        public final void a(int i) {
            if (i > 0 && il.a(il.this) != null) {
                ((im) il.this.c().f).a(i);
                il.a(il.this, "error", String.valueOf(((im) il.this.c().f).b()));
                il.a(il.this).postDelayed(new Runnable() { // from class: com.amap.api.col.3sl.il.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        il.this.c(false);
                    }
                }, 660000L);
            }
        }
    };
    private ix.a k = new ix.a() { // from class: com.amap.api.col.3sl.il.2
        @Override // com.amap.api.col.p0003sl.ix.a
        public final void a(int i) {
            if (i <= 0) {
                return;
            }
            ((im) il.this.e().f).a(i);
            il.a(il.this, "info", String.valueOf(((im) il.this.e().f).b()));
            if (il.a(il.this) == null) {
                return;
            }
            il.a(il.this).postDelayed(new Runnable() { // from class: com.amap.api.col.3sl.il.2.1
                @Override // java.lang.Runnable
                public final void run() {
                    il.this.d(false);
                }
            }, 660000L);
        }
    };
    private Handler l = null;
    private ke m = null;
    private ke n = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.il$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/il$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static Map<String, il> f5165a = new HashMap();
    }

    private il(ia iaVar) {
        this.b = iaVar;
    }

    private long a(String str) {
        try {
            String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
            io a2 = io.a(this.b);
            Context context = this.f5159a;
            return Long.parseLong(a2.a(context, "", "", format + str));
        } catch (Throwable th) {
            return 0L;
        }
    }

    static /* synthetic */ Handler a(il ilVar) {
        Context context = ilVar.f5159a;
        if (context == null || context == null) {
            return null;
        }
        if (ilVar.l == null) {
            ilVar.l = new Handler(ilVar.f5159a.getMainLooper());
        }
        return ilVar.l;
    }

    public static il a(ia iaVar) {
        if (iaVar == null || TextUtils.isEmpty(iaVar.a())) {
            return null;
        }
        if (a.f5165a.get(iaVar.a()) == null) {
            a.f5165a.put(iaVar.a(), new il(iaVar));
        }
        return a.f5165a.get(iaVar.a());
    }

    private static String a(Context context, String str, ia iaVar) {
        String b;
        if (context == null) {
            return null;
        }
        if (iaVar != null) {
            try {
                if (!TextUtils.isEmpty(iaVar.a())) {
                    b = hw.b(iaVar.a());
                    return context.getFilesDir().getAbsolutePath() + File.separator + "EBDEC84EF205FEA2DF0719DEB822869E" + File.separator + str + File.separator + b;
                }
            } catch (Throwable th) {
                return null;
            }
        }
        b = "a";
        return context.getFilesDir().getAbsolutePath() + File.separator + "EBDEC84EF205FEA2DF0719DEB822869E" + File.separator + str + File.separator + b;
    }

    private void a(int i) {
        Context context;
        in b = b(i);
        String a2 = ik.a(b.a());
        if (TextUtils.isEmpty(a2) || "[]".equals(a2) || (context = this.f5159a) == null) {
            return;
        }
        ix.a(context, this.b, ik.a(i), c(i), a2);
        b.b();
    }

    static /* synthetic */ void a(il ilVar, String str, String str2) {
        try {
            String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
            io a2 = io.a(ilVar.b);
            Context context = ilVar.f5159a;
            a2.a(context, "", "", format + str, str2);
        } catch (Throwable th) {
        }
    }

    private in b(int i) {
        return i == ik.b ? this.i : this.h;
    }

    private void b(boolean z) {
        c(z);
        d(z);
    }

    private boolean b() {
        return this.f5159a != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ke c() {
        ke keVar = this.n;
        if (keVar != null) {
            return keVar;
        }
        d();
        return this.n;
    }

    private ke c(int i) {
        if (i == ik.b) {
            if (this.n == null) {
                this.n = c();
            }
            return this.n;
        }
        if (this.m == null) {
            this.m = e();
        }
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        ke c2 = c(ik.b);
        if (z) {
            ((im) c2.f).a(z);
        }
        Context context = this.f5159a;
        if (context == null) {
            return;
        }
        ix.a(context, c2, this.j);
    }

    private ke d() {
        if (this.f5159a == null) {
            return null;
        }
        ke keVar = new ke();
        this.n = keVar;
        keVar.f5266a = h();
        this.n.b = 512000000L;
        this.n.d = 12500;
        this.n.f5267c = "1";
        this.n.h = -1;
        this.n.i = "elkey";
        long a2 = a("error");
        this.n.f = new im(true, new kz(this.f5159a, this.d), a2, ExceptionCode.CRASH_EXCEPTION);
        this.n.g = null;
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        ke c2 = c(ik.f5157a);
        if (z) {
            ((im) c2.f).a(z);
        }
        Context context = this.f5159a;
        if (context == null) {
            return;
        }
        ix.a(context, c2, this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ke e() {
        ke keVar = this.m;
        if (keVar != null) {
            return keVar;
        }
        f();
        return this.m;
    }

    private ke f() {
        if (this.f5159a == null) {
            return null;
        }
        ke keVar = new ke();
        this.m = keVar;
        keVar.f5266a = g();
        this.m.b = 512000000L;
        this.m.d = 12500;
        this.m.f5267c = "1";
        this.m.h = -1;
        this.m.i = "inlkey";
        long a2 = a("info");
        this.m.f = new im(this.f, new kz(this.f5159a, this.d), a2, 30000000);
        this.m.g = null;
        return this.m;
    }

    private String g() {
        Context context = this.f5159a;
        if (context == null) {
            return null;
        }
        return a(context, "CAF9B6B99962BF5C2264824231D7A40C", this.b);
    }

    private String h() {
        Context context = this.f5159a;
        if (context == null) {
            return null;
        }
        return a(context, "CB5E100E5A9A3E7F6D1FD97512215282", this.b);
    }

    public final void a() {
        if (b()) {
            a(ik.b);
            a(ik.f5157a);
        }
    }

    public final void a(Context context) {
        this.f5159a = context.getApplicationContext();
    }

    public final void a(ik ikVar) {
        boolean z;
        if (b() && this.f5160c && ik.a(ikVar)) {
            if (ikVar == null) {
                z = true;
            } else {
                List<String> list = this.g;
                if (list != null && list.size() != 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= this.g.size()) {
                            break;
                        } else if (!TextUtils.isEmpty(this.g.get(i2)) && ikVar.b().contains(this.g.get(i2))) {
                            z = true;
                            break;
                        } else {
                            i = i2 + 1;
                        }
                    }
                }
                z = false;
            }
            if (z) {
                return;
            }
            if (this.e || ikVar.a() != ik.f5157a) {
                in b = b(ikVar.a());
                if (b.a(ikVar.b())) {
                    String a2 = ik.a(b.a());
                    if (this.f5159a == null || TextUtils.isEmpty(a2) || "[]".equals(a2)) {
                        return;
                    }
                    ix.a(this.f5159a, this.b, ikVar.c(), c(ikVar.a()), a2);
                    b(false);
                    b.b();
                }
                b.a(ikVar);
            }
        }
    }

    public final void a(boolean z) {
        if (b()) {
            b(z);
        }
    }

    public final void a(boolean z, boolean z2, boolean z3, boolean z4, List<String> list) {
        this.f5160c = z;
        this.d = z2;
        this.e = z3;
        this.f = z4;
        this.g = list;
        d();
        f();
    }
}
