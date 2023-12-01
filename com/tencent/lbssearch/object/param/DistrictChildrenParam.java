package com.tencent.lbssearch.object.param;

import com.tencent.lbssearch.object.RequestParams;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/DistrictChildrenParam.class */
public class DistrictChildrenParam extends DistrictParam {
    private static final String ID = "id";
    private int id;

    @Override // com.tencent.lbssearch.object.param.DistrictParam, com.tencent.lbssearch.object.param.ParamObject
    public RequestParams buildParameters() {
        RequestParams buildParameters = super.buildParameters();
        int i = this.id;
        if (i > 0) {
            buildParameters.add("id", String.valueOf(i));
        }
        return buildParameters;
    }

    @Override // com.tencent.lbssearch.object.param.DistrictParam, com.tencent.lbssearch.object.param.ParamObject
    public boolean checkParams() {
        return true;
    }

    public DistrictChildrenParam id(int i) {
        this.id = i;
        return this;
    }
}
