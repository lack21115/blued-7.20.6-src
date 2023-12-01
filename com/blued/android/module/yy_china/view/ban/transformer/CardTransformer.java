package com.blued.android.module.yy_china.view.ban.transformer;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/ban/transformer/CardTransformer.class */
public class CardTransformer implements ViewPager.PageTransformer {
    private float a;

    public CardTransformer() {
        this.a = 0.79f;
    }

    public CardTransformer(float f) {
        this.a = 0.79f;
        this.a = f;
    }

    public void transformPage(View view, float f) {
        float width = view.getWidth();
        float f2 = this.a;
        float f3 = width * f2;
        if (f <= 0.0f) {
            view.setScaleX(f2);
            view.setScaleY(this.a);
            view.setTranslationX((-(view.getWidth() - f3)) / 2.0f);
            view.setClickable(true);
            return;
        }
        float f4 = (6.0f - f) / 6.0f;
        float f5 = (3.0f - f) / 3.0f;
        view.setTranslationX((((-view.getWidth()) * f) - ((view.getWidth() - f3) / 2.0f)) + ((view.getWidth() - f3) * (1.0f - f5) * 2.0f));
        view.setScaleX(this.a * f4);
        view.setScaleY(this.a * f4);
        view.setClickable(false);
        view.setAlpha(f5);
    }
}
