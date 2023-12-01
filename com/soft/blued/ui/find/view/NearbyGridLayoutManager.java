package com.soft.blued.ui.find.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/NearbyGridLayoutManager.class */
public class NearbyGridLayoutManager extends GridLayoutManager {
    public NearbyGridLayoutManager(Context context, int i) {
        super(context, i);
    }

    public NearbyGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception e) {
        }
    }
}
