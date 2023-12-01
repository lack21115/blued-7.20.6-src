package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/keyframe/ColorKeyframeAnimation.class */
public class ColorKeyframeAnimation extends KeyframeAnimation<Integer> {
    public ColorKeyframeAnimation(List<Keyframe<Integer>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: b */
    public Integer a(Keyframe<Integer> keyframe, float f) {
        return Integer.valueOf(c(keyframe, f));
    }

    public int c(Keyframe<Integer> keyframe, float f) {
        Integer num;
        if (keyframe.f4418a == null || keyframe.b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = keyframe.f4418a.intValue();
        int intValue2 = keyframe.b.intValue();
        return (this.b == null || (num = (Integer) this.b.a(keyframe.d, keyframe.e.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f, d(), h())) == null) ? GammaEvaluator.a(MiscUtils.b(f, 0.0f, 1.0f), intValue, intValue2) : num.intValue();
    }

    public int i() {
        return c(c(), e());
    }
}
