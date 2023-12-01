package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/keyframe/GradientColorKeyframeAnimation.class */
public class GradientColorKeyframeAnimation extends KeyframeAnimation<GradientColor> {

    /* renamed from: c  reason: collision with root package name */
    private final GradientColor f4298c;

    public GradientColorKeyframeAnimation(List<Keyframe<GradientColor>> list) {
        super(list);
        int i = 0;
        GradientColor gradientColor = list.get(0).f4418a;
        i = gradientColor != null ? gradientColor.c() : i;
        this.f4298c = new GradientColor(new float[i], new int[i]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: b */
    public GradientColor a(Keyframe<GradientColor> keyframe, float f) {
        this.f4298c.a(keyframe.f4418a, keyframe.b, f);
        return this.f4298c;
    }
}
