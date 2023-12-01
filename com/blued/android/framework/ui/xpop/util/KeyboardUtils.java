package com.blued.android.framework.ui.xpop.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.provider.Settings;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import java.util.HashMap;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/util/KeyboardUtils.class */
public final class KeyboardUtils {

    /* renamed from: a  reason: collision with root package name */
    public static int f10015a;
    private static ViewTreeObserver.OnGlobalLayoutListener b;

    /* renamed from: c  reason: collision with root package name */
    private static HashMap<View, OnSoftInputChangedListener> f10016c = new HashMap<>();
    private static int d = 0;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/util/KeyboardUtils$OnSoftInputChangedListener.class */
    public interface OnSoftInputChangedListener {
        void a(int i);
    }

    private KeyboardUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void a(View view) {
        ((InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(view, 2);
    }

    public static void a(View view, BasePopupView basePopupView) {
        View findViewById;
        b = null;
        if (view == null || (findViewById = view.findViewById(16908290)) == null) {
            return;
        }
        findViewById.getViewTreeObserver().removeGlobalOnLayoutListener(b);
        f10016c.remove(basePopupView);
    }

    public static void a(final Window window, BasePopupView basePopupView, OnSoftInputChangedListener onSoftInputChangedListener) {
        if ((window.getAttributes().flags & 512) != 0) {
            window.clearFlags(512);
        }
        FrameLayout frameLayout = (FrameLayout) window.findViewById(16908290);
        f10015a = b(window);
        f10016c.put(basePopupView, onSoftInputChangedListener);
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.blued.android.framework.ui.xpop.util.KeyboardUtils.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int b2 = KeyboardUtils.b(Window.this);
                if (KeyboardUtils.f10015a != b2) {
                    for (OnSoftInputChangedListener onSoftInputChangedListener2 : KeyboardUtils.f10016c.values()) {
                        onSoftInputChangedListener2.a(b2);
                    }
                    KeyboardUtils.f10015a = b2;
                }
            }
        });
    }

    private static int b() {
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier(Settings.System.NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (identifier != 0) {
            return system.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(Window window) {
        View decorView = window.getDecorView();
        if (decorView == null) {
            return f10015a;
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
        ((InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
