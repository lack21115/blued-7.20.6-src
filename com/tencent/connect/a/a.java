package com.tencent.connect.a;

import android.content.Context;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.utils.OpenConfig;
import java.lang.reflect.Method;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/connect/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Class<?> f36137a;
    private static Class<?> b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f36138c;
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
                f.invoke(f36137a, true);
            } else {
                f.invoke(f36137a, false);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void c(Context context, QQToken qQToken) {
        String str = "Aqc" + qQToken.getAppId();
        try {
            f36137a = Class.forName("com.tencent.stat.StatConfig");
            Class<?> cls = Class.forName("com.tencent.stat.StatService");
            b = cls;
            f36138c = cls.getMethod("reportQQ", Context.class, String.class);
            d = b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
            e = b.getMethod("commitEvents", Context.class, Integer.TYPE);
            f = f36137a.getMethod("setEnableStatService", Boolean.TYPE);
            b(context, qQToken);
            f36137a.getMethod("setAutoExceptionCaught", Boolean.TYPE).invoke(f36137a, false);
            f36137a.getMethod("setEnableSmartReporting", Boolean.TYPE).invoke(f36137a, true);
            f36137a.getMethod("setSendPeriodMinutes", Integer.TYPE).invoke(f36137a, 1440);
            Class<?> cls2 = Class.forName("com.tencent.stat.StatReportStrategy");
            f36137a.getMethod("setStatSendStrategy", cls2).invoke(f36137a, cls2.getField("PERIOD").get(null));
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
                    f36138c.invoke(b, context, qQToken.getOpenId());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
