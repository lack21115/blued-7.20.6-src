package com.android.internal.util.gesture;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/gesture/EdgeGesturePosition.class */
public enum EdgeGesturePosition {
    LEFT(0, 0),
    BOTTOM(1, 1),
    RIGHT(2, 1),
    TOP(3, 0);
    
    public final int FACTOR;
    public final int FLAG;
    public final int INDEX;

    EdgeGesturePosition(int i, int i2) {
        this.INDEX = i;
        this.FLAG = 1 << i;
        this.FACTOR = i2;
    }
}
