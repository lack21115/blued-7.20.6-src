package com.soft.blued.utils;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/RecyclerViewUtil.class */
public class RecyclerViewUtil {
    public static void a(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return;
        }
        recyclerView.getItemAnimator().setAddDuration(0L);
        recyclerView.getItemAnimator().setChangeDuration(0L);
        recyclerView.getItemAnimator().setMoveDuration(0L);
        recyclerView.getItemAnimator().setRemoveDuration(0L);
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    }
}
