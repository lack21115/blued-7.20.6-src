package androidx.core.telephony;

import android.os.Build;
import android.telephony.TelephonyManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/telephony/TelephonyManagerCompat.class */
public class TelephonyManagerCompat {

    /* renamed from: a  reason: collision with root package name */
    private static Method f2511a;
    private static Method b;

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/telephony/TelephonyManagerCompat$Api23Impl.class */
    static class Api23Impl {
        private Api23Impl() {
        }

        static String a(TelephonyManager telephonyManager, int i) {
            return telephonyManager.getDeviceId(i);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/telephony/TelephonyManagerCompat$Api26Impl.class */
    static class Api26Impl {
        private Api26Impl() {
        }

        static String a(TelephonyManager telephonyManager) {
            return telephonyManager.getImei();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/telephony/TelephonyManagerCompat$Api30Impl.class */
    public static class Api30Impl {
        private Api30Impl() {
        }

        static int a(TelephonyManager telephonyManager) {
            return telephonyManager.getSubscriptionId();
        }
    }

    private TelephonyManagerCompat() {
    }

    public static String getImei(TelephonyManager telephonyManager) {
        int subscriptionId;
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.a(telephonyManager);
        }
        if (Build.VERSION.SDK_INT < 22 || (subscriptionId = getSubscriptionId(telephonyManager)) == Integer.MAX_VALUE || subscriptionId == -1) {
            return telephonyManager.getDeviceId();
        }
        int slotIndex = SubscriptionManagerCompat.getSlotIndex(subscriptionId);
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.a(telephonyManager, slotIndex);
        }
        try {
            if (f2511a == null) {
                Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getDeviceId", Integer.TYPE);
                f2511a = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            return (String) f2511a.invoke(telephonyManager, Integer.valueOf(slotIndex));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            return null;
        }
    }

    public static int getSubscriptionId(TelephonyManager telephonyManager) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.a(telephonyManager);
        }
        if (Build.VERSION.SDK_INT >= 22) {
            try {
                if (b == null) {
                    Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getSubId", new Class[0]);
                    b = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                Integer num = (Integer) b.invoke(telephonyManager, new Object[0]);
                if (num == null || num.intValue() == -1) {
                    return Integer.MAX_VALUE;
                }
                return num.intValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                return Integer.MAX_VALUE;
            }
        }
        return Integer.MAX_VALUE;
    }
}
