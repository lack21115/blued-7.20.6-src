package com.blued.android.module.common.widget.refresh;

import com.blued.android.module.common.R;
import com.chad.library.adapter.base.loadmore.LoadMoreView;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/refresh/BluedAdapterLoadMoreView.class */
public class BluedAdapterLoadMoreView extends LoadMoreView {
    @Override // com.chad.library.adapter.base.loadmore.LoadMoreView
    public int a() {
        return R.layout.layout_adapter_load_more;
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
        return R.id.load_more_load_end_view;
    }
}
