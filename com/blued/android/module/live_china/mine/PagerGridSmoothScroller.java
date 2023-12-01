package com.blued.android.module.live_china.mine;

import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/PagerGridSmoothScroller.class */
public class PagerGridSmoothScroller extends LinearSmoothScroller {
    private RecyclerView a;

    public PagerGridSmoothScroller(RecyclerView recyclerView) {
        super(recyclerView.getContext());
        this.a = recyclerView;
    }

    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return PagerConfig.b() / displayMetrics.densityDpi;
    }

    public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        RecyclerView.LayoutManager layoutManager = this.a.getLayoutManager();
        if (layoutManager != null && (layoutManager instanceof PagerGridLayoutManager)) {
            int[] a = ((PagerGridLayoutManager) layoutManager).a(this.a.getChildAdapterPosition(view));
            int i = a[0];
            int i2 = a[1];
            int calculateTimeForScrolling = calculateTimeForScrolling(Math.max(Math.abs(i), Math.abs(i2)));
            if (calculateTimeForScrolling > 0) {
                action.update(i, i2, calculateTimeForScrolling, this.mDecelerateInterpolator);
            }
        }
    }
}
