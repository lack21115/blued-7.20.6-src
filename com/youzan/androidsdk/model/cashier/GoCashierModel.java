package com.youzan.androidsdk.model.cashier;

import com.google.gson.annotations.SerializedName;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/model/cashier/GoCashierModel.class */
public class GoCashierModel {
    @SerializedName("dealerCode")
    private String dealerCode;
    @SerializedName("orderNo")
    private String orderNo;
    @SerializedName("orderType")
    private String orderType;
    @SerializedName("serviceNo")
    private String serviceNo;

    public String getDealerCode() {
        return this.dealerCode;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public String getOrderType() {
        return this.orderType;
    }

    public String getServiceNo() {
        return this.serviceNo;
    }

    public void setDealerCode(String str) {
        this.dealerCode = str;
    }

    public void setOrderNo(String str) {
        this.orderNo = str;
    }

    public void setOrderType(String str) {
        this.orderType = str;
    }

    public void setServiceNo(String str) {
        this.serviceNo = str;
    }

    public String toString() {
        return "GoodsOfCartModel{serviceNo=" + this.serviceNo + ", orderNo=" + this.orderNo + ", dealCode=" + this.dealerCode + ", orderType=" + this.orderType + '}';
    }
}
