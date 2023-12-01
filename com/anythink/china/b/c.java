package com.anythink.china.b;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.internal.telephony.PhoneConstants;
import com.anythink.china.api.ChinaDeviceDataInfo;
import com.anythink.core.common.b.n;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/b/c.class */
public final class c {
    public static String a(Context context) {
        if (n.a().c(ChinaDeviceDataInfo.IMEI)) {
            return "";
        }
        try {
            return Build.VERSION.SDK_INT < 23 ? b(context) : Build.VERSION.SDK_INT < 26 ? a(c(context)) : a(d(context));
        } catch (Throwable th) {
            return "";
        }
    }

    private static String a(Map map) {
        return map != null ? (String) map.get("imei1") : "";
    }

    private static String b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PhoneConstants.PHONE_KEY);
        if (telephonyManager != null) {
            try {
                return telephonyManager.getDeviceId();
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }

    private static Map c(Context context) {
        HashMap hashMap = new HashMap();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PhoneConstants.PHONE_KEY);
        Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class);
        String str = (String) method.invoke(null, "ril.gsm.imei", "");
        hashMap.put("meid", (String) method.invoke(null, "ril.cdma.meid", ""));
        if (TextUtils.isEmpty(str)) {
            try {
                hashMap.put("imei1", telephonyManager.getDeviceId(0));
                hashMap.put("imei2", telephonyManager.getDeviceId(1));
                return hashMap;
            } catch (Throwable th) {
                return hashMap;
            }
        }
        String[] split = str.split(",");
        if (split == null || split.length <= 0) {
            hashMap.put("imei1", telephonyManager.getDeviceId(0));
            hashMap.put("imei2", telephonyManager.getDeviceId(1));
            return hashMap;
        }
        hashMap.put("imei1", split[0]);
        if (split.length > 1) {
            hashMap.put("imei2", split[1]);
            return hashMap;
        }
        hashMap.put("imei2", telephonyManager.getDeviceId(1));
        return hashMap;
    }

    private static Map d(Context context) {
        HashMap hashMap = new HashMap();
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PhoneConstants.PHONE_KEY);
            String imei = telephonyManager.getImei(0);
            String imei2 = telephonyManager.getImei(1);
            if (TextUtils.isEmpty(imei) && TextUtils.isEmpty(imei2)) {
                hashMap.put("imei1", telephonyManager.getMeid());
                return hashMap;
            }
            hashMap.put("imei1", imei);
            hashMap.put("imei2", imei2);
            return hashMap;
        } catch (Throwable th) {
            return hashMap;
        }
    }
}
