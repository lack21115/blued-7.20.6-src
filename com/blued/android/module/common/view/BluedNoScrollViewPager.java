package com.blued.android.module.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/BluedNoScrollViewPager.class */
public class BluedNoScrollViewPager extends ViewPager {
    private boolean a;

    public BluedNoScrollViewPager(Context context) {
        this(context, null);
    }

    public BluedNoScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
    }

    public void a(boolean z) {
        this.a = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.a) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.a) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setCurrentItem(int i) {
        super.setCurrentItem(i, false);
    }
}
