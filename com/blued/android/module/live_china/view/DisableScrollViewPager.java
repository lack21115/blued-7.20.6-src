package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/DisableScrollViewPager.class */
public class DisableScrollViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private boolean f14253a;

    public DisableScrollViewPager(Context context) {
        super(context);
        this.f14253a = false;
    }

    public DisableScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14253a = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f14253a) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f14253a) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }
}
