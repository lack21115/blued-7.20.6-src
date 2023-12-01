package android.hardware.camera2.dispatch;

import android.hardware.camera2.utils.UncheckedThrow;
import android.os.Handler;
import android.util.Log;
import com.android.internal.util.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/dispatch/HandlerDispatcher.class */
public class HandlerDispatcher<T> implements Dispatchable<T> {
    private static final String TAG = "HandlerDispatcher";
    private final Dispatchable<T> mDispatchTarget;
    private final Handler mHandler;

    public HandlerDispatcher(Dispatchable<T> dispatchable, Handler handler) {
        this.mDispatchTarget = (Dispatchable) Preconditions.checkNotNull(dispatchable, "dispatchTarget must not be null");
        this.mHandler = (Handler) Preconditions.checkNotNull(handler, "handler must not be null");
    }

    @Override // android.hardware.camera2.dispatch.Dispatchable
    public Object dispatch(final Method method, final Object[] objArr) throws Throwable {
        this.mHandler.post(new Runnable() { // from class: android.hardware.camera2.dispatch.HandlerDispatcher.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HandlerDispatcher.this.mDispatchTarget.dispatch(method, objArr);
                } catch (IllegalAccessException e) {
                    Log.wtf(HandlerDispatcher.TAG, "IllegalAccessException while invoking " + method, e);
                } catch (IllegalArgumentException e2) {
                    Log.wtf(HandlerDispatcher.TAG, "IllegalArgumentException while invoking " + method, e2);
                } catch (InvocationTargetException e3) {
                    UncheckedThrow.throwAnyException(e3.getTargetException());
                } catch (Throwable th) {
                    UncheckedThrow.throwAnyException(th);
                }
            }
        });
        return null;
    }
}
