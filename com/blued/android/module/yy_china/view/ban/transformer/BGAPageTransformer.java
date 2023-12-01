package com.blued.android.module.yy_china.view.ban.transformer;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/ban/transformer/BGAPageTransformer.class */
public abstract class BGAPageTransformer implements ViewPager.PageTransformer {
    public static BGAPageTransformer a(int i) {
        return new DefaultPageTransformer();
    }

    public abstract void a(View view, float f);

    public abstract void b(View view, float f);

    public abstract void c(View view, float f);

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f) {
        if (f < -1.0f) {
            a(view, f);
        } else if (f <= 0.0f) {
            b(view, f);
        } else if (f <= 1.0f) {
            c(view, f);
        } else {
            a(view, f);
        }
    }
}
