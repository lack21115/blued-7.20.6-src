package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/CompluteViewPager.class */
public class CompluteViewPager extends ViewPager {
    public CompluteViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i3 = i5;
            if (i4 >= getChildCount()) {
                break;
            }
            View childAt = getChildAt(i4);
            childAt.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredHeight = childAt.getMeasuredHeight();
            int i6 = i3;
            if (measuredHeight > i3) {
                i6 = measuredHeight;
            }
            i4++;
            i5 = i6;
        }
        if (i3 > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        }
        super.onMeasure(i, i2);
    }
}
