package com.android.internal.util.cm.palette;

import android.graphics.Color;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/cm/palette/ColorUtils.class */
final class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 10;

    private ColorUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int HSLtoRGB(float[] fArr) {
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float abs = (1.0f - Math.abs((2.0f * f3) - 1.0f)) * f2;
        float f4 = f3 - (0.5f * abs);
        float abs2 = abs * (1.0f - Math.abs(((f / 60.0f) % 2.0f) - 1.0f));
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        switch (((int) f) / 60) {
            case 0:
                i = Math.round(255.0f * (abs + f4));
                i2 = Math.round(255.0f * (abs2 + f4));
                i3 = Math.round(255.0f * f4);
                break;
            case 1:
                i = Math.round(255.0f * (abs2 + f4));
                i2 = Math.round(255.0f * (abs + f4));
                i3 = Math.round(255.0f * f4);
                break;
            case 2:
                i = Math.round(255.0f * f4);
                i2 = Math.round(255.0f * (abs + f4));
                i3 = Math.round(255.0f * (abs2 + f4));
                break;
            case 3:
                i = Math.round(255.0f * f4);
                i2 = Math.round(255.0f * (abs2 + f4));
                i3 = Math.round(255.0f * (abs + f4));
                break;
            case 4:
                i = Math.round(255.0f * (abs2 + f4));
                i2 = Math.round(255.0f * f4);
                i3 = Math.round(255.0f * (abs + f4));
                break;
            case 5:
            case 6:
                i = Math.round(255.0f * (abs + f4));
                i2 = Math.round(255.0f * f4);
                i3 = Math.round(255.0f * (abs2 + f4));
                break;
        }
        return Color.rgb(Math.max(0, Math.min(255, i)), Math.max(0, Math.min(255, i2)), Math.max(0, Math.min(255, i3)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void RGBtoHSL(int i, int i2, int i3, float[] fArr) {
        float f;
        float abs;
        float f2 = i / 255.0f;
        float f3 = i2 / 255.0f;
        float f4 = i3 / 255.0f;
        float max = Math.max(f2, Math.max(f3, f4));
        float min = Math.min(f2, Math.min(f3, f4));
        float f5 = max - min;
        float f6 = (max + min) / 2.0f;
        if (max == min) {
            abs = 0.0f;
            f = 0.0f;
        } else {
            f = max == f2 ? ((f3 - f4) / f5) % 6.0f : max == f3 ? ((f4 - f2) / f5) + 2.0f : ((f2 - f3) / f5) + 4.0f;
            abs = f5 / (1.0f - Math.abs((2.0f * f6) - 1.0f));
        }
        fArr[0] = (60.0f * f) % 360.0f;
        fArr[1] = abs;
        fArr[2] = f6;
    }

    private static double calculateContrast(int i, int i2) {
        if (Color.alpha(i2) != 255) {
            throw new IllegalArgumentException("background can not be translucent");
        }
        int i3 = i;
        if (Color.alpha(i) < 255) {
            i3 = compositeColors(i, i2);
        }
        double calculateLuminance = calculateLuminance(i3) + 0.05d;
        double calculateLuminance2 = calculateLuminance(i2) + 0.05d;
        return Math.max(calculateLuminance, calculateLuminance2) / Math.min(calculateLuminance, calculateLuminance2);
    }

    private static double calculateLuminance(int i) {
        double red = Color.red(i) / 255.0d;
        double pow = red < 0.03928d ? red / 12.92d : Math.pow((0.055d + red) / 1.055d, 2.4d);
        double green = Color.green(i) / 255.0d;
        double pow2 = green < 0.03928d ? green / 12.92d : Math.pow((0.055d + green) / 1.055d, 2.4d);
        double blue = Color.blue(i) / 255.0d;
        return (0.2126d * pow) + (0.7152d * pow2) + (0.0722d * (blue < 0.03928d ? blue / 12.92d : Math.pow((0.055d + blue) / 1.055d, 2.4d)));
    }

    private static int compositeColors(int i, int i2) {
        float alpha = Color.alpha(i) / 255.0f;
        float alpha2 = Color.alpha(i2) / 255.0f;
        return Color.argb((int) ((alpha + alpha2) * (1.0f - alpha)), (int) ((Color.red(i) * alpha) + (Color.red(i2) * alpha2 * (1.0f - alpha))), (int) ((Color.green(i) * alpha) + (Color.green(i2) * alpha2 * (1.0f - alpha))), (int) ((Color.blue(i) * alpha) + (Color.blue(i2) * alpha2 * (1.0f - alpha))));
    }

    private static int findMinimumAlpha(int i, int i2, double d) {
        int i3;
        if (Color.alpha(i2) != 255) {
            throw new IllegalArgumentException("background can not be translucent");
        }
        if (calculateContrast(modifyAlpha(i, 255), i2) >= d) {
            int i4 = 0;
            int i5 = 0;
            int i6 = 255;
            while (true) {
                i3 = i6;
                if (i4 > 10) {
                    break;
                }
                i3 = i6;
                if (i6 - i5 <= 10) {
                    break;
                }
                int i7 = (i5 + i6) / 2;
                if (calculateContrast(modifyAlpha(i, i7), i2) < d) {
                    i5 = i7;
                } else {
                    i6 = i7;
                }
                i4++;
            }
        } else {
            i3 = -1;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getTextColorForBackground(int i, int i2, float f) {
        int findMinimumAlpha = findMinimumAlpha(i2, i, f);
        if (findMinimumAlpha >= 0) {
            return modifyAlpha(i2, findMinimumAlpha);
        }
        return -1;
    }

    static int modifyAlpha(int i, int i2) {
        return (16777215 & i) | (i2 << 24);
    }
}
