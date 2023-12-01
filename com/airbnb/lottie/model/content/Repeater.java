package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RepeaterContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/content/Repeater.class */
public class Repeater implements ContentModel {
    private final String a;
    private final AnimatableFloatValue b;
    private final AnimatableFloatValue c;
    private final AnimatableTransform d;
    private final boolean e;

    public Repeater(String str, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableTransform animatableTransform, boolean z) {
        this.a = str;
        this.b = animatableFloatValue;
        this.c = animatableFloatValue2;
        this.d = animatableTransform;
        this.e = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new RepeaterContent(lottieDrawable, baseLayer, this);
    }

    public String a() {
        return this.a;
    }

    public AnimatableFloatValue b() {
        return this.b;
    }

    public AnimatableFloatValue c() {
        return this.c;
    }

    public AnimatableTransform d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }
}
