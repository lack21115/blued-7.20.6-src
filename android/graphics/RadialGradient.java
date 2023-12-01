package android.graphics;

import android.graphics.Shader;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/RadialGradient.class */
public class RadialGradient extends Shader {
    private static final int TYPE_COLORS_AND_POSITIONS = 1;
    private static final int TYPE_COLOR_CENTER_AND_COLOR_EDGE = 2;
    private int mCenterColor;
    private int[] mColors;
    private int mEdgeColor;
    private float[] mPositions;
    private float mRadius;
    private Shader.TileMode mTileMode;
    private int mType;
    private float mX;
    private float mY;

    public RadialGradient(float f, float f2, float f3, int i, int i2, Shader.TileMode tileMode) {
        if (f3 <= 0.0f) {
            throw new IllegalArgumentException("radius must be > 0");
        }
        this.mType = 2;
        this.mX = f;
        this.mY = f2;
        this.mRadius = f3;
        this.mCenterColor = i;
        this.mEdgeColor = i2;
        this.mTileMode = tileMode;
        init(nativeCreate2(f, f2, f3, i, i2, tileMode.nativeInt));
    }

    public RadialGradient(float f, float f2, float f3, int[] iArr, float[] fArr, Shader.TileMode tileMode) {
        if (f3 <= 0.0f) {
            throw new IllegalArgumentException("radius must be > 0");
        }
        if (iArr.length < 2) {
            throw new IllegalArgumentException("needs >= 2 number of colors");
        }
        if (fArr != null && iArr.length != fArr.length) {
            throw new IllegalArgumentException("color and position arrays must be of equal length");
        }
        this.mType = 1;
        this.mX = f;
        this.mY = f2;
        this.mRadius = f3;
        this.mColors = iArr;
        this.mPositions = fArr;
        this.mTileMode = tileMode;
        init(nativeCreate1(f, f2, f3, iArr, fArr, tileMode.nativeInt));
    }

    private static native long nativeCreate1(float f, float f2, float f3, int[] iArr, float[] fArr, int i);

    private static native long nativeCreate2(float f, float f2, float f3, int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.Shader
    public Shader copy() {
        RadialGradient radialGradient;
        switch (this.mType) {
            case 1:
                radialGradient = new RadialGradient(this.mX, this.mY, this.mRadius, (int[]) this.mColors.clone(), this.mPositions != null ? (float[]) this.mPositions.clone() : null, this.mTileMode);
                break;
            case 2:
                radialGradient = new RadialGradient(this.mX, this.mY, this.mRadius, this.mCenterColor, this.mEdgeColor, this.mTileMode);
                break;
            default:
                throw new IllegalArgumentException("RadialGradient should be created with either colors and positions or center color and edge color");
        }
        copyLocalMatrix(radialGradient);
        return radialGradient;
    }
}
