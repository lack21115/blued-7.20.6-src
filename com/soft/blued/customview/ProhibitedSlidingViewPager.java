package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/ProhibitedSlidingViewPager.class */
public class ProhibitedSlidingViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14785a = ProhibitedSlidingViewPager.class.getSimpleName();
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private SwipeDirection f14786c;
    private int d;
    private ILastPageScrollToRightListener e;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/ProhibitedSlidingViewPager$ILastPageScrollToRightListener.class */
    public interface ILastPageScrollToRightListener {
        boolean a();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/ProhibitedSlidingViewPager$SwipeDirection.class */
    public enum SwipeDirection {
        all,
        left,
        right,
        none
    }

    public ProhibitedSlidingViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14786c = SwipeDirection.all;
        addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.customview.ProhibitedSlidingViewPager.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                ProhibitedSlidingViewPager.this.d = i;
            }
        });
    }

    private boolean a(MotionEvent motionEvent) {
        if (this.f14786c == SwipeDirection.all) {
            return true;
        }
        if (this.f14786c == SwipeDirection.none) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.b = motionEvent.getX();
            return true;
        } else if (motionEvent.getAction() == 2) {
            try {
                float x = motionEvent.getX() - this.b;
                if (x > 0.0f) {
                    return this.f14786c != SwipeDirection.right;
                } else if (x < 0.0f) {
                    if (this.f14786c == SwipeDirection.left) {
                        return false;
                    }
                    if (this.d != getAdapter().getCount() - 1 || this.e == null) {
                        return true;
                    }
                    return this.e.a();
                } else {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        } else {
            return true;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (a(motionEvent)) {
            try {
                return super.onInterceptTouchEvent(motionEvent);
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (a(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setAllowedSwipeDirection(SwipeDirection swipeDirection) {
        this.f14786c = swipeDirection;
    }

    public void setLastPageToRightListener(ILastPageScrollToRightListener iLastPageScrollToRightListener) {
        this.e = iLastPageScrollToRightListener;
    }
}
