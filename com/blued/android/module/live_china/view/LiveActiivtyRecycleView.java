package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveActiivtyRecycleView.class */
public class LiveActiivtyRecycleView extends RecyclerView {
    public LiveActiivtyRecycleView(Context context) {
        super(context);
    }

    public LiveActiivtyRecycleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }
}
