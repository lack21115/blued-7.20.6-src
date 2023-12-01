package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;

/* loaded from: source-8756600-dex2jar.jar:androidx/savedstate/SavedStateRegistryController.class */
public final class SavedStateRegistryController {

    /* renamed from: a  reason: collision with root package name */
    private final SavedStateRegistryOwner f3324a;
    private final SavedStateRegistry b = new SavedStateRegistry();

    private SavedStateRegistryController(SavedStateRegistryOwner savedStateRegistryOwner) {
        this.f3324a = savedStateRegistryOwner;
    }

    public static SavedStateRegistryController create(SavedStateRegistryOwner savedStateRegistryOwner) {
        return new SavedStateRegistryController(savedStateRegistryOwner);
    }

    public SavedStateRegistry getSavedStateRegistry() {
        return this.b;
    }

    public void performRestore(Bundle bundle) {
        Lifecycle lifecycle = this.f3324a.getLifecycle();
        if (lifecycle.getCurrentState() != Lifecycle.State.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.addObserver(new Recreator(this.f3324a));
        this.b.a(lifecycle, bundle);
    }

    public void performSave(Bundle bundle) {
        this.b.a(bundle);
    }
}
