package android.graphics;

import android.graphics.Shader;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/LinearGradient.class */
public class LinearGradient extends Shader {
    private static final int TYPE_COLORS_AND_POSITIONS = 1;
    private static final int TYPE_COLOR_START_AND_COLOR_END = 2;
    private int mColor0;
    private int mColor1;
    private int[] mColors;
    private float[] mPositions;
    private Shader.TileMode mTileMode;
    private int mType;
    private float mX0;
    private float mX1;
    private float mY0;
    private float mY1;

    public LinearGradient(float f, float f2, float f3, float f4, int i, int i2, Shader.TileMode tileMode) {
        this.mType = 2;
        this.mX0 = f;
        this.mY0 = f2;
        this.mX1 = f3;
        this.mY1 = f4;
        this.mColor0 = i;
        this.mColor1 = i2;
        this.mTileMode = tileMode;
        init(nativeCreate2(f, f2, f3, f4, i, i2, tileMode.nativeInt));
    }

    public LinearGradient(float f, float f2, float f3, float f4, int[] iArr, float[] fArr, Shader.TileMode tileMode) {
        if (iArr.length < 2) {
            throw new IllegalArgumentException("needs >= 2 number of colors");
        }
        if (fArr != null && iArr.length != fArr.length) {
            throw new IllegalArgumentException("color and position arrays must be of equal length");
        }
        this.mType = 1;
        this.mX0 = f;
        this.mY0 = f2;
        this.mX1 = f3;
        this.mY1 = f4;
        this.mColors = iArr;
        this.mPositions = fArr;
        this.mTileMode = tileMode;
        init(nativeCreate1(f, f2, f3, f4, iArr, fArr, tileMode.nativeInt));
    }

    private native long nativeCreate1(float f, float f2, float f3, float f4, int[] iArr, float[] fArr, int i);

    private native long nativeCreate2(float f, float f2, float f3, float f4, int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.Shader
    public Shader copy() {
        LinearGradient linearGradient;
        switch (this.mType) {
            case 1:
                linearGradient = new LinearGradient(this.mX0, this.mY0, this.mX1, this.mY1, (int[]) this.mColors.clone(), this.mPositions != null ? (float[]) this.mPositions.clone() : null, this.mTileMode);
                break;
            case 2:
                linearGradient = new LinearGradient(this.mX0, this.mY0, this.mX1, this.mY1, this.mColor0, this.mColor1, this.mTileMode);
                break;
            default:
                throw new IllegalArgumentException("LinearGradient should be created with either colors and positions or start color and end color");
        }
        copyLocalMatrix(linearGradient);
        return linearGradient;
    }
}
