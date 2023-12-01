package androidx.lifecycle;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/LiveDataKt.class */
public final class LiveDataKt {
    @Deprecated
    public static final <T> Observer<T> observe(LiveData<T> liveData, LifecycleOwner owner, final Function1<? super T, Unit> onChanged) {
        Intrinsics.e(liveData, "<this>");
        Intrinsics.e(owner, "owner");
        Intrinsics.e(onChanged, "onChanged");
        Observer<T> observer = new Observer() { // from class: androidx.lifecycle.LiveDataKt$observe$wrappedObserver$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                onChanged.invoke(t);
            }
        };
        liveData.observe(owner, observer);
        return observer;
    }
}
