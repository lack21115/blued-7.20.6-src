package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/bl.class */
public final class bl {
    public static boolean a(View view, int i, boolean z) {
        return view != null && b(view, i, z) && ci(view.getContext());
    }

    private static boolean b(View view, int i, boolean z) {
        if (view == null || view.getParent() == null) {
            return false;
        }
        Activity dj = com.kwad.sdk.j.k.dj(view.getContext());
        if ((dj == null || !dj.isFinishing()) && view.isShown() && view.getVisibility() == 0) {
            if (!z || view.hasWindowFocus()) {
                Rect rect = new Rect();
                if (view.getGlobalVisibleRect(rect)) {
                    long height = rect.height();
                    long width = rect.width();
                    long height2 = view.getHeight() * view.getWidth();
                    return height2 > 0 && (height * width) * 100 >= ((long) i) * height2;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private static boolean ci(Context context) {
        return an.DN().ci(context);
    }

    public static boolean o(View view, int i) {
        return view != null && b(view, i, true) && view.hasWindowFocus() && ci(view.getContext());
    }
}
