package com.xiaomi.push.service;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.BrowserContract;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hms.ads.fw;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/ay.class */
public class ay {

    /* renamed from: a  reason: collision with other field name */
    private static final String[] f947a = {"com.mi.globalbrowser", BrowserContract.AUTHORITY};

    /* renamed from: a  reason: collision with other field name */
    private static String f946a = null;

    /* renamed from: a  reason: collision with root package name */
    public static final a<String, String, String> f27929a = new a<>("setSound", "canSound", "canSound");
    public static final a<String, String, String> b = new a<>("setVibrate", "canVibrate", "canVibrate");

    /* renamed from: c  reason: collision with root package name */
    public static final a<String, String, String> f27930c = new a<>("setLights", "canLights", "canLights");
    public static final a<String, String, String> d = new a<>("setShowOnKeyguard", "canShowOnKeyguard", "canShowOnKeyguard");
    public static final a<String, String, String> e = new a<>("setFloat", "canFloat", "canShowFloat");
    public static final a<String, String, String> f = new a<>("setShowBadge", "canShowBadge", "canShowBadge");

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/ay$a.class */
    public static class a<F, S, T> {

        /* renamed from: a  reason: collision with root package name */
        F f27931a;
        S b;

        /* renamed from: c  reason: collision with root package name */
        T f27932c;

        private a(F f, S s, T t) {
            this.f27931a = f;
            this.b = s;
            this.f27932c = t;
        }
    }

    public static int a(ContentResolver contentResolver) {
        try {
            return Settings.Global.getInt(contentResolver, "user_aggregate", 0);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("get user aggregate failed, ".concat(String.valueOf(e2)));
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Context context, String str) {
        return com.xiaomi.push.g.b(context, str);
    }

    public static int a(Context context, String str, String str2, a<String, String, String> aVar) {
        if (aVar != null) {
            try {
                Bundle a2 = a(context, aVar.b, str, str2, (Bundle) null);
                if (a2 == null || !a2.containsKey(aVar.f27932c)) {
                    return -1;
                }
                return a2.getBoolean(aVar.f27932c) ? 1 : 0;
            } catch (Exception e2) {
                return -1;
            }
        }
        return -1;
    }

    private static Bundle a(Context context, String str, String str2, String str3, Bundle bundle) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("call notification provider failed!");
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("package", str2);
        if (!TextUtils.isEmpty(str3)) {
            bundle2.putString("channel_id", str3);
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        return context.getContentResolver().call(Uri.parse("content://statusbar.notification"), str, null, bundle2);
    }

    public static <T> T a(Notification notification, String str) {
        if (notification.extras != null) {
            try {
                return (T) notification.extras.get(str);
            } catch (Exception e2) {
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T a(Object obj, String str, T t) {
        T t2;
        try {
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("get value error ".concat(String.valueOf(e2)));
        }
        if (obj instanceof Notification) {
            t2 = a((Notification) obj, str);
        } else if (obj instanceof Map) {
            t2 = ((Map) obj).get(str);
        } else if (obj instanceof Bundle) {
            t2 = ((Bundle) obj).get(str);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m8344a("not support get value from classType:".concat(String.valueOf(obj)));
            t2 = null;
        }
        return t2 == null ? t : t2;
    }

    public static String a(Notification notification) {
        CharSequence charSequence;
        if (notification.extras != null) {
            CharSequence charSequence2 = notification.extras.getCharSequence("android.title");
            CharSequence charSequence3 = charSequence2;
            if (TextUtils.isEmpty(charSequence2)) {
                charSequence3 = notification.extras.getCharSequence("android.title.big");
            }
            charSequence = charSequence3;
            if (TextUtils.isEmpty(charSequence3)) {
                charSequence = notification.extras.getCharSequence("mipush.customTitle");
            }
        } else {
            charSequence = null;
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    public static String a(Object obj) {
        return (String) a(obj, "msg_busi_type", "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Notification notification, int i) {
        try {
            if (notification.extras != null) {
                notification.extras.putInt("miui.messageCount", i);
            }
            Object a2 = com.xiaomi.push.bi.a(notification, "extraNotification");
            if (a2 != null) {
                com.xiaomi.push.bi.a(a2, "setMessageCount", Integer.valueOf(i));
            }
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Notification notification, int i, int i2) {
        if (notification != null) {
            if (notification.extras == null) {
                notification.extras = new Bundle();
            }
            notification.extras.putInt("is_priority", i);
            notification.extras.putInt("mipush_class", i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public static void m9093a(Notification notification, String str) {
        try {
            if (notification.extras != null) {
                notification.extras.putString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, str);
            }
            Object a2 = com.xiaomi.push.bi.a(notification, "extraNotification");
            if (a2 != null) {
                com.xiaomi.push.bi.a(a2, "setTargetPkg", str);
            }
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Notification notification, boolean z) {
        try {
            if (notification.extras != null) {
                notification.extras.putBoolean("miui.enableFloat", z);
            }
            Object a2 = com.xiaomi.push.bi.a(notification, "extraNotification");
            if (a2 != null) {
                com.xiaomi.push.bi.a(a2, "setEnableFloat", Boolean.valueOf(z));
            }
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, String str, Intent intent) {
        if (intent == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(str);
        }
        arrayList.addAll(Arrays.asList(f947a));
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            String str2 = (String) arrayList.get(i2);
            if (!TextUtils.isEmpty(str2)) {
                Intent intent2 = new Intent(intent);
                intent2.setPackage(str2);
                try {
                    if (context.getPackageManager().resolveActivity(intent2, 65536) != null) {
                        intent.setPackage(str2);
                        break;
                    }
                    continue;
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m8344a("can't match url intent. ".concat(String.valueOf(e2)));
                }
            }
            i = i2 + 1;
        }
        intent.setPackage(intent.getPackage());
    }

    public static void a(Map<String, String> map, Bundle bundle, String str) {
        if (map == null || bundle == null || TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("cp map to b fail:".concat(String.valueOf(str)));
        } else if (TextUtils.isEmpty(map.get(str))) {
            bundle.remove(str);
        } else {
            bundle.putString(str, map.get(str));
        }
    }

    public static boolean a(Notification.Builder builder, boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setGroupAlertBehavior(z ? 2 : 1);
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.b("not support setGroupAlertBehavior");
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m9094a(ContentResolver contentResolver) {
        int a2 = a(contentResolver);
        return a2 == 1 || a2 == 2;
    }

    public static boolean a(Context context, String str, String str2, a<String, String, String> aVar, boolean z) {
        if (aVar != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putBoolean(aVar.f27932c, z);
                a(context, aVar.f27931a, str, str2, bundle);
                return true;
            } catch (Exception e2) {
                return false;
            }
        }
        return false;
    }

    public static boolean a(Map<String, String> map) {
        return Boolean.parseBoolean((String) a(map, "not_suppress", fw.Code));
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Notification.Action[] m9095a(Notification notification) {
        Parcelable[] parcelableArray;
        if (notification.actions != null) {
            return notification.actions;
        }
        if (notification.extras == null || (parcelableArray = notification.extras.getParcelableArray("mipush.customActions")) == null) {
            return null;
        }
        return (Notification.Action[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Notification.Action[].class);
    }

    public static String b(Notification notification) {
        CharSequence charSequence;
        if (notification.extras != null) {
            CharSequence charSequence2 = notification.extras.getCharSequence("android.text");
            CharSequence charSequence3 = charSequence2;
            if (TextUtils.isEmpty(charSequence2)) {
                charSequence3 = charSequence2;
                if (Build.VERSION.SDK_INT >= 21) {
                    charSequence3 = notification.extras.getCharSequence("android.bigText");
                }
            }
            charSequence = charSequence3;
            if (TextUtils.isEmpty(charSequence3)) {
                charSequence = notification.extras.getCharSequence("mipush.customContent");
            }
        } else {
            charSequence = null;
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    public static void b(Notification notification, boolean z) {
        try {
            if (notification.extras != null) {
                notification.extras.putBoolean("miui.enableKeyguard", z);
            }
            Object a2 = com.xiaomi.push.bi.a(notification, "extraNotification");
            if (a2 != null) {
                com.xiaomi.push.bi.a(a2, "setEnableKeyguard", Boolean.valueOf(z));
            }
        } catch (Exception e2) {
        }
    }

    public static String c(Notification notification) {
        String str = null;
        String str2 = null;
        try {
            if (notification.extras != null) {
                str = notification.extras.getString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE);
            }
            String str3 = str;
            if (TextUtils.isEmpty(str)) {
                String str4 = str;
                Object a2 = com.xiaomi.push.bi.a(notification, "extraNotification");
                str3 = str;
                if (a2 != null) {
                    str2 = str;
                    str3 = (String) com.xiaomi.push.bi.a(a2, "getTargetPkg", new Object[0]);
                }
            }
            return str3;
        } catch (Exception e2) {
            return str2;
        }
    }
}
