package com.blued.android.module.live.base.model;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/model/BasePayRemaining.class */
public class BasePayRemaining implements Serializable {
    public long beans;
    public long beans_count;
    public long beans_current;
    public long bonus;
    @SerializedName(BridgeUtil.UNDERLINE_STR)
    public String encrypted;
    public String errorMessage;
    public int free_number;
    public int hit_count;
    public long hit_id;
    public String order_id;
    public int sendGiftStatus;
    public int status;
    public PayRemainingText text;
    public String tips;
    public String token;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BasePayRemaining[beans:");
        sb.append(this.beans);
        sb.append(", bonus:");
        sb.append(this.bonus);
        sb.append(", status:");
        sb.append(this.status);
        sb.append(", token:");
        sb.append(this.token);
        sb.append(", hit_id:");
        sb.append(this.hit_id);
        sb.append(", hit_count:");
        sb.append(this.hit_count);
        sb.append(", beans_count:");
        sb.append(this.beans_count);
        sb.append(", beans_current:");
        sb.append(this.beans_current);
        sb.append(", free_number:");
        sb.append(this.free_number);
        sb.append(", tips:");
        sb.append(this.tips);
        sb.append(", sendGiftStatus:");
        sb.append(this.sendGiftStatus);
        sb.append(", text:");
        PayRemainingText payRemainingText = this.text;
        sb.append(payRemainingText != null ? payRemainingText.toString() : "null");
        sb.append("]");
        return sb.toString();
    }
}
