package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/ZhiChiGroupBase.class */
public class ZhiChiGroupBase implements Serializable {
    private static final long serialVersionUID = 1;
    private String channelType;
    private String companyId;
    private String description;
    private String groupGuideDoc;
    private String groupId;
    private String groupName;
    private String groupPic;
    private int groupStyle;
    private String isOnline;
    private String recGroupName;

    public ZhiChiGroupBase() {
    }

    public ZhiChiGroupBase(String str, String str2) {
        this.groupName = str;
        this.isOnline = str2;
    }

    public String getChannelType() {
        return this.channelType;
    }

    public String getCompanyId() {
        return this.companyId;
    }

    public String getDescription() {
        return this.description;
    }

    public String getGroupGuideDoc() {
        return this.groupGuideDoc;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getGroupPic() {
        return this.groupPic;
    }

    public int getGroupStyle() {
        return this.groupStyle;
    }

    public String getRecGroupName() {
        return this.recGroupName;
    }

    public String isOnline() {
        return this.isOnline;
    }

    public void setChannelType(String str) {
        this.channelType = str;
    }

    public void setCompanyId(String str) {
        this.companyId = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setGroupGuideDoc(String str) {
        this.groupGuideDoc = str;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setGroupPic(String str) {
        this.groupPic = str;
    }

    public void setGroupStyle(int i) {
        this.groupStyle = i;
    }

    public void setIsOnline(String str) {
        this.isOnline = str;
    }

    public void setRecGroupName(String str) {
        this.recGroupName = str;
    }

    public String toString() {
        return "ZhiChiGroupBase{groupId='" + this.groupId + "', channelType='" + this.channelType + "', groupName='" + this.groupName + "', companyId='" + this.companyId + "', recGroupName='" + this.recGroupName + "', isOnline=" + this.isOnline + '}';
    }
}
