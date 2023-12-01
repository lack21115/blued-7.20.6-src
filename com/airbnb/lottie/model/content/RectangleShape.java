package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RectangleContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/content/RectangleShape.class */
public class RectangleShape implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f4356a;
    private final AnimatableValue<PointF, PointF> b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatablePointValue f4357c;
    private final AnimatableFloatValue d;
    private final boolean e;

    public RectangleShape(String str, AnimatableValue<PointF, PointF> animatableValue, AnimatablePointValue animatablePointValue, AnimatableFloatValue animatableFloatValue, boolean z) {
        this.f4356a = str;
        this.b = animatableValue;
        this.f4357c = animatablePointValue;
        this.d = animatableFloatValue;
        this.e = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new RectangleContent(lottieDrawable, baseLayer, this);
    }

    public String a() {
        return this.f4356a;
    }

    public AnimatableFloatValue b() {
        return this.d;
    }

    public AnimatablePointValue c() {
        return this.f4357c;
    }

    public AnimatableValue<PointF, PointF> d() {
        return this.b;
    }

    public boolean e() {
        return this.e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.b + ", size=" + this.f4357c + '}';
    }
}
