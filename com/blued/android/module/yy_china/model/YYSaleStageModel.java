package com.blued.android.module.yy_china.model;

import com.blued.android.framework.utils.StringUtils;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYSaleStageModel.class */
public class YYSaleStageModel {
    public String name;
    public String value;

    public Integer getValueInt() {
        return Integer.valueOf(StringUtils.a(this.value, 0));
    }
}
