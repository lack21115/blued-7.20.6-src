package com.youzan.androidsdk.model.trade;

import com.google.gson.annotations.SerializedName;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/model/trade/TradePayFinishedModel.class */
public class TradePayFinishedModel {
    @SerializedName("pay_type")
    private int payType;
    private int status;
    private String tid;

    public int getPayType() {
        return this.payType;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTid() {
        return this.tid;
    }

    public void setPayType(int i) {
        this.payType = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public String toString() {
        return "TradePayFinishedModel{tid='" + this.tid + "', status=" + this.status + ", payType=" + this.payType + '}';
    }
}
