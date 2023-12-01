package io.noties.markwon.utils;

import android.graphics.Color;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/utils/ColorUtils.class */
public abstract class ColorUtils {
    private ColorUtils() {
    }

    public static int applyAlpha(int i, int i2) {
        return (i & 16777215) | (i2 << 24);
    }

    public static int blend(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.rgb((int) ((Color.red(i) * f2) + (Color.red(i2) * f)), (int) ((Color.green(i) * f2) + (Color.green(i2) * f)), (int) ((f2 * Color.blue(i)) + (f * Color.blue(i2))));
    }
}
