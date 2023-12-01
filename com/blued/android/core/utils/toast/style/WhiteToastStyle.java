package com.blued.android.core.utils.toast.style;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/style/WhiteToastStyle.class */
public class WhiteToastStyle extends BlackToastStyle {
    @Override // com.blued.android.core.utils.toast.style.BlackToastStyle
    protected int f(Context context) {
        return -1157627904;
    }

    @Override // com.blued.android.core.utils.toast.style.BlackToastStyle
    protected Drawable j(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1381654);
        gradientDrawable.setCornerRadius(StyleUtils.a(context, 8.0f));
        return gradientDrawable;
    }
}
