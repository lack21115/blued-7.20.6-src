package com.igexin.assist.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.igexin.assist.control.AbstractPushManager;
import com.igexin.assist.util.AssistUtils;
import com.igexin.c.a.c.a.d;
import com.igexin.push.core.e;
import com.igexin.push.core.e.f;
import com.igexin.push.f.n;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/assist/sdk/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9583a = "AssistMangerFactory";

    /* renamed from: c  reason: collision with root package name */
    private static final String f9584c = "com.igexin.assist.control.fcm.ManufacturePushManager";
    private static a d;
    private static final String[] e = {"com.igexin.assist.control.xiaomi.MiuiPushManager", "com.igexin.assist.control.meizu.FlymePushManager", "com.igexin.assist.control.huawei.HmsPushManager", "com.igexin.assist.control.oppo.OppoPushManager", "com.igexin.assist.control.vivo.VivoPushManager", "com.igexin.assist.control.st.SmartisanPushManager", "com.igexin.assist.control.fcm.FcmPushManager"};
    public AbstractPushManager b;

    public static a a() {
        if (d == null) {
            synchronized (AbstractPushManager.class) {
                try {
                    if (d == null) {
                        d = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    private void b(Context context) {
        AbstractPushManager abstractPushManager = this.b;
        if (abstractPushManager != null && abstractPushManager.isSupport()) {
            if (this.b.getBrandCode().equals("3")) {
                try {
                    Class.forName("com.xiaomi.mipush.sdk.MiPushClient").getDeclaredMethod("clearNotification", Context.class).invoke(null, context);
                } catch (Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                    com.igexin.c.a.c.a.a("AssistMangerFactory | cancelAllAssistNotification() err " + th.toString(), new Object[0]);
                }
                com.igexin.c.a.c.a.b(f9583a, " cancelAllAssistNotification() XM ");
            } else if (this.b.getBrandCode().equals("4")) {
                try {
                    Class.forName("com.meizu.cloud.pushsdk.PushManager").getDeclaredMethod("clearNotification", Context.class).invoke(null, context);
                } catch (Throwable th2) {
                    com.igexin.c.a.c.a.a(th2);
                    com.igexin.c.a.c.a.a("AssistMangerFactory | cancelAllAssistNotification() err " + th2.toString(), new Object[0]);
                }
                com.igexin.c.a.c.a.b(f9583a, " cancelAllAssistNotification() MZ ");
            }
        }
    }

    private static void c(Context context) {
        try {
            Class.forName("com.xiaomi.mipush.sdk.MiPushClient").getDeclaredMethod("clearNotification", Context.class).invoke(null, context);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a("AssistMangerFactory | cancelAllAssistNotification() err " + th.toString(), new Object[0]);
        }
        com.igexin.c.a.c.a.b(f9583a, " cancelAllAssistNotification() XM ");
    }

    private static void d() {
        String[] strArr = e;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            String str = strArr[i2];
            try {
                Class.forName(str);
                d a2 = d.a();
                a2.a("UnSupport plugin [" + str + "]. Please change plugin to 3.0.");
                return;
            } catch (Throwable th) {
                th.getMessage();
                i = i2 + 1;
            }
        }
    }

    private static void d(Context context) {
        try {
            Class.forName("com.meizu.cloud.pushsdk.PushManager").getDeclaredMethod("clearNotification", Context.class).invoke(null, context);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a("AssistMangerFactory | cancelAllAssistNotification() err " + th.toString(), new Object[0]);
        }
        com.igexin.c.a.c.a.b(f9583a, " cancelAllAssistNotification() MZ ");
    }

    private String e() {
        AbstractPushManager abstractPushManager = this.b;
        return abstractPushManager == null ? "" : abstractPushManager.getBrandCode();
    }

    private String f() {
        Object invoke;
        AbstractPushManager abstractPushManager = this.b;
        String str = "";
        if (abstractPushManager == null) {
            return "";
        }
        String name = abstractPushManager.getClass().getName();
        String str2 = str;
        String str3 = str;
        try {
            if (!name.contains("fcm")) {
                if (name.contains(AssistUtils.BRAND_XIAOMI)) {
                    Field declaredField = this.b.getClass().getDeclaredField("XIAOMI_VERSION");
                    boolean isAccessible = declaredField.isAccessible();
                    declaredField.setAccessible(true);
                    String str4 = (String) declaredField.get(this.b.getClass());
                    try {
                        declaredField.setAccessible(isAccessible);
                        return str4;
                    } catch (Throwable th) {
                        str2 = str4;
                        th = th;
                        com.igexin.c.a.c.a.a(th);
                        str3 = str2;
                        return str3;
                    }
                } else if (name.contains(AssistUtils.BRAND_HW)) {
                    return ((String) n.b(e.l).metaData.get("com.huawei.hms.client.service.name:push")).split(":")[1];
                } else {
                    int i = 0;
                    if (name.contains(AssistUtils.BRAND_OPPO)) {
                        Class<?> cls = Class.forName("com.heytap.msp.push.HeytapPushManager");
                        invoke = cls.getDeclaredMethod("getSDKVersionName", new Class[0]).invoke(cls, new Object[0]);
                    } else if (name.contains(AssistUtils.BRAND_STP)) {
                        Class<?> cls2 = Class.forName("com.gtups.sdk.PushManager");
                        invoke = cls2.getDeclaredMethod("getVersion", Context.class).invoke(cls2.getDeclaredMethod("getInstance", new Class[0]).invoke(cls2, new Object[0]), e.l);
                    } else if (name.contains(AssistUtils.BRAND_VIVO)) {
                        ApplicationInfo b = n.b(e.l);
                        StringBuilder sb = new StringBuilder();
                        sb.append(b.metaData.getInt("sdk_version_vivo"));
                        return sb.toString();
                    } else {
                        str3 = str;
                        if (name.contains(AssistUtils.BRAND_MZ)) {
                            Field[] declaredFields = Class.forName("com.meizu.cloud.pushsdk.PushManager").getDeclaredFields();
                            int length = declaredFields.length;
                            while (true) {
                                str3 = str;
                                if (i >= length) {
                                    break;
                                }
                                Field field = declaredFields[i];
                                String str5 = str;
                                if (Modifier.isFinal(field.getModifiers())) {
                                    str5 = str;
                                    if ("TAG".equals(field.getName())) {
                                        String str6 = str;
                                        str5 = (String) field.get(null);
                                    }
                                }
                                i++;
                                str = str5;
                            }
                        }
                    }
                    return (String) invoke;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return str3;
    }

    public final AbstractPushManager a(Context context) {
        String lowerCase = AssistUtils.getDeviceBrand().toLowerCase();
        if (com.igexin.push.config.d.M.contains(lowerCase)) {
            com.igexin.c.a.c.a.a("AssistMangerFactory|getPushManager = null, setToken = false", new Object[0]);
            f.a().b("false");
            return null;
        }
        boolean z = true;
        try {
            this.b = (AbstractPushManager) Class.forName("com.igexin.assist.control." + lowerCase + ".ManufacturePushManager").getConstructor(Context.class).newInstance(context);
        } catch (Throwable th) {
            d.a().a(lowerCase + " PushManager = null " + th.toString());
        }
        if (this.b == null) {
            try {
                com.igexin.c.a.c.a.a("AssistMangerFactory|try init fcm push", new Object[0]);
                AbstractPushManager abstractPushManager = (AbstractPushManager) Class.forName(f9584c).getConstructor(Context.class).newInstance(context);
                this.b = abstractPushManager;
                if (!abstractPushManager.isSupport()) {
                    this.b = null;
                }
            } catch (Throwable th2) {
                d.a().a(lowerCase + " Fcm PushManager = null");
                StringBuilder sb = new StringBuilder("|Fcm ManufacturePushManager = null ");
                sb.append(th2.toString());
                com.igexin.c.a.c.a.b(f9583a, sb.toString());
                if (!e.J) {
                    f.a().b("false");
                }
                if (th2 instanceof ClassNotFoundException) {
                    d();
                }
            }
        }
        if (this.b == null && !e.J) {
            f.a().b("false");
        }
        StringBuilder sb2 = new StringBuilder("AssistMangerFactory|ManufacturePushManager is null = ");
        if (this.b != null) {
            z = false;
        }
        sb2.append(z);
        com.igexin.c.a.c.a.a(sb2.toString(), new Object[0]);
        return this.b;
    }

    public final String[] b() {
        String str;
        Throwable th;
        String f;
        AbstractPushManager abstractPushManager = this.b;
        if (abstractPushManager == null) {
            return new String[]{"", ""};
        }
        try {
            Field declaredField = abstractPushManager.getClass().getDeclaredField("PLUGIN_VERSION");
            boolean isAccessible = declaredField.isAccessible();
            declaredField.setAccessible(true);
            str = (String) declaredField.get(this.b.getClass());
            try {
                declaredField.setAccessible(isAccessible);
            } catch (Throwable th2) {
                th = th2;
                com.igexin.c.a.c.a.a(th);
                f = (String) this.b.getClass().getDeclaredMethod("getBrandSdkVersion", new Class[0]).invoke(this.b, new Object[0]);
                return new String[]{str, f};
            }
        } catch (Throwable th3) {
            str = "";
            th = th3;
        }
        try {
            f = (String) this.b.getClass().getDeclaredMethod("getBrandSdkVersion", new Class[0]).invoke(this.b, new Object[0]);
        } catch (Throwable th4) {
            com.igexin.c.a.c.a.a(f9583a, th4.getMessage());
            f = f();
        }
        return new String[]{str, f};
    }

    public final boolean c() {
        AbstractPushManager abstractPushManager;
        if (com.igexin.push.config.d.M.contains(AssistUtils.getDeviceBrand().toLowerCase()) || (abstractPushManager = this.b) == null) {
            return false;
        }
        return abstractPushManager.isSupport();
    }
}
