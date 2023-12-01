package com.tencent.rtmp;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/TXPlayerAuthBuilder.class */
public class TXPlayerAuthBuilder {
    int appId;
    int exper = -1;
    String fileId;
    protected boolean isHttps;
    String sign;
    String timeout;
    String us;

    public int getAppId() {
        return this.appId;
    }

    public int getExper() {
        return this.exper;
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getSign() {
        return this.sign;
    }

    public String getTimeout() {
        return this.timeout;
    }

    public String getUs() {
        return this.us;
    }

    public boolean isHttps() {
        return this.isHttps;
    }

    public void setAppId(int i) {
        this.appId = i;
    }

    public void setExper(int i) {
        this.exper = i;
    }

    public void setFileId(String str) {
        this.fileId = str;
    }

    public void setHttps(boolean z) {
        this.isHttps = z;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public void setTimeout(String str) {
        this.timeout = str;
    }

    public void setUs(String str) {
        this.us = str;
    }
}
