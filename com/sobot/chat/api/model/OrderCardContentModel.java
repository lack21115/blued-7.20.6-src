package com.sobot.chat.api.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/OrderCardContentModel.class */
public class OrderCardContentModel implements Serializable {
    private static final long serialVersionUID = 1;
    private String createTime;
    private List<Goods> goods;
    private String goodsCount;
    private boolean isAutoSend;
    private boolean isEveryTimeAutoSend;
    private String orderCode;
    private int orderStatus;
    private String orderUrl;
    private String statusCustom;
    private int totalFee;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/OrderCardContentModel$Goods.class */
    public static class Goods implements Serializable {
        private String name;
        private String pictureUrl;

        public Goods() {
        }

        public Goods(String str, String str2) {
            this.name = str;
            this.pictureUrl = str2;
        }

        public String getName() {
            return this.name;
        }

        public String getPictureUrl() {
            return this.pictureUrl;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPictureUrl(String str) {
            this.pictureUrl = str;
        }

        public String toString() {
            return "{name='" + this.name + "', pictureUrl='" + this.pictureUrl + "'}";
        }
    }

    public OrderCardContentModel() {
        this.isEveryTimeAutoSend = false;
    }

    public OrderCardContentModel(int i, String str, String str2, String str3, String str4, int i2, List<Goods> list, boolean z, boolean z2, String str5) {
        this.isEveryTimeAutoSend = false;
        this.orderStatus = i;
        this.orderCode = str;
        this.createTime = str2;
        this.orderUrl = str3;
        this.goodsCount = str4;
        this.totalFee = i2;
        this.goods = list;
        this.isAutoSend = z;
        this.isEveryTimeAutoSend = z2;
        this.statusCustom = str5;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public List<Goods> getGoods() {
        return this.goods;
    }

    public String getGoodsCount() {
        return this.goodsCount;
    }

    public String getOrderCode() {
        return this.orderCode;
    }

    public int getOrderStatus() {
        return this.orderStatus;
    }

    public String getOrderUrl() {
        return this.orderUrl;
    }

    public String getStatusCustom() {
        return this.statusCustom;
    }

    public int getTotalFee() {
        return this.totalFee;
    }

    public boolean isAutoSend() {
        return this.isAutoSend;
    }

    public boolean isEveryTimeAutoSend() {
        return this.isEveryTimeAutoSend;
    }

    public void setAutoSend(boolean z) {
        this.isAutoSend = z;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setEveryTimeAutoSend(boolean z) {
        this.isEveryTimeAutoSend = z;
    }

    public void setGoods(List<Goods> list) {
        this.goods = list;
    }

    public void setGoodsCount(String str) {
        this.goodsCount = str;
    }

    public void setOrderCode(String str) {
        this.orderCode = str;
    }

    public void setOrderStatus(int i) {
        this.orderStatus = i;
    }

    public void setOrderUrl(String str) {
        this.orderUrl = str;
    }

    public void setStatusCustom(String str) {
        this.statusCustom = str;
    }

    public void setTotalFee(int i) {
        this.totalFee = i;
    }

    public String toString() {
        return "OrderCardContentModel{orderStatus=" + this.orderStatus + ", orderCode='" + this.orderCode + "', createTime='" + this.createTime + "', orderUrl='" + this.orderUrl + "', goodsCount='" + this.goodsCount + "', totalFee=" + this.totalFee + ", goods=" + this.goods + ", isAutoSend=" + this.isAutoSend + ", isEveryTimeAutoSend=" + this.isEveryTimeAutoSend + ", statusCustom='" + this.statusCustom + "'}";
    }
}
