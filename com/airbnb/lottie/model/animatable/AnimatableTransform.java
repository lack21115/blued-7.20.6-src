package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ModifierContent;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/animatable/AnimatableTransform.class */
public class AnimatableTransform implements ModifierContent, ContentModel {
    private final AnimatablePathValue a;
    private final AnimatableValue<PointF, PointF> b;
    private final AnimatableScaleValue c;
    private final AnimatableFloatValue d;
    private final AnimatableIntegerValue e;
    private final AnimatableFloatValue f;
    private final AnimatableFloatValue g;
    private final AnimatableFloatValue h;
    private final AnimatableFloatValue i;

    public AnimatableTransform() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public AnimatableTransform(AnimatablePathValue animatablePathValue, AnimatableValue<PointF, PointF> animatableValue, AnimatableScaleValue animatableScaleValue, AnimatableFloatValue animatableFloatValue, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, AnimatableFloatValue animatableFloatValue4, AnimatableFloatValue animatableFloatValue5) {
        this.a = animatablePathValue;
        this.b = animatableValue;
        this.c = animatableScaleValue;
        this.d = animatableFloatValue;
        this.e = animatableIntegerValue;
        this.h = animatableFloatValue2;
        this.i = animatableFloatValue3;
        this.f = animatableFloatValue4;
        this.g = animatableFloatValue5;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return null;
    }

    public AnimatablePathValue a() {
        return this.a;
    }

    public AnimatableValue<PointF, PointF> b() {
        return this.b;
    }

    public AnimatableScaleValue c() {
        return this.c;
    }

    public AnimatableFloatValue d() {
        return this.d;
    }

    public AnimatableIntegerValue e() {
        return this.e;
    }

    public AnimatableFloatValue f() {
        return this.h;
    }

    public AnimatableFloatValue g() {
        return this.i;
    }

    public AnimatableFloatValue h() {
        return this.f;
    }

    public AnimatableFloatValue i() {
        return this.g;
    }

    public TransformKeyframeAnimation j() {
        return new TransformKeyframeAnimation(this);
    }
}
