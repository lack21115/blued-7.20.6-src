package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PathKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.Collections;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/animatable/AnimatablePathValue.class */
public class AnimatablePathValue implements AnimatableValue<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final List<Keyframe<PointF>> f4328a;

    public AnimatablePathValue() {
        this.f4328a = Collections.singletonList(new Keyframe(new PointF(0.0f, 0.0f)));
    }

    public AnimatablePathValue(List<Keyframe<PointF>> list) {
        this.f4328a = list;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<PointF, PointF> a() {
        return this.f4328a.get(0).e() ? new PointKeyframeAnimation(this.f4328a) : new PathKeyframeAnimation(this.f4328a);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public boolean b() {
        boolean z = false;
        if (this.f4328a.size() == 1) {
            z = false;
            if (this.f4328a.get(0).e()) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public List<Keyframe<PointF>> c() {
        return this.f4328a;
    }
}
