package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.object.RequestParams;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/RoutePlanningParam.class */
public abstract class RoutePlanningParam implements ParamObject {
    private LatLng from;
    private LatLng to;
    private String toPOI;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/RoutePlanningParam$DrivingPolicy.class */
    public enum DrivingPolicy {
        LEAST_TIME,
        LEAST_FEE,
        LEAST_DISTANCE,
        REAL_TRAFFIC
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/RoutePlanningParam$TransitPolicy.class */
    public enum TransitPolicy {
        LEAST_TIME,
        LEAST_TRANSFER,
        LEAST_WALKING
    }

    public RoutePlanningParam() {
    }

    public RoutePlanningParam(LatLng latLng, LatLng latLng2) {
        this.from = latLng;
        this.to = latLng2;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public RequestParams buildParameters() {
        RequestParams requestParams = new RequestParams();
        requestParams.put("from", locationToParamsString(this.from));
        requestParams.put("to", locationToParamsString(this.to));
        if (!TextUtils.isEmpty(this.toPOI)) {
            requestParams.put("to_poi", this.toPOI);
        }
        return requestParams;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public boolean checkParams() {
        return (this.from == null || this.to == null) ? false : true;
    }

    public RoutePlanningParam from(LatLng latLng) {
        this.from = latLng;
        return this;
    }

    public abstract <T extends BaseObject> Class<T> getResultClass();

    public abstract String getUrl();

    public String locationToParamsString(LatLng latLng) {
        return latLng.latitude + "," + latLng.longitude;
    }

    public RoutePlanningParam to(LatLng latLng) {
        this.to = latLng;
        return this;
    }

    public RoutePlanningParam toPOI(String str) {
        this.toPOI = str;
        return this;
    }
}
