package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentViewLifecycleOwner.class */
public class FragmentViewLifecycleOwner implements HasDefaultViewModelProviderFactory, ViewModelStoreOwner, SavedStateRegistryOwner {

    /* renamed from: a  reason: collision with root package name */
    private final Fragment f3040a;
    private final ViewModelStore b;

    /* renamed from: c  reason: collision with root package name */
    private ViewModelProvider.Factory f3041c;
    private LifecycleRegistry d = null;
    private SavedStateRegistryController e = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentViewLifecycleOwner(Fragment fragment, ViewModelStore viewModelStore) {
        this.f3040a = fragment;
        this.b = viewModelStore;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.d == null) {
            this.d = new LifecycleRegistry(this);
            this.e = SavedStateRegistryController.create(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Bundle bundle) {
        this.e.performRestore(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Lifecycle.Event event) {
        this.d.handleLifecycleEvent(event);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Lifecycle.State state) {
        this.d.setCurrentState(state);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Bundle bundle) {
        this.e.performSave(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.d != null;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        Application application;
        ViewModelProvider.Factory defaultViewModelProviderFactory = this.f3040a.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(this.f3040a.mDefaultFactory)) {
            this.f3041c = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.f3041c == null) {
            Context applicationContext = this.f3040a.requireContext().getApplicationContext();
            while (true) {
                Context context = applicationContext;
                application = null;
                if (!(context instanceof ContextWrapper)) {
                    break;
                } else if (context instanceof Application) {
                    application = (Application) context;
                    break;
                } else {
                    applicationContext = ((ContextWrapper) context).getBaseContext();
                }
            }
            this.f3041c = new SavedStateViewModelFactory(application, this, this.f3040a.getArguments());
        }
        return this.f3041c;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        a();
        return this.d;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public SavedStateRegistry getSavedStateRegistry() {
        a();
        return this.e.getSavedStateRegistry();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        a();
        return this.b;
    }
}
