package com.web.library.groups.webviewsdk.photoview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* loaded from: source-8829756-dex2jar.jar:com/web/library/groups/webviewsdk/photoview/HackyViewPager.class */
public class HackyViewPager extends ViewPager {
    private boolean isLocked;

    public HackyViewPager(Context context) {
        super(context);
        this.isLocked = false;
    }

    public HackyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isLocked = false;
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.isLocked) {
            return false;
        }
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isLocked) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setLocked(boolean z) {
        this.isLocked = z;
    }

    public void toggleLock() {
        this.isLocked = !this.isLocked;
    }
}
