package android.animation;

/* loaded from: source-9557208-dex2jar.jar:android/animation/IntArrayEvaluator.class */
public class IntArrayEvaluator implements TypeEvaluator<int[]> {
    private int[] mArray;

    public IntArrayEvaluator() {
    }

    public IntArrayEvaluator(int[] iArr) {
        this.mArray = iArr;
    }

    @Override // android.animation.TypeEvaluator
    public int[] evaluate(float f, int[] iArr, int[] iArr2) {
        int[] iArr3 = this.mArray;
        int[] iArr4 = iArr3;
        if (iArr3 == null) {
            iArr4 = new int[iArr.length];
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iArr4.length) {
                return iArr4;
            }
            int i3 = iArr[i2];
            iArr4[i2] = (int) (i3 + ((iArr2[i2] - i3) * f));
            i = i2 + 1;
        }
    }
}
