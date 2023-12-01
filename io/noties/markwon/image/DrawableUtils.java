package io.noties.markwon.image;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/image/DrawableUtils.class */
public abstract class DrawableUtils {
    private DrawableUtils() {
    }

    public static void applyIntrinsicBounds(Drawable drawable) {
        drawable.setBounds(intrinsicBounds(drawable));
    }

    public static void applyIntrinsicBoundsIfEmpty(Drawable drawable) {
        if (drawable.getBounds().isEmpty()) {
            drawable.setBounds(intrinsicBounds(drawable));
        }
    }

    public static Rect intrinsicBounds(Drawable drawable) {
        return new Rect(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }
}
