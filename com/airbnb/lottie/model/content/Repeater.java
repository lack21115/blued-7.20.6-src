package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RepeaterContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/content/Repeater.class */
public class Repeater implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f4358a;
    private final AnimatableFloatValue b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableFloatValue f4359c;
    private final AnimatableTransform d;
    private final boolean e;

    public Repeater(String str, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableTransform animatableTransform, boolean z) {
        this.f4358a = str;
        this.b = animatableFloatValue;
        this.f4359c = animatableFloatValue2;
        this.d = animatableTransform;
        this.e = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new RepeaterContent(lottieDrawable, baseLayer, this);
    }

    public String a() {
        return this.f4358a;
    }

    public AnimatableFloatValue b() {
        return this.b;
    }

    public AnimatableFloatValue c() {
        return this.f4359c;
    }

    public AnimatableTransform d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }
}
