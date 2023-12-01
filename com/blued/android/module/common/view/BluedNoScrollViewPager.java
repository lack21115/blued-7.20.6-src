package com.blued.android.module.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/BluedNoScrollViewPager.class */
public class BluedNoScrollViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private boolean f10949a;

    public BluedNoScrollViewPager(Context context) {
        this(context, null);
    }

    public BluedNoScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10949a = true;
    }

    public void a(boolean z) {
        this.f10949a = z;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f10949a) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f10949a) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i) {
        super.setCurrentItem(i, false);
    }
}
