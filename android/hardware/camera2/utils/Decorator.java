package android.hardware.camera2.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/utils/Decorator.class */
public class Decorator<T> implements InvocationHandler {
    private final DecoratorListener mListener;
    private final T mObject;

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/utils/Decorator$DecoratorListener.class */
    public interface DecoratorListener {
        void onAfterInvocation(Method method, Object[] objArr, Object obj);

        void onBeforeInvocation(Method method, Object[] objArr);

        boolean onCatchException(Method method, Object[] objArr, Throwable th);

        void onFinally(Method method, Object[] objArr);
    }

    private Decorator(T t, DecoratorListener decoratorListener) {
        this.mObject = t;
        this.mListener = decoratorListener;
    }

    public static <T> T newInstance(T t, DecoratorListener decoratorListener) {
        return (T) Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), new Decorator(t, decoratorListener));
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        Object obj2 = null;
        try {
            try {
                this.mListener.onBeforeInvocation(method, objArr);
                Object invoke = method.invoke(this.mObject, objArr);
                obj2 = invoke;
                this.mListener.onAfterInvocation(method, objArr, invoke);
                return invoke;
            } catch (InvocationTargetException e) {
                Throwable targetException = e.getTargetException();
                if (this.mListener.onCatchException(method, objArr, targetException)) {
                    this.mListener.onFinally(method, objArr);
                    return obj2;
                }
                throw targetException;
            }
        } finally {
            this.mListener.onFinally(method, objArr);
        }
    }
}
