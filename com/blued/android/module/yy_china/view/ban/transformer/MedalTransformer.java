package com.blued.android.module.yy_china.view.ban.transformer;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/ban/transformer/MedalTransformer.class */
public class MedalTransformer implements ViewPager.PageTransformer {
    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f) {
        if (f >= 1.0f || f <= -1.0f) {
            view.setScaleY(0.8f);
            view.setScaleX(0.8f);
        } else if (f < 0.0f) {
            float f2 = ((f + 1.0f) * 0.19999999f) + 0.8f;
            view.setScaleY(f2);
            view.setScaleX(f2);
        } else {
            float f3 = ((1.0f - f) * 0.19999999f) + 0.8f;
            view.setScaleY(f3);
            view.setScaleX(f3);
        }
    }
}
