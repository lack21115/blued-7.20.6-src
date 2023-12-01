package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.tencent.lbssearch.object.RequestParams;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/StreetViewParam.class */
public class StreetViewParam implements ParamObject {
    private static final String ID = "id";
    private static final String LOCATION = "location";
    private static final String POI = "poi";
    private static final String RADIUS = "radius";
    private String id;
    private LatLng latLng;
    private String poi;
    private int radius;

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public RequestParams buildParameters() {
        RequestParams requestParams = new RequestParams();
        if (this.latLng != null) {
            requestParams.add("location", this.latLng.latitude + "," + this.latLng.longitude);
        }
        if (!TextUtils.isEmpty(this.poi)) {
            requestParams.add(POI, this.poi);
        }
        if (!TextUtils.isEmpty(this.id)) {
            requestParams.add("id", this.id);
        }
        int i = this.radius;
        if (i > 0) {
            requestParams.add(RADIUS, String.valueOf(i));
        }
        return requestParams;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public boolean checkParams() {
        return (TextUtils.isEmpty(this.id) && this.latLng == null && TextUtils.isEmpty(this.poi)) ? false : true;
    }

    public StreetViewParam id(String str) {
        this.id = str;
        return this;
    }

    public StreetViewParam location(LatLng latLng) {
        this.latLng = latLng;
        return this;
    }

    public StreetViewParam poi(String str) {
        this.poi = str;
        return this;
    }

    public StreetViewParam radius(int i) {
        this.radius = i;
        return this;
    }
}
