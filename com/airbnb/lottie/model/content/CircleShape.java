package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.EllipseContent;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/content/CircleShape.class */
public class CircleShape implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f4335a;
    private final AnimatableValue<PointF, PointF> b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatablePointValue f4336c;
    private final boolean d;
    private final boolean e;

    public CircleShape(String str, AnimatableValue<PointF, PointF> animatableValue, AnimatablePointValue animatablePointValue, boolean z, boolean z2) {
        this.f4335a = str;
        this.b = animatableValue;
        this.f4336c = animatablePointValue;
        this.d = z;
        this.e = z2;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new EllipseContent(lottieDrawable, baseLayer, this);
    }

    public String a() {
        return this.f4335a;
    }

    public AnimatableValue<PointF, PointF> b() {
        return this.b;
    }

    public AnimatablePointValue c() {
        return this.f4336c;
    }

    public boolean d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }
}
