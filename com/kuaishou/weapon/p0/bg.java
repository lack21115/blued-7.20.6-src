package com.kuaishou.weapon.p0;

import android.Manifest;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.LocaleList;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.google.android.material.timepicker.TimeModel;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/bg.class */
public class bg {
    public static String A(Context context) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 11) {
                break;
            }
            try {
                sb.append(g.a(context, new String[]{"android.permission.READ_PHONE_STATE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", Manifest.permission.READ_CONTACTS, Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO, "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", Manifest.permission.BLUETOOTH, Manifest.permission.WRITE_CALENDAR, Manifest.permission.READ_CALENDAR}[i2]) == 0 ? "1" : "0");
                i = i2 + 1;
            } catch (Exception e) {
            }
        }
        return sb.toString();
    }

    public static String B(Context context) {
        Iterator<String> keys;
        try {
            StringBuilder sb = new StringBuilder();
            JSONObject C = C(context);
            if (C == null || (keys = C.keys()) == null) {
                return "";
            }
            String str = "";
            while (keys.hasNext()) {
                String next = keys.next();
                String string = C.getString(next);
                sb.append(str);
                str = com.huawei.openalliance.ad.constant.t.aE;
                sb.append(next);
                sb.append("=");
                sb.append(string);
            }
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }

    private static JSONObject C(Context context) {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            String str2 = WeaponHI.sUserId;
            String l = l();
            String str3 = WeaponHI.sChannel;
            String k = k();
            String j = j();
            jSONObject.put(com.huawei.openalliance.ad.constant.ao.q, TextUtils.isEmpty(str2) ? "" : URLEncoder.encode(str2, "UTF-8"));
            jSONObject.put("platform", TextUtils.isEmpty(l) ? "" : URLEncoder.encode(l, "UTF-8"));
            jSONObject.put("channel", TextUtils.isEmpty(str3) ? "" : URLEncoder.encode(str3, "UTF-8"));
            try {
                if (h.a(context, "re_po_rt").e("a1_p_s_p_s")) {
                    jSONObject.put("mod", TextUtils.isEmpty(k) ? "" : URLEncoder.encode(k, "UTF-8"));
                    str = TextUtils.isEmpty(j) ? "" : URLEncoder.encode(j, "UTF-8");
                } else {
                    jSONObject.put("mod", "");
                    str = "";
                }
                jSONObject.put("sysver", str);
                return jSONObject;
            } catch (Exception e) {
                return jSONObject;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    public static double a() {
        double d = -1.0d;
        try {
            String c2 = c(com.kwad.sdk.d.b.Ax().getLocation());
            if (!TextUtils.isEmpty(c2)) {
                if (c2.startsWith("RISK")) {
                    return -1.0d;
                }
                d = new JSONObject(c2).getDouble("latitude");
            }
            return d;
        } catch (Throwable th) {
            return -1.0d;
        }
    }

    private static String a(AccessibilityServiceInfo accessibilityServiceInfo) {
        String id = accessibilityServiceInfo.getId();
        int lastIndexOf = id.lastIndexOf("/");
        String str = id;
        if (lastIndexOf > 0) {
            str = id.substring(0, lastIndexOf);
        }
        return str;
    }

    public static String a(Context context) {
        try {
            return c(com.kwad.sdk.d.b.Ax().Al());
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String a(Context context, int i) {
        try {
            return i == 1 ? c(com.kwad.sdk.d.b.Ax().Ao()) : c(com.kwad.sdk.d.b.Ax().Al());
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, str);
        } catch (Throwable th) {
            return null;
        }
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method b = b(cls, str, clsArr);
            try {
                b.setAccessible(true);
                return b;
            } catch (Throwable th) {
                return b;
            }
        } catch (Throwable th2) {
            return null;
        }
    }

    public static void a(final Context context, String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || h.a(context, "re_po_rt").c(de.bj, 1) == 0) {
            return;
        }
        try {
            JSONObject a2 = new cl(str, cj.j).a(context);
            if (map == null || map.size() <= 0) {
                a2.put("module_section", new JSONObject());
            } else {
                a2.put("module_section", new JSONObject(map));
            }
            final String jSONObject = a2.toString();
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.bg.1
                @Override // java.lang.Runnable
                public final void run() {
                    co.a(Context.this, jSONObject);
                }
            });
        } catch (Throwable th) {
        }
    }

    public static double b() {
        double d = -1.0d;
        try {
            String c2 = c(com.kwad.sdk.d.b.Ax().getLocation());
            if (!TextUtils.isEmpty(c2)) {
                if (c2.startsWith("RISK")) {
                    return -1.0d;
                }
                d = new JSONObject(c2).getDouble("longitude");
            }
            return d;
        } catch (Throwable th) {
            return -1.0d;
        }
    }

    public static int b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            return new JSONObject(str).getBoolean("userSet") ? 1 : 0;
        } catch (Throwable th) {
            return -2;
        }
    }

    public static String b(Context context) {
        try {
            return c(com.kwad.sdk.d.b.Ax().Al());
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String b(Context context, int i) {
        try {
            return i == 1 ? c(com.kwad.sdk.d.b.Ax().Ao()) : c(com.kwad.sdk.d.b.Ax().Al());
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            if (method != null) {
                return method;
            }
        } catch (Throwable th) {
        }
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (NoSuchMethodException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException();
    }

    public static String c() {
        try {
            String c2 = c(com.kwad.sdk.d.b.Ax().At());
            String str = c2;
            if (!TextUtils.isEmpty(c2)) {
                if (c2.startsWith("RISK")) {
                    return c2;
                }
                JSONObject jSONObject = new JSONObject(c2);
                str = jSONObject.getString("cellId") + ", " + jSONObject.getString("lac");
            }
            return str;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String c(Context context) {
        try {
            return c(com.kwad.sdk.d.b.Ax().Al());
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt(AccountManager.KEY_ERROR_CODE);
            return i == 0 ? jSONObject.getString("value") : i == 3 ? bh.f10141c : i == 1 ? bh.f10140a : bh.d;
        } catch (Throwable th) {
            return "";
        }
    }

    public static String d() {
        try {
            String c2 = c(com.kwad.sdk.d.b.Ax().Av());
            if (!TextUtils.isEmpty(c2)) {
                if (c2.startsWith("RISK")) {
                }
            }
            return c2;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String d(Context context) {
        try {
            return c(com.kwad.sdk.d.b.Ax().Aq());
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String e(Context context) {
        try {
            return c(com.kwad.sdk.d.b.Ax().getIccId());
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static JSONArray e() {
        try {
            String c2 = c(com.kwad.sdk.d.b.Ax().Au());
            if (TextUtils.isEmpty(c2) || c2.startsWith("RISK")) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray(c2);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray2.length()) {
                    return jSONArray;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("1", jSONArray2.getJSONObject(i2).getString("ssid"));
                jSONObject.put("2", jSONArray2.getJSONObject(i2).getString("bssid"));
                jSONArray.put(jSONObject);
                i = i2 + 1;
            }
        } catch (Throwable th) {
            return null;
        }
    }

    public static String f() {
        try {
            return c(com.kwad.sdk.d.b.Ax().getIp());
        } catch (Throwable th) {
            return bh.f10141c;
        }
    }

    public static String f(Context context) {
        try {
            return c(com.kwad.sdk.d.b.Ax().Am());
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String g() {
        try {
            return c(com.kwad.sdk.d.b.Ax().An());
        } catch (Throwable th) {
            return bh.f10141c;
        }
    }

    public static boolean g(Context context) {
        boolean z = false;
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            return false;
        }
    }

    public static String h() {
        try {
            Locale locale = Locale.getDefault();
            return locale.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + locale.getCountry();
        } catch (Throwable th) {
            return "";
        }
    }

    public static boolean h(Context context) {
        try {
            return Build.VERSION.SDK_INT > 16 ? Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0 : Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
        } catch (Throwable th) {
            return false;
        }
    }

    public static String i() {
        Locale locale = Build.VERSION.SDK_INT >= 24 ? LocaleList.getDefault().get(0) : Locale.getDefault();
        return locale.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + locale.getCountry();
    }

    public static String i(Context context) {
        try {
            List<InputMethodInfo> inputMethodList = ((InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE)).getInputMethodList();
            StringBuilder sb = new StringBuilder();
            for (InputMethodInfo inputMethodInfo : inputMethodList) {
                sb.append(inputMethodInfo.getId());
                sb.append(com.huawei.openalliance.ad.constant.t.aE);
            }
            if (TextUtils.isEmpty(sb)) {
                return bh.f10141c;
            }
            String sb2 = sb.toString();
            String str = sb2;
            if (sb2.endsWith(com.huawei.openalliance.ad.constant.t.aE)) {
                str = sb2.substring(0, sb2.length() - 1);
            }
            return str;
        } catch (Exception e) {
            return bh.d;
        }
    }

    public static String j() {
        return "ANDROID_" + Build.VERSION.RELEASE;
    }

    public static String j(Context context) {
        String str = "";
        int i = -1;
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                String string = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.DEFAULT_INPUT_METHOD);
                String str2 = string;
                if (string == null) {
                    str2 = com.igexin.push.core.b.l;
                }
                String str3 = "1=" + str2 + com.huawei.openalliance.ad.constant.t.aE;
                InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                str = str3;
                if (inputMethodManager != null) {
                    List<InputMethodInfo> enabledInputMethodList = inputMethodManager.getEnabledInputMethodList();
                    str = str3;
                    if (enabledInputMethodList != null) {
                        String str4 = str3 + "2=";
                        Iterator<InputMethodInfo> it = enabledInputMethodList.iterator();
                        while (true) {
                            str = str4;
                            if (!it.hasNext()) {
                                break;
                            }
                            InputMethodInfo next = it.next();
                            String packageName = next.getPackageName();
                            String str5 = packageName;
                            if (packageName == null) {
                                str5 = com.igexin.push.core.b.l;
                            }
                            String settingsActivity = next.getSettingsActivity();
                            String str6 = settingsActivity;
                            if (settingsActivity == null) {
                                str6 = com.igexin.push.core.b.l;
                            }
                            int i2 = i;
                            if (packageManager != null) {
                                i2 = i;
                                try {
                                    if (!str5.equals(com.igexin.push.core.b.l)) {
                                        i2 = i;
                                        if (!str6.equals(com.igexin.push.core.b.l)) {
                                            ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(str5, str6), 0);
                                            i2 = i;
                                            if (activityInfo != null) {
                                                i2 = activityInfo.launchMode;
                                            }
                                        }
                                    }
                                } catch (Exception e) {
                                    i2 = i;
                                }
                            }
                            str4 = str4 + str5 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i2)) + com.huawei.openalliance.ad.constant.t.aE;
                            i = i2;
                        }
                    }
                }
            } catch (Throwable th) {
                return "";
            }
        }
        return str;
    }

    public static String k() {
        return Build.MANUFACTURER + "(" + Build.MODEL + ")";
    }

    public static String k(Context context) {
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.ACCESSIBILITY_ENABLED, 0) != 1) {
                return bh.e;
            }
            String string = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
            String str = string;
            if (TextUtils.isEmpty(string)) {
                str = bh.f10141c;
            }
            return str;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    private static String l() {
        return "ANDROID_PHONE";
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String l(android.content.Context r4) {
        /*
            r0 = r4
            java.lang.String r1 = "accessibility"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.accessibility.AccessibilityManager r0 = (android.view.accessibility.AccessibilityManager) r0
            r4 = r0
            r0 = r4
            if (r0 != 0) goto L11
            r0 = 0
            return r0
        L11:
            r0 = r4
            java.util.List r0 = r0.getInstalledAccessibilityServiceList()     // Catch: java.lang.Exception -> L88
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L69
            r0 = r4
            int r0 = r0.size()     // Catch: java.lang.Exception -> L88
            if (r0 <= 0) goto L69
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L88
            r1 = r0
            r1.<init>()     // Catch: java.lang.Exception -> L88
            r5 = r0
            r0 = r4
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> L8c
            r6 = r0
        L32:
            r0 = r5
            r4 = r0
            r0 = r6
            boolean r0 = r0.hasNext()     // Catch: java.lang.Exception -> L8c
            if (r0 == 0) goto L6b
            r0 = r6
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Exception -> L8c
            android.accessibilityservice.AccessibilityServiceInfo r0 = (android.accessibilityservice.AccessibilityServiceInfo) r0     // Catch: java.lang.Exception -> L8c
            java.lang.String r0 = a(r0)     // Catch: java.lang.Exception -> L8c
            r4 = r0
            r0 = r5
            r1 = r4
            int r0 = r0.indexOf(r1)     // Catch: java.lang.Exception -> L8c
            r1 = -1
            if (r0 != r1) goto L32
            r0 = r5
            r1 = r4
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L8c
            r0 = r5
            java.lang.String r1 = "|"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L8c
            goto L32
        L64:
            r0 = r5
            r4 = r0
            goto L6b
        L69:
            r0 = 0
            r4 = r0
        L6b:
            r0 = r4
            if (r0 != 0) goto L71
            r0 = 0
            return r0
        L71:
            r0 = r4
            int r0 = r0.length()
            if (r0 <= 0) goto L83
            r0 = r4
            r1 = r4
            int r1 = r1.length()
            r2 = 1
            int r1 = r1 - r2
            java.lang.StringBuilder r0 = r0.deleteCharAt(r1)
        L83:
            r0 = r4
            java.lang.String r0 = r0.toString()
            return r0
        L88:
            r4 = move-exception
            goto L69
        L8c:
            r4 = move-exception
            goto L64
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.bg.l(android.content.Context):java.lang.String");
    }

    public static String m(Context context) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService(Context.ACCESSIBILITY_SERVICE);
        StringBuilder sb4 = null;
        if (accessibilityManager == null) {
            return null;
        }
        try {
            if (!accessibilityManager.isEnabled() || (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(-1)) == null || enabledAccessibilityServiceList.size() <= 0) {
                sb2 = null;
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb3 = sb5;
                try {
                    Iterator<AccessibilityServiceInfo> it = enabledAccessibilityServiceList.iterator();
                    while (true) {
                        sb2 = sb5;
                        if (!it.hasNext()) {
                            break;
                        }
                        String a2 = a(it.next());
                        if (sb5.indexOf(a2) == -1) {
                            sb5.append(a2);
                            sb5.append("|");
                        }
                    }
                } catch (Exception e) {
                    sb4 = sb3;
                    sb = sb4;
                    return sb.toString();
                }
            }
        } catch (Exception e2) {
        }
        if (sb2 == null) {
            return null;
        }
        sb = sb2;
        if (sb2.length() > 0) {
            sb = sb2;
            if (sb2.charAt(sb2.length() - 1) == '|') {
                sb3 = sb2;
                sb2.deleteCharAt(sb2.length() - 1);
                sb = sb2;
            }
        }
        return sb.toString();
    }

    public static String n(Context context) {
        return bh.d;
    }

    public static String o(Context context) {
        return bh.f10141c;
    }

    public static String p(Context context) {
        return bh.f10140a;
    }

    public static String q(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable th) {
            return "";
        }
    }

    public static String r(Context context) {
        try {
            return (String) context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(context.getPackageManager());
        } catch (Throwable th) {
            return "";
        }
    }

    public static String s(Context context) {
        try {
            return context.getPackageName();
        } catch (Throwable th) {
            return "";
        }
    }

    public static String t(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.name;
        } catch (Throwable th) {
            return "";
        }
    }

    public static int u(Context context) {
        try {
            String c2 = c(com.kwad.sdk.d.b.Ax().Ar());
            if (!TextUtils.isEmpty(c2) && !c2.startsWith("RISK")) {
                return Integer.parseInt(c2);
            }
            return -1;
        } catch (Throwable th) {
            return -2;
        }
    }

    public static int v(Context context) {
        try {
            String c2 = c(com.kwad.sdk.d.b.Ax().As());
            if (!TextUtils.isEmpty(c2) && !c2.startsWith("RISK")) {
                return Integer.parseInt(c2);
            }
            return -1;
        } catch (Throwable th) {
            return -2;
        }
    }

    public static String w(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            StringBuilder sb = new StringBuilder();
            sb.append(packageInfo.firstInstallTime);
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }

    public static String x(Context context) {
        return bh.f10141c;
    }

    public static String y(Context context) {
        try {
            return c(com.kwad.sdk.d.b.Ax().getOaid());
        } catch (Throwable th) {
            return "";
        }
    }

    public static String z(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            PackageManager packageManager = context.getPackageManager();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 27) {
                    break;
                }
                sb.append(packageManager.hasSystemFeature(new String[]{PackageManager.FEATURE_CAMERA, PackageManager.FEATURE_CAMERA_AUTOFOCUS, PackageManager.FEATURE_CAMERA_FLASH, PackageManager.FEATURE_LOCATION, PackageManager.FEATURE_LOCATION_GPS, PackageManager.FEATURE_LOCATION_NETWORK, PackageManager.FEATURE_MICROPHONE, PackageManager.FEATURE_SENSOR_COMPASS, PackageManager.FEATURE_SENSOR_ACCELEROMETER, PackageManager.FEATURE_SENSOR_LIGHT, PackageManager.FEATURE_SENSOR_PROXIMITY, PackageManager.FEATURE_TELEPHONY, PackageManager.FEATURE_TELEPHONY_CDMA, PackageManager.FEATURE_TELEPHONY_GSM, PackageManager.FEATURE_TOUCHSCREEN, PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH, PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH_DISTINCT, PackageManager.FEATURE_CAMERA_FRONT, PackageManager.FEATURE_WIFI, PackageManager.FEATURE_BLUETOOTH, PackageManager.FEATURE_NFC, PackageManager.FEATURE_FINGERPRINT, "android.hardware.biometrics.face", PackageManager.FEATURE_SCREEN_PORTRAIT, PackageManager.FEATURE_SCREEN_LANDSCAPE, PackageManager.FEATURE_FAKETOUCH, PackageManager.FEATURE_AUDIO_OUTPUT}[i2]) ? "1" : "0");
                i = i2 + 1;
            }
        } catch (Exception e) {
        }
        return sb.toString();
    }
}
