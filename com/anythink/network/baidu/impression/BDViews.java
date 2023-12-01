package com.anythink.network.baidu.impression;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/impression/BDViews.class */
public class BDViews {
    private static View a(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getWindow().getDecorView().findViewById(16908290);
        }
        return null;
    }

    private static View a(View view) {
        View rootView;
        if (view == null || (rootView = view.getRootView()) == null) {
            return null;
        }
        View findViewById = rootView.findViewById(16908290);
        return findViewById != null ? findViewById : rootView;
    }

    public static View getTopmostView(Context context, View view) {
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

    public static void removeFromParent(View view) {
        if (view == null || view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) view.getParent()).removeView(view);
    }
}
