package com.tencent.lbssearch.object.param;

import com.huawei.openalliance.ad.constant.t;
import com.tencent.lbssearch.object.RequestParams;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/TranslateParam.class */
public class TranslateParam implements ParamObject {
    private static final String LOCATIONS = "locations";
    private static final String TYPES = "type";
    private List<LatLng> latLngs;
    private CoordType type = CoordType.STANDARD;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/TranslateParam$CoordType.class */
    public enum CoordType {
        NONE,
        GPS,
        SOGOU,
        BAIDU,
        MAPBAR,
        STANDARD,
        SOGOUMERCATOR
    }

    public TranslateParam addLocation(LatLng latLng) {
        if (this.latLngs == null) {
            this.latLngs = new ArrayList();
        }
        this.latLngs.add(latLng);
        return this;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public RequestParams buildParameters() {
        RequestParams requestParams = new RequestParams();
        List<LatLng> list = this.latLngs;
        if (list != null && list.size() > 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.latLngs.size()) {
                    break;
                }
                String str = i2 != 0 ? t.aE : "";
                sb.append(str + this.latLngs.get(i2).latitude + "," + this.latLngs.get(i2).longitude);
                i = i2 + 1;
            }
            requestParams.add("locations", sb.toString());
        }
        requestParams.add("type", "" + this.type.ordinal());
        return requestParams;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public boolean checkParams() {
        return this.latLngs != null;
    }

    public TranslateParam coordType(CoordType coordType) {
        this.type = coordType;
        return this;
    }

    public TranslateParam coord_type(CoordTypeEnum coordTypeEnum) {
        coordType(coordTypeEnum.coordType);
        return this;
    }

    public TranslateParam locations(LatLng... latLngArr) {
        if (this.latLngs == null) {
            this.latLngs = new ArrayList();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= latLngArr.length) {
                return this;
            }
            this.latLngs.add(latLngArr[i2]);
            i = i2 + 1;
        }
    }
}
