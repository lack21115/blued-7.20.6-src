package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotLocationModel.class */
public class SobotLocationModel implements Serializable {
    private String lat;
    private String lng;
    private String localLabel;
    private String localName;
    private String snapshot;

    public String getLat() {
        return this.lat;
    }

    public String getLng() {
        return this.lng;
    }

    public String getLocalLabel() {
        return this.localLabel;
    }

    public String getLocalName() {
        return this.localName;
    }

    public String getSnapshot() {
        return this.snapshot;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    public void setLng(String str) {
        this.lng = str;
    }

    public void setLocalLabel(String str) {
        this.localLabel = str;
    }

    public void setLocalName(String str) {
        this.localName = str;
    }

    public void setSnapshot(String str) {
        this.snapshot = str;
    }
}
