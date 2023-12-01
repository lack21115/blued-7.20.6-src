package com.blued.android.module.common.utils;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/HorizontalLooperLayoutManager.class */
public final class HorizontalLooperLayoutManager extends LinearLayoutManager {
    private boolean a;

    private final int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2;
        View viewForPosition;
        View viewForPosition2;
        if (i > 0) {
            View childAt = getChildAt(getChildCount() - 1);
            if (childAt == null) {
                return 0;
            }
            int position = getPosition(childAt);
            i2 = i;
            if (childAt.getRight() < getWidth()) {
                if (position != getItemCount() - 1) {
                    viewForPosition2 = recycler.getViewForPosition(position + 1);
                } else if (this.a) {
                    viewForPosition2 = recycler.getViewForPosition(0);
                } else {
                    viewForPosition2 = null;
                    i = 0;
                }
                if (viewForPosition2 == null) {
                    return i;
                }
                addView(viewForPosition2);
                measureChildWithMargins(viewForPosition2, 0, 0);
                layoutDecorated(viewForPosition2, childAt.getRight(), 0, childAt.getRight() + getDecoratedMeasuredWidth(viewForPosition2), getDecoratedMeasuredHeight(viewForPosition2));
                return i;
            }
        } else {
            View childAt2 = getChildAt(0);
            if (childAt2 == null) {
                return 0;
            }
            int position2 = getPosition(childAt2);
            i2 = i;
            if (childAt2.getLeft() >= 0) {
                if (position2 != 0) {
                    viewForPosition = recycler.getViewForPosition(position2 - 1);
                } else if (this.a) {
                    viewForPosition = recycler.getViewForPosition(getItemCount() - 1);
                } else {
                    viewForPosition = null;
                    i = 0;
                }
                if (viewForPosition == null) {
                    return 0;
                }
                addView(viewForPosition, 0);
                measureChildWithMargins(viewForPosition, 0, 0);
                layoutDecorated(viewForPosition, childAt2.getLeft() - getDecoratedMeasuredWidth(viewForPosition), 0, childAt2.getLeft(), getDecoratedMeasuredHeight(viewForPosition));
                i2 = i;
            }
        }
        return i2;
    }

    private final void b(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int childCount = getChildCount();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= childCount) {
                return;
            }
            View childAt = getChildAt(i3);
            if (childAt != null) {
                if (i > 0) {
                    if (childAt.getRight() < 0) {
                        removeAndRecycleView(childAt, recycler);
                    }
                } else if (childAt.getLeft() > getWidth()) {
                    removeAndRecycleView(childAt, recycler);
                }
            }
            i2 = i3 + 1;
        }
    }

    public boolean canScrollHorizontally() {
        return true;
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.e(recycler, "recycler");
        Intrinsics.e(state, "state");
        if (getItemCount() > 0 && !state.isPreLayout()) {
            detachAndScrapAttachedViews(recycler);
            int itemCount = getItemCount();
            int i = 0;
            for (int i2 = 0; i2 < itemCount; i2++) {
                View viewForPosition = recycler.getViewForPosition(i2);
                Intrinsics.c(viewForPosition, "recycler.getViewForPosition(i)");
                addView(viewForPosition);
                measureChildWithMargins(viewForPosition, 0, 0);
                int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
                int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition);
                int i3 = decoratedMeasuredWidth + i;
                layoutDecorated(viewForPosition, i, 0, i3, decoratedMeasuredHeight);
                i = i3;
            }
        }
    }

    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.e(recycler, "recycler");
        Intrinsics.e(state, "state");
        int a = a(i, recycler, state);
        if (a == 0) {
            return 0;
        }
        offsetChildrenHorizontal(-a);
        b(i, recycler, state);
        return a;
    }
}
