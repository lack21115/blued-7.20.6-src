package android.renderscript;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/Matrix3f.class */
public class Matrix3f {
    final float[] mMat;

    public Matrix3f() {
        this.mMat = new float[9];
        loadIdentity();
    }

    public Matrix3f(float[] fArr) {
        this.mMat = new float[9];
        System.arraycopy(fArr, 0, this.mMat, 0, this.mMat.length);
    }

    public float get(int i, int i2) {
        return this.mMat[(i * 3) + i2];
    }

    public float[] getArray() {
        return this.mMat;
    }

    public void load(Matrix3f matrix3f) {
        System.arraycopy(matrix3f.getArray(), 0, this.mMat, 0, this.mMat.length);
    }

    public void loadIdentity() {
        this.mMat[0] = 1.0f;
        this.mMat[1] = 0.0f;
        this.mMat[2] = 0.0f;
        this.mMat[3] = 0.0f;
        this.mMat[4] = 1.0f;
        this.mMat[5] = 0.0f;
        this.mMat[6] = 0.0f;
        this.mMat[7] = 0.0f;
        this.mMat[8] = 1.0f;
    }

    public void loadMultiply(Matrix3f matrix3f, Matrix3f matrix3f2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                return;
            }
            float f = 0.0f;
            float f2 = 0.0f;
            float f3 = 0.0f;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < 3) {
                    float f4 = matrix3f2.get(i2, i4);
                    f += matrix3f.get(i4, 0) * f4;
                    f2 += matrix3f.get(i4, 1) * f4;
                    f3 += matrix3f.get(i4, 2) * f4;
                    i3 = i4 + 1;
                }
            }
            set(i2, 0, f);
            set(i2, 1, f2);
            set(i2, 2, f3);
            i = i2 + 1;
        }
    }

    public void loadRotate(float f) {
        loadIdentity();
        float f2 = f * 0.017453292f;
        float cos = (float) Math.cos(f2);
        float sin = (float) Math.sin(f2);
        this.mMat[0] = cos;
        this.mMat[1] = -sin;
        this.mMat[3] = sin;
        this.mMat[4] = cos;
    }

    public void loadRotate(float f, float f2, float f3, float f4) {
        float f5 = f * 0.017453292f;
        float cos = (float) Math.cos(f5);
        float sin = (float) Math.sin(f5);
        float sqrt = (float) Math.sqrt((f2 * f2) + (f3 * f3) + (f4 * f4));
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        if (sqrt == 1.0f) {
            float f9 = 1.0f / sqrt;
            f6 = f2 * f9;
            f7 = f3 * f9;
            f8 = f4 * f9;
        }
        float f10 = 1.0f - cos;
        float f11 = f6 * f7;
        float f12 = f7 * f8;
        float f13 = f8 * f6;
        float f14 = f6 * sin;
        float f15 = f7 * sin;
        float f16 = f8 * sin;
        this.mMat[0] = (f6 * f6 * f10) + cos;
        this.mMat[3] = (f11 * f10) - f16;
        this.mMat[6] = (f13 * f10) + f15;
        this.mMat[1] = (f11 * f10) + f16;
        this.mMat[4] = (f7 * f7 * f10) + cos;
        this.mMat[7] = (f12 * f10) - f14;
        this.mMat[2] = (f13 * f10) - f15;
        this.mMat[5] = (f12 * f10) + f14;
        this.mMat[8] = (f8 * f8 * f10) + cos;
    }

    public void loadScale(float f, float f2) {
        loadIdentity();
        this.mMat[0] = f;
        this.mMat[4] = f2;
    }

    public void loadScale(float f, float f2, float f3) {
        loadIdentity();
        this.mMat[0] = f;
        this.mMat[4] = f2;
        this.mMat[8] = f3;
    }

    public void loadTranslate(float f, float f2) {
        loadIdentity();
        this.mMat[6] = f;
        this.mMat[7] = f2;
    }

    public void multiply(Matrix3f matrix3f) {
        Matrix3f matrix3f2 = new Matrix3f();
        matrix3f2.loadMultiply(this, matrix3f);
        load(matrix3f2);
    }

    public void rotate(float f) {
        Matrix3f matrix3f = new Matrix3f();
        matrix3f.loadRotate(f);
        multiply(matrix3f);
    }

    public void rotate(float f, float f2, float f3, float f4) {
        Matrix3f matrix3f = new Matrix3f();
        matrix3f.loadRotate(f, f2, f3, f4);
        multiply(matrix3f);
    }

    public void scale(float f, float f2) {
        Matrix3f matrix3f = new Matrix3f();
        matrix3f.loadScale(f, f2);
        multiply(matrix3f);
    }

    public void scale(float f, float f2, float f3) {
        Matrix3f matrix3f = new Matrix3f();
        matrix3f.loadScale(f, f2, f3);
        multiply(matrix3f);
    }

    public void set(int i, int i2, float f) {
        this.mMat[(i * 3) + i2] = f;
    }

    public void translate(float f, float f2) {
        Matrix3f matrix3f = new Matrix3f();
        matrix3f.loadTranslate(f, f2);
        multiply(matrix3f);
    }

    public void transpose() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 2) {
                return;
            }
            int i3 = i2;
            while (true) {
                int i4 = i3 + 1;
                if (i4 < 3) {
                    float f = this.mMat[(i2 * 3) + i4];
                    this.mMat[(i2 * 3) + i4] = this.mMat[(i4 * 3) + i2];
                    this.mMat[(i4 * 3) + i2] = f;
                    i3 = i4;
                }
            }
            i = i2 + 1;
        }
    }
}
