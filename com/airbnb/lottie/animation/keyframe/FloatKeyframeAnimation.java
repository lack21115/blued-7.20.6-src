package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/keyframe/FloatKeyframeAnimation.class */
public class FloatKeyframeAnimation extends KeyframeAnimation<Float> {
    public FloatKeyframeAnimation(List<Keyframe<Float>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: b */
    public Float a(Keyframe<Float> keyframe, float f) {
        return Float.valueOf(c(keyframe, f));
    }

    float c(Keyframe<Float> keyframe, float f) {
        Float f2;
        if (keyframe.a == null || keyframe.b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.b == null || (f2 = (Float) this.b.a(keyframe.d, keyframe.e.floatValue(), keyframe.a, keyframe.b, f, d(), h())) == null) ? MiscUtils.a(keyframe.f(), keyframe.g(), f) : f2.floatValue();
    }

    public float i() {
        return c(c(), e());
    }
}
