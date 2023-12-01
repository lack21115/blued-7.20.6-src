package android.hardware.camera2.dispatch;

import com.android.internal.util.Preconditions;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/dispatch/BroadcastDispatcher.class */
public class BroadcastDispatcher<T> implements Dispatchable<T> {
    private final List<Dispatchable<T>> mDispatchTargets;

    @SafeVarargs
    public BroadcastDispatcher(Dispatchable<T>... dispatchableArr) {
        this.mDispatchTargets = Arrays.asList((Object[]) Preconditions.checkNotNull(dispatchableArr, "dispatchTargets must not be null"));
    }

    @Override // android.hardware.camera2.dispatch.Dispatchable
    public Object dispatch(Method method, Object[] objArr) throws Throwable {
        Object obj = null;
        boolean z = false;
        for (Dispatchable<T> dispatchable : this.mDispatchTargets) {
            Object dispatch = dispatchable.dispatch(method, objArr);
            if (!z) {
                z = true;
                obj = dispatch;
            }
        }
        return obj;
    }
}
