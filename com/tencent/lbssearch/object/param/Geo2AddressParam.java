package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.t;
import com.tencent.lbssearch.object.RequestParams;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/Geo2AddressParam.class */
public class Geo2AddressParam implements ParamObject {
    private static final String GET_POI = "get_poi";
    private static final String LOCATION = "location";
    private static final String POI_OPTIONS = "poi_options";
    private boolean isGetPoi = false;
    private LatLng latLng;
    private PoiOptions poiOptions;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/Geo2AddressParam$PoiOptions.class */
    public static class PoiOptions {
        public static final String ADDRESS_FORMAT_DEFAULT = "";
        public static final String ADDRESS_FORMAT_SHORT = "short";
        public static final int POLICY_DEFAULT = 1;
        public static final int POLICY_O2O = 2;
        public static final int POLICY_SHARE = 5;
        public static final int POLICY_SOCIAL = 4;
        public static final int POLICY_TRIP = 3;
        private String addressFormat;
        private String[] categorys;
        private int pageIndex;
        private int pageSize;
        private int policy;
        private int radius;

        public PoiOptions setAddressFormat(String str) {
            this.addressFormat = str;
            return this;
        }

        public PoiOptions setCategorys(String... strArr) {
            this.categorys = strArr;
            return this;
        }

        public PoiOptions setPageIndex(int i) {
            this.pageIndex = i;
            return this;
        }

        public PoiOptions setPageSize(int i) {
            this.pageSize = i;
            return this;
        }

        public PoiOptions setPolicy(int i) {
            this.policy = i;
            return this;
        }

        public PoiOptions setRadius(int i) {
            this.radius = i;
            return this;
        }

        public String toString() {
            int i;
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.addressFormat)) {
                sb.append(";address_format=");
                sb.append(this.addressFormat);
            }
            int i2 = this.radius;
            if (i2 > 0 && i2 <= 5000) {
                sb.append(";radius=");
                sb.append(this.radius);
            }
            int i3 = this.pageIndex;
            if (i3 > 0 && i3 <= 20 && (i = this.pageSize) > 0 && i <= 20) {
                sb.append(";page_index=");
                sb.append(this.pageIndex);
                sb.append(";page_size=");
                sb.append(this.pageSize);
            }
            if (this.policy > 0) {
                sb.append(";policy=");
                sb.append(this.policy);
            }
            String[] strArr = this.categorys;
            if (strArr != null && strArr.length > 0) {
                StringBuilder sb2 = new StringBuilder();
                String[] strArr2 = this.categorys;
                int length = strArr2.length;
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= length) {
                        break;
                    }
                    sb2.append(strArr2[i5]);
                    sb2.append(",");
                    i4 = i5 + 1;
                }
                int lastIndexOf = sb2.lastIndexOf(",");
                sb2.delete(lastIndexOf, lastIndexOf + 1);
                sb.append(";category=");
                sb.append(sb2.toString());
            }
            if (sb.indexOf(t.aE) == 0) {
                sb.delete(0, 1);
            }
            return sb.toString();
        }
    }

    public Geo2AddressParam() {
    }

    public Geo2AddressParam(LatLng latLng) {
        this.latLng = latLng;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public RequestParams buildParameters() {
        RequestParams requestParams = new RequestParams();
        if (this.latLng != null) {
            requestParams.add("location", this.latLng.latitude + "," + this.latLng.longitude);
        }
        requestParams.add(GET_POI, this.isGetPoi ? "1" : "0");
        PoiOptions poiOptions = this.poiOptions;
        if (poiOptions != null) {
            requestParams.add(POI_OPTIONS, poiOptions.toString());
        }
        return requestParams;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public boolean checkParams() {
        return this.latLng != null;
    }

    public Geo2AddressParam coord_type(CoordTypeEnum coordTypeEnum) {
        return this;
    }

    public Geo2AddressParam getPoi(boolean z) {
        this.isGetPoi = z;
        return this;
    }

    public Geo2AddressParam get_poi(boolean z) {
        this.isGetPoi = z;
        return this;
    }

    public Geo2AddressParam location(LatLng latLng) {
        this.latLng = latLng;
        return this;
    }

    public Geo2AddressParam setPoiOptions(PoiOptions poiOptions) {
        this.poiOptions = poiOptions;
        return this;
    }
}
