package android.hardware.camera2.dispatch;

import java.lang.reflect.Method;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/dispatch/Dispatchable.class */
public interface Dispatchable<T> {
    Object dispatch(Method method, Object[] objArr) throws Throwable;
}
