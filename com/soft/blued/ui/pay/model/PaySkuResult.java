package com.soft.blued.ui.pay.model;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.google.gson.annotations.SerializedName;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/model/PaySkuResult.class */
public class PaySkuResult {
    @SerializedName(BridgeUtil.UNDERLINE_STR)
    public String encrypted;
    public int status;
}
