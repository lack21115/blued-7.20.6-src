package com.blued.android.module.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/BluedLinearLayoutManager.class */
public class BluedLinearLayoutManager extends LinearLayoutManager {
    public BluedLinearLayoutManager(Context context) {
        super(context);
    }

    public BluedLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception e) {
            Log.e("LinearLayoutManager", "recyclerView crash");
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        try {
            super.scrollToPosition(i);
        } catch (Exception e) {
            Log.e("LinearLayoutManager", "recyclerView scrollToPosition crash");
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return false;
    }
}
