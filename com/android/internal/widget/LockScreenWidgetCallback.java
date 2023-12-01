package com.android.internal.widget;

import android.view.View;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/LockScreenWidgetCallback.class */
public interface LockScreenWidgetCallback {
    boolean isVisible(View view);

    void requestHide(View view);

    void requestShow(View view);

    void userActivity(View view);
}
