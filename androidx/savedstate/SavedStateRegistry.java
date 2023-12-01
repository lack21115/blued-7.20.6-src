package androidx.savedstate;

import android.os.Bundle;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.Recreator;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:androidx/savedstate/SavedStateRegistry.class */
public final class SavedStateRegistry {

    /* renamed from: c  reason: collision with root package name */
    private Bundle f3322c;
    private boolean d;
    private Recreator.SavedStateProvider e;
    private SafeIterableMap<String, SavedStateProvider> b = new SafeIterableMap<>();

    /* renamed from: a  reason: collision with root package name */
    boolean f3321a = true;

    /* loaded from: source-8756600-dex2jar.jar:androidx/savedstate/SavedStateRegistry$AutoRecreated.class */
    public interface AutoRecreated {
        void onRecreated(SavedStateRegistryOwner savedStateRegistryOwner);
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/savedstate/SavedStateRegistry$SavedStateProvider.class */
    public interface SavedStateProvider {
        Bundle saveState();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f3322c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        SafeIterableMap<String, SavedStateProvider>.IteratorWithAdditions iteratorWithAdditions = this.b.iteratorWithAdditions();
        while (iteratorWithAdditions.hasNext()) {
            Map.Entry next = iteratorWithAdditions.next();
            bundle2.putBundle((String) next.getKey(), ((SavedStateProvider) next.getValue()).saveState());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Lifecycle lifecycle, Bundle bundle) {
        if (this.d) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        if (bundle != null) {
            this.f3322c = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        }
        lifecycle.addObserver(new GenericLifecycleObserver() { // from class: androidx.savedstate.SavedStateRegistry.1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_START) {
                    SavedStateRegistry.this.f3321a = true;
                } else if (event == Lifecycle.Event.ON_STOP) {
                    SavedStateRegistry.this.f3321a = false;
                }
            }
        });
        this.d = true;
    }

    public Bundle consumeRestoredStateForKey(String str) {
        if (this.d) {
            Bundle bundle = this.f3322c;
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle(str);
                this.f3322c.remove(str);
                if (this.f3322c.isEmpty()) {
                    this.f3322c = null;
                }
                return bundle2;
            }
            return null;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    public boolean isRestored() {
        return this.d;
    }

    public void registerSavedStateProvider(String str, SavedStateProvider savedStateProvider) {
        if (this.b.putIfAbsent(str, savedStateProvider) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public void runOnNextRecreation(Class<? extends AutoRecreated> cls) {
        if (!this.f3321a) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.e == null) {
            this.e = new Recreator.SavedStateProvider(this);
        }
        try {
            cls.getDeclaredConstructor(new Class[0]);
            this.e.a(cls.getName());
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
        }
    }

    public void unregisterSavedStateProvider(String str) {
        this.b.remove(str);
    }
}
