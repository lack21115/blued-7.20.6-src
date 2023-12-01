package com.tencent.connect.a;

import android.content.Context;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.utils.OpenConfig;
import java.lang.reflect.Method;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/connect/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Class<?> f22446a;
    private static Class<?> b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f22447c;
    private static Method d;
    private static Method e;
    private static Method f;
    private static boolean g = false;

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        if (g) {
            b(context, qQToken);
            try {
                d.invoke(b, context, str, strArr);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean a(Context context, QQToken qQToken) {
        return OpenConfig.getInstance(context, qQToken.getAppId()).getBoolean("Common_ta_enable");
    }

    public static void b(Context context, QQToken qQToken) {
        try {
            if (a(context, qQToken)) {
                f.invoke(f22446a, true);
            } else {
                f.invoke(f22446a, false);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void c(Context context, QQToken qQToken) {
        String str = "Aqc" + qQToken.getAppId();
        try {
            f22446a = Class.forName("com.tencent.stat.StatConfig");
            Class<?> cls = Class.forName("com.tencent.stat.StatService");
            b = cls;
            f22447c = cls.getMethod("reportQQ", Context.class, String.class);
            d = b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
            e = b.getMethod("commitEvents", Context.class, Integer.TYPE);
            f = f22446a.getMethod("setEnableStatService", Boolean.TYPE);
            b(context, qQToken);
            f22446a.getMethod("setAutoExceptionCaught", Boolean.TYPE).invoke(f22446a, false);
            f22446a.getMethod("setEnableSmartReporting", Boolean.TYPE).invoke(f22446a, true);
            f22446a.getMethod("setSendPeriodMinutes", Integer.TYPE).invoke(f22446a, 1440);
            Class<?> cls2 = Class.forName("com.tencent.stat.StatReportStrategy");
            f22446a.getMethod("setStatSendStrategy", cls2).invoke(f22446a, cls2.getField("PERIOD").get(null));
            b.getMethod("startStatService", Context.class, String.class, String.class).invoke(b, context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
            g = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void d(Context context, QQToken qQToken) {
        if (g) {
            b(context, qQToken);
            if (qQToken.getOpenId() != null) {
                try {
                    f22447c.invoke(b, context, qQToken.getOpenId());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
