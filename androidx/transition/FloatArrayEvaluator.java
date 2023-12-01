package androidx.transition;

import android.animation.TypeEvaluator;

/* loaded from: source-8756600-dex2jar.jar:androidx/transition/FloatArrayEvaluator.class */
class FloatArrayEvaluator implements TypeEvaluator<float[]> {

    /* renamed from: a  reason: collision with root package name */
    private float[] f3441a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FloatArrayEvaluator(float[] fArr) {
        this.f3441a = fArr;
    }

    @Override // android.animation.TypeEvaluator
    public float[] evaluate(float f, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.f3441a;
        float[] fArr4 = fArr3;
        if (fArr3 == null) {
            fArr4 = new float[fArr.length];
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= fArr4.length) {
                return fArr4;
            }
            float f2 = fArr[i2];
            fArr4[i2] = f2 + ((fArr2[i2] - f2) * f);
            i = i2 + 1;
        }
    }
}
