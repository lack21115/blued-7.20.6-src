package com.google.android.material.shadow;

import android.graphics.drawable.Drawable;

/* loaded from: source-8110460-dex2jar.jar:com/google/android/material/shadow/ShadowViewDelegate.class */
public interface ShadowViewDelegate {
    float getRadius();

    boolean isCompatPaddingEnabled();

    void setBackgroundDrawable(Drawable drawable);

    void setShadowPadding(int i, int i2, int i3, int i4);
}
