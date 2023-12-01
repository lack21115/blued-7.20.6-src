package androidx.lifecycle;

import android.view.View;
import android.view.ViewParent;
import androidx.lifecycle.viewmodel.R;

/* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/ViewTreeViewModelStoreOwner.class */
public class ViewTreeViewModelStoreOwner {
    private ViewTreeViewModelStoreOwner() {
    }

    public static ViewModelStoreOwner get(View view) {
        ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) view.getTag(R.id.view_tree_view_model_store_owner);
        if (viewModelStoreOwner != null) {
            return viewModelStoreOwner;
        }
        ViewParent parent = view.getParent();
        ViewModelStoreOwner viewModelStoreOwner2 = viewModelStoreOwner;
        while (viewModelStoreOwner2 == null && (parent instanceof View)) {
            View view2 = (View) parent;
            viewModelStoreOwner2 = (ViewModelStoreOwner) view2.getTag(R.id.view_tree_view_model_store_owner);
            parent = view2.getParent();
        }
        return viewModelStoreOwner2;
    }

    public static void set(View view, ViewModelStoreOwner viewModelStoreOwner) {
        view.setTag(R.id.view_tree_view_model_store_owner, viewModelStoreOwner);
    }
}
