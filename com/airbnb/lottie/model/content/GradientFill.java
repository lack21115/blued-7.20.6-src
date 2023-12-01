package com.airbnb.lottie.model.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.GradientFillContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/content/GradientFill.class */
public class GradientFill implements ContentModel {
    private final GradientType a;
    private final Path.FillType b;
    private final AnimatableGradientColorValue c;
    private final AnimatableIntegerValue d;
    private final AnimatablePointValue e;
    private final AnimatablePointValue f;
    private final String g;
    private final AnimatableFloatValue h;
    private final AnimatableFloatValue i;
    private final boolean j;

    public GradientFill(String str, GradientType gradientType, Path.FillType fillType, AnimatableGradientColorValue animatableGradientColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatablePointValue animatablePointValue, AnimatablePointValue animatablePointValue2, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, boolean z) {
        this.a = gradientType;
        this.b = fillType;
        this.c = animatableGradientColorValue;
        this.d = animatableIntegerValue;
        this.e = animatablePointValue;
        this.f = animatablePointValue2;
        this.g = str;
        this.h = animatableFloatValue;
        this.i = animatableFloatValue2;
        this.j = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new GradientFillContent(lottieDrawable, baseLayer, this);
    }

    public String a() {
        return this.g;
    }

    public GradientType b() {
        return this.a;
    }

    public Path.FillType c() {
        return this.b;
    }

    public AnimatableGradientColorValue d() {
        return this.c;
    }

    public AnimatableIntegerValue e() {
        return this.d;
    }

    public AnimatablePointValue f() {
        return this.e;
    }

    public AnimatablePointValue g() {
        return this.f;
    }

    public boolean h() {
        return this.j;
    }
}
