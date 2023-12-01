package com.blued.android.module.media.selector.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/view/HackyViewPager.class */
public class HackyViewPager extends ViewPager {
    public HackyViewPager(Context context) {
        super(context);
        a();
    }

    public HackyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public void a() {
        setPageMargin(DensityUtils.a(AppInfo.d(), 20.0f));
        setBackgroundColor(View.MEASURED_STATE_MASK);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    public void setAlpha(int i) {
        getBackground().setAlpha(i);
    }
}
