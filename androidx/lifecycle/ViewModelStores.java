package androidx.lifecycle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

@Deprecated
/* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/ViewModelStores.class */
public class ViewModelStores {
    private ViewModelStores() {
    }

    @Deprecated
    public static ViewModelStore of(Fragment fragment) {
        return fragment.getViewModelStore();
    }

    @Deprecated
    public static ViewModelStore of(FragmentActivity fragmentActivity) {
        return fragmentActivity.getViewModelStore();
    }
}
