package com.tencent.tencentmap.mapsdk.maps.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/OverlayLevel.class */
public @interface OverlayLevel {
    public static final int OverlayLevelAboveBuildings = 1;
    public static final int OverlayLevelAboveLabels = 2;
    public static final int OverlayLevelAboveRoads = 0;
}
