package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.SplitDimensionPathKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/animatable/AnimatableSplitDimensionPathValue.class */
public class AnimatableSplitDimensionPathValue implements AnimatableValue<PointF, PointF> {
    private final AnimatableFloatValue a;
    private final AnimatableFloatValue b;

    public AnimatableSplitDimensionPathValue(AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2) {
        this.a = animatableFloatValue;
        this.b = animatableFloatValue2;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<PointF, PointF> a() {
        return new SplitDimensionPathKeyframeAnimation(this.a.a(), this.b.a());
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public boolean b() {
        return this.a.b() && this.b.b();
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public List<Keyframe<PointF>> c() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }
}
