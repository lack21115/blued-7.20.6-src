package com.tencent.mapsdk.internal;

import android.content.Context;
import com.tencent.tmsbeacon.event.UserAction;
import com.tencent.tmsbeacon.qimei.IAsyncQimeiListener;
import com.tencent.tmsbeacon.upload.InitHandleListener;
import com.tencent.tmsbeacon.upload.TunnelInfo;
import com.tencent.tmsbeacon.upload.UploadHandleListener;
import java.lang.reflect.Constructor;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/m1.class */
public class m1 {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f37626a = false;
    private static String b;

    public static String a(String str) {
        return !f37626a ? "" : UserAction.getCloudParas(str);
    }

    public static void a() {
        if (f37626a) {
            UserAction.doUploadRecords();
        }
    }

    public static void a(Context context) {
        Object invoke;
        try {
            Class.forName("com.tencent.beacon.event.UserAction");
            b = null;
            try {
                b = UserAction.getSDKVersion();
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    String message = e.getMessage();
                    String substring = message.substring(message.indexOf("com"), message.indexOf("("));
                    String substring2 = substring.substring(0, substring.lastIndexOf(46));
                    String substring3 = substring.substring(substring.lastIndexOf(46) + 1);
                    Class<?> cls = Class.forName(substring2);
                    try {
                        Constructor<?> constructor = cls.getConstructor(Context.class);
                        constructor.setAccessible(true);
                        invoke = constructor.newInstance(context);
                    } catch (Exception e2) {
                        invoke = cls.getDeclaredMethod("a", Context.class).invoke(null, context);
                    }
                    b = (String) cls.getMethod(substring3, new Class[0]).invoke(invoke, new Object[0]);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if (a(b, "3.1.2")) {
                f37626a = true;
            }
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
        }
    }

    public static void a(Context context, boolean z) {
        if (f37626a) {
            UserAction.initUserAction(context, z);
        }
    }

    public static void a(Context context, boolean z, long j) {
        if (f37626a) {
            UserAction.initUserAction(context, z, j);
        }
    }

    public static void a(Context context, boolean z, long j, InitHandleListener initHandleListener, UploadHandleListener uploadHandleListener) {
        if (f37626a) {
            UserAction.initUserAction(context, z, j, initHandleListener, uploadHandleListener);
        }
    }

    public static void a(IAsyncQimeiListener iAsyncQimeiListener) {
        if (f37626a && a(UserAction.getSDKVersion(), "3.2.1")) {
            UserAction.getQimei(iAsyncQimeiListener);
        }
    }

    public static void a(String str, String str2, String str3) {
        if (f37626a) {
            UserAction.registerTunnel(new TunnelInfo(str, str2, str3));
        }
    }

    public static void a(String str, String str2, Map<String, String> map, boolean z, boolean z2) {
        if (f37626a) {
            UserAction.onUserActionToTunnel(str, str2, map, z, z2);
        }
    }

    public static void a(String str, String str2, boolean z, long j, long j2, Map<String, String> map, boolean z2, boolean z3) {
        if (f37626a) {
            UserAction.onUserActionToTunnel(str, str2, z, j, j2, map, z2, z3);
        }
    }

    public static void a(String str, Map<String, String> map) {
        if (f37626a) {
            UserAction.setAdditionalInfo(str, map);
        }
    }

    public static void a(Map<String, String> map) {
        if (f37626a) {
            UserAction.setAdditionalInfo(map);
        }
    }

    public static void a(boolean z) {
        if (f37626a) {
            UserAction.flushObjectsToDB(z);
        }
    }

    public static void a(boolean z, boolean z2) {
        if (f37626a) {
            UserAction.setLogAble(z, z2);
        }
    }

    private static boolean a(String str, String str2) {
        return str.compareTo(str2) >= 0;
    }

    public static boolean a(String str, boolean z, long j, long j2, Map<String, String> map, boolean z2) {
        if (f37626a) {
            return UserAction.onUserAction(str, z, j, j2, map, z2);
        }
        return false;
    }

    public static boolean a(String str, boolean z, long j, long j2, Map<String, String> map, boolean z2, boolean z3) {
        if (f37626a) {
            return UserAction.onUserAction(str, z, j, j2, map, z2, z3);
        }
        return false;
    }

    public static boolean a(boolean z, long j, Map<String, String> map) {
        if (f37626a) {
            return UserAction.loginEvent(z, j, map);
        }
        return false;
    }

    public static String b() {
        return !f37626a ? "" : UserAction.getQIMEI();
    }

    public static void b(Context context) {
        if (f37626a) {
            UserAction.initUserAction(context);
        }
    }

    public static void b(String str) {
        if (f37626a) {
            UserAction.onPageIn(str);
        }
    }

    public static void b(String str, String str2) {
        if (f37626a) {
            UserAction.setReportDomain(str, str2);
        }
    }

    public static void b(boolean z) {
        if (f37626a) {
            UserAction.setUploadMode(z);
        }
    }

    public static String c() {
        return !f37626a ? "" : UserAction.getSDKVersion();
    }

    public static void c(String str) {
        if (f37626a) {
            UserAction.onPageOut(str);
        }
    }

    public static void c(String str, String str2) {
        if (f37626a) {
            UserAction.setUserID(str, str2);
        }
    }

    public static void d(String str) {
        if (f37626a) {
            UserAction.setAppKey(str);
        }
    }

    public static void e(String str) {
        if (f37626a) {
            UserAction.setAppVersion(str);
        }
    }

    public static void f(String str) {
        if (f37626a) {
            UserAction.setChannelID(str);
        }
    }

    public static void g(String str) {
        if (f37626a && a(UserAction.getSDKVersion(), "3.2.0")) {
            UserAction.setOmgId(str);
        }
    }

    public static void h(String str) {
        if (f37626a) {
            UserAction.setQQ(str);
        }
    }

    public static void i(String str) {
        if (f37626a) {
            UserAction.setUserID(str);
        }
    }
}
