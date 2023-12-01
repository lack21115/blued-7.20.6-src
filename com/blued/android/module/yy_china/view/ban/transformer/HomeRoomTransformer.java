package com.blued.android.module.yy_china.view.ban.transformer;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/ban/transformer/HomeRoomTransformer.class */
public class HomeRoomTransformer implements ViewPager.PageTransformer {

    /* renamed from: a  reason: collision with root package name */
    private float f18619a = 0.8f;

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f) {
        float width = (view.getWidth() * (1.0f - this.f18619a)) / 2.0f;
        float height = (view.getHeight() * (1.0f - this.f18619a)) / 2.0f;
        if (f < 0.0f) {
            view.setAlpha(0.0f);
            view.setClickable(false);
        }
        int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        if (i == 0) {
            view.setTranslationX(-width);
            view.setTranslationY(height);
            view.setScaleX(this.f18619a);
            view.setScaleY(this.f18619a);
            view.setClickable(true);
        }
        if (i > 0 && f <= 1.0f) {
            float f2 = 1.0f - f;
            view.setTranslationX(((width - view.getWidth()) + (view.getWidth() * f2)) - ((width * 2.0f) * f2));
            view.setTranslationY((1.0f - (f * 2.0f)) * height);
            view.setScaleX(this.f18619a);
            view.setScaleY(this.f18619a);
            view.setClickable(false);
        }
        if (f > 1.0f) {
            float f3 = 2.0f - f;
            view.setTranslationX(((-view.getWidth()) * 2) + (view.getWidth() * f3) + width);
            view.setTranslationY(-height);
            view.setAlpha(f3);
            view.setScaleX(this.f18619a);
            view.setScaleY(this.f18619a);
            view.setClickable(false);
        }
    }
}
