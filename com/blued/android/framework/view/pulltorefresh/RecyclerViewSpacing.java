package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.blued.android.framework.utils.DensityUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/RecyclerViewSpacing.class */
public class RecyclerViewSpacing extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private int f10273a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f10274c;
    private int d = 0;
    private Context e;

    public RecyclerViewSpacing(Context context, int i, int i2) {
        a(context, i, i2, i2, 0);
    }

    private void a(Context context, int i, int i2, int i3, int i4) {
        this.e = context;
        this.f10273a = DensityUtils.a(context, i);
        this.b = DensityUtils.a(context, i2);
        this.f10274c = DensityUtils.a(context, i3);
        this.d = DensityUtils.a(this.e, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i;
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (!(recyclerView.getAdapter() instanceof BaseQuickAdapter) || childAdapterPosition >= ((BaseQuickAdapter) recyclerView.getAdapter()).getHeaderLayoutCount()) {
            int i2 = 0;
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                i = ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
                i2 = ((StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams()).getSpanIndex();
            } else if (layoutManager instanceof GridLayoutManager) {
                i = ((GridLayoutManager) layoutManager).getSpanCount();
                i2 = ((GridLayoutManager.LayoutParams) view.getLayoutParams()).getSpanIndex();
            } else {
                i = 1;
            }
            if (i == 1) {
                rect.left = this.b + this.d;
                rect.right = this.f10274c + this.d;
            } else if (i2 == 0) {
                rect.left = this.b + this.d;
                rect.right = this.b / 2;
            } else if (i2 == i - 1) {
                rect.left = this.b / 2;
                rect.right = this.b + this.d;
            } else {
                rect.left = this.b / 2;
                rect.right = this.b / 2;
            }
            rect.bottom = this.f10273a;
        }
    }
}
