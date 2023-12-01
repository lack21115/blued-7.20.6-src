package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ShapeContent;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/content/ShapePath.class */
public class ShapePath implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f4366a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableShapeValue f4367c;
    private final boolean d;

    public ShapePath(String str, int i, AnimatableShapeValue animatableShapeValue, boolean z) {
        this.f4366a = str;
        this.b = i;
        this.f4367c = animatableShapeValue;
        this.d = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new ShapeContent(lottieDrawable, baseLayer, this);
    }

    public String a() {
        return this.f4366a;
    }

    public AnimatableShapeValue b() {
        return this.f4367c;
    }

    public boolean c() {
        return this.d;
    }

    public String toString() {
        return "ShapePath{name=" + this.f4366a + ", index=" + this.b + '}';
    }
}
