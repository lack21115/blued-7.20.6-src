package com.kwad.components.ad.interstitial.aggregate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/aggregate/TransViewPager.class */
public class TransViewPager extends com.kwad.sdk.widget.d {
    private float iG;
    private int iH;
    private Map<Integer, com.kwad.components.ad.interstitial.e.c> map;

    public TransViewPager(Context context) {
        this(context, null);
    }

    public TransViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.map = new HashMap();
        this.iH = 0;
    }

    private void a(View view, View view2, float f) {
        if (this.iH == 0 && f != 0.0f) {
            float f2 = this.iG;
            if (f2 != 0.0f) {
                if (f > f2) {
                    this.iH = 1;
                } else {
                    this.iH = 2;
                }
            }
        }
        if (this.iH == 1 && view2 != null) {
            if (f > 0.5d || f <= 0.0f) {
                view2.setTranslationX((1.0f - f) * 240.0f);
            } else {
                view2.setTranslationX(240.0f * f);
            }
        }
        if (this.iH == 2 && view != null) {
            if (f > 0.5d || f < 0.0f) {
                view.setTranslationX((1.0f - f) * (-240.0f));
            } else {
                view.setTranslationX((-240.0f) * f);
            }
        }
        this.iG = f;
        if (f == 0.0f) {
            this.iH = 0;
        }
    }

    public final com.kwad.components.ad.interstitial.e.c B(int i) {
        return this.map.get(Integer.valueOf(i));
    }

    public final void a(int i, com.kwad.components.ad.interstitial.e.c cVar) {
        this.map.put(Integer.valueOf(i), cVar);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void onPageScrolled(int i, float f, int i2) {
        a(B(i), B(i + 1), f);
        super.onPageScrolled(i, f, i2);
    }
}
