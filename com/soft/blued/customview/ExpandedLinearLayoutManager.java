package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/ExpandedLinearLayoutManager.class */
public class ExpandedLinearLayoutManager extends LinearLayoutManager {

    /* renamed from: a  reason: collision with root package name */
    private int f14725a;

    public ExpandedLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f14725a = -1;
    }

    private int[] a(RecyclerView.Recycler recycler, int i) {
        try {
            View viewForPosition = recycler.getViewForPosition(i);
            super.measureChildWithMargins(viewForPosition, 0, 0);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewForPosition.getLayoutParams();
            int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
            int i2 = layoutParams.leftMargin;
            return new int[]{decoratedMeasuredWidth + i2 + layoutParams.rightMargin, getDecoratedMeasuredHeight(viewForPosition) + layoutParams.bottomMargin + layoutParams.topMargin};
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0032, code lost:
        if (r0 < r0) goto L43;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(androidx.recyclerview.widget.RecyclerView.Recycler r5, androidx.recyclerview.widget.RecyclerView.State r6, int r7, int r8) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.customview.ExpandedLinearLayoutManager.onMeasure(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, int, int):void");
    }
}
