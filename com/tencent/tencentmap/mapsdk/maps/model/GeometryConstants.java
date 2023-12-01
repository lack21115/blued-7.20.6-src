package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Rect;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/GeometryConstants.class */
public class GeometryConstants {
    public static final double LATITUDE_SPAN = 180.0d;
    public static final double LONGITUDE_SPAN = 360.0d;
    public static final double MAX_LATITUDE = 90.0d;
    public static final double MAX_LONGITUDE = Double.MAX_VALUE;
    public static final double MAX_MERCATOR_LATITUDE = 85.05112877980659d;
    public static final double MAX_WRAP_LONGITUDE = 180.0d;
    public static final double MIN_LATITUDE = -90.0d;
    public static final double MIN_LONGITUDE = -1.7976931348623157E308d;
    public static final double MIN_MERCATOR_LATITUDE = -85.05112877980659d;
    public static final double MIN_WRAP_LONGITUDE = -180.0d;
    public static final int RADIUS_EARTH_METERS = 6378137;
    public static final int WORLD_WEST = -180000000;
    public static final int WORLD_SOUTH = -85000000;
    public static final int WORLD_EAST = 180000000;
    public static final int WORLD_NORTH = 85000000;
    public static final Rect BOUNDARY_WORLD = new Rect(WORLD_WEST, WORLD_SOUTH, WORLD_EAST, WORLD_NORTH);
}
