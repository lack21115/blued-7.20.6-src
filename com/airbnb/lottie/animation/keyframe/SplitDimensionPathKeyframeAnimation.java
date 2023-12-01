package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import java.util.Collections;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/keyframe/SplitDimensionPathKeyframeAnimation.class */
public class SplitDimensionPathKeyframeAnimation extends BaseKeyframeAnimation<PointF, PointF> {
    private final PointF c;
    private final BaseKeyframeAnimation<Float, Float> d;
    private final BaseKeyframeAnimation<Float, Float> e;

    public SplitDimensionPathKeyframeAnimation(BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation, BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2) {
        super(Collections.emptyList());
        this.c = new PointF();
        this.d = baseKeyframeAnimation;
        this.e = baseKeyframeAnimation2;
        a(h());
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void a(float f) {
        this.d.a(f);
        this.e.a(f);
        this.c.set(this.d.g().floatValue(), this.e.g().floatValue());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.a.size()) {
                return;
            }
            this.a.get(i2).a();
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: b */
    public PointF a(Keyframe<PointF> keyframe, float f) {
        return this.c;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: i */
    public PointF g() {
        return a(null, 0.0f);
    }
}
