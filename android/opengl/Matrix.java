package android.opengl;

/* loaded from: source-9557208-dex2jar.jar:android/opengl/Matrix.class */
public class Matrix {
    private static final float[] sTemp = new float[32];

    public static void frustumM(float[] fArr, int i, float f, float f2, float f3, float f4, float f5, float f6) {
        if (f == f2) {
            throw new IllegalArgumentException("left == right");
        }
        if (f4 == f3) {
            throw new IllegalArgumentException("top == bottom");
        }
        if (f5 == f6) {
            throw new IllegalArgumentException("near == far");
        }
        if (f5 <= 0.0f) {
            throw new IllegalArgumentException("near <= 0.0f");
        }
        if (f6 <= 0.0f) {
            throw new IllegalArgumentException("far <= 0.0f");
        }
        float f7 = 1.0f / (f2 - f);
        float f8 = 1.0f / (f4 - f3);
        float f9 = 1.0f / (f5 - f6);
        fArr[i + 0] = 2.0f * f5 * f7;
        fArr[i + 5] = 2.0f * f5 * f8;
        fArr[i + 8] = (f2 + f) * f7;
        fArr[i + 9] = (f4 + f3) * f8;
        fArr[i + 10] = (f6 + f5) * f9;
        fArr[i + 14] = 2.0f * f6 * f5 * f9;
        fArr[i + 11] = -1.0f;
        fArr[i + 1] = 0.0f;
        fArr[i + 2] = 0.0f;
        fArr[i + 3] = 0.0f;
        fArr[i + 4] = 0.0f;
        fArr[i + 6] = 0.0f;
        fArr[i + 7] = 0.0f;
        fArr[i + 12] = 0.0f;
        fArr[i + 13] = 0.0f;
        fArr[i + 15] = 0.0f;
    }

    public static boolean invertM(float[] fArr, int i, float[] fArr2, int i2) {
        float f = fArr2[i2 + 0];
        float f2 = fArr2[i2 + 1];
        float f3 = fArr2[i2 + 2];
        float f4 = fArr2[i2 + 3];
        float f5 = fArr2[i2 + 4];
        float f6 = fArr2[i2 + 5];
        float f7 = fArr2[i2 + 6];
        float f8 = fArr2[i2 + 7];
        float f9 = fArr2[i2 + 8];
        float f10 = fArr2[i2 + 9];
        float f11 = fArr2[i2 + 10];
        float f12 = fArr2[i2 + 11];
        float f13 = fArr2[i2 + 12];
        float f14 = fArr2[i2 + 13];
        float f15 = fArr2[i2 + 14];
        float f16 = fArr2[i2 + 15];
        float f17 = f11 * f16;
        float f18 = f15 * f12;
        float f19 = f7 * f16;
        float f20 = f15 * f8;
        float f21 = f7 * f12;
        float f22 = f11 * f8;
        float f23 = f3 * f16;
        float f24 = f15 * f4;
        float f25 = f3 * f12;
        float f26 = f11 * f4;
        float f27 = f3 * f8;
        float f28 = f7 * f4;
        float f29 = (((f17 * f6) + (f20 * f10)) + (f21 * f14)) - (((f18 * f6) + (f19 * f10)) + (f22 * f14));
        float f30 = (((f18 * f2) + (f23 * f10)) + (f26 * f14)) - (((f17 * f2) + (f24 * f10)) + (f25 * f14));
        float f31 = (((f19 * f2) + (f24 * f6)) + (f27 * f14)) - (((f20 * f2) + (f23 * f6)) + (f28 * f14));
        float f32 = (((f22 * f2) + (f25 * f6)) + (f28 * f10)) - (((f21 * f2) + (f26 * f6)) + (f27 * f10));
        float f33 = f9 * f14;
        float f34 = f13 * f10;
        float f35 = f5 * f14;
        float f36 = f13 * f6;
        float f37 = f5 * f10;
        float f38 = f9 * f6;
        float f39 = f * f14;
        float f40 = f13 * f2;
        float f41 = f * f10;
        float f42 = f9 * f2;
        float f43 = f * f6;
        float f44 = f5 * f2;
        float f45 = (f * f29) + (f5 * f30) + (f9 * f31) + (f13 * f32);
        if (f45 == 0.0f) {
            return false;
        }
        float f46 = 1.0f / f45;
        fArr[i] = f29 * f46;
        fArr[i + 1] = f30 * f46;
        fArr[i + 2] = f31 * f46;
        fArr[i + 3] = f32 * f46;
        fArr[i + 4] = ((((f18 * f5) + (f19 * f9)) + (f22 * f13)) - (((f17 * f5) + (f20 * f9)) + (f21 * f13))) * f46;
        fArr[i + 5] = ((((f17 * f) + (f24 * f9)) + (f25 * f13)) - (((f18 * f) + (f23 * f9)) + (f26 * f13))) * f46;
        fArr[i + 6] = ((((f20 * f) + (f23 * f5)) + (f28 * f13)) - (((f19 * f) + (f24 * f5)) + (f27 * f13))) * f46;
        fArr[i + 7] = ((((f21 * f) + (f26 * f5)) + (f27 * f9)) - (((f22 * f) + (f25 * f5)) + (f28 * f9))) * f46;
        fArr[i + 8] = ((((f33 * f8) + (f36 * f12)) + (f37 * f16)) - (((f34 * f8) + (f35 * f12)) + (f38 * f16))) * f46;
        fArr[i + 9] = ((((f34 * f4) + (f39 * f12)) + (f42 * f16)) - (((f33 * f4) + (f40 * f12)) + (f41 * f16))) * f46;
        fArr[i + 10] = ((((f35 * f4) + (f40 * f8)) + (f43 * f16)) - (((f36 * f4) + (f39 * f8)) + (f44 * f16))) * f46;
        fArr[i + 11] = ((((f38 * f4) + (f41 * f8)) + (f44 * f12)) - (((f37 * f4) + (f42 * f8)) + (f43 * f12))) * f46;
        fArr[i + 12] = ((((f35 * f11) + (f38 * f15)) + (f34 * f7)) - (((f37 * f15) + (f33 * f7)) + (f36 * f11))) * f46;
        fArr[i + 13] = ((((f41 * f15) + (f33 * f3)) + (f40 * f11)) - (((f39 * f11) + (f42 * f15)) + (f34 * f3))) * f46;
        fArr[i + 14] = ((((f39 * f7) + (f44 * f15)) + (f36 * f3)) - (((f43 * f15) + (f35 * f3)) + (f40 * f7))) * f46;
        fArr[i + 15] = ((((f43 * f11) + (f37 * f3)) + (f42 * f7)) - (((f41 * f7) + (f44 * f11)) + (f38 * f3))) * f46;
        return true;
    }

    public static float length(float f, float f2, float f3) {
        return (float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
    }

    public static native void multiplyMM(float[] fArr, int i, float[] fArr2, int i2, float[] fArr3, int i3);

    public static native void multiplyMV(float[] fArr, int i, float[] fArr2, int i2, float[] fArr3, int i3);

    public static void orthoM(float[] fArr, int i, float f, float f2, float f3, float f4, float f5, float f6) {
        if (f == f2) {
            throw new IllegalArgumentException("left == right");
        }
        if (f3 == f4) {
            throw new IllegalArgumentException("bottom == top");
        }
        if (f5 == f6) {
            throw new IllegalArgumentException("near == far");
        }
        float f7 = 1.0f / (f2 - f);
        float f8 = 1.0f / (f4 - f3);
        float f9 = 1.0f / (f6 - f5);
        fArr[i + 0] = 2.0f * f7;
        fArr[i + 5] = 2.0f * f8;
        fArr[i + 10] = (-2.0f) * f9;
        fArr[i + 12] = (-(f2 + f)) * f7;
        fArr[i + 13] = (-(f4 + f3)) * f8;
        fArr[i + 14] = (-(f6 + f5)) * f9;
        fArr[i + 15] = 1.0f;
        fArr[i + 1] = 0.0f;
        fArr[i + 2] = 0.0f;
        fArr[i + 3] = 0.0f;
        fArr[i + 4] = 0.0f;
        fArr[i + 6] = 0.0f;
        fArr[i + 7] = 0.0f;
        fArr[i + 8] = 0.0f;
        fArr[i + 9] = 0.0f;
        fArr[i + 11] = 0.0f;
    }

    public static void perspectiveM(float[] fArr, int i, float f, float f2, float f3, float f4) {
        float tan = 1.0f / ((float) Math.tan(f * 0.008726646259971648d));
        float f5 = 1.0f / (f3 - f4);
        fArr[i + 0] = tan / f2;
        fArr[i + 1] = 0.0f;
        fArr[i + 2] = 0.0f;
        fArr[i + 3] = 0.0f;
        fArr[i + 4] = 0.0f;
        fArr[i + 5] = tan;
        fArr[i + 6] = 0.0f;
        fArr[i + 7] = 0.0f;
        fArr[i + 8] = 0.0f;
        fArr[i + 9] = 0.0f;
        fArr[i + 10] = (f4 + f3) * f5;
        fArr[i + 11] = -1.0f;
        fArr[i + 12] = 0.0f;
        fArr[i + 13] = 0.0f;
        fArr[i + 14] = 2.0f * f4 * f3 * f5;
        fArr[i + 15] = 0.0f;
    }

    public static void rotateM(float[] fArr, int i, float f, float f2, float f3, float f4) {
        synchronized (sTemp) {
            setRotateM(sTemp, 0, f, f2, f3, f4);
            multiplyMM(sTemp, 16, fArr, i, sTemp, 0);
            System.arraycopy(sTemp, 16, fArr, i, 16);
        }
    }

    public static void rotateM(float[] fArr, int i, float[] fArr2, int i2, float f, float f2, float f3, float f4) {
        synchronized (sTemp) {
            setRotateM(sTemp, 0, f, f2, f3, f4);
            multiplyMM(fArr, i, fArr2, i2, sTemp, 0);
        }
    }

    public static void scaleM(float[] fArr, int i, float f, float f2, float f3) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 4) {
                return;
            }
            int i4 = i + i3;
            fArr[i4] = fArr[i4] * f;
            int i5 = i4 + 4;
            fArr[i5] = fArr[i5] * f2;
            int i6 = i4 + 8;
            fArr[i6] = fArr[i6] * f3;
            i2 = i3 + 1;
        }
    }

    public static void scaleM(float[] fArr, int i, float[] fArr2, int i2, float f, float f2, float f3) {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 4) {
                return;
            }
            int i5 = i + i4;
            int i6 = i2 + i4;
            fArr[i5] = fArr2[i6] * f;
            fArr[i5 + 4] = fArr2[i6 + 4] * f2;
            fArr[i5 + 8] = fArr2[i6 + 8] * f3;
            fArr[i5 + 12] = fArr2[i6 + 12];
            i3 = i4 + 1;
        }
    }

    public static void setIdentityM(float[] fArr, int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 16) {
                break;
            }
            fArr[i + i3] = 0.0f;
            i2 = i3 + 1;
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= 16) {
                return;
            }
            fArr[i + i5] = 1.0f;
            i4 = i5 + 5;
        }
    }

    public static void setLookAtM(float[] fArr, int i, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = f4 - f;
        float f11 = f5 - f2;
        float f12 = f6 - f3;
        float length = 1.0f / length(f10, f11, f12);
        float f13 = f10 * length;
        float f14 = f11 * length;
        float f15 = f12 * length;
        float f16 = (f14 * f9) - (f15 * f8);
        float f17 = (f15 * f7) - (f13 * f9);
        float f18 = (f13 * f8) - (f14 * f7);
        float length2 = 1.0f / length(f16, f17, f18);
        float f19 = f16 * length2;
        float f20 = f17 * length2;
        float f21 = f18 * length2;
        fArr[i + 0] = f19;
        fArr[i + 1] = (f20 * f15) - (f21 * f14);
        fArr[i + 2] = -f13;
        fArr[i + 3] = 0.0f;
        fArr[i + 4] = f20;
        fArr[i + 5] = (f21 * f13) - (f19 * f15);
        fArr[i + 6] = -f14;
        fArr[i + 7] = 0.0f;
        fArr[i + 8] = f21;
        fArr[i + 9] = (f19 * f14) - (f20 * f13);
        fArr[i + 10] = -f15;
        fArr[i + 11] = 0.0f;
        fArr[i + 12] = 0.0f;
        fArr[i + 13] = 0.0f;
        fArr[i + 14] = 0.0f;
        fArr[i + 15] = 1.0f;
        translateM(fArr, i, -f, -f2, -f3);
    }

    public static void setRotateEulerM(float[] fArr, int i, float f, float f2, float f3) {
        float f4 = f * 0.017453292f;
        float f5 = f2 * 0.017453292f;
        float f6 = f3 * 0.017453292f;
        float cos = (float) Math.cos(f4);
        float sin = (float) Math.sin(f4);
        float cos2 = (float) Math.cos(f5);
        float sin2 = (float) Math.sin(f5);
        float cos3 = (float) Math.cos(f6);
        float sin3 = (float) Math.sin(f6);
        float f7 = cos * sin2;
        float f8 = sin * sin2;
        fArr[i + 0] = cos2 * cos3;
        fArr[i + 1] = (-cos2) * sin3;
        fArr[i + 2] = sin2;
        fArr[i + 3] = 0.0f;
        fArr[i + 4] = (f7 * cos3) + (cos * sin3);
        fArr[i + 5] = ((-f7) * sin3) + (cos * cos3);
        fArr[i + 6] = (-sin) * cos2;
        fArr[i + 7] = 0.0f;
        fArr[i + 8] = ((-f8) * cos3) + (sin * sin3);
        fArr[i + 9] = (f8 * sin3) + (sin * cos3);
        fArr[i + 10] = cos * cos2;
        fArr[i + 11] = 0.0f;
        fArr[i + 12] = 0.0f;
        fArr[i + 13] = 0.0f;
        fArr[i + 14] = 0.0f;
        fArr[i + 15] = 1.0f;
    }

    public static void setRotateM(float[] fArr, int i, float f, float f2, float f3, float f4) {
        fArr[i + 3] = 0.0f;
        fArr[i + 7] = 0.0f;
        fArr[i + 11] = 0.0f;
        fArr[i + 12] = 0.0f;
        fArr[i + 13] = 0.0f;
        fArr[i + 14] = 0.0f;
        fArr[i + 15] = 1.0f;
        float f5 = f * 0.017453292f;
        float sin = (float) Math.sin(f5);
        float cos = (float) Math.cos(f5);
        if (1.0f == f2 && 0.0f == f3 && 0.0f == f4) {
            fArr[i + 5] = cos;
            fArr[i + 10] = cos;
            fArr[i + 6] = sin;
            fArr[i + 9] = -sin;
            fArr[i + 1] = 0.0f;
            fArr[i + 2] = 0.0f;
            fArr[i + 4] = 0.0f;
            fArr[i + 8] = 0.0f;
            fArr[i + 0] = 1.0f;
        } else if (0.0f == f2 && 1.0f == f3 && 0.0f == f4) {
            fArr[i + 0] = cos;
            fArr[i + 10] = cos;
            fArr[i + 8] = sin;
            fArr[i + 2] = -sin;
            fArr[i + 1] = 0.0f;
            fArr[i + 4] = 0.0f;
            fArr[i + 6] = 0.0f;
            fArr[i + 9] = 0.0f;
            fArr[i + 5] = 1.0f;
        } else if (0.0f == f2 && 0.0f == f3 && 1.0f == f4) {
            fArr[i + 0] = cos;
            fArr[i + 5] = cos;
            fArr[i + 1] = sin;
            fArr[i + 4] = -sin;
            fArr[i + 2] = 0.0f;
            fArr[i + 6] = 0.0f;
            fArr[i + 8] = 0.0f;
            fArr[i + 9] = 0.0f;
            fArr[i + 10] = 1.0f;
        } else {
            float length = length(f2, f3, f4);
            float f6 = f2;
            float f7 = f3;
            float f8 = f4;
            if (1.0f != length) {
                float f9 = 1.0f / length;
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
            fArr[i + 0] = (f6 * f6 * f10) + cos;
            fArr[i + 4] = (f11 * f10) - f16;
            fArr[i + 8] = (f13 * f10) + f15;
            fArr[i + 1] = (f11 * f10) + f16;
            fArr[i + 5] = (f7 * f7 * f10) + cos;
            fArr[i + 9] = (f12 * f10) - f14;
            fArr[i + 2] = (f13 * f10) - f15;
            fArr[i + 6] = (f12 * f10) + f14;
            fArr[i + 10] = (f8 * f8 * f10) + cos;
        }
    }

    public static void translateM(float[] fArr, int i, float f, float f2, float f3) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 4) {
                return;
            }
            int i4 = i + i3;
            int i5 = i4 + 12;
            fArr[i5] = fArr[i5] + (fArr[i4] * f) + (fArr[i4 + 4] * f2) + (fArr[i4 + 8] * f3);
            i2 = i3 + 1;
        }
    }

    public static void translateM(float[] fArr, int i, float[] fArr2, int i2, float f, float f2, float f3) {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 12) {
                break;
            }
            fArr[i + i4] = fArr2[i2 + i4];
            i3 = i4 + 1;
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= 4) {
                return;
            }
            int i7 = i2 + i6;
            fArr[i + i6 + 12] = (fArr2[i7] * f) + (fArr2[i7 + 4] * f2) + (fArr2[i7 + 8] * f3) + fArr2[i7 + 12];
            i5 = i6 + 1;
        }
    }

    public static void transposeM(float[] fArr, int i, float[] fArr2, int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 4) {
                return;
            }
            int i5 = (i4 * 4) + i2;
            fArr[i4 + i] = fArr2[i5];
            fArr[i4 + 4 + i] = fArr2[i5 + 1];
            fArr[i4 + 8 + i] = fArr2[i5 + 2];
            fArr[i4 + 12 + i] = fArr2[i5 + 3];
            i3 = i4 + 1;
        }
    }
}
