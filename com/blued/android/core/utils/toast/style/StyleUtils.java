package com.blued.android.core.utils.toast.style;

import android.content.Context;
import android.util.TypedValue;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/style/StyleUtils.class */
public class StyleUtils {
    private StyleUtils() {
    }

    public static float a(Context context, float f) {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static float b(Context context, float f) {
        return TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }
}
