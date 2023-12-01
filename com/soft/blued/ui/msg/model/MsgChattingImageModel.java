package com.soft.blued.ui.msg.model;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/MsgChattingImageModel.class */
public class MsgChattingImageModel {
    public boolean identify_yellow;
    public boolean illegal;
    private String latitude;
    private String location;
    private String longitude;
    private MsgSourceEntity msgSource;
    private int pic_height;
    private int pic_width;

    public String getLatitude() {
        String str = this.latitude;
        return str != null ? str : "";
    }

    public String getLocation() {
        String str = this.location;
        return str != null ? str : "";
    }

    public String getLongitude() {
        String str = this.longitude;
        return str != null ? str : "";
    }

    public MsgSourceEntity getMsgSource() {
        return this.msgSource;
    }

    public int getPicHeight() {
        return this.pic_height;
    }

    public int getPicWidth() {
        return this.pic_width;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setMsgSource(MsgSourceEntity msgSourceEntity) {
        this.msgSource = msgSourceEntity;
    }

    public void setPicHeight(int i) {
        this.pic_height = i;
    }

    public void setPicWidth(int i) {
        this.pic_width = i;
    }
}
