package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.viewpager.widget.ViewPager;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/widget/d.class */
public class d extends ViewPager {
    private int aDm;
    private boolean aDn;

    public d(Context context) {
        super(context);
        this.aDn = false;
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDn = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.aDn) {
            return super.canScrollHorizontally(i);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        boolean z;
        if (this.aDn) {
            int x = (int) motionEvent.getX();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 2) {
                    int i = this.aDm;
                    if (getCurrentItem() == 0 && x - i > 0) {
                        parent = getParent();
                        z = false;
                    }
                }
                this.aDm = x;
                return super.dispatchTouchEvent(motionEvent);
            }
            parent = getParent();
            z = true;
            parent.requestDisallowInterceptTouchEvent(z);
            this.aDm = x;
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.aDn && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.aDn && super.onTouchEvent(motionEvent);
    }

    public void setScrollable(boolean z) {
        this.aDn = z;
    }
}
