package com.blued.android.module.live_china.manager;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/ScrollSpeedLinearLayoutManger.class */
public class ScrollSpeedLinearLayoutManger extends LinearLayoutManager {
    private float a;
    private Context b;

    public ScrollSpeedLinearLayoutManger(Context context) {
        super(context);
        this.a = 0.03f;
        this.b = context;
    }

    public void a() {
        this.a = this.b.getResources().getDisplayMetrics().density * 0.6f;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: com.blued.android.module.live_china.manager.ScrollSpeedLinearLayoutManger.1
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return ScrollSpeedLinearLayoutManger.this.a / displayMetrics.density;
            }

            public PointF computeScrollVectorForPosition(int i2) {
                return ScrollSpeedLinearLayoutManger.this.computeScrollVectorForPosition(i2);
            }
        };
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }
}
