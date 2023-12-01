package com.tencent.mapsdk.internal;

import android.opengl.Matrix;
import java.lang.reflect.Array;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/db.class */
public class db {
    private static boolean a(float[][] fArr, float[] fArr2) {
        int length = fArr2.length / 3;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 6) {
                return true;
            }
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i3 >= length) {
                    break;
                }
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                if ((fArr[i2][0] * fArr2[i5]) + (fArr[i2][1] * fArr2[i6]) + (fArr[i2][2] * fArr2[i7]) + fArr[i2][3] > 0.0f) {
                    break;
                }
                i3++;
                i4 = i7 + 1;
            }
            if (i3 == length) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static float[][] a(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[16];
        Matrix.multiplyMM(fArr3, 0, fArr2, 0, fArr, 0);
        float[][] fArr4 = (float[][]) Array.newInstance(Float.TYPE, 6, 4);
        fArr4[0][0] = fArr3[3] - fArr3[0];
        fArr4[0][1] = fArr3[7] - fArr3[4];
        fArr4[0][2] = fArr3[11] - fArr3[8];
        fArr4[0][3] = fArr3[15] - fArr3[12];
        double sqrt = Math.sqrt((fArr4[0][0] * fArr4[0][0]) + (fArr4[0][1] * fArr4[0][1]) + (fArr4[0][2] * fArr4[0][2]));
        float[] fArr5 = fArr4[0];
        fArr5[0] = (float) (fArr5[0] / sqrt);
        float[] fArr6 = fArr4[0];
        fArr6[1] = (float) (fArr6[1] / sqrt);
        float[] fArr7 = fArr4[0];
        fArr7[2] = (float) (fArr7[2] / sqrt);
        float[] fArr8 = fArr4[0];
        fArr8[3] = (float) (fArr8[3] / sqrt);
        fArr4[1][0] = fArr3[3] + fArr3[0];
        fArr4[1][1] = fArr3[7] + fArr3[4];
        fArr4[1][2] = fArr3[11] + fArr3[8];
        fArr4[1][3] = fArr3[15] + fArr3[12];
        double sqrt2 = Math.sqrt((fArr4[1][0] * fArr4[1][0]) + (fArr4[1][1] * fArr4[1][1]) + (fArr4[1][2] * fArr4[1][2]));
        float[] fArr9 = fArr4[1];
        fArr9[0] = (float) (fArr9[0] / sqrt2);
        float[] fArr10 = fArr4[1];
        fArr10[1] = (float) (fArr10[1] / sqrt2);
        float[] fArr11 = fArr4[1];
        fArr11[2] = (float) (fArr11[2] / sqrt2);
        float[] fArr12 = fArr4[1];
        fArr12[3] = (float) (fArr12[3] / sqrt2);
        fArr4[2][0] = fArr3[3] + fArr3[1];
        fArr4[2][1] = fArr3[7] + fArr3[5];
        fArr4[2][2] = fArr3[11] + fArr3[9];
        fArr4[2][3] = fArr3[15] + fArr3[13];
        double sqrt3 = Math.sqrt((fArr4[2][0] * fArr4[2][0]) + (fArr4[2][1] * fArr4[2][1]) + (fArr4[2][2] * fArr4[2][2]));
        float[] fArr13 = fArr4[2];
        fArr13[0] = (float) (fArr13[0] / sqrt3);
        float[] fArr14 = fArr4[2];
        fArr14[1] = (float) (fArr14[1] / sqrt3);
        float[] fArr15 = fArr4[2];
        fArr15[2] = (float) (fArr15[2] / sqrt3);
        float[] fArr16 = fArr4[2];
        fArr16[3] = (float) (fArr16[3] / sqrt3);
        fArr4[3][0] = fArr3[3] - fArr3[1];
        fArr4[3][1] = fArr3[7] - fArr3[5];
        fArr4[3][2] = fArr3[11] - fArr3[9];
        fArr4[3][3] = fArr3[15] - fArr3[13];
        double sqrt4 = Math.sqrt((fArr4[3][0] * fArr4[3][0]) + (fArr4[3][1] * fArr4[3][1]) + (fArr4[3][2] * fArr4[3][2]));
        float[] fArr17 = fArr4[3];
        fArr17[0] = (float) (fArr17[0] / sqrt4);
        float[] fArr18 = fArr4[3];
        fArr18[1] = (float) (fArr18[1] / sqrt4);
        float[] fArr19 = fArr4[3];
        fArr19[2] = (float) (fArr19[2] / sqrt4);
        float[] fArr20 = fArr4[3];
        fArr20[3] = (float) (fArr20[3] / sqrt4);
        fArr4[4][0] = fArr3[3] - fArr3[2];
        fArr4[4][1] = fArr3[7] - fArr3[6];
        fArr4[4][2] = fArr3[11] - fArr3[10];
        fArr4[4][3] = fArr3[15] - fArr3[14];
        double sqrt5 = Math.sqrt((fArr4[4][0] * fArr4[4][0]) + (fArr4[4][1] * fArr4[4][1]) + (fArr4[4][2] * fArr4[4][2]));
        float[] fArr21 = fArr4[4];
        fArr21[0] = (float) (fArr21[0] / sqrt5);
        float[] fArr22 = fArr4[4];
        fArr22[1] = (float) (fArr22[1] / sqrt5);
        float[] fArr23 = fArr4[4];
        fArr23[2] = (float) (fArr23[2] / sqrt5);
        float[] fArr24 = fArr4[4];
        fArr24[3] = (float) (fArr24[3] / sqrt5);
        fArr4[5][0] = fArr3[3] + fArr3[2];
        fArr4[5][1] = fArr3[7] + fArr3[6];
        fArr4[5][2] = fArr3[11] + fArr3[10];
        fArr4[5][3] = fArr3[15] + fArr3[14];
        double sqrt6 = Math.sqrt((fArr4[5][0] * fArr4[5][0]) + (fArr4[5][1] * fArr4[5][1]) + (fArr4[5][2] * fArr4[5][2]));
        float[] fArr25 = fArr4[5];
        fArr25[0] = (float) (fArr25[0] / sqrt6);
        float[] fArr26 = fArr4[5];
        fArr26[1] = (float) (fArr26[1] / sqrt6);
        float[] fArr27 = fArr4[5];
        fArr27[2] = (float) (fArr27[2] / sqrt6);
        float[] fArr28 = fArr4[5];
        fArr28[3] = (float) (fArr28[3] / sqrt6);
        return fArr4;
    }

    public static boolean b(float[][] fArr, float[] fArr2) {
        return a(fArr, fArr2);
    }
}
