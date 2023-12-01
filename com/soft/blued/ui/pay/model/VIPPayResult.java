package com.soft.blued.ui.pay.model;

import com.blued.android.module.common.login.model.UserBasicModel;
import com.google.gson.annotations.SerializedName;
import com.soft.blued.ui.msg.model.FuGiftModel;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/model/VIPPayResult.class */
public class VIPPayResult {
    public int activity_id;
    @SerializedName("_")
    public String encrypted;
    public String exchange_id;
    public _extra extra;
    public int is_dialog;
    public int is_secret_dialog;
    public List<FuGiftModel> lucky_list;
    public int ops;
    public int status;
    public String tips;
    public UserBasicModel user_info;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/model/VIPPayResult$_extra.class */
    public class _extra {
        public String info_1;
        public String info_2;
        public String link;
        public int product_vip_grade;

        public _extra() {
        }
    }

    public String toString() {
        return "VIPPayResult{encrypted='" + this.encrypted + "', status=" + this.status + ", activity_id=" + this.activity_id + ", exchange_id='" + this.exchange_id + "', user_info=" + this.user_info + ", extra=" + this.extra + ", tips='" + this.tips + "', ops=" + this.ops + ", is_dialog=" + this.is_dialog + ", is_secret_dialog=" + this.is_secret_dialog + ", lucky_list=" + this.lucky_list + '}';
    }
}
