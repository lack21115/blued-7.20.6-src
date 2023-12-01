package com.tencent.map.lib.models;

import android.graphics.Rect;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/AccessibleTouchItem.class */
public abstract class AccessibleTouchItem implements Comparable<AccessibleTouchItem> {
    public static final String MAP_DEFAULT_CONTENT_DESCRIPTION = "地图";
    public static final int MIN_TOUCH_RADIUS = 20;
    public static final String MY_LOCATION_PREFIX = "我的位置";

    @Override // java.lang.Comparable
    public int compareTo(AccessibleTouchItem accessibleTouchItem) {
        Rect bounds = getBounds();
        Rect bounds2 = accessibleTouchItem.getBounds();
        int i = bounds.top;
        int i2 = bounds2.top;
        return i != i2 ? i - i2 : bounds.left - bounds2.left;
    }

    public abstract Rect getBounds();

    public abstract String getContentDescription();

    public abstract void onClick();
}
