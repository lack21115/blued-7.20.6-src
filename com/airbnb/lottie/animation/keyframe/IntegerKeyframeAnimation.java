package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/keyframe/IntegerKeyframeAnimation.class */
public class IntegerKeyframeAnimation extends KeyframeAnimation<Integer> {
    public IntegerKeyframeAnimation(List<Keyframe<Integer>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: b */
    public Integer a(Keyframe<Integer> keyframe, float f) {
        return Integer.valueOf(c(keyframe, f));
    }

    int c(Keyframe<Integer> keyframe, float f) {
        Integer num;
        if (keyframe.a == null || keyframe.b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.b == null || (num = (Integer) this.b.a(keyframe.d, keyframe.e.floatValue(), keyframe.a, keyframe.b, f, d(), h())) == null) ? MiscUtils.a(keyframe.h(), keyframe.i(), f) : num.intValue();
    }

    public int i() {
        return c(c(), e());
    }
}
