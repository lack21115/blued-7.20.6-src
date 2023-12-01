package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.framework.utils.DensityUtils;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/PagerIndicator.class */
public class PagerIndicator extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout.LayoutParams f14770a;

    public PagerIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public PagerIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.f14770a = layoutParams;
        layoutParams.setMargins(0, 0, DensityUtils.a(getContext(), 2.5f), 0);
    }

    public int getPageCount() {
        return getChildCount();
    }

    public void setCurrentPage(int i) {
        if (getChildCount() <= 0) {
            return;
        }
        int childCount = getChildCount();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= getChildCount()) {
                return;
            }
            View childAt = getChildAt(i3);
            if (i3 == i % childCount) {
                childAt.setSelected(true);
            } else {
                childAt.setSelected(false);
            }
            i2 = i3 + 1;
        }
    }

    public void setTotalPageSize(int i) {
        if (i == 1) {
            removeAllViews();
        } else if (i == getChildCount()) {
        } else {
            if (i <= getChildCount()) {
                while (getChildCount() > i) {
                    removeViewAt(getChildCount() - 1);
                }
                return;
            }
            while (getChildCount() < i) {
                ImageView imageView = new ImageView(getContext());
                imageView.setImageResource(R.drawable.pager_indicator);
                addView(imageView, this.f14770a);
            }
        }
    }
}
