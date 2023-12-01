package com.chad.library.adapter.base.loadmore;

import com.chad.library.R;

/* loaded from: source-7206380-dex2jar.jar:com/chad/library/adapter/base/loadmore/SimpleLoadMoreView.class */
public final class SimpleLoadMoreView extends LoadMoreView {
    @Override // com.chad.library.adapter.base.loadmore.LoadMoreView
    public int a() {
        return R.layout.quick_view_load_more;
    }

    @Override // com.chad.library.adapter.base.loadmore.LoadMoreView
    protected int b() {
        return R.id.load_more_loading_view;
    }

    @Override // com.chad.library.adapter.base.loadmore.LoadMoreView
    protected int c() {
        return R.id.load_more_load_fail_view;
    }

    @Override // com.chad.library.adapter.base.loadmore.LoadMoreView
    protected int d() {
        return R.id.load_more_load_end_view;
    }
}
