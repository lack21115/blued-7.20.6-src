package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/keyframe/PathKeyframeAnimation.class */
public class PathKeyframeAnimation extends KeyframeAnimation<PointF> {
    private final PointF c;
    private final float[] d;
    private PathKeyframe e;
    private PathMeasure f;

    public PathKeyframeAnimation(List<? extends Keyframe<PointF>> list) {
        super(list);
        this.c = new PointF();
        this.d = new float[2];
        this.f = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: b */
    public PointF a(Keyframe<PointF> keyframe, float f) {
        PointF pointF;
        PathKeyframe pathKeyframe = (PathKeyframe) keyframe;
        Path b = pathKeyframe.b();
        if (b == null) {
            return keyframe.a;
        }
        if (this.b == null || (pointF = (PointF) this.b.a(pathKeyframe.d, pathKeyframe.e.floatValue(), pathKeyframe.a, pathKeyframe.b, d(), f, h())) == null) {
            if (this.e != pathKeyframe) {
                this.f.setPath(b, false);
                this.e = pathKeyframe;
            }
            PathMeasure pathMeasure = this.f;
            pathMeasure.getPosTan(f * pathMeasure.getLength(), this.d, null);
            PointF pointF2 = this.c;
            float[] fArr = this.d;
            pointF2.set(fArr[0], fArr[1]);
            return this.c;
        }
        return pointF;
    }
}
