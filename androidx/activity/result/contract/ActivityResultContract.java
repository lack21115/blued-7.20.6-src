package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;

/* loaded from: source-8756600-dex2jar.jar:androidx/activity/result/contract/ActivityResultContract.class */
public abstract class ActivityResultContract<I, O> {

    /* loaded from: source-8756600-dex2jar.jar:androidx/activity/result/contract/ActivityResultContract$SynchronousResult.class */
    public static final class SynchronousResult<T> {

        /* renamed from: a  reason: collision with root package name */
        private final T f1526a;

        public SynchronousResult(T t) {
            this.f1526a = t;
        }

        public T getValue() {
            return this.f1526a;
        }
    }

    public abstract Intent createIntent(Context context, I i);

    public SynchronousResult<O> getSynchronousResult(Context context, I i) {
        return null;
    }

    public abstract O parseResult(int i, Intent intent);
}
