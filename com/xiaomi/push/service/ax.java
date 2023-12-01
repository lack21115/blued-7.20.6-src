package com.xiaomi.push.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.xiaomi.push.hl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/ax.class */
public class ax {

    /* renamed from: a  reason: collision with root package name */
    private static Context f41619a;

    /* renamed from: a  reason: collision with other field name */
    private static Object f989a;

    /* renamed from: a  reason: collision with other field name */
    private static WeakHashMap<Integer, ax> f990a = new WeakHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private static boolean f991a;

    /* renamed from: a  reason: collision with other field name */
    private String f992a;
    private String b;

    private ax(String str) {
        this.f992a = str;
    }

    private static int a(String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return f41619a.getPackageManager().getPackageUid(str, 0);
            } catch (Exception e) {
                return -1;
            }
        }
        return -1;
    }

    private static NotificationManager a() {
        return (NotificationManager) f41619a.getSystemService("notification");
    }

    public static ax a(Context context, String str) {
        a(context);
        int hashCode = str.hashCode();
        ax axVar = f990a.get(Integer.valueOf(hashCode));
        ax axVar2 = axVar;
        if (axVar == null) {
            axVar2 = new ax(str);
            f990a.put(Integer.valueOf(hashCode), axVar2);
        }
        return axVar2;
    }

    private static <T> T a(Object obj) {
        if (obj != null) {
            try {
                return (T) obj.getClass().getMethod("getList", new Class[0]).invoke(obj, new Object[0]);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    private static Object a(List list) {
        return Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class).newInstance(list);
    }

    public static String a(String str, String str2) {
        String str3 = str;
        if (!TextUtils.isEmpty(str)) {
            String a2 = a("mipush|%s|%s", str2, "");
            str3 = str;
            if (str.startsWith(a2)) {
                str3 = a("mipush_%s_%s", str2, str.replace(a2, ""));
            }
        }
        return str3;
    }

    private static String a(String str, String str2, String str3) {
        return TextUtils.isEmpty(str) ? "" : String.format(str, str2, str3);
    }

    private static void a(Context context) {
        if (f41619a == null) {
            f41619a = context.getApplicationContext();
            NotificationManager a2 = a();
            Boolean bool = (Boolean) com.xiaomi.push.bi.a((Object) a2, "isSystemConditionProviderEnabled", "xmsf_fake_condition_provider_path");
            m12131a("fwk is support.init:".concat(String.valueOf(bool)));
            boolean booleanValue = bool != null ? bool.booleanValue() : false;
            f991a = booleanValue;
            if (booleanValue) {
                f989a = com.xiaomi.push.bi.a((Object) a2, "getService", new Object[0]);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    static void m12131a(String str) {
        com.xiaomi.channel.commonutils.logger.b.m11394a("NMHelper:".concat(String.valueOf(str)));
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m12132a() {
        if (com.xiaomi.push.j.m12047a() && ba.a(f41619a).a(hl.NotificationBelongToAppSwitch.a(), true)) {
            return f991a;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m12133a(Context context) {
        a(context);
        return m12132a();
    }

    /* renamed from: a  reason: collision with other method in class */
    private StatusBarNotification[] m12134a() {
        if (com.xiaomi.push.j.m12048a(m12136a())) {
            try {
                Object a2 = com.xiaomi.push.bi.a(f989a, "getActiveNotifications", m12136a().getPackageName());
                if (a2 instanceof StatusBarNotification[]) {
                    return (StatusBarNotification[]) a2;
                }
                return null;
            } catch (Throwable th) {
                m12131a("getAllNotifications error ".concat(String.valueOf(th)));
                return null;
            }
        }
        return null;
    }

    private String b(String str) {
        return a(m12132a() ? "mipush|%s|%s" : "mipush_%s_%s", this.f992a, str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public NotificationChannel m12135a(String str) {
        NotificationChannel next;
        try {
            if (m12132a()) {
                List<NotificationChannel> m12139a = m12139a();
                if (m12139a != null) {
                    Iterator<NotificationChannel> it = m12139a.iterator();
                    do {
                        if (!it.hasNext()) {
                            return null;
                        }
                        next = it.next();
                    } while (!str.equals(next.getId()));
                    return next;
                }
                return null;
            }
            return a().getNotificationChannel(str);
        } catch (Exception e) {
            m12131a("getNotificationChannel error".concat(String.valueOf(e)));
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public Context m12136a() {
        return f41619a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m12137a() {
        return this.f992a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m12138a(String str) {
        if (TextUtils.isEmpty(str)) {
            return b();
        }
        String str2 = str;
        if (com.xiaomi.push.j.m12048a(m12136a())) {
            str2 = b(str);
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a  reason: collision with other method in class */
    public List<NotificationChannel> m12139a() {
        List<NotificationChannel> list;
        String str;
        String str2 = this.f992a;
        List<NotificationChannel> list2 = null;
        List<NotificationChannel> list3 = null;
        try {
            if (m12132a()) {
                int a2 = a(str2);
                if (a2 != -1) {
                    list2 = (List) a(com.xiaomi.push.bi.a(f989a, "getNotificationChannelsForPackage", str2, Integer.valueOf(a2), Boolean.FALSE));
                    str = "mipush|%s|%s";
                } else {
                    str = null;
                }
            } else {
                list2 = a().getNotificationChannels();
                str = "mipush_%s_%s";
            }
            list = list2;
            if (com.xiaomi.push.j.m12047a()) {
                list = list2;
                if (list2 != null) {
                    ArrayList arrayList = new ArrayList();
                    List<NotificationChannel> list4 = list2;
                    String a3 = a(str, str2, "");
                    List<NotificationChannel> list5 = list2;
                    Iterator<NotificationChannel> it = list2.iterator();
                    while (true) {
                        list3 = list2;
                        if (!it.hasNext()) {
                            return arrayList;
                        }
                        List<NotificationChannel> list6 = list2;
                        NotificationChannel next = it.next();
                        List<NotificationChannel> list7 = list2;
                        if (next.getId().startsWith(a3)) {
                            List<NotificationChannel> list8 = list2;
                            arrayList.add(next);
                        }
                    }
                }
            }
        } catch (Exception e) {
            m12131a("getNotificationChannels error ".concat(String.valueOf(e)));
            list = list3;
        }
        return list;
    }

    public void a(int i) {
        String str = this.f992a;
        try {
            if (!m12132a()) {
                a().cancel(i);
                return;
            }
            int a2 = com.xiaomi.push.i.a();
            String packageName = m12136a().getPackageName();
            if (Build.VERSION.SDK_INT >= 30) {
                com.xiaomi.push.bi.b(f989a, "cancelNotificationWithTag", str, packageName, null, Integer.valueOf(i), Integer.valueOf(a2));
            } else {
                com.xiaomi.push.bi.b(f989a, "cancelNotificationWithTag", str, null, Integer.valueOf(i), Integer.valueOf(a2));
            }
            m12131a("cancel succ:".concat(String.valueOf(i)));
        } catch (Exception e) {
            m12131a("cancel error".concat(String.valueOf(e)));
        }
    }

    public void a(int i, Notification notification) {
        String str = this.f992a;
        NotificationManager a2 = a();
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (!m12132a()) {
                a2.notify(i, notification);
                return;
            }
            if (i2 >= 19) {
                notification.extras.putString("xmsf_target_package", str);
            }
            if (i2 >= 29) {
                a2.notifyAsPackage(str, null, i, notification);
            } else {
                a2.notify(i, notification);
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(NotificationChannel notificationChannel) {
        String str = this.f992a;
        try {
            if (!m12132a()) {
                a().createNotificationChannel(notificationChannel);
                return;
            }
            int a2 = a(str);
            if (a2 != -1) {
                com.xiaomi.push.bi.b(f989a, "createNotificationChannelsForPackage", str, Integer.valueOf(a2), a(Arrays.asList(notificationChannel)));
            }
        } catch (Exception e) {
            m12131a("createNotificationChannel error".concat(String.valueOf(e)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(NotificationChannel notificationChannel, boolean z) {
        String str = this.f992a;
        try {
            if (!z) {
                a(notificationChannel);
                return;
            }
            int a2 = a(str);
            if (a2 != -1) {
                com.xiaomi.push.bi.b(f989a, "updateNotificationChannelForPackage", str, Integer.valueOf(a2), notificationChannel);
            }
        } catch (Exception e) {
            m12131a("updateNotificationChannel error ".concat(String.valueOf(e)));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m12140a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(b(""));
    }

    String b() {
        if (TextUtils.isEmpty(this.b)) {
            this.b = b("default");
        }
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b(String str, String str2) {
        if (!m12132a()) {
            str = str2;
        }
        return str;
    }

    /* renamed from: b  reason: collision with other method in class */
    public List<StatusBarNotification> m12141b() {
        ArrayList arrayList;
        ArrayList arrayList2;
        String str = this.f992a;
        NotificationManager a2 = a();
        try {
            if (m12132a()) {
                int a3 = com.xiaomi.push.i.a();
                arrayList2 = null;
                if (a3 != -1) {
                    return (List) a(com.xiaomi.push.bi.a(f989a, "getAppActiveNotifications", str, Integer.valueOf(a3)));
                }
            } else {
                StatusBarNotification[] activeNotifications = Build.VERSION.SDK_INT >= 23 ? a2.getActiveNotifications() : m12134a();
                arrayList2 = null;
                if (activeNotifications != null) {
                    arrayList2 = null;
                    if (activeNotifications.length > 0) {
                        ArrayList arrayList3 = new ArrayList();
                        try {
                            for (StatusBarNotification statusBarNotification : activeNotifications) {
                                if (str.equals(ay.c(statusBarNotification.getNotification()))) {
                                    arrayList3.add(statusBarNotification);
                                }
                            }
                            return arrayList3;
                        } catch (Throwable th) {
                            arrayList = arrayList3;
                            th = th;
                            m12131a("getActiveNotifications error ".concat(String.valueOf(th)));
                            arrayList2 = arrayList;
                            return arrayList2;
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            arrayList = null;
        }
        return arrayList2;
    }

    public String toString() {
        return "NotificationManagerHelper{" + this.f992a + com.alipay.sdk.util.i.d;
    }
}
