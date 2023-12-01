package android.hardware.camera2.dispatch;

import android.hardware.camera2.utils.UncheckedThrow;
import com.android.internal.util.Preconditions;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/dispatch/MethodNameInvoker.class */
public class MethodNameInvoker<T> {
    private final ConcurrentHashMap<String, Method> mMethods = new ConcurrentHashMap<>();
    private final Dispatchable<T> mTarget;
    private final Class<T> mTargetClass;

    public MethodNameInvoker(Dispatchable<T> dispatchable, Class<T> cls) {
        this.mTargetClass = cls;
        this.mTarget = dispatchable;
    }

    public <K> K invoke(String str, Object... objArr) {
        Method method;
        Preconditions.checkNotNull(str, "methodName must not be null");
        Method method2 = this.mMethods.get(str);
        Method method3 = method2;
        if (method2 == null) {
            Method[] methods = this.mTargetClass.getMethods();
            int length = methods.length;
            int i = 0;
            while (true) {
                int i2 = i;
                method = method2;
                if (i2 >= length) {
                    break;
                }
                method = methods[i2];
                if (method.getName().equals(str) && objArr.length == method.getParameterTypes().length) {
                    this.mMethods.put(str, method);
                    break;
                }
                i = i2 + 1;
            }
            method3 = method;
            if (method == null) {
                throw new IllegalArgumentException("Method " + str + " does not exist on class " + this.mTargetClass);
            }
        }
        try {
            return (K) this.mTarget.dispatch(method3, objArr);
        } catch (Throwable th) {
            UncheckedThrow.throwAnyException(th);
            return null;
        }
    }
}
