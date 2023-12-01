package com.github.chrisbanes.photoview;

import android.os.Build;
import android.view.View;

/* loaded from: source-8110460-dex2jar.jar:com/github/chrisbanes/photoview/Compat.class */
class Compat {
    Compat() {
    }

    public static void a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            b(view, runnable);
        } else {
            view.postDelayed(runnable, 16L);
        }
    }

    private static void b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
