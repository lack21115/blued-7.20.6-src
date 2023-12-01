package com.blued.android.module.shortvideo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/widget/StvHackyViewPager.class */
public class StvHackyViewPager extends ViewPager {
    public StvHackyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public void a() {
        setPageMargin(DensityUtils.a(AppInfo.d(), 20.0f));
        setBackgroundColor(-16777216);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            return false;
        }
    }

    public void setAlpha(int i) {
        getBackground().setAlpha(i);
    }
}
