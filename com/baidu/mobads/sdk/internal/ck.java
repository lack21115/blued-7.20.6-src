package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/ck.class */
public class ck implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public static String f9384a = "";
    private static final String b = "remote";

    /* renamed from: c  reason: collision with root package name */
    private static final String f9385c = "proxy";
    private static final String d = "third-mtj";
    private static final String e = "third-novel";
    private static Thread.UncaughtExceptionHandler f;
    private static volatile ck g;
    private static final String j = "key_crash_source";
    private static final String k = "key_crash_trace";
    private static final String l = "key_crash_ad";
    private Context h;
    private a i;

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/ck$a.class */
    interface a {
        void a(String str);
    }

    private ck(Context context) {
        this.h = context.getApplicationContext();
        f = Thread.getDefaultUncaughtExceptionHandler();
    }

    public static ck a(Context context) {
        if (g == null) {
            synchronized (ck.class) {
                try {
                    if (g == null) {
                        g = new ck(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        return e().getString(str, "");
    }

    private String a(Throwable th) {
        String str;
        Throwable cause = th.getCause();
        if (cause != null) {
            th = cause;
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            List<String> d2 = d();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= stackTrace.length) {
                    break;
                }
                String className = stackTrace[i2].getClassName();
                if (!className.startsWith("junit.framework")) {
                    str = b;
                    if (!className.startsWith(w.aq)) {
                        str = b;
                        if (className.startsWith(w.f9444ar)) {
                            break;
                        } else if (className.startsWith(w.as)) {
                            return b;
                        } else {
                            if (className.startsWith(w.at) || className.startsWith(w.au) || className.startsWith(w.av)) {
                                return "proxy";
                            }
                            if (className.startsWith(w.aw)) {
                                return d;
                            }
                            if (className.startsWith(w.ax) || className.startsWith(w.ay)) {
                                if (cj.g.booleanValue()) {
                                    return e;
                                }
                            } else if (a(className, d2)) {
                                return b;
                            }
                            i = i2 + 1;
                        }
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        str = null;
        return str;
    }

    private boolean a(String str, List<String> list) {
        for (String str2 : list) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    private List<String> d() {
        IXAdContainerFactory c2;
        ArrayList arrayList = new ArrayList();
        try {
            z a2 = z.a();
            if (a2 != null && (c2 = a2.c()) != null) {
                Object remoteParam = c2.getRemoteParam("appCommonConfig", "getCrashPackage");
                if (remoteParam instanceof List) {
                    arrayList.addAll((List) remoteParam);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            return arrayList;
        }
    }

    private SharedPreferences e() {
        return this.h.getSharedPreferences("baidu_mobads_crash", 0);
    }

    private SharedPreferences.Editor f() {
        return e().edit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        SharedPreferences.Editor f2 = f();
        f2.clear();
        f2.apply();
    }

    public void a() {
        ba.a().a((h) new cl(this));
    }

    public void a(a aVar) {
        this.i = aVar;
    }

    public void a(String str, String str2) {
        SharedPreferences.Editor f2 = f();
        f2.putString(j, str);
        f2.putString(k, ("crashtime:" + System.currentTimeMillis() + " ") + str2);
        f2.putString(l, f9384a);
        f2.commit();
    }

    public void b() {
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof ck) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void c() {
        this.i = null;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            String a2 = a(th);
            if (a2 != null) {
                a(a2, Log.getStackTraceString(th));
                if (this.i != null) {
                    this.i.a(a2);
                }
            }
            if (f != null) {
                f.uncaughtException(thread, th);
            }
        } catch (Exception e2) {
            bq.a().c(e2);
        }
    }
}
