package com.oplus.log;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.oplus.log.c;
import com.oplus.log.core.c;
import com.oplus.log.d.i;
import com.oplus.log.g.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f24311a = false;
    private static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private com.oplus.log.g.c f24312c;
    private com.oplus.log.a.b d;
    private f e;
    private com.oplus.log.b.a f;
    private com.oplus.log.b.a.b g;
    private com.oplus.log.b.a.d h;
    private com.oplus.log.f.d i;
    private Context j;
    private com.oplus.log.core.c k;

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/log/b$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private c f24313a = new c();

        private String a(Context context, String str) {
            String str2;
            if (com.oplus.log.d.b.f24353a.isEmpty()) {
                if (TextUtils.isEmpty(i.f24362a)) {
                    int myPid = Process.myPid();
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                    String str3 = null;
                    if (runningAppProcesses != null) {
                        if (!runningAppProcesses.isEmpty()) {
                            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                            while (true) {
                                str3 = null;
                                if (!it.hasNext()) {
                                    break;
                                }
                                ActivityManager.RunningAppProcessInfo next = it.next();
                                if (next.pid == myPid) {
                                    str3 = next.processName;
                                    break;
                                }
                            }
                        } else {
                            str3 = null;
                        }
                    }
                    i.f24362a = str3;
                }
                str2 = i.f24362a;
            } else {
                str2 = com.oplus.log.d.b.f24353a;
            }
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            return str + BridgeUtil.SPLIT_MARK + str2 + BridgeUtil.SPLIT_MARK;
        }

        public a a(int i) {
            this.f24313a.a(i);
            return this;
        }

        public a a(c.a aVar) {
            this.f24313a.a(aVar);
            return this;
        }

        public a a(c.b bVar) {
            this.f24313a.a(bVar);
            return this;
        }

        public a a(com.oplus.log.g.a aVar) {
            this.f24313a.a(aVar);
            return this;
        }

        public a a(String str) {
            this.f24313a.a(str);
            return this;
        }

        public b a(Context context) {
            b bVar = null;
            if (!TextUtils.isEmpty(this.f24313a.e())) {
                bVar = null;
                if (context != null) {
                    if (context.getFilesDir() == null) {
                        return null;
                    }
                    String d = this.f24313a.d();
                    if (d == null || d.isEmpty()) {
                        this.f24313a.c(a(context, context.getFilesDir().getAbsolutePath()));
                    } else {
                        this.f24313a.c(a(context, d));
                    }
                    bVar = new b();
                    bVar.a(context, this.f24313a);
                }
            }
            return bVar;
        }

        public a b(int i) {
            this.f24313a.b(i);
            return this;
        }

        public a b(String str) {
            this.f24313a.c(str);
            return this;
        }

        public a c(int i) {
            this.f24313a.c(i);
            return this;
        }

        public a c(String str) {
            this.f24313a.b(str);
            this.f24313a.d(str);
            return this;
        }

        public a d(String str) {
            this.f24313a.e(str);
            return this;
        }

        public a e(String str) {
            com.oplus.log.d.b.f24353a = str;
            return this;
        }
    }

    private b() {
    }

    public static void a(boolean z) {
        f24311a = z;
    }

    public static boolean a() {
        return f24311a;
    }

    public static boolean b() {
        return b;
    }

    public static a c() {
        return new a();
    }

    private void f() {
        com.oplus.log.b.a aVar = new com.oplus.log.b.a();
        this.f = aVar;
        Context context = this.j;
        com.oplus.log.f.d dVar = this.i;
        if (context != null) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(aVar.b);
            aVar.f24314a = new ArrayList();
            aVar.f24314a.add(new com.oplus.log.b.a.a(dVar));
        }
        if (this.g == null) {
            com.oplus.log.b.a.b bVar = new com.oplus.log.b.a.b(this.i);
            this.g = bVar;
            bVar.a(this.j);
        }
        com.oplus.log.b.a.d dVar2 = new com.oplus.log.b.a.d(this.i);
        this.h = dVar2;
        dVar2.a(this.j);
        new com.oplus.log.b.a.e(this.i).a(this.j);
    }

    private void g() {
        com.oplus.log.b.a.d dVar = this.h;
        if (dVar != null) {
            try {
                this.j.unregisterReceiver(dVar);
            } catch (Exception e) {
                if (a()) {
                    e.printStackTrace();
                }
            }
            this.h = null;
        }
        com.oplus.log.b.a aVar = this.f;
        if (aVar != null) {
            Context context = this.j;
            if (context != null) {
                ((Application) context.getApplicationContext()).unregisterActivityLifecycleCallbacks(aVar.b);
            }
            this.f = null;
        }
        this.j = null;
    }

    public final void a(int i) {
        f fVar = this.e;
        if (fVar != null) {
            fVar.b(i);
        }
    }

    public final void a(Context context, c cVar) {
        c cVar2 = cVar;
        if (cVar == null) {
            cVar2 = new c();
        }
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            this.j = applicationContext;
            com.oplus.log.d.b.a(applicationContext);
        }
        c.a aVar = new c.a();
        aVar.f24332a = cVar2.d();
        aVar.b = cVar2.e();
        c.a a2 = aVar.a(cVar2.j());
        a2.h = cVar2.g();
        a2.e = "0123456789012345".getBytes();
        a2.f = "0123456789012345".getBytes();
        com.oplus.log.core.c a3 = a2.a();
        this.k = a3;
        com.oplus.log.a.b bVar = new com.oplus.log.a.b(a3);
        this.d = bVar;
        f fVar = new f(bVar);
        this.e = fVar;
        fVar.a(cVar2.h());
        this.e.b(cVar2.i());
        com.oplus.log.g.c cVar3 = new com.oplus.log.g.c(cVar2);
        this.f24312c = cVar3;
        cVar3.a(this.d);
        this.i = new com.oplus.log.f.c(this.d);
        this.e.a("NearX-HLog", "sdk version : 4.0.6");
        f();
    }

    public final void a(c.g gVar) {
        com.oplus.log.g.c cVar = this.f24312c;
        if (cVar != null) {
            cVar.a(gVar);
        }
    }

    public final void a(String str, String str2, long j, long j2, boolean z, String str3) {
        if (this.f24312c != null) {
            this.f24312c.a(new c.C0614c(str, j, j2, z, str2, str3), 0);
        }
    }

    public final void a(String str, String str2, c.e eVar) {
        com.oplus.log.g.c cVar = this.f24312c;
        if (cVar != null) {
            cVar.a(str, str2, eVar);
        }
    }

    public final void b(boolean z) {
        com.oplus.log.a.b bVar = this.d;
        if (bVar != null) {
            if (z) {
                bVar.a();
            } else {
                bVar.a(null);
            }
        }
    }

    public final com.oplus.log.a d() {
        f fVar = this.e;
        return fVar != null ? fVar : new f(null);
    }

    public final void e() {
        this.f24312c = null;
        this.e = null;
        this.i = null;
        g();
        this.d = null;
    }
}
