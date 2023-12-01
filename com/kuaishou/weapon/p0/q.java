package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/q.class */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public static final int f10244a = 3;
    private static q b;
    private static final String g = "1";

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f10245c = false;
    private Cdo d;
    private Context e;
    private t f;

    private q(Context context) {
        this.e = context;
        this.d = Cdo.a(context);
        this.f = t.a(context);
    }

    public static q a(Context context) {
        q qVar;
        synchronized (q.class) {
            try {
                if (b == null) {
                    b = new q(context);
                }
                qVar = b;
            } catch (Exception e) {
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return qVar;
    }

    private boolean a(int i, String str, String str2, boolean z, PackageInfo packageInfo) {
        synchronized (this) {
            if (z) {
                if (this.f.c(i) != 1) {
                    return false;
                }
            }
            s a2 = this.f.a(i);
            if (a2 == null) {
                this.f.b(i, -1);
                HashMap hashMap = new HashMap();
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                hashMap.put("pk", sb.toString());
                hashMap.put("pv", str);
                hashMap.put("e", cj.m);
                bg.a(this.e, "1002001", hashMap);
                return false;
            } else if (!dm.a(new File(a2.e))) {
                this.f.b(i, -1);
                HashMap hashMap2 = new HashMap();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i);
                hashMap2.put("pk", sb2.toString());
                hashMap2.put("pv", str);
                hashMap2.put("e", cj.n);
                hashMap2.put("l", "CBH");
                bg.a(this.e, "1002001", hashMap2);
                return false;
            } else {
                if (packageInfo != null) {
                    a2.r = packageInfo;
                }
                r a3 = r.a(this.e.getApplicationContext(), true);
                if (a3.a(a2, false)) {
                    s c2 = a3.c(a2.e);
                    c2.b = 1;
                    c2.p = 1;
                    this.f.a(c2);
                    return true;
                }
                this.f.b(i, -1);
                a3.a(a2.e);
                HashMap hashMap3 = new HashMap();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(i);
                hashMap3.put("pk", sb3.toString());
                hashMap3.put("pv", str);
                hashMap3.put("e", cj.o);
                hashMap3.put("l", "CBH");
                bg.a(this.e, "1002001", hashMap3);
                return false;
            }
        }
    }

    private static void d() {
        try {
            Cdo a2 = Cdo.a();
            if (a2 != null) {
                a2.b("W_S_V", "1");
            }
        } catch (Exception e) {
        }
    }

    public void a() {
        d();
        b();
    }

    public void a(final String str) {
        try {
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.q.1
                @Override // java.lang.Runnable
                public void run() {
                    final r a2;
                    try {
                        if (TextUtils.isEmpty(str) || (a2 = r.a(q.this.e.getApplicationContext(), true)) == null) {
                            return;
                        }
                        final s d = a2.d(str);
                        if (d == null) {
                            s b2 = q.this.f.b(str);
                            if (b2 != null) {
                                q.this.a(str, b2.e);
                                return;
                            }
                            return;
                        }
                        new Timer().schedule(new TimerTask() { // from class: com.kuaishou.weapon.p0.q.1.1
                            @Override // java.util.TimerTask, java.lang.Runnable
                            public void run() {
                                a2.b(str);
                                q.this.f.a(str);
                                File file = new File(d.e);
                                if (file.exists()) {
                                    file.delete();
                                }
                            }
                        }, 600000L);
                        a2.b(str);
                        q.this.f.a(str);
                        File file = new File(d.e);
                        if (file.exists()) {
                            file.delete();
                        }
                    } catch (Throwable th) {
                    }
                }
            });
        } catch (Throwable th) {
        }
    }

    public void a(String str, String str2) {
        this.f.a(str);
        File file = new File(str2);
        if (file.exists()) {
            file.delete();
        }
    }

    public boolean a(int i, String str, PackageInfo packageInfo) {
        boolean a2;
        synchronized (this) {
            a2 = a(i, str, null, false, packageInfo);
        }
        return a2;
    }

    public boolean a(s sVar, String str, String str2) {
        r a2;
        HashMap hashMap;
        String str3;
        if (sVar == null) {
            hashMap = new HashMap();
            str3 = cj.r;
        } else {
            File file = new File(sVar.e);
            if (dm.a(file)) {
                try {
                    if (!this.f.b(sVar.f10253a)) {
                        this.f.a(sVar);
                    }
                    a2 = r.a(this.e.getApplicationContext(), true);
                    this.f.a(sVar.f10253a, 1);
                    b(sVar.f10254c);
                } catch (Throwable th) {
                }
                if (!a2.a(sVar, true)) {
                    file.delete();
                    a(sVar.f10253a, sVar.d, null, true, null);
                    this.f.a(sVar.f10253a, 0);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("e", cj.u);
                    hashMap2.put("l", "CBH");
                    hashMap2.put("apk", sVar.toString());
                    bg.a(this.e, "1002001", hashMap2);
                    return false;
                }
                s c2 = a2.c(sVar.e);
                sVar = c2;
                if (c2 == null) {
                    try {
                        this.f.a(c2.f10253a, 0);
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("e", cj.s);
                        hashMap3.put("l", "CBH");
                        bg.a(this.e, "1002001", hashMap3);
                        return false;
                    } catch (Throwable th2) {
                        sVar = c2;
                    }
                }
                try {
                    s a3 = this.f.a(sVar.f10253a);
                    File file2 = null;
                    if (a3 != null) {
                        file2 = null;
                        if (!a3.d.equals(sVar.d)) {
                            file2 = new File(a3.e);
                        }
                    }
                    sVar.b = 1;
                    sVar.p = 1;
                    if (this.f.a(sVar) > 0 && file2 != null && file2.exists()) {
                        file2.delete();
                    }
                    this.f.a(sVar.f10253a, 0);
                    return true;
                } catch (Throwable th3) {
                    return false;
                }
            }
            hashMap = new HashMap();
            str3 = cj.t;
        }
        hashMap.put("e", str3);
        hashMap.put("l", "CBH");
        bg.a(this.e, "1002001", hashMap);
        return false;
    }

    public void b() {
        synchronized (this) {
            try {
                if (this.f10245c) {
                    return;
                }
                this.f10245c = true;
                for (s sVar : this.f.a()) {
                    String str = null;
                    try {
                        str = this.e.getFilesDir().getCanonicalPath();
                    } catch (Throwable th) {
                    }
                    if (str != null) {
                        sVar.m = str + bh.j + sVar.f10253a;
                        StringBuilder sb = new StringBuilder();
                        sb.append(sVar.m);
                        sb.append("/lib");
                        dm.c(sb.toString());
                        dm.b(sVar.m);
                    }
                }
                this.f.b();
                if (this.d.b(Cdo.d)) {
                    this.f.c();
                } else {
                    this.d.a(Cdo.d, Boolean.TRUE, true);
                }
                n.a().a(new u(this.e, 1, false));
            } catch (Throwable th2) {
            }
        }
    }

    public void b(String str) {
        r a2;
        try {
            if (TextUtils.isEmpty(str) || (a2 = r.a()) == null) {
                return;
            }
            a2.b(str);
        } catch (Throwable th) {
        }
    }

    public void c() {
        for (s sVar : this.f.a()) {
            r a2 = r.a();
            if ((a2 != null ? a2.d(sVar.f10254c) : null) == null) {
                a(sVar.f10253a, sVar.d, (PackageInfo) null);
            }
        }
    }
}
