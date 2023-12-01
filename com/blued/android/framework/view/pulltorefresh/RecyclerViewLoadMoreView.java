package com.blued.android.framework.view.pulltorefresh;

import com.blued.android.framework.R;
import com.chad.library.adapter.base.loadmore.LoadMoreView;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/RecyclerViewLoadMoreView.class */
public final class RecyclerViewLoadMoreView extends LoadMoreView {
    @Override // com.chad.library.adapter.base.loadmore.LoadMoreView
    public int a() {
        return R.layout.layout_recyclerview_load_more;
    }

    @Override // com.chad.library.adapter.base.loadmore.LoadMoreView
    public int b() {
        return R.id.load_more_loading_view;
    }

    @Override // com.chad.library.adapter.base.loadmore.LoadMoreView
    public int c() {
        return R.id.load_more_load_fail_view;
    }

    @Override // com.chad.library.adapter.base.loadmore.LoadMoreView
    public int d() {
        return 0;
    }
}
