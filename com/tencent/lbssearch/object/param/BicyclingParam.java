package com.tencent.lbssearch.object.param;

import com.tencent.lbssearch.httpresponse.UrlConstant;
import com.tencent.lbssearch.object.result.BicyclingResultObject;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/BicyclingParam.class */
public class BicyclingParam extends RoutePlanningParam {
    public BicyclingParam() {
    }

    public BicyclingParam(LatLng latLng, LatLng latLng2) {
        super(latLng, latLng2);
    }

    @Override // com.tencent.lbssearch.object.param.RoutePlanningParam
    public Class<?> getResultClass() {
        return BicyclingResultObject.class;
    }

    @Override // com.tencent.lbssearch.object.param.RoutePlanningParam
    public String getUrl() {
        return UrlConstant.ROUTE_BICYCLING_TRANSIT;
    }
}
