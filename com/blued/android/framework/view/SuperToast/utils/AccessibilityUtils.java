package com.blued.android.framework.view.SuperToast.utils;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/SuperToast/utils/AccessibilityUtils.class */
public class AccessibilityUtils {
    public static boolean a(View view) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService(Context.ACCESSIBILITY_SERVICE);
        if (accessibilityManager.isEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(64);
            obtain.setClassName(view.getClass().getName());
            obtain.setPackageName(view.getContext().getPackageName());
            view.dispatchPopulateAccessibilityEvent(obtain);
            accessibilityManager.sendAccessibilityEvent(obtain);
            return true;
        }
        return false;
    }
}
