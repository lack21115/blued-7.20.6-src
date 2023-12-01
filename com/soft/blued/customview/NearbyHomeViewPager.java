package com.soft.blued.customview;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import skin.support.widget.SkinCompatBackgroundHelper;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/NearbyHomeViewPager.class */
public class NearbyHomeViewPager extends ViewPager implements BluedSkinSupportable {

    /* renamed from: a  reason: collision with root package name */
    private Rect f28458a;
    private SkinCompatBackgroundHelper b;

    public NearbyHomeViewPager(Context context) {
        super(context);
    }

    public NearbyHomeViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.b = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, 0);
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.b;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (getCurrentItem() == 0 && this.f28458a != null && this.f28458a.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.b;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a(i);
        }
    }

    public void setIgnoreRect(Rect rect) {
        this.f28458a = rect;
    }
}
