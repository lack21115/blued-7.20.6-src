package com.blued.android.module.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/BluedGridLayoutManager.class */
public class BluedGridLayoutManager extends GridLayoutManager {
    public BluedGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception e) {
            Log.e("GridLayoutManager", "recyclerView onLayoutChildren crash");
        }
    }

    public void scrollToPosition(int i) {
        try {
            super.scrollToPosition(i);
        } catch (Exception e) {
            Log.e("GridLayoutManager", "recyclerView scrollToPosition crash");
        }
    }

    public boolean supportsPredictiveItemAnimations() {
        return false;
    }
}
