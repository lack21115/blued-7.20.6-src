package com.tencent.lbssearch.object.param;

import com.tencent.lbssearch.httpresponse.UrlConstant;
import com.tencent.lbssearch.object.result.WalkingResultObject;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/WalkingParam.class */
public class WalkingParam extends RoutePlanningParam {
    public WalkingParam() {
    }

    public WalkingParam(LatLng latLng, LatLng latLng2) {
        super(latLng, latLng2);
    }

    @Override // com.tencent.lbssearch.object.param.RoutePlanningParam
    public Class<WalkingResultObject> getResultClass() {
        return WalkingResultObject.class;
    }

    @Override // com.tencent.lbssearch.object.param.RoutePlanningParam
    public String getUrl() {
        return UrlConstant.ROUTE_PLANNING_WALKING;
    }
}
