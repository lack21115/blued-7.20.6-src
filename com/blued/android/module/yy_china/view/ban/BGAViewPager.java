package com.blued.android.module.yy_china.view.ban;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/ban/BGAViewPager.class */
public class BGAViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private boolean f18617a;
    private AutoPlayDelegate b;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/ban/BGAViewPager$AutoPlayDelegate.class */
    public interface AutoPlayDelegate {
        void a(float f);
    }

    public BGAViewPager(Context context) {
        super(context);
        this.f18617a = true;
    }

    public BGAViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18617a = true;
    }

    private float getXVelocity() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mVelocityTracker");
            declaredField.setAccessible(true);
            VelocityTracker velocityTracker = (VelocityTracker) declaredField.get(this);
            Field declaredField2 = ViewPager.class.getDeclaredField("mActivePointerId");
            declaredField2.setAccessible(true);
            Field declaredField3 = ViewPager.class.getDeclaredField("mMaximumVelocity");
            declaredField3.setAccessible(true);
            velocityTracker.computeCurrentVelocity(1000, declaredField3.getInt(this));
            return VelocityTrackerCompat.getXVelocity(velocityTracker, declaredField2.getInt(this));
        } catch (Exception e) {
            return 0.0f;
        }
    }

    public void a(int i, boolean z) {
        try {
            Method declaredMethod = ViewPager.class.getDeclaredMethod("setCurrentItemInternal", Integer.TYPE, Boolean.TYPE, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, Integer.valueOf(i), Boolean.valueOf(z), true);
            ViewCompat.postInvalidateOnAnimation(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f18617a || getAdapter() == null || getAdapter().getCount() <= 0) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f18617a || getAdapter() == null || getAdapter().getCount() <= 0) {
            return false;
        }
        if (this.b == null || !(motionEvent.getAction() == 3 || motionEvent.getAction() == 1)) {
            return super.onTouchEvent(motionEvent);
        }
        this.b.a(getXVelocity());
        return false;
    }

    public void setAllowUserScrollable(boolean z) {
        this.f18617a = z;
    }

    public void setAutoPlayDelegate(AutoPlayDelegate autoPlayDelegate) {
        this.b = autoPlayDelegate;
    }

    public void setPageChangeDuration(int i) {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(this, new BGABannerScroller(getContext(), i));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
