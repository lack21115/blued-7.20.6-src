package androidx.lifecycle;

import android.view.View;
import android.view.ViewParent;
import androidx.lifecycle.runtime.R;

/* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/ViewTreeLifecycleOwner.class */
public class ViewTreeLifecycleOwner {
    private ViewTreeLifecycleOwner() {
    }

    public static LifecycleOwner get(View view) {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) view.getTag(R.id.view_tree_lifecycle_owner);
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        ViewParent parent = view.getParent();
        LifecycleOwner lifecycleOwner2 = lifecycleOwner;
        while (lifecycleOwner2 == null && (parent instanceof View)) {
            View view2 = (View) parent;
            lifecycleOwner2 = (LifecycleOwner) view2.getTag(R.id.view_tree_lifecycle_owner);
            parent = view2.getParent();
        }
        return lifecycleOwner2;
    }

    public static void set(View view, LifecycleOwner lifecycleOwner) {
        view.setTag(R.id.view_tree_lifecycle_owner, lifecycleOwner);
    }
}
