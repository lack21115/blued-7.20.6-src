package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.R;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullToRefreshRecyclerView.class */
public class PullToRefreshRecyclerView extends PullToRefreshBase<RecyclerView> {
    public PullToRefreshRecyclerView(Context context) {
        super(context);
    }

    public PullToRefreshRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PullToRefreshRecyclerView(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
    }

    public PullToRefreshRecyclerView(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle animationStyle) {
        super(context, mode, animationStyle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase
    /* renamed from: b */
    public RecyclerView a(Context context, AttributeSet attributeSet) {
        RecyclerView recyclerView = new RecyclerView(context, attributeSet);
        recyclerView.setId(R.id.recycler_list);
        return recyclerView;
    }

    @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase
    protected boolean d() {
        return !getRefreshableView().canScrollVertically(-1);
    }

    @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase
    protected boolean e() {
        return !getRefreshableView().canScrollVertically(1);
    }

    @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase
    public PullToRefreshBase.Orientation getPullToRefreshScrollDirection() {
        return PullToRefreshBase.Orientation.VERTICAL;
    }

    public void setRefreshEnabled(boolean z) {
        if (z) {
            setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        } else {
            setMode(PullToRefreshBase.Mode.DISABLED);
        }
    }
}
