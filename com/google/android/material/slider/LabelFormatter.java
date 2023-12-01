package com.google.android.material.slider;

/* loaded from: source-8110460-dex2jar.jar:com/google/android/material/slider/LabelFormatter.class */
public interface LabelFormatter {
    public static final int LABEL_FLOATING = 0;
    public static final int LABEL_GONE = 2;
    public static final int LABEL_WITHIN_BOUNDS = 1;

    String getFormattedValue(float f);
}
