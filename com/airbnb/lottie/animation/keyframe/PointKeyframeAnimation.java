package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/keyframe/PointKeyframeAnimation.class */
public class PointKeyframeAnimation extends KeyframeAnimation<PointF> {

    /* renamed from: c  reason: collision with root package name */
    private final PointF f4302c;

    public PointKeyframeAnimation(List<Keyframe<PointF>> list) {
        super(list);
        this.f4302c = new PointF();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: b */
    public PointF a(Keyframe<PointF> keyframe, float f) {
        PointF pointF;
        if (keyframe.f4418a == null || keyframe.b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = keyframe.f4418a;
        PointF pointF3 = keyframe.b;
        if (this.b == null || (pointF = (PointF) this.b.a(keyframe.d, keyframe.e.floatValue(), pointF2, pointF3, f, d(), h())) == null) {
            this.f4302c.set(pointF2.x + ((pointF3.x - pointF2.x) * f), pointF2.y + (f * (pointF3.y - pointF2.y)));
            return this.f4302c;
        }
        return pointF;
    }
}
