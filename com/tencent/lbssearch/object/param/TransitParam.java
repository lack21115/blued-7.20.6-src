package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.tencent.lbssearch.httpresponse.UrlConstant;
import com.tencent.lbssearch.object.RequestParams;
import com.tencent.lbssearch.object.param.RoutePlanningParam;
import com.tencent.lbssearch.object.result.TransitResultObject;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.umeng.analytics.pro.bh;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/TransitParam.class */
public class TransitParam extends RoutePlanningParam {
    private long departureTime;
    private String policy;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/TransitParam$Policy.class */
    public enum Policy {
        LEAST_TIME,
        LEAST_TRANSFER,
        LEAST_WALKING
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/TransitParam$Preference.class */
    public enum Preference {
        NO_SUBWAY
    }

    public TransitParam() {
    }

    public TransitParam(LatLng latLng, LatLng latLng2) {
        super(latLng, latLng2);
    }

    @Override // com.tencent.lbssearch.object.param.RoutePlanningParam, com.tencent.lbssearch.object.param.ParamObject
    public RequestParams buildParameters() {
        RequestParams buildParameters = super.buildParameters();
        if (!TextUtils.isEmpty(this.policy)) {
            buildParameters.put(bh.bt, this.policy);
        }
        long j = this.departureTime;
        if (j > 0) {
            buildParameters.put("departure_time", j);
        }
        return buildParameters;
    }

    public TransitParam departureTime(long j) {
        this.departureTime = j;
        return this;
    }

    @Override // com.tencent.lbssearch.object.param.RoutePlanningParam
    public Class<TransitResultObject> getResultClass() {
        return TransitResultObject.class;
    }

    @Override // com.tencent.lbssearch.object.param.RoutePlanningParam
    public String getUrl() {
        return UrlConstant.ROUTE_PLANNING_TRANSIT;
    }

    public TransitParam policy(RoutePlanningParam.TransitPolicy transitPolicy) {
        StringBuilder sb = new StringBuilder();
        if (transitPolicy != null) {
            sb.append(transitPolicy.name());
        }
        this.policy = sb.toString();
        return this;
    }

    public TransitParam policy(Policy policy, Preference... preferenceArr) {
        StringBuilder sb = new StringBuilder();
        if (policy != null) {
            sb.append(policy.name());
        }
        if (preferenceArr != null && preferenceArr.length > 0) {
            int length = preferenceArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                Preference preference = preferenceArr[i2];
                sb.append(",");
                sb.append(preference.name());
                i = i2 + 1;
            }
        }
        this.policy = sb.toString();
        return this;
    }
}
