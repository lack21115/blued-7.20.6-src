package androidx.savedstate;

import androidx.lifecycle.LifecycleOwner;

/* loaded from: source-8756600-dex2jar.jar:androidx/savedstate/SavedStateRegistryOwner.class */
public interface SavedStateRegistryOwner extends LifecycleOwner {
    SavedStateRegistry getSavedStateRegistry();
}
