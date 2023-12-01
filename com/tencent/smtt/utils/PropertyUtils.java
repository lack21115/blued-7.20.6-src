package com.tencent.smtt.utils;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Method;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/PropertyUtils.class */
public class PropertyUtils {

    /* renamed from: a  reason: collision with root package name */
    private static Class f38926a;
    private static Method b;

    static {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            f38926a = cls;
            b = cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static String a(String str, String str2) {
        Class cls = f38926a;
        if (cls != null) {
            Method method = b;
            if (method == null) {
                return str2;
            }
            try {
                return (String) method.invoke(cls, str, str2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return str2;
    }

    public static String getQuickly(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : a(str, str2);
    }
}
