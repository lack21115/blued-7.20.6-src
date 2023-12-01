package com.alibaba.mtl.log.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.alibaba.mtl.log.model.LogField;
import com.android.internal.telephony.PhoneConstants;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/d.class */
public class d {
    private static Map<String, String> t;

    /* JADX WARN: Can't wrap try/catch for region: R(10:27|28|(10:30|31|32|(1:34)|35|36|37|38|39|40)|45|35|36|37|38|39|40) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x01a8, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x01a9, code lost:
        android.util.Log.e("DeviceUtil", "utdid4all jar doesn't exist, please copy the libs folder.");
        r5.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.String, java.lang.String> a(android.content.Context r4) {
        /*
            Method dump skipped, instructions count: 494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.e.d.a(android.content.Context):java.util.Map");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0048 -> B:27:0x0066). Please submit an issue!!! */
    private static void a(Map<String, String> map, Context context) {
        try {
            String[] networkState = l.getNetworkState(context);
            map.put(LogField.ACCESS.toString(), networkState[0]);
            if (networkState[0].equals("2G/3G")) {
                map.put(LogField.ACCESS_SUBTYPE.toString(), networkState[1]);
            } else {
                map.put(LogField.ACCESS_SUBTYPE.toString(), "Unknown");
            }
        } catch (Exception e) {
            map.put(LogField.ACCESS.toString(), "Unknown");
            map.put(LogField.ACCESS_SUBTYPE.toString(), "Unknown");
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PhoneConstants.PHONE_KEY);
            String str = "";
            if (telephonyManager != null) {
                str = "";
                if (telephonyManager.getSimState() == 5) {
                    str = telephonyManager.getNetworkOperatorName();
                }
            }
            if (TextUtils.isEmpty(str)) {
                str = "Unknown";
            }
            map.put(LogField.CARRIER.toString(), str);
        } catch (Exception e2) {
        }
    }

    private static String b(Context context) {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Throwable th) {
            return "Unknown";
        }
    }

    private static String c(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            int i3 = i;
            int i4 = i2;
            if (i > i2) {
                int i5 = i ^ i2;
                i4 = i2 ^ i5;
                i3 = i5 ^ i4;
            }
            return i4 + PhoneConstants.APN_TYPE_ALL + i3;
        } catch (Exception e) {
            return "Unknown";
        }
    }

    public static String c(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls.newInstance(), str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String d(Context context) {
        String appVersion = com.alibaba.mtl.log.b.a().getAppVersion();
        if (TextUtils.isEmpty(appVersion)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                String str = "Unknown";
                if (packageInfo != null) {
                    t.put(LogField.APPVERSION.toString(), packageInfo.versionName);
                    str = packageInfo.versionName;
                }
                return str;
            } catch (Throwable th) {
                return "Unknown";
            }
        }
        return appVersion;
    }

    public static boolean k() {
        if ((System.getProperty("java.vm.name") == null || !System.getProperty("java.vm.name").toLowerCase().contains("lemur")) && System.getProperty("ro.yunos.version") == null && TextUtils.isEmpty(q.get("ro.yunos.build.version"))) {
            return l();
        }
        return true;
    }

    private static boolean l() {
        return (TextUtils.isEmpty(c("ro.yunos.product.chip")) && TextUtils.isEmpty(c("ro.yunos.hardware"))) ? false : true;
    }

    private static String o() {
        String str = Build.VERSION.RELEASE;
        if (k()) {
            System.getProperty("ro.yunos.version");
            String s = s();
            str = s;
            if (!TextUtils.isEmpty(s)) {
            }
        }
        return str;
    }

    private static String p() {
        return (!k() || l()) ? "a" : "y";
    }

    public static String q() {
        String str = q.get("ro.aliyun.clouduuid", "false");
        String str2 = str;
        if ("false".equals(str)) {
            str2 = q.get("ro.sys.aliyun.clouduuid", "false");
        }
        return TextUtils.isEmpty(str2) ? r() : str2;
    }

    private static String r() {
        try {
            return (String) Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }

    private static String s() {
        try {
            Field declaredField = Build.class.getDeclaredField("YUNOS_BUILD_VERSION");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                return (String) declaredField.get(new String());
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
