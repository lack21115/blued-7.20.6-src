package com.tencent.lbssearch.object.param;

import com.tencent.lbssearch.object.RequestParams;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/DistrictParam.class */
public class DistrictParam implements ParamObject {
    private int maxOffset = -1;
    private int polygon;

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public RequestParams buildParameters() {
        RequestParams requestParams = new RequestParams();
        requestParams.put("get_polygon", this.polygon);
        int i = this.maxOffset;
        if (i != -1) {
            requestParams.put("max_offset", i);
        }
        return requestParams;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public boolean checkParams() {
        return true;
    }

    public DistrictParam maxOffset(int i) {
        this.maxOffset = i;
        return this;
    }

    public DistrictParam polygon(int i) {
        this.polygon = i;
        return this;
    }
}
