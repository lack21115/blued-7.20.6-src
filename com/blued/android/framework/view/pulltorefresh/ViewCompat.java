package com.blued.android.framework.view.pulltorefresh;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/ViewCompat.class */
public class ViewCompat {

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/ViewCompat$SDK11.class */
    static class SDK11 {
        SDK11() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/ViewCompat$SDK16.class */
    public static class SDK16 {
        SDK16() {
        }

        public static void a(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        public static void a(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }
    }

    public static void a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            SDK16.a(view, drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            SDK16.a(view, runnable);
        } else {
            view.postDelayed(runnable, 16L);
        }
    }
}
