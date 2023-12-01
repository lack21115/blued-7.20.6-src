package com.anythink.expressad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/widget/FeedbackRadioGroup.class */
public class FeedbackRadioGroup extends RadioGroup {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5943a = "FeedbackRadioGroup";

    public FeedbackRadioGroup(Context context) {
        super(context);
    }

    public FeedbackRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i7 = 0;
        int i8 = 0;
        while (i7 < childCount) {
            View childAt = getChildAt(i7);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            if (marginLayoutParams.leftMargin + paddingLeft + childAt.getMeasuredWidth() + marginLayoutParams.rightMargin + getPaddingRight() > i3 - i) {
                int paddingLeft2 = getPaddingLeft();
                paddingTop += i8;
                i6 = getChildAt(i7).getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                i5 = paddingLeft2;
            } else {
                int max = Math.max(i8, childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
                i5 = paddingLeft;
                i6 = max;
            }
            int i9 = marginLayoutParams.leftMargin + i5;
            int i10 = marginLayoutParams.topMargin + paddingTop;
            childAt.layout(i9, i10, childAt.getMeasuredWidth() + i9, childAt.getMeasuredHeight() + i10);
            int measuredWidth = i5 + marginLayoutParams.leftMargin + childAt.getMeasuredWidth() + marginLayoutParams.rightMargin;
            i7++;
            i8 = i6;
            paddingLeft = measuredWidth;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        measureChildren(i, i2);
        int childCount = getChildCount();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int i10 = i8 + measuredWidth;
            if (getPaddingLeft() + i10 + getPaddingRight() > size) {
                i3 = Math.max(i8, i5);
                i6 += i7;
                i7 = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                Log.v(f5943a, "maxHeight:" + i6 + "---maxWidth:" + i3);
                i8 = measuredWidth;
            } else {
                i7 = Math.max(i7, childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
                i3 = i5;
                i8 = i10;
            }
            if (i9 == childCount - 1) {
                i6 += i7;
                i4 = Math.max(i8, i5);
            } else {
                i4 = i3;
            }
            i5 = i4;
        }
        setMeasuredDimension(mode == 1073741824 ? size : i5 + getPaddingLeft() + getPaddingRight(), mode2 == 1073741824 ? size2 : i6 + getPaddingTop() + getPaddingBottom());
    }
}
