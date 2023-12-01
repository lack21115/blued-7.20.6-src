package android.graphics;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/ColorMatrixColorFilter.class */
public class ColorMatrixColorFilter extends ColorFilter {
    private final ColorMatrix mMatrix = new ColorMatrix();

    public ColorMatrixColorFilter(ColorMatrix colorMatrix) {
        this.mMatrix.set(colorMatrix);
        update();
    }

    public ColorMatrixColorFilter(float[] fArr) {
        if (fArr.length < 20) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.mMatrix.set(fArr);
        update();
    }

    private static native long nativeColorMatrixFilter(float[] fArr);

    private void update() {
        float[] array = this.mMatrix.getArray();
        destroyFilter(this.native_instance);
        this.native_instance = nativeColorMatrixFilter(array);
    }

    public ColorMatrix getColorMatrix() {
        return this.mMatrix;
    }

    public void setColorMatrix(ColorMatrix colorMatrix) {
        if (colorMatrix == null) {
            this.mMatrix.reset();
        } else if (colorMatrix != this.mMatrix) {
            this.mMatrix.set(colorMatrix);
        }
        update();
    }

    public void setColorMatrix(float[] fArr) {
        if (fArr == null) {
            this.mMatrix.reset();
        } else if (fArr.length < 20) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            this.mMatrix.set(fArr);
        }
        update();
    }
}
