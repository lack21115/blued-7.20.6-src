package com.youzan.androidsdk.model.goods;

import com.google.gson.annotations.SerializedName;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/model/goods/GoodsOfCartModel.class */
public class GoodsOfCartModel {
    private String alias;
    @SerializedName("item_id")
    private long itemId;
    private int num;
    @SerializedName("pay_price")
    private int payPrice;
    @SerializedName("sku_id")
    private long skuId;
    private String title;

    public String getAlias() {
        return this.alias;
    }

    public long getItemId() {
        return this.itemId;
    }

    public int getNum() {
        return this.num;
    }

    public int getPayPrice() {
        return this.payPrice;
    }

    public long getSkuId() {
        return this.skuId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setItemId(long j) {
        this.itemId = j;
    }

    public void setNum(int i) {
        this.num = i;
    }

    public void setPayPrice(int i) {
        this.payPrice = i;
    }

    public void setSkuId(long j) {
        this.skuId = j;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "GoodsOfCartModel{itemId=" + this.itemId + ", skuId=" + this.skuId + ", alias='" + this.alias + "', title='" + this.title + "', num=" + this.num + ", payPrice=" + this.payPrice + '}';
    }
}
