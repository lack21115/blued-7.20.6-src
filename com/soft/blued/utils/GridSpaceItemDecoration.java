package com.soft.blued.utils;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/GridSpaceItemDecoration.class */
public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private int f21048a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f21049c;

    public GridSpaceItemDecoration(int i, int i2, boolean z) {
        this.f21048a = i;
        this.b = i2;
        this.f21049c = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = this.f21048a;
        int i2 = childAdapterPosition % i;
        if (this.f21049c) {
            int i3 = this.b;
            rect.left = i3 - ((i2 * i3) / i);
            rect.right = ((i2 + 1) * this.b) / this.f21048a;
            if (childAdapterPosition < this.f21048a) {
                rect.top = this.b;
            }
            rect.bottom = this.b;
            return;
        }
        rect.left = (this.b * i2) / i;
        int i4 = this.b;
        rect.right = i4 - (((i2 + 1) * i4) / this.f21048a);
        if (childAdapterPosition >= this.f21048a) {
            rect.top = this.b;
        }
    }
}
