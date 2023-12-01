package io.grpc.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ReflectionLongAdderCounter.class */
public final class ReflectionLongAdderCounter implements LongCounter {
    private static final Method addMethod;
    private static final Constructor<?> defaultConstructor;
    private static final RuntimeException initializationException;
    private static final Logger logger = Logger.getLogger(ReflectionLongAdderCounter.class.getName());
    private static final Method sumMethod;
    private final Object instance;

    static {
        Method method;
        Method method2;
        Constructor<?> constructor;
        Throwable th;
        Constructor<?> constructor2;
        try {
            Class<?> cls = Class.forName("java.util.concurrent.atomic.LongAdder");
            int i = 0;
            method = cls.getMethod("add", Long.TYPE);
            try {
                method2 = cls.getMethod("sum", new Class[0]);
            } catch (Throwable th2) {
                th = th2;
                method2 = null;
            }
            try {
                Constructor<?>[] constructors = cls.getConstructors();
                int length = constructors.length;
                while (true) {
                    if (i >= length) {
                        constructor2 = null;
                        break;
                    }
                    constructor2 = constructors[i];
                    if (constructor2.getParameterTypes().length == 0) {
                        break;
                    }
                    i++;
                }
                th = null;
                constructor = constructor2;
            } catch (Throwable th3) {
                th = th3;
                logger.log(Level.FINE, "LongAdder can not be found via reflection, this is normal for JDK7 and below", th);
                constructor = null;
                th = th;
                if (th == null) {
                }
                defaultConstructor = null;
                addMethod = null;
                sumMethod = null;
                initializationException = new RuntimeException(th);
                return;
            }
        } catch (Throwable th4) {
            th = th4;
            method = null;
            method2 = null;
        }
        if (th == null || constructor == null) {
            defaultConstructor = null;
            addMethod = null;
            sumMethod = null;
            initializationException = new RuntimeException(th);
            return;
        }
        defaultConstructor = constructor;
        addMethod = method;
        sumMethod = method2;
        initializationException = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectionLongAdderCounter() {
        RuntimeException runtimeException = initializationException;
        if (runtimeException != null) {
            throw runtimeException;
        }
        try {
            this.instance = defaultConstructor.newInstance(new Object[0]);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isAvailable() {
        return initializationException == null;
    }

    @Override // io.grpc.internal.LongCounter
    public void add(long j) {
        try {
            addMethod.invoke(this.instance, Long.valueOf(j));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // io.grpc.internal.LongCounter
    public long value() {
        try {
            return ((Long) sumMethod.invoke(this.instance, new Object[0])).longValue();
        } catch (IllegalAccessException e) {
            throw new RuntimeException();
        } catch (InvocationTargetException e2) {
            throw new RuntimeException();
        }
    }
}
