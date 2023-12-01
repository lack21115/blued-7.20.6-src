package com.blued.android.module.common.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import skin.support.widget.SkinCompatBackgroundHelper;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/CustomViewPager.class */
public class CustomViewPager extends ViewPager implements BluedSkinSupportable {

    /* renamed from: a  reason: collision with root package name */
    private int f10982a;
    private Rect b;

    /* renamed from: c  reason: collision with root package name */
    private SkinCompatBackgroundHelper f10983c;

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.f10983c = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, 0);
        this.b = new Rect();
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.f10983c;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        View findViewById;
        try {
            if (this.f10982a > 0 && (findViewById = findViewById(this.f10982a)) != null) {
                if (this.b.bottom == 0) {
                    findViewById.getHitRect(this.b);
                }
                if (this.b.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    return false;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
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
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.f10983c;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a(i);
        }
    }

    public void setChildId(int i) {
        this.f10982a = i;
    }
}
