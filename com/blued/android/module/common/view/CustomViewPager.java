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
    private int a;
    private Rect b;
    private SkinCompatBackgroundHelper c;

    /* JADX WARN: Multi-variable type inference failed */
    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.c = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, 0);
        this.b = new Rect();
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.c;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        View findViewById;
        try {
            if (this.a > 0 && (findViewById = findViewById(this.a)) != null) {
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

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.c;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a(i);
        }
    }

    public void setChildId(int i) {
        this.a = i;
    }
}
