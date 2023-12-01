package io.grpc.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.Provider;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ConscryptLoader.class */
public final class ConscryptLoader {
    private static final Method IS_CONSCRYPT_METHOD;
    private static final Method NEW_PROVIDER_METHOD;

    static {
        Method method;
        Method method2 = null;
        try {
            Class<?> cls = Class.forName("org.conscrypt.Conscrypt");
            Method method3 = cls.getMethod("newProvider", new Class[0]);
            method = cls.getMethod("isConscrypt", Provider.class);
            method2 = method3;
        } catch (ClassNotFoundException e) {
            method = null;
        } catch (NoSuchMethodException e2) {
            throw new AssertionError(e2);
        }
        NEW_PROVIDER_METHOD = method2;
        IS_CONSCRYPT_METHOD = method;
    }

    public static boolean isConscrypt(Provider provider) {
        if (isPresent()) {
            try {
                return ((Boolean) IS_CONSCRYPT_METHOD.invoke(null, provider)).booleanValue();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                throw new AssertionError(e2);
            }
        }
        return false;
    }

    public static boolean isPresent() {
        return NEW_PROVIDER_METHOD != null;
    }

    public static Provider newProvider() throws Throwable {
        if (isPresent()) {
            return (Provider) NEW_PROVIDER_METHOD.invoke(null, new Object[0]);
        }
        Class.forName("org.conscrypt.Conscrypt");
        throw new AssertionError("Unexpected failure referencing Conscrypt class");
    }
}
