package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/StCategoryModel.class */
public class StCategoryModel implements Serializable {
    private String appId;
    private String categoryDetail;
    private String categoryId;
    private String categoryName;
    private String categoryUrl;
    private int sortNo;

    public String getAppId() {
        return this.appId;
    }

    public String getCategoryDetail() {
        return this.categoryDetail;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public String getCategoryUrl() {
        return this.categoryUrl;
    }

    public int getSortNo() {
        return this.sortNo;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setCategoryDetail(String str) {
        this.categoryDetail = str;
    }

    public void setCategoryId(String str) {
        this.categoryId = str;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public void setCategoryUrl(String str) {
        this.categoryUrl = str;
    }

    public void setSortNo(int i) {
        this.sortNo = i;
    }

    public String toString() {
        return "StCategoryModel{categoryId='" + this.categoryId + "', appId='" + this.appId + "', categoryName='" + this.categoryName + "', categoryDetail='" + this.categoryDetail + "', categoryUrl='" + this.categoryUrl + "', sortNo=" + this.sortNo + '}';
    }
}
