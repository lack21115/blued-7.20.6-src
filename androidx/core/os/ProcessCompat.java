package androidx.core.os;

import android.os.Build;
import android.os.Process;
import android.os.UserHandle;
import java.lang.reflect.Method;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/os/ProcessCompat.class */
public final class ProcessCompat {

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/os/ProcessCompat$Api16Impl.class */
    static class Api16Impl {

        /* renamed from: a  reason: collision with root package name */
        private static final Object f2516a = new Object();
        private static Method b;

        /* renamed from: c  reason: collision with root package name */
        private static boolean f2517c;

        private Api16Impl() {
        }

        static boolean a(int i) {
            try {
                synchronized (f2516a) {
                    if (!f2517c) {
                        f2517c = true;
                        b = Class.forName("android.os.UserId").getDeclaredMethod("isApp", Integer.TYPE);
                    }
                }
                if (b != null) {
                    Boolean bool = (Boolean) b.invoke(null, Integer.valueOf(i));
                    if (bool != null) {
                        return bool.booleanValue();
                    }
                    throw new NullPointerException();
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/os/ProcessCompat$Api17Impl.class */
    static class Api17Impl {

        /* renamed from: a  reason: collision with root package name */
        private static final Object f2518a = new Object();
        private static Method b;

        /* renamed from: c  reason: collision with root package name */
        private static boolean f2519c;

        private Api17Impl() {
        }

        static boolean a(int i) {
            try {
                synchronized (f2518a) {
                    if (!f2519c) {
                        f2519c = true;
                        b = UserHandle.class.getDeclaredMethod("isApp", Integer.TYPE);
                    }
                }
                if (b == null || ((Boolean) b.invoke(null, Integer.valueOf(i))) != null) {
                    return true;
                }
                throw new NullPointerException();
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/os/ProcessCompat$Api24Impl.class */
    static class Api24Impl {
        private Api24Impl() {
        }

        static boolean a(int i) {
            return Process.isApplicationUid(i);
        }
    }

    private ProcessCompat() {
    }

    public static boolean isApplicationUid(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.a(i);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            return Api17Impl.a(i);
        }
        if (Build.VERSION.SDK_INT == 16) {
            return Api16Impl.a(i);
        }
        return true;
    }
}
