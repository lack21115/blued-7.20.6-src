package com.blued.android.framework.ui.xpop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/widget/HackyViewPager.class */
public class HackyViewPager extends ViewPager {
    public HackyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
