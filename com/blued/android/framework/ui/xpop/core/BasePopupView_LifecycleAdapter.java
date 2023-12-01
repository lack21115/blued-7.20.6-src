package com.blued.android.framework.ui.xpop.core;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/core/BasePopupView_LifecycleAdapter.class */
public class BasePopupView_LifecycleAdapter implements GeneratedAdapter {
    final BasePopupView a;

    BasePopupView_LifecycleAdapter(BasePopupView basePopupView) {
        this.a = basePopupView;
    }

    public void callMethods(LifecycleOwner lifecycleOwner, Lifecycle.Event event, boolean z, MethodCallsLogger methodCallsLogger) {
        boolean z2 = methodCallsLogger != null;
        if (!z && event == Lifecycle.Event.ON_DESTROY) {
            if (!z2 || methodCallsLogger.approveCall("onDestroy", 1)) {
                this.a.onDestroy();
            }
        }
    }
}
