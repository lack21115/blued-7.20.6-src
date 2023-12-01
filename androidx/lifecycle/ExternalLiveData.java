package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/ExternalLiveData.class */
public class ExternalLiveData<T> extends MutableLiveData<T> {
    public static final int START_VERSION = -1;

    /* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/ExternalLiveData$ExternalLifecycleBoundObserver.class */
    class ExternalLifecycleBoundObserver extends LiveData<T>.LifecycleBoundObserver {
        ExternalLifecycleBoundObserver(LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
            super(lifecycleOwner, observer);
        }

        @Override // androidx.lifecycle.LiveData.LifecycleBoundObserver, androidx.lifecycle.LiveData.ObserverWrapper
        boolean shouldBeActive() {
            return this.mOwner.getLifecycle().getCurrentState().isAtLeast(ExternalLiveData.this.observerActiveLevel());
        }
    }

    private Object callMethodPutIfAbsent(Object obj, Object obj2) throws Exception {
        Object fieldObservers = getFieldObservers();
        Method declaredMethod = fieldObservers.getClass().getDeclaredMethod("putIfAbsent", Object.class, Object.class);
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(fieldObservers, obj, obj2);
    }

    private Object getFieldObservers() throws Exception {
        Field declaredField = LiveData.class.getDeclaredField("mObservers");
        declaredField.setAccessible(true);
        return declaredField.get(this);
    }

    @Override // androidx.lifecycle.LiveData
    public int getVersion() {
        return super.getVersion();
    }

    @Override // androidx.lifecycle.LiveData
    public void observe(LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
        if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            return;
        }
        try {
            ExternalLifecycleBoundObserver externalLifecycleBoundObserver = new ExternalLifecycleBoundObserver(lifecycleOwner, observer);
            LiveData.LifecycleBoundObserver lifecycleBoundObserver = (LiveData.LifecycleBoundObserver) callMethodPutIfAbsent(observer, externalLifecycleBoundObserver);
            if (lifecycleBoundObserver != null && !lifecycleBoundObserver.isAttachedTo(lifecycleOwner)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            }
            if (lifecycleBoundObserver != null) {
                return;
            }
            lifecycleOwner.getLifecycle().addObserver(externalLifecycleBoundObserver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected Lifecycle.State observerActiveLevel() {
        return Lifecycle.State.CREATED;
    }
}
