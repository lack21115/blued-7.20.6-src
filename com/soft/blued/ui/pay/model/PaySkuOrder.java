package com.soft.blued.ui.pay.model;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.google.gson.annotations.SerializedName;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/model/PaySkuOrder.class */
public class PaySkuOrder {
    @SerializedName(BridgeUtil.UNDERLINE_STR)
    public String encrypted;
    public String out_trade_no;
    public float total_fee;
}
