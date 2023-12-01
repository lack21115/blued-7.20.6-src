package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/interfaces/IRouteSearchV2.class */
public interface IRouteSearchV2 {
    DriveRouteResultV2 calculateDriveRoute(RouteSearchV2.DriveRouteQuery driveRouteQuery) throws AMapException;

    void calculateDriveRouteAsyn(RouteSearchV2.DriveRouteQuery driveRouteQuery);

    void setRouteSearchListener(RouteSearchV2.OnRouteSearchListener onRouteSearchListener);
}
