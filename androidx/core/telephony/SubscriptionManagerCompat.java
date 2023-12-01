package androidx.core.telephony;

import android.os.Build;
import android.telephony.SubscriptionManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/telephony/SubscriptionManagerCompat.class */
public class SubscriptionManagerCompat {

    /* renamed from: a  reason: collision with root package name */
    private static Method f2510a;

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/telephony/SubscriptionManagerCompat$Api29Impl.class */
    static class Api29Impl {
        private Api29Impl() {
        }

        static int a(int i) {
            return SubscriptionManager.getSlotIndex(i);
        }
    }

    private SubscriptionManagerCompat() {
    }

    public static int getSlotIndex(int i) {
        if (i == -1) {
            return -1;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.a(i);
        }
        try {
            if (f2510a == null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    f2510a = SubscriptionManager.class.getDeclaredMethod("getSlotIndex", Integer.TYPE);
                } else {
                    f2510a = SubscriptionManager.class.getDeclaredMethod("getSlotId", Integer.TYPE);
                }
                f2510a.setAccessible(true);
            }
            Integer num = (Integer) f2510a.invoke(null, Integer.valueOf(i));
            if (num != null) {
                return num.intValue();
            }
            return -1;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            return -1;
        }
    }
}
