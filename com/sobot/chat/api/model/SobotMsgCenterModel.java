package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotMsgCenterModel.class */
public class SobotMsgCenterModel implements Serializable {
    private static final long serialVersionUID = 3567312018034692181L;
    private String app_key;
    private String senderFace;
    private String senderName;
    private Information info = null;
    private String appkey = "";
    private String id = "";
    private String face = "";
    private String name = "";
    private String lastMsg = "";
    private String lastDate = "";
    private String lastDateTime = "";
    private int unreadCount = 0;

    public boolean equals(Object obj) {
        if (obj instanceof SobotMsgCenterModel) {
            return ((SobotMsgCenterModel) obj).getApp_key().equals(getApp_key());
        }
        return false;
    }

    public String getApp_key() {
        return this.app_key;
    }

    @Deprecated
    public String getAppkey() {
        return this.appkey;
    }

    public String getFace() {
        return this.face;
    }

    public String getId() {
        return this.id;
    }

    public Information getInfo() {
        return this.info;
    }

    public String getLastDate() {
        return this.lastDate;
    }

    public String getLastDateTime() {
        return this.lastDateTime;
    }

    public String getLastMsg() {
        return this.lastMsg;
    }

    public String getName() {
        return this.name;
    }

    public String getSenderFace() {
        return this.senderFace;
    }

    public String getSenderName() {
        return this.senderName;
    }

    public int getUnreadCount() {
        return this.unreadCount;
    }

    public void setApp_key(String str) {
        this.appkey = str;
        this.app_key = str;
    }

    @Deprecated
    public void setAppkey(String str) {
        this.appkey = str;
        this.app_key = str;
    }

    public void setFace(String str) {
        this.face = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setInfo(Information information) {
        this.info = information;
    }

    public void setLastDate(String str) {
        this.lastDate = str;
    }

    public void setLastDateTime(String str) {
        this.lastDateTime = str;
    }

    public void setLastMsg(String str) {
        this.lastMsg = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSenderFace(String str) {
        this.senderFace = str;
    }

    public void setSenderName(String str) {
        this.senderName = str;
    }

    public void setUnreadCount(int i) {
        this.unreadCount = i;
    }

    public String toString() {
        return "SobotMsgCenterModel{app_key='" + this.app_key + "', info=" + this.info + ", appkey='" + this.appkey + "', id='" + this.id + "', face='" + this.face + "', name='" + this.name + "', lastMsg='" + this.lastMsg + "', lastDate='" + this.lastDate + "', lastDateTime='" + this.lastDateTime + "', unreadCount=" + this.unreadCount + ", senderName='" + this.senderName + "', senderFace='" + this.senderFace + "'}";
    }
}
