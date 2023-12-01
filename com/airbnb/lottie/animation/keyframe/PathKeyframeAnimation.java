package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/keyframe/PathKeyframeAnimation.class */
public class PathKeyframeAnimation extends KeyframeAnimation<PointF> {

    /* renamed from: c  reason: collision with root package name */
    private final PointF f4301c;
    private final float[] d;
    private PathKeyframe e;
    private PathMeasure f;

    public PathKeyframeAnimation(List<? extends Keyframe<PointF>> list) {
        super(list);
        this.f4301c = new PointF();
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
            return keyframe.f4418a;
        }
        if (this.b == null || (pointF = (PointF) this.b.a(pathKeyframe.d, pathKeyframe.e.floatValue(), pathKeyframe.f4418a, pathKeyframe.b, d(), f, h())) == null) {
            if (this.e != pathKeyframe) {
                this.f.setPath(b, false);
                this.e = pathKeyframe;
            }
            PathMeasure pathMeasure = this.f;
            pathMeasure.getPosTan(f * pathMeasure.getLength(), this.d, null);
            PointF pointF2 = this.f4301c;
            float[] fArr = this.d;
            pointF2.set(fArr[0], fArr[1]);
            return this.f4301c;
        }
        return pointF;
    }
}
