package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

/* loaded from: source-8110460-dex2jar.jar:com/google/android/material/navigationrail/NavigationRailMenuView.class */
public class NavigationRailMenuView extends NavigationBarMenuView {
    private int itemMinimumHeight;
    private final FrameLayout.LayoutParams layoutParams;

    public NavigationRailMenuView(Context context) {
        super(context);
        this.itemMinimumHeight = -1;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.layoutParams = layoutParams;
        layoutParams.gravity = 49;
        setLayoutParams(this.layoutParams);
        setItemActiveIndicatorResizeable(true);
    }

    private int makeSharedHeightSpec(int i, int i2, int i3) {
        int max = i2 / Math.max(1, i3);
        int i4 = this.itemMinimumHeight;
        return View.MeasureSpec.makeMeasureSpec(Math.min(i4 != -1 ? i4 : View.MeasureSpec.getSize(i), max), 0);
    }

    private int measureChildHeight(View view, int i, int i2) {
        if (view.getVisibility() != 8) {
            view.measure(i, i2);
            return view.getMeasuredHeight();
        }
        return 0;
    }

    private int measureSharedChildHeights(int i, int i2, int i3, View view) {
        makeSharedHeightSpec(i, i2, i3);
        int makeSharedHeightSpec = view == null ? makeSharedHeightSpec(i, i2, i3) : View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            int i6 = i4;
            if (childAt != view) {
                i6 = i4 + measureChildHeight(childAt, i, makeSharedHeightSpec);
            }
            i5++;
            i4 = i6;
        }
        return i4;
    }

    private int measureShiftingChildHeights(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        View childAt = getChildAt(getSelectedItemPosition());
        if (childAt != null) {
            int measureChildHeight = measureChildHeight(childAt, i, makeSharedHeightSpec(i, i2, i3));
            int i7 = i2 - measureChildHeight;
            int i8 = i3 - 1;
            i6 = measureChildHeight;
            i5 = i7;
            i4 = i8;
        } else {
            i4 = i3;
            i5 = i2;
            i6 = 0;
        }
        return i6 + measureSharedChildHeights(i, i5, i4, childAt);
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    public NavigationBarItemView createNavigationBarItemView(Context context) {
        return new NavigationRailItemView(context);
    }

    public int getItemMinimumHeight() {
        return this.itemMinimumHeight;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMenuGravity() {
        return this.layoutParams.gravity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isTopGravity() {
        return (this.layoutParams.gravity & 112) == 48;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i5 >= childCount) {
                return;
            }
            View childAt = getChildAt(i5);
            int i8 = i7;
            if (childAt.getVisibility() != 8) {
                i8 = childAt.getMeasuredHeight() + i7;
                childAt.layout(0, i7, i3 - i, i8);
            }
            i5++;
            i6 = i8;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = getMenu().getVisibleItems().size();
        setMeasuredDimension(View.resolveSizeAndState(View.MeasureSpec.getSize(i), i, 0), View.resolveSizeAndState((size2 <= 1 || !isShifting(getLabelVisibilityMode(), size2)) ? measureSharedChildHeights(i, size, size2, null) : measureShiftingChildHeights(i, size, size2), i2, 0));
    }

    public void setItemMinimumHeight(int i) {
        if (this.itemMinimumHeight != i) {
            this.itemMinimumHeight = i;
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuGravity(int i) {
        if (this.layoutParams.gravity != i) {
            this.layoutParams.gravity = i;
            setLayoutParams(this.layoutParams);
        }
    }
}
