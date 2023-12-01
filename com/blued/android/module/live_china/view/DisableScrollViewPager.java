package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/DisableScrollViewPager.class */
public class DisableScrollViewPager extends ViewPager {
    private boolean a;

    public DisableScrollViewPager(Context context) {
        super(context);
        this.a = false;
    }

    public DisableScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
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
        return true;
    }
}
