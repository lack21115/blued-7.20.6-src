package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/LifecycleEventObserver.class */
public interface LifecycleEventObserver extends LifecycleObserver {
    void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event);
}
