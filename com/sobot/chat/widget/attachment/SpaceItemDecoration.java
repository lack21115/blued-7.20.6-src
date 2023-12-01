package com.sobot.chat.widget.attachment;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/attachment/SpaceItemDecoration.class */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    public static final int GRIDLAYOUT = 1;
    public static final int LINEARLAYOUT = 0;
    public static final int STAGGEREDGRIDLAYOUT = 2;
    private int headItemCount;
    private boolean includeEdge;
    private int layoutManager;
    private int leftRight;
    private int space;
    private int spanCount;
    private int topBottom;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/attachment/SpaceItemDecoration$LayoutManager.class */
    public @interface LayoutManager {
        int type() default 0;
    }

    public SpaceItemDecoration(int i, int i2) {
        this(i, 0, true, i2);
    }

    public SpaceItemDecoration(int i, int i2, int i3) {
        this(i, i2, true, i3);
    }

    public SpaceItemDecoration(int i, int i2, int i3, int i4) {
        this.leftRight = i;
        this.topBottom = i2;
        this.headItemCount = i3;
        this.layoutManager = i4;
    }

    public SpaceItemDecoration(int i, int i2, boolean z, int i3) {
        this.space = i;
        this.headItemCount = i2;
        this.includeEdge = z;
        this.layoutManager = i3;
    }

    public SpaceItemDecoration(int i, boolean z, int i2) {
        this(i, 0, z, i2);
    }

    private void setGridLayoutSpaceItemDecoration(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        int itemCount = gridLayoutManager.getItemCount();
        int spanCount = itemCount % gridLayoutManager.getSpanCount();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (gridLayoutManager.getOrientation() != 1) {
            if (spanCount == 0 && childAdapterPosition > (itemCount - gridLayoutManager.getSpanCount()) - 1) {
                rect.right = this.leftRight;
            } else if (spanCount != 0 && childAdapterPosition > (itemCount - spanCount) - 1) {
                rect.right = this.leftRight;
            }
            if ((childAdapterPosition + 1) % gridLayoutManager.getSpanCount() == 0) {
                rect.bottom = this.topBottom;
            }
            rect.top = this.topBottom;
            rect.left = this.leftRight;
            return;
        }
        if (spanCount == 0 && childAdapterPosition > (itemCount - gridLayoutManager.getSpanCount()) - 1) {
            rect.bottom = this.topBottom;
        } else if (spanCount != 0 && childAdapterPosition > (itemCount - spanCount) - 1) {
            rect.bottom = this.topBottom;
        }
        int i = this.headItemCount;
        gridLayoutManager.getSpanCount();
        rect.top = this.topBottom;
        rect.left = this.leftRight / 2;
        rect.right = this.leftRight / 2;
    }

    private void setGridlayoutSpaceItemDecorition2(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        int itemCount = gridLayoutManager.getItemCount();
        int spanCount = gridLayoutManager.getSpanCount();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition < this.spanCount) {
            rect.top = 0;
        } else {
            rect.top = this.topBottom / 2;
        }
        if (childAdapterPosition % this.spanCount == 0) {
            rect.left = 0;
        } else {
            rect.left = this.leftRight / 2;
        }
        if ((childAdapterPosition + 1) % this.spanCount == 0) {
            rect.right = 0;
        } else {
            rect.right = this.leftRight / 2;
        }
        if (childAdapterPosition >= itemCount - (itemCount % spanCount)) {
            rect.bottom = 0;
        } else {
            rect.bottom = this.topBottom;
        }
    }

    private void setLinearLayoutSpaceItemDecoration(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.left = this.space;
        rect.right = this.space;
        rect.bottom = this.space;
        if (recyclerView.getChildLayoutPosition(view) == 0) {
            rect.top = this.space;
        } else {
            rect.top = 0;
        }
    }

    private void setNGridLayoutSpaceItemDecoration(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = this.headItemCount;
        int i2 = childAdapterPosition - i;
        if (i == 0 || i2 != (-i)) {
            int i3 = this.spanCount;
            int i4 = i2 % i3;
            if (this.includeEdge) {
                int i5 = this.space;
                rect.left = i5 - ((i4 * i5) / i3);
                rect.right = ((i4 + 1) * this.space) / this.spanCount;
                if (i2 < this.spanCount) {
                    rect.top = this.space;
                }
                rect.bottom = this.space;
                return;
            }
            rect.left = (this.space * i4) / i3;
            int i6 = this.space;
            rect.right = i6 - (((i4 + 1) * i6) / this.spanCount);
            if (i2 >= this.spanCount) {
                rect.top = this.space;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i = this.layoutManager;
        if (i == 0) {
            setLinearLayoutSpaceItemDecoration(rect, view, recyclerView, state);
        } else if (i == 1) {
            this.spanCount = ((GridLayoutManager) recyclerView.getLayoutManager()).getSpanCount();
            setGridlayoutSpaceItemDecorition2(rect, view, recyclerView, state);
        } else if (i != 2) {
        } else {
            this.spanCount = ((StaggeredGridLayoutManager) recyclerView.getLayoutManager()).getSpanCount();
            setNGridLayoutSpaceItemDecoration(rect, view, recyclerView, state);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
    }
}
