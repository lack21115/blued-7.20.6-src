package com.blued.android.module.common.base.mvvm;

import android.util.Log;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvvm/SingleLiveEvent.class */
public class SingleLiveEvent<T> extends MutableLiveData<T> {
    private static final String a = SingleLiveEvent.class.getName();
    private final AtomicBoolean b = new AtomicBoolean(false);

    public void call() {
        setValue(null);
    }

    public void observe(LifecycleOwner lifecycleOwner, final Observer<? super T> observer) {
        if (hasActiveObservers()) {
            Log.i(a, "Multiple observers registered but only one will be notified of changes.");
        }
        super.observe(lifecycleOwner, new Observer<T>() { // from class: com.blued.android.module.common.base.mvvm.SingleLiveEvent.1
            public void onChanged(T t) {
                if (SingleLiveEvent.this.b.compareAndSet(true, false)) {
                    observer.onChanged(t);
                }
            }
        });
    }

    public void setValue(T t) {
        this.b.set(true);
        super.setValue(t);
    }
}
