package com.blued.android.framework.ui.xpop.util;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.blued.android.chat.grpc.backup.MsgBackupManager;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import java.util.HashMap;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/util/KeyboardUtils.class */
public final class KeyboardUtils {
    public static int a;
    private static ViewTreeObserver.OnGlobalLayoutListener b;
    private static HashMap<View, OnSoftInputChangedListener> c = new HashMap<>();
    private static int d = 0;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/util/KeyboardUtils$OnSoftInputChangedListener.class */
    public interface OnSoftInputChangedListener {
        void a(int i);
    }

    private KeyboardUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void a(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 2);
    }

    public static void a(View view, BasePopupView basePopupView) {
        View findViewById;
        b = null;
        if (view == null || (findViewById = view.findViewById(16908290)) == null) {
            return;
        }
        findViewById.getViewTreeObserver().removeGlobalOnLayoutListener(b);
        c.remove(basePopupView);
    }

    public static void a(final Window window, BasePopupView basePopupView, OnSoftInputChangedListener onSoftInputChangedListener) {
        if ((window.getAttributes().flags & 512) != 0) {
            window.clearFlags(512);
        }
        FrameLayout frameLayout = (FrameLayout) window.findViewById(16908290);
        a = b(window);
        c.put(basePopupView, onSoftInputChangedListener);
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.blued.android.framework.ui.xpop.util.KeyboardUtils.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int b2 = KeyboardUtils.b(Window.this);
                if (KeyboardUtils.a != b2) {
                    for (OnSoftInputChangedListener onSoftInputChangedListener2 : KeyboardUtils.c.values()) {
                        onSoftInputChangedListener2.a(b2);
                    }
                    KeyboardUtils.a = b2;
                }
            }
        });
    }

    private static int b() {
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("navigation_bar_height", "dimen", MsgBackupManager.PLATFORM_ANDROID);
        if (identifier != 0) {
            return system.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(Window window) {
        View decorView = window.getDecorView();
        if (decorView == null) {
            return a;
        }
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        int abs = Math.abs(decorView.getBottom() - rect.bottom);
        if (abs <= b()) {
            d = abs;
            return 0;
        }
        return abs - d;
    }

    public static void b(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
