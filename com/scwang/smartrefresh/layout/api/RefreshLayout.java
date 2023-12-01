package com.scwang.smartrefresh.layout.api;

import android.view.ViewGroup;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;

/* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/api/RefreshLayout.class */
public interface RefreshLayout {
    RefreshLayout b(RefreshHeader refreshHeader);

    RefreshLayout b(OnMultiPurposeListener onMultiPurposeListener);

    RefreshLayout c(int... iArr);

    RefreshLayout e(float f);

    RefreshLayout f(float f);

    ViewGroup getLayout();

    RefreshState getState();

    RefreshLayout h(boolean z);

    boolean i();

    RefreshLayout j();

    RefreshLayout k(boolean z);

    RefreshLayout l(boolean z);
}
