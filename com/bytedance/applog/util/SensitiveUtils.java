package com.bytedance.applog.util;

import android.Manifest;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Process;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.applog.ISensitiveInfoProvider;
import com.bytedance.applog.Level;
import com.bytedance.bdtracker.a;
import com.bytedance.bdtracker.e2;
import com.bytedance.bdtracker.j1;
import com.bytedance.bdtracker.q1;
import com.bytedance.bdtracker.r1;
import com.bytedance.bdtracker.z2;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/util/SensitiveUtils.class */
public class SensitiveUtils {
    public static final String CHANNEL_APP_KEY = "UMENG_APPKEY";
    public static final String KEY_ALIYUN_UUID = "aliyun_uuid";
    public static final String KEY_BUILD_SERIAL = "build_serial";
    public static final String KEY_MAC = "mac_address";
    public static final String KEY_MC = "mc";

    public static /* synthetic */ String a() {
        if (Build.VERSION.SDK_INT >= 23) {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if ("wlan0".equals(nextElement.getName())) {
                    StringBuilder a2 = a.a("[DeviceMeta] Try to get hardware address from ");
                    a2.append(nextElement.getName());
                    a2.append(".");
                    z2.a(a2.toString());
                    byte[] hardwareAddress = nextElement.getHardwareAddress();
                    if (hardwareAddress != null && hardwareAddress.length > 0) {
                        StringBuilder sb = new StringBuilder();
                        int length = hardwareAddress.length;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= length) {
                                break;
                            }
                            sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i2])));
                            i = i2 + 1;
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        return sb.toString();
                    }
                }
            }
            return "";
        }
        return "";
    }

    public static /* synthetic */ String a(Context context) {
        if (hasReadPhoneStatePermission(context)) {
            z2.a("[DeviceMeta&READ_PHONE_STATE] Try to get device id.");
            try {
                return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            } catch (Throwable th) {
                z2.a(th);
                return null;
            }
        }
        return null;
    }

    public static String a(Context context, int i) {
        String str;
        String str2 = null;
        if (hasReadPhoneStatePermission(context)) {
            z2.a("[READ_PHONE_STATE] Try to get device id.");
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                str = null;
                if (Build.VERSION.SDK_INT >= 21) {
                    Method method = telephonyManager.getClass().getMethod("getDeviceId", a("getDeviceId"));
                    str = null;
                    if (i >= 0) {
                        str = method.invoke(telephonyManager, Integer.valueOf(i));
                    }
                }
            } catch (Throwable th) {
                z2.a("Read phone info failed.", th);
                str = null;
            }
            str2 = str;
        }
        return str2;
    }

    public static JSONObject a(String str, int i, String str2) {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("id", str);
            jSONObject.put("slot_index", i);
            jSONObject.put("type", str2);
        }
        return jSONObject;
    }

    public static Class[] a(String str) {
        Class<?>[] clsArr = null;
        Class<?>[] clsArr2 = null;
        try {
            Method[] declaredMethods = TelephonyManager.class.getDeclaredMethods();
            int length = declaredMethods.length;
            int i = 0;
            while (true) {
                clsArr2 = clsArr;
                if (i >= length) {
                    break;
                }
                Method method = declaredMethods[i];
                Class<?>[] clsArr3 = clsArr;
                if (str.equals(method.getName())) {
                    Class<?>[] clsArr4 = clsArr;
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    clsArr3 = parameterTypes;
                    if (parameterTypes.length >= 1) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("params length:");
                        sb.append(parameterTypes.length);
                        clsArr2 = parameterTypes;
                        z2.a(sb.toString());
                        return parameterTypes;
                    }
                }
                i++;
                clsArr = clsArr3;
            }
        } catch (Exception e) {
            z2.a(e);
        }
        return clsArr2;
    }

    public static void addSensitiveParamsForUrlQuery(r1 r1Var, StringBuilder sb, JSONObject jSONObject) {
        q1.a(sb, KEY_BUILD_SERIAL, (String) r1Var.a(jSONObject, KEY_BUILD_SERIAL, (String) null, String.class));
        JSONArray jSONArray = (JSONArray) r1Var.a(jSONObject, "sim_serial_number", (String) null, JSONArray.class);
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        try {
            StringBuilder sb2 = new StringBuilder(((JSONObject) jSONArray.get(0)).optString("sim_serial_number"));
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    q1.a(sb, "sim_serial_number", sb2.toString());
                    return;
                }
                String optString = ((JSONObject) jSONArray.get(i2)).optString("sim_serial_number");
                sb2.append(",");
                sb2.append(optString);
                i = i2 + 1;
            }
        } catch (JSONException e) {
            z2.a("failed to get sim_serial_number", e);
        }
    }

    public static void appendSensitiveParams(r1 r1Var, JSONObject jSONObject, Map<String, String> map, boolean z, Level level) {
        if (level == Level.L0) {
            if (z) {
                String str = (String) r1Var.a(jSONObject, "mc", (String) null, String.class);
                String str2 = (String) r1Var.a(jSONObject, "udid", (String) null, String.class);
                if (!TextUtils.isEmpty(str)) {
                    map.put(KEY_MAC, str);
                }
                if (j1.a(str2)) {
                    map.put("uuid", str2);
                }
            }
            String str3 = (String) r1Var.a(jSONObject, KEY_ALIYUN_UUID, (String) null, String.class);
            if (!TextUtils.isEmpty(str3)) {
                map.put(KEY_ALIYUN_UUID, str3);
            }
        }
        String str4 = (String) r1Var.a(jSONObject, KEY_BUILD_SERIAL, (String) null, String.class);
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        map.put(KEY_BUILD_SERIAL, str4);
    }

    public static /* synthetic */ String b(Context context) {
        if (Build.VERSION.SDK_INT < 26 || !hasReadPhoneStatePermission(context)) {
            return null;
        }
        z2.a("[DeviceMeta&READ_PHONE_STATE] Try to get imei and meid info.");
        int activeSubscriptionInfoCount = SubscriptionManager.from(context).getActiveSubscriptionInfoCount();
        JSONArray jSONArray = new JSONArray();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= activeSubscriptionInfoCount) {
                return jSONArray.toString();
            }
            try {
                jSONArray.put(a(telephonyManager.getMeid(i2), i2, "meid"));
            } catch (Throwable th) {
            }
            try {
                jSONArray.put(a(telephonyManager.getImei(i2), i2, "imei"));
            } catch (Throwable th2) {
            }
            i = i2 + 1;
        }
    }

    public static /* synthetic */ String c(Context context) {
        if (Build.VERSION.SDK_INT < 26 || context.getApplicationInfo().targetSdkVersion < 26 || !hasReadPhoneStatePermission(context)) {
            return "";
        }
        z2.a("[DeviceMeta&READ_PHONE_STATE] Try to get build serial.");
        return Build.getSerial();
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00d6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.String d(android.content.Context r5) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.applog.util.SensitiveUtils.d(android.content.Context):java.lang.String");
    }

    public static String getDeviceId(final Context context) {
        if (context == null) {
            return null;
        }
        try {
            return e2.a(context).a("TelephonyManager.getDeviceId", new e2.a() { // from class: com.bytedance.applog.util.-$$Lambda$0W9DJXDzCcbJfd_UpXeqtCm3EGQ
                @Override // com.bytedance.bdtracker.e2.a
                public final String a() {
                    return SensitiveUtils.a(Context.this);
                }
            });
        } catch (Throwable th) {
            z2.a(th);
            return null;
        }
    }

    public static String getMacAddress(ISensitiveInfoProvider iSensitiveInfoProvider, Context context) {
        return iSensitiveInfoProvider != null ? iSensitiveInfoProvider.getMac() : getMacAddressFromSystem(context);
    }

    public static String getMacAddressFromSystem(Context context) {
        String str;
        try {
            str = e2.a(context).a("NetworkInterface.getHardwareAddress", new e2.a() { // from class: com.bytedance.applog.util.-$$Lambda$aPptjFOAUrnQBeM4GuzScQhDMyI
                @Override // com.bytedance.bdtracker.e2.a
                public final String a() {
                    return SensitiveUtils.a();
                }
            });
        } catch (Throwable th) {
            z2.c("U SHALL NOT PASS!", th);
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            try {
                WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    return connectionInfo.getMacAddress();
                }
            } catch (SecurityException e) {
                z2.c("U SHALL NOT PASS!", e);
            }
        }
        return str;
    }

    public static JSONArray getMultiImeiFallback(Context context) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(a(a(context, 0), 0, "unknown"));
        jSONArray.put(a(a(context, 1), 1, "unknown"));
        return jSONArray;
    }

    public static JSONArray getMultiImeiFromSystem(final Context context) {
        try {
            String a2 = e2.a(context).a("TelephonyManager.getMultiImei", new e2.a() { // from class: com.bytedance.applog.util.-$$Lambda$A6D4BLypjotpXNBC9lY3LyFkPvo
                @Override // com.bytedance.bdtracker.e2.a
                public final String a() {
                    return SensitiveUtils.b(Context.this);
                }
            });
            return TextUtils.isEmpty(a2) ? new JSONArray() : new JSONArray(a2);
        } catch (Throwable th) {
            z2.a("Failed to get meid 0", th);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
        if (android.text.TextUtils.equals(r6, "unknown") != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getSerialNumber(final android.content.Context r6) {
        /*
            r0 = 0
            r7 = r0
            r0 = r6
            if (r0 != 0) goto L8
            r0 = 0
            return r0
        L8:
            r0 = r6
            com.bytedance.bdtracker.e2 r0 = com.bytedance.bdtracker.e2.a(r0)     // Catch: java.lang.Throwable -> L20
            r8 = r0
            r0 = r8
            java.lang.String r1 = "Build.getSerial"
            com.bytedance.applog.util.-$$Lambda$qayPZ-DZTvAf4VI2R5pVyLEF7SA r2 = new com.bytedance.applog.util.-$$Lambda$qayPZ-DZTvAf4VI2R5pVyLEF7SA     // Catch: java.lang.Throwable -> L20
            r3 = r2
            r4 = r6
            r3.<init>()     // Catch: java.lang.Throwable -> L20
            java.lang.String r0 = r0.a(r1, r2)     // Catch: java.lang.Throwable -> L20
            r6 = r0
            goto L2a
        L20:
            r6 = move-exception
            java.lang.String r0 = "U SHALL NOT PASS!"
            r1 = r6
            com.bytedance.bdtracker.z2.c(r0, r1)
            r0 = r7
            r6 = r0
        L2a:
            r0 = r6
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L3d
            r0 = r6
            r7 = r0
            r0 = r6
            java.lang.String r1 = "unknown"
            boolean r0 = android.text.TextUtils.equals(r0, r1)
            if (r0 == 0) goto L41
        L3d:
            java.lang.String r0 = android.os.Build.SERIAL
            r7 = r0
        L41:
            r0 = r7
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L57
            r0 = r7
            java.lang.String r1 = "unknown"
            boolean r0 = android.text.TextUtils.equals(r0, r1)
            if (r0 == 0) goto L55
            goto L57
        L55:
            r0 = r7
            return r0
        L57:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.applog.util.SensitiveUtils.getSerialNumber(android.content.Context):java.lang.String");
    }

    public static String[] getSimSerialNumbers(final Context context) {
        if (context == null) {
            return new String[0];
        }
        try {
            String a2 = e2.a(context).a("SubscriptionInfo.getIccid", new e2.a() { // from class: com.bytedance.applog.util.-$$Lambda$DTZTxKsPEK-Fj3TYyyKcPcuEmcw
                @Override // com.bytedance.bdtracker.e2.a
                public final String a() {
                    return SensitiveUtils.d(Context.this);
                }
            });
            if (!TextUtils.isEmpty(a2)) {
                return a2.split(",");
            }
        } catch (Throwable th) {
            z2.a(th);
        }
        return new String[0];
    }

    public static boolean hasPermission(Context context, String str) {
        boolean z = false;
        if (str == null) {
            return false;
        }
        try {
            if (context.checkPermission(str, Process.myPid(), Process.myUid()) == 0) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            z2.a("check has permission failed.", th);
            return false;
        }
    }

    public static boolean hasReadPhoneStatePermission(Context context) {
        return hasPermission(context, Build.VERSION.SDK_INT > 28 ? Manifest.permission.READ_PRECISE_PHONE_STATE : "android.permission.READ_PHONE_STATE");
    }

    public static boolean validMultiImei(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return validMultiImei(new JSONArray(str));
        } catch (JSONException e) {
            z2.a(e);
            return false;
        }
    }

    public static boolean validMultiImei(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) <= 0) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null && !TextUtils.isEmpty(optJSONObject.optString("id"))) {
                return true;
            }
            i = i2 + 1;
        }
    }
}
