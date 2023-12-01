package com.tencent.beacon.a.c;

import android.content.Context;
import com.tencent.beacon.base.util.BeaconLogger;
import com.tencent.qimei.sdk.IAsyncQimeiListener;
import com.tencent.qimei.sdk.Qimei;
import com.tencent.qimei.sdk.QimeiSDK;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/c/j.class */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f34949a = true;

    @Deprecated
    public static Qimei a(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return null;
        }
        String f = c.d().f();
        com.tencent.beacon.base.util.c.a("QimeiWrapper", "getRtQimei  appkey is %s", f);
        c(context, f);
        return QimeiSDK.getInstance(f).getQimei();
    }

    public static void a() {
        if (f34949a) {
            try {
                String f = c.d().f();
                d(f);
                a(f);
                e(f);
            } catch (Throwable th) {
                com.tencent.beacon.a.b.g e = com.tencent.beacon.a.b.g.e();
                e.a("203", "sdk init error! package name: " + b.b() + " , msg:" + th.getMessage(), th);
                com.tencent.beacon.base.util.c.a(th);
            }
        }
    }

    @Deprecated
    public static void a(IAsyncQimeiListener iAsyncQimeiListener) throws NullPointerException {
        Context c2 = c.d().c();
        com.tencent.beacon.base.util.e.a("should call start() first to init beaconsdk! old async getQimei context", c2);
        String f = c.d().f();
        com.tencent.beacon.base.util.c.a("QimeiWrapper", "async getQimei  appkey is %s", f);
        c(c2, f);
        QimeiSDK.getInstance(c.d().f()).getQimei(iAsyncQimeiListener);
    }

    public static void a(String str) {
        QimeiSDK.getInstance(str).getStrategy().enableProcessInfo(com.tencent.beacon.e.b.a().k());
    }

    public static void a(String str, Context context, IAsyncQimeiListener iAsyncQimeiListener) {
        com.tencent.beacon.base.util.e.a("context", context);
        com.tencent.beacon.base.util.e.a("ApplicationContext", context.getApplicationContext());
        com.tencent.beacon.a.b.a.a().a(new i(str, context, iAsyncQimeiListener));
    }

    public static void a(String str, String str2) {
        synchronized (j.class) {
            try {
                com.tencent.beacon.base.util.c.b("内部版该接口无效", new Object[0]);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(boolean z) {
        f34949a = z;
    }

    @Deprecated
    public static Qimei b() {
        Context c2 = c.d().c();
        if (c2 == null) {
            return null;
        }
        String f = c.d().f();
        c(c2, f);
        com.tencent.beacon.base.util.c.a("QimeiWrapper", "getQimei  appkey is %s", f);
        return QimeiSDK.getInstance(f).getQimei();
    }

    public static Qimei b(Context context, String str) {
        if (context == null || context.getApplicationContext() == null) {
            return null;
        }
        c(context.getApplicationContext(), str);
        return QimeiSDK.getInstance(str).getQimei();
    }

    public static Qimei b(String str) {
        Context c2 = c.d().c();
        if (c2 == null) {
            return null;
        }
        com.tencent.beacon.base.util.c.a("QimeiWrapper", "getQimeiWithAppkey  appkey is %s", str);
        c(c2, str);
        return QimeiSDK.getInstance(str).getQimei();
    }

    public static String c() {
        Qimei qimei = QimeiSDK.getInstance(c.d().f()).getQimei();
        return qimei == null ? "" : qimei.getQimei16();
    }

    public static void c(String str) {
        com.tencent.beacon.base.util.c.b("内部版该接口无效", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(Context context, String str) {
        if (f34949a) {
            QimeiSDK.getInstance(str).setSdkName("beacon");
            return QimeiSDK.getInstance(str).init(context);
        }
        return false;
    }

    public static String d() {
        Qimei qimei = QimeiSDK.getInstance(c.d().f()).getQimei();
        return qimei == null ? "" : qimei.getQimei36();
    }

    private static void d(String str) {
        QimeiSDK.getInstance(str).setAppVersion(b.a()).setChannelID(c.d().a()).setLogAble(com.tencent.beacon.base.util.c.b()).addUserId("QQ", b.c()).addUserId("OMGID", c.d().g());
    }

    public static Map<String, String> e() {
        HashMap hashMap = new HashMap(2);
        hashMap.put("A3", c());
        hashMap.put("A153", d());
        return hashMap;
    }

    private static void e(String str) {
        BeaconLogger a2 = com.tencent.beacon.base.util.c.a();
        if (a2 != null) {
            QimeiSDK.getInstance(str).setLogObserver(new h(a2));
        }
    }

    public static String f() {
        return QimeiSDK.getInstance(c.d().f()).getSdkVersion();
    }

    public static String g() {
        if (com.tencent.beacon.e.b.a().g()) {
            String beaconTicket = QimeiSDK.getInstance(c.d().f()).getBeaconTicket();
            return beaconTicket != null ? beaconTicket : "";
        }
        return "";
    }

    public static void h() {
        String f = c.d().f();
        com.tencent.beacon.base.util.c.a("QimeiWrapper", "initQimei: appkey is %s , qimei init %s", f, Boolean.valueOf(c(c.d().c(), f)));
        QimeiSDK.getInstance(f).getQimei(new g());
    }
}
