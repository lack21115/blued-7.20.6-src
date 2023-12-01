package com.blued.android.module.live_china.view;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.utils.Log;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMsgLayoutManager.class */
public final class LiveMsgLayoutManager extends LinearLayoutManager {
    public LiveMsgLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("LiveMsgLayoutManager", e.getMessage());
        }
    }

    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            return super.scrollVerticallyBy(i, recycler, state);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("LiveMsgLayoutManager scroll", e.getMessage());
            return 0;
        }
    }
}
