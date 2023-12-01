package com.brandongogetap.stickyheaders;

import android.view.View;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: source-7206380-dex2jar.jar:com/brandongogetap/stickyheaders/Preconditions.class */
final class Preconditions {
    private Preconditions() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view) {
        View view2 = (View) view.getParent();
        if (!(view2 instanceof FrameLayout) && !(view2 instanceof CoordinatorLayout)) {
            throw new IllegalArgumentException("RecyclerView parent must be either a FrameLayout or CoordinatorLayout");
        }
    }
}
