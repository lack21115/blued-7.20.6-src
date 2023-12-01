package androidx.savedstate;

import android.view.View;
import android.view.ViewParent;

/* loaded from: source-8756600-dex2jar.jar:androidx/savedstate/ViewTreeSavedStateRegistryOwner.class */
public final class ViewTreeSavedStateRegistryOwner {
    private ViewTreeSavedStateRegistryOwner() {
    }

    public static SavedStateRegistryOwner get(View view) {
        SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) view.getTag(R.id.view_tree_saved_state_registry_owner);
        if (savedStateRegistryOwner != null) {
            return savedStateRegistryOwner;
        }
        ViewParent parent = view.getParent();
        SavedStateRegistryOwner savedStateRegistryOwner2 = savedStateRegistryOwner;
        while (savedStateRegistryOwner2 == null && (parent instanceof View)) {
            View view2 = (View) parent;
            savedStateRegistryOwner2 = (SavedStateRegistryOwner) view2.getTag(R.id.view_tree_saved_state_registry_owner);
            parent = view2.getParent();
        }
        return savedStateRegistryOwner2;
    }

    public static void set(View view, SavedStateRegistryOwner savedStateRegistryOwner) {
        view.setTag(R.id.view_tree_saved_state_registry_owner, savedStateRegistryOwner);
    }
}
