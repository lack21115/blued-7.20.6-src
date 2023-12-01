package com.anythink.core.common.k.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/a/e.class */
public final class e {
    private static View a(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getWindow().getDecorView().findViewById(16908290);
        }
        return null;
    }

    private static View a(Context context, View view) {
        View rootView;
        View findViewById = !(context instanceof Activity) ? null : ((Activity) context).getWindow().getDecorView().findViewById(16908290);
        if (view == null) {
            rootView = null;
        } else {
            rootView = view.getRootView();
            if (rootView == null) {
                rootView = null;
            } else {
                View findViewById2 = rootView.findViewById(16908290);
                if (findViewById2 != null) {
                    rootView = findViewById2;
                }
            }
        }
        return findViewById != null ? findViewById : rootView;
    }

    private static void a(View view) {
        if (view == null || view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) view.getParent()).removeView(view);
    }

    private static View b(View view) {
        View rootView;
        if (view == null || (rootView = view.getRootView()) == null) {
            return null;
        }
        View findViewById = rootView.findViewById(16908290);
        return findViewById != null ? findViewById : rootView;
    }
}
