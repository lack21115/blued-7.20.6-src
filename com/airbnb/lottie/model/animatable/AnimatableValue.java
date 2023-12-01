package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/animatable/AnimatableValue.class */
public interface AnimatableValue<K, A> {
    BaseKeyframeAnimation<K, A> a();

    boolean b();

    List<Keyframe<K>> c();
}
