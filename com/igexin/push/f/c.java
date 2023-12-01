package com.igexin.push.f;

import android.Manifest;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.text.TextUtils;
import com.igexin.push.core.ServiceManager;
import com.igexin.sdk.GActivity;
import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.GetuiPushException;
import com.igexin.sdk.PushActivity;
import com.igexin.sdk.PushReceiver;
import com.igexin.sdk.PushService;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/f/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f10030a = "CheckUtils";
    private static Integer b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f10031c = "checkOpNoThrow";
    private static final String d = "OP_POST_NOTIFICATION";
    private static final ServiceConnection e = new ServiceConnection() { // from class: com.igexin.push.f.c.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Context context = ServiceManager.b;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            Context context = ServiceManager.b;
        }
    };

    public static void a(Context context, Intent intent) {
        try {
            if (Build.VERSION.SDK_INT < 26 || !g()) {
                context.getApplicationContext().startService(intent);
            } else {
                c(intent, context);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a("CheckUtils|startPService err：" + th.toString(), new Object[0]);
            if (th instanceof IllegalStateException) {
                c(intent, context);
            }
        }
    }

    private static void a(Map<String, com.igexin.push.core.b.f> map, String str) {
        map.remove(str);
        for (String str2 : map.get(str).b) {
            com.igexin.push.core.b.f fVar = map.get(str2);
            if (fVar != null) {
                fVar.f9832c--;
                if (fVar.f9832c == 0) {
                    a(map, str2);
                }
            }
        }
    }

    public static boolean a() {
        return System.currentTimeMillis() > com.igexin.push.config.d.d;
    }

    public static boolean a(long j) {
        if (com.igexin.push.config.d.f9768c == 0) {
            return false;
        }
        Date date = new Date(j);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(11);
        int i2 = com.igexin.push.config.d.b + com.igexin.push.config.d.f9768c;
        int i3 = i2;
        if (i2 >= 24) {
            i3 = i2 - 24;
        }
        if (com.igexin.push.config.d.b < i3) {
            return i >= com.igexin.push.config.d.b && i < i3;
        } else if (com.igexin.push.config.d.b > i3) {
            if (i < 0 || i >= i3) {
                return i >= com.igexin.push.config.d.b && i < 24;
            }
            return true;
        } else {
            return false;
        }
    }

    public static boolean a(Context context) {
        if (b == null) {
            b = (context.getApplicationInfo().flags & 2) == 0 ? -1 : 1;
        }
        return b.intValue() > 0;
    }

    public static boolean a(Intent intent, Context context) {
        if (context == null) {
            return false;
        }
        try {
            ServiceInfo[] serviceInfoArr = context.getApplicationContext().getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 4).services;
            if (serviceInfoArr == null || serviceInfoArr.length == 0) {
                return false;
            }
            int length = serviceInfoArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return false;
                }
                ServiceInfo serviceInfo = serviceInfoArr[i2];
                if (intent.getComponent() != null && serviceInfo.name.equals(intent.getComponent().getClassName())) {
                    return true;
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public static boolean a(String str) {
        try {
            return com.igexin.push.core.e.l.getPackageManager().getLaunchIntentForPackage(str) != null;
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0123, code lost:
        r0 = new java.util.ArrayList(r0.values());
        r0 = r0.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0145, code lost:
        if (r0.hasNext() == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0148, code lost:
        r0 = ((com.igexin.push.core.b.f) ((java.util.Map.Entry) r0.next()).getValue()).b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0161, code lost:
        if (r0 == null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0164, code lost:
        r0 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0174, code lost:
        if (r0.hasNext() == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0177, code lost:
        r0 = (com.igexin.push.core.b.f) r0.get(r0.next());
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x018e, code lost:
        if (r0 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0191, code lost:
        r0.f9832c++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01a5, code lost:
        if (r0.contains(r0) == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01a8, code lost:
        r0.remove(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01b4, code lost:
        r0 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01c1, code lost:
        if (r0.hasNext() == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01c4, code lost:
        a(r0, ((com.igexin.push.core.b.f) r0.next()).f9831a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01dd, code lost:
        if (r0.size() <= 0) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01e0, code lost:
        com.igexin.c.a.c.a.a("CheckUtils|action_chains have loop nodeMap not empty", new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01eb, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:?, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(org.json.JSONObject r4) {
        /*
            Method dump skipped, instructions count: 537
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.f.c.a(org.json.JSONObject):boolean");
    }

    public static boolean b() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) com.igexin.push.core.e.l.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public static boolean b(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                return ((Boolean) NotificationManager.class.getDeclaredMethod("areNotificationsEnabled", new Class[0]).invoke((NotificationManager) context.getSystemService("notification"), new Object[0])).booleanValue();
            }
            if (Build.VERSION.SDK_INT >= 19) {
                AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                String packageName = context.getApplicationContext().getPackageName();
                int i = applicationInfo.uid;
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                return ((Integer) cls.getMethod(f10031c, Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField(d).get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() == 0;
            }
            return true;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return true;
        }
    }

    public static boolean b(Intent intent, Context context) {
        if (intent == null || context == null) {
            return false;
        }
        try {
            ActivityInfo[] activityInfoArr = context.getApplicationContext().getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 1).activities;
            if (activityInfoArr == null || activityInfoArr.length == 0) {
                return false;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= activityInfoArr.length) {
                    return false;
                }
                ActivityInfo activityInfo = activityInfoArr[i2];
                if (intent.getComponent() != null && activityInfo.name.equals(intent.getComponent().getClassName())) {
                    return true;
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public static boolean b(String str) {
        try {
            if (TextUtils.isEmpty(com.igexin.push.config.d.C) || "none".equals(com.igexin.push.config.d.C)) {
                return false;
            }
            List asList = Arrays.asList(com.igexin.push.config.d.C.split(","));
            if (asList.isEmpty()) {
                return false;
            }
            Iterator it = asList.iterator();
            do {
                if (!it.hasNext()) {
                    return false;
                }
            } while (!str.startsWith((String) it.next()));
            return true;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public static void c() {
        NetworkInfo.State state = ((ConnectivityManager) com.igexin.push.core.e.l.getSystemService(Context.CONNECTIVITY_SERVICE)).getNetworkInfo(1).getState();
        if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
            com.igexin.push.core.e.x = 1;
        } else {
            com.igexin.push.core.e.x = 0;
        }
    }

    public static void c(Context context) throws GetuiPushException {
        boolean z;
        boolean z2;
        boolean z3;
        if (context == null) {
            throw new GetuiPushException("传入的context为空");
        }
        Context applicationContext = context.getApplicationContext();
        if (a(applicationContext)) {
            try {
                PackageInfo packageInfo = applicationContext.getApplicationContext().getPackageManager().getPackageInfo(applicationContext.getApplicationContext().getPackageName(), 4229);
                if (packageInfo == null) {
                    return;
                }
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if (applicationInfo == null) {
                    throw new GetuiPushException("ApplicationInfo 应用异常");
                }
                if (applicationInfo.metaData != null) {
                    String a2 = d.a(applicationInfo);
                    String str = a2;
                    if (TextUtils.isEmpty(a2)) {
                        str = applicationInfo.metaData.getString(com.igexin.push.core.b.b);
                    }
                    if (TextUtils.isEmpty(str) && TextUtils.isEmpty(applicationInfo.metaData.getString("GETUI_APPID"))) {
                        throw new GetuiPushException("未配置个推APPID");
                    }
                } else if (TextUtils.isEmpty(d.a(applicationInfo))) {
                    throw new GetuiPushException("未配置META-DATA");
                }
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                int length = serviceInfoArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        z = false;
                        break;
                    }
                    ServiceInfo serviceInfo = serviceInfoArr[i2];
                    if (!PushService.class.getName().equals(serviceInfo.name)) {
                        i = i2 + 1;
                    } else if (!serviceInfo.processName.endsWith(":pushservice")) {
                        throw new GetuiPushException("PushService需配置在pushservice进程");
                    } else {
                        z = true;
                    }
                }
                if (!z) {
                    throw new GetuiPushException("未集成com.igexin.sdk.PushService");
                }
                ActivityInfo[] activityInfoArr = packageInfo.activities;
                int length2 = activityInfoArr.length;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= length2) {
                        z2 = false;
                        break;
                    }
                    ActivityInfo activityInfo = activityInfoArr[i4];
                    if (!GActivity.class.getName().endsWith(activityInfo.name)) {
                        i3 = i4 + 1;
                    } else if (!activityInfo.processName.endsWith(":pushservice")) {
                        throw new GetuiPushException("GActivity需配置在pushservice进程");
                    } else {
                        if (activityInfo.theme != 16973840) {
                            throw new GetuiPushException("GActivity未配置正确theme");
                        }
                        if (!activityInfo.exported) {
                            throw new GetuiPushException("GActivity.exported属性需配置为true");
                        }
                        z2 = true;
                    }
                }
                if (!z2) {
                    throw new GetuiPushException("未集成com.igexin.sdk.GActivity,若enable = false,则忽略此预警");
                }
                int length3 = activityInfoArr.length;
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= length3) {
                        z3 = false;
                        break;
                    }
                    ActivityInfo activityInfo2 = activityInfoArr[i6];
                    if (!PushActivity.class.getName().endsWith(activityInfo2.name)) {
                        i5 = i6 + 1;
                    } else if (!activityInfo2.processName.endsWith(":pushservice")) {
                        throw new GetuiPushException("PushActivity需配置在pushservice进程");
                    } else {
                        if (activityInfo2.theme != 16973840) {
                            throw new GetuiPushException("PushActivity未配置正确theme");
                        }
                        z3 = true;
                    }
                }
                if (!z3) {
                    throw new GetuiPushException("未集成com.igexin.sdk.GActivity");
                }
                List<ResolveInfo> queryBroadcastReceivers = applicationContext.getPackageManager().queryBroadcastReceivers(new Intent(applicationContext, PushReceiver.class), 0);
                if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() == 0) {
                    throw new GetuiPushException("未集成com.igexin.sdk.PushReceiver");
                }
                if (packageInfo != null) {
                    String[] strArr = packageInfo.requestedPermissions;
                    if (strArr == null || strArr.length == 0) {
                        throw new GetuiPushException("Manifest中无权限配置");
                    }
                    List asList = Arrays.asList(strArr);
                    if (!asList.contains("android.permission.INTERNET")) {
                        throw new GetuiPushException("未在Manifest中配置所需权限：android.permission.INTERNET");
                    }
                    if (!asList.contains("android.permission.READ_PHONE_STATE")) {
                        throw new GetuiPushException("未在Manifest中配置所需权限：android.permission.READ_PHONE_STATE");
                    }
                    if (!asList.contains("android.permission.ACCESS_NETWORK_STATE")) {
                        throw new GetuiPushException("未在Manifest中配置所需权限：android.permission.ACCESS_NETWORK_STATE");
                    }
                    if (!asList.contains("android.permission.ACCESS_WIFI_STATE")) {
                        throw new GetuiPushException("未在Manifest中配置所需权限：android.permission.ACCESS_WIFI_STATE");
                    }
                    if (!asList.contains(Manifest.permission.VIBRATE)) {
                        throw new GetuiPushException("未在Manifest中配置所需权限：android.permission.VIBRATE");
                    }
                    if (!asList.contains("android.permission.GET_TASKS")) {
                        throw new GetuiPushException("未在Manifest中配置所需权限：android.permission.GET_TASKS");
                    }
                }
                ServiceInfo serviceInfo2 = d.a(applicationContext, PushService.class).first;
                if (serviceInfo2 == null) {
                    throw new GetuiPushException("未找到继承 com.igexin.sdk.PushService 的子类");
                }
                if (!serviceInfo2.processName.endsWith(":pushservice")) {
                    throw new GetuiPushException("自定义推送服务(Service)需配置在pushservice进程");
                }
                if (!TextUtils.isEmpty(serviceInfo2.permission)) {
                    throw new GetuiPushException("自定义推送服务(Service)不能配置android:permission");
                }
                if (d.a(applicationContext, GTIntentService.class).first == null) {
                    throw new GetuiPushException("未找到继承 com.igexin.sdk.GTIntentService 的子类");
                }
                try {
                    Class.forName("com.getui.gtc.base.log.Logger");
                } catch (ClassNotFoundException e2) {
                    throw new GetuiPushException("未配置 com.getui:gtc:version 依赖");
                }
            } catch (PackageManager.NameNotFoundException e3) {
            }
        }
    }

    private static void c(Intent intent, Context context) {
        com.igexin.c.a.c.a.a("CheckUtils|startPService by bind", new Object[0]);
        intent.setType("PB-" + System.nanoTime());
        context.getApplicationContext().bindService(intent, e, 1);
    }

    public static boolean c(String str) {
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(com.igexin.push.config.d.F) || "none".equals(com.igexin.push.config.d.F)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(Arrays.asList(com.igexin.push.config.d.F.split(",")));
            if (arrayList.isEmpty()) {
                return false;
            }
            Iterator it = arrayList.iterator();
            do {
                if (!it.hasNext()) {
                    return false;
                }
            } while (!str.contains((String) it.next()));
            return true;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public static void d() {
        com.igexin.push.core.e.y = ((PowerManager) com.igexin.push.core.e.l.getSystemService(Context.POWER_SERVICE)).isScreenOn() ? 1 : 0;
    }

    private static boolean d(Context context) {
        try {
            ApplicationInfo b2 = n.b(context);
            if (b2 == null || b2.metaData == null) {
                return false;
            }
            return !TextUtils.isEmpty(b2.metaData.getString("GETUI_APPID"));
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public static boolean d(String str) {
        try {
            if (Build.VERSION.SDK_INT < 28 || !a(com.igexin.push.core.e.l)) {
                k.a(str);
                com.igexin.c.a.c.a.b(f10030a, "checkApp by GtPm");
                return true;
            }
            return false;
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(f10030a, e2.toString());
            com.igexin.c.a.c.a.b(f10030a, "checkApp by GtPm");
            return false;
        }
    }

    public static boolean e() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) com.igexin.push.core.e.l.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager == null) {
                com.igexin.c.a.c.a.a("CheckUtils|ConnectivityManager is null", new Object[0]);
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            com.igexin.c.a.c.a.a("CheckUtils|activeNetworkInfo = ".concat(String.valueOf(activeNetworkInfo)), new Object[0]);
            if (activeNetworkInfo == null || activeNetworkInfo.getState() != NetworkInfo.State.CONNECTED) {
                com.igexin.c.a.c.a.a("CheckUtils|network available = false", new Object[0]);
                return false;
            }
            String str = activeNetworkInfo.getType() == 0 ? "mobile" : activeNetworkInfo.getType() == 1 ? "wifi" : "none";
            com.igexin.c.a.c.a.a(f10030a + str + "|connected", new Object[0]);
            return true;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.b(f10030a, "network available ex =" + th.toString());
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public static boolean f() {
        return System.currentTimeMillis() >= 1182566108138L;
    }

    public static boolean g() {
        String str = com.igexin.push.config.d.P;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String[] split = str.split(",");
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return false;
                }
                String str2 = split[i2];
                if (str2.contains("|") && str2.contains(Constants.WAVE_SEPARATOR)) {
                    String substring = str2.substring(0, str2.indexOf("|"));
                    String[] split2 = str2.substring(str2.indexOf("|") + 1).split(Constants.WAVE_SEPARATOR);
                    if (split2.length == 2) {
                        int parseInt = Integer.parseInt(split2[0]);
                        int parseInt2 = Integer.parseInt(split2[1]);
                        if (Build.BRAND.equalsIgnoreCase(substring) && Build.VERSION.SDK_INT >= parseInt && Build.VERSION.SDK_INT <= parseInt2) {
                            return true;
                        }
                    } else {
                        continue;
                    }
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    private static String h() {
        return null;
    }
}
