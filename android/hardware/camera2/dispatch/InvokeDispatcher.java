package android.hardware.camera2.dispatch;

import android.hardware.camera2.utils.UncheckedThrow;
import android.util.Log;
import com.android.internal.util.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/dispatch/InvokeDispatcher.class */
public class InvokeDispatcher<T> implements Dispatchable<T> {
    private static final String TAG = "InvocationSink";
    private final T mTarget;

    public InvokeDispatcher(T t) {
        this.mTarget = (T) Preconditions.checkNotNull(t, "target must not be null");
    }

    @Override // android.hardware.camera2.dispatch.Dispatchable
    public Object dispatch(Method method, Object[] objArr) {
        try {
            return method.invoke(this.mTarget, objArr);
        } catch (IllegalAccessException e) {
            Log.wtf(TAG, "IllegalAccessException while invoking " + method, e);
            return null;
        } catch (IllegalArgumentException e2) {
            Log.wtf(TAG, "IllegalArgumentException while invoking " + method, e2);
            return null;
        } catch (InvocationTargetException e3) {
            UncheckedThrow.throwAnyException(e3.getTargetException());
            return null;
        }
    }
}
