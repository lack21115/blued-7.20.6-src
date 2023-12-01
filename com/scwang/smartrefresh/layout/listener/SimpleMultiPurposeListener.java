package com.scwang.smartrefresh.layout.listener;

import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;

/* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/listener/SimpleMultiPurposeListener.class */
public class SimpleMultiPurposeListener implements OnMultiPurposeListener {
    @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
    public void a(RefreshFooter refreshFooter, int i, int i2) {
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
    public void a(RefreshFooter refreshFooter, boolean z) {
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
    public void a(RefreshFooter refreshFooter, boolean z, float f, int i, int i2, int i3) {
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
    public void a(RefreshHeader refreshHeader, int i, int i2) {
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
    public void a(RefreshHeader refreshHeader, boolean z) {
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
    public void a(RefreshHeader refreshHeader, boolean z, float f, int i, int i2, int i3) {
    }

    public void a(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
    public void b(RefreshFooter refreshFooter, int i, int i2) {
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
    public void b(RefreshHeader refreshHeader, int i, int i2) {
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
    public void onLoadMore(RefreshLayout refreshLayout) {
    }

    public void onRefresh(RefreshLayout refreshLayout) {
    }
}
