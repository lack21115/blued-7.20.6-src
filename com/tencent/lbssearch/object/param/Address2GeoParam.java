package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.tencent.lbssearch.object.RequestParams;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/Address2GeoParam.class */
public class Address2GeoParam implements ParamObject {
    private static final String ADDRESS = "address";
    private static final String REGION = "region";
    private String address;
    private String region;

    public Address2GeoParam() {
    }

    public Address2GeoParam(String str) {
        this.address = str;
    }

    public Address2GeoParam address(String str) {
        this.address = str;
        return this;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public RequestParams buildParameters() {
        RequestParams requestParams = new RequestParams();
        if (!TextUtils.isEmpty(this.address)) {
            requestParams.add(ADDRESS, this.address);
        }
        if (!TextUtils.isEmpty(this.region)) {
            requestParams.add("region", this.region);
        }
        return requestParams;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public boolean checkParams() {
        return !TextUtils.isEmpty(this.address);
    }

    public Address2GeoParam region(String str) {
        this.region = str;
        return this;
    }
}
