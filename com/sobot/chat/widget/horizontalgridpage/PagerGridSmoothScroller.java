package com.sobot.chat.widget.horizontalgridpage;

import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.sobot.chat.utils.LogUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/horizontalgridpage/PagerGridSmoothScroller.class */
public class PagerGridSmoothScroller extends LinearSmoothScroller {
    private String TAG;
    private RecyclerView mRecyclerView;

    public PagerGridSmoothScroller(RecyclerView recyclerView) {
        super(recyclerView.getContext());
        this.TAG = "PagerGridSmoothScroller";
        this.mRecyclerView = recyclerView;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return PagerConfig.getMillisecondsPreInch() / displayMetrics.densityDpi;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager != null && (layoutManager instanceof PagerGridLayoutManager)) {
            int[] snapOffset = ((PagerGridLayoutManager) layoutManager).getSnapOffset(this.mRecyclerView.getChildAdapterPosition(view));
            int i = snapOffset[0];
            int i2 = snapOffset[1];
            LogUtils.i("dx = " + i);
            LogUtils.i("dy = " + i2);
            int calculateTimeForScrolling = calculateTimeForScrolling(Math.max(Math.abs(i), Math.abs(i2)));
            if (calculateTimeForScrolling > 0) {
                action.update(i, i2, calculateTimeForScrolling, this.mDecelerateInterpolator);
            }
        }
    }
}
