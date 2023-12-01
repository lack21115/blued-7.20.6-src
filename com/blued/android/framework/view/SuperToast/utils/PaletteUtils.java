package com.blued.android.framework.view.SuperToast.utils;

import android.graphics.Color;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/SuperToast/utils/PaletteUtils.class */
public class PaletteUtils {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/SuperToast/utils/PaletteUtils$PaletteColors.class */
    public @interface PaletteColors {
    }

    public static int a(String str) {
        return Color.parseColor("#FF".concat(str));
    }
}
