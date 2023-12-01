package com.blued.android.module.live_china.mine;

import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/PagerGridSmoothScroller.class */
public class PagerGridSmoothScroller extends LinearSmoothScroller {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f13877a;

    public PagerGridSmoothScroller(RecyclerView recyclerView) {
        super(recyclerView.getContext());
        this.f13877a = recyclerView;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return PagerConfig.b() / displayMetrics.densityDpi;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        RecyclerView.LayoutManager layoutManager = this.f13877a.getLayoutManager();
        if (layoutManager != null && (layoutManager instanceof PagerGridLayoutManager)) {
            int[] a2 = ((PagerGridLayoutManager) layoutManager).a(this.f13877a.getChildAdapterPosition(view));
            int i = a2[0];
            int i2 = a2[1];
            int calculateTimeForScrolling = calculateTimeForScrolling(Math.max(Math.abs(i), Math.abs(i2)));
            if (calculateTimeForScrolling > 0) {
                action.update(i, i2, calculateTimeForScrolling, this.mDecelerateInterpolator);
            }
        }
    }
}
