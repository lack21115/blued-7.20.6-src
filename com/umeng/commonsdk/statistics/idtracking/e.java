package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.pd.ExHandler;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.bz;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/idtracking/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final long f27228a = 86400000;
    public static e b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f27229c = at.b().b("id");
    private static Object j = new Object();
    private File d;
    private long f;
    private a i;
    private com.umeng.commonsdk.statistics.proto.c e = null;
    private Set<com.umeng.commonsdk.statistics.idtracking.a> h = new HashSet();
    private long g = 86400000;

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/idtracking/e$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Context f27230a;
        private Set<String> b = new HashSet();

        public a(Context context) {
            this.f27230a = context;
        }

        public void a() {
            synchronized (this) {
                if (!this.b.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    for (String str : this.b) {
                        sb.append(str);
                        sb.append(',');
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    PreferenceWrapper.getDefault(this.f27230a).edit().putString("invld_id", sb.toString()).commit();
                }
            }
        }

        public boolean a(String str) {
            boolean contains;
            synchronized (this) {
                contains = this.b.contains(str);
            }
            return !contains;
        }

        public void b() {
            String[] split;
            synchronized (this) {
                String string = PreferenceWrapper.getDefault(this.f27230a).getString("invld_id", null);
                if (!TextUtils.isEmpty(string) && (split = string.split(",")) != null) {
                    int length = split.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            break;
                        }
                        String str = split[i2];
                        if (!TextUtils.isEmpty(str)) {
                            this.b.add(str);
                        }
                        i = i2 + 1;
                    }
                }
            }
        }

        public void b(String str) {
            synchronized (this) {
                this.b.add(str);
            }
        }

        public void c(String str) {
            this.b.remove(str);
        }
    }

    e(Context context) {
        this.i = null;
        this.d = new File(context.getFilesDir(), f27229c);
        a aVar = new a(context);
        this.i = aVar;
        aVar.b();
    }

    public static e a(Context context) {
        e eVar;
        synchronized (e.class) {
            try {
                if (b == null) {
                    e eVar2 = new e(context);
                    b = eVar2;
                    eVar2.a(new f(context));
                    b.a(new b(context));
                    b.a(new j(context));
                    b.a(new d(context));
                    b.a(new c(context));
                    b.a(new g(context));
                    b.a(new i());
                    if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
                        b.a(new h(context));
                    }
                    b.f();
                }
                eVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    public static void a() {
        synchronized (e.class) {
            try {
                if (b != null) {
                    b.e();
                    b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        if (cVar == null || cVar.f27256a == null) {
            return;
        }
        if (cVar.f27256a.containsKey("mac") && !FieldManager.allow(com.umeng.commonsdk.utils.d.h)) {
            cVar.f27256a.remove("mac");
        }
        if (cVar.f27256a.containsKey(ExHandler.JSON_REQUEST_IMEI) && !FieldManager.allow(com.umeng.commonsdk.utils.d.g)) {
            cVar.f27256a.remove(ExHandler.JSON_REQUEST_IMEI);
        }
        if (cVar.f27256a.containsKey("android_id") && !FieldManager.allow(com.umeng.commonsdk.utils.d.i)) {
            cVar.f27256a.remove("android_id");
        }
        if (cVar.f27256a.containsKey(Context.SERIAL_SERVICE) && !FieldManager.allow(com.umeng.commonsdk.utils.d.j)) {
            cVar.f27256a.remove(Context.SERIAL_SERVICE);
        }
        if (cVar.f27256a.containsKey(com.anythink.expressad.foundation.g.a.bj) && !FieldManager.allow(com.umeng.commonsdk.utils.d.w)) {
            cVar.f27256a.remove(com.anythink.expressad.foundation.g.a.bj);
        }
        if (!cVar.f27256a.containsKey("oaid") || FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            return;
        }
        cVar.f27256a.remove("oaid");
    }

    private boolean a(com.umeng.commonsdk.statistics.idtracking.a aVar) {
        if (this.i.a(aVar.b())) {
            return this.h.add(aVar);
        }
        if (AnalyticsConstants.UM_DEBUG) {
            MLog.w("invalid domain: " + aVar.b());
            return false;
        }
        return false;
    }

    private void b(com.umeng.commonsdk.statistics.proto.c cVar) {
        byte[] a2;
        synchronized (j) {
            if (cVar != null) {
                try {
                    synchronized (this) {
                        a(cVar);
                        a2 = new bz().a(cVar);
                    }
                    if (a2 != null) {
                        HelperUtils.writeFile(this.d, a2);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void h() {
        synchronized (this) {
            com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.h) {
                if (aVar.c()) {
                    if (aVar.d() != null) {
                        hashMap.put(aVar.b(), aVar.d());
                    }
                    if (aVar.e() != null && !aVar.e().isEmpty()) {
                        arrayList.addAll(aVar.e());
                    }
                }
            }
            cVar.a(arrayList);
            cVar.a(hashMap);
            synchronized (this) {
                this.e = cVar;
            }
        }
    }

    private com.umeng.commonsdk.statistics.proto.c i() {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        synchronized (j) {
            if (this.d.exists()) {
                try {
                    fileInputStream2 = new FileInputStream(this.d);
                    fileInputStream = fileInputStream2;
                } catch (Exception e) {
                    e = e;
                    fileInputStream2 = null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = null;
                    HelperUtils.safeClose(fileInputStream);
                    throw th;
                }
                try {
                    try {
                        byte[] readStreamToByteArray = HelperUtils.readStreamToByteArray(fileInputStream2);
                        com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
                        new bt().a(cVar, readStreamToByteArray);
                        HelperUtils.safeClose(fileInputStream2);
                        return cVar;
                    } catch (Throwable th2) {
                        th = th2;
                        HelperUtils.safeClose(fileInputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    HelperUtils.safeClose(fileInputStream2);
                    return null;
                }
            }
            return null;
        }
    }

    public void a(long j2) {
        this.g = j2;
    }

    public void b() {
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f >= this.g) {
                boolean z = false;
                for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.h) {
                    if (aVar.c() && aVar.a()) {
                        z = true;
                        if (!aVar.c()) {
                            this.i.b(aVar.b());
                            z = true;
                        }
                    }
                }
                if (z) {
                    h();
                    this.i.a();
                    g();
                }
                this.f = currentTimeMillis;
            }
        }
    }

    public com.umeng.commonsdk.statistics.proto.c c() {
        com.umeng.commonsdk.statistics.proto.c cVar;
        synchronized (this) {
            cVar = this.e;
        }
        return cVar;
    }

    public String d() {
        return null;
    }

    public void e() {
        synchronized (this) {
            if (b == null) {
                return;
            }
            boolean z = false;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.h) {
                if (aVar.c() && aVar.e() != null && !aVar.e().isEmpty()) {
                    aVar.a((List<com.umeng.commonsdk.statistics.proto.a>) null);
                    z = true;
                }
            }
            if (z) {
                this.e.b(false);
                g();
            }
        }
    }

    public void f() {
        synchronized (this) {
            com.umeng.commonsdk.statistics.proto.c i = i();
            if (i == null) {
                return;
            }
            a(i);
            ArrayList<com.umeng.commonsdk.statistics.idtracking.a> arrayList = new ArrayList(this.h.size());
            synchronized (this) {
                this.e = i;
                for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.h) {
                    aVar.a(this.e);
                    if (!aVar.c()) {
                        arrayList.add(aVar);
                    }
                }
                for (com.umeng.commonsdk.statistics.idtracking.a aVar2 : arrayList) {
                    this.h.remove(aVar2);
                }
                h();
            }
        }
    }

    public void g() {
        synchronized (this) {
            if (this.e != null) {
                b(this.e);
            }
        }
    }
}
