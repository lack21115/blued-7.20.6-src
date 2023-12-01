package com.anythink.core.api;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.common.b.n;
import java.util.List;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/ATInitMediation.class */
public abstract class ATInitMediation {
    public static final String KEY_LOCAL = "anythink_local";

    public static boolean getBooleanFromMap(Map<String, Object> map, String str) {
        return getBooleanFromMap(map, str, false);
    }

    public static boolean getBooleanFromMap(Map<String, Object> map, String str, boolean z) {
        return ((Boolean) getValueFromMap(map, str, Boolean.valueOf(z))).booleanValue();
    }

    public static double getDoubleFromMap(Map<String, Object> map, String str) {
        return getDoubleFromMap(map, str, 0.0d);
    }

    public static double getDoubleFromMap(Map<String, Object> map, String str, double d) {
        return ((Double) getValueFromMap(map, str, Double.valueOf(d))).doubleValue();
    }

    public static int getIntFromMap(Map<String, Object> map, String str) {
        return getIntFromMap(map, str, 0);
    }

    public static int getIntFromMap(Map<String, Object> map, String str, int i) {
        return ((Integer) getValueFromMap(map, str, Integer.valueOf(i))).intValue();
    }

    public static long getLongFromMap(Map<String, Object> map, String str) {
        return getLongFromMap(map, str, 0L);
    }

    public static long getLongFromMap(Map<String, Object> map, String str, long j) {
        return ((Long) getValueFromMap(map, str, Long.valueOf(j))).longValue();
    }

    public static String getStringFromMap(Map<String, Object> map, String str) {
        return getStringFromMap(map, str, "");
    }

    public static String getStringFromMap(Map<String, Object> map, String str, String str2) {
        return (String) getValueFromMap(map, str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v33, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r0v36, types: [java.lang.Float] */
    /* JADX WARN: Type inference failed for: r0v39, types: [java.lang.Double] */
    /* JADX WARN: Type inference failed for: r0v42, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r0v45, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r6v0, types: [T, java.lang.Object] */
    private static <T> T getValueFromMap(Map<String, Object> map, String str, T t) {
        Object obj;
        try {
            if (TextUtils.isEmpty(str) || map == null) {
                return t;
            }
            if (map.size() > 0 && (obj = map.get(str)) != null) {
                String obj2 = obj.toString();
                if (!(t instanceof String)) {
                    obj2 = t instanceof Integer ? Integer.valueOf(Integer.parseInt(obj2)) : t instanceof Long ? Long.valueOf(Long.parseLong(obj2)) : t instanceof Double ? Double.valueOf(Double.parseDouble(obj2)) : t instanceof Float ? Float.valueOf(Float.parseFloat(obj2)) : t instanceof Boolean ? Boolean.valueOf(Boolean.parseBoolean(obj2)) : t;
                }
                if (ATSDK.isNetworkLogDebug()) {
                    Log.d("ATInitMediation", "key = " + str + "getValueFromMap() >>> result = " + ((Object) obj2) + " defaultValue = " + ((Object) t));
                }
                return (T) obj2;
            }
            return t;
        } catch (Exception e) {
            if (ATSDK.isNetworkLogDebug()) {
                Log.e("ATInitMediation", "getValueFromMap() >>> errorMsg = " + e.getMessage());
            }
            return t;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void checkToSaveInitData(String str, Map<String, Object> map, String... strArr) {
        n.a().a(str, map, strArr);
    }

    public List getActivityStatus() {
        return null;
    }

    public List getMetaValutStatus() {
        return null;
    }

    public String getNetworkName() {
        return "";
    }

    public String getNetworkSDKClass() {
        return "";
    }

    public String getNetworkVersion() {
        return "";
    }

    public List getPermissionStatus() {
        return null;
    }

    public Map<String, Boolean> getPluginClassStatus() {
        return null;
    }

    public List getProviderStatus() {
        return null;
    }

    public List getResourceStatus() {
        return null;
    }

    public List getServiceStatus() {
        return null;
    }

    public abstract void initSDK(Context context, Map<String, Object> map, MediationInitCallback mediationInitCallback);

    protected final void runOnMainThread(Runnable runnable) {
        n.a().a(runnable);
    }

    public final void runOnThreadPool(Runnable runnable) {
        n.a();
        n.b(runnable);
    }

    public boolean setUserDataConsent(Context context, boolean z, boolean z2) {
        return false;
    }
}
