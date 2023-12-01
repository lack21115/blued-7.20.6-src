package com.soft.blued.ui.user.utils;

import android.os.Build;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/utils/PageTransformerThree.class */
public class PageTransformerThree implements ViewPager.PageTransformer {

    /* renamed from: a  reason: collision with root package name */
    private float f34332a = 0.1f;

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f) {
        view.setTranslationX((int) (view.getWidth() * this.f34332a));
        if (Build.VERSION.SDK_INT < 19) {
            view.getParent().requestLayout();
        }
    }
}
