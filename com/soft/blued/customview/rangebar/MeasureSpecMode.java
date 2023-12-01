package com.soft.blued.customview.rangebar;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/rangebar/MeasureSpecMode.class */
public enum MeasureSpecMode {
    AT_MOST(Integer.MIN_VALUE),
    EXACTLY(1073741824),
    UNSPECIFIED(0);
    
    private final int d;

    MeasureSpecMode(int i) {
        this.d = i;
    }
}
