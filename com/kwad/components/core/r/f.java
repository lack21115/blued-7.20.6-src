package com.kwad.components.core.r;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import java.lang.reflect.Field;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/r/f.class */
public final class f {
    public static void destroyActivity(Context context, Window window) {
        if (window == null) {
            return;
        }
        View decorView = window.getDecorView();
        destroyWebViewInTree(decorView);
        fixInputMethodManagerLeak(context, decorView);
    }

    public static void destroyFragment(Context context, View view) {
        destroyWebViewInTree(view);
        fixInputMethodManagerLeak(context, view);
    }

    private static void destroyWebViewInTree(View view) {
        synchronized (f.class) {
            if (view == null) {
                return;
            }
            try {
                if (view instanceof WebView) {
                    try {
                        ((WebView) view).destroy();
                    } catch (Throwable th) {
                    }
                } else if (!(view instanceof ViewGroup)) {
                } else {
                    ViewGroup viewGroup = (ViewGroup) view;
                    int childCount = viewGroup.getChildCount();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= childCount) {
                            return;
                        }
                        destroyWebViewInTree(viewGroup.getChildAt(i2));
                        i = i2 + 1;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static void fixInputMethodManagerLeak(Context context, View view) {
        InputMethodManager inputMethodManager;
        if (context == null || view == null || Build.VERSION.SDK_INT >= 29 || (inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE)) == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                return;
            }
            try {
                Field declaredField = inputMethodManager.getClass().getDeclaredField(new String[]{"mCurRootView", "mServedView", "mNextServedView"}[i2]);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                Object obj = declaredField.get(inputMethodManager);
                if (!(obj instanceof View)) {
                    continue;
                } else if (!context.equals(((View) obj).getContext())) {
                    return;
                } else {
                    declaredField.set(inputMethodManager, null);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            i = i2 + 1;
        }
    }
}
