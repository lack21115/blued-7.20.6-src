package android.graphics;

import android.util.FloatMath;
import java.util.Arrays;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/ColorMatrix.class */
public class ColorMatrix {
    private final float[] mArray;

    public ColorMatrix() {
        this.mArray = new float[20];
        reset();
    }

    public ColorMatrix(ColorMatrix colorMatrix) {
        this.mArray = new float[20];
        System.arraycopy(colorMatrix.mArray, 0, this.mArray, 0, 20);
    }

    public ColorMatrix(float[] fArr) {
        this.mArray = new float[20];
        System.arraycopy(fArr, 0, this.mArray, 0, 20);
    }

    public final float[] getArray() {
        return this.mArray;
    }

    public void postConcat(ColorMatrix colorMatrix) {
        setConcat(colorMatrix, this);
    }

    public void preConcat(ColorMatrix colorMatrix) {
        setConcat(this, colorMatrix);
    }

    public void reset() {
        float[] fArr = this.mArray;
        Arrays.fill(fArr, 0.0f);
        fArr[18] = 1.0f;
        fArr[12] = 1.0f;
        fArr[6] = 1.0f;
        fArr[0] = 1.0f;
    }

    public void set(ColorMatrix colorMatrix) {
        System.arraycopy(colorMatrix.mArray, 0, this.mArray, 0, 20);
    }

    public void set(float[] fArr) {
        System.arraycopy(fArr, 0, this.mArray, 0, 20);
    }

    public void setConcat(ColorMatrix colorMatrix, ColorMatrix colorMatrix2) {
        float[] fArr = (colorMatrix == this || colorMatrix2 == this) ? new float[20] : this.mArray;
        float[] fArr2 = colorMatrix.mArray;
        float[] fArr3 = colorMatrix2.mArray;
        int i = 0;
        int i2 = 0;
        while (i2 < 20) {
            int i3 = 0;
            while (i3 < 4) {
                fArr[i] = (fArr2[i2 + 0] * fArr3[i3 + 0]) + (fArr2[i2 + 1] * fArr3[i3 + 5]) + (fArr2[i2 + 2] * fArr3[i3 + 10]) + (fArr2[i2 + 3] * fArr3[i3 + 15]);
                i3++;
                i++;
            }
            fArr[i] = (fArr2[i2 + 0] * fArr3[4]) + (fArr2[i2 + 1] * fArr3[9]) + (fArr2[i2 + 2] * fArr3[14]) + (fArr2[i2 + 3] * fArr3[19]) + fArr2[i2 + 4];
            i2 += 5;
            i++;
        }
        if (fArr != this.mArray) {
            System.arraycopy(fArr, 0, this.mArray, 0, 20);
        }
    }

    public void setRGB2YUV() {
        reset();
        float[] fArr = this.mArray;
        fArr[0] = 0.299f;
        fArr[1] = 0.587f;
        fArr[2] = 0.114f;
        fArr[5] = -0.16874f;
        fArr[6] = -0.33126f;
        fArr[7] = 0.5f;
        fArr[10] = 0.5f;
        fArr[11] = -0.41869f;
        fArr[12] = -0.08131f;
    }

    public void setRotate(int i, float f) {
        reset();
        float f2 = (3.1415927f * f) / 180.0f;
        float cos = FloatMath.cos(f2);
        float sin = FloatMath.sin(f2);
        switch (i) {
            case 0:
                float[] fArr = this.mArray;
                this.mArray[12] = cos;
                fArr[6] = cos;
                this.mArray[7] = sin;
                this.mArray[11] = -sin;
                return;
            case 1:
                float[] fArr2 = this.mArray;
                this.mArray[12] = cos;
                fArr2[0] = cos;
                this.mArray[2] = -sin;
                this.mArray[10] = sin;
                return;
            case 2:
                float[] fArr3 = this.mArray;
                this.mArray[6] = cos;
                fArr3[0] = cos;
                this.mArray[1] = sin;
                this.mArray[5] = -sin;
                return;
            default:
                throw new RuntimeException();
        }
    }

    public void setSaturation(float f) {
        reset();
        float[] fArr = this.mArray;
        float f2 = 1.0f - f;
        float f3 = 0.213f * f2;
        float f4 = 0.715f * f2;
        float f5 = 0.072f * f2;
        fArr[0] = f3 + f;
        fArr[1] = f4;
        fArr[2] = f5;
        fArr[5] = f3;
        fArr[6] = f4 + f;
        fArr[7] = f5;
        fArr[10] = f3;
        fArr[11] = f4;
        fArr[12] = f5 + f;
    }

    public void setScale(float f, float f2, float f3, float f4) {
        float[] fArr = this.mArray;
        int i = 19;
        while (true) {
            int i2 = i;
            if (i2 <= 0) {
                fArr[0] = f;
                fArr[6] = f2;
                fArr[12] = f3;
                fArr[18] = f4;
                return;
            }
            fArr[i2] = 0.0f;
            i = i2 - 1;
        }
    }

    public void setYUV2RGB() {
        reset();
        float[] fArr = this.mArray;
        fArr[2] = 1.402f;
        fArr[5] = 1.0f;
        fArr[6] = -0.34414f;
        fArr[7] = -0.71414f;
        fArr[10] = 1.0f;
        fArr[11] = 1.772f;
        fArr[12] = 0.0f;
    }
}
