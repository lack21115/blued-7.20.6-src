package com.airbnb.lottie.model.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.FillContent;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/content/ShapeFill.class */
public class ShapeFill implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f4362a;
    private final Path.FillType b;

    /* renamed from: c  reason: collision with root package name */
    private final String f4363c;
    private final AnimatableColorValue d;
    private final AnimatableIntegerValue e;
    private final boolean f;

    public ShapeFill(String str, boolean z, Path.FillType fillType, AnimatableColorValue animatableColorValue, AnimatableIntegerValue animatableIntegerValue, boolean z2) {
        this.f4363c = str;
        this.f4362a = z;
        this.b = fillType;
        this.d = animatableColorValue;
        this.e = animatableIntegerValue;
        this.f = z2;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new FillContent(lottieDrawable, baseLayer, this);
    }

    public String a() {
        return this.f4363c;
    }

    public AnimatableColorValue b() {
        return this.d;
    }

    public AnimatableIntegerValue c() {
        return this.e;
    }

    public Path.FillType d() {
        return this.b;
    }

    public boolean e() {
        return this.f;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f4362a + '}';
    }
}
