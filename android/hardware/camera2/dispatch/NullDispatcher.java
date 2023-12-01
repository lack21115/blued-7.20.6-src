package android.hardware.camera2.dispatch;

import java.lang.reflect.Method;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/dispatch/NullDispatcher.class */
public class NullDispatcher<T> implements Dispatchable<T> {
    @Override // android.hardware.camera2.dispatch.Dispatchable
    public Object dispatch(Method method, Object[] objArr) {
        return null;
    }
}
