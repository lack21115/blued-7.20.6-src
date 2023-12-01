package android.os;

import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/os/SystemProperties.class */
public class SystemProperties {
    public static final int PROP_NAME_MAX = 31;
    public static final int PROP_VALUE_MAX = 91;
    private static final ArrayList<Runnable> sChangeCallbacks = new ArrayList<>();

    public static void addChangeCallback(Runnable runnable) {
        synchronized (sChangeCallbacks) {
            if (sChangeCallbacks.size() == 0) {
                native_add_change_callback();
            }
            sChangeCallbacks.add(runnable);
        }
    }

    static void callChangeCallbacks() {
        synchronized (sChangeCallbacks) {
            if (sChangeCallbacks.size() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList(sChangeCallbacks);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    return;
                }
                ((Runnable) arrayList.get(i2)).run();
                i = i2 + 1;
            }
        }
    }

    public static String get(String str) {
        if (str.length() > 31) {
            throw new IllegalArgumentException("key.length > 31");
        }
        return native_get(str);
    }

    public static String get(String str, String str2) {
        if (str.length() > 31) {
            throw new IllegalArgumentException("key.length > 31");
        }
        return native_get(str, str2);
    }

    public static boolean getBoolean(String str, boolean z) {
        if (str.length() > 31) {
            throw new IllegalArgumentException("key.length > 31");
        }
        return native_get_boolean(str, z);
    }

    public static int getInt(String str, int i) {
        if (str.length() > 31) {
            throw new IllegalArgumentException("key.length > 31");
        }
        return native_get_int(str, i);
    }

    public static long getLong(String str, long j) {
        if (str.length() > 31) {
            throw new IllegalArgumentException("key.length > 31");
        }
        return native_get_long(str, j);
    }

    private static native void native_add_change_callback();

    private static native String native_get(String str);

    private static native String native_get(String str, String str2);

    private static native boolean native_get_boolean(String str, boolean z);

    private static native int native_get_int(String str, int i);

    private static native long native_get_long(String str, long j);

    private static native void native_set(String str, String str2);

    public static void set(String str, String str2) {
        if (str.length() > 31) {
            throw new IllegalArgumentException("key.length > 31");
        }
        if (str2 != null && str2.length() > 91) {
            throw new IllegalArgumentException("val.length > 91");
        }
        native_set(str, str2);
    }
}
