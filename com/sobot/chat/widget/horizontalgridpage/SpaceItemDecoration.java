package com.sobot.chat.widget.horizontalgridpage;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/horizontalgridpage/SpaceItemDecoration.class */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int leftRight;
    private int topBottom;

    public SpaceItemDecoration(int i, int i2) {
        this.leftRight = i;
        this.topBottom = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        PagerGridLayoutManager pagerGridLayoutManager = (PagerGridLayoutManager) recyclerView.getLayoutManager();
        if (pagerGridLayoutManager.getOrientation() != 0) {
            if (recyclerView.getChildAdapterPosition(view) == pagerGridLayoutManager.getItemCount() - 1) {
                rect.right = this.leftRight;
            }
            rect.top = this.topBottom;
            rect.left = this.leftRight;
            rect.bottom = this.topBottom;
            return;
        }
        if (recyclerView.getChildAdapterPosition(view) == pagerGridLayoutManager.getItemCount() - 1) {
            rect.bottom = this.topBottom;
        }
        if (recyclerView.getChildAdapterPosition(view) == 0) {
            rect.top = 0;
        } else {
            rect.top = this.topBottom;
        }
        rect.left = this.leftRight;
        rect.right = this.leftRight;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
    }
}
