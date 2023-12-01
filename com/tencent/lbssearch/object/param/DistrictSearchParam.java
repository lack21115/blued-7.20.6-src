package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.tencent.lbssearch.object.RequestParams;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/DistrictSearchParam.class */
public class DistrictSearchParam extends DistrictParam {
    private static final String KEYWORD = "keyword";
    private String keyword;

    public DistrictSearchParam() {
    }

    public DistrictSearchParam(String str) {
        this.keyword = str;
    }

    @Override // com.tencent.lbssearch.object.param.DistrictParam, com.tencent.lbssearch.object.param.ParamObject
    public RequestParams buildParameters() {
        RequestParams buildParameters = super.buildParameters();
        if (!TextUtils.isEmpty(this.keyword)) {
            buildParameters.add(KEYWORD, this.keyword);
        }
        return buildParameters;
    }

    @Override // com.tencent.lbssearch.object.param.DistrictParam, com.tencent.lbssearch.object.param.ParamObject
    public boolean checkParams() {
        return !TextUtils.isEmpty(this.keyword);
    }

    public DistrictSearchParam keyword(String str) {
        this.keyword = str;
        return this;
    }
}
