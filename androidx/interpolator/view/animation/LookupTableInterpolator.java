package androidx.interpolator.view.animation;

import android.view.animation.Interpolator;

/* loaded from: source-8756600-dex2jar.jar:androidx/interpolator/view/animation/LookupTableInterpolator.class */
abstract class LookupTableInterpolator implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f3066a;
    private final float b;

    /* JADX INFO: Access modifiers changed from: protected */
    public LookupTableInterpolator(float[] fArr) {
        this.f3066a = fArr;
        this.b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float[] fArr;
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) ((fArr.length - 1) * f), this.f3066a.length - 2);
        float f2 = min;
        float f3 = this.b;
        float f4 = (f - (f2 * f3)) / f3;
        float[] fArr2 = this.f3066a;
        return fArr2[min] + (f4 * (fArr2[min + 1] - fArr2[min]));
    }
}
