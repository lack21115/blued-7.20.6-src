package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.ScaleXY;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/keyframe/ScaleKeyframeAnimation.class */
public class ScaleKeyframeAnimation extends KeyframeAnimation<ScaleXY> {

    /* renamed from: c  reason: collision with root package name */
    private final ScaleXY f4303c;

    public ScaleKeyframeAnimation(List<Keyframe<ScaleXY>> list) {
        super(list);
        this.f4303c = new ScaleXY();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: b */
    public ScaleXY a(Keyframe<ScaleXY> keyframe, float f) {
        ScaleXY scaleXY;
        if (keyframe.f4418a == null || keyframe.b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        ScaleXY scaleXY2 = keyframe.f4418a;
        ScaleXY scaleXY3 = keyframe.b;
        if (this.b == null || (scaleXY = (ScaleXY) this.b.a(keyframe.d, keyframe.e.floatValue(), scaleXY2, scaleXY3, f, d(), h())) == null) {
            this.f4303c.a(MiscUtils.a(scaleXY2.a(), scaleXY3.a(), f), MiscUtils.a(scaleXY2.b(), scaleXY3.b(), f));
            return this.f4303c;
        }
        return scaleXY;
    }
}
