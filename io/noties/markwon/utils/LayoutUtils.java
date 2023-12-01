package io.noties.markwon.utils;

import android.os.Build;
import android.text.Layout;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/utils/LayoutUtils.class */
public abstract class LayoutUtils {
    private static final float DEFAULT_EXTRA = 0.0f;
    private static final float DEFAULT_MULTIPLIER = 1.0f;

    private LayoutUtils() {
    }

    public static int getLineBottomWithoutPaddingAndSpacing(Layout layout, int i) {
        int lineBottom = layout.getLineBottom(i);
        boolean z = false;
        boolean z2 = Build.VERSION.SDK_INT >= 19;
        boolean z3 = i == layout.getLineCount() - 1;
        float spacingAdd = layout.getSpacingAdd();
        float spacingMultiplier = layout.getSpacingMultiplier();
        if (spacingAdd != 0.0f || spacingMultiplier != 1.0f) {
            z = true;
        }
        int i2 = lineBottom;
        if (z) {
            if (z3 && z2) {
                i2 = lineBottom;
            } else {
                float f = spacingAdd;
                if (Float.compare(1.0f, spacingMultiplier) != 0) {
                    float lineHeight = getLineHeight(layout, i);
                    f = lineHeight - ((lineHeight - spacingAdd) / spacingMultiplier);
                }
                i2 = (int) ((lineBottom - f) + 0.5f);
            }
        }
        int i3 = i2;
        if (z3) {
            i3 = i2;
            if (i == layout.getLineCount() - 1) {
                i3 = i2 - layout.getBottomPadding();
            }
        }
        return i3;
    }

    public static int getLineHeight(Layout layout, int i) {
        return layout.getLineTop(i + 1) - layout.getLineTop(i);
    }

    public static int getLineTopWithoutPadding(Layout layout, int i) {
        int lineTop = layout.getLineTop(i);
        int i2 = lineTop;
        if (i == 0) {
            i2 = lineTop - layout.getTopPadding();
        }
        return i2;
    }
}
