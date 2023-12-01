package com.blued.android.core.image.util;

import android.graphics.Bitmap;
import android.view.View;
import java.lang.reflect.Array;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/util/FastBlur.class */
public class FastBlur {
    public static Bitmap a(Bitmap bitmap, int i, boolean z) {
        Bitmap copy = z ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        if (i < 1) {
            return null;
        }
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i2 = width * height;
        int[] iArr = new int[i2];
        copy.getPixels(iArr, 0, width, 0, 0, width, height);
        int i3 = width - 1;
        int i4 = height - 1;
        int i5 = i + i + 1;
        int[] iArr2 = new int[i2];
        int[] iArr3 = new int[i2];
        int[] iArr4 = new int[i2];
        int[] iArr5 = new int[Math.max(width, height)];
        int i6 = (i5 + 1) >> 1;
        int i7 = i6 * i6;
        int i8 = i7 * 256;
        int[] iArr6 = new int[i8];
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= i8) {
                break;
            }
            iArr6[i10] = i10 / i7;
            i9 = i10 + 1;
        }
        int[][] iArr7 = (int[][]) Array.newInstance(Integer.TYPE, i5, 3);
        int i11 = i + 1;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < height; i14++) {
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            for (int i24 = -i; i24 <= i; i24++) {
                int i25 = iArr[i12 + Math.min(i3, Math.max(i24, 0))];
                int[] iArr8 = iArr7[i24 + i];
                iArr8[0] = (i25 & 16711680) >> 16;
                iArr8[1] = (i25 & 65280) >> 8;
                iArr8[2] = i25 & 255;
                int abs = i11 - Math.abs(i24);
                i23 += iArr8[0] * abs;
                i15 += iArr8[1] * abs;
                i16 += iArr8[2] * abs;
                if (i24 > 0) {
                    i20 += iArr8[0];
                    i21 += iArr8[1];
                    i22 += iArr8[2];
                } else {
                    i17 += iArr8[0];
                    i18 += iArr8[1];
                    i19 += iArr8[2];
                }
            }
            int i26 = i23;
            int i27 = i22;
            int i28 = i21;
            int i29 = i20;
            int i30 = i15;
            int i31 = i;
            int i32 = i26;
            int i33 = 0;
            while (true) {
                int i34 = i33;
                if (i34 < width) {
                    iArr2[i12] = iArr6[i32];
                    iArr3[i12] = iArr6[i30];
                    iArr4[i12] = iArr6[i16];
                    int[] iArr9 = iArr7[((i31 - i) + i5) % i5];
                    int i35 = iArr9[0];
                    int i36 = iArr9[1];
                    int i37 = iArr9[2];
                    if (i14 == 0) {
                        iArr5[i34] = Math.min(i34 + i + 1, i3);
                    }
                    int i38 = iArr[i13 + iArr5[i34]];
                    iArr9[0] = (i38 & 16711680) >> 16;
                    iArr9[1] = (i38 & 65280) >> 8;
                    iArr9[2] = i38 & 255;
                    int i39 = i29 + iArr9[0];
                    int i40 = i28 + iArr9[1];
                    int i41 = i27 + iArr9[2];
                    i32 = (i32 - i17) + i39;
                    i30 = (i30 - i18) + i40;
                    i16 = (i16 - i19) + i41;
                    i31 = (i31 + 1) % i5;
                    int[] iArr10 = iArr7[i31 % i5];
                    i17 = (i17 - i35) + iArr10[0];
                    i18 = (i18 - i36) + iArr10[1];
                    i19 = (i19 - i37) + iArr10[2];
                    i29 = i39 - iArr10[0];
                    i28 = i40 - iArr10[1];
                    i27 = i41 - iArr10[2];
                    i12++;
                    i33 = i34 + 1;
                }
            }
            i13 += width;
        }
        int i42 = 0;
        while (true) {
            int i43 = i42;
            if (i43 >= width) {
                copy.setPixels(iArr, 0, width, 0, 0, width, height);
                return copy;
            }
            int i44 = -i;
            int i45 = 0;
            int i46 = 0;
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = i44;
            int i53 = i44 * width;
            int i54 = 0;
            int i55 = 0;
            while (i52 <= i) {
                int max = Math.max(0, i53) + i43;
                int[] iArr11 = iArr7[i52 + i];
                iArr11[0] = iArr2[max];
                iArr11[1] = iArr3[max];
                iArr11[2] = iArr4[max];
                int abs2 = i11 - Math.abs(i52);
                i54 += iArr2[max] * abs2;
                i55 += iArr3[max] * abs2;
                i45 += iArr4[max] * abs2;
                if (i52 > 0) {
                    i49 += iArr11[0];
                    i50 += iArr11[1];
                    i51 += iArr11[2];
                } else {
                    i46 += iArr11[0];
                    i47 += iArr11[1];
                    i48 += iArr11[2];
                }
                int i56 = i53;
                if (i52 < i4) {
                    i56 = i53 + width;
                }
                i52++;
                i53 = i56;
            }
            int i57 = i55;
            int i58 = i54;
            int i59 = i;
            int i60 = i43;
            int i61 = i51;
            int i62 = i50;
            int i63 = i49;
            int i64 = i57;
            int i65 = i58;
            int i66 = 0;
            while (true) {
                int i67 = i66;
                if (i67 < height) {
                    iArr[i60] = (iArr[i60] & View.MEASURED_STATE_MASK) | (iArr6[i65] << 16) | (iArr6[i64] << 8) | iArr6[i45];
                    int[] iArr12 = iArr7[((i59 - i) + i5) % i5];
                    int i68 = iArr12[0];
                    int i69 = iArr12[1];
                    int i70 = iArr12[2];
                    if (i43 == 0) {
                        iArr5[i67] = Math.min(i67 + i11, i4) * width;
                    }
                    int i71 = iArr5[i67] + i43;
                    iArr12[0] = iArr2[i71];
                    iArr12[1] = iArr3[i71];
                    iArr12[2] = iArr4[i71];
                    int i72 = i63 + iArr12[0];
                    int i73 = i62 + iArr12[1];
                    int i74 = i61 + iArr12[2];
                    i65 = (i65 - i46) + i72;
                    i64 = (i64 - i47) + i73;
                    i45 = (i45 - i48) + i74;
                    i59 = (i59 + 1) % i5;
                    int[] iArr13 = iArr7[i59];
                    i46 = (i46 - i68) + iArr13[0];
                    i47 = (i47 - i69) + iArr13[1];
                    i48 = (i48 - i70) + iArr13[2];
                    i63 = i72 - iArr13[0];
                    i62 = i73 - iArr13[1];
                    i61 = i74 - iArr13[2];
                    i60 += width;
                    i66 = i67 + 1;
                }
            }
            i42 = i43 + 1;
        }
    }
}
