package io.noties.markwon.utils;

import android.graphics.drawable.Drawable;

@Deprecated
/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/utils/DrawableUtils.class */
public abstract class DrawableUtils {
    private DrawableUtils() {
    }

    public static void intrinsicBounds(Drawable drawable) {
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }
}
