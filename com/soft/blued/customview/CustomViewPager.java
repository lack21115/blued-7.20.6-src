package com.soft.blued.customview;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import skin.support.widget.SkinCompatBackgroundHelper;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/CustomViewPager.class */
public class CustomViewPager extends ViewPager implements BluedSkinSupportable {

    /* renamed from: a  reason: collision with root package name */
    private Rect f14713a;
    private SkinCompatBackgroundHelper b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14714c;

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14714c = true;
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.b = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, 0);
        this.f14713a = new Rect();
    }

    public void applySkin() {
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.b;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if ((this.f14713a == null || !this.f14713a.contains((int) motionEvent.getX(), (int) motionEvent.getY())) && this.f14714c) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onTouchEvent(motionEvent);
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
        this.f14713a = rect;
    }

    public void setScrollEnable(boolean z) {
        this.f14714c = z;
    }
}
