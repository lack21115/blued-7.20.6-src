package com.blued.android.module.yy_china.model;

import com.blued.android.module.live.base.model.PayOption;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYPerFirstGiftModel.class */
public class YYPerFirstGiftModel {
    private List<GiftListDTOModel> gift_list;
    public boolean isClick = false;
    private long pay_id;
    private PayOption._pay_list sel;
    private String tips;
    private long type;

    public List<GiftListDTOModel> getGift_list() {
        return this.gift_list;
    }

    public long getPay_id() {
        return this.pay_id;
    }

    public PayOption._pay_list getSel() {
        return this.sel;
    }

    public String getTips() {
        return this.tips;
    }

    public long getType() {
        return this.type;
    }

    public void setGift_list(List<GiftListDTOModel> list) {
        this.gift_list = list;
    }

    public void setPay_id(long j) {
        this.pay_id = j;
    }

    public void setSel(PayOption._pay_list _pay_listVar) {
        this.sel = _pay_listVar;
    }

    public void setTips(String str) {
        this.tips = str;
    }

    public void setType(long j) {
        this.type = j;
    }
}
