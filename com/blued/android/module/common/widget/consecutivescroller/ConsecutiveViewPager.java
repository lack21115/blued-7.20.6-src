package com.blued.android.module.common.widget.consecutivescroller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/consecutivescroller/ConsecutiveViewPager.class */
public class ConsecutiveViewPager extends ViewPager implements IConsecutiveScroller {
    private int a;

    public ConsecutiveViewPager(Context context) {
        super(context);
    }

    public ConsecutiveViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(View view) {
        view.setVerticalScrollBarEnabled(false);
        view.setHorizontalScrollBarEnabled(false);
        view.setOverScrollMode(2);
        ViewCompat.setNestedScrollingEnabled(view, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean a() {
        ViewParent parent = getParent();
        boolean z = false;
        if (parent instanceof ConsecutiveScrollerLayout) {
            ConsecutiveScrollerLayout consecutiveScrollerLayout = (ConsecutiveScrollerLayout) parent;
            z = false;
            if (consecutiveScrollerLayout.indexOfChild(this) == consecutiveScrollerLayout.getChildCount() - 1) {
                z = true;
            }
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (ScrollUtils.g(this)) {
            a(view);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).setClipToPadding(false);
            }
        }
    }

    public int getAdjustHeight() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.blued.android.module.common.widget.consecutivescroller.IConsecutiveScroller
    public View getCurrentScrollerView() {
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return this;
            }
            View childAt = getChildAt(i2);
            if (childAt.getX() == getScrollX() + getPaddingLeft()) {
                return childAt;
            }
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.module.common.widget.consecutivescroller.IConsecutiveScroller
    public List<View> getScrolledViews() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        if (childCount > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childCount) {
                    break;
                }
                arrayList.add(getChildAt(i2));
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void onMeasure(int i, int i2) {
        if (!a() || this.a <= 0) {
            super.onMeasure(i, i2);
        } else {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getDefaultSize(0, i2) - this.a, View.MeasureSpec.getMode(i2)));
        }
    }

    public void setAdjustHeight(int i) {
        if (this.a != i) {
            this.a = i;
            requestLayout();
        }
    }
}
