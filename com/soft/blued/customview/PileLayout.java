package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.framework.utils.DensityUtils;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/PileLayout.class */
public class PileLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    protected float f14777a;
    protected float b;

    public PileLayout(Context context) {
        this(context, null, 0);
    }

    public PileLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PileLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14777a = DensityUtils.a(context, 4.0f);
        this.b = DensityUtils.a(context, 10.0f);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int max;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < childCount) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 8) {
                i5 = paddingTop;
                max = i7;
            } else {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth = marginLayoutParams.leftMargin + childAt.getMeasuredWidth() + marginLayoutParams.rightMargin;
                int i9 = paddingLeft;
                i5 = paddingTop;
                int i10 = i7;
                if (paddingLeft + measuredWidth + getPaddingRight() > i3 - i) {
                    i9 = getPaddingLeft();
                    i5 = (int) (paddingTop + i7 + this.f14777a);
                    i10 = 0;
                    i8 = 0;
                }
                childAt.layout(marginLayoutParams.leftMargin + i9, marginLayoutParams.topMargin + i5, marginLayoutParams.leftMargin + i9 + childAt.getMeasuredWidth(), marginLayoutParams.topMargin + i5 + childAt.getMeasuredHeight());
                int i11 = i9 + measuredWidth;
                int i12 = marginLayoutParams.topMargin;
                int measuredHeight = childAt.getMeasuredHeight();
                int i13 = marginLayoutParams.bottomMargin;
                int i14 = i11;
                if (i8 != childCount - 1) {
                    i14 = (int) (i11 - this.b);
                }
                max = Math.max(i10, i12 + measuredHeight + i13);
                i8++;
                paddingLeft = i14;
            }
            i6++;
            paddingTop = i5;
            i7 = max;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int childCount = getChildCount();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i12 < childCount) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() == 8) {
                i8 = i11;
                i9 = i13;
                if (i12 == childCount - 1) {
                    i8 = i11 + i10;
                    i9 = Math.max(i13, i14);
                }
                i7 = i10;
            } else {
                measureChildWithMargins(childAt, i, 0, i2, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                int i16 = i14 + measuredWidth;
                float f = i16;
                if (f - (i15 > 0 ? this.b : 0.0f) > (size - getPaddingLeft()) - getPaddingRight()) {
                    i5 = Math.max(i13, i14);
                    i6 = (int) (i11 + i10 + this.f14777a);
                    i4 = measuredWidth;
                    i7 = measuredHeight;
                    i3 = 0;
                } else {
                    if (i15 > 0) {
                        i16 = (int) (f - this.b);
                    }
                    int max = Math.max(i10, measuredHeight);
                    int i17 = i11;
                    i3 = i15;
                    i4 = i16;
                    i5 = i13;
                    i6 = i17;
                    i7 = max;
                }
                i8 = i6;
                int i18 = i5;
                if (i12 == childCount - 1) {
                    i18 = Math.max(i4, i5);
                    i8 = i6 + i7;
                }
                i15 = i3 + 1;
                i14 = i4;
                i9 = i18;
            }
            i11 = i8;
            i12++;
            i10 = i7;
            i13 = i9;
        }
        int paddingLeft = mode == 1073741824 ? size : i13 + getPaddingLeft() + getPaddingRight();
        if (mode2 != 1073741824) {
            size2 = i11 + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(paddingLeft, size2);
    }
}
