package com.soft.blued.ui.msg.model;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/Photo.class */
public class Photo {
    private String picid;
    private String url;
    private String url_small;

    public String getPicid() {
        return this.picid;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUrl_small() {
        return this.url_small;
    }

    public void setPicid(String str) {
        this.picid = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setUrl_small(String str) {
        this.url_small = str;
    }

    public String toString() {
        return "Photo [picid=" + this.picid + ", url=" + this.url + ", url_small=" + this.url_small + "]";
    }
}
