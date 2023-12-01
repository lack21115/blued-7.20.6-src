package com.scwang.smartrefresh.layout.listener;

import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;

/* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/listener/OnMultiPurposeListener.class */
public interface OnMultiPurposeListener extends OnRefreshLoadMoreListener, OnStateChangedListener {
    void a(RefreshFooter refreshFooter, int i, int i2);

    void a(RefreshFooter refreshFooter, boolean z);

    void a(RefreshFooter refreshFooter, boolean z, float f, int i, int i2, int i3);

    void a(RefreshHeader refreshHeader, int i, int i2);

    void a(RefreshHeader refreshHeader, boolean z);

    void a(RefreshHeader refreshHeader, boolean z, float f, int i, int i2, int i3);

    void b(RefreshFooter refreshFooter, int i, int i2);

    void b(RefreshHeader refreshHeader, int i, int i2);
}
