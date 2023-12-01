package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/NoScrollH5ViewPager.class */
public class NoScrollH5ViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private boolean f14769a;

    public NoScrollH5ViewPager(Context context) {
        super(context);
        this.f14769a = false;
    }

    public NoScrollH5ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14769a = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f14769a) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f14769a) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setScroll(boolean z) {
        this.f14769a = z;
    }
}
