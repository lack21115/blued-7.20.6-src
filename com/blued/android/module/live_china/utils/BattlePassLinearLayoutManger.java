package com.blued.android.module.live_china.utils;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/BattlePassLinearLayoutManger.class */
public final class BattlePassLinearLayoutManger extends LinearLayoutManager {
    private float a;
    private Context b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BattlePassLinearLayoutManger(Context context, int i, boolean z) {
        super(context, i, z);
        Intrinsics.e(context, "context");
        this.a = 0.03f;
        this.b = context;
    }

    public final void a() {
        this.a = this.b.getResources().getDisplayMetrics().density * 0.4f;
    }

    public final void b() {
        this.a = this.b.getResources().getDisplayMetrics().density * 0.08f;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        Intrinsics.e(recyclerView, "recyclerView");
        Intrinsics.e(state, "state");
        final Context context = recyclerView.getContext();
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(context) { // from class: com.blued.android.module.live_china.utils.BattlePassLinearLayoutManger$smoothScrollToPosition$linearSmoothScroller$1
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                float f;
                Intrinsics.e(displayMetrics, "displayMetrics");
                f = BattlePassLinearLayoutManger.this.a;
                return f / displayMetrics.density;
            }

            public PointF computeScrollVectorForPosition(int i2) {
                return BattlePassLinearLayoutManger.this.computeScrollVectorForPosition(i2);
            }
        };
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll((RecyclerView.SmoothScroller) linearSmoothScroller);
    }
}
