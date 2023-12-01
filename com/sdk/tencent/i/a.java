package com.sdk.tencent.i;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.sdk.tencent.f.c;
import com.sdk.tencent.n.b;
import java.lang.reflect.Method;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/i/a.class */
public class a {
    private static final String TAG = "a";
    private static final boolean isDebug = c.b;

    public static Object invokeOnSubscriptionManager(Context context, String str, Boolean bool, Class<?>[] clsArr, Object[] objArr) {
        try {
            Class<?> cls = Class.forName("android.telephony.SubscriptionManager");
            Object newInstance = cls.getConstructor(Class.forName("android.content.Context")).newInstance(context);
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return bool.booleanValue() ? declaredMethod.invoke(null, objArr) : declaredMethod.invoke(newInstance, objArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static Object invokeOnTelephonyManager(Context context, String str, Boolean bool, Class<?>[] clsArr, Object[] objArr) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            Method declaredMethod = Class.forName(telephonyManager.getClass().getName()).getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return bool.booleanValue() ? declaredMethod.invoke(null, objArr) : declaredMethod.invoke(telephonyManager, objArr);
        } catch (Exception e) {
            b.a(TAG, e.getMessage(), Boolean.valueOf(isDebug));
            return null;
        }
    }

    public static void logError(String str, String str2, Object obj, boolean z) {
        if (z) {
            Log.e(str, "==>" + str2 + "\n==>" + obj);
        }
    }

    public static void logInfo(String str, String str2, Object obj, boolean z) {
        if (z) {
            Log.i(str, "==>" + str2 + "\n==>" + obj);
        }
    }
}
