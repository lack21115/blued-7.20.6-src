package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.igexin.assist.util.AssistUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/ax.class */
public class ax {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40640a = "ro.build.version.emui";
    private static final String b = "hw_sc.build.platform.version";

    public static au a(Context context) {
        String str = Build.BRAND;
        bg.a("Device", "Brand", str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase(AssistUtils.BRAND_HW) || str.equalsIgnoreCase(AssistUtils.BRAND_HON) || str.equalsIgnoreCase("华为")) {
            return new ay();
        }
        if (str.equalsIgnoreCase(AssistUtils.BRAND_XIAOMI) || str.equalsIgnoreCase("redmi") || str.equalsIgnoreCase("meitu") || str.equalsIgnoreCase("小米") || str.equalsIgnoreCase("blackshark")) {
            return new bf();
        }
        if (str.equalsIgnoreCase(AssistUtils.BRAND_VIVO)) {
            return new be();
        }
        if (str.equalsIgnoreCase(AssistUtils.BRAND_OPPO) || str.equalsIgnoreCase("oneplus") || str.equalsIgnoreCase("realme")) {
            return new bc();
        }
        if (str.equalsIgnoreCase("lenovo") || str.equalsIgnoreCase("zuk")) {
            return new az();
        }
        if (str.equalsIgnoreCase("nubia")) {
            return new bb();
        }
        if (str.equalsIgnoreCase("samsung")) {
            return new bd();
        }
        if (a()) {
            return new ay();
        }
        if (str.equalsIgnoreCase(AssistUtils.BRAND_MZ) || str.equalsIgnoreCase("mblu") || c()) {
            return new ba();
        }
        if (b()) {
            return new aw();
        }
        return null;
    }

    private static String a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, str);
        } catch (Throwable th) {
            return "";
        }
    }

    private static boolean a() {
        return (TextUtils.isEmpty(a(f40640a)) && TextUtils.isEmpty(a(b))) ? false : true;
    }

    private static boolean b() {
        return !TextUtils.isEmpty(a("ro.coolos.version"));
    }

    private static boolean c() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return !TextUtils.isEmpty((String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, "ro.build.flyme.version", ""));
        } catch (Exception e) {
            return false;
        }
    }
}
