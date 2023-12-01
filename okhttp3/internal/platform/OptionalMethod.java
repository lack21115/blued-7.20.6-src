package okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/platform/OptionalMethod.class */
public class OptionalMethod<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f43976a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final Class[] f43977c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OptionalMethod(Class<?> cls, String str, Class... clsArr) {
        this.f43976a = cls;
        this.b = str;
        this.f43977c = clsArr;
    }

    private Method a(Class<?> cls) {
        Class<?> cls2;
        String str = this.b;
        Method method = null;
        if (str != null) {
            method = a(cls, str, this.f43977c);
            if (method != null && (cls2 = this.f43976a) != null && !cls2.isAssignableFrom(method.getReturnType())) {
                return null;
            }
        }
        return method;
    }

    private static Method a(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException e) {
            }
            return method;
        } catch (NoSuchMethodException e2) {
            return null;
        }
    }

    public Object a(T t, Object... objArr) throws InvocationTargetException {
        Method a2 = a(t.getClass());
        if (a2 == null) {
            return null;
        }
        try {
            return a2.invoke(t, objArr);
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    public boolean a(T t) {
        return a(t.getClass()) != null;
    }

    public Object b(T t, Object... objArr) {
        try {
            return a(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object c(T t, Object... objArr) throws InvocationTargetException {
        Method a2 = a(t.getClass());
        if (a2 == null) {
            throw new AssertionError("Method " + this.b + " not supported for object " + t);
        }
        try {
            return a2.invoke(t, objArr);
        } catch (IllegalAccessException e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a2);
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    public Object d(T t, Object... objArr) {
        try {
            return c(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }
}
