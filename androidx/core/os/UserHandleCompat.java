package androidx.core.os;

import android.os.Build;
import android.os.UserHandle;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/os/UserHandleCompat.class */
public class UserHandleCompat {

    /* renamed from: a  reason: collision with root package name */
    private static Method f2522a;
    private static Constructor<UserHandle> b;

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/os/UserHandleCompat$Api24Impl.class */
    static class Api24Impl {
        private Api24Impl() {
        }

        static UserHandle a(int i) {
            return UserHandle.getUserHandleForUid(i);
        }
    }

    private UserHandleCompat() {
    }

    private static Method a() throws NoSuchMethodException {
        if (f2522a == null) {
            Method declaredMethod = UserHandle.class.getDeclaredMethod("getUserId", Integer.TYPE);
            f2522a = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        return f2522a;
    }

    private static Constructor<UserHandle> b() throws NoSuchMethodException {
        if (b == null) {
            Constructor<UserHandle> declaredConstructor = UserHandle.class.getDeclaredConstructor(Integer.TYPE);
            b = declaredConstructor;
            declaredConstructor.setAccessible(true);
        }
        return b;
    }

    public static UserHandle getUserHandleForUid(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.a(i);
        }
        try {
            return b().newInstance((Integer) a().invoke(null, Integer.valueOf(i)));
        } catch (IllegalAccessException e) {
            IllegalAccessError illegalAccessError = new IllegalAccessError();
            illegalAccessError.initCause(e);
            throw illegalAccessError;
        } catch (InstantiationException e2) {
            InstantiationError instantiationError = new InstantiationError();
            instantiationError.initCause(e2);
            throw instantiationError;
        } catch (NoSuchMethodException e3) {
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
            noSuchMethodError.initCause(e3);
            throw noSuchMethodError;
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }
}
