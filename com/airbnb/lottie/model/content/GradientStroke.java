package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.GradientStrokeContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/content/GradientStroke.class */
public class GradientStroke implements ContentModel {
    private final String a;
    private final GradientType b;
    private final AnimatableGradientColorValue c;
    private final AnimatableIntegerValue d;
    private final AnimatablePointValue e;
    private final AnimatablePointValue f;
    private final AnimatableFloatValue g;
    private final ShapeStroke.LineCapType h;
    private final ShapeStroke.LineJoinType i;
    private final float j;
    private final List<AnimatableFloatValue> k;
    private final AnimatableFloatValue l;
    private final boolean m;

    public GradientStroke(String str, GradientType gradientType, AnimatableGradientColorValue animatableGradientColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatablePointValue animatablePointValue, AnimatablePointValue animatablePointValue2, AnimatableFloatValue animatableFloatValue, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<AnimatableFloatValue> list, AnimatableFloatValue animatableFloatValue2, boolean z) {
        this.a = str;
        this.b = gradientType;
        this.c = animatableGradientColorValue;
        this.d = animatableIntegerValue;
        this.e = animatablePointValue;
        this.f = animatablePointValue2;
        this.g = animatableFloatValue;
        this.h = lineCapType;
        this.i = lineJoinType;
        this.j = f;
        this.k = list;
        this.l = animatableFloatValue2;
        this.m = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new GradientStrokeContent(lottieDrawable, baseLayer, this);
    }

    public String a() {
        return this.a;
    }

    public GradientType b() {
        return this.b;
    }

    public AnimatableGradientColorValue c() {
        return this.c;
    }

    public AnimatableIntegerValue d() {
        return this.d;
    }

    public AnimatablePointValue e() {
        return this.e;
    }

    public AnimatablePointValue f() {
        return this.f;
    }

    public AnimatableFloatValue g() {
        return this.g;
    }

    public ShapeStroke.LineCapType h() {
        return this.h;
    }

    public ShapeStroke.LineJoinType i() {
        return this.i;
    }

    public List<AnimatableFloatValue> j() {
        return this.k;
    }

    public AnimatableFloatValue k() {
        return this.l;
    }

    public float l() {
        return this.j;
    }

    public boolean m() {
        return this.m;
    }
}
