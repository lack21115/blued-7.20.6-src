package com.blued.android.core.utils.toast.config;

import android.app.Application;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/config/IToastStrategy.class */
public interface IToastStrategy {
    void a(Application application);

    void a(IToastStyle<?> iToastStyle);

    void a(CharSequence charSequence, long j, int i);
}
