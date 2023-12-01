package android.animation;

/* loaded from: source-9557208-dex2jar.jar:android/animation/FloatArrayEvaluator.class */
public class FloatArrayEvaluator implements TypeEvaluator<float[]> {
    private float[] mArray;

    public FloatArrayEvaluator() {
    }

    public FloatArrayEvaluator(float[] fArr) {
        this.mArray = fArr;
    }

    @Override // android.animation.TypeEvaluator
    public float[] evaluate(float f, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.mArray;
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
            fArr4[i2] = ((fArr2[i2] - f2) * f) + f2;
            i = i2 + 1;
        }
    }
}
