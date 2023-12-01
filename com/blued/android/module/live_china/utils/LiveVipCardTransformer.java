package com.blued.android.module.live_china.utils;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/LiveVipCardTransformer.class */
public final class LiveVipCardTransformer implements ViewPager.PageTransformer {

    /* renamed from: a  reason: collision with root package name */
    private final float f14196a;

    public LiveVipCardTransformer(float f) {
        this.f14196a = f;
    }

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View page, float f) {
        Intrinsics.e(page, "page");
        page.setTranslationX((-this.f14196a) * f);
        if (f == 0.0f) {
            page.setTranslationZ(0.0f);
        } else {
            page.setTranslationZ(1.0f);
        }
    }
}
