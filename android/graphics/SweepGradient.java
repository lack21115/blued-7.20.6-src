package android.graphics;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/SweepGradient.class */
public class SweepGradient extends Shader {
    private static final int TYPE_COLORS_AND_POSITIONS = 1;
    private static final int TYPE_COLOR_START_AND_COLOR_END = 2;
    private int mColor0;
    private int mColor1;
    private int[] mColors;
    private float mCx;
    private float mCy;
    private float[] mPositions;
    private int mType;

    public SweepGradient(float f, float f2, int i, int i2) {
        this.mType = 2;
        this.mCx = f;
        this.mCy = f2;
        this.mColor0 = i;
        this.mColor1 = i2;
        init(nativeCreate2(f, f2, i, i2));
    }

    public SweepGradient(float f, float f2, int[] iArr, float[] fArr) {
        if (iArr.length < 2) {
            throw new IllegalArgumentException("needs >= 2 number of colors");
        }
        if (fArr != null && iArr.length != fArr.length) {
            throw new IllegalArgumentException("color and position arrays must be of equal length");
        }
        this.mType = 1;
        this.mCx = f;
        this.mCy = f2;
        this.mColors = iArr;
        this.mPositions = fArr;
        init(nativeCreate1(f, f2, iArr, fArr));
    }

    private static native long nativeCreate1(float f, float f2, int[] iArr, float[] fArr);

    private static native long nativeCreate2(float f, float f2, int i, int i2);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.Shader
    public Shader copy() {
        SweepGradient sweepGradient;
        switch (this.mType) {
            case 1:
                sweepGradient = new SweepGradient(this.mCx, this.mCy, (int[]) this.mColors.clone(), this.mPositions != null ? (float[]) this.mPositions.clone() : null);
                break;
            case 2:
                sweepGradient = new SweepGradient(this.mCx, this.mCy, this.mColor0, this.mColor1);
                break;
            default:
                throw new IllegalArgumentException("SweepGradient should be created with either colors and positions or start color and end color");
        }
        copyLocalMatrix(sweepGradient);
        return sweepGradient;
    }
}
