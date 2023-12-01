package android.animation;

import android.graphics.PointF;

/* loaded from: source-9557208-dex2jar.jar:android/animation/PointFEvaluator.class */
public class PointFEvaluator implements TypeEvaluator<PointF> {
    private PointF mPoint;

    public PointFEvaluator() {
    }

    public PointFEvaluator(PointF pointF) {
        this.mPoint = pointF;
    }

    @Override // android.animation.TypeEvaluator
    public PointF evaluate(float f, PointF pointF, PointF pointF2) {
        float f2 = pointF.x + ((pointF2.x - pointF.x) * f);
        float f3 = pointF.y + ((pointF2.y - pointF.y) * f);
        if (this.mPoint != null) {
            this.mPoint.set(f2, f3);
            return this.mPoint;
        }
        return new PointF(f2, f3);
    }
}
