package com.vivo.push.util;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/util/z.class */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    private static String[] f41151a = {"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};
    private static String[] b = {"android.permission.INTERNET", "android.permission.READ_PHONE_STATE", "android.permission.ACCESS_NETWORK_STATE", Manifest.permission.WRITE_SETTINGS, Manifest.permission.VIBRATE, "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_WIFI_STATE", Manifest.permission.WAKE_LOCK, "android.permission.GET_ACCOUNTS", "com.bbk.account.permission.READ_ACCOUNTINFO", Manifest.permission.AUTHENTICATE_ACCOUNTS, Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS, "android.permission.GET_TASKS"};

    /* renamed from: c  reason: collision with root package name */
    private static String[] f41152c = {"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};
    private static String[] d = {"com.vivo.push.sdk.RegistrationReceiver"};
    private static String[] e = new String[0];
    private static Map<String, Bundle> f = new ConcurrentHashMap();

    public static long a(Context context) {
        String b2 = t.b(context);
        if (TextUtils.isEmpty(b2)) {
            p.a("Utility", "systemPushPkgName is null");
            return -1L;
        }
        return a(context, b2);
    }

    public static long a(Context context, String str) {
        Object a2 = a(context, str, "com.vivo.push.sdk_version");
        Object obj = a2;
        if (a2 == null) {
            obj = a(context, str, "sdk_version");
        }
        if (obj == null) {
            p.a("Utility", "getSdkVersionCode sdk version is null");
            return -1L;
        }
        try {
            return Long.parseLong(obj.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
            p.a("Utility", "getSdkVersionCode error ", e2);
            return -1L;
        }
    }

    public static Object a(Context context, String str, String str2) {
        Object obj;
        Object obj2;
        Object obj3;
        Bundle bundle;
        Bundle bundle2 = null;
        if (context == null || str2 == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            obj3 = (f == null || f.size() <= 0 || (bundle = f.get(str)) == null) ? null : bundle.get(str2);
        } catch (Exception e2) {
            e = e2;
            obj = null;
        }
        if (obj3 != null) {
            return obj3;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo != null) {
                bundle2 = applicationInfo.metaData;
            }
            obj = bundle2 != null ? bundle2.get(str2) : obj3;
            obj2 = obj;
            try {
                if (f.size() <= 300) {
                    f.put(str, bundle2);
                    return obj;
                }
            } catch (Exception e3) {
                e = e3;
                p.a("Utility", "getMetaValue::".concat(String.valueOf(e)));
                obj2 = obj;
                return obj2;
            }
        } catch (Exception e4) {
            e = e4;
            obj = obj3;
        }
        return obj2;
    }

    public static Object a(String str, String str2) {
        Class<?> cls = Class.forName(str);
        return cls.getField(str2).get(cls);
    }

    public static void a(Context context, Intent intent) {
        String b2 = t.b(context);
        String stringExtra = intent.getStringExtra("client_pkgname");
        if (TextUtils.isEmpty(b2)) {
            p.a("Utility", "illegality abe adapter : push pkg is null");
        } else if (TextUtils.isEmpty(stringExtra)) {
            p.a("Utility", "illegality abe adapter : src pkg is null");
        } else if (b2.equals(context.getPackageName())) {
            p.a("Utility", "illegality abe adapter : abe is not pushservice");
        } else if (b2.equals(stringExtra)) {
            p.a("Utility", "illegality abe adapter : pushPkg = " + b2 + " ; srcPkg = " + stringExtra);
        } else {
            p.d("Utility", "proxy to core : intent pkg : " + intent.getPackage() + " ; src pkg : " + stringExtra + " ; push pkg : " + b2);
            intent.setPackage(b2);
            intent.setClassName(b2, "com.vivo.push.sdk.service.PushService");
            context.startService(intent);
        }
    }

    private static void a(Context context, String str, String str2, boolean z) {
        ResolveInfo next;
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            if (z) {
                List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 576);
                if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
                    throw new VivoPushException("checkModule " + intent + " has no receivers");
                }
                Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
                do {
                    if (!it.hasNext()) {
                        throw new VivoPushException(str2 + " is missing");
                    }
                } while (!str2.equals(it.next().activityInfo.name));
                return;
            }
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 576);
            if (queryIntentServices == null || queryIntentServices.size() <= 0) {
                throw new VivoPushException("checkModule " + intent + " has no services");
            }
            Iterator<ResolveInfo> it2 = queryIntentServices.iterator();
            do {
                if (!it2.hasNext()) {
                    throw new VivoPushException(str2 + " is missing");
                }
                next = it2.next();
            } while (!str2.equals(next.serviceInfo.name));
            if (next.serviceInfo.exported) {
                return;
            }
            throw new VivoPushException(next.serviceInfo.name + " exported is false");
        } catch (Exception e2) {
            p.a("Utility", "error  " + e2.getMessage());
            throw new VivoPushException("checkModule error" + e2.getMessage());
        }
    }

    private static void a(ComponentInfo componentInfo, String str) {
        if (componentInfo.applicationInfo.packageName.equals(str)) {
            return;
        }
        String[] strArr = f41151a;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            if (strArr[i2].equals(componentInfo.name) && !componentInfo.processName.contains(":pushservice")) {
                throw new VivoPushException("module : " + componentInfo.name + " process :" + componentInfo.processName + "  check process fail");
            }
            i = i2 + 1;
        }
    }

    private static void a(String str, ComponentInfo[] componentInfoArr, String str2) {
        int length = componentInfoArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                throw new VivoPushException(str + " module Push-SDK need is not exist");
            }
            ComponentInfo componentInfo = componentInfoArr[i2];
            if (str.equals(componentInfo.name)) {
                if (componentInfo.enabled) {
                    a(componentInfo, str2);
                    return;
                }
                throw new VivoPushException(componentInfo.name + " module Push-SDK need is illegitmacy !");
            }
            i = i2 + 1;
        }
    }

    public static String b(Context context, String str) {
        Object a2 = a(context, str, "com.vivo.push.app_id");
        if (a2 != null) {
            return a2.toString();
        }
        Object a3 = a(context, str, "app_id");
        return a3 != null ? a3.toString() : "";
    }

    public static String b(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = str2;
        }
        String str4 = str2;
        if (str3 != null) {
            if (str3.length() == 0) {
                return str2;
            }
            str4 = str3;
        }
        return str4;
    }

    public static void b(Context context) {
        String obj;
        int i;
        p.d("Utility", "check PushService AndroidManifest declearation !");
        String b2 = t.b(context);
        boolean d2 = t.d(context, context.getPackageName());
        boolean e2 = t.e(context, context.getPackageName());
        boolean c2 = t.c(context, context.getPackageName());
        if (e2) {
            f41151a = new String[]{"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};
            b = new String[]{"android.permission.INTERNET", "android.permission.READ_PHONE_STATE", "android.permission.ACCESS_NETWORK_STATE", Manifest.permission.WRITE_SETTINGS, Manifest.permission.VIBRATE, "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_WIFI_STATE", Manifest.permission.WAKE_LOCK, "android.permission.GET_ACCOUNTS", "com.bbk.account.permission.READ_ACCOUNTINFO", Manifest.permission.AUTHENTICATE_ACCOUNTS, Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS, "android.permission.GET_TASKS"};
            f41152c = new String[]{"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};
            d = new String[]{"com.vivo.push.sdk.RegistrationReceiver"};
        } else if (!c2 && !d2) {
            throw new VivoPushException("AndroidManifest.xml中receiver配置项错误，详见接入文档");
        } else {
            if (c2) {
                f41152c = new String[]{"com.vivo.push.sdk.service.CommandClientService"};
            } else {
                f41152c = new String[]{"com.vivo.push.sdk.service.CommandService"};
            }
            d = new String[0];
            f41151a = new String[0];
            if (d2) {
                b = new String[]{"android.permission.INTERNET", Manifest.permission.WRITE_SETTINGS};
            } else {
                b = new String[]{"android.permission.INTERNET"};
            }
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            String[] strArr = packageManager.getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr == null) {
                throw new VivoPushException("Permissions is null!");
            }
            String[] strArr2 = b;
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    f(context, b2);
                    d(context, b2);
                    e(context, b2);
                    try {
                        if (a(context, context.getPackageName(), "local_iv") == null) {
                            throw new VivoPushException("AndroidManifest.xml中未配置".concat("local_iv"));
                        }
                        String packageName = context.getPackageName();
                        Object a2 = a(context, packageName, "com.vivo.push.api_key");
                        if (a2 != null) {
                            obj = a2.toString();
                        } else {
                            Object a3 = a(context, packageName, "api_key");
                            obj = a3 != null ? a3.toString() : "";
                        }
                        if (TextUtils.isEmpty(obj)) {
                            throw new VivoPushException("com.vivo.push.api_key is null");
                        }
                        if (TextUtils.isEmpty(b(context, context.getPackageName()))) {
                            throw new VivoPushException("com.vivo.push.app_id is null");
                        }
                        if ((d2 || e2) && a(context, context.getPackageName()) == -1) {
                            throw new VivoPushException("sdkversion is null");
                        }
                        if (e2) {
                            a(context, "com.vivo.pushservice.action.METHOD", "com.vivo.push.sdk.RegistrationReceiver", true);
                            a(context, "com.vivo.pushservice.action.PUSH_SERVICE", "com.vivo.push.sdk.service.PushService", false);
                            return;
                        }
                        return;
                    } catch (Exception e3) {
                        throw new VivoPushException("getMetaValue error " + e3.getMessage());
                    }
                }
                String str = strArr2[i3];
                int length2 = strArr.length;
                while (true) {
                    int i4 = i;
                    if (i4 >= length2) {
                        throw new VivoPushException("permission : " + str + "  check fail : " + Arrays.toString(strArr));
                    }
                    i = str.equals(strArr[i4]) ? 0 : i4 + 1;
                }
                i2 = i3 + 1;
            }
        } catch (Exception e4) {
            throw new VivoPushException(e4.getMessage());
        }
    }

    public static boolean b(Context context, String str, String str2) {
        AutoCloseable autoCloseable = null;
        AutoCloseable autoCloseable2 = null;
        try {
            try {
                try {
                    if (context == null) {
                        p.a("Utility", com.anythink.expressad.foundation.g.b.b.f7836a);
                        return false;
                    }
                    Cursor query = context.getContentResolver().query(com.vivo.push.p.f41114c, null, "appPkgName = ? and regId = ? sdkVersion = ? ", new String[]{str, str2, "323"}, null);
                    if (query == null) {
                        p.a("Utility", "cursor is null");
                        if (query != null) {
                            try {
                                query.close();
                                return false;
                            } catch (Exception e2) {
                                p.a("Utility", "close", e2);
                                return false;
                            }
                        }
                        return false;
                    } else if (!query.moveToFirst()) {
                        if (query != null) {
                            query.close();
                            return false;
                        }
                        return false;
                    } else {
                        boolean parseBoolean = Boolean.parseBoolean(query.getString(query.getColumnIndex("clientState")));
                        if (query != null) {
                            try {
                                query.close();
                                return parseBoolean;
                            } catch (Exception e3) {
                                p.a("Utility", "close", e3);
                            }
                        }
                        return parseBoolean;
                    }
                } catch (Exception e4) {
                    p.a("Utility", "close", e4);
                    return false;
                }
            } catch (Exception e5) {
                p.a("Utility", "isOverdue", e5);
                if (0 != 0) {
                    autoCloseable.close();
                    return false;
                }
                return false;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    autoCloseable2.close();
                } catch (Exception e6) {
                    p.a("Utility", "close", e6);
                }
            }
            throw th;
        }
    }

    public static String c(Context context, String str) {
        Object a2 = a(context, str, "verification_status");
        return a2 != null ? a2.toString() : "";
    }

    public static PublicKey c(Context context) {
        Cursor query = context.getContentResolver().query(com.vivo.push.p.f41113a, null, null, null, null);
        if (query == null) {
            return null;
        }
        do {
            try {
                try {
                    if (query.moveToNext()) {
                    }
                } catch (Throwable th) {
                    try {
                        query.close();
                    } catch (Exception e2) {
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                query.close();
                return null;
            } catch (Exception e4) {
                return null;
            }
        } while (!"pushkey".equals(query.getString(query.getColumnIndex("name"))));
        String string = query.getString(query.getColumnIndex("value"));
        p.d("Utility", "result key : ".concat(String.valueOf(string)));
        PublicKey a2 = u.a(string);
        try {
            query.close();
            return a2;
        } catch (Exception e5) {
            return a2;
        }
    }

    private static void d(Context context, String str) {
        try {
            if (context.getPackageManager() == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services;
            if (serviceInfoArr == null) {
                throw new VivoPushException("serviceInfos is null");
            }
            String[] strArr = f41152c;
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                a(strArr[i2], serviceInfoArr, str);
                i = i2 + 1;
            }
        } catch (Exception e2) {
            throw new VivoPushException("error " + e2.getMessage());
        }
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0107: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r11 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:55:0x0107 */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x00e2: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r12 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:46:0x00e2 */
    public static boolean d(Context context) {
        AutoCloseable autoCloseable;
        AutoCloseable autoCloseable2;
        try {
            try {
                try {
                    if (context == null) {
                        p.a("Utility", com.anythink.expressad.foundation.g.b.b.f7836a);
                        return false;
                    }
                    String packageName = context.getPackageName();
                    Cursor query = context.getContentResolver().query(com.vivo.push.p.b, null, "pushVersion = ? and appPkgName = ? and appCode = ? ", new String[]{"323", packageName, String.valueOf(context.getPackageManager().getPackageInfo(packageName, 0).versionCode)}, null);
                    if (query == null) {
                        p.a("Utility", "cursor is null");
                        if (query != null) {
                            try {
                                query.close();
                                return false;
                            } catch (Exception e2) {
                                p.a("Utility", "close", e2);
                                return false;
                            }
                        }
                        return false;
                    } else if (!query.moveToFirst() || (query.getInt(query.getColumnIndex("permission")) & 1) == 0) {
                        if (query != null) {
                            query.close();
                            return false;
                        }
                        return false;
                    } else if (query != null) {
                        try {
                            query.close();
                            return true;
                        } catch (Exception e3) {
                            p.a("Utility", "close", e3);
                            return true;
                        }
                    } else {
                        return true;
                    }
                } catch (Exception e4) {
                    p.a("Utility", "isSupport", e4);
                    if (autoCloseable != null) {
                        autoCloseable.close();
                        return false;
                    }
                    return false;
                }
            } catch (Throwable th) {
                if (autoCloseable2 != null) {
                    try {
                        autoCloseable2.close();
                    } catch (Exception e5) {
                        p.a("Utility", "close", e5);
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            p.a("Utility", "close", e6);
            return false;
        }
    }

    private static void e(Context context, String str) {
        if (e.length <= 0) {
            return;
        }
        try {
            if (context.getPackageManager() == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
            if (activityInfoArr == null) {
                throw new VivoPushException("activityInfos is null");
            }
            String[] strArr = e;
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                a(strArr[i2], activityInfoArr, str);
                i = i2 + 1;
            }
        } catch (Exception e2) {
            throw new VivoPushException("error " + e2.getMessage());
        }
    }

    private static void f(Context context, String str) {
        try {
            if (context.getPackageManager() == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 2).receivers;
            if (activityInfoArr == null) {
                throw new VivoPushException("receivers is null");
            }
            String[] strArr = d;
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                a(strArr[i2], activityInfoArr, str);
                i = i2 + 1;
            }
        } catch (Exception e2) {
            throw new VivoPushException(e2.getMessage());
        }
    }
}
