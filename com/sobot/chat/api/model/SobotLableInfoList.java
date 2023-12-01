package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotLableInfoList.class */
public class SobotLableInfoList implements Serializable {
    private String lableId;
    private String lableLink;
    private String lableName;

    public String getLableId() {
        return this.lableId;
    }

    public String getLableLink() {
        return this.lableLink;
    }

    public String getLableName() {
        return this.lableName;
    }

    public void setLableId(String str) {
        this.lableId = str;
    }

    public void setLableLink(String str) {
        this.lableLink = str;
    }

    public void setLableName(String str) {
        this.lableName = str;
    }

    public String toString() {
        return "SobotLableInfoList{lableId='" + this.lableId + "', lableName='" + this.lableName + "', lableLink='" + this.lableLink + "'}";
    }
}
