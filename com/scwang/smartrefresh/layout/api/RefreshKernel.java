package com.scwang.smartrefresh.layout.api;

import android.animation.ValueAnimator;
import com.scwang.smartrefresh.layout.constant.RefreshState;

/* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/api/RefreshKernel.class */
public interface RefreshKernel {
    ValueAnimator a(int i);

    RefreshKernel a(int i, boolean z);

    RefreshKernel a(RefreshInternal refreshInternal, int i);

    RefreshKernel a(RefreshInternal refreshInternal, boolean z);

    RefreshKernel a(RefreshState refreshState);

    RefreshKernel a(boolean z);

    RefreshLayout a();

    RefreshKernel b();

    RefreshKernel b(int i);
}
