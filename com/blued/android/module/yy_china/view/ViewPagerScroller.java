package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Field;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/ViewPagerScroller.class */
public class ViewPagerScroller extends Scroller {
    private int a;

    public ViewPagerScroller(Context context) {
        super(context);
        this.a = 2000;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(ViewPager viewPager) {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(viewPager, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4) {
        super.startScroll(i, i2, i3, i4, this.a);
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, this.a);
    }
}
