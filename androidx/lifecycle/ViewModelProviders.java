package androidx.lifecycle;

import android.app.Application;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

@Deprecated
/* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/ViewModelProviders.class */
public class ViewModelProviders {

    @Deprecated
    /* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/ViewModelProviders$DefaultFactory.class */
    public static class DefaultFactory extends ViewModelProvider.AndroidViewModelFactory {
        @Deprecated
        public DefaultFactory(Application application) {
            super(application);
        }
    }

    @Deprecated
    public static ViewModelProvider of(Fragment fragment) {
        return new ViewModelProvider(fragment);
    }

    @Deprecated
    public static ViewModelProvider of(Fragment fragment, ViewModelProvider.Factory factory) {
        ViewModelProvider.Factory factory2 = factory;
        if (factory == null) {
            factory2 = fragment.getDefaultViewModelProviderFactory();
        }
        return new ViewModelProvider(fragment.getViewModelStore(), factory2);
    }

    @Deprecated
    public static ViewModelProvider of(FragmentActivity fragmentActivity) {
        return new ViewModelProvider(fragmentActivity);
    }

    @Deprecated
    public static ViewModelProvider of(FragmentActivity fragmentActivity, ViewModelProvider.Factory factory) {
        ViewModelProvider.Factory factory2 = factory;
        if (factory == null) {
            factory2 = fragmentActivity.getDefaultViewModelProviderFactory();
        }
        return new ViewModelProvider(fragmentActivity.getViewModelStore(), factory2);
    }
}
