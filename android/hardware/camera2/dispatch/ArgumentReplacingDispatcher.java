package android.hardware.camera2.dispatch;

import com.android.internal.util.Preconditions;
import java.lang.reflect.Method;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/dispatch/ArgumentReplacingDispatcher.class */
public class ArgumentReplacingDispatcher<T, TArg> implements Dispatchable<T> {
    private final int mArgumentIndex;
    private final TArg mReplaceWith;
    private final Dispatchable<T> mTarget;

    public ArgumentReplacingDispatcher(Dispatchable<T> dispatchable, int i, TArg targ) {
        this.mTarget = (Dispatchable) Preconditions.checkNotNull(dispatchable, "target must not be null");
        this.mArgumentIndex = Preconditions.checkArgumentNonnegative(i, "argumentIndex must not be negative");
        this.mReplaceWith = (TArg) Preconditions.checkNotNull(targ, "replaceWith must not be null");
    }

    private static Object[] arrayCopy(Object[] objArr) {
        int length = objArr.length;
        Object[] objArr2 = new Object[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return objArr2;
            }
            objArr2[i2] = objArr[i2];
            i = i2 + 1;
        }
    }

    @Override // android.hardware.camera2.dispatch.Dispatchable
    public Object dispatch(Method method, Object[] objArr) throws Throwable {
        Object[] objArr2 = objArr;
        if (objArr.length > this.mArgumentIndex) {
            objArr2 = arrayCopy(objArr);
            objArr2[this.mArgumentIndex] = this.mReplaceWith;
        }
        return this.mTarget.dispatch(method, objArr2);
    }
}
