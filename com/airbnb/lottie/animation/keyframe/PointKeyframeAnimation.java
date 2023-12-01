package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/keyframe/PointKeyframeAnimation.class */
public class PointKeyframeAnimation extends KeyframeAnimation<PointF> {
    private final PointF c;

    public PointKeyframeAnimation(List<Keyframe<PointF>> list) {
        super(list);
        this.c = new PointF();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: b */
    public PointF a(Keyframe<PointF> keyframe, float f) {
        PointF pointF;
        if (keyframe.a == null || keyframe.b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = keyframe.a;
        PointF pointF3 = keyframe.b;
        if (this.b == null || (pointF = (PointF) this.b.a(keyframe.d, keyframe.e.floatValue(), pointF2, pointF3, f, d(), h())) == null) {
            this.c.set(pointF2.x + ((pointF3.x - pointF2.x) * f), pointF2.y + (f * (pointF3.y - pointF2.y)));
            return this.c;
        }
        return pointF;
    }
}
