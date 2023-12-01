package com.blued.android.module.yy_china.model;

import android.text.TextUtils;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYMsgSaleFlowExtra.class */
public class YYMsgSaleFlowExtra {
    public YYGiftModel goods;
    public YYMsgRelationExtra relation;
    public List<YYSaleStageModel> stage_list;
    public int step;

    public boolean hasGoods() {
        YYGiftModel yYGiftModel = this.goods;
        return (yYGiftModel == null || TextUtils.isEmpty(yYGiftModel.images_static)) ? false : true;
    }

    public boolean hasRelation() {
        YYMsgRelationExtra yYMsgRelationExtra = this.relation;
        return (yYMsgRelationExtra == null || TextUtils.isEmpty(yYMsgRelationExtra.images_static)) ? false : true;
    }
}
