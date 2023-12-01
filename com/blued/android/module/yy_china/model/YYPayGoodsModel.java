package com.blued.android.module.yy_china.model;

import com.blued.android.module.live.base.model.BasePayRemaining;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYPayGoodsModel.class */
public class YYPayGoodsModel extends BasePayRemaining {
    public YyWealthModel current_wealth;
    public LuckGiftModel extra;
    public int extra_count;
    public int free_count;
    public String json_contents_im;
    public YyWealthModel next_wealth;
    public String payment_token;
    public long users_sums_left;

    @Override // com.blued.android.module.live.base.model.BasePayRemaining
    public String toString() {
        return "YYPayGoodsModel{users_sums_left='" + this.users_sums_left + "', hit_id='" + this.hit_id + "'}";
    }
}
